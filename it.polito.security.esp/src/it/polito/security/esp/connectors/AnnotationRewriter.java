package it.polito.security.esp.connectors;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.ActionType;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartSet;
import it.polito.security.esp.kb.ApplicationPartType;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.CodeBlock;
import it.polito.security.esp.kb.ProtectionInstantiation;
import it.polito.security.esp.kb.Solution;
import it.polito.security.esp.kb.SolutionSequence;
import it.polito.security.esp.util.Strings;

/**
 * The legendary annotation rewriter.
 * @author Daniele Canavese
 **/
public class AnnotationRewriter
{
	/** The ESP. **/
	private ESP esp;

	/**
	 * Creates the rewriter.
	 * @param esp
	 *            The ESP.
	 **/
	public AnnotationRewriter(ESP esp)
	{
		this.esp = esp;
	}

	/**
	 * Deploys the patch file for splitting the source files into their code blocks.
	 * @throws IOException
	 *             If a source file cannot be read.
	 */
	public void deploySplittingPatch() throws IOException
	{
		StringBuilder sb = new StringBuilder();
		int count = 0;

		for (String i : getSourceFiles())
		{
			String[] content = esp.getRunner().readFile(i).split("\n");

			Path p = Paths.get(esp.getModel().getPreferences().getWorkingDirectory()).relativize(Paths.get(i));
			String fileName = p.toString();
			if (File.separator.equals("\\"))
				fileName = fileName.replaceAll("\\\\", esp.getModel().getPreferences().getRemoteFileSeparator());
			sb.append("--- " + fileName + "\n");
			sb.append("+++ " + fileName + ".esp\n");

			List<ApplicationPart> parts = new ArrayList<>();
			for (ApplicationPart j : esp.getModel().getApplicationParts())
				if (j.getSourceFilePath().equals(i) && j.getType() == ApplicationPartType.FUNCTION)
					parts.add(j);

			parts.sort(new Comparator<ApplicationPart>()
			{
				@Override
				public int compare(ApplicationPart o1, ApplicationPart o2)
				{
					return o1.getStartLine() - o2.getStartLine();
				}
			});

			Map<Integer, Hunk> hunks = new HashMap<>();

			for (ApplicationPart j : parts)
			{
				List<CodeBlock> blocks = new ArrayList<>();

				blocks.add(j.getBody());

				while (!blocks.isEmpty())
				{
					CodeBlock block = blocks.get(0);
					blocks.remove(0);
					int lines = block.getEndLine() - block.getStartLine() + 1;

					if (lines > 1)
					{
						Hunk hunk;
						if (!hunks.containsKey(block.getStartLine()))
						{
							hunk = new Hunk(block.getStartLine(), content[block.getStartLine() - 1] + "\n",
									content[block.getStartLine() - 1] + "\n");
							hunks.put(block.getStartLine(), hunk);
						}
						else
							hunk = hunks.get(block.getStartLine());
						hunk.setPatched("{\n" + "_Pragma(\"ASPIRE begin requirement(confidentiality, integrity)\")\n" + hunk.getPatched());

						if (!hunks.containsKey(block.getEndLine()))
						{
							hunk = new Hunk(block.getEndLine(), content[block.getEndLine() - 1] + "\n",
									content[block.getEndLine() - 1] + "\n");
							hunks.put(block.getEndLine(), hunk);
						}
						else
							hunk = hunks.get(block.getEndLine());
						hunk.setPatched(hunk.getPatched() + "_Pragma(\"ASPIRE end\")\n" + "}\n");
						++count;
					}
					blocks.addAll(block.getCodeBlocks());
				}
			}

			List<Integer> lines = new ArrayList<>();
			lines.addAll(hunks.keySet());
			lines.sort(null);

			for (Integer j : lines)
				sb.append(hunks.get(j));
		}

		esp.getRunner().createFile(
				esp.getModel().getPreferences().getWorkingDirectory() + esp.getRunner().getSeparator() + "splitting.patch",
				new ByteArrayInputStream(sb.toString().getBytes()));

		log.finer(count + " code regions found");
		log.fine("splitting.patch deployed");
	}

	/**
	 * Deploys the patch file content for preparing the source files.
	 * @param solution
	 *            The solution for deploying a full patch or <code>null</code> to deploy a partial one.
	 * @throws IOException
	 *             If a source file cannot be read.
	 */
	public void deployPatch(Solution solution) throws IOException
	{
		HashSet<Integer> deployedPartsId = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (String i : getSourceFiles())
		{
			List<ApplicationPart> parts = getPartsToUpdate(i);
			List<SimpleEntry<Integer, SimpleEntry<ApplicationPart, String>>> annotations = new LinkedList<>();
			if (!parts.isEmpty())
			{
				String[] content = esp.getRunner().readFile(i).split("\n");

				Path p = Paths.get(esp.getModel().getPreferences().getWorkingDirectory()).relativize(Paths.get(i));
				String fileName = p.toString();
				if (File.separator.equals("\\"))
					fileName = fileName.replaceAll("\\\\", esp.getModel().getPreferences().getRemoteFileSeparator());
				sb.append("--- " + fileName + "\n");
				sb.append("+++ " + fileName + ".esp\n");

				Collections.sort(parts, new Comparator<ApplicationPart>()
				{
					@Override
					public int compare(ApplicationPart o1, ApplicationPart o2)
					{
						return o1.getStartLine() - o2.getStartLine();
					}
				});

				for (ApplicationPart j : parts)
				{
					String startLine = content[j.getStartLine() - 1];
					String endLine = content[j.getEndLine() - 1];
					if (deployedPartsId.contains(j.getId()))
						continue;

					String annotation1 = "";
					String annotation2 = "";

					List<AppliedProtectionInstantiation> apis = getAPIs(solution, j);

					if (j.getType().equals(ApplicationPartType.ATTESTATOR))
					{
						if (solution == null)
							annotation1 += "+_Pragma(\"ASPIRE begin protection(placeHolder, id(" + j.getId()
									+ "))\")\n+_Pragma(\"ASPIRE end\")\n";
						else
						{
							List<String> protections = new ArrayList<>();
							for (AppliedProtectionInstantiation k : apis)
								if (k.getCodeAnnotation() == null || !k.getAttestatorAnnotation().isEmpty())
									protections.add("protection(" + k.getAttestatorAnnotation() + ")");
							if (!protections.isEmpty())
								annotation1 += "+_Pragma(\"ASPIRE begin " + Strings.join(protections, ", ")
										+ "\")\n+_Pragma(\"ASPIRE end\")\n";
							else
								annotation1 += "+_Pragma(\"ASPIRE begin protection(placeHolder, id(" + j.getId()
										+ "))\")\n+_Pragma(\"ASPIRE end\")\n";
						}
						// if(attestatorHostPart==null)
						// {
						// attestatorHostPart = j;
						// attestatorHostPartStartLine = startLine;
						// }
						// annotation1 = "\n"+"@@ -" + j.getStartLine() + ",1 +" + j.getStartLine() + "," + addedAttestatorLines + "@@\n" +
						// "-" + attestatorHostPartStartLine + "\n" +
						// attestatorLines +
						// "+" + attestatorHostPartStartLine + "\n";
					}
					else if (startLine.matches(".*requirement\\(.*?\\).*"))
					{
						if (j.getSecurityProperties().size() == 0)
							continue;

						// annotation1 += "@@ -" + j.getStartLine() + ",1 +" + j.getStartLine() + ",1 @@\n";
						// annotation1 += "-" + startLine + "\n";
						if (solution == null)
						{
							startLine = startLine.replaceFirst("(weight\\(.*?\\)\\s*,\\s*)?requirement\\(.*?\\)(\\s*,\\s*weight\\(.*?\\))?",
									"protection(placeHolder, id(" + j.getId() + "))");
							annotation1 += "+" + startLine + "\n";
						}
						else
						{
							List<String> protections = new ArrayList<>();
							for (AppliedProtectionInstantiation k : apis)
								if (k.getCodeAnnotation() == null || !k.getCodeAnnotation().isEmpty())
									protections.add("protection(" + k.getCodeAnnotation() + ")");
							if (!protections.isEmpty())
							{
								startLine = startLine.replaceFirst(
										"(weight\\(.*?\\)\\s*,\\s*)?requirement\\(.*?\\)(\\s*,\\s*weight\\(.*?\\))?",
										Strings.join(protections, ", "));
								annotation1 += "+" + startLine + "\n";
							}
							else
							{
								startLine = startLine.replaceFirst(
										"(weight\\(.*?\\)\\s*,\\s*)?requirement\\(.*?\\)(\\s*,\\s*weight\\(.*?\\))?",
										"protection(placeHolder, id(" + j.getId() + "))");
								annotation1 += "+" + startLine + "\n";
							}
						}
					}
					else if (j.isDatum())
					{
						Pattern pattern = Pattern.compile("(.*\\s+" + j.getName() + "\\s*(\\[.*\\])?)(.*)");
						Matcher matcher = pattern.matcher(startLine);
						if (matcher.matches())
						{
							// annotation1 += "@@ -" + j.getStartLine() + ",1 +" + j.getStartLine() + ",1 @@\n";
							// annotation1 += "-" + startLine + "\n";
							startLine = matcher.group(1) + " __attribute__((ASPIRE(\"protection(placeHolder, id(" + j.getId() + "))\")))"
									+ matcher.group(3);
							annotation1 += "+" + startLine + "\n";
						}
					}
					else if (j.isCode())
					{
						// if(j.getStartLine()==j.getEndLine())
						// {
						// annotation1 += "@@ -" + j.getStartLine() + ",1 +" + j.getStartLine() + ",3 @@\n";
						// annotation1 += "-" + startLine + "\n";
						// startLine = "_Pragma(\"ASPIRE begin protection(placeHolder, id(" + j.getId() + "))\")\n+" + startLine;
						// annotation1 += "+" + startLine + "\n";
						// annotation1 += "+_Pragma(\"ASPIRE end\")" + "\n";
						// }
						// else
						// {
						// annotation1 += "@@ -" + j.getStartLine() + ",1 +" + j.getStartLine() + ",2 @@\n";
						// annotation1 += "-" + startLine + "\n";
						if (solution == null)
						{
							startLine = "_Pragma(\"ASPIRE begin protection(placeHolder, id(" + j.getId() + "))\")\n+" + startLine;
							annotation1 += "+" + startLine + "\n";
						}
						else
						{
							List<String> protections = new ArrayList<>();
							for (AppliedProtectionInstantiation k : apis)
								if (k.getCodeAnnotation() == null || !k.getCodeAnnotation().isEmpty())
									protections.add("protection(" + k.getCodeAnnotation() + ")");

							if (!protections.isEmpty())
							{
								startLine = startLine.replaceFirst(
										"(weight\\(.*?\\)\\s*,\\s*)?requirement\\(.*?\\)(\\s*,\\s*weight\\(.*?\\))?",
										Strings.join(protections, ", "));
								annotation1 += "+" + startLine + "\n";
							}
							else
							{
								startLine = startLine.replaceFirst(
										"(weight\\(.*?\\)\\s*,\\s*)?requirement\\(.*?\\)(\\s*,\\s*weight\\(.*?\\))?",
										"protection(placeHolder, id(" + j.getId() + "))");
								annotation1 += "+" + startLine + "\n";
							}
						}

						// annotation2 += "@@ -" + j.getEndLine() + ",1 +" + j.getEndLine() + ",2 @@\n";
						// annotation2 += "-" + endLine + "\n";

						if (j.getStartLine() == j.getEndLine())
							annotation1 += "+_Pragma(\"ASPIRE end\")" + "\n";
						else
						{
							endLine = endLine + "\n+_Pragma(\"ASPIRE end\")";
							annotation2 += "+" + endLine + "\n";
						}
						// }
					}

					if (!annotation1.isEmpty())
					{
						SimpleEntry<ApplicationPart, String> innerEntry = new SimpleEntry<ApplicationPart, String>(j, annotation1);
						SimpleEntry<Integer, SimpleEntry<ApplicationPart, String>> outerEntry = new SimpleEntry<Integer, AbstractMap.SimpleEntry<ApplicationPart, String>>(
								j.getStartLine(), innerEntry);
						annotations.add(outerEntry);
					}

					if (!annotation2.isEmpty())
					{
						SimpleEntry<ApplicationPart, String> innerEntry = new SimpleEntry<ApplicationPart, String>(j, annotation2);
						SimpleEntry<Integer, SimpleEntry<ApplicationPart, String>> outerEntry = new SimpleEntry<Integer, AbstractMap.SimpleEntry<ApplicationPart, String>>(
								j.getEndLine(), innerEntry);
						annotations.add(outerEntry);
					}

					deployedPartsId.add(j.getId());
				}

				Comparator<SimpleEntry<Integer, SimpleEntry<ApplicationPart, String>>> comparator = new Comparator<AbstractMap.SimpleEntry<Integer, SimpleEntry<ApplicationPart, String>>>()
				{

					@Override
					public int compare(SimpleEntry<Integer, SimpleEntry<ApplicationPart, String>> o1,
							SimpleEntry<Integer, SimpleEntry<ApplicationPart, String>> o2)
					{
						if (o1.getKey() == o2.getKey())
						{
							// Here two annotations relative to the same row are compared.
							ApplicationPart part1 = o1.getValue().getKey();
							ApplicationPart part2 = o2.getValue().getKey();

							if (part1.contains(part2))
								return -1;
							else if (part2.contains(part1))
								return 1;
							else if (part1.equals(part2))
								return 0;
							else
								return 0; // Really improbable case
						}
						else
							return o1.getKey() - o2.getKey();
					}
				};
				annotations.sort(comparator);

				int row = 0;
				String temp = "";
				boolean attestator = false;
				for (int n = 0; n < annotations.size(); n++)
				{
					SimpleEntry<Integer, SimpleEntry<ApplicationPart, String>> annotation = annotations.get(n);
					ApplicationPart part = annotation.getValue().getKey();
					ApplicationPart previousPart = null;
					if (n > 0)
						previousPart = annotations.get(n - 1).getValue().getKey();

					if (row == 0)
						row = annotation.getKey();

					if (row == annotation.getKey())
						temp += annotation.getValue().getValue();

					if (row != annotation.getKey() || n == annotations.size() - 1)
					{
						if (annotations.size() != 1)
						{
							if (previousPart.getType().equals(ApplicationPartType.ATTESTATOR))
								attestator = true;

							int addedRows = 0;
							for (char c : temp.toCharArray())
								if (c == '\n')
									addedRows++;

							String functionContent = "";
							boolean emptyFunction = false;
							if (previousPart != null)
							{
								ApplicationPart function = previousPart;
								while (function != null && function.getType() != ApplicationPartType.FUNCTION)
									function = function.getDeclaringCode();

								if (function != null)
								{
									for (int j = function.getStartLine() - 1; j < function.getEndLine(); j++)
										functionContent += content[j];

									String bodyContent = functionContent.substring(functionContent.indexOf('{') + 1,
											functionContent.lastIndexOf('}'));
									if (bodyContent.replaceAll(" ", "").replaceAll("/n", "").isEmpty())
										emptyFunction = true;
								}
							}

							if (emptyFunction)
							{
								int functionLength = previousPart.getDeclaringCode().getEndLine()
										- previousPart.getDeclaringCode().getStartLine() + 1;
								sb.append("@@ -" + row + "," + functionLength + " +" + row + "," + (addedRows + 3) + " @@\n");
								for (int j = previousPart.getDeclaringCode().getStartLine() - 1; j < previousPart.getDeclaringCode()
										.getEndLine(); j++)
									sb.append("-" + content[j] + "\n");
								if (content[previousPart.getDeclaringCode().getStartLine() - 1].indexOf('{') != -1)
									sb.append("+" + content[previousPart.getDeclaringCode().getStartLine() - 1].substring(0,
											content[previousPart.getDeclaringCode().getStartLine() - 1].indexOf('{')) + "\n");
								else
									sb.append("+" + content[previousPart.getDeclaringCode().getStartLine() - 1] + "\n");
								sb.append("+" + '{' + "\n");
								sb.append(temp);
								sb.append("+" + '}' + "\n");
							}
							else
							{
								if (attestator)
								{
									temp += "+" + content[row - 1] + "\n";
									++addedRows;
								}
								sb.append("@@ -" + row + ",1 +" + row + "," + addedRows + " @@\n");
								sb.append("-" + content[row - 1] + "\n");
								sb.append(temp);
							}

							temp = annotation.getValue().getValue();
							attestator = false;
							addedRows = 0;
						}

						if (n == annotations.size() - 1)
						{
							row = annotation.getKey();

							if (part.getType().equals(ApplicationPartType.ATTESTATOR))
								attestator = true;

							int addedRows = 0;
							for (char c : temp.toCharArray())
								if (c == '\n')
									addedRows++;

							String functionContent = "";
							boolean emptyFunction = false;
							if (part != null)
							{
								ApplicationPart function = part;
								while (function != null && function.getType() != ApplicationPartType.FUNCTION)
									function = function.getDeclaringCode();

								if (function != null)
								{
									for (int j = function.getStartLine() - 1; j < function.getEndLine(); j++)
										functionContent += content[j];

									String bodyContent = functionContent.substring(functionContent.indexOf('{') + 1,
											functionContent.lastIndexOf('}'));
									if (bodyContent.replaceAll(" ", "").replaceAll("/n", "").isEmpty())
										emptyFunction = true;
								}
							}

							if (emptyFunction)
							{
								int functionLength = part.getDeclaringCode().getEndLine() - part.getDeclaringCode().getStartLine() + 1;
								sb.append("@@ -" + row + "," + functionLength + " +" + row + "," + (addedRows + 3) + " @@\n");
								for (int j = part.getDeclaringCode().getStartLine() - 1; j < part.getDeclaringCode().getEndLine(); j++)
									sb.append("-" + content[j] + "\n");
								if (content[part.getDeclaringCode().getStartLine() - 1].indexOf('{') != -1)
									sb.append("+" + content[part.getDeclaringCode().getStartLine() - 1].substring(0,
											content[part.getDeclaringCode().getStartLine() - 1].indexOf('{')) + "\n");
								else
									sb.append("+" + content[part.getDeclaringCode().getStartLine() - 1] + "\n");
								sb.append("+" + '{' + "\n");
								sb.append(temp);
								sb.append("+" + '}' + "\n");
							}
							else
							{
								if (attestator)
								{
									temp += "+" + content[row - 1] + "\n";
									++addedRows;
								}
								sb.append("@@ -" + row + ",1 +" + row + "," + addedRows + " @@\n");
								sb.append("-" + content[row - 1] + "\n");
								sb.append(temp);
							}
						}
						row = annotation.getKey();

					}
				}
			}
		}

		esp.getRunner().createFile(esp.getModel().getPreferences().getWorkingDirectory() + esp.getRunner().getSeparator()
				+ esp.getModel().getPreferences().getEspPatchFile(), new ByteArrayInputStream(sb.toString().getBytes()));

		log.fine(esp.getModel().getPreferences().getEspPatchFile() + " deployed");
	}

	/**
	 * Retrieves the list of applied PIs for an application part in a solution.
	 * @param solution
	 *            The solution.
	 * @param part
	 *            The application part.
	 * @return The list of applied PIs.
	 */
	private List<AppliedProtectionInstantiation> getAPIs(Solution solution, ApplicationPart part)
	{
		List<AppliedProtectionInstantiation> list = new ArrayList<>();

		for (SolutionSequence i : solution.getSolutionSequences())
			for (AppliedProtectionInstantiation j : i.getAppliedProtectionInstantiations())
				if (j.getApplicationPart() == part)
					list.add(j);

		return list;
	}

	/**
	 * Deploys the JSON file content for rewriting the source files.
	 * @param solution
	 *            The solution to use or <code>null</code> to deploy a partial json.
	 * @throws IOException
	 *             If a source file cannot be read.
	 */
	public void deployJSON(Solution solution) throws IOException
	{
		StringBuilder sb = new StringBuilder();

		sb.append("[\n");
		if (solution != null)
		{
			HashSet<ApplicationPart> deployedAttestators = new HashSet<>();

			List<AppliedProtectionInstantiation> appliedProtectionInstantiations = new ArrayList<>();

			for (SolutionSequence i : solution.getSolutionSequences())
				appliedProtectionInstantiations.addAll(i.getAppliedProtectionInstantiations());

			final Map<ApplicationPart, List<AppliedProtectionInstantiation>> map = new HashMap<>();
			List<ApplicationPart> parts = new ArrayList<>();
			for (AppliedProtectionInstantiation i : appliedProtectionInstantiations)
			{
				List<AppliedProtectionInstantiation> protectionInstantiations;
				Collection<ApplicationPart> set = new HashSet<>();
				set.add(i.getApplicationPart());
				for (ApplicationPartSet j : i.getApplicationPart().getSets())
					if (i.getProtectionInstantiation().getProtection().getActions().contains(j.getAction()))
						set.addAll(j.getApplicationParts());
				for (ApplicationPart k : set)
				{
					if (map.containsKey(k))
						protectionInstantiations = map.get(k);
					else
					{
						protectionInstantiations = new ArrayList<>();
						map.put(k, protectionInstantiations);
					}

					protectionInstantiations.add(i);
					if (!parts.contains(k))
						parts.add(k);
				}
			}

			Collections.sort(parts, new Comparator<ApplicationPart>()
			{
				@Override
				public int compare(ApplicationPart o1, ApplicationPart o2)
				{
					if (!o1.getSourceFilePath().equals(o2.getSourceFilePath()))
						return o1.getSourceFilePath().compareTo(o2.getSourceFilePath());
					else
						return map.get(o1).hashCode() - map.get(o2).hashCode();
				}
			});

			boolean first = true;
			for (ApplicationPart i : parts)
			{
				List<AppliedProtectionInstantiation> protectionInstantiations = map.get(i);

				List<String> annotationContent = new ArrayList<>();
				for (AppliedProtectionInstantiation j : protectionInstantiations)
				{
					String expandedContent = expand(i, j, deployedAttestators);
					if (!expandedContent.isEmpty())
						annotationContent.add("protection(" + expandedContent + ")");
				}
				if (annotationContent.isEmpty())
					continue;

				if (first)
					first = false;
				else
					sb.append(",\n");
				sb.append("\t{\n");
				String path = i.getSourceFilePath();
				path = path.substring(path.lastIndexOf(esp.getRunner().getSeparator()) + 1);
				sb.append("\t\t\"file name\": \"" + path + "\",\n");
				sb.append("\t\t\"id\": \"" + i.getId() + "\",\n");
				sb.append("\t\t\"annotation content\": \"" + Strings.join(annotationContent, ", ") + "\"\n");
				sb.append("\t}");
			}
		}

		sb.append("\n]\n");

		esp.getRunner().createFile(esp.getModel().getPreferences().getWorkingDirectory() + esp.getRunner().getSeparator()
				+ esp.getModel().getPreferences().getEspJSONFile(), new ByteArrayInputStream(sb.toString().getBytes()));

		log.fine(esp.getModel().getPreferences().getEspJSONFile() + " deployed");
	}

	/**
	 * Expands all the keywords in an annotation.
	 * @param applicationPart
	 *            The related application part.
	 * @param appliedProtectionInstantiation
	 *            The applied protection instantiation to use.
	 * @param deployedAttestators
	 * @return The annotation with all the expanded keywords.
	 **/
	private String expand(ApplicationPart applicationPart, AppliedProtectionInstantiation appliedProtectionInstantiation,
			HashSet<ApplicationPart> deployedAttestators)
	{
		String expansion = "";

		ProtectionInstantiation protectionInstantiation = appliedProtectionInstantiation.getProtectionInstantiation();

		if (applicationPart.isCode())
		{
			if (appliedProtectionInstantiation.getCodeAnnotation() != null)
				expansion = appliedProtectionInstantiation.getCodeAnnotation();
			else
				expansion = protectionInstantiation.getCodeAnnotation();
		}
		else if (applicationPart.isDatum())
		{
			if (appliedProtectionInstantiation.getVariableAnnotation() != null)
				expansion = appliedProtectionInstantiation.getVariableAnnotation();
			else
				expansion = protectionInstantiation.getVariableAnnotation();
		}

		if (applicationPart.getType() == ApplicationPartType.CRYPTOGRAPHIC_KEY)
			expansion = expansion.replaceAll("#role#", "key");
		else if (applicationPart.getType() == ApplicationPartType.INITIALIZATION_VECTOR)
			expansion = expansion.replaceAll("#role#", "iv");
		else if (applicationPart.getType() == ApplicationPartType.PLAINTEXT)
		{
			for (ApplicationPartSet i : applicationPart.getSets())
				if (i.getAction() == ActionType.ENCRYPT_AES128_CBC || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
					expansion = expansion.replaceAll("#role#", "input");
				else if (i.getAction() == ActionType.DECRYPT_AES128_CBC || i.getAction() == ActionType.DECRYPT_AES128_ECB)
					expansion = expansion.replaceAll("#role#", "output");
		}
		else if (applicationPart.getType() == ApplicationPartType.CIPHERTEXT)
		{
			for (ApplicationPartSet i : applicationPart.getSets())
				if (i.getAction() == ActionType.ENCRYPT_AES128_CBC || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
					expansion = expansion.replaceAll("#role#", "output");
				else if (i.getAction() == ActionType.DECRYPT_AES128_CBC || i.getAction() == ActionType.DECRYPT_AES128_ECB)
					expansion = expansion.replaceAll("#role#", "input");
		}

		if (applicationPart.isDatum())
		{
			int size = applicationPart.getDatumSize();
			if (applicationPart.getType() == ApplicationPartType.CRYPTOGRAPHIC_KEY)
			{
				for (ApplicationPartSet i : applicationPart.getSets())
					if (i.getAction() == ActionType.DECRYPT_AES128_CBC || i.getAction() == ActionType.DECRYPT_AES128_ECB
							|| i.getAction() == ActionType.ENCRYPT_AES128_CBC || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
						size = 16;
			}
			else if (applicationPart.getType() == ApplicationPartType.INITIALIZATION_VECTOR)
			{
				for (ApplicationPartSet i : applicationPart.getSets())
					if (i.getAction() == ActionType.DECRYPT_AES128_CBC || i.getAction() == ActionType.DECRYPT_AES128_ECB
							|| i.getAction() == ActionType.ENCRYPT_AES128_CBC || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
						size = 16;
			}
			else if (applicationPart.getType() == ApplicationPartType.PLAINTEXT
					|| applicationPart.getType() == ApplicationPartType.CIPHERTEXT)
			{
				for (ApplicationPartSet i : applicationPart.getSets())
					if (i.getAction() == ActionType.DECRYPT_AES128_ECB || i.getAction() == ActionType.ENCRYPT_AES128_ECB)
						size = 16;
			}
			expansion = expansion.replaceAll("#size#", String.valueOf(size));
		}

		if (!applicationPart.getSets().isEmpty())
			expansion = expansion.replaceAll("#label#", "set" + applicationPart.getSets().get(0).hashCode());

		if (applicationPart.isCode())
		{
			for (ApplicationPartSet i : applicationPart.getSets())
				if (i.getAction() == ActionType.DECRYPT_AES128_CBC)
				{
					expansion = expansion.replaceAll("#algorithm#", "AES");
					expansion = expansion.replaceAll("#mode#", "CBC");
					expansion = expansion.replaceAll("#operation#", "decrypt");
				}
				else if (i.getAction() == ActionType.DECRYPT_AES128_ECB)
				{
					expansion = expansion.replaceAll("#algorithm#", "AES");
					expansion = expansion.replaceAll("#mode#", "ECB");
					expansion = expansion.replaceAll("#operation#", "decrypt");
				}
				else if (i.getAction() == ActionType.ENCRYPT_AES128_CBC)
				{
					expansion = expansion.replaceAll("#algorithm#", "AES");
					expansion = expansion.replaceAll("#mode#", "CBC");
					expansion = expansion.replaceAll("#operation#", "encrypt");
				}
				else if (i.getAction() == ActionType.ENCRYPT_AES128_ECB)
				{
					expansion = expansion.replaceAll("#algorithm#", "AES");
					expansion = expansion.replaceAll("#mode#", "ECB");
					expansion = expansion.replaceAll("#operation#", "encrypt");
				}
		}

		if (applicationPart.getType() == ApplicationPartType.ATTESTATOR && !deployedAttestators.contains(applicationPart))
		{
			// String attestatorLabel = appliedProtectionInstantiation.getAttestatorAnnotation();
			String label = appliedProtectionInstantiation.getAttestatorAnnotation();
			label = label.substring(label.indexOf("label") + 6, label.indexOf(")", label.indexOf("label")));
			if (applicationPart.getName().equals(label))
			{
				expansion = appliedProtectionInstantiation.getAttestatorAnnotation();
				deployedAttestators.add(applicationPart);
			}
		}

		return expansion;
	}

	// private int[] primeNumbers = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
	// 103,
	// 107, 109, 113, 127, 131, 137, 139, 149 };
	//
	// /**
	// * Returns from the passed applied protection instantiation the annotations with evaluated annotation variables.
	// * @param pi
	// * The applied protection instantiation containing the annotations that must be evaluated.
	// * @return A list of entries, where the key is the type of annotation, and the value is the annotation with the variables evaluated.
	// */
	// List<SimpleEntry<String, String>> getRealAnnotations(ProtectionInstantiation pi, ApplicationPart part)
	// {
	// switch (pi.getProtection().getName())
	// {
	// case "dataObfuscation":
	// return getRealAnnotationsDataObfuscation(pi, part);
	// // case "antiDebugging" :
	// // case "binaryCodeControlFlowObfuscation" :
	// // case "callStackChecks" :
	// // case "softVM" :
	// }
	// return new LinkedList<SimpleEntry<String, String>>();
	// }
	//
	// public String getOverheadDiabloMetrics(ProtectionInstantiation pi, ApplicationPart part, Solution solution)
	// {
	// // String[] instVars = pi.getClientMemoryOverhead().split("#", -1);
	// String[] instVars = "1 + (10 * max(0, (#nr_bbls_dynamic_size# / #nr_bbls_static_size# - 10)/100) * #nr_bbls_dynamic_size#) /
	// #nr_ins_dynamic_size# "
	// .split("#", -1);
	// int i = 1;
	// // if the string starts with a #var#, then the vars are at even indexes of instVars, otherwise are odd indexes
	// // if(pi.getClientMemoryOverhead().indexOf('#')==0) i=0;
	// for (; i < instVars.length; i += 2)
	// {
	// String metricToFound = instVars[i];
	// if (instVars[i].equals("nr_bbls_dynamic_size"))
	// metricToFound = "nr_ins_dynamic";
	// else if (instVars[i].equals("nr_bbls_static_size"))
	// metricToFound = "nr_ins_static";
	// for (ApplicationPartMetricSet apms : solution.getApplicationPartMetricSets())
	// {
	// if (apms.getApplicationPart() != part)
	// continue;
	// for (Metric metric : apms.getMetrics())
	// {
	// if (!metric.getName().equals(metricToFound))
	// continue;
	// if (instVars[i].equals("nr_bbls_dynamic_size") || instVars[i].equals("nr_bbls_static_size"))
	// instVars[i] = ((Double) (metric.getValue() / 8.0)).toString();
	// else
	// instVars[i] = metric.getValue().toString();
	// break;
	// }
	// break;
	// }
	// }
	// String acc = "";
	// for (String instVar : instVars)
	// acc += instVar;
	// try
	// {
	// final Evaluator evaluator = new Evaluator();
	// final String expression = "1 + (10 * max(-1000, (3 / 1.0 - 10)/100) * 2) / 1.0 ";
	// return evaluator.evaluate(expression).toString();
	// }
	// catch (EvaluationException e)
	// {
	// return e.getMessage();
	// }
	// }
	//
	// List<SimpleEntry<String, String>> getRealAnnotationsDataObfuscation(ProtectionInstantiation pi, ApplicationPart variable)
	// {
	// String[] instVars = pi.getVariableAnnotation().split("#", -1);
	// int i = 1;
	// // if the string starts with a #var#, then the vars are at even indexes of instVars, otherwise are odd indexes
	// if (pi.getVariableAnnotation().indexOf('#') == 0)
	// i = 0;
	// String[] randomPair = { "", "" };
	// String[] minMaxPair = { "", "" };
	// for (; i < instVars.length; i += 2)
	// {
	// switch (instVars[i])
	// {
	// case "random":
	// {
	// Random random = new Random();
	// instVars[i] = String.valueOf(Math.pow(2, (random.nextInt(8 * variable.getDatumSize()))) - 1);
	// break;
	// }
	// case "vars":
	// instVars[i] = "4";
	// break;
	// case "nbits":
	// instVars[i] = String.valueOf(8 * variable.getDatumSize());
	// break;
	// case "random_1":
	// if (randomPair[0].isEmpty())
	// randomPair = generateCoupleOfRandomNumbers(variable);
	// instVars[i] = randomPair[0];
	// randomPair[0] = "";
	// break;
	// case "random_2":
	// if (randomPair[1].isEmpty())
	// randomPair = generateCoupleOfRandomNumbers(variable);
	// instVars[i] = randomPair[1];
	// randomPair[1] = "";
	// break;
	// case "min":
	// if (minMaxPair[0].isEmpty())
	// minMaxPair = generateMinMax(variable);
	// instVars[i] = minMaxPair[0];
	// minMaxPair[0] = "";
	// break;
	// case "max":
	// if (minMaxPair[1].isEmpty())
	// minMaxPair = generateMinMax(variable);
	// instVars[i] = minMaxPair[1];
	// minMaxPair[1] = "";
	// break;
	// }
	// }
	// String acc = "";
	// for (String instVar : instVars)
	// acc += instVar;
	// List<SimpleEntry<String, String>> retValue = new LinkedList<SimpleEntry<String, String>>();
	// retValue.add(0, new SimpleEntry<String, String>("variableAnnotation", acc));
	// return retValue;
	// }
	//
	// private String[] generateMinMax(ApplicationPart variable)
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// String[] generateCoupleOfRandomNumbers(ApplicationPart variable)
	// {
	// Random random = new Random();
	// Long range = (long) (Math.pow(2, (8 * variable.getDatumSize())) - 1);
	// Long mult = (long) 1;
	// Long var1 = (long) 1;
	// Long var2 = (long) 1;
	// Set<Long> var1primes = new HashSet<>();
	// Set<Long> var2primes = new HashSet<>();
	// while (true)
	// {
	// /*
	// * TODO: maybe create an hardcoded set of prime numbers less than range generate and cache prime numbers until the half of the
	// * variable range, starting from already generate numbers
	// */
	// Long randomPrime = (long) primeNumbers[random.nextInt(34)];
	// // stop if the multiplication random1*random2 would be higher than the variable range, or globally with a 10% of probability
	// if (mult * randomPrime >= range || random.nextInt(10) == 1)
	// break;
	// if (var1primes.contains(randomPrime))
	// var2primes.add(randomPrime);
	// else if (var2primes.contains(randomPrime))
	// var1primes.add(randomPrime);
	// else if (random.nextBoolean())
	// var1primes.add(randomPrime);
	// else
	// var2primes.add(randomPrime);
	// mult = mult * randomPrime;
	// }
	// for (Long var1prime : var1primes)
	// var1 = var1 * var1prime;
	// for (Long var2prime : var1primes)
	// var2 = var2 * var2prime;
	// String[] retValue = new String[2];
	// retValue[0] = var1.toString();
	// retValue[1] = var2.toString();
	// return retValue;
	// }
	//
	/**
	 * Retrieves all the parts to update in a source file.
	 * @param file
	 *            The source file.
	 * @return The list of the parts to update in a file.
	 */
	private List<ApplicationPart> getPartsToUpdate(String file)
	{
		List<ApplicationPart> parts;
		parts = getPartsToUpdate();

		Iterator<ApplicationPart> i = parts.iterator();
		while (i.hasNext())
		{
			ApplicationPart part = i.next();
			if (!part.getSourceFilePath().equals(file))
				i.remove();
		}

		return parts;
	}

	/**
	 * Retrieves all the parts to update.
	 * @return The list of the parts to update in a file.
	 */
	private List<ApplicationPart> getPartsToUpdate()
	{
		List<ApplicationPart> parts = new ArrayList<>();
		for (ApplicationPart i : esp.getModel().getAllApplicationParts())
			if (i.isAsset() || i.getType() == ApplicationPartType.CODE_REGION)
				parts.add(i);
		for (ApplicationPart i : esp.getModel().getAssets())
			for (ApplicationPartSet j : i.getSets())
				parts.addAll(j.getApplicationParts());
		return parts;
	}

	/**
	 * Retrieves all the source files.
	 * @return The list of source files.
	 */
	private Collection<String> getSourceFiles()
	{
		HashSet<String> files = new HashSet<>();

		for (ApplicationPart i : esp.getModel().getApplicationParts())
			if (!i.getSourceFilePath().isEmpty())
				files.add(i.getSourceFilePath());

		return files;
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(AnnotationRewriter.class.getName());
}

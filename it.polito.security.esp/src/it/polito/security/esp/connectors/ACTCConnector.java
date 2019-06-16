package it.polito.security.esp.connectors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import com.google.gson.Gson;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.Activator;
import it.polito.security.esp.kb.KbFactory;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartMetricSet;
import it.polito.security.esp.kb.ApplicationPartType;
import it.polito.security.esp.kb.Metric;
import it.polito.security.esp.kb.Preferences;
import it.polito.security.esp.kb.Protection;
import it.polito.security.esp.kb.ProtectionInstantiation;
import it.polito.security.esp.kb.Solution;
import it.polito.security.esp.kb.protectioninstantiation.ProtectionInstantiationsList;
import it.polito.security.esp.util.Eclipse;

/**
 * Manages the communications between the ACTC and the ESP.
 * @author Daniele Canavese
 **/
public class ACTCConnector
{
	/** The ESP. **/
	private ESP esp;

	/**
	 * Creates the connector.
	 * @param esp
	 *            The ESP.
	 **/
	public ACTCConnector(ESP esp)
	{
		this.esp = esp;
	}

	/**
	 * Builds the project with the ACTC. This is the first method to call.
	 * @param logFileName
	 *            The log file name where to put the logs or <code>null</code> if no log file should be created.
	 * @throws IOException
	 *             If the command cannot be executed.
	 * @throws CoreException
	 *             If the log file cannot be created.
	 **/
	public void build(String logFileName) throws IOException, CoreException
	{
		Preferences preferences = esp.getModel().getPreferences();
		String dockerRoot = preferences.getCommandACTC().split(" ")[2].replace("~",System.getProperty("user.home")).substring(0, preferences.getCommandACTC().split(" ")[2].replace("~",System.getProperty("user.home")).lastIndexOf(File.separatorChar));
		//docker-compose up -d
		StringBuilder upCommandSB = new StringBuilder();
		List<String> upCommand = new ArrayList<>();
		upCommand.add("cd");
		upCommand.add(dockerRoot);
		upCommand.add("&&");
		upCommand.add(preferences.getCommandACTC().split(" ")[0]);
		upCommand.add("up");
		upCommand.add("-d");
		if(esp.getRunner().run(upCommand,upCommandSB)!=0)		
			throw new IOException("Cannot start ACTC Docker: "+upCommandSB);
				
		//ACTC Clean
		log.info("ACTC build started");
		long start = System.currentTimeMillis();
		List<String> command = new ArrayList<>();
		command.add("cd");
		command.add(preferences.getWorkingDirectory());
		command.add("&&");
		for(String s: preferences.getCommandACTC().split(" "))
		{
			if(s.startsWith("~"))
				command.add(s.replace("~",System.getProperty("user.home")));
			else
				command.add(s);
		}
		command.add("-d");
		command.add("-v");
		command.add("-f");
		command.add(preferences.getActcConfigurationFile().replace(dockerRoot, ""));
		StringBuilder sb = new StringBuilder();
		int exitValue = esp.getRunner().run(command, sb);
		if (logFileName != null)
			Eclipse.createFile(esp.getKBFile().getParent(), logFileName, sb.toString());
		long stop = System.currentTimeMillis();
		if (exitValue != 0)
		{
			log.info("ACTC building error");
			throw new IOException(String.format("Build error = %.3f s", (stop - start) / 1000.0));
		}
		else
			log.info(String.format("Build completed = %.3f s", (stop - start) / 1000.0));
	}

	/**
	 * Retrieves the list of the annotated files.
	 * @return The list of the annotated files.
	 * @throws IOException
	 *             If the command cannot be executed.
	 **/
	public Collection<String> getAnnotatedFiles() throws IOException
	{
		Collection<String> files = new HashSet<>();

		Preferences preferences = esp.getModel().getPreferences();
		String content = esp.getRunner()
				.readFile(preferences.getWorkingDirectory() + esp.getRunner().getSeparator() + "build" + esp.getRunner().getSeparator()
						+ getName() + esp.getRunner().getSeparator() + "D01" + esp.getRunner().getSeparator() + "annotations.json");

		Gson gson = new Gson();
		for (Object i : gson.fromJson(content, ArrayList.class))
			if (i instanceof Map)
			{
				Map<?, ?> map = (Map<?, ?>) i;
				Object file = map.get("file name");
				if (file != null)
					files.add(file.toString());
			}

		return files;
	}

	/**
	 * Cleans the project with the ACTC.
	 * @throws IOException
	 *             If the command cannot be executed.
	 **/
	public void clean() throws IOException
	{
		Preferences preferences = esp.getModel().getPreferences();
		String dockerRoot = preferences.getCommandACTC().split(" ")[2].replace("~",System.getProperty("user.home")).substring(0, preferences.getCommandACTC().split(" ")[2].replace("~",System.getProperty("user.home")).lastIndexOf(File.separatorChar));
		
		//docker-compose up -d
		StringBuilder upCommandSB = new StringBuilder();
		List<String> upCommand = new ArrayList<>();
		upCommand.add("cd");
		upCommand.add(dockerRoot);
		upCommand.add("&&");
		upCommand.add(preferences.getCommandACTC().split(" ")[0]);
		upCommand.add("up");
		upCommand.add("-d");
		if(esp.getRunner().run(upCommand,upCommandSB)!=0)		
			throw new IOException("Cannot start ACTC Docker: "+upCommandSB);
				
		//ACTC Clean
		List<String> command = new ArrayList<>();
		command.add("cd");
		command.add(preferences.getWorkingDirectory());
		command.add("&&");
		for(String s: preferences.getCommandACTC().split(" "))
		{
			if(s.startsWith("~"))
				command.add(s.replace("~",System.getProperty("user.home")));
			else
				command.add(s);
		}
		command.add("clean");
		command.add("-f");
		command.add(preferences.getActcConfigurationFile().replace(dockerRoot, ""));
		StringBuilder sb = new StringBuilder();
		int status = esp.getRunner().run(command,sb);
		System.out.println(sb);
		esp.getRunner().deleteDirectory(preferences.getWorkingDirectory() + esp.getRunner().getSeparator() + "build");
		esp.getRunner().deleteFile(preferences.getWorkingDirectory() + esp.getRunner().getSeparator() + ".actc.db");
		esp.getRunner().deleteFile(preferences.getWorkingDirectory() + esp.getRunner().getSeparator() + preferences.getEspPatchFile());
		esp.getRunner().deleteFile(preferences.getWorkingDirectory() + esp.getRunner().getSeparator() + preferences.getEspJSONFile());
		if (status != 0)
		{
			log.info("ACTC cleaning error");
			throw new IOException("Build error");
		}
		else
			log.info("ACTC clean completed");
	}

	/**
	 * Retrieves the list of the preprocessed files.
	 * @return The list of preprocessed files.
	 * @throws IOException
	 *             If the command cannot be executed.
	 */
	public Set<String> getPreprocessedFiles() throws IOException
	{
		Preferences preferences = esp.getModel().getPreferences();

		String s = esp.getRunner().getSeparator();
		String name = getName();

		return esp.getRunner().listFile(preferences.getWorkingDirectory() + s + "build" + s + name + s + "SC04", ".c.i");
	}

	/**
	 * Retrieves the ACTC project name.
	 * @return The project name.
	 **/
	public String getName()
	{
		Preferences preferences = esp.getModel().getPreferences();

		String[] sections = preferences.getActcConfigurationFile().split(preferences.getRemoteFileSeparator());
		String name = sections[sections.length - 1].replace(".json", "");
		return name;
	}

	/**
	 * Retrieves all the protections supported by the ACTC.
	 * @throws IOException
	 *             If a file cannot be opened.
	 * @throws URISyntaxException
	 *             If a path is invalid.
	 * @throws JAXBException
	 *             If some XML parsing error occurs.
	 **/
	public void collectProtections() throws JAXBException, URISyntaxException, IOException
	{
		JAXBContext jc = JAXBContext.newInstance("it.polito.security.esp.kb.protectioninstantiation");
		Unmarshaller u = jc.createUnmarshaller();

		for (IConfigurationElement i : Eclipse.getExtensions(Activator.PROTECTION_INSTANTIATIONS_ID))
		{
			String pluginId = i.getDeclaringExtension().getNamespaceIdentifier();
			String xmlFile = i.getAttribute("xmlFile");
			String file = Eclipse.getPath(pluginId, xmlFile);
			File f = new File(file);

			ProtectionInstantiationsList list = (ProtectionInstantiationsList) u.unmarshal(new FileInputStream(f));
			for (ProtectionInstantiationsList.ProtectionInstantiation pi : list.getProtectionInstantiation())
			{
				Protection protection = null;
				boolean exitDueToProtDisabled = false;
				for (Protection protection2 : esp.getModel().getProtections())
					if (protection2.getId().equals(pi.getProtectionName()))
					{
						if(!protection2.isEnabled())
						{
							exitDueToProtDisabled=true;
							break;
						}
						boolean exit = false;
						for (ProtectionInstantiation pi2 : protection2.getInstantiations())
							if (pi2.getName().equals(pi.getProtectionInstantiationName()))
							{
								log.severe("Unable to import " + pi.getProtectionInstantiationName() + " from file " + f.getAbsolutePath()
										+ ": a protection instantiation with the same name exists.");
								exit = true;
								break;
							}
						if (exit)
							continue;
						protection = protection2;
						break;
					}
				if (exitDueToProtDisabled)
					continue;
				if (protection == null)
				{
					log.severe("Unable to import " + pi.getProtectionInstantiationName() + " from file " + f.getAbsolutePath()
							+ ": the specified protection " + pi.getProtectionName() + " does not exist.");
					continue;
				}

				ProtectionInstantiation pi2 = KbFactory.eINSTANCE.createProtectionInstantiation();
				pi2.setName(pi.getProtectionInstantiationName());

				if (pi.getVariableAnnotation() != null)
					pi2.setVariableAnnotation(pi.getVariableAnnotation());
				else
					pi2.setVariableAnnotation("");
				if (pi.getCodeRegionAnnotation() != null)
					pi2.setCodeAnnotation(pi.getCodeRegionAnnotation());
				else
					pi2.setCodeAnnotation("");
				if (pi.getAttestatorAnnotation() != null)
					pi2.setAttestatorAnnotation(pi.getAttestatorAnnotation());
				else
					pi2.setAttestatorAnnotation("");
				if (pi.getVerifierAnnotation() != null)
					pi2.setVerifierAnnotation(pi.getVerifierAnnotation());
				else
					pi2.setVerifierAnnotation("");
				if (pi.getToolCommand()!= null)
					pi2.setToolCommand(pi.getToolCommand());
				else
					pi2.setToolCommand("");
				if (pi.getClientMemoryOverhead() != null)
					pi2.setClientMemoryOverhead(pi.getClientMemoryOverhead());
				else
					pi2.setClientMemoryOverhead("");
				if (pi.getServerMemoryOverhead() != null)
					pi2.setServerMemoryOverhead(pi.getServerMemoryOverhead());
				else
					pi2.setServerMemoryOverhead("");
				if (pi.getClientTimeOverhead() != null)
					pi2.setClientTimeOverhead(pi.getClientTimeOverhead());
				else
					pi2.setClientTimeOverhead("");
				if (pi.getServerTimeOverhead() != null)
					pi2.setServerTimeOverhead(pi.getServerTimeOverhead());
				else
					pi2.setServerTimeOverhead("");
				if (pi.getNetworkOverhead() != null)
					pi2.setNetworkOverhead(pi.getNetworkOverhead());
				else
					pi2.setNetworkOverhead("");
				protection.getInstantiations().add(pi2);
				log.finer("Added protection instantiation " + pi2.getName() + " referring to protection " + pi2.getProtection().getName());
			}
		}
	}

	/**
	 * Parses the metrics and updates a solution.
	 * @param solution
	 *            The solution to update.
	 * @throws IOException
	 *             If the file cannot be read.
	 **/
	public void parseMetrics(Solution solution) throws IOException
	{
		Runner runner = esp.getRunner();

		Preferences preferences = esp.getModel().getPreferences();
		String baseDir = preferences.getWorkingDirectory() + esp.getRunner().getSeparator() + "build" + esp.getRunner().getSeparator()
				+ getName() + esp.getRunner().getSeparator() + "BC05";

		// Parses the global metrics.
		Set<Entry<Integer, Map<String, Double>>> entries = new HashSet<>();
		entries.addAll(parseMetrics(runner.listFirstFile(baseDir, ".stat_complexity_info")).entrySet());
		// entries.addAll(parseMetrics(runner.listFirstFile(baseDir, ".dynamic_complexity_info")).entrySet());
		entries.addAll(parseMetrics(runner.listFirstFile(baseDir, ".stat_regions_complexity_info")).entrySet());
		// entries.addAll(parseMetrics(runner.listFirstFile(baseDir, ".dynamic_regions_complexity_info")).entrySet());
		entries.addAll(parseMetrics(runner.listFirstFile(baseDir, ".code_mobility_metrics")).entrySet());
		entries.addAll(parseMetrics(runner.listFirstFile(baseDir, ".attestation_metrics")).entrySet());

		// Merges the metrics.
		Map<Integer, Map<String, Double>> metrics = new HashMap<>();
		for (Entry<Integer, Map<String, Double>> i : entries)
		{
			Map<String, Double> list;
			if (metrics.containsKey(i.getKey()))
				list = metrics.get(i.getKey());
			else
			{
				list = new HashMap<>();
				metrics.put(i.getKey(), list);
			}
			for (Entry<String, Double> j : i.getValue().entrySet())
				list.put(j.getKey(), j.getValue());
		}

		// Saves the metrics in the solution.
		for (Entry<Integer, Map<String, Double>> i : metrics.entrySet())
			if (i.getKey() == -1)
			{
				for (Entry<String, Double> j : i.getValue().entrySet())
				{
					Metric metric = KbFactory.eINSTANCE.createMetric();
					metric.setName(j.getKey());
					metric.setValue(j.getValue());
					solution.getApplicationMetrics().add(metric);
				}
			}
			else
			{
				ApplicationPart part = getApplicationPart(i.getKey());
				if (part != null)
				{
					ApplicationPartMetricSet set = KbFactory.eINSTANCE.createApplicationPartMetricSet();
					if (part.getType() == ApplicationPartType.CODE_REGION)// || part.getType() == ApplicationPartType.ATTESTATOR)
					{
						set.setApplicationPart(part);
						for (Entry<String, Double> j : i.getValue().entrySet())
						{
							Metric metric = KbFactory.eINSTANCE.createMetric();
							metric.setName(j.getKey());
							metric.setValue(j.getValue());
							set.getMetrics().add(metric);
						}
						solution.getApplicationPartMetricSets().add(set);
					}
					else
						log.warning("Invalid metrics for " + i.getKey() + " (" + part + ")");
				}
				else
					log.warning("Unmatched metrics for " + i.getKey());
			}

		if (solution.getSolutionSequences().isEmpty())
			log.info("Added " + metrics.size() + " metric sets for the vanilla solution");
		else
			log.info("Added " + metrics.size() + " metric sets for the solution #" + solution.hashCode());
	}

	/**
	 * Retrieves an application part with a certain id.
	 * @param id
	 *            The id.
	 * @return The found application part or <code>null</code> if it does not exist.
	 */
	private ApplicationPart getApplicationPart(int id)
	{
		for (ApplicationPart i : esp.getModel().getAllApplicationParts())
			if (i.getId() == id)
				return i;

		return null;
	}

	/**
	 * Parses a metrics file.
	 * @param file
	 *            The file to parse.
	 * @return The metrics.
	 * @throws IOException
	 *             If the file cannot be read.
	 **/
	private Map<Integer, Map<String, Double>> parseMetrics(String file) throws IOException
	{
		if (file == null || file.isEmpty())
			return new HashMap<>();

		String content = esp.getRunner().readFile(file);
		List<String> names = new ArrayList<>();
		Map<Integer, Map<String, Double>> list = new HashMap<>();
		Map<String, Double> metrics = null;

		BufferedReader reader = new BufferedReader(new StringReader(content));
		String line;
		while ((line = reader.readLine()) != null)
		{
			String[] parts = line.split(",");
			if (line.trim().startsWith("#"))
			{
				names.clear();
				for (String i : parts)
				{
					String name = i.trim().trim();
					names.add(name);
				}
			}
			else
			{
				for (int i = 0; i < parts.length; ++i)
				{
					String s = new String(parts[i]).trim();
					if (!s.isEmpty())
					{
						String name = names.get(i);
						if (i == 0)
						{
							int value = Integer.valueOf(s);
							metrics = new HashMap<>();
							list.put(value, metrics);
						}
						else
						{
							double value = Double.valueOf(s);
							metrics.put(name, value);
						}
					}
				}
			}
		}
		reader.close();

		return list;
	}

	/**
	 * Retrieves the source files of an ACTC project.
	 * @return A map containing the files names coupled with a boolean stating if they are standard files or not.
	 * @throws IOException
	 *             If some I/O error occurs.
	 **/
	public Map<String, Boolean> getFiles() throws IOException
	{
		Map<String, Boolean> map = new HashMap<>();
		Preferences preferences = esp.getModel().getPreferences();
		Runner runner = esp.getRunner();

		// Copies the list script.
		URL url1 = new URL("platform:/plugin/it.polito.security.esp.kb/files/list.pl");
		String list = preferences.getWorkingDirectory() + preferences.getRemoteFileSeparator() + "list.pl";
		runner.createFile(list, url1.openConnection().getInputStream());

		// Launches the script.
		List<String> command = new ArrayList<>();
		command.add("cd");
		command.add(preferences.getWorkingDirectory());
		command.add("&&");
		command.add(preferences.getCommandPerl());
		command.add(list);
		command.add(preferences.getActcConfigurationFile());
		command.add(String.valueOf(preferences.isParserHeaderParsing()));
		StringBuilder files = new StringBuilder();
		if (runner.run(command, files) != 0)
		{
			log.severe("Unable to list the project source files");
			throw new IOException("Unable to list the project source files");
		}

		// Deletes the script.
		runner.deleteFile(list);

		for (String i : files.toString().split("\n"))
			if (i.startsWith("true "))
				map.put(i.substring(5), true);
			else if (i.startsWith("false "))
				map.put(i.substring(6), false);

		return map;
	}

	/**
	 * Retrieves the inclusion directories of an ACTC project.
	 * @return The inclusion directories of the project.
	 * @throws IOException
	 *             If some I/O error occurs.
	 **/
	public Collection<String> getInclusionDirectories() throws IOException
	{
		Preferences preferences = esp.getModel().getPreferences();
		Runner runner = esp.getRunner();

		// Copies the list script.
		URL url1 = new URL("platform:/plugin/it.polito.security.esp.kb/files/includes.pl");
		String includes = preferences.getWorkingDirectory() + preferences.getRemoteFileSeparator() + "includes.pl";
		runner.createFile(includes, url1.openConnection().getInputStream());

		// Launches the script.
		List<String> command = new ArrayList<>();
		command.add("cd");
		command.add(preferences.getWorkingDirectory());
		command.add("&&");
		command.add("perl");
		command.add(includes);
		command.add(preferences.getActcConfigurationFile());
		StringBuilder files = new StringBuilder();
		if (runner.run(command, files) != 0)
		{
			log.severe("Unable to list the project source files");
			throw new IOException("Unable to list the project source files");
		}

		// Deletes the script.
		runner.deleteFile(includes);

		return Arrays.asList(files.toString().split("\n"));
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(ACTCConnector.class.getName());
}

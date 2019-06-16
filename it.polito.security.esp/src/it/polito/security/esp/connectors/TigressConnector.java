package it.polito.security.esp.connectors;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.Metric;
import it.polito.security.esp.kb.Preferences;
import it.polito.security.esp.kb.Protection;
import it.polito.security.esp.kb.ProtectionInstantiation;
import it.polito.security.esp.kb.Solution;
import it.polito.security.esp.kb.SolutionSequence;
import it.polito.security.esp.kb.protectioninstantiation.ProtectionInstantiationsList;
import it.polito.security.esp.util.Eclipse;

/**
 * Manages the communications between Tigress and the ESP.
 * @author Leonardo Regano
 **/
public class TigressConnector
{
	/** The ESP. **/
	private ESP esp;

	/**
	 * Creates the connector.
	 * @param esp
	 *            The ESP.
	 **/
	public TigressConnector(ESP esp)
	{
		this.esp = esp;
	}

	/**
	 * Builds the project with Tigress.
	 * @param logFileName
	 *            The log file name where to put the logs or <code>null</code> if no log file should be created.
	 * @throws IOException
	 *             If the command cannot be executed.
	 * @throws CoreException
	 *             If the log file cannot be created.
	 **/
	public void build(String logFileName, Solution solution) throws IOException, CoreException
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
				
		//Tigress build
		log.info("Tigress build started");
		long start = System.currentTimeMillis();
		
		esp.getRunner().createDirectory(preferences.getWorkingDirectory(), "tempTigress");
		String tempDir = preferences.getWorkingDirectory()+esp.getRunner().getSeparator()+"tempTigress";
		
		Map<String,List<String>> config = retrieveProjectConfiguration();
		
		//create .c.tigress files with ASPIRE annotation removed
		for(String file: config.get("sourceFiles"))
		{
//			esp.getRunner().copyFile(file, file+".tigress");
			List<String> content = esp.getRunner().readFileAsList(file);
			StringBuilder sb = new StringBuilder();
			for(String line : content)
			{
				Pattern pattern = Pattern.compile(
						".+(__attribute__\\s*\\(\\s*\\(\\s*ASPIRE\\s*\\(\\s*\"(.*)?\\s*\"\\s*\\)\\s*\\)\\s*\\)).+", Pattern.DOTALL);
				Matcher matcher = pattern.matcher(line);
				if (matcher.matches())
				{
					int annStart = matcher.start(1);
					int annEnd = matcher.end(1);
					sb.append(line.substring(0, annStart));
					sb.append("/*");
					sb.append(line.substring(annStart,annEnd));
					sb.append("*/");
					sb.append(line.substring(annEnd));
					sb.append("\n");
				}
				else
				{
					if(line.trim().startsWith("_Pragma(\"ASPIRE"))
						sb.append("//");
					sb.append(line);
					sb.append("\n");	
				}
			}
			esp.getRunner().copyFile(file, file+".bak");
			esp.getRunner().deleteFile(file);
			esp.getRunner().createFile(file, new ByteArrayInputStream(sb.toString().getBytes()));
		}
		
		//merge .c.tigress files with cilly
		List<String> commandCillyMerge = new ArrayList<>();
		commandCillyMerge.add("cd");
		commandCillyMerge.add(dockerRoot);
		commandCillyMerge.add("&&");		
		for(String s: preferences.getCommandCilly().split(" "))
		{
			if(s.startsWith("~"))
				commandCillyMerge.add(s.replace("~",System.getProperty("user.home")));
			else
				commandCillyMerge.add(s);
		}
		
		commandCillyMerge.add("--gcc="+config.get("frontend").get(0));
		
		for(String preprocessFlag: config.get("preprocessFlags"))
			commandCillyMerge.add(preprocessFlag);
		for(String compilationFlag: config.get("compilationFlags"))
			commandCillyMerge.add(compilationFlag);
		for(String linkFlag: config.get("linkFlags"))
			commandCillyMerge.add(linkFlag);
		commandCillyMerge.add("--merge");
		commandCillyMerge.add("--keepmerged");

		for(String sourceFile: config.get("sourceFiles"))
			commandCillyMerge.add(sourceFile.replace(dockerRoot, ""));
		
		commandCillyMerge.add("-o");
		commandCillyMerge.add(tempDir.replace(dockerRoot, "")+esp.getRunner().getSeparator()+"merged");
		commandCillyMerge.add("--mergedout="+tempDir.replace(dockerRoot, "")+esp.getRunner().getSeparator()+"merged.c");
		StringBuilder sb = new StringBuilder();
		int exitValue = esp.getRunner().run(commandCillyMerge, sb);
		long stop = System.currentTimeMillis();
		if (exitValue != 0)
		{
			log.info("Cilly merging error");
			if (logFileName != null)
				Eclipse.createFile(esp.getKBFile().getParent(), logFileName, sb.toString());
			for(String file: config.get("sourceFiles"))
			{
				esp.getRunner().deleteFile(file);
				esp.getRunner().copyFile(file+".bak", file);
				esp.getRunner().deleteFile(file+".bak");
			}
			log.severe("Cilly merging error");
			return;
//			throw new IOException(String.format("Cilly merging error = %.3f s", (stop - start) / 1000.0));
		}
		
		for(String file: config.get("sourceFiles"))
		{
			esp.getRunner().deleteFile(file);
			esp.getRunner().copyFile(file+".bak", file);
			esp.getRunner().deleteFile(file+".bak");
		}

//		List<String> whoami = new ArrayList<String>();
//		whoami.add("cd");
//		whoami.add(dockerRoot);
//		whoami.add("&&");
//		whoami.add("docker-compose");
//		whoami.add("-f");
//		whoami.add("/home/leo89r/git/framework/docker-compose.yml");
//		whoami.add("exec");
//		whoami.add("-T");
//		whoami.add("actc");
//		whoami.add("cat");
//		esp.getRunner().run(whoami,sb);
		
		
//		commandTigress.add("--FilePrefix=_tigress_ESP_");
		
		if (logFileName != null)
			Eclipse.createFile(esp.getKBFile().getParent(), logFileName, sb.toString());

		for(ApplicationPart function: esp.getModel().getApplicationParts())
		{
			List<String> commandTigress = new ArrayList<>();
			commandTigress.add("cd");
			commandTigress.add(dockerRoot);
			commandTigress.add("&&");		
			for(String s: preferences.getCommandTigress().split(" "))
			{
				if(s.startsWith("~"))
					commandTigress.add(s.replace("~",System.getProperty("user.home")));
				else
					commandTigress.add(s);
			}
			commandTigress.add("--gcc="+config.get("frontend").get(0));
			
			commandTigress.add("--Environment=armv7:Linux:Gcc:4.6");
			
			List<String> commandTigress2 = new ArrayList<>();
			
			boolean isTigressProtected = false;
			for(SolutionSequence solSeq : solution.getSolutionSequences())
				for(AppliedProtectionInstantiation api : solSeq.getAppliedProtectionInstantiations())
				{
					if(api.getProtectionInstantiation().getName().contains("Tigress"))
						if(function.contains(api.getApplicationPart())&&api.getApplicationPart().isDatum())
						{
							if(api.getToolCommand()!=null)
								for(String s : api.getToolCommand().split(" "))
								{
									commandTigress.add(s);
									isTigressProtected=true;
								}
						}
						else if(function.contains(api.getApplicationPart())&&api.getApplicationPart().isCode())
						{
							if(api.getToolCommand()!=null)
								for(String s : api.getToolCommand().split(" "))
								{
									commandTigress2.add(s);
									isTigressProtected=true;
								}
						}		
				}
			
			
			if(!isTigressProtected)
				continue;
			
			commandTigress.addAll(commandTigress2);
			
			commandTigress.add("--out="+tempDir.replace(dockerRoot, "")+esp.getRunner().getSeparator()+"merged_comb_tigress_"+function+".c");
			commandTigress.add(tempDir.replace(dockerRoot, "")+esp.getRunner().getSeparator()+"merged_comb.c");
			exitValue = esp.getRunner().run(commandTigress, sb);
			stop = System.currentTimeMillis();
			if (exitValue != 0)
			{
				log.info("Tigress building error");
	//			throw new IOException(String.format("Build error = %.3f s", (stop - start) / 1000.0));
			}
		}	
		stop = System.currentTimeMillis();
		log.info(String.format("Build completed = %.3f s", (stop - start) / 1000.0));
	}

	/**
	 * Retrieves the project configuration.
	 * @return A map containing the source files, and the flags for preprocessing, compilation and linking.
	 * @throws IOException
	 *             If some I/O error occurs.
	 **/
	public Map<String, List<String>> retrieveProjectConfiguration() throws IOException
	{
		Map<String, List<String>> map = new HashMap<>();
		Preferences preferences = esp.getModel().getPreferences();
		Runner runner = esp.getRunner();

		// Copies the list script.
		URL url1 = new URL("platform:/plugin/it.polito.security.esp.kb/files/tigress.pl");
		String projectConfigurationScript = preferences.getWorkingDirectory() + preferences.getRemoteFileSeparator() + "tigress.pl";
		runner.createFile(projectConfigurationScript, url1.openConnection().getInputStream());

		// Launches the script.
		List<String> command = new ArrayList<>();
		command.add("cd");
		command.add(preferences.getWorkingDirectory());
		command.add("&&");
		command.add(preferences.getCommandPerl());
		command.add(projectConfigurationScript);
		command.add(preferences.getActcConfigurationFile());
		command.add(String.valueOf(preferences.isParserHeaderParsing()));
		StringBuilder files = new StringBuilder();
		if (runner.run(command, files) != 0)
		{
			log.severe("Unable to list the project source files");
			throw new IOException("Unable to list the project source files");
		}

		// Deletes the script.
		runner.deleteFile(projectConfigurationScript);

		String[] lines = files.toString().split("\n");
		int i = 0;
		while(i<lines.length)
		{
			String[] header = lines[i++].split(" ");
			String key = header[0];
			String linesAmount = header[1];
			List<String> list = new ArrayList<String>(Integer.parseInt(linesAmount));
			
			int start = i;
			for(; i<start+Integer.parseInt(linesAmount); i++)
				list.add(lines[i]);
			
			map.put(key, list);
		}
		
		return map;
	}
	
	/**
	 * Cleans the files generated by Tigress.
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
		
		try
		{
			//Tigress Clean
			String tempDir = preferences.getWorkingDirectory()+esp.getRunner().getSeparator()+"tempTigress";
			esp.getRunner().deleteDirectory(tempDir);
		}		
		catch(Exception e)
		{
			log.info("ACTC cleaning error");
			throw new IOException("Build error");
		}
		
		log.info("TIgress clean completed");
	}

		/** The logger. **/
	private static Logger log = Logger.getLogger(TigressConnector.class.getName());
}

package it.polito.security.esp.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import it.polito.security.esp.ESP;
import it.polito.security.esp.ui.Activator;
import it.polito.security.esp.kb.KbFactory;
import it.polito.security.esp.kb.Level;
import it.polito.security.esp.kb.Preferences;

/**
 * The CryptoStudio nature.
 * @author Daniele Canavese
 **/
public class Nature implements IProjectNature
{
	/** The nature id. **/
	public static final String NATURE_ID = Activator.PLUGIN_ID + ".nature";

	/**
	 * Configures the current project.
	 * @throws CoreException
	 *             If something went wrong.
	 **/
	@Override
	public void configure() throws CoreException
	{
		final IFile file = getProject().getFile("kb.owl");
		final IEditorDescriptor descriptor = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		Job job = new Job("Creating initial KB")
		{
			@Override
			protected IStatus run(IProgressMonitor monitor)
			{
				try
				{
					ESP.create(file, getPreferences(getProject()), true);
					Display.getDefault().asyncExec(new Runnable()
					{
						@Override
						public void run()
						{
							try
							{
								page.openEditor(new FileEditorInput(file), descriptor.getId());
							}
							catch (PartInitException e)
							{
								e.printStackTrace();
							}
						}
					});
				}
				catch (Exception e)
				{
					e.printStackTrace();
					return Status.CANCEL_STATUS;
				}

				return Status.OK_STATUS;
			}
		};
		job.schedule();
	}

	/**
	 * Deconfigures the current project.
	 * @throws CoreException
	 *             If something went wrong.
	 **/
	@Override
	public void deconfigure() throws CoreException
	{
	}

	/**
	 * Retrieves the project.
	 * @return The project.
	 **/
	@Override
	public IProject getProject()
	{
		return project;
	}

	/**
	 * Sets the project.
	 * @param project
	 *            The project to set.
	 **/
	@Override
	public void setProject(IProject project)
	{
		this.project = project;
	}

	/**
	 * Creates the user preferences for a project.
	 * @param project
	 *            The project.
	 * @return
	 * @return The project preferences.
	 * @throws CoreException
	 *             If something goes wrong.
	 **/
	public Preferences getPreferences(IProject project) throws CoreException
	{
		String architecture = (String) (project.getSessionProperty(new QualifiedName("ESP", "architecture")));
		String workingDirectory = (String) (project.getSessionProperty(new QualifiedName("ESP", "workingDirectory")));
		String actcConfigFile = (String) (project.getSessionProperty(new QualifiedName("ESP", "actcConfigFile")));
		String espPatchFile = (String) (project.getSessionProperty(new QualifiedName("ESP", "espPatchFile")));
		String espJSONFile = (String) (project.getSessionProperty(new QualifiedName("ESP", "espJSONFile")));
		String actcCommand = (String) (project.getSessionProperty(new QualifiedName("ESP", "actcCommand")));
		String perlCommand = (String) (project.getSessionProperty(new QualifiedName("ESP", "PerlCommand")));
		String dotCommand = (String) (project.getSessionProperty(new QualifiedName("ESP", "dotCommand")));
		Boolean remoteConnectionEnabled = (Boolean) (project.getSessionProperty(new QualifiedName("ESP", "remoteConnectionEnabled")));
		String remoteHost = (String) (project.getSessionProperty(new QualifiedName("ESP", "remoteHost")));
		String remotePort = (String) (project.getSessionProperty(new QualifiedName("ESP", "remotePort")));
		String remoteUsername = (String) (project.getSessionProperty(new QualifiedName("ESP", "remoteUsername")));
		String remotePassword = (String) (project.getSessionProperty(new QualifiedName("ESP", "remotePassword")));
		String remoteFileSep = (String) (project.getSessionProperty(new QualifiedName("ESP", "remoteFileSep")));
		int profileLevel = (int) (project.getSessionProperty(new QualifiedName("ESP", "profileLevel")));

		Preferences preferences = KbFactory.eINSTANCE.createPreferences();

		if (architecture != null && !architecture.isEmpty())
			preferences.setArchitecture(architecture);
		if (workingDirectory != null && !workingDirectory.isEmpty())
			preferences.setWorkingDirectory(workingDirectory);
		if (actcConfigFile != null && !actcConfigFile.isEmpty())
			preferences.setActcConfigurationFile(actcConfigFile);
		if (espPatchFile != null && !espPatchFile.isEmpty())
			preferences.setEspPatchFile(espPatchFile);
		if (espJSONFile != null && !espJSONFile.isEmpty())
			preferences.setEspJSONFile(espJSONFile);
		if (actcCommand != null && !actcCommand.isEmpty())
			preferences.setCommandACTC(actcCommand);
		if (perlCommand != null && !perlCommand.isEmpty())
			preferences.setCommandPerl(perlCommand);
		if (dotCommand != null && !dotCommand.isEmpty())
			preferences.setCommandDot(dotCommand);
		preferences.setRemoteConnection(remoteConnectionEnabled);
		if (remoteHost != null && !remoteHost.isEmpty())
			preferences.setRemoteHost(remoteHost);
		if (remotePort != null && !remotePort.isEmpty())
			preferences.setRemotePort(Integer.parseInt(remotePort));
		if (remoteUsername != null && !remoteUsername.isEmpty())
			preferences.setRemoteUsername(remoteUsername);
		if (remotePassword != null && !remotePassword.isEmpty())
			preferences.setRemotePassword(remotePassword);
		if (remoteFileSep != null && !remoteFileSep.isEmpty())
			preferences.setRemoteFileSeparator(remoteFileSep);

		if (profileLevel == 1)
		{
			preferences.setMetricsFile("+gammas.csv");
			preferences.setParserSystemFilesIgnoration(true);
			preferences.setAttacksTimeLimit(60);
			preferences.setAttacksMaximumDepth(4);
			preferences.setProtectionsMinimumAttackMitigation(Level.MEDIUM);
			preferences.setL1pTimeLimit(180);
			preferences.setL1pMainSearchMaximumDepth(3);
			preferences.setL1pMultiTreeMultiplier(1.0);
			preferences.setL1pEncouragedPrecedencesFocusing(true);
			preferences.setL1pDiscouragedPrecedencesIgnoration(true);
			preferences.setL1pFutilityMargin(1.0);
			preferences.setL1pExtendedFutilityMargin(2.0);
			preferences.setL1pRazoringMargin(4.0);
			preferences.setL2pTimeLimit(60);
			preferences.setL2pFunctionSplittingMediumCodeBlockLength(16);
			preferences.setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(4);
			preferences.setL2pFunctionSplittingDepthLevel(1);
		}
		else if (profileLevel == 2)
		{
			preferences.setMetricsFile("+gammas.csv");
			preferences.setParserHeaderParsing(true);
			preferences.setParserSystemFilesIgnoration(true);
			preferences.setAttacksTimeLimit(600);
			preferences.setAttacksMaximumDepth(6);
			preferences.setProtectionsMinimumAttackMitigation(Level.MEDIUM);
			preferences.setL1pTimeLimit(600);
			preferences.setL1pMainSearchMaximumDepth(6);
			preferences.setL1pMultiTreeMultiplier(1.0);
			preferences.setL1pEncouragedPrecedencesFocusing(true);
			preferences.setL1pDiscouragedPrecedencesIgnoration(true);
			preferences.setL1pFutilityMargin(1.0);
			preferences.setL1pExtendedFutilityMargin(2.0);
			preferences.setL1pRazoringMargin(4.0);
			preferences.setL2pTimeLimit(600);
			preferences.setL2pFunctionSplittingMediumCodeBlockLength(8);
			preferences.setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(2);
			preferences.setL2pFunctionSplittingDepthLevel(1);
		}
		else if (profileLevel == 3)
		{
			preferences.setMetricsFile("+gammas.csv");
			preferences.setParserHeaderParsing(true);
			preferences.setParserSystemFilesIgnoration(true);
			preferences.setAttacksTimeLimit(3600);
			preferences.setAttacksMaximumDepth(8);
			preferences.setProtectionsMinimumAttackMitigation(Level.MEDIUM);
			preferences.setL1pTimeLimit(3600);
			preferences.setL1pMainSearchMaximumDepth(9);
			preferences.setL1pMultiTreeMultiplier(1.0);
			preferences.setL1pEncouragedPrecedencesFocusing(true);
			preferences.setL1pDiscouragedPrecedencesIgnoration(true);
			preferences.setL1pFutilityMargin(1.0);
			preferences.setL1pExtendedFutilityMargin(2.0);
			preferences.setL1pRazoringMargin(-4.0);
			preferences.setL2pTimeLimit(3600);
			preferences.setL2pFunctionSplittingMediumCodeBlockLength(4);
			preferences.setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(2);
			preferences.setL2pFunctionSplittingDepthLevel(1);
		}
		else if (profileLevel == 4)
		{
			preferences.setMetricsFile("+gammas.csv");
			preferences.setParserHeaderParsing(true);
			preferences.setParserSystemFilesIgnoration(false);
			preferences.setAttacksTimeLimit(86400);
			preferences.setAttacksMaximumDepth(10);
			preferences.setProtectionsMinimumAttackMitigation(Level.LOW);
			preferences.setL1pTimeLimit(86400);
			preferences.setL1pMainSearchMaximumDepth(15);
			preferences.setL1pMultiTreeMultiplier(1.0);
			preferences.setL1pEncouragedPrecedencesFocusing(true);
			preferences.setL1pDiscouragedPrecedencesIgnoration(true);
			preferences.setL1pFutilityMargin(1.0);
			preferences.setL1pExtendedFutilityMargin(-2.0);
			preferences.setL1pRazoringMargin(-4.0);
			preferences.setL2pTimeLimit(86400);
			preferences.setL2pFunctionSplittingMediumCodeBlockLength(2);
			preferences.setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(1);
			preferences.setL2pFunctionSplittingDepthLevel(1);
		}
		else
		{
			preferences.setMetricsFile("-gammas.csv");
			preferences.setParserHeaderParsing(true);
			preferences.setParserSystemFilesIgnoration(false);
			preferences.setAttacksTimeLimit(-86400);
			preferences.setAttacksMaximumDepth(12);
			preferences.setProtectionsMinimumAttackMitigation(Level.LOW);
			preferences.setL1pTimeLimit(-86400);
			preferences.setL1pMainSearchMaximumDepth(30);
			preferences.setL1pMultiTreeMultiplier(-50.0);
			preferences.setL1pEncouragedPrecedencesFocusing(false);
			preferences.setL1pDiscouragedPrecedencesIgnoration(false);
			preferences.setL1pFutilityMargin(-1.0);
			preferences.setL1pExtendedFutilityMargin(-2.0);
			preferences.setL1pRazoringMargin(-4.0);
			preferences.setL2pTimeLimit(-86400);
			preferences.setL2pFunctionSplittingMediumCodeBlockLength(1);
			preferences.setL2pFunctionSplittingCodeBlockLengthRandomizationDenominator(1);
			preferences.setL2pFunctionSplittingDepthLevel(1);
		}

		return preferences;
	}

	/** The project. **/
	private IProject project;
}

package it.polito.security.esp.ui.editors;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.AttackMitigation;
import it.polito.security.esp.kb.Protection;
import it.polito.security.esp.kb.Solution;
import it.polito.security.esp.ui.Activator;
import it.polito.security.esp.ui.dialogs.SolutionMultiSelectionDialog;
import it.polito.security.esp.ui.dialogs.SolutionSelectionDialog;
import it.polito.security.esp.ui.listeners.ESPEventGenerator;
import it.polito.security.esp.ui.listeners.Event;
import it.polito.security.esp.util.Eclipse;

/**
 * The overview page.
 * @author Daniele Canavese
 **/
public class OverviewPage extends FormPage
{
	/** The ESP. **/
	private ESP esp;
	/** The event generator. **/
	private ESPEventGenerator eventGenerator;
	/** The build all hyperlink. **/
	private ImageHyperlink buildAllHyperlink;
	/** The analyze source code hyperlink. **/
	private ImageHyperlink analyzeSourceCodeHyperlink;
	/** The find attacks hyperlink. **/
	private ImageHyperlink findAttacksHyperlink;
	/** The find protections hyperlink. **/
	private ImageHyperlink findProtectionsHyperlink;
	/** The find first level protections hyperlink. **/
	private ImageHyperlink findFirstLevelProtectionsHyperlink;
	/** The find second level protections hyperlink. **/
	private ImageHyperlink findSecondLevelProtectionsHyperlink;
	/** The deploy solution. **/
	private ImageHyperlink deploySolutionghHyperlink;
	/** The source directory text. **/
	private Text workingDirectoryText;
	/** The ACTC configuration file text. **/
	private Text actcConfigurationFileText;
	/** The ESP patch file text. **/
	private Text espPatchFileText;
	/** The ESP JSON file text. **/
	private Text espJSONFileText;
	/** The deploy splitting patch action. **/
	private Action deploySplittingPatchAction;
	/** The create fake attack paths action. **/
	private Action createFakeAttackPathsAction;
	/** The compute metrics action. **/
	private Action computeMetricsAction;
	/** The compute metrics coefficients action. **/
	private Action computeCoefficientsAction;

	/**
	 * Creates the page.
	 * @param editor
	 *            The parent editor.
	 * @param esp
	 *            The ESP.
	 * @param eventGenerator
	 *            The event generator.
	 * @param solverObserver
	 *            An optional solver observer to use.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public OverviewPage(FormEditor editor, ESP esp, ESPEventGenerator eventGenerator) throws Exception
	{
		super(editor, "overview", "Overview");
		this.esp = esp;
		this.eventGenerator = eventGenerator;
	}

	/**
	 * Creates the form content.
	 * @param managedForm
	 *            The managed form.
	 **/
	@Override
	protected void createFormContent(IManagedForm managedForm)
	{
		try
		{
			ScrolledForm form = managedForm.getForm();
			managedForm.getToolkit().paintBordersFor(form);
			form.setText("ESP Knowledge Base Overview");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/all.png"));
			form.getBody().setLayout(new GridLayout(2, false));

			form.getToolBarManager()
					.add(new Action("Export HTML report...", Eclipse.getImageDescriptor(Activator.PLUGIN_ID, "icons/report.png"))
					{
						@Override
						public void run()
						{
							SaveAsDialog dialog = new SaveAsDialog(Display.getDefault().getActiveShell());
							dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile().getProject().getFile("report.html"));
							dialog.open();
							IPath path = dialog.getResult();
							if (path != null)
							{
								ReportGenerator reportGenerator = new ReportGenerator(OverviewPage.this.esp);
								try
								{
									reportGenerator.generate(((IFileEditorInput) getEditorInput()).getFile().getProject().getName(),
											ResourcesPlugin.getWorkspace().getRoot().getLocation().append(path).toOSString());
									ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
								}
								catch (FileNotFoundException | CoreException e)
								{
									e.printStackTrace();
								}
							}
						}
					});
			deploySplittingPatchAction = new Action("Deploy the splitting patch",
					Eclipse.getImageDescriptor(Activator.PLUGIN_ID, "icons/deploy.png"))
			{
				@Override
				public void run()
				{
					Job job = new Job("Deploying the splitting patch...")
					{
						@Override
						protected IStatus run(IProgressMonitor monitor)
						{
							try
							{
								esp.getAnnotationRewriter().deploySplittingPatch();
								return Status.OK_STATUS;
							}
							catch (Exception e)
							{
								e.printStackTrace();
								return Status.CANCEL_STATUS;
							}
						}
					};
					job.setUser(true);
					job.schedule();
				}
			};
			deploySplittingPatchAction.setEnabled(false);
			form.getForm().getMenuManager().add(deploySplittingPatchAction);
			createFakeAttackPathsAction = new Action("Creates the fake attack paths",
					Eclipse.getImageDescriptor(Activator.PLUGIN_ID, "icons/attackPath.png"))
			{
				@Override
				public void run()
				{
					Job job = new Job("Creating the fake attack paths...")
					{
						@Override
						protected IStatus run(IProgressMonitor monitor)
						{
							try
							{
								esp.createFakeAttackPaths();
								eventGenerator.fireEvents(Event.ATTACK_PATH_UPDATED);
								eventGenerator.fireEvents(Event.ATTACK_STEP_UPDATED);
								updateEnables();
								return Status.OK_STATUS;
							}
							catch (Exception e)
							{
								e.printStackTrace();
								return Status.CANCEL_STATUS;
							}
						}
					};
					job.setUser(true);
					job.schedule();
				}
			};
			createFakeAttackPathsAction.setEnabled(false);
			form.getForm().getMenuManager().add(createFakeAttackPathsAction);
			computeMetricsAction = new Action("Compute the metrics", Eclipse.getImageDescriptor(Activator.PLUGIN_ID, "icons/metrics.png"))
			{
				@Override
				public void run()
				{
					IInputValidator validator = new IInputValidator()
					{
						@Override
						public String isValid(String text)
						{
							try
							{
								int v = Integer.parseInt(text);
								if (v > 0)
									return null;
								else
									return "The depth must be a positive integer value.";
							}
							catch (NumberFormatException e)
							{
								return "The depth must be a positive integer value.";
							}
						}
					};
					InputDialog input = new InputDialog(Display.getDefault().getActiveShell(), "ESP", "Choose a depth level", "1",
							validator);
					if (input.open() == Window.OK)
					{
						final int depth = Integer.parseInt(input.getValue());

						SaveAsDialog dialog = new SaveAsDialog(Display.getDefault().getActiveShell());
						dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile().getProject().getFile("metrics.csv"));
						dialog.open();
						final IPath path = dialog.getResult();
						Job job = new Job("Computing the metrics...")
						{
							@Override
							protected IStatus run(IProgressMonitor monitor)
							{
								try
								{
									if (path != null)
										esp.computeMetrics(ResourcesPlugin.getWorkspace().getRoot().getFile(path), monitor, depth);
									return Status.OK_STATUS;
								}
								catch (Exception e)
								{
									e.printStackTrace();
									return Status.CANCEL_STATUS;
								}
							}
						};
						job.setUser(true);
						job.schedule();
					}
				}
			};
			computeMetricsAction.setEnabled(false);
			form.getForm().getMenuManager().add(computeMetricsAction);
			computeCoefficientsAction = new Action("Compute the metrics estimation coefficients...",
					Eclipse.getImageDescriptor(Activator.PLUGIN_ID, "icons/coefficients.png"))
			{
				@Override
				public void run()
				{
					final Collection<IFile> files = new ArrayList<>();
					ResourceSelectionDialog dialog = new ResourceSelectionDialog(Display.getDefault().getActiveShell(),
							ResourcesPlugin.getWorkspace().getRoot(), "Select the metrics file to use:");
					dialog.open();
					if (dialog.getResult() != null && dialog.getResult().length > 0)
					{
						for (Object i : dialog.getResult())
							if (i instanceof IFile)
								files.add((IFile) i);
					}
					if (!files.isEmpty())
					{
						SaveAsDialog dialog2 = new SaveAsDialog(Display.getDefault().getActiveShell());
						dialog2.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile().getProject().getFile("gammas.csv"));
						dialog2.open();
						final IPath path = dialog2.getResult();
						Job job = new Job("Computing the metrics estimation coefficients...")
						{
							@Override
							protected IStatus run(IProgressMonitor monitor)
							{
								try
								{
									esp.computeMetricCoefficients(files, ResourcesPlugin.getWorkspace().getRoot().getFile(path), monitor);
									return Status.OK_STATUS;
								}
								catch (Exception e)
								{
									e.printStackTrace();
									return Status.CANCEL_STATUS;
								}
							}
						};
						job.setUser(true);
						job.schedule();
					}
				}
			};
			computeCoefficientsAction.setEnabled(false);
			form.getForm().getMenuManager().add(computeCoefficientsAction);
			form.getToolBarManager().update(true);

			SummarySection summarySection = new SummarySection(esp, managedForm, LabelType.ASSETS, LabelType.PROTECTIONS,
					LabelType.ATTACK_PATHS);
			eventGenerator.addListener(summarySection);
			managedForm.addPart(summarySection);
			createSourceDirectorySection(managedForm);
			createAutomaticBuildSection(managedForm);
			createStepByStepBuildSection(managedForm);
			createLogo(managedForm);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the application parts section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createSourceDirectorySection(IManagedForm managedForm) throws Exception
	{
		SectionPart sourceDirectorySectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(sourceDirectorySectionPart);
		sourceDirectorySectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		sourceDirectorySectionPart.getSection().setText("Source Directory");

		Composite sourceDirectoryComposite = new Composite(sourceDirectorySectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(sourceDirectoryComposite);
		managedForm.getToolkit().paintBordersFor(sourceDirectoryComposite);
		sourceDirectorySectionPart.getSection().setClient(sourceDirectoryComposite);
		sourceDirectoryComposite.setLayout(new GridLayout(3, false));

		managedForm.getToolkit().createLabel(sourceDirectoryComposite, "Working directory:");

		workingDirectoryText = managedForm.getToolkit().createText(sourceDirectoryComposite, "", SWT.NONE);
		workingDirectoryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		workingDirectoryText.setText(esp.getModel().getPreferences().getWorkingDirectory());

		Button sourceDirectoryButton = managedForm.getToolkit().createButton(sourceDirectoryComposite, "Browse...", SWT.NONE);

		managedForm.getToolkit().createLabel(sourceDirectoryComposite, "ACTC configuration file:");

		actcConfigurationFileText = managedForm.getToolkit().createText(sourceDirectoryComposite, "", SWT.NONE);
		actcConfigurationFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		actcConfigurationFileText.setText(esp.getModel().getPreferences().getActcConfigurationFile());

		Button actcConfigurationFileButton = managedForm.getToolkit().createButton(sourceDirectoryComposite, "Browse...", SWT.NONE);

		managedForm.getToolkit().createLabel(sourceDirectoryComposite, "ESP patch file:");

		espPatchFileText = managedForm.getToolkit().createText(sourceDirectoryComposite, "", SWT.NONE);
		espPatchFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		espPatchFileText.setText(esp.getModel().getPreferences().getEspPatchFile());

		new Label(sourceDirectoryComposite, SWT.NONE);

		managedForm.getToolkit().createLabel(sourceDirectoryComposite, "ESP JSON file:");

		espJSONFileText = managedForm.getToolkit().createText(sourceDirectoryComposite, "", SWT.NONE);
		espJSONFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		espJSONFileText.setText(esp.getModel().getPreferences().getEspJSONFile());

		new Label(sourceDirectoryComposite, SWT.NONE);

		workingDirectoryText.addModifyListener(new ModifyListener()
		{

			@Override
			public void modifyText(ModifyEvent e)
			{
				esp.getModel().getPreferences().setWorkingDirectory(workingDirectoryText.getText());
			}
		});

		actcConfigurationFileText.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				esp.getModel().getPreferences().setActcConfigurationFile(actcConfigurationFileText.getText());
			}
		});

		espPatchFileText.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				esp.getModel().getPreferences().setEspPatchFile(espPatchFileText.getText());
			}
		});

		espJSONFileText.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				esp.getModel().getPreferences().setEspJSONFile(espJSONFileText.getText());
			}
		});

		sourceDirectoryButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getDefault().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						DirectoryDialog dialog = new DirectoryDialog(Display.getDefault().getActiveShell());
						String directory = dialog.open();
						if (directory != null)
						{
							esp.getModel().getPreferences().setWorkingDirectory(directory);
							workingDirectoryText.setText(esp.getModel().getPreferences().getWorkingDirectory());
						}
					}
				});
			}
		});

		actcConfigurationFileButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getDefault().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						FileDialog dialog = new FileDialog(Display.getDefault().getActiveShell());
						dialog.setFilterExtensions(new String[] { "*.json" });
						String file = dialog.open();
						if (file != null)
						{
							esp.getModel().getPreferences().setActcConfigurationFile(file);
							actcConfigurationFileText.setText(esp.getModel().getPreferences().getActcConfigurationFile());
						}
					}
				});
			}
		});
	}

	/**
	 * Creates the automatic build section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createAutomaticBuildSection(IManagedForm managedForm) throws Exception
	{
		SectionPart automaticBuildSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR | Section.DESCRIPTION);
		managedForm.addPart(automaticBuildSectionPart);
		automaticBuildSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		automaticBuildSectionPart.getSection().setText("Automatic Build");
		automaticBuildSectionPart.getSection().setDescription("Perform all the protection steps at once");

		Composite automaticBuildComposite = new Composite(automaticBuildSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(automaticBuildComposite);
		managedForm.getToolkit().paintBordersFor(automaticBuildComposite);
		automaticBuildSectionPart.getSection().setClient(automaticBuildComposite);
		automaticBuildComposite.setLayout(new GridLayout(1, false));

		buildAllHyperlink = managedForm.getToolkit().createImageHyperlink(automaticBuildComposite, SWT.NONE);
		buildAllHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		buildAllHyperlink.setText("Build All");
		buildAllHyperlink.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/all.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		buildAllHyperlink.addHyperlinkListener(createAdapter("Building everything!", new Executable()
		{
			@Override
			public void execute() throws Exception
			{
				disableAll();

				try
				{
					esp.analyzeSourceCode();
					esp.close();
					eventGenerator.fireEvents(Event.APPLICATION_PARTS_UPDATED);
					esp.findAttacks();
					eventGenerator.fireEvents(Event.ATTACK_STEP_UPDATED, Event.ATTACK_PATH_UPDATED);
					esp.findProtections();
					eventGenerator.fireEvents(Event.PROTECTIONS_UPDATED);
					esp.findFirstLevelProtections();
					int secondLevelSolutionLimit = esp.getModel().getPreferences().getL2pSolutionsCount();
					if (secondLevelSolutionLimit > esp.getModel().getSolutions().size())
						secondLevelSolutionLimit = esp.getModel().getSolutions().size();
					for (int i = 0; i < secondLevelSolutionLimit; i++)
						esp.findSecondLevelProtections(esp.getModel().getSolutions().get(i));
					eventGenerator.fireEvents(Event.APPLICATION_PARTS_UPDATED, Event.SOLUTIONS_UPDATED);
					esp.deploySolution(esp.getModel().getSolutions().get(0));
					esp.close();
				}
				finally
				{
					Display.getDefault().syncExec(new Runnable()
					{
						@Override
						public void run()
						{
							MessageDialog.openInformation(Display.getDefault().getActiveShell(), "ESP", "Solution deployment completed!");
						}
					});
				}
			}
		}));
	}

	/**
	 * Creates the step by step build section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createStepByStepBuildSection(IManagedForm managedForm) throws Exception
	{
		SectionPart stepByStepBuildSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR | Section.DESCRIPTION);
		managedForm.addPart(stepByStepBuildSectionPart);
		stepByStepBuildSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		stepByStepBuildSectionPart.getSection().setText("Step by Step Build");
		stepByStepBuildSectionPart.getSection().setDescription("Control each protection step individually");

		Composite stepByStepBuildComposite = new Composite(stepByStepBuildSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(stepByStepBuildComposite);
		managedForm.getToolkit().paintBordersFor(stepByStepBuildComposite);
		stepByStepBuildSectionPart.getSection().setClient(stepByStepBuildComposite);
		stepByStepBuildComposite.setLayout(new GridLayout(1, false));

		analyzeSourceCodeHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		analyzeSourceCodeHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		analyzeSourceCodeHyperlink.setText("Analyze the source code");
		analyzeSourceCodeHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/source.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		findAttacksHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		findAttacksHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		findAttacksHyperlink.setText("Find the attacks");
		findAttacksHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/attackPath.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		findProtectionsHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		findProtectionsHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		findProtectionsHyperlink.setText("Find the protections");
		findProtectionsHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/protection.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		findFirstLevelProtectionsHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		findFirstLevelProtectionsHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		findFirstLevelProtectionsHyperlink.setText("Find the first level protections");
		findFirstLevelProtectionsHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/solution.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		findSecondLevelProtectionsHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		findSecondLevelProtectionsHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		findSecondLevelProtectionsHyperlink.setText("Find the second level protections");
		findSecondLevelProtectionsHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/solution.png", "icons/build.png", IDecoration.BOTTOM_LEFT));

		deploySolutionghHyperlink = managedForm.getToolkit().createImageHyperlink(stepByStepBuildComposite, SWT.NONE);
		deploySolutionghHyperlink.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		deploySolutionghHyperlink.setText("Deploy a solution");
		deploySolutionghHyperlink
				.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/solution.png", "icons/deploy.png", IDecoration.BOTTOM_LEFT));

		updateEnables();

		analyzeSourceCodeHyperlink.addHyperlinkListener(createAdapter("Analyzing the source code", new Executable()
		{
			@Override
			public void execute() throws Exception
			{
				disableAll();

				esp.analyzeSourceCode();
				esp.close();
				eventGenerator.fireEvents(Event.APPLICATION_PARTS_UPDATED);
				updateEnables();
			}
		}));

		findAttacksHyperlink.addHyperlinkListener(createAdapter("Finding the attacks", new Executable()
		{
			@Override
			public void execute() throws Exception
			{
				disableAll();

				esp.findAttacks();
				esp.close();
				eventGenerator.fireEvents(Event.ATTACK_STEP_UPDATED, Event.ATTACK_PATH_UPDATED);
				updateEnables();
			}
		}));
		findProtectionsHyperlink.addHyperlinkListener(createAdapter("Finding the protections", new Executable()
		{
			@Override
			public void execute() throws Exception
			{
				disableAll();

				esp.findProtections();
				esp.close();
				eventGenerator.fireEvents(Event.PROTECTIONS_UPDATED, Event.APPLICATION_PARTS_UPDATED);
				updateEnables();
			}
		}));
		findFirstLevelProtectionsHyperlink.addHyperlinkListener(createAdapter("Finding the first level protections", new Executable()
		{
			@Override
			public void execute() throws Exception
			{
				disableAll();

				esp.findFirstLevelProtections();
				esp.close();
				eventGenerator.fireEvents(Event.SOLUTIONS_UPDATED);
				updateEnables();
			}
		}));
		findSecondLevelProtectionsHyperlink.addHyperlinkListener(createAdapter("Finding the second level protections", new Executable()
		{
			private Object[] solutions;

			@Override
			public void execute() throws Exception
			{
				disableAll();
				solutions = null;
				Display.getDefault().syncExec(new Runnable()
				{

					@Override
					public void run()
					{
						SolutionMultiSelectionDialog dialog = new SolutionMultiSelectionDialog(Display.getDefault().getActiveShell(),
								esp.getModel());
						dialog.setTitle("Solution Selection");
						dialog.setMessage("Select the solutions on which the second level protections must be evaluated:");
						if (dialog.open() == Window.OK)
							solutions = dialog.getResult();
					}
				});
				if (solutions != null)
					for (Object solution : solutions)
						esp.findSecondLevelProtections((Solution) solution);
				esp.close();
				eventGenerator.fireEvents(Event.APPLICATION_PARTS_UPDATED, Event.SOLUTIONS_UPDATED);
				updateEnables();
			}
		}));
		deploySolutionghHyperlink.addHyperlinkListener(createAdapter("Deploying the solution", new Executable()
		{
			private Solution solution;

			@Override
			public void execute() throws Exception
			{
				solution = null;
				disableAll();
				Display.getDefault().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						SolutionSelectionDialog dialog = new SolutionSelectionDialog(Display.getDefault().getActiveShell(),
								esp.getModel());
						dialog.setTitle("Solution Selection");
						dialog.setMessage("Select the solution to deploy:");
						if (dialog.open() == Window.OK)
							solution = (Solution) dialog.getResult()[0];
					}
				});
				if (solution != null)
				{
					try
					{
						esp.deploySolution(solution);
					}
					finally
					{
//						Display.getDefault().syncExec(new Runnable()
//						{
//							@Override
//							public void run()
//							{
//								MessageDialog.openInformation(Display.getDefault().getActiveShell(), "ESP",
//										"Solution deployment completed!");
//							}
//						});
					}
				}
				updateEnables();
			}
		}));
	}

	/**
	 * Disables all the various hyper-links.
	 */
	private void disableAll()
	{
		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				analyzeSourceCodeHyperlink.setEnabled(false);
				findAttacksHyperlink.setEnabled(false);
				findProtectionsHyperlink.setEnabled(false);
				findFirstLevelProtectionsHyperlink.setEnabled(false);
				findSecondLevelProtectionsHyperlink.setEnabled(false);
				deploySolutionghHyperlink.setEnabled(false);

				buildAllHyperlink.setEnabled(false);
			}
		});
	}

	/**
	 * Updates the enable state of the various hyper-links.
	 */
	private void updateEnables()
	{
		disableAll();

		Display.getDefault().syncExec(new Runnable()
		{
			@Override
			public void run()
			{
				analyzeSourceCodeHyperlink.setEnabled(esp.getModel().getApplicationParts().isEmpty());
				buildAllHyperlink.setEnabled(analyzeSourceCodeHyperlink.isEnabled());
				if (analyzeSourceCodeHyperlink.isEnabled())
					return;

				deploySplittingPatchAction.setEnabled(esp.getModel().getAttackPaths().isEmpty());
				findAttacksHyperlink.setEnabled(esp.getModel().getAttackPaths().isEmpty());
				createFakeAttackPathsAction.setEnabled(esp.getModel().getAttackPaths().isEmpty());
				if (findAttacksHyperlink.isEnabled())
					return;

				findProtectionsHyperlink.setEnabled(true);
				for (Protection i : esp.getModel().getAvailableProtections())
					for (AttackMitigation j : i.getMitigations())
						if (!j.getAttackPaths().isEmpty())
							findProtectionsHyperlink.setEnabled(false);
				if (findProtectionsHyperlink.isEnabled())
					return;

				computeMetricsAction.setEnabled(esp.getModel().getSolutions().isEmpty());
				computeCoefficientsAction.setEnabled(esp.getModel().getSolutions().isEmpty());
				findFirstLevelProtectionsHyperlink.setEnabled(esp.getModel().getSolutions().isEmpty());
				if (findFirstLevelProtectionsHyperlink.isEnabled())
					return;

				findSecondLevelProtectionsHyperlink.setEnabled(true);
				for (Solution sol : esp.getModel().getSolutions())
					if (sol.getFirstLevelSolution() != null)
					{
						findSecondLevelProtectionsHyperlink.setEnabled(false);
						break;
					}

				deploySolutionghHyperlink.setEnabled(true);
			}
		});
	}

	/**
	 * Creates an hyperlink adapter.
	 * @param name
	 *            The job name.
	 * @param executable
	 *            The executable.
	 * @return The hyperlink adapter.
	 **/
	private IHyperlinkListener createAdapter(final String name, final Executable executable)
	{
		return new HyperlinkAdapter()
		{
			@Override
			public void linkActivated(HyperlinkEvent e)
			{
				Job job = new Job(name)
				{
					@Override
					protected IStatus run(IProgressMonitor monitor)
					{
						try
						{
							executable.execute();
							return Status.OK_STATUS;
						}
						catch (Exception e)
						{
							e.printStackTrace();
							return Status.CANCEL_STATUS;
						}
					}
				};
				job.setUser(true);
				job.schedule();
			}
		};
	}

	/**
	 * Creates the ESP logo.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createLogo(IManagedForm managedForm) throws Exception
	{
		Label logoImage = managedForm.getToolkit().createLabel(managedForm.getForm().getBody(), "");
		logoImage.setImage(Eclipse.getImage(it.polito.security.esp.ui.Activator.PLUGIN_ID, "icons/logo.png"));
		logoImage.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 2, 1));
	}
}

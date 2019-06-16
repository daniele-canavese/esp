package it.polito.security.esp.ui.editors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import it.polito.security.esp.ESP;
import it.polito.security.esp.connectors.Runner;
import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.FitterType;
import it.polito.security.esp.kb.Level;
import it.polito.security.esp.kb.Preferences;
import it.polito.security.esp.ui.Activator;
import it.polito.security.esp.util.Eclipse;

/**
 * The preferences page.
 * @author Daniele Canavese
 **/
public class PreferencesPage extends FormPage
{
	/** The ESP. **/
	private ESP esp;

	/**
	 * Creates the page.
	 * @param editor
	 *            The parent editor.
	 * @param esp
	 *            The ESP.
	 * @param eventGenerator
	 *            The event generator.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public PreferencesPage(FormEditor editor, ESP esp) throws Exception
	{
		super(editor, "preferences", "Preferences");
		this.esp = esp;
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
			form.setText("Preferences");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/preferences.png"));
			form.getBody().setLayout(new GridLayout(2, false));

			createRemoteConnectionSection(managedForm);
			createCommandsSection(managedForm);
			createMetricsSection(managedForm);
			createParsingSection(managedForm);
			createAttackFinderSection(managedForm);
			createProtectionFinderSection(managedForm);
			createOverheadsSection(managedForm);
			createFirstLevelProtectionsSection(managedForm);
			createSecondLevelProtectionsSection(managedForm);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the remote connection section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createRemoteConnectionSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Remote connection");

		createCheckField(composite, "Remote connection",
				"Enables the remote connection if the whole ASPIRE tool-chain is available on another machine.",
				KbPackage.PREFERENCES__REMOTE_CONNECTION);
		createTextField(composite, "Remote host:", "Specifies the host IP address", KbPackage.PREFERENCES__REMOTE_HOST);
		createIntegerField(composite, 1, 65535, "Remote port:", "Specifies the host port number.", KbPackage.PREFERENCES__REMOTE_PORT);
		createTextField(composite, "Remote username:", "Specifies the username used for the remote connection.",
				KbPackage.PREFERENCES__REMOTE_USERNAME);
		createTextField(composite, "Remote password:", "Specifies the password used for the remote connection.",
				KbPackage.PREFERENCES__REMOTE_PASSWORD);
		createTextField(composite, "Remote server file separator:",
				"Specifies the file separator of the remote server.\nUsually \\ for Windows and / for UNIX.",
				KbPackage.PREFERENCES__REMOTE_FILE_SEPARATOR);

		final Button testButton = managedForm.getToolkit().createButton(composite, "Connection test...", SWT.NONE);
		testButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		testButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Job job = new Job("Connection test")
				{

					@Override
					protected IStatus run(IProgressMonitor monitor)
					{
						try
						{
							Runner r = new Runner(esp);
							final boolean ok = r.test();
							Display.getDefault().syncExec(new Runnable()
							{
								@Override
								public void run()
								{
									MessageBox box = new MessageBox(Display.getDefault().getActiveShell(),
											ok ? SWT.ICON_WORKING : SWT.ICON_ERROR);
									box.setText("ESP");
									if (ok)
										box.setMessage("Congratulations! Your remote connection seems working.");
									else
										box.setMessage("Oops! Something is not working.");
									box.open();
								}
							});
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}

						return Status.OK_STATUS;
					}
				};
				job.schedule();
			}
		});
	}

	/**
	 * Creates the commands section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createCommandsSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Commands");

		createTextField(composite, "ACTC command:", "Specifies the ACTC command.", KbPackage.PREFERENCES__COMMAND_ACTC);
		createTextField(composite, "Perl interpreter:", "Specifies the Perl interpreter.", KbPackage.PREFERENCES__COMMAND_PERL);
		createTextField(composite, "Local dot utility:", "Specifies the Dot utility.", KbPackage.PREFERENCES__COMMAND_DOT);
		createTextField(composite, "Tigress command:", "Specifies the Tigress command.", KbPackage.PREFERENCES__COMMAND_TIGRESS);
		createTextField(composite, "Cilly command:", "Specifies the Cilly command.", KbPackage.PREFERENCES__COMMAND_CILLY);
	}

	/**
	 * Creates the metrics section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createMetricsSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Metrics");

		createSignedCheckTextField(composite, "Coefficients file:", "Specifies the file containing the metrics estimantion coefficents.",
				KbPackage.PREFERENCES__METRICS_FILE);

		Composite computationGroup = createGroup(managedForm, composite, "Coefficients computation");
		createIntegerField(computationGroup, 1, Integer.MAX_VALUE, "Polynomial transformation degree:",
				"Sets the maximum polynomial transformation degree.", KbPackage.PREFERENCES__METRICS_TRANSFORMATION_DEGREE);
		createPreciseDoubleField(computationGroup, Double.MIN_VALUE, Double.MAX_VALUE, "Pseudo-inverse matrix computation sensitivity:",
				"Sets the sensitivity when computing the pseudo-inverse matrix.",
				KbPackage.PREFERENCES__METRICS_PSEUDO_INVERSE_SENSITIVITY);
		createPreciseDoubleField(computationGroup, Double.MIN_VALUE, Double.MAX_VALUE, "Derivative computation sensitivity:",
				"Sets the sensitivity when computing the derivatives.", KbPackage.PREFERENCES__METRICS_DERIVATIVE_SENSITIVITY);
		Map<String, FitterType> fitterMap = new LinkedHashMap<>();
		fitterMap.put("Linear fitter", FitterType.LINEAR);
		fitterMap.put("Non-linear fitter", FitterType.NON_LINEAR);
		fitterMap.put("Marquardt fitter", FitterType.MARQUARDT);
		createComboField(computationGroup, fitterMap, "Fitter type:", "Sets the fitter to use.", KbPackage.PREFERENCES__METRICS_FITTER);
		createIntegerField(computationGroup, 1, Integer.MAX_VALUE, "Non-linear fitter maximum iterations:",
				"Sets the maximum iterations of the non-linear fitter.", KbPackage.PREFERENCES__METRICS_NON_LINEAR_MAXIMUM_ITERATIONS);
		createPreciseDoubleField(computationGroup, Double.MIN_VALUE, Double.MAX_VALUE, "Non-linear fitter step size:",
				"Sets the step size of the non-linear fitter.", KbPackage.PREFERENCES__METRICS_NON_LINEAR_STEP_SIZE);
		createPreciseDoubleField(computationGroup, Double.MIN_VALUE, Double.MAX_VALUE, "Non-linear fitter minimum error:",
				"Sets the minimum error of the non-linear fitter.", KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_ERROR);
		createPreciseDoubleField(computationGroup, Double.MIN_VALUE, Double.MAX_VALUE, "Non-linear fitter minimum change:",
				"Sets the minimum change value of the non-linear fitter.", KbPackage.PREFERENCES__METRICS_NON_LINEAR_MINIMUM_CHANGE);
	}

	/**
	 * Creates the protection finder section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createProtectionFinderSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Protection Finder");

		Map<String, Level> levelMap = new LinkedHashMap<>();
		levelMap.put("Low", Level.LOW);
		levelMap.put("Medium", Level.MEDIUM);
		levelMap.put("High", Level.HIGH);
		createComboField(composite, levelMap, "Minimum allowed protection mitigation level:",
				"Unsound. Higher values increase the performance and decrease the accuracy.\n"
						+ "The ESP will use only the protections that have a high enough attack mitigation level.",
				KbPackage.PREFERENCES__PROTECTIONS_MINIMUM_ATTACK_MITIGATION);
		createIntegerField(composite, 0, Integer.MAX_VALUE, "Maximum number of attestators per protection instantiation:",
				"Specifies the maximum number of attestators created for a single protection instantiation.",
				KbPackage.PREFERENCES__MAX_ATTESTATORS_PER_PROTECTION_INSTANTIATION);
	}

	/**
	 * Creates the attack finder section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createAttackFinderSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Attack Finder");

		createCheckIntegerField(composite, 1, Integer.MAX_VALUE, "Time limit [seconds]:",
				"Unsound.\n" + "Specifies a time limit in seconds.\n"
						+ "Note that this is not a hard limit since the timeout is checked only once in a while during the computation.",
				KbPackage.PREFERENCES__ATTACKS_TIME_LIMIT);
		createIntegerField(composite, 0, Integer.MAX_VALUE, "Maximum search depth:",
				"Unsound.\n" + "Specifies the maximum search depth for the calll graph.", KbPackage.PREFERENCES__ATTACKS_MAXIMUM_DEPTH);
		createCheckField(composite, "Remove the included protection objectives",
				"Sound. Can increase the performance.\n"
						+ "Removes the protection objectives completely included in other protection objectives.",
				KbPackage.PREFERENCES__ATTACKS_INCLUDED_PROTECTION_OBJECTIVES_REMOVAL);
	}

	/**
	 * Creates the parsing section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createParsingSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Parsing");

		createCheckField(composite, "Parse headers",
				"Indicates if the ESP should also take into account the headers when analyzing the code.",
				KbPackage.PREFERENCES__PARSER_HEADER_PARSING);
		createCheckField(composite, "Ignore system files",
				"Indicates if the ESP should ignore the system files (e.g. stdio.h) when analyzing the code.",
				KbPackage.PREFERENCES__PARSER_SYSTEM_FILES_IGNORATION);
	}

	/**
	 * Creates the overheads section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createOverheadsSection(IManagedForm managedForm) throws Exception
	{
		Composite composite = createComposite(managedForm, "Overheads");

		createDoubleField(composite, 0.1, Double.MAX_VALUE, "Client time overhead [percentage]:",
				"Specifies the maximum allowed client time overhead in percentage w.r.t. the vanilla application.",
				KbPackage.PREFERENCES__CLIENT_TIME_OVERHEAD);
		createDoubleField(composite, 0.1, Double.MAX_VALUE, "Server time overhead [percentage]:",
				"Specifies the maximum allowed server time overhead in percentage w.r.t. the vanilla application.",
				KbPackage.PREFERENCES__SERVER_TIME_OVERHEAD);
		createIntegerField(composite, 1, Integer.MAX_VALUE, "Client memory overhead [bytes]:",
				"Specifies the maximum allowed client memory overhead in bytes w.r.t. the vanilla application.",
				KbPackage.PREFERENCES__CLIENT_MEMORY_OVERHEAD);
		createIntegerField(composite, 1, Integer.MAX_VALUE, "Server memory overhead [bytes]:",
				"Specifies the maximum allowed server memory overhead in bytes w.r.t. the vanilla application.",
				KbPackage.PREFERENCES__SERVER_MEMORY_OVERHEAD);
		createIntegerField(composite, 1, Integer.MAX_VALUE, "Network overhead [bytes in 24 hours]:",
				"Specifies the maximum allowed network overhead in bytes in 24 hours w.r.t. the vanilla application.",
				KbPackage.PREFERENCES__NETWORK_OVERHEAD);
	}

	/**
	 * Creates the first level protections section.
	 * @param managedForm
	 *            The managed form.
	 **/
	private void createFirstLevelProtectionsSection(final IManagedForm managedForm)
	{
		Composite composite = createComposite(managedForm, "First Level Protections");

		createIntegerField(composite, 1, Integer.MAX_VALUE, "Number of solutions to find:",
				"Sound.\n" + "Specifies the number of solutions to find.\n"
						+ "Note that, according to the pruning techniques, the number of extracted solutions may be less than this value.",
				KbPackage.PREFERENCES__L1P_SOLUTIONS_COUNT);

		Composite terminationGroup = createGroup(managedForm, composite, "Termination");
		createCheckIntegerField(terminationGroup, 1, Integer.MAX_VALUE, "Time limit [seconds]:",
				"Unsound.\n" + "Specifies a time limit in seconds.\n"
						+ "Note that this is not a hard limit since the timeout is checked only once in a while during the computation.",
				KbPackage.PREFERENCES__L1P_TIME_LIMIT);
		createCheckIntegerField(terminationGroup, 1, Integer.MAX_VALUE, "Solutions limit:",
				"Unsound.\n" + "Specifies the maximum number of solutions to explore.\n"
						+ "Note that, according to the pruning techniques, the number of explorable solutions may be less than this value.",
				KbPackage.PREFERENCES__L1P_SOLUTIONS_LIMIT);
		// createCheckDoubleField(terminationGroup, 0.1, 100, "Gap limit [percentage]:",
		// "Unsound.\n" + "Specifies the maximum gap limit.\n"
		// + "The gap is the relative distance between the scores of the current solution score and the best one.",
		// KbPackage.PREFERENCES__L1P_GAP_LIMIT);

		Composite constraintsGroup = createGroup(managedForm, composite, "Constraints");
		createCheckDoubleField(constraintsGroup, 0.1, 100, "Maximum client time overhead [percentage]:",
				"Specifies the maximum allowed percentage of the client time overhead.",
				KbPackage.PREFERENCES__L1P_CLIENT_TIME_OVERHEAD_PERCENTAGE);
		createCheckDoubleField(constraintsGroup, 0.1, 100, "Maximum server time overhead [percentage]:",
				"Specifies the maximum allowed percentage of the server time overhead.",
				KbPackage.PREFERENCES__L1P_SERVER_TIME_OVERHEAD_PERCENTAGE);
		createCheckDoubleField(constraintsGroup, 0.1, 100, "Maximum client memory overhead [percentage]:",
				"Specifies the maximum allowed percentage of the client memory overhead.",
				KbPackage.PREFERENCES__L1P_CLIENT_MEMORY_OVERHEAD_PERCENTAGE);
		createCheckDoubleField(constraintsGroup, 0.1, 100, "Maximum server memory overhead [percentage]:",
				"Specifies the maximum allowed percentage of the server memory overhead.",
				KbPackage.PREFERENCES__L1P_SERVER_MEMORY_OVERHEAD_PERCENTAGE);
		createCheckDoubleField(constraintsGroup, 0.1, 100, "Maximum network overhead [percentage]:",
				"Specifies the maximum allowed percentage of the server memory overhead.",
				KbPackage.PREFERENCES__L1P_NETWORK_OVERHEAD_PERCENTAGE);
		createCheckField(constraintsGroup, "Ignore the solutions with some discouraged protection precedences",
				"Unsound. Can increase the performance.\n"
						+ "The ESP will skip the solutions with at least one discouraged protection precedence.",
				KbPackage.PREFERENCES__L1P_DISCOURAGED_PRECEDENCES_IGNORATION);
		createCheckField(constraintsGroup, "Focus on the solutions with only encouraged protection precedences",
				"Unsound. Can increase the performance.\n"
						+ "The ESP will take into account only the solutions containing only encouraged protection precedences.",
				KbPackage.PREFERENCES__L1P_ENCOURAGED_PRECEDENCES_FOCUSING);
		// createCheckField(constraintsGroup, "Use the protection precedences of the ACTC",
		// "Unsound. Can decrease the performance.\n"
		// + "The ESP will ignore all the solutions containing protection permutations undeployable by the ACTC.",
		// KbPackage.PREFERENCES__L1P_USE_ACTC_PRECEDENCES);
		// createCheckField(constraintsGroup, "Ignore the application part order",
		// "Unsound. Can decrease the performance.\n"
		// + "The ESP will ignore all the solutions containing application part permutations undeployable by the ACTC.",
		// KbPackage.PREFERENCES__L1P_IGNORE_APPLICATION_PART_ORDER);
		createIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Maximum number of protection instantiations per protection objective:",
				"Unsound. Lower values increase the performance and decrease the accuracy.\n"
						+ "The ESP will use a maximum number of protection instantiations per protection objective.",
				KbPackage.PREFERENCES__L1P_MAXIMUM_INSTANTIATIONS_PER_PROTECTION_OBJECTIVE);
		createIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Main search maximum depth:",
				"Unsound. Lower values increase the performance and decrease the accuracy.\n"
						+ "The minimax main search tree will be explored until this depth is reached. It is a hard limit.",
				KbPackage.PREFERENCES__L1P_MAIN_SEARCH_MAXIMUM_DEPTH);

		Composite algorithmGroup = createGroup(managedForm, composite, "Algorithm");
		createCheckDoubleField(algorithmGroup, 1, Integer.MAX_VALUE, "Multi-tree multiplier:",
				"Unsound. Can significantly increase the performance at the cost of some accuracy.\n"
						+ "The ESP will independently perform a search on each code correlation set instead of a global one and use this value to multiply a set weight.",
				KbPackage.PREFERENCES__L1P_MULTI_TREE_MULTIPLIER);
		createCheckIntegerField(algorithmGroup, 1, Integer.MAX_VALUE, "Transposition table size",
				"Mostly sound. Higher values can increase the performance and the accuracy.\n"
						+ "The transposition table maximum size. Disable it to turn off the use of transposition tables.",
				KbPackage.PREFERENCES__L1P_TRANSPOSITION_TABLE_MAXIMUM_SIZE);
		createCheckNaNDoubleField(algorithmGroup, -Double.MAX_VALUE, Double.MAX_VALUE, "Initial alpha value",
				"Sound.\n" + "The initial value for the alpha (lower) bound. Disable for negative infinity.",
				KbPackage.PREFERENCES__L1P_INITIAL_ALPHA);
		createCheckNaNDoubleField(algorithmGroup, -Double.MAX_VALUE, Double.MAX_VALUE, "Initial beta value",
				"Sound.\n" + "The initial value for the beta (upper) bound. Disable for positive infinity.",
				KbPackage.PREFERENCES__L1P_INITIAL_BETA);
		createDoubleField(algorithmGroup, -Double.MAX_VALUE, Double.MAX_VALUE, "Research delta value",
				"Sound.\n" + "The value used to increase/decrease an alpha/beta bound if a search fails.",
				KbPackage.PREFERENCES__L1P_RESEARCH_DELTA);
		createCheckDoubleField(algorithmGroup, Double.MIN_VALUE, Double.MAX_VALUE, "Futility margin",
				"Unsound.\n" + "The futility margin value. Disable to turn off the futility pruning.",
				KbPackage.PREFERENCES__L1P_FUTILITY_MARGIN);
		createCheckDoubleField(algorithmGroup, Double.MIN_VALUE, Double.MAX_VALUE, "Extended futility margin",
				"Unsound.\n" + "The extended futility margin value. Disable to turn off the extended futility pruning.",
				KbPackage.PREFERENCES__L1P_EXTENDED_FUTILITY_MARGIN);
		createCheckDoubleField(algorithmGroup, Double.MIN_VALUE, Double.MAX_VALUE, "Razoring margin",
				"Unsound.\n" + "The razoring margin value. Disable to turn off the razoring pruning.",
				KbPackage.PREFERENCES__L1P_RAZORING_MARGIN);
	}

	/**
	 * Creates the second level protections section.
	 * @param managedForm
	 *            The managed form.
	 **/
	private void createSecondLevelProtectionsSection(final IManagedForm managedForm)
	{
		Composite composite = createComposite(managedForm, "Second Level Protections");

		createIntegerField(composite, 1, Integer.MAX_VALUE, "Number of solutions to find:",
				"Sound.\n" + "Specifies the number of solutions to find for each level 1 solution.\n"
						+ "Note that, according to the pruning techniques, the number of extracted solutions may be less than this value.",
				KbPackage.PREFERENCES__L2P_SOLUTIONS_COUNT);
		createCheckIntegerField(composite, 1, Integer.MAX_VALUE, "Seed:",
				"Specifies a seed for the function splitting. Disable to use a random value.",
				KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_SEED);
		// createCheckField(composite, "Use the metrics from the first level solution",
		// "Unsound.\n" + "Indicates if the metrics must be computed starting from the first level solution or the vanilla one.\n"
		// + "Using the first level solution is more accurate but requires an additional build.",
		// KbPackage.PREFERENCES__L2P_START_FROM_L1P_SOLUTION);

		Composite terminationGroup = createGroup(managedForm, composite, "Termination");
		createCheckIntegerField(terminationGroup, 1, Integer.MAX_VALUE, "Time limit [seconds]:",
				"Unsound.\n" + "Specifies a time limit in seconds.\n"
						+ "Note that this is not a hard limit since the timeout is checked only once in a while during the computation.",
				KbPackage.PREFERENCES__L2P_TIME_LIMIT);
		createCheckIntegerField(terminationGroup, 1, Integer.MAX_VALUE, "Solutions limit:",
				"Unsound.\n" + "Specifies the maximum number of solutions to explore.\n"
						+ "Note that, according to the pruning techniques, the number of explorable solutions may be less than this value.",
				KbPackage.PREFERENCES__L2P_SOLUTION_LIMIT);
		createCheckDoubleField(terminationGroup, 0.1, 100, "Gap limit [percentage]:",
				"Unsound.\n" + "Specifies the maximum gap limit.\n"
						+ "The gap is the relative distance between the scores of the current solution score and the best one.",
				KbPackage.PREFERENCES__L2P_GAP_LIMIT);

		Composite constraintsGroup = createGroup(managedForm, composite, "Constraints");
		createIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Maximum number of protection instantiations per application part:",

				"The ESP will use a maximum number of protection instantiations per application part.",
				KbPackage.PREFERENCES__L2P_UPPER_BOUND);
		createCheckIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Minimum code block length for splitting:",
				"The minimum length that a code block must have in order to be splitted. Disable to generate an application part for each block.",
				KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_MEDIUM_CODE_BLOCK_LENGTH);
		createCheckIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Splitting randomization denominator:",
				"Specifies the length of the new code regions, which will be a random value in minimumCodeBlockLength ± minimumCodeBlockLength/codeBlockLengthRandomizationDenominator. Disable to generate all the blocks with minimumCodeBlockLength lines.",
				KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_CODE_BLOCK_LENGTH_RANDOMIZATION_DENOMINATOR);
		createCheckIntegerField(constraintsGroup, 1, Integer.MAX_VALUE, "Splitting depth level:",
				"Specifies the function splitting depth level. Disable for no limit.",
				KbPackage.PREFERENCES__L2P_FUNCTION_SPLITTING_DEPTH_LEVEL);
	}

	/**
	 * Creates a composite for hosting the fields.
	 * @param managedForm
	 *            The managed form.
	 * @param title
	 *            The section title.
	 * @return
	 */
	private Composite createComposite(IManagedForm managedForm, String title)
	{
		SectionPart part = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(), ExpandableComposite.TITLE_BAR);
		managedForm.addPart(part);
		part.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		part.getSection().setText(title);

		Composite composite = new Composite(part.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(composite);
		managedForm.getToolkit().paintBordersFor(composite);
		part.getSection().setClient(composite);
		composite.setLayout(new GridLayout(2, false));
		return composite;
	}

	/**
	 * Creates a group for hosting the fields.
	 * @param managedForm
	 *            The managed form.
	 * @param parent
	 *            The parent composite.
	 * @param title
	 *            The section title.
	 * @return
	 */
	private Composite createGroup(IManagedForm managedForm, Composite parent, String title)
	{
		SectionPart part = new SectionPart(parent, managedForm.getToolkit(), ExpandableComposite.SHORT_TITLE_BAR);
		managedForm.addPart(part);
		part.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		part.getSection().setText(title);

		Composite composite = new Composite(part.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(composite);
		managedForm.getToolkit().paintBordersFor(composite);
		part.getSection().setClient(composite);
		composite.setLayout(new GridLayout(2, false));
		return composite;
	}

	/**
	 * Creates a check field.
	 * @param composite
	 *            The parent composite.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createCheckField(Composite composite, String description, String tooltip, int featureId)
	{
		final Button button = new Button(composite, SWT.CHECK);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		button.setText(description);
		button.setToolTipText(tooltip);

		final Preferences preferences = esp.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		boolean value = (boolean) preferences.eGet(feature);
		button.setSelection(value);

		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				preferences.eSet(feature, button.getSelection());
			}
		});
	}

	/**
	 * Creates a text field.
	 * @param composite
	 *            The parent composite.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createTextField(Composite composite, String description, String tooltip, int featureId)
	{
		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		label.setText(description);
		label.setToolTipText(tooltip);

		final Text text = new Text(composite, SWT.NONE);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setToolTipText(tooltip);

		final Preferences preferences = esp.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		String value = (String) preferences.eGet(feature);
		text.setText(value);

		text.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, text.getText());
			}
		});
	}

	/**
	 * Creates a text field that can be enabled or disabled. If the control is disabled, the first character of the string is -, otherwise
	 * it is +.
	 * @param composite
	 *            The parent composite.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createSignedCheckTextField(Composite composite, String description, String tooltip, int featureId)
	{
		final Button button = new Button(composite, SWT.CHECK);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText(description);
		button.setToolTipText(tooltip);

		final Text text = new Text(composite, SWT.NONE);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setToolTipText(tooltip);

		final Preferences preferences = esp.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		String value = (String) preferences.eGet(feature);
		button.setSelection(value.startsWith("+"));
		text.setEnabled(button.getSelection());
		text.setText(value.substring(1));

		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				text.setEnabled(button.getSelection());
				if (button.getSelection())
					preferences.eSet(feature, "+" + text.getText());
				else
					preferences.eSet(feature, "-" + text.getText());
			}
		});
		text.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				if (button.getSelection())
					preferences.eSet(feature, "+" + text.getText());
				else
					preferences.eSet(feature, "-" + text.getText());
			}
		});
	}

	/**
	 * Creates an integer field.
	 * @param composite
	 *            The parent composite.
	 * @param min
	 *            The minimum allowed value.
	 * @param max
	 *            The maximum allowed value.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createIntegerField(Composite composite, int min, int max, String description, String tooltip, int featureId)
	{
		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		label.setText(description);
		label.setToolTipText(tooltip);

		final Spinner spinner = new Spinner(composite, SWT.NONE);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		spinner.setMinimum(min);
		spinner.setMaximum(max);
		spinner.setToolTipText(tooltip);

		final Preferences preferences = esp.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		Integer value = (Integer) preferences.eGet(feature);
		spinner.setSelection(value);

		spinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, spinner.getSelection());
			}
		});
	}

	/**
	 * Creates an integer field that can be enabled or disabled. If the control is disabled, the internal value is set to a non-positive
	 * value.
	 * @param composite
	 *            The parent composite.
	 * @param min
	 *            The minimum allowed value.
	 * @param max
	 *            The maximum allowed value.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createCheckIntegerField(Composite composite, int min, int max, String description, String tooltip, int featureId)
	{
		final Button button = new Button(composite, SWT.CHECK);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText(description);
		button.setToolTipText(tooltip);

		final Spinner spinner = new Spinner(composite, SWT.NONE);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		spinner.setMinimum(min);
		spinner.setMaximum(max);
		spinner.setToolTipText(tooltip);

		final Preferences preferences = esp.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		Integer value = (Integer) preferences.eGet(feature);
		button.setSelection(value > 0);
		spinner.setEnabled(button.getSelection());
		spinner.setSelection(Math.abs(value));

		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				spinner.setEnabled(button.getSelection());
				if (button.getSelection())
					preferences.eSet(feature, spinner.getSelection());
				else
					preferences.eSet(feature, -spinner.getSelection());
			}
		});
		spinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, spinner.getSelection());
			}
		});
	}

	/**
	 * Creates a combo field.
	 * @param <T>
	 *            The enum to use.
	 * @param composite
	 *            The parent composite.
	 * @param names
	 *            The combo-box names.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param values
	 *            The value enum.
	 * @param featureId
	 *            The related feature ID.
	 */
	private <T> void createComboField(Composite composite, final Map<String, T> values, String description, String tooltip, int featureId)
	{
		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		label.setText(description);
		label.setToolTipText(tooltip);

		final Combo combo = new Combo(composite, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		combo.setItems(values.keySet().toArray(new String[] {}));
		combo.setToolTipText(tooltip);

		final Preferences preferences = esp.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		@SuppressWarnings("unchecked")
		T value = (T) preferences.eGet(feature);
		for (Entry<String, T> i : values.entrySet())
			if (i.getValue() == value)
				combo.setText(i.getKey());

		combo.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, values.get(combo.getText()));
			}
		});
	}

	/**
	 * Creates a double field that can be enabled or disabled. If the control is disabled, the internal value is set to a non-positive.
	 * @param composite
	 *            The parent composite.
	 * @param min
	 *            The minimum allowed value.
	 * @param max
	 *            The maximum allowed value.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createCheckDoubleField(Composite composite, double min, double max, String description, String tooltip, int featureId)
	{
		final Button button = new Button(composite, SWT.CHECK);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText(description);
		button.setToolTipText(tooltip);

		final Spinner spinner = new Spinner(composite, SWT.NONE);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		spinner.setMinimum((int) (min * 1000));
		spinner.setMaximum((int) (max * 1000));
		spinner.setDigits(3);
		spinner.setIncrement(100);
		spinner.setToolTipText(tooltip);

		final Preferences preferences = esp.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		Double value = (Double) preferences.eGet(feature);
		button.setSelection(value > 0);
		spinner.setEnabled(button.getSelection());
		spinner.setSelection(Math.abs((int) (value * 1000)));

		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				spinner.setEnabled(button.getSelection());
				if (button.getSelection())
					preferences.eSet(feature, ((double) spinner.getSelection()) / 1000);
				else
					preferences.eSet(feature, -((double) spinner.getSelection()) / 1000);
			}
		});
		spinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, ((double) spinner.getSelection()) / 1000);
			}
		});
	}

	/**
	 * Creates a double field that can be enabled or disabled. If the control is disabled, the internal value is set to NaN.
	 * @param composite
	 *            The parent composite.
	 * @param min
	 *            The minimum allowed value.
	 * @param max
	 *            The maximum allowed value.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createCheckNaNDoubleField(Composite composite, double min, double max, String description, String tooltip, int featureId)
	{
		final Button button = new Button(composite, SWT.CHECK);
		button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		button.setText(description);
		button.setToolTipText(tooltip);

		final Spinner spinner = new Spinner(composite, SWT.NONE);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		spinner.setMinimum((int) (min * 1000));
		spinner.setMaximum((int) (max * 1000));
		spinner.setDigits(3);
		spinner.setIncrement(100);
		spinner.setToolTipText(tooltip);

		final Preferences preferences = esp.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		Double value = (Double) preferences.eGet(feature);
		button.setSelection(!Double.isNaN(value));
		spinner.setEnabled(button.getSelection());
		if (button.getSelection())
			spinner.setSelection((int) (value * 1000));
		else
			spinner.setSelection(0);

		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				spinner.setEnabled(button.getSelection());
				if (button.getSelection())
					preferences.eSet(feature, ((double) spinner.getSelection()) / 1000.0);
				else
					preferences.eSet(feature, Double.NaN);
			}
		});
		spinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, ((double) spinner.getSelection()) / 1000.0);
			}
		});
	}

	/**
	 * Creates a double field.
	 * @param composite
	 *            The parent composite.
	 * @param min
	 *            The minimum allowed value.
	 * @param max
	 *            The maximum allowed value.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createDoubleField(Composite composite, double min, double max, String description, String tooltip, int featureId)
	{
		Label label = new Label(composite, SWT.CHECK);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		label.setText(description);
		label.setToolTipText(tooltip);

		final Spinner spinner = new Spinner(composite, SWT.NONE);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		spinner.setMinimum((int) (min * 1000));
		spinner.setMaximum((int) (max * 1000));
		spinner.setDigits(3);
		spinner.setIncrement(100);
		spinner.setToolTipText(tooltip);

		final Preferences preferences = esp.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		Double value = (Double) preferences.eGet(feature);
		spinner.setSelection((int) (value * 1000));

		spinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, ((double) spinner.getSelection()) / 1000);
			}
		});
	}

	/**
	 * Creates a double field with some extra precision.
	 * @param composite
	 *            The parent composite.
	 * @param min
	 *            The minimum allowed value.
	 * @param max
	 *            The maximum allowed value.
	 * @param description
	 *            The field description.
	 * @param tooltip
	 *            The tool-tip description.
	 * @param featureId
	 *            The related feature ID.
	 */
	private void createPreciseDoubleField(Composite composite, double min, double max, String description, String tooltip, int featureId)
	{
		Label label = new Label(composite, SWT.CHECK);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		label.setText(description);
		label.setToolTipText(tooltip);

		final Spinner spinner = new Spinner(composite, SWT.NONE);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		spinner.setMinimum((int) (min * 1000000000));
		spinner.setMaximum((int) (max * 1000000000));
		spinner.setDigits(9);
		spinner.setIncrement(1);
		spinner.setToolTipText(tooltip);

		final Preferences preferences = esp.getModel().getPreferences();
		final EStructuralFeature feature = preferences.eClass().getEStructuralFeature(featureId);
		Double value = (Double) preferences.eGet(feature);
		spinner.setSelection((int) (value * 1000000000));

		spinner.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				preferences.eSet(feature, ((double) spinner.getSelection()) / 1000000000);
			}
		});
	}
}

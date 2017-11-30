package it.polito.security.esp.ui.editors;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IEditableRule;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.editor.TextCellEditor;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.LayerUtil;
import org.eclipse.nebula.widgets.nattable.layer.cell.IConfigLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.AttackMitigation;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.AttackStep;
import it.polito.security.esp.kb.Level;
import it.polito.security.esp.ui.Activator;
import it.polito.security.esp.ui.DotWriter;
import it.polito.security.esp.ui.NoteWidget;
import it.polito.security.esp.ui.dialogs.ImageDialog;
import it.polito.security.esp.ui.listeners.ESPEventGenerator;
import it.polito.security.esp.ui.listeners.ESPEventListener;
import it.polito.security.esp.ui.listeners.Event;
import it.polito.security.esp.ui.nattables.ESPNatTable;
import it.polito.security.esp.ui.nattables.AllExpansionModel;
import it.polito.security.esp.ui.nattables.ListFormat;
import it.polito.security.esp.util.Eclipse;

/**
 * The attacks page.
 * @author Daniele Canavese
 **/
public class AttacksPage extends FormPage implements ESPEventListener
{
	/** The ESP. **/
	private ESP esp;
	/** The attack paths nattable. **/
	private ESPNatTable<AttackPath> pathsTreeNatTable;
	/** The attack steps nattable. **/
	private ESPNatTable<AttackStep> stepsTreeNatTable;
	/** The event generator. **/
	private ESPEventGenerator eventGenerator;
	/** The form. **/
	private ScrolledForm form;

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
	public AttacksPage(FormEditor editor, ESP esp, ESPEventGenerator eventGenerator) throws Exception
	{
		super(editor, "attacks", "Attacks");
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
			form = managedForm.getForm();
			managedForm.getToolkit().paintBordersFor(form);
			form.setText("Attacks");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/attackPath.png"));
			form.getBody().setLayout(new GridLayout());

			SummarySection summarySection = new SummarySection(esp, managedForm, LabelType.ATTACK_PATHS);
			eventGenerator.addListener(summarySection);
			managedForm.addPart(summarySection);
			createAttackPathsSection(managedForm);
			createAttackStepsSection(managedForm);

			form.getToolBarManager()
					.add(new Action("View the attack graph...", Eclipse.getImageDescriptor(Activator.PLUGIN_ID, "icons/view.png"))
					{
						@Override
						public void run()
						{
							final Image image = getAttackGraph();
							Display.getDefault().syncExec(new Runnable()
							{
								@Override
								public void run()
								{
									ImageDialog dialog = new ImageDialog(Display.getDefault().getActiveShell(), image);
									dialog.open();
								}
							});
						}
					});
			form.getToolBarManager().update(true);

			eventGenerator.addListener(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the attack steps section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createAttackStepsSection(final IManagedForm managedForm) throws Exception
	{
		SectionPart attackStepsSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(attackStepsSectionPart);
		attackStepsSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		attackStepsSectionPart.getSection().setText("Attack Steps");

		Composite attackStepsComposite = new Composite(attackStepsSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(attackStepsComposite);
		managedForm.getToolkit().paintBordersFor(attackStepsComposite);
		attackStepsSectionPart.getSection().setClient(attackStepsComposite);
		attackStepsComposite.setLayout(new GridLayout());

		String[] propertyNames = new String[] { "name", "type" };
		Map<String, String> propertyToLabelMap = new HashMap<>();
		propertyToLabelMap.put("name", "Name");
		propertyToLabelMap.put("type", "Type");

		stepsTreeNatTable = new ESPNatTable<>(attackStepsComposite, esp.getModel().getAttackSteps(), propertyNames, propertyToLabelMap,
				new ListFormat<AttackStep>(), new AllExpansionModel<AttackStep>(false));

		stepsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(0, 70);
		stepsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(1, 30);

		stepsTreeNatTable.getBodyDataLayer().setConfigLabelAccumulator(new IConfigLabelAccumulator()
		{
			@Override
			public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition)
			{
				if (columnPosition == 0)
					configLabels.addLabel("attackStep");
				else if (columnPosition == 2)
					configLabels.addLabel("formula");
			}
		});

		stepsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITABLE_RULE,
				IEditableRule.ALWAYS_EDITABLE, DisplayMode.EDIT, "formula");
		stepsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, new TextCellEditor(),
				DisplayMode.EDIT, "formula");
		stepsTreeNatTable.getConfigRegistry().registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, new DefaultDisplayConverter()
		{
			@Override
			public Object displayToCanonicalValue(Object destinationValue)
			{
				if (destinationValue == null || destinationValue.toString().isEmpty())
					return "";
				else
					return super.displayToCanonicalValue(destinationValue);
			}
		}, DisplayMode.EDIT, "formula");

		GridDataFactory.fillDefaults().grab(true, true).applyTo(stepsTreeNatTable);
	}

	/**
	 * Creates the attack paths section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createAttackPathsSection(final IManagedForm managedForm) throws Exception
	{
		final SectionPart attackPathsSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(attackPathsSectionPart);
		attackPathsSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		attackPathsSectionPart.getSection().setText("Attack Paths");

		Composite attackPathsComposite = new Composite(attackPathsSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(attackPathsComposite);
		managedForm.getToolkit().paintBordersFor(attackPathsComposite);
		attackPathsSectionPart.getSection().setClient(attackPathsComposite);
		attackPathsComposite.setLayout(new GridLayout());

		NoteWidget noteWidget = new NoteWidget(attackPathsComposite, "Double click an item for more information.");
		noteWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		String[] propertyNames = new String[] { "id", "attackSteps", "protectionObjectives", "level", "mitigations" };
		Map<String, String> propertyToLabelMap = new HashMap<>();
		propertyToLabelMap.put("id", "ID");
		propertyToLabelMap.put("attackSteps", "Attack steps");
		propertyToLabelMap.put("protectionObjectives", "Targets");
		propertyToLabelMap.put("level", "Maximum Mitigation");
		propertyToLabelMap.put("mitigations", "Protections");

		pathsTreeNatTable = new ESPNatTable<>(attackPathsComposite, esp.getModel().getAttackPaths(), propertyNames, propertyToLabelMap,
				new ListFormat<AttackPath>(), new AllExpansionModel<AttackPath>(false));

		pathsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(0, 10);
		pathsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(1, 45);
		pathsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(2, 20);
		pathsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(3, 5);
		pathsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(4, 20);

		pathsTreeNatTable.getBodyDataLayer().setConfigLabelAccumulator(new IConfigLabelAccumulator()
		{
			@Override
			public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition)
			{
				AttackPath path = pathsTreeNatTable.getBodyDataProvider().getRowObject(rowPosition);

				if (columnPosition == 0)
					configLabels.addLabel("attackPath");
				if (columnPosition == 4)
					configLabels.addLabel("mitigationsBadges");

				if (path.getLevel() == Level.NONE)
					configLabels.addLabel("dangerLevel");
				else if (path.getLevel() == Level.LOW)
					configLabels.addLabel("lowLevel");
				else if (path.getLevel() == Level.MEDIUM)
					configLabels.addLabel("mediumLevel");
				else if (path.getLevel() == Level.HIGH)
					configLabels.addLabel("highLevel");
			}
		});

		GridDataFactory.fillDefaults().grab(true, true).applyTo(pathsTreeNatTable);

		pathsTreeNatTable.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseDoubleClick(MouseEvent e)
			{
				int rowPos = pathsTreeNatTable.getRowPositionByY(e.y);
				if (rowPos > 1)
				{
					int bodyRowPos = LayerUtil.convertRowPosition(pathsTreeNatTable, rowPos, pathsTreeNatTable.getBodyDataLayer());
					AttackPath path = pathsTreeNatTable.getBodyDataProvider().getRowObject(bodyRowPos);

					final Image image = getMitigationExplanationGraph(path);
					Display.getDefault().syncExec(new Runnable()
					{
						@Override
						public void run()
						{
							ImageDialog dialog = new ImageDialog(Display.getDefault().getActiveShell(), image);
							dialog.open();
						}
					});
				}
			}
		});
	}

	/**
	 * Computes the mitigation graph for an attack path.
	 * @param attackPath
	 *            The attack path.
	 * @return The image.
	 **/
	private Image getMitigationExplanationGraph(AttackPath attackPath)
	{
		Collection<Object> vertexes = new HashSet<>();
		vertexes.addAll(attackPath.getAttackSteps());
		vertexes.addAll(attackPath.getAppliedProtectionInstantiations());

		Map<Entry<Object, Object>, String> edges = new HashMap<>();
		AttackStep lastStep = null;
		for (AttackStep i : attackPath.getAttackSteps())
			if (lastStep == null)
				lastStep = i;
			else
			{
				edges.put(new AbstractMap.SimpleEntry<Object, Object>(lastStep, i), null);
				lastStep = i;
			}
		for (AppliedProtectionInstantiation i : attackPath.getAppliedProtectionInstantiations())
			for (AttackMitigation j : i.getAttackMitigations())
				for (AttackStep k : attackPath.getAttackSteps())
					if (k.getType() == j.getType())
						edges.put(new AbstractMap.SimpleEntry<Object, Object>(i, k), j.getLevel().toString());

		DotWriter<Object> dotWriter = new DotWriter<>(esp, vertexes, edges);
		Image image = dotWriter.toImage();

		return image;
	}

	/**
	 * Computes the attack graph.
	 * @return The image.
	 **/
	private Image getAttackGraph()
	{
		Map<Entry<AttackStep, AttackStep>, String> edges = new HashMap<>();

		for (AttackPath i : esp.getModel().getAttackPaths())
		{
			AttackStep lastStep = null;
			for (AttackStep j : i.getAttackSteps())
				if (lastStep == null)
					lastStep = j;
				else
				{
					edges.put(new AbstractMap.SimpleEntry<AttackStep, AttackStep>(lastStep, j), null);
					lastStep = j;
				}
		}

		DotWriter<AttackStep> dotWriter = new DotWriter<>(esp, esp.getModel().getAttackSteps(), edges);
		Image image = dotWriter.toImage();

		return image;
	}

	/**
	 * Handles an event.
	 * @param event
	 *            The event.
	 **/
	@Override
	public void handleEvent(final Event event)
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run()
			{
				if (event == Event.ATTACK_PATH_UPDATED || event == Event.PROTECTIONS_UPDATED)
					pathsTreeNatTable.update(esp.getModel().getAttackPaths());
				else if (event == Event.ATTACK_STEP_UPDATED)
					stepsTreeNatTable.update(esp.getModel().getAttackSteps());
			}
		});
	}
}

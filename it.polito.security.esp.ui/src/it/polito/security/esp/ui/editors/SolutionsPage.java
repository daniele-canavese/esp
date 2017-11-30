package it.polito.security.esp.ui.editors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.LayerUtil;
import org.eclipse.nebula.widgets.nattable.layer.cell.IConfigLabelAccumulator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
import it.polito.security.esp.kb.Solution;
import it.polito.security.esp.ui.Activator;
import it.polito.security.esp.ui.NoteWidget;
import it.polito.security.esp.ui.dialogs.KeyValueDialog;
import it.polito.security.esp.ui.dialogs.Pair;
import it.polito.security.esp.ui.listeners.ESPEventGenerator;
import it.polito.security.esp.ui.listeners.ESPEventListener;
import it.polito.security.esp.ui.listeners.Event;
import it.polito.security.esp.ui.nattables.ESPNatTable;
import it.polito.security.esp.ui.nattables.AllExpansionModel;
import it.polito.security.esp.ui.nattables.ListFormat;
import it.polito.security.esp.util.Eclipse;

/**
 * The solutions page.
 * @author Daniele Canavese
 **/
public class SolutionsPage extends FormPage implements ESPEventListener
{
	/** The ESP. **/
	private ESP esp;
	/** The event generator. **/
	private ESPEventGenerator eventGenerator;
	/** The form. **/
	private ScrolledForm form;
	/** The solutions nattable. **/
	private ESPNatTable<Solution> solutionsTreeNatTable;

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
	public SolutionsPage(FormEditor editor, ESP esp, ESPEventGenerator eventGenerator) throws Exception
	{
		super(editor, "solutions", "Solutions");
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
			form.setText("Solutions");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/solution.png"));
			form.getBody().setLayout(new GridLayout());

			SummarySection summarySection = new SummarySection(esp, managedForm, LabelType.ASSETS, LabelType.PROTECTIONS);
			eventGenerator.addListener(summarySection);
			managedForm.addPart(summarySection);
			createSolutionSection(managedForm);

			eventGenerator.addListener(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Creates the solutions section.
	 * @param managedForm
	 *            The managed form.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void createSolutionSection(final IManagedForm managedForm) throws Exception
	{
		SectionPart solutionsSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(solutionsSectionPart);
		solutionsSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		solutionsSectionPart.getSection().setText("Solutions");

		Composite solutionsComposite = new Composite(solutionsSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(solutionsComposite);
		managedForm.getToolkit().paintBordersFor(solutionsComposite);
		solutionsSectionPart.getSection().setClient(solutionsComposite);
		solutionsComposite.setLayout(new GridLayout());

		NoteWidget noteWidget = new NoteWidget(solutionsComposite, "Double click an item for more information.");
		noteWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		String[] propertyNames = new String[] { "id", "solutionSequences", "l1pScore" };
		Map<String, String> propertyToLabelMap = new HashMap<>();
		propertyToLabelMap.put("id", "ID");
		propertyToLabelMap.put("solutionSequences", "Sequences");
		propertyToLabelMap.put("l1pScore", "Protection Index");

		solutionsTreeNatTable = new ESPNatTable<>(solutionsComposite, esp.getModel().getSolutions(), propertyNames, propertyToLabelMap,
				new ListFormat<Solution>(), new AllExpansionModel<Solution>(false));

		solutionsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(0, 15);
		solutionsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(1, 75);
		solutionsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(2, 10);

		solutionsTreeNatTable.getBodyDataLayer().setConfigLabelAccumulator(new IConfigLabelAccumulator()
		{
			@Override
			public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition)
			{
				if (columnPosition == 0)
					configLabels.addLabel("solution");
			}
		});

		GridDataFactory.fillDefaults().grab(true, true).applyTo(solutionsTreeNatTable);

		solutionsTreeNatTable.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseDoubleClick(MouseEvent e)
			{
				int rowPos = solutionsTreeNatTable.getRowPositionByY(e.y);
				if (rowPos > 1)
				{
					int bodyRowPos = LayerUtil.convertRowPosition(solutionsTreeNatTable, rowPos, solutionsTreeNatTable.getBodyDataLayer());
					Solution solution = solutionsTreeNatTable.getBodyDataProvider().getRowObject(bodyRowPos);

					List<Pair<?, ?>> pairs = new ArrayList<>();
					pairs.add(new Pair<>("L1P computation time", String.format("%.3f seconds", solution.getL1pTime())));
					pairs.add(new Pair<>("L1P predicted attack paths", solution.getAttackPaths()));
					pairs.add(new Pair<>("L1P score (protection index)", String.format("%.3f", solution.getL1pScore())));
					pairs.add(new Pair<>("L2P score", String.format("%.3f", solution.getL2pScore())));
					pairs.add(new Pair<>("L2P computation time", String.format("%.3f seconds", solution.getL2pTime())));
					pairs.add(new Pair<>("Client time overhead", String.format("%+.3f%%", solution.getClientTimeOverhead() * 100)));
					pairs.add(new Pair<>("Server time overhead", String.format("%+.3f%%", solution.getServerTimeOverhead() * 100)));
					pairs.add(new Pair<>("Client memory overhead", String.format("%+.0f bytes", solution.getClientMemoryOverhead())));
					pairs.add(new Pair<>("Server memory overhead", String.format("%+.0f bytes", solution.getServerMemoryOverhead())));
					pairs.add(new Pair<>("Network overhead", String.format("%+.3f bytes in 24 hours", solution.getNetworkOverhead())));
					KeyValueDialog dialog = new KeyValueDialog(solutionsTreeNatTable.getShell(), "Solution: " + solution.getId(), pairs);
					dialog.open();
				}
			}
		});
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
				if (event == Event.SOLUTIONS_UPDATED)
					solutionsTreeNatTable.update(esp.getModel().getSolutions());
			}
		});
	}
}

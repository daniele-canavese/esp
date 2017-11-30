package it.polito.security.esp.ui.editors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.IEditableRule;
import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultDoubleDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.validate.DataValidator;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.command.UpdateDataCommand;
import org.eclipse.nebula.widgets.nattable.edit.editor.ComboBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.TextCellEditor;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.LayerUtil;
import org.eclipse.nebula.widgets.nattable.layer.cell.IConfigLabelAccumulator;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartType;
import it.polito.security.esp.ui.Activator;
import it.polito.security.esp.ui.NoteWidget;
import it.polito.security.esp.ui.dialogs.KeyValueDialog;
import it.polito.security.esp.ui.dialogs.Pair;
import it.polito.security.esp.ui.listeners.ESPEventGenerator;
import it.polito.security.esp.ui.listeners.ESPEventListener;
import it.polito.security.esp.ui.listeners.Event;
import it.polito.security.esp.ui.nattables.ESPNatTable;
import it.polito.security.esp.ui.nattables.ApplicationPartExpansionModel;
import it.polito.security.esp.ui.nattables.ApplicationPartFormat;
import it.polito.security.esp.ui.nattables.ApplicationPartUpdateDataCommandHandler;
import it.polito.security.esp.util.Eclipse;

/**
 * The assets page.
 * @author Daniele Canavese
 **/
public class AssetsPage extends FormPage implements ESPEventListener
{
	/** The ESP. **/
	private ESP esp;
	/** The event generator. **/
	private ESPEventGenerator eventGenerator;
	/** The application parts nattable. **/
	private ESPNatTable<ApplicationPart> partsTreeNatTable;
	/** The form. **/
	private ScrolledForm form;
	/** The column showing the weight of the assets. **/
	TreeViewerColumn weightViewerColumn;
	/** The assets checkbox. **/
	private Button assetsCheck;

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
	public AssetsPage(FormEditor editor, ESP esp, ESPEventGenerator eventGenerator) throws Exception
	{
		super(editor, "assets", "Assets");
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
			form.setText("Assets");
			form.setImage(Eclipse.getImage(Activator.PLUGIN_ID, "icons/applicationParts.png"));
			form.getBody().setLayout(new GridLayout());

			SummarySection summarySection = new SummarySection(esp, managedForm, LabelType.ASSETS);
			eventGenerator.addListener(summarySection);
			managedForm.addPart(summarySection);
			createApplicationPartsSection(managedForm);

			eventGenerator.addListener(this);
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
	private void createApplicationPartsSection(IManagedForm managedForm) throws Exception
	{
		SectionPart applicationPartsSectionPart = new SectionPart(managedForm.getForm().getBody(), managedForm.getToolkit(),
				ExpandableComposite.TITLE_BAR);
		managedForm.addPart(applicationPartsSectionPart);
		applicationPartsSectionPart.getSection().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		applicationPartsSectionPart.getSection().setText("Application Parts");

		Composite applicationPartsComposite = new Composite(applicationPartsSectionPart.getSection(), SWT.NONE);
		managedForm.getToolkit().adapt(applicationPartsComposite);
		managedForm.getToolkit().paintBordersFor(applicationPartsComposite);
		applicationPartsSectionPart.getSection().setClient(applicationPartsComposite);
		applicationPartsComposite.setLayout(new GridLayout());

		NoteWidget noteWidget = new NoteWidget(applicationPartsComposite, "Double click an item for more information:");
		noteWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		String[] propertyNames = new String[] { "name", "type", "shortLocation", "properties", "weight" };
		Map<String, String> propertyToLabelMap = new HashMap<>();
		propertyToLabelMap.put("name", "Name");
		propertyToLabelMap.put("type", "Type");
		propertyToLabelMap.put("shortLocation", "Source File : Line");
		propertyToLabelMap.put("properties", "Properties");
		propertyToLabelMap.put("weight", "Weight");

		partsTreeNatTable = new ESPNatTable<>(applicationPartsComposite, esp.getModel().getAllApplicationParts(), propertyNames,
				propertyToLabelMap, new ApplicationPartFormat(), new ApplicationPartExpansionModel());

		partsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(0, 30);
		partsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(1, 20);
		partsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(2, 30);
		partsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(3, 10);
		partsTreeNatTable.getBodyDataLayer().setColumnWidthPercentageByPosition(4, 10);

		partsTreeNatTable.getBodyDataLayer().setConfigLabelAccumulator(new IConfigLabelAccumulator()
		{
			@Override
			public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition)
			{
				ApplicationPart part = partsTreeNatTable.getBodyDataProvider().getRowObject(rowPosition);
				int depth = 0;
				ApplicationPart parent = part.getDeclaringCode();
				while (parent != null)
				{
					++depth;
					parent = parent.getDeclaringCode();
				}

				if (part.isAsset())
					configLabels.addLabel("asset");
				if (part.isDisabledAsset())
					configLabels.addLabel("disabledAsset");
				if ((part.isAsset() || part.isDisabledAsset()) && columnPosition == 0)
					configLabels.addLabel("assetBadge");
				if (part.isCode() && columnPosition == 0)
					configLabels.addLabel("code");
				else if (part.isDatum() && columnPosition == 0)
					configLabels.addLabel("datum");
				else if (columnPosition == 0)
					configLabels.addLabel("reference");
				configLabels.addLabel("depth:" + depth);
				if (columnPosition == 3)
					configLabels.addLabel("properties");
				else if (columnPosition == 4 && part.isAsset())
					configLabels.addLabel("weight");
				else if (columnPosition == 4 && !part.isAsset())
					configLabels.addLabel("empty");
			}
		});

		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITABLE_RULE,
				IEditableRule.ALWAYS_EDITABLE, DisplayMode.EDIT, "weight");
		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, new TextCellEditor(),
				DisplayMode.EDIT, "weight");
		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER,
				new DefaultDoubleDisplayConverter(), DisplayMode.EDIT, "weight");
		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.DATA_VALIDATOR, new DataValidator()
		{
			@Override
			public boolean validate(int columnIndex, int rowIndex, Object newValue)
			{
				if (newValue instanceof Double && ((Double) newValue) >= 0)
					return true;
				else
					return false;
			}
		}, DisplayMode.EDIT, "weight");

		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITABLE_RULE, new IEditableRule()
		{
			@Override
			public boolean isEditable(int columnIndex, int rowIndex)
			{

				return columnIndex == 3;
			}

			@Override
			public boolean isEditable(ILayerCell cell, IConfigRegistry configRegistry)
			{
				ListDataProvider<ApplicationPart> dataProvider = (ListDataProvider<ApplicationPart>) partsTreeNatTable
						.getBodyDataProvider();
				ApplicationPart part = dataProvider.getRowObject(cell.getRowIndex());

				return part.getType() != ApplicationPartType.FUNCTION;
			}
		}, DisplayMode.EDIT, "properties");
		List<String> securityProperties = new ArrayList<>();
		securityProperties.add("(no properties)");
		securityProperties.add("confidentiality");
		securityProperties.add("hard confidentiality");
		securityProperties.add("privacy");
		securityProperties.add("integrity");
		securityProperties.add("confidentiality, integrity");
		securityProperties.add("hard confidentiality, integrity");
		securityProperties.add("privacy, integrity");
		partsTreeNatTable.getConfigRegistry().registerConfigAttribute(EditConfigAttributes.CELL_EDITOR,
				new ComboBoxCellEditor(securityProperties, securityProperties.size()), DisplayMode.EDIT, "properties");

		partsTreeNatTable.getBodyDataLayer().unregisterCommandHandler(UpdateDataCommand.class);
		partsTreeNatTable.getBodyDataLayer().registerCommandHandler(
				new ApplicationPartUpdateDataCommandHandler(esp, eventGenerator, partsTreeNatTable.getBodyDataLayer()));

		GridDataFactory.fillDefaults().grab(true, true).applyTo(partsTreeNatTable);

		assetsCheck = new Button(applicationPartsComposite, SWT.CHECK);
		assetsCheck.setText("Assets only");
		assetsCheck.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		assetsCheck.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				if (assetsCheck.getSelection())
					partsTreeNatTable.update(esp.getModel().getAssets());
				else
					partsTreeNatTable.update(getInterestingParts());
			}
		});

		partsTreeNatTable.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseDoubleClick(MouseEvent e)
			{
				int rowPos = partsTreeNatTable.getRowPositionByY(e.y);
				if (rowPos > 1)
				{
					int bodyRowPos = LayerUtil.convertRowPosition(partsTreeNatTable, rowPos, partsTreeNatTable.getBodyDataLayer());
					ApplicationPart part = partsTreeNatTable.getBodyDataProvider().getRowObject(bodyRowPos);
					List<Pair<?, ?>> pairs = new ArrayList<>();
					pairs.add(new Pair<>("Body", part.getBody()));
					pairs.add(new Pair<>("Contains #ifdef", part.isContainsIfdef()));
					pairs.add(new Pair<>("Contained assets", part.getAssets()));
					pairs.add(new Pair<>("Contained parts", part.getApplicationParts()));
					pairs.add(new Pair<>("Declaring code", part.getDeclaringCode()));
					pairs.add(new Pair<>("Datum lower bound", part.getDatumLowerBound()));
					pairs.add(new Pair<>("Datum upper bound", part.getDatumUpperBound()));
					pairs.add(new Pair<>("End line", part.getEndLine()));
					pairs.add(new Pair<>("ID", part.getId()));
					pairs.add(new Pair<>("Index", part.getIndex()));
					pairs.add(new Pair<>("In system file", part.isInSystemFile()));
					pairs.add(new Pair<>("Name", part.getName()));
					pairs.add(new Pair<>("Parameters", part.getParameters()));
					pairs.add(new Pair<>("Properties", part.getProperties()));
					pairs.add(new Pair<>("Sets", part.getSets()));
					pairs.add(new Pair<>("Size", part.getDatumSize()));
					pairs.add(new Pair<>("Source file", part.getSourceFilePath()));
					pairs.add(new Pair<>("Start line", part.getStartLine()));
					pairs.add(new Pair<>("Targets", part.getTargetOf()));
					pairs.add(new Pair<>("Type", part.getType()));
					pairs.add(new Pair<>("Uses", part.getUses()));
					pairs.add(new Pair<>("Weight", part.getWeight()));
					KeyValueDialog dialog = new KeyValueDialog(partsTreeNatTable.getShell(), "Application part: " + part.getName(), pairs);
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
				if (event == Event.APPLICATION_PARTS_UPDATED)
				{
					if (assetsCheck.getSelection())
						partsTreeNatTable.update(esp.getModel().getAssets());
					else
						partsTreeNatTable.update(getInterestingParts());
				}
			}
		});
	}

	/**
	 * Retrieves only the "interesting" application parts.
	 * @return The interesting application parts.
	 **/
	private List<ApplicationPart> getInterestingParts()
	{
		List<ApplicationPart> parts = new ArrayList<>();
		for (ApplicationPart i : esp.getModel().getAllApplicationParts())
			if (i.isDatum() || i.isCode())
				parts.add(i);
		
		return parts;
	}
}

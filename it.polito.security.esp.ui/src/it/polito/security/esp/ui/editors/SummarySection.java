package it.polito.security.esp.ui.editors;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.ExpandableComposite;

import it.polito.security.esp.ESP;
import it.polito.security.esp.ui.Activator;
import it.polito.security.esp.ui.listeners.ESPEventListener;
import it.polito.security.esp.ui.listeners.Event;
import it.polito.security.esp.util.Eclipse;

/**
 * A summary section.
 * @author Daniele Canavese
 **/
public class SummarySection extends SectionPart implements ESPEventListener
{
	/** The labels mapping. **/
	private final Map<LabelType, CLabel> map;
	/** The ESP. **/
	private final ESP esp;

	/**
	 * Creates the section.
	 * @param esp
	 *            The ESP.
	 * @param form
	 *            The form.
	 * @param labels
	 *            The labels.
	 **/
	public SummarySection(ESP esp, IManagedForm form, LabelType... labels)
	{
		super(form.getForm().getBody(), form.getToolkit(), ExpandableComposite.TITLE_BAR);

		this.esp = esp;
		map = new HashMap<>();

		getSection().setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
		getSection().setText("Summary");

		Composite summaryComposite = new Composite(getSection(), SWT.NONE);
		form.getToolkit().adapt(summaryComposite);
		form.getToolkit().paintBordersFor(summaryComposite);
		getSection().setClient(summaryComposite);
		summaryComposite.setLayout(new ColumnLayout());

		for (LabelType i : labels)
			try
			{
				CLabel label = new CLabel(summaryComposite, SWT.NONE);
				label.setLayoutData(new ColumnLayoutData(ColumnLayoutData.FILL));
				label.setText(i.getString(esp.getModel()));
				label.setImage(Eclipse.getImage(Activator.PLUGIN_ID, i.getIcon()));
				map.put(i, label);
			}
			catch (MalformedURLException e)
			{
			}
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
				for (LabelType i : map.keySet())
					if (event == i.getEvent())
						map.get(i).setText(i.getString(esp.getModel()));
			}
		});
	}
}

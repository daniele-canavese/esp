package it.polito.security.esp.ui.nattables;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.nebula.widgets.nattable.data.ListDataProvider;
import org.eclipse.nebula.widgets.nattable.edit.command.UpdateDataCommand;
import org.eclipse.nebula.widgets.nattable.edit.command.UpdateDataCommandHandler;
import org.eclipse.nebula.widgets.nattable.layer.DataLayer;
import org.eclipse.nebula.widgets.nattable.layer.event.CellVisualChangeEvent;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.Property;
import it.polito.security.esp.ui.listeners.ESPEventGenerator;
import it.polito.security.esp.ui.listeners.Event;

/**
 * The application part data command handler.
 * @author Daniele Canavese
 **/
public class ApplicationPartUpdateDataCommandHandler extends UpdateDataCommandHandler
{
	/** The data layer. **/
	private DataLayer dataLayer;
	/** The ESP. **/
	private ESP esp;
	/** The event generator. **/
	private ESPEventGenerator eventGenerator;

	/**
	 * Creates the command handler.
	 * @param esp
	 *            The ESP.
	 * @param eventGenerator
	 *            The event generator.
	 * @param dataLayer
	 *            The data layer.
	 **/
	public ApplicationPartUpdateDataCommandHandler(ESP esp, ESPEventGenerator eventGenerator, DataLayer dataLayer)
	{
		super(dataLayer);
		this.esp = esp;
		this.eventGenerator = eventGenerator;
		this.dataLayer = dataLayer;
	}

	/**
	 * Executes a command.
	 * @param command
	 *            The command to run.
	 **/
	@SuppressWarnings("unchecked")
	@Override
	protected boolean doCommand(UpdateDataCommand command)
	{
		try
		{
			int columnPosition = command.getColumnPosition();
			int rowPosition = command.getRowPosition();

			Object currentValue = dataLayer.getDataValueByPosition(columnPosition, rowPosition);

			if (currentValue == null || command.getNewValue() == null || !currentValue.equals(command.getNewValue()))
			{
				if (columnPosition == 3)
				{
					ListDataProvider<ApplicationPart> dataProvider = (ListDataProvider<ApplicationPart>) dataLayer.getDataProvider();
					ApplicationPart part = dataProvider.getRowObject(dataLayer.getRowIndexByPosition(rowPosition));
					String value = command.getNewValue().toString();

					Collection<Property> properties = new ArrayList<>();
					if (value.contains("hard confidentiality"))
						properties.add(Property.HARDCONFIDENTIALITY);
					else if (value.contains("confidentiality"))
						properties.add(Property.CONFIDENTIALITY);
					else if (value.contains("privacy"))
						properties.add(Property.PRIVACY);
					if (value.contains("integrity"))
						properties.add(Property.INTEGRITY);

					boolean hardcoded = part.getProperties().contains(Property.HARDCODED);
					part.getProperties().clear();
					part.getProperties().addAll(properties);
					if (hardcoded)
						part.getProperties().add(Property.HARDCODED);
					esp.updateAssets();
					eventGenerator.fireEvent(Event.APPLICATION_PARTS_UPDATED);
				}
				else if (columnPosition == 4)
				{
					dataLayer.setDataValueByPosition(columnPosition, rowPosition, command.getNewValue());
					esp.updateAssets();
					eventGenerator.fireEvent(Event.APPLICATION_PARTS_UPDATED);
				}
				else
					dataLayer.setDataValueByPosition(columnPosition, rowPosition, command.getNewValue());
				dataLayer.fireLayerEvent(new CellVisualChangeEvent(this.dataLayer, columnPosition, rowPosition));
			}
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}

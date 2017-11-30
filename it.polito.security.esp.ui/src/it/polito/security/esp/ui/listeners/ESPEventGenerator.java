package it.polito.security.esp.ui.listeners;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Generates the ESP events.
 * @author Daniele Canavese
 **/
public class ESPEventGenerator
{
	/**
	 * Creates the event generator.
	 **/
	public ESPEventGenerator()
	{
		listeners = new ArrayList<>();
	}

	/**
	 * Signals an event.
	 * @param event
	 *            The event.
	 **/
	public void fireEvent(Event event)
	{
		for (ESPEventListener i : listeners)
			i.handleEvent(event);
	}

	/**
	 * Signals a list of events.
	 * @param events
	 *            The events.
	 **/
	public void fireEvents(Event... events)
	{
		for (Event i : events)
			fireEvent(i);
	}

	/**
	 * Signals all the events at once.
	 **/
	public void fireAllEvents()
	{
		for (Event i : Event.values())
			fireEvent(i);
	}

	/**
	 * Adds a new listener.
	 * @param listener
	 *            The listener to add.
	 **/
	public void addListener(ESPEventListener listener)
	{
		listeners.add(listener);
		for (Event i : Event.values())
			listener.handleEvent(i);
	}

	/** The listeners. **/
	private Collection<ESPEventListener> listeners;
}

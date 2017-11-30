package it.polito.security.esp.ui.listeners;

import java.util.EventListener;

/**
 * An ESP event listener.
 * @author Daniele Canavese
 **/
public interface ESPEventListener extends EventListener
{
	/**
	 * Handles an event.
	 * @param event
	 *            The event.
	 **/
	void handleEvent(Event event);
}

package it.polito.security.esp.ui;

import it.polito.security.esp.kb.Model;

/**
 * An ESP dirty listener.
 * @author Daniele Canavese
 **/
public interface ESPDirtyListener
{
	/**
	 * Signals that the dirty state of a model has changed.
	 * @param model
	 *            The model.
	 * @param dirty
	 *            The new dirty state of the model.
	 **/
	public void dirtyStateChanged(Model model, boolean dirty);
}

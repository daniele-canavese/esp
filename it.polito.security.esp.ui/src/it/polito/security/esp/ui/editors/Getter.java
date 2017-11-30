package it.polito.security.esp.ui.editors;

import it.polito.security.esp.kb.Model;

/**
 * A getter class.
 * @author Daniele Canavese
 **/
interface Getter
{
	/**
	 * Retrieves a string.
	 * @param model
	 *            The model.
	 * @return The string.
	 **/
	public String get(Model model);
}

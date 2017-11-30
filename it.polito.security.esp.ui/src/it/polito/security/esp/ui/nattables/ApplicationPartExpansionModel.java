package it.polito.security.esp.ui.nattables;

import java.util.List;

import ca.odell.glazedlists.TreeList;
import it.polito.security.esp.kb.ApplicationPart;

/**
 * The application part expansion model.
 * @author Daniele Canavese
 **/
public class ApplicationPartExpansionModel implements TreeList.ExpansionModel<ApplicationPart>
{
	/**
	 * Checks if an application part is expanded or not.
	 * @param element
	 *            The element.
	 * @param path
	 *            The element's path.
	 * @return <code>true</code> if the children should be visible, <code>false</code> otherwise.
	 **/
	@Override
	public boolean isExpanded(ApplicationPart element, List<ApplicationPart> path)
	{
		return element.containsAsset();
	}

	/**
	 * Sets an element as expanded or not.
	 * @param element
	 *            The element.
	 * @param path
	 *            The element's path.
	 * @param expanded
	 *            The element's expanded state.
	 **/
	@Override
	public void setExpanded(ApplicationPart element, List<ApplicationPart> path, boolean expanded)
	{
	}
}

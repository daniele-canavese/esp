package it.polito.security.esp.ui.nattables;

import java.util.Comparator;
import java.util.List;

import ca.odell.glazedlists.TreeList;

/**
 * The format that shows a simple list.
 * @param <T>
 *            The list base type.
 * @author Daniele Canavese
 **/
public class ListFormat<T> implements TreeList.Format<T>
{
	/**
	 * Checks if an element can have children.
	 * @param element
	 *            The element.
	 * @return <code>true</code> if the element can have children, <code>false</code> otherwise.
	 **/
	@Override
	public boolean allowsChildren(T element)
	{
		return false;
	}

	/**
	 * Retrieves the path of an element.
	 * @param element
	 *            The element.
	 * @param path
	 *            The list where to write the path.
	 **/
	@Override
	public void getPath(List<T> path, T element)
	{
		path.clear();
		path.add(element);
	}

	/**
	 * Returns the element comparator.
	 * @param depth
	 *            The elements depth.
	 * @return The comparator or <code>null</code> if no comparator is needed.
	 */
	@Override
	public Comparator<T> getComparator(int depth)
	{
		return null;
	}

}

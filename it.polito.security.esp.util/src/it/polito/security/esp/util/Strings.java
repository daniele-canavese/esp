package it.polito.security.esp.util;

import java.util.Collection;

/**
 * Strings utilities.
 * @author Daniele Canavese
 **/
public class Strings
{
	/**
	 * Joins a set of strings into a single one.
	 * @param collection
	 *            The collection of strings.
	 * @param separator
	 *            The separator.
	 * @return The joined string.
	 **/
	public static String join(Collection<?> collection, String separator)
	{
		if (collection == null)
			return "";

		StringBuilder sb = new StringBuilder();

		for (Object i : collection)
		{
			if (sb.length() > 0)
				sb.append(separator);
			sb.append(i.toString());
		}

		return sb.toString();
	}

	/**
	 * Capitalize the first letter of a string.
	 * @param string
	 *            The string to modify.
	 * @return The capitalized string.
	 **/
	public static String capitalize(String string)
	{
		if (string.isEmpty())
			return string;
		else
			return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	/**
	 * Expand a camel string and capitalize the first letter of a string.
	 * @param string
	 *            The string to modify.
	 * @return The expanded and capitalized string.
	 **/
	public static String expandAndCapitalize(String string)
	{
		if (string.isEmpty())
			return string;
		else
		{
			StringBuilder sb = new StringBuilder();

			for (char i : string.toCharArray())
				if (Character.isUpperCase(i))
					sb.append(" " + Character.toLowerCase(i));
				else
					sb.append(i);

			return capitalize(sb.toString());
		}
	}

	/**
	 * Private constructor.
	 **/
	private Strings()
	{
	}
}

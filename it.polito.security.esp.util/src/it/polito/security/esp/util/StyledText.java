package it.polito.security.esp.util;

import org.eclipse.swt.custom.StyleRange;

/**
 * A styled text for a viewer.
 * @author Daniele Canavese
 **/
public class StyledText
{
	/**
	 * Creates the styled text with no style.
	 * @param text
	 *            The text.
	 **/
	public StyledText(String text)
	{
		this(text, null);
	}

	/**
	 * Creates the styled text.
	 * @param text
	 *            The text.
	 * @param styleRanges
	 *            The text ranges.
	 **/
	public StyledText(String text, StyleRange styleRanges[])
	{
		this.text = text;
		this.styleRanges = styleRanges;
	}

	/** The text. **/
	private String text;
	/** The style ranges. **/
	private StyleRange styleRanges[];

	/**
	 * Retrieve the text.
	 * @return The text.
	 **/
	public String getText()
	{
		return text;
	}

	/**
	 * Retrieve the style ranges.
	 * @return The style ranges.
	 **/
	public StyleRange[] getStyleRanges()
	{
		return styleRanges;
	}
}

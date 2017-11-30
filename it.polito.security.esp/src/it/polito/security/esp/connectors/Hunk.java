package it.polito.security.esp.connectors;

/**
 * A patch hunk.
 * @author Daniele Canavese
 **/
public class Hunk
{
	/** The line number. **/
	private int line;
	/** The original code. **/
	private String original;
	/** The patched code. **/
	private String patched;

	/**
	 * Creates a hunk
	 * @param line
	 *            The line number.
	 * @param original
	 *            The original code.
	 * @param patched
	 *            The patched code.
	 **/
	public Hunk(int line, String original, String patched)
	{
		this.line = line;
		this.original = original;
		this.setPatched(patched);
	}

	/**
	 * Retrieves the patched code.
	 * @return The patched code.
	 **/
	public String getPatched()
	{
		return patched;
	}

	/**
	 * Sets the patched code.
	 * @param patched
	 *            The new patched code.
	 **/
	public void setPatched(String patched)
	{
		this.patched = patched;
	}

	/**
	 * Converts the object to a string.
	 * @return A string.
	 **/
	@Override
	public String toString()
	{
		int originalLines = original.split("\r\n|\r|\n").length;
		int patchedLines = patched.split("\r\n|\r|\n").length;

		String text = "";
		text += "@@ -" + line + "," + originalLines + " +" + line + "," + patchedLines + " @@\n";
		for (String i : original.split("\r\n|\r|\n"))
			text += "-" + i + "\n";
		for (String i : patched.split("\r\n|\r|\n"))
			text += "+" + i + "\n";

		return text;
	}
}

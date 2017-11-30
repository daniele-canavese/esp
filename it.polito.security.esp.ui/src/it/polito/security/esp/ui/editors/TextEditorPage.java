package it.polito.security.esp.ui.editors;

import org.eclipse.ui.editors.text.TextEditor;

/**
 * The text editor page.
 * @author Daniele Canavese
 **/
public class TextEditorPage extends TextEditor
{
	/**
	 * Retrieves the dirty state of the editor.
	 * @return Always <code>false</code>.
	 **/
	@Override
	public boolean isDirty()
	{
		return false;
	}

	/**
	 * Retrieves the editable status of the editor.
	 * @return Always <code>false</code>.
	 **/
	@Override
	public boolean isEditable()
	{
		return false;
	}

	/**
	 * Checks if the input is modifiable.
	 * @return Always <code>false</code>.
	 **/
	@Override
	public boolean isEditorInputModifiable()
	{
		return false;
	}

	/**
	 * Checks if the input is read-only.
	 * @return Always <code>false</code>.
	 **/
	@Override
	public boolean isEditorInputReadOnly()
	{
		return true;
	}
}

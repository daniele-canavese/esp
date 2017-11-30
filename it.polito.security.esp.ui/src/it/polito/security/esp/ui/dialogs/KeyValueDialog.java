package it.polito.security.esp.ui.dialogs;

import java.util.Collection;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.AttackStep;
import it.polito.security.esp.kb.CodeBlock;

/**
 * A simple key-value view dialog.
 * @author Leonardo Regano, Daniele Canavese
 **/
public class KeyValueDialog extends Dialog
{
	/** The pairs to show. **/
	private List<Pair<?, ?>> pairs;
	/** A description. **/
	private String description;
	/** The tree. **/
	private Tree tree;

	/**
	 * Creates the dialog.
	 * @param parent
	 *            The parent shell.
	 * @param description
	 *            A description.
	 * @param pairs
	 *            The pairs to show.
	 **/
	public KeyValueDialog(Shell parent, String description, List<Pair<?, ?>> pairs)
	{
		super(parent);
		this.description = description;
		this.pairs = pairs;
	}

	/**
	 * Retrieves a value stating if the dialog is resizable.
	 * @return Always <code>true</code>.
	 **/
	@Override
	protected boolean isResizable()
	{
		return true;
	}

	/**
	 * Configures the shell.
	 * @param newShell
	 *            The shell to configure.
	 **/
	@Override
	protected void configureShell(Shell newShell)
	{
		super.configureShell(newShell);
		newShell.setText("ESP");
	}

	/**
	 * Creates a button.
	 * @param parent
	 *            The parent composite.
	 * @param id
	 *            The button id.
	 * @param label
	 *            The button label.
	 * @param defaultButton
	 *            A value stating if the button is the default one or not.
	 * @return The button or <code>null</code> if no button was created.
	 **/
	@Override
	protected Button createButton(Composite parent, int id, String label, boolean defaultButton)
	{
		if (id == IDialogConstants.CANCEL_ID)
			return null;
		else
			return super.createButton(parent, id, label, defaultButton);
	}

	/**
	 * Creates, if needed, all the sub-items for an item.
	 * @param parent
	 *            The parent item or <code>null</code> for the tree.
	 * @param key
	 *            The key to represent or <code>null</code> for no key.
	 * @param value
	 *            The value to represent.
	 */
	void createItem(TreeItem parent, Object key, Object value)
	{
		TreeItem item;
		if (parent == null)
			item = new TreeItem(tree, SWT.NONE);
		else
			item = new TreeItem(parent, SWT.NONE);
		String text = "";
		if (key != null)
			text = key.toString() + " : ";
		if (value != null)
			text += value.toString();
		else
			text += "<null>";

		item.setText(text);

		if (value instanceof Collection)
		{
			@SuppressWarnings("unchecked")
			Collection<Object> collection = (Collection<Object>) value;
			for (Object i : collection)
				createItem(item, null, i);
		}
		else if (value instanceof ApplicationPart)
			for (ApplicationPart i : ((ApplicationPart) value).getApplicationParts())
				createItem(item, null, i);
		else if (value instanceof CodeBlock)
			for (CodeBlock i : ((CodeBlock) value).getCodeBlocks())
				createItem(item, null, i);
		else if (value instanceof AttackPath)
			for (AttackStep i : ((AttackPath) value).getAttackSteps())
				createItem(item, null, i);
	}

	/**
	 * Creates the dialog area.
	 * @param parent
	 *            The parent composite.
	 **/
	@Override
	protected Control createDialogArea(Composite parent)
	{
		Composite composite = (Composite) super.createDialogArea(parent);

		Label label = new Label(composite, SWT.NONE);
		label.setText(description);

		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.widthHint = 500;

		tree = new Tree(composite, SWT.H_SCROLL | SWT.V_SCROLL);
		tree.setLayoutData(gridData);
		tree.setLinesVisible(true);
		TableLayout layout = new TableLayout();
		tree.setLayout(layout);

		new TreeColumn(tree, SWT.NONE);
		ColumnWeightData keyColumnLayoutData = new ColumnWeightData(1);
		layout.addColumnData(keyColumnLayoutData);

		new TreeColumn(tree, SWT.NONE);

		for (Pair<?, ?> i : pairs)
			createItem(null, i.getKey(), i.getValue());

		return composite;
	}
}

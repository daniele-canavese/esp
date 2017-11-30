package it.polito.security.esp.ui.wizards;

import java.util.UUID;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Text;

import it.polito.security.esp.kb.Activator;
import it.polito.security.esp.util.Eclipse;

/**
 * The project overview wizard page.
 * @author Daniele Canavese
 **/
public class OverviewPage extends WizardPage
{
	/**
	 * Creates the page.
	 **/
	protected OverviewPage()
	{
		super("Create an ESP Full Software Protection Project");
		setTitle("Create an ESP Full Software Protection Project");
		setDescription("Create an ESP Full project in the workspace or in an external location.");
		setPageComplete(false);
		projectName = UUID.randomUUID().toString();
	}

	/**
	 * Fills the page.
	 * @param parent
	 *            The parent composite.
	 **/
	@Override
	public void createControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, false));

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(2, false));

		Label labelProjectName = new Label(composite, SWT.NONE);
		labelProjectName.setText("Project name:");

		Text textProjectName = new Text(composite, SWT.BORDER);
		textProjectName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textProjectName.setFocus();

		Group groupLocation = new Group(container, SWT.NONE);
		groupLocation.setText("Location");
		groupLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		groupLocation.setLayout(new GridLayout(3, false));

		Button buttonUseDefaultLocation = new Button(groupLocation, SWT.CHECK);
		buttonUseDefaultLocation.setSelection(true);
		buttonUseDefaultLocation.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		buttonUseDefaultLocation.setText("Use default location");

		Label labelLocation = new Label(groupLocation, SWT.NONE);
		labelLocation.setText("Location:");

		final Text textLocation = new Text(groupLocation, SWT.BORDER);
		textLocation.setEnabled(false);
		textLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textLocation.setText(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());

		final Button buttonBrowse = new Button(groupLocation, SWT.NONE);
		buttonBrowse.setEnabled(false);
		buttonBrowse.setText("Browse...");

		Group groupSourceCode = new Group(container, SWT.NONE);
		groupSourceCode.setText("Source code");
		groupSourceCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		groupSourceCode.setLayout(new GridLayout(3, false));

		Label labelWorkingDirectory = new Label(groupSourceCode, SWT.NONE);
		labelWorkingDirectory.setText("Working directory:");

		textWorkingDirectory = new Text(groupSourceCode, SWT.BORDER);
		textWorkingDirectory.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Button buttonSourceCodeBrowse = new Button(groupSourceCode, SWT.NONE);
		buttonSourceCodeBrowse.setText("Browse...");

		Label labelACTCConfigurationFile = new Label(groupSourceCode, SWT.NONE);
		labelACTCConfigurationFile.setText("ACTC configuration file:");

		textACTCConfigurationFile = new Text(groupSourceCode, SWT.BORDER);
		textACTCConfigurationFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		final Button buttonACTCConfigurationFile = new Button(groupSourceCode, SWT.NONE);
		buttonACTCConfigurationFile.setText("Browse...");

		Label labelESPPatchFile = new Label(groupSourceCode, SWT.NONE);
		labelESPPatchFile.setText("ESP patch file:");

		textESPPatchFile = new Text(groupSourceCode, SWT.BORDER);
		textESPPatchFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textESPPatchFile.setText("esp.patch");

		new Label(groupSourceCode, SWT.NONE);

		Label labelESPJSONFile = new Label(groupSourceCode, SWT.NONE);
		labelESPJSONFile.setText("ESP JSON file:");

		textESPJSONFile = new Text(groupSourceCode, SWT.BORDER);
		textESPJSONFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textESPJSONFile.setText("esp.json");

		new Label(groupSourceCode, SWT.NONE);

		Group groupArchitecture = new Group(container, SWT.NONE);
		groupArchitecture.setText("Target Architecture");
		groupArchitecture.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		groupArchitecture.setLayout(new GridLayout(1, false));

		comboArchitecture = new Combo(groupArchitecture, SWT.READ_ONLY);
		comboArchitecture.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comboArchitecture.setLayout(new GridLayout(1, false));
		for (IConfigurationElement i : Eclipse.getExtensions(Activator.ARCHITECTURES_ID))
			comboArchitecture.add(i.getAttribute("name"));
		comboArchitecture.select(0);

		Group groupProfileLevel = new Group(container, SWT.NONE);
		groupProfileLevel.setText("Solution Estimation Profile");
		groupProfileLevel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		groupProfileLevel.setLayout(new GridLayout(1, false));

		final Label securityTriangleImage = new Label(groupProfileLevel, SWT.NONE);
		securityTriangleImage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		scaleProfileLevel = new Scale(groupProfileLevel, SWT.HORIZONTAL);
		scaleProfileLevel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		scaleProfileLevel.setMinimum(1);
		scaleProfileLevel.setMaximum(5);
		scaleProfileLevel.setSelection(1);
		scaleProfileLevel.setIncrement(1);
		scaleProfileLevel.setPageIncrement(1);

		final Label speedTriangleImage = new Label(groupProfileLevel, SWT.NONE);
		speedTriangleImage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		scaleProfileLabel = new Label(groupProfileLevel, SWT.WRAP | SWT.CENTER | SWT.BORDER);
		scaleProfileLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		scaleProfileLabel.setText("?");

		profileDescriptionLabel = new Label(groupProfileLevel, SWT.LEFT);
		profileDescriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

		updateDescriptions();

		securityTriangleImage.addPaintListener(new PaintListener()
		{
			@Override
			public void paintControl(PaintEvent e)
			{
				Point size = securityTriangleImage.getSize();

				e.gc.setForeground(new Color(Display.getDefault(), 254, 73, 2));
				e.gc.setBackground(new Color(Display.getDefault(), 240, 230, 140));
				e.gc.fillGradientRectangle(0, 0, size.x / 2, size.y, false);

				e.gc.setForeground(new Color(Display.getDefault(), 240, 230, 140));
				e.gc.setBackground(new Color(Display.getDefault(), 50, 205, 50));
				e.gc.fillGradientRectangle(size.x / 2, 0, size.x, size.y, false);

				e.gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
				int[] polygon = new int[] { 0, 0, 0, size.y, size.x, 0 };
				e.gc.fillPolygon(polygon);

				e.gc.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_FOREGROUND));
				e.gc.drawText("Minimum accuracy", 10, 0, true);
				Point textSize = e.gc.textExtent("Maximum accuracy");
				e.gc.drawText("Maximum accuracy", size.x - textSize.x - 10, 0, true);
			}
		});

		speedTriangleImage.addPaintListener(new PaintListener()
		{
			@Override
			public void paintControl(PaintEvent e)
			{
				Point size = speedTriangleImage.getSize();

				e.gc.setForeground(new Color(Display.getDefault(), 50, 205, 50));
				e.gc.setBackground(new Color(Display.getDefault(), 240, 230, 140));
				e.gc.fillGradientRectangle(0, 0, size.x / 2, size.y, false);

				e.gc.setForeground(new Color(Display.getDefault(), 240, 230, 140));
				e.gc.setBackground(new Color(Display.getDefault(), 254, 73, 2));
				e.gc.fillGradientRectangle(size.x / 2, 0, size.x, size.y, false);

				e.gc.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
				int[] polygon = new int[] { 0, size.y, size.x, size.y, size.x, 0 };
				e.gc.fillPolygon(polygon);

				e.gc.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_FOREGROUND));
				e.gc.drawText("Maximum speed", 10, 0, true);
				Point textSize = e.gc.textExtent("Minimum speed");
				e.gc.drawText("Minimum speed", size.x - textSize.x - 10, 0, true);
			}
		});

		scaleProfileLevel.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				updateDescriptions();
			}
		});

		scaleProfileLevel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseUp(MouseEvent e)
			{
				scaleProfileLevel.setSelection(scaleProfileLevel.getSelection());
			}
		});

		textProjectName.addModifyListener(new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				projectName = ((Text) e.getSource()).getText();
				if (!projectName.isEmpty())
				{
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					IProject project = root.getProject(projectName);
					if (project.exists())
						setErrorMessage(" A project with this name already exists.");
					else
						setErrorMessage(null);
				}
			}
		});
		buttonUseDefaultLocation.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				boolean custom = !((Button) e.widget).getSelection();
				textLocation.setEnabled(custom);
				buttonBrowse.setEnabled(custom);
				if (custom)
					textLocation.setText("");
				else
					textLocation.setText(ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString());
			}
		});
		buttonBrowse.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getCurrent().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent().getActiveShell());
						dialog.setMessage("Choose a directory for the project contents");
						dialog.setText("Project Location");
						String folder = dialog.open();
						if (folder != null)
							textLocation.setText(folder);
					}
				});
			}
		});
		buttonSourceCodeBrowse.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getCurrent().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						DirectoryDialog dialog = new DirectoryDialog(Display.getCurrent().getActiveShell());
						dialog.setMessage("Choose a directory containing the application to protect");
						dialog.setText("Source Code Location");
						String folder = dialog.open();
						if (folder != null)
							textWorkingDirectory.setText(folder);
					}
				});
			}
		});
		buttonACTCConfigurationFile.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				Display.getCurrent().syncExec(new Runnable()
				{
					@Override
					public void run()
					{
						FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell());
						dialog.setText("ACTC Configuration File");
						dialog.setFilterExtensions(new String[] { "*.json" });
						String file = dialog.open();
						if (file != null)
							textACTCConfigurationFile.setText(file);
					}
				});
			}
		});
		ModifyListener completiontLister = new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				if (textLocation.getText().isEmpty())
					setPageComplete(false);
				else if (textACTCConfigurationFile.getText().isEmpty())
					setPageComplete(false);
				else if (textWorkingDirectory.getText().isEmpty())
					setPageComplete(false);
				else if (textESPPatchFile.getText().isEmpty())
					setPageComplete(false);
				else if (textESPJSONFile.getText().isEmpty())
					setPageComplete(false);
				else
					setPageComplete(true);
			}
		};
		textProjectName.addModifyListener(completiontLister);
		textLocation.addModifyListener(completiontLister);
		textACTCConfigurationFile.addModifyListener(completiontLister);
		textWorkingDirectory.addModifyListener(completiontLister);
		completiontLister.modifyText(null);
	}

	/**
	 * Updates the level descriptions.
	 **/
	private void updateDescriptions()
	{
		scaleProfileLabel.setText("Profile level: " + scaleProfileLevel.getSelection());

		if (scaleProfileLevel.getSelection() == 1)
			profileDescriptionLabel.setText("Metrics && parsing: estimate metrics, ignore headers\n"
					+ "Attacks && protections: 1 minute, depth 4, medium mitigation level\n"
					+ "Level 1 protections: 3 minutes, depth 3, multi-tree, use synergies, full razoring && co.\n"
					+ "Level 2 protections: 1 minute, block length 16, splitting 4+1");
		else if (scaleProfileLevel.getSelection() == 2)
			profileDescriptionLabel.setText("Metrics && parsing: estimate metrics, ignore system headers\n"
					+ "Attacks && protections: 10 minutes, depth 6, medium mitigation level\n"
					+ "Level 1 protections: 10 minutes, depth 6, multi-tree, use synergies, full razoring && co.\n"
					+ "Level 2 protections: 10 minutes, block length 8, splitting 2+2");
		else if (scaleProfileLevel.getSelection() == 3)
			profileDescriptionLabel.setText("Metrics && parsing: estimate metrics, ignore system headers\n"
					+ "Attacks && protections: 1 hour, depth 8, medium mitigation level\n"
					+ "Level 1 protections: 1 hour, depth 9, multi-tree, use synergies, partial razoring && co.\n"
					+ "Level 2 protections: 1 hour, block length 4, splitting 2+3");
		else if (scaleProfileLevel.getSelection() == 4)
			profileDescriptionLabel.setText("Metrics && parsing: estimate metrics, parse all the headers\n"
					+ "Attacks && protections: 1 day, depth 10, low mitigation level\n"
					+ "Level 1 protections: 1 day, depth 15, multi-tree, use synergies, partial razoring && co.\n"
					+ "Level 2 protections: 1 day, block length 2, splitting 1+4");
		else
			profileDescriptionLabel.setText("Metrics && parsing: compute metrics, parse all the headers\n"
					+ "Attacks && protections: no limit, depth 12, low mitigation level\n"
					+ "Level 1 protections: no limit, depth 30, single tree, ignore synergies, no razoring && co.\n"
					+ "Level 2 protections: no limit, block length 1, splitting 1+off");
	}

	/**
	 * Retrieves the project name.
	 * @return The project name.
	 **/
	public String getProjectName()
	{
		return projectName;
	}

	/**
	 * Retrieves the working directory.
	 * @return The working directory.
	 **/
	public String getWorkingDirectory()
	{
		return textWorkingDirectory.getText();
	}

	/**
	 * Retrieves the ACTC configuration file.
	 * @return The ACTC configuration file.
	 **/
	public String getACTCConfigurationFile()
	{
		return textACTCConfigurationFile.getText();
	}

	/**
	 * Retrieves the ESP patch file.
	 * @return The ESP patch file.
	 **/
	public String getESPPatchFile()
	{
		return textESPPatchFile.getText();
	}

	/**
	 * Retrieves the ESP JSON file.
	 * @return The ESP JSON file.
	 **/
	public String getESPJSONFile()
	{
		return textESPJSONFile.getText();
	}

	/**
	 * Retrieves the architecture.
	 * @return The architecture.
	 **/
	public String getArchitecture()
	{
		return comboArchitecture.getText();
	}

	/**
	 * Retrieves the profile level.
	 * @return The profile level.
	 **/
	public int getProfileLevel()
	{
		return scaleProfileLevel.getSelection();
	}

	/** The project name. **/
	private String projectName;
	/** The working directory text. **/
	private Text textWorkingDirectory;
	/** The ACTC configuration file text. **/
	private Text textACTCConfigurationFile;
	/** The ESP patch file text. **/
	private Text textESPPatchFile;
	/** The ESP JSON file text. **/
	private Text textESPJSONFile;
	/** The combo architecture. **/
	private Combo comboArchitecture;
	/** Theve profile level scale. */
	private Scale scaleProfileLevel;
	/** Theve profile level label. */
	private Label scaleProfileLabel;
	/** Theve profile level description. */
	private Label profileDescriptionLabel;
}

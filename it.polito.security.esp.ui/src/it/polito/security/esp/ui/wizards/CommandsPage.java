package it.polito.security.esp.ui.wizards;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The commands wizard page.
 * @author Daniele Canavese
 **/
public class CommandsPage extends WizardPage
{
	/**
	 * Creates the page.
	 **/
	protected CommandsPage()
	{
		super("Create an ESP Software Protection Project");
		setTitle("Create an ESP Software Protection Project");
		setDescription("Select the external commands to use.");
		setPageComplete(true);
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
		composite.setLayout(new GridLayout(3, false));

		Label labelACTCCommand = new Label(composite, SWT.NONE);
		labelACTCCommand.setText("ACTC command:");

		textACTCCommand = new Text(composite, SWT.BORDER);
		textACTCCommand.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textACTCCommand.setText("docker-compose -f "+System.getProperty("user.home")+"/git/framework/docker-compose.yml exec -T actc /opt/ACTC/actc.py");

		final Button buttonACTCCommand = new Button(composite, SWT.NONE);
		buttonACTCCommand.setText("Browse...");

		Label labelCodeSurferCommand = new Label(composite, SWT.NONE);
		labelCodeSurferCommand.setText("Perl interpreter:");

		textPerlCommand = new Text(composite, SWT.BORDER);
		textPerlCommand.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textPerlCommand.setText("/usr/bin/perl");

		final Button buttonCodeSurferCommand = new Button(composite, SWT.NONE);
		buttonCodeSurferCommand.setText("Browse...");

		Label labelCompilationCommand = new Label(composite, SWT.NONE);
		labelCompilationCommand.setText("Local dot utility:");

		textDotCommand = new Text(composite, SWT.BORDER);
		textDotCommand.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		if (Platform.getOS().equals(Platform.OS_WIN32))
			textDotCommand.setText("C:\\Program Files\\Graphviz\\bin\\dot.exe");
		else
			textDotCommand.setText("/usr/bin/dot");

		final Button buttonCompilationCommand = new Button(composite, SWT.NONE);
		buttonCompilationCommand.setText("Browse...");

		buttonACTCCommand.addSelectionListener(new SelectionAdapter()
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
						dialog.setText("ACTC command");
						String file = dialog.open();
						if (file != null)
							textACTCCommand.setText(file);
					}
				});
			}
		});
		buttonCodeSurferCommand.addSelectionListener(new SelectionAdapter()
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
						dialog.setText("Perl command");
						String file = dialog.open();
						if (file != null)
							textPerlCommand.setText(file);
					}
				});
			}
		});
		buttonCompilationCommand.addSelectionListener(new SelectionAdapter()
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
						dialog.setText("Compilation command");
						String file = dialog.open();
						if (file != null)
							textDotCommand.setText(file);
					}
				});
			}
		});

		Label labelTigressCommand = new Label(composite, SWT.NONE);
		labelTigressCommand.setText("Tigress command:");

		textTigressCommand = new Text(composite, SWT.BORDER);
		textTigressCommand.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textTigressCommand.setText("docker-compose -f ~/git/framework/docker-compose.yml exec -T actc env TIGRESS_HOME=/projects/tigress-unstable PATH=$PATH:/projects/tigress-unstable /projects/tigress-unstable/tigress");

		final Button buttonTigressCommand = new Button(composite, SWT.NONE);
		buttonTigressCommand.setText("Browse...");
		buttonTigressCommand.addSelectionListener(new SelectionAdapter()
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
						dialog.setText("Tigress command");
						String file = dialog.open();
						if (file != null)
							textTigressCommand.setText(file);
					}
				});
			}
		});
		
		Label labelCillyCommand = new Label(composite, SWT.NONE);
		labelCillyCommand.setText("Cilly command:");

		textCillyCommand = new Text(composite, SWT.BORDER);
		textCillyCommand.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		textCillyCommand.setText("docker-compose -f ~/git/framework/docker-compose.yml exec -T actc env TIGRESS_HOME=/projects/tigress-unstable PATH=$PATH:/projects/tigress-unstable /projects/tigress-unstable/cilly");

		final Button buttonCillyCommand = new Button(composite, SWT.NONE);
		buttonCillyCommand.setText("Browse...");
		buttonCillyCommand.addSelectionListener(new SelectionAdapter()
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
						dialog.setText("Cilly command");
						String file = dialog.open();
						if (file != null)
							textCillyCommand.setText(file);
					}
				});
			}
		});
		
		ModifyListener completiontLister = new ModifyListener()
		{
			@Override
			public void modifyText(ModifyEvent e)
			{
				if (textACTCCommand.getText().isEmpty())
					setPageComplete(false);
				else if (textPerlCommand.getText().isEmpty())
					setPageComplete(false);
				else if (textDotCommand.getText().isEmpty())
					setPageComplete(false);
				else if (textTigressCommand.getText().isEmpty())
					setPageComplete(false);
				else if (textCillyCommand.getText().isEmpty())
					setPageComplete(false);
				else
					setPageComplete(true);
			}
		};
		textACTCCommand.addModifyListener(completiontLister);
		textPerlCommand.addModifyListener(completiontLister);
		textDotCommand.addModifyListener(completiontLister);
		textTigressCommand.addModifyListener(completiontLister);
		textCillyCommand.addModifyListener(completiontLister);
	}

	/** The ACTC command text. **/
	private Text textACTCCommand;
	/** The Perl interpreter text. **/
	private Text textPerlCommand;
	/** The Dot utility text. **/
	private Text textDotCommand;
	/** The Tigress utility text. **/
	private Text textTigressCommand;
	/** The Cilly utility text. **/
	private Text textCillyCommand;

	
	/**
	 * Retrieves the ACTC command.
	 * @return The ACTC command.
	 **/
	public String getACTCCommand()
	{
		return textACTCCommand.getText();
	}

	/**
	 * Retrieves the Perl interpreter.
	 * @return The Perl interpreter.
	 **/
	public String getPerlCommand()
	{
		return textPerlCommand.getText();
	}

	/**
	 * Retrieves the Dot utility.
	 * @return The Dot utility.
	 **/
	public String getDotCommand()
	{
		return textDotCommand.getText();
	}
	
	/**
	 * Retrieves the Tigress command.
	 * @return The Tigress command.
	 **/
	public String getTigressCommand()
	{
		return textTigressCommand.getText();
	}
	
	/**
	 * Retrieves the Cilly command.
	 * @return The Cilly command.
	 **/
	public String getCillyCommand()
	{
		return textCillyCommand.getText();
	}
}

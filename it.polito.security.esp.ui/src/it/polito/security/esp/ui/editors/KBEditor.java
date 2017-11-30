package it.polito.security.esp.ui.editors;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;

import com.google.inject.Injector;

import it.polito.security.esp.rules.ui.internal.RulesActivator;
import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.ActionType;
import it.polito.security.esp.kb.KbFactory;
import it.polito.security.esp.kb.ApplicationPartType;
import it.polito.security.esp.kb.FunctionDeclaration;
import it.polito.security.esp.kb.Model;
import it.polito.security.esp.kb.Rule;
import it.polito.security.esp.rulesLanguage.Action;
import it.polito.security.esp.rulesLanguage.Condition;
import it.polito.security.esp.rulesLanguage.ParameterType;
import it.polito.security.esp.ui.ESPDirtyListener;
import it.polito.security.esp.ui.ESPService;
import it.polito.security.esp.ui.listeners.ESPEventGenerator;
import it.polito.security.esp.util.Strings;

/**
 * The KB editor.
 **/
public class KBEditor extends FormEditor implements IResourceChangeListener, ESPDirtyListener
{
	/**
	 * Creates the editor.
	 */
	public KBEditor()
	{
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
		esp = null;
		eventGenerator = new ESPEventGenerator();
		espService = null;
	}

	/**
	 * Adds the pages.
	 **/
	@Override
	protected void addPages()
	{
		try
		{
			espService = (ESPService) getSite().getService(ESPService.class);

			LogsPage logsPage = new LogsPage(this, file.getParent());
			esp = new ESP(file, espService.getModel(file));
			espService.addListener(this, esp.getModel());
			AssetsPage assetsPage = new AssetsPage(this, esp, eventGenerator);
			AttackerPage attackerPage = new AttackerPage(this, esp, eventGenerator);
			AttacksPage attacksPage = new AttacksPage(this, esp, eventGenerator);
			ProtectionsPage protectionsPage = new ProtectionsPage(this, esp, eventGenerator);
			PreferencesPage preferencesPage = new PreferencesPage(this, esp);
			SolutionsPage solutionsPage = new SolutionsPage(this, esp, eventGenerator);
			OverviewPage overviewPage = new OverviewPage(this, esp, eventGenerator);

			addPage(overviewPage);
			addPage(attackerPage);
			addPage(preferencesPage);

			addRulesPage();

			addPage(assetsPage);
			addPage(attacksPage);
			addPage(protectionsPage);
			addPage(solutionsPage);
			addPage(logsPage);

			setPageText(addPage(new TextEditorPage(), getEditorInput()), "kb.owl");

			esp.getModel().eAdapters().add(new EContentAdapter()
			{
				@Override
				public void notifyChanged(Notification msg)
				{
					espService.setDirty(esp.getModel(), true);
				}
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Adds the rules page.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	private void addRulesPage() throws Exception
	{
		RulesActivator activator = RulesActivator.getInstance();
		final Injector injector = activator.getInjector("it.polito.security.esp.RulesLanguage");
		XtextEditor xtextEditor = injector.getInstance(XtextEditor.class);

		IFile rulesFile = file.getProject().getFile("esp.rules");
		if (!rulesFile.exists())
			rulesFile.create(new ByteArrayInputStream(getRules().getBytes()), IFile.HIDDEN | IFile.FORCE, null);
		else
			rulesFile.setContents(new ByteArrayInputStream(getRules().getBytes()), IFile.HIDDEN | IFile.FORCE, null);
		FileEditorInput fileEditorInput = new FileEditorInput(rulesFile);

		int index = addPage(xtextEditor, fileEditorInput);
		setPageText(index, "Rules");

		xtextEditor.getDocument().addModelListener(new IXtextModelListener()
		{
			private boolean first = true;

			@Override
			public void modelChanged(XtextResource resource)
			{
				if (first)
					first = false;
				else if (!resource.getParseResult().hasSyntaxErrors())
				{
					esp.getModel().getRules().clear();
					for (EObject i : resource.getContents())
						if (i instanceof it.polito.security.esp.rulesLanguage.Model)
							analyze((it.polito.security.esp.rulesLanguage.Model) i);
				}
			}
		});
	}

	/**
	 * Analyzes a DSL model.
	 * @param model
	 *            The model to analyze.
	 **/
	private void analyze(it.polito.security.esp.rulesLanguage.Model model)
	{
		for (it.polito.security.esp.rulesLanguage.Rule i : model.getRules())
			analyze(i);
	}

	/**
	 * Analyzes a DSL rule.
	 * @param rule
	 *            The rule to analyze.
	 **/
	private void analyze(it.polito.security.esp.rulesLanguage.Rule rule)
	{
		Rule r = KbFactory.eINSTANCE.createRule();

		for (Condition i : rule.getConditions())
			if (i instanceof it.polito.security.esp.rulesLanguage.FunctionDeclaration)
			{
				it.polito.security.esp.rulesLanguage.FunctionDeclaration declaration = (it.polito.security.esp.rulesLanguage.FunctionDeclaration) i;
				FunctionDeclaration f = KbFactory.eINSTANCE.createFunctionDeclaration();

				f.setName(declaration.getName());
				for (ParameterType j : declaration.getParameters())
					if (j == ParameterType.CRYPTOGRAPHIC_KEY)
						f.getParameters().add(ApplicationPartType.CRYPTOGRAPHIC_KEY);
					else if (j == ParameterType.INITIALIZATION_VECTOR)
						f.getParameters().add(ApplicationPartType.INITIALIZATION_VECTOR);
					else if (j == ParameterType.PLAINTEXT)
						f.getParameters().add(ApplicationPartType.PLAINTEXT);
					else if (j == ParameterType.CIPHERTEXT)
						f.getParameters().add(ApplicationPartType.CIPHERTEXT);
					else if (j == ParameterType.IGNORE)
						f.getParameters().add(ApplicationPartType.IGNORE);

				r.getFunctionDeclarations().add(f);
			}

		if (rule.getAction() == Action.DECRYPT_AES128_CBC)
			r.setAction(ActionType.DECRYPT_AES128_CBC);
		else if (rule.getAction() == Action.DECRYPT_AES128_ECB)
			r.setAction(ActionType.DECRYPT_AES128_ECB);
		else if (rule.getAction() == Action.ENCRYPT_AES128_CBC)
			r.setAction(ActionType.ENCRYPT_AES128_CBC);
		else if (rule.getAction() == Action.ENCRYPT_AES128_ECB)
			r.setAction(ActionType.ENCRYPT_AES128_ECB);

		esp.getModel().getRules().add(r);
	}

	/**
	 * Retrieves the rules in the KB.
	 * @return The rules
	 **/
	private String getRules()
	{
		StringBuilder sb = new StringBuilder();

		for (Rule i : esp.getModel().getRules())
		{
			List<String> functions = new ArrayList<>();
			for (FunctionDeclaration j : i.getFunctionDeclarations())
			{
				List<String> parameters = new ArrayList<>();
				for (ApplicationPartType k : j.getParameters())
					if (k == ApplicationPartType.CIPHERTEXT)
						parameters.add("ciphertext");
					else if (k == ApplicationPartType.INITIALIZATION_VECTOR)
						parameters.add("initializationVector");
					else if (k == ApplicationPartType.PLAINTEXT)
						parameters.add("plaintext");
					else if (k == ApplicationPartType.CRYPTOGRAPHIC_KEY)
						parameters.add("cryptographicKey");
					else if (k == ApplicationPartType.IGNORE)
						parameters.add("_");
				functions.add(j.getName() + "(" + Strings.join(parameters, ", ") + ")");
			}
			String action = "<unknown>";
			if (i.getAction() == ActionType.DECRYPT_AES128_CBC)
				action = "decrypt:AES128-CBC";
			else if (i.getAction() == ActionType.DECRYPT_AES128_ECB)
				action = "decrypt:AES128-ECB";
			else if (i.getAction() == ActionType.ENCRYPT_AES128_CBC)
				action = "encrypt:AES128-CBC";
			else if (i.getAction() == ActionType.ENCRYPT_AES128_ECB)
				action = "encrypt:AES128-ECB";

			sb.append("if " + Strings.join(functions, ", ") + " then\n\t" + action + "\n");
		}

		return sb.toString();
	}

	/**
	 * Disposes the editor.
	 */
	@Override
	public void dispose()
	{
		espService.removeListener(this, esp.getModel());
		espService.dispose(esp.getModel());
		esp.close();

		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}

	/**
	 * Saves the editor's document.
	 * @param monitor
	 *            the monitor.
	 **/
	@Override
	public void doSave(IProgressMonitor monitor)
	{
		try
		{
			esp.save();
			espService.setDirty(esp.getModel(), false);
			firePropertyChange(PROP_DIRTY);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		monitor.done();
	}

	/**
	 * Saves the editor's document as another file.
	 **/
	@Override
	public void doSaveAs()
	{
	}

	/**
	 * Initializes the editor.
	 * @param site
	 *            The editor site.
	 * @param editorInput
	 *            The editor input.
	 **/
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException
	{
		super.init(site, editorInput);
		if (editorInput instanceof IFileEditorInput)
			try
			{
				file = ((IFileEditorInput) editorInput).getFile();
				setPartName(file.getProject().getName());
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	}

	/**
	 * Retrieves the dirty state of the editor.
	 **/
	@Override
	public boolean isDirty()
	{
		return espService.isDirty(esp.getModel());
	}

	/**
	 * Checks if a save is allowed.
	 * @return <code>true</code> if saving is allowed, <code>false</code> otherwise.
	 **/
	@Override
	public boolean isSaveAsAllowed()
	{
		return false;
	}

	/**
	 * Reacts to the resource change.
	 * @param event
	 *            The resource change event.
	 **/
	@Override
	public void resourceChanged(final IResourceChangeEvent event)
	{
		if (event.getType() == IResourceChangeEvent.PRE_CLOSE)
			Display.getDefault().asyncExec(new Runnable()
			{
				@Override
				public void run()
				{
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (IWorkbenchPage page : pages)
						if (((FileEditorInput) editor.getEditorInput()).getFile().getProject().equals(event.getResource()))
						{
							IEditorPart editorPart = page.findEditor(editor.getEditorInput());
							page.closeEditor(editorPart, true);
						}
				}
			});
	}

	/**
	 * Signals that the dirty state of model has changed.
	 * @param model
	 *            The model.
	 * @param dirty
	 *            The new dirty state of the model.
	 **/
	@Override
	public void dirtyStateChanged(Model model, boolean dirty)
	{
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run()
			{
				firePropertyChange(PROP_DIRTY);
			}
		});
	}

	/** The ESP. **/
	private ESP esp;
	/** The text editor used in page 0. */
	private TextEditor editor;
	/** The event generator. */
	private ESPEventGenerator eventGenerator;
	/** The file. **/
	private IFile file;
	/** The ESP service. **/
	private ESPService espService;
}

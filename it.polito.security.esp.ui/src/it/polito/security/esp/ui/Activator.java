package it.polito.security.esp.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator.
 * @author Daniele Canavese
 **/
public class Activator extends AbstractUIPlugin
{
	/**
	 * Retrieves the activator instance.
	 * @return The activator instance.
	 **/
	public static Activator getInstance()
	{
		return INSTANCE;
	}

	/** This instance. **/
	private static Activator INSTANCE;

	/** The plug-in id. **/
	public static final String PLUGIN_ID = "it.polito.security.esp.ui";

	/**
	 * The actions to performs when the plug-in is started.
	 * @param context
	 *            The context.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void start(BundleContext context) throws Exception
	{
		super.start(context);
		INSTANCE = this;
	}

	/**
	 * The actions to performs when the plug-in is stopped.
	 * @param context
	 *            The context.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	@Override
	public void stop(BundleContext context) throws Exception
	{
		INSTANCE = null;
		super.stop(context);
	}
}

package it.polito.security.esp.ui;

import org.eclipse.ui.services.AbstractServiceFactory;
import org.eclipse.ui.services.IServiceLocator;

/**
 * The ESP service factor.
 * @author Daniele Canavese
 **/
public class ESPServiceFactory extends AbstractServiceFactory
{
	/** The ESP service instance. **/
	private static ESPService instance = null;
	
	/**
	 * Creates a new ESP service object.
	 **/
	@SuppressWarnings("rawtypes")
	@Override
	public Object create(Class serviceInterface, IServiceLocator parentLocator, IServiceLocator locator)
	{
		if (serviceInterface.equals(ESPService.class))
		{
			if (instance == null)
				instance = new ESPService();
			
			return instance;
		}

		return null;
	}
}

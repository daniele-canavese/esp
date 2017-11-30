package it.polito.security.esp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IFile;

import it.polito.security.esp.kb.KBUtil;
import it.polito.security.esp.kb.Model;

/**
 * The ESP service.
 * @author Daniele Canavese
 **/
public class ESPService
{
	/** The IFile ESP map. **/
	private Map<IFile, Model> map;
	/** The reference counter map. **/
	private Map<Model, Integer> counters;
	/** The dirty states map. **/
	private Map<Model, Boolean> dirties;
	/** The listeners. **/
	private Map<Model, List<ESPDirtyListener>> listeners;

	/**
	 * The private constructor.
	 **/
	ESPService()
	{
		map = new HashMap<>();
		counters = new HashMap<>();
		dirties = new HashMap<>();
		listeners = new HashMap<>();
	}

	/**
	 * Retrieves the model related to an IFile object.
	 * @param file
	 *            The file.
	 * @return The related model object.
	 * @throws Exception
	 *             If something goes wrong.
	 **/
	public Model getModel(IFile file) throws Exception
	{
		Model model;

		if (map.containsKey(file))
		{
			model = map.get(file);
			counters.put(model, counters.get(model) + 1);
		}
		else
		{
			model = KBUtil.loadFromOntology(file);
			map.put(file, model);
			counters.put(model, 1);
			dirties.put(model, false);
		}

		return model;
}

	/**
	 * Checks the dirty state of a model.
	 * @param model
	 *            The model.
	 * @return The model dirty state.
	 **/
	public boolean isDirty(Model model)
	{
		if (dirties.containsKey(model))
			return dirties.get(model);
		else
			return false;
	}

	/**
	 * Changes the dirty state of a model.
	 * @param model
	 *            The model.
	 * @param value
	 *            The dirty state.
	 **/
	public void setDirty(Model model, boolean value)
	{
		boolean dirty = dirties.get(model);

		if (value != dirty)
		{
			dirties.put(model, value);
			for (ESPDirtyListener i : listeners.get(model))
				i.dirtyStateChanged(model, value);
		}
	}

	/**
	 * Disposes a model (it is remove from the internal cache).
	 * @param model
	 *            The model to dispose.
	 * @return The dirty state of the model.
	 **/
	public boolean dispose(Model model)
	{
		int counter = counters.get(model);
		boolean dirty = dirties.get(model);

		if (counter <= 1)
		{
			map.values().remove(model);
			counters.remove(model);
			dirties.remove(model);
		}
		else
			counters.put(model, counter - 1);

		return dirty;
	}

	/**
	 * Adds a new dirty state listener.
	 * @param listener
	 *            The listener to add.
	 * @param model
	 *            The model to listen to.
	 */
	public void addListener(ESPDirtyListener listener, Model model)
	{
		List<ESPDirtyListener> list;

		if (listeners.containsKey(model))
			list = listeners.get(model);
		else
		{
			list = new ArrayList<>();
			listeners.put(model, list);
		}

		list.add(listener);
	}

	/**
	 * Removes a dirty state listener.
	 * @param listener
	 *            The listener to remove.
	 * @param model
	 *            The model to listen to.
	 */
	public void removeListener(ESPDirtyListener listener, Model model)
	{
		if (listeners.containsKey(model))
		{
			List<ESPDirtyListener> list = listeners.get(model);
			list.remove(listener);
			if (list.isEmpty())
				listeners.remove(model);
		}
	}
}

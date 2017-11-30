package it.polito.security.esp.ui.editors;

import it.polito.security.esp.kb.Model;
import it.polito.security.esp.ui.listeners.Event;

/**
 * The type of labels.
 * @author Daniele Canavese
 **/
public enum LabelType
{
	/** The applications count label. **/
	ASSETS("icons/applicationParts.png", Event.APPLICATION_PARTS_UPDATED, new Getter()
	{
		@Override
		public String get(Model model)
		{
			return "Assets: " + model.getAssetsCount();
		}
	}),
	/** The applications count label. **/
	PROTECTIONS("icons/protection.png", Event.PROTECTIONS_UPDATED, new Getter()
	{
		@Override
		public String get(Model model)
		{
			return "Protections: " + model.getAvailableProtectionsCount();
		}
	}),
	/** The attacker tools count label. **/
	ATTACKER_TOOLS("icons/attackerTool.png", Event.ATTACKER_UPDATED, new Getter()
	{
		@Override
		public String get(Model model)
		{
			return "Attacker tools: " + model.getAvailableAttackerToolsCount();
		}
	}),
	/** The attack paths count label. **/
	ATTACK_PATHS("icons/attackPath.png", Event.ATTACK_PATH_UPDATED, new Getter()
	{
		@Override
		public String get(Model model)
		{
			return "Attack paths: " + model.getAttackPathsCount();
		}
	});

	/** The icon file. **/
	private String icon;
	/** The feature. **/
	private final Getter getter;
	/** The event. **/
	private final Event event;

	/**
	 * Creates a new label type.
	 * @param icon
	 *            The icon file.
	 * @param event
	 *            The event.
	 * @param getter
	 *            The getter to use.
	 **/
	LabelType(String icon, Event event, Getter getter)
	{
		this.icon = icon;
		this.event = event;
		this.getter = getter;
	}

	/**
	 * Retrieve the label string.
	 * @param model
	 *            The model.
	 * @return The label string.
	 **/
	public String getString(Model model)
	{
		return getter.get(model);
	}

	/**
	 * Retrieve the icon file.
	 * @return The icon file.
	 **/
	public String getIcon()
	{
		return icon;
	}

	/**
	 * Retrieve the event.
	 * @return The event.
	 **/
	public Event getEvent()
	{
		return event;
	}
}

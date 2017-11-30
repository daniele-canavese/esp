package it.polito.security.esp.l1p;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.AttackPath;

/**
 * Evaluates an attack path.
 * 
 * @author Daniele Canavese
 **/
public abstract class AttackEvaluator
{
	/** The ESP. **/
	protected ESP esp;

	/**
	 * Creates the connector.
	 * @param esp
	 *            The ESP.
	 **/
	public AttackEvaluator(ESP esp)
	{
		this.esp = esp;
	}

	/**
	 * Initializes the connector.
	 **/
	public void initialize()
	{
	}

	/**
	 * Retrieves the effort for an attack path.
	 * @param state
	 *            The state.
	 * @param attackPath
	 *            The attack path.
	 * @return The attack path effort.
	 **/
	public abstract double getEffort(State state, AttackPath attackPath);
}

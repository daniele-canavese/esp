package it.polito.security.esp.l1p;

import it.polito.security.esp.ESP;

/**
 * Evaluates a protection.
 * 
 * @author Daniele Canavese
 **/
public abstract class ProtectionEvaluator
{
	/** The ESP. **/
	protected ESP esp;

	/**
	 * Creates the evaluator.
	 * @param esp
	 *            The ESP.
	 **/
	public ProtectionEvaluator(ESP esp)
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
	 * Retrieves the strength for a set of protections.
	 * @param state
	 *            The state.
	 * @return The protection strength.
	 **/
	public abstract double getStrength(State state);
}

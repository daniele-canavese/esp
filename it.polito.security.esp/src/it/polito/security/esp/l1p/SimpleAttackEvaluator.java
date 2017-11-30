package it.polito.security.esp.l1p;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.AttackPath;

/**
 * Evaluates an attack path.
 * 
 * @author Daniele Canavese
 **/
public class SimpleAttackEvaluator extends AttackEvaluator
{
	/**
	 * Creates the evaluator.
	 * @param esp
	 *            The ESP.
	 **/
	public SimpleAttackEvaluator(ESP esp)
	{
		super(esp);
	}

	/**
	 * Retrieves the effort for an attack path.
	 * @param state
	 *            The state.
	 * @param attackPath
	 *            The attack path.
	 * @return The attack path effort.
	 **/
	public double getEffort(State state, AttackPath attackPath)
	{
		return 0.0f;
//		return attackPath.getCost();
	}
}

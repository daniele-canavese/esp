package it.polito.security.esp.l1p;

import it.polito.security.esp.ESP;

/**
 * Evaluates a protection.
 * 
 * @author Daniele Canavese
 **/
public class SimpleProtectionEvaluator extends ProtectionEvaluator
{
	/**
	 * Creates the evaluator.
	 * @param esp
	 *            The ESP.
	 **/
	public SimpleProtectionEvaluator(ESP esp)
	{
		super(esp);
	}

	/**
	 * Retrieves the strength for a set of protections.
	 * @param state
	 *            The state.
	 * @return The protection strength.
	 **/
	public double getStrength(State state)
	{
		double score = 0.0f;

//		for (List<AppliedProtectionInstantiation> i : state.getSolutionMap().values())
//			for (AppliedProtectionInstantiation j : i)
//			{
//				double assetWeight = j.getApplicationPart().getWeight();
//				score += assetWeight;
//			}

		return score;
	}
}

package it.polito.security.esp.l1p;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.ProtectionObjective;

/**
 * A search state.
 * @author Daniele Canavese
 **/
public class State
{
	/**
	 * Creates an empty state.
	 **/
	public State()
	{
		solutionMap = new HashMap<>();
		attackPaths = new ArrayDeque<>();
		predictedAttackPaths = new ArrayList<>();
	}

	/** The solution. **/
	private Map<List<ProtectionObjective>, List<AppliedProtectionInstantiation>> solutionMap;
	/** The attack paths. **/
	private Deque<AttackPath> attackPaths;
	/** The predicted attack paths. **/
	private List<AttackPath> predictedAttackPaths;

	/**
	 * Converts the object into a string.
	 * @return The string representation of the object.
	 **/
	@Override
	public String toString()
	{
		return solutionMap + " & " + attackPaths;
	}

	/**
	 * Retrieve the solution map.
	 * @return The solution map.
	 **/
	public Map<List<ProtectionObjective>, List<AppliedProtectionInstantiation>> getSolutionMap()
	{
		return solutionMap;
	}

	/**
	 * Retrieve the attack paths.
	 * @return The attack paths.
	 **/
	public Deque<AttackPath> getAttackPaths()
	{
		return attackPaths;
	}

	/**
	 * Retrieve the predicted attack paths.
	 * @return The predicted attack paths.
	 **/
	public List<AttackPath> getPredictedAttackPaths()
	{
		return predictedAttackPaths;
	}
}

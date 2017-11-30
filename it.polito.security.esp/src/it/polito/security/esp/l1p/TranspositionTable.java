package it.polito.security.esp.l1p;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.Protection;
import it.polito.security.esp.kb.ProtectionInstantiation;

/**
 * A transposition table with a LRU replacement politic.
 * @author Daniele Canavese
 **/
public class TranspositionTable
{
	/** The map. **/
	private Map<Long, StateData> map;
	/** The deque of the hashes. **/
	private Deque<Long> deque;
	/** The hit count. **/
	private long hitCount;
	/** The miss count. **/
	private long missCount;
	/** The ESP. **/
	private final ESP esp;
	/** The attack path hash codes. **/
	private Map<AttackPath, Long> attackPathHashCodes;
	/** The asset hash codes. **/
	private Map<ApplicationPart, Long> assetHashCodes;
	/** The protection instantiation hash codes. **/
	private Map<ProtectionInstantiation, Long> protectionInstantiationHashCodes;
	/** The random number generator. **/
	private Random random;

	/**
	 * Creates an empty transposition table.
	 * @param esp
	 *            The ESP.
	 **/
	public TranspositionTable(ESP esp)
	{
		this.esp = esp;
		map = new HashMap<>();
		deque = new ArrayDeque<>();
		attackPathHashCodes = new HashMap<>();
		assetHashCodes = new HashMap<>();
		protectionInstantiationHashCodes = new HashMap<>();
	}

	/**
	 * Clears the table.
	 **/
	public void clear()
	{
		map.clear();
	}

	/**
	 * Puts a state into the table.
	 * @param state
	 *            The state.
	 * @param value
	 *            The state value.
	 * @param ply
	 *            The state ply.
	 * @param type
	 *            The state type.
	 * @return The state data or <code>null</code> if the insertion cannot be performed.
	 **/
	public StateData put(State state, double value, int ply, StateType type)
	{
		StateData stateData = null;
		if (esp.getModel().getPreferences().getL1pTranspositionTableMaximumSize() > 0)
		{
			// Updates the table only if this data has a bigger ply then the stored one.
			boolean insert = false;
			long hashCode = getHashCode(state);
			if (map.containsKey(hashCode))
			{
				stateData = map.get(hashCode);
				insert = ply >= stateData.getPly();
			}
			else
				insert = true;
			if (insert)
			{
				if (map.size() > esp.getModel().getPreferences().getL1pTranspositionTableMaximumSize())
					map.remove(deque.poll());
				stateData = new StateData(value, ply, type);
				map.put(hashCode, stateData);
				deque.add(hashCode);
			}
		}

		return stateData;
	}

	/**
	 * Retrieves a state data.
	 * @param state
	 *            The state.
	 * @param ply
	 *            The state ply.
	 * @return The state data or null if no such state exists in the table.
	 **/
	public StateData getData(State state, int ply)
	{
		if (esp.getModel().getPreferences().getL1pTranspositionTableMaximumSize() > 0)
		{
			Long hashCode = getHashCode(state);
			if (map.containsKey(hashCode))
			{
				// Retrieves the data only if the stored state ply is equal to or greater than the current one.
				StateData stateData = map.get(hashCode);
				if (stateData.getPly() >= ply)
				{
					hitCount++;
					return stateData;
				}
				else
				{
					missCount++;
					return null;
				}
			}
			else
			{
				missCount++;
				return null;
			}
		}
		else
			return null;
	}

	/**
	 * Computes the hashcode of a state
	 * @param state
	 *            The state.
	 * @return The state hashcode.
	 **/
	private Long getHashCode(State state)
	{
		long hashCode = 0;

		int count = 1;
		for (List<AppliedProtectionInstantiation> i : state.getSolutionMap().values())
			for (AppliedProtectionInstantiation j : i)
				hashCode ^= (assetHashCodes.get(j.getApplicationPart())
						^ protectionInstantiationHashCodes.get(j.getProtectionInstantiation())) * ++count;

		for (AttackPath i : state.getAttackPaths())
			hashCode ^= attackPathHashCodes.get(i);

		return hashCode;
	}

	/**
	 * Retrieve the hit count.
	 * @return The hit count.
	 **/
	public long getHitCount()
	{
		return hitCount;
	}

	/**
	 * Retrieve the miss count.
	 * @return The miss count.
	 **/
	public long getMissCount()
	{
		return missCount;
	}

	/**
	 * Initializes the transposition table.
	 **/
	public void initialize()
	{
		random = new Random(0);

		for (ApplicationPart j : esp.getModel().getAssets())
			assetHashCodes.put(j, random.nextLong());
		for (Protection j : esp.getModel().getProtections())
			for (ProtectionInstantiation k : j.getInstantiations())
				protectionInstantiationHashCodes.put(k, random.nextLong());
		for (AttackPath j : esp.getModel().getAttackPaths())
			attackPathHashCodes.put(j, random.nextLong());

		hitCount = 0;
		missCount = 0;
	}
}

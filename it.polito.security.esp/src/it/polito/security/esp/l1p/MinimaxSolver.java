package it.polito.security.esp.l1p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.KbFactory;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.Preferences;
import it.polito.security.esp.kb.ProtectionObjective;
import it.polito.security.esp.kb.Solution;
import it.polito.security.esp.kb.SolutionSequence;
import it.polito.security.esp.metrics.MetricsFramework;
import it.polito.security.esp.util.Collections;

/**
 * Finds the golden solution using a mini-max algorithm.
 * @author Daniele Canavese
 **/
public class MinimaxSolver extends SolutionSolver
{
	/** The number of millisecond that will trigger a log. **/
	private static final int LOG_TRIGGER = 5000;
	/** The number of solutions. **/
	private long solutionsCount;
	/** The number of states. **/
	private long statesCount;
	/** The number of accepted solutions. **/
	private long acceptedSolutionsCount;
	/** The number of rejected solutions. **/
	private long rejectedSolutionsCount;
	/** The number of rejected partial solutions. **/
	private long rejectedPartialSolutionsCount;
	/** The number of states where the pruning was executed. **/
	private long pruningStates;
	/** The transposition table. **/
	private TranspositionTable transpositionTable;
	/** The state evaluator. **/
	private StateEvaluator stateEvaluator;
	/** The attack paths. **/
	private Collection<AttackPath> attackPaths;
	/** The GA framework. **/
	// private GeneticAlgorithm<AppliedProtectionInstantiation> ga;

	/**
	 * Creates the solver.
	 * 
	 * @param esp
	 *            The ESP.
	 * @param attackEvaluator
	 *            The attack evaluator.
	 * @param protectionEvaluator
	 *            The protection evaluator.
	 **/
	public MinimaxSolver(ESP esp, AttackEvaluator attackEvaluator, ProtectionEvaluator protectionEvaluator)
	{
		super(esp, attackEvaluator, protectionEvaluator);
		transpositionTable = new TranspositionTable(esp);
		stateEvaluator = new StateEvaluator(esp);
		attackPaths = new HashSet<>();
		// ga = new GeneticAlgorithm<>();
	}

	/**
	 * Finds the golden solution.
	 **/
	public void run()
	{
		int timeout = esp.getModel().getPreferences().getL1pTimeLimit() * 1000;
		transpositionTable.initialize();
		solutionWalker.initialize1();

		int trees;
		if (esp.getModel().getPreferences().getL1pMultiTreeMultiplier() > 0)
			trees = solutionWalker.getCodeCorrelationSets().size();
		else
			trees = 1;

		// Creates the trees.
		List<List<Solution>> partials = new ArrayList<>();
		long trueStart = System.currentTimeMillis();
		statesCount = 0;
		pruningStates = 0;
		acceptedSolutionsCount = 0;
		rejectedSolutionsCount = 0;
		for (int i = 0; i < trees; ++i)
		{
			long start = System.currentTimeMillis();
			double score = Double.NEGATIVE_INFINITY;
			List<Solution> s = new ArrayList<>();
			double alpha = Double.NEGATIVE_INFINITY;
			double beta = Double.POSITIVE_INFINITY;

			if (!Double.isNaN(esp.getModel().getPreferences().getL1pInitialAlpha()))
				alpha = esp.getModel().getPreferences().getL1pInitialAlpha();
			if (!Double.isNaN(esp.getModel().getPreferences().getL1pInitialBeta()))
				beta = esp.getModel().getPreferences().getL1pInitialBeta();

			// boolean notFirst = false;
			for (int j = 1; j <= esp.getModel().getPreferences().getL1pMainSearchMaximumDepth(); ++j)
			{
				solutionsCount = 0;
				int size;
				if (esp.getModel().getPreferences().getL1pMultiTreeMultiplier() > 0)
					size = solutionWalker.initialize2(i);
				else
					size = solutionWalker.initialize2(-1);

				if (size == 0)
					continue;

				attackPaths.clear();
				for (AttackPath k : esp.getModel().getAttackPaths())
					if (Collections.containsAny(solutionWalker.getCurrentProtectionObjectives(), k.getProtectionObjectives()))
						attackPaths.add(k);

				if (j == 1)
				{
					if (esp.getModel().getPreferences().getL1pMultiTreeMultiplier() > 0)
						log.fine("Searching for partial solution with order " + size + " = "
								+ solutionWalker.getCodeCorrelationSets().get(i));
					else
						log.fine("Searching for global solution with order " + size + " = " + solutionWalker.getCodeCorrelationSets());
					log.fine(String.format("%1s  %15s  %15s  %15s  %15s  %15s  %15s", " ", "Depth", "BestScore", "Alpha", "Beta",
							"Solutions", "Time"));
				}

				long delta = System.currentTimeMillis() - start;
				log.fine(String.format("%1s  %15d  % 15.3f  % 15.3f  % 15.3f  % 15d  % 15.3f", " ", j, score, alpha, beta, solutionsCount,
						delta / 1000.0f));
				getSolutions().clear();
				// notFirst = true;

				double currentScore;
				// int threshold = esp.getModel().getPreferences().getGaThreshold();
				// if (threshold >= 0 && size >= threshold)
				// currentScore = evolve(alpha, beta, start);
				// else
				currentScore = findMax(alpha, beta, j, start);
				acceptedSolutionsCount += solutionWalker.getAcceptedSolutionsCount();
				rejectedSolutionsCount += solutionWalker.getRejectedSolutionsCount();
				rejectedPartialSolutionsCount += solutionWalker.getRejectedPartialSolutionsCount();

				if (currentScore == Double.NEGATIVE_INFINITY)
				{
					log.severe("No suitable solutions found");
					break;
				}

				if (currentScore <= alpha)
				{
					log.fine(String.format("%1s  %15d  % 15.3f  % 15.3f  % 15.3f  % 15d  % 15.3f", "<", j, currentScore, alpha, beta,
							solutionsCount, delta / 1000.0f));
					alpha -= esp.getModel().getPreferences().getL1pResearchDelta();
					--j;
				}
				else if (currentScore >= beta)
				{
					log.fine(String.format("%1s  %15d  % 15.3f  % 15.3f  % 15.3f  % 15d  % 15.3f", ">", j, currentScore, alpha, beta,
							solutionsCount, delta / 1000.0f));
					beta += esp.getModel().getPreferences().getL1pResearchDelta();
					--j;
				}
				else
				{
					log.fine(String.format("%1s  %15d  % 15.3f  % 15.3f  % 15.3f  % 15d  % 15.3f", "*", j, currentScore, alpha, beta,
							solutionsCount, delta / 1000.0f));

					score = currentScore;
					alpha = score - esp.getModel().getPreferences().getL1pResearchDelta();
					beta = score + esp.getModel().getPreferences().getL1pResearchDelta();
				}

				if (timeout > 0 && System.currentTimeMillis() - start > timeout)
				{
					log.info("Timeout reached");
					if (j == 1)
					{
						s.clear();
						s.addAll(getSolutions());
						log.warning("Iteration 1 result");
					}
					break;
				}
				s.clear();
				s.addAll(getSolutions());
			}

			getSolutions().clear();
			getSolutions().addAll(s);
			if (getSolutions().isEmpty())
			{
				if (esp.getModel().getPreferences().getL1pMultiTreeMultiplier() > 0)
					log.severe("Unable to find the partial golden solution");
				else
					log.severe("Unable to find the golden solution");
			}
			else
			{
				if (trees == 1)
					log.fine(String.format("Golden solution = %.3f for %s ", score, getSolutions().get(0)));
				else
					log.fine(String.format("Partial golden solution = %.3f for %s ", score, getSolutions().get(0)));
			}
			partials.add(s);
		}

		// Merges the partial solutions together, if needed.
		if (esp.getModel().getPreferences().getL1pMultiTreeMultiplier() > 0 && trees > 1)
			fullMerge(partials, trueStart);
		if (trees > 1 && !getSolutions().isEmpty())
		{
			log.fine(String.format("Golden solution = %.3f for %s ", getSolutions().get(0).getL1pScore(), getSolutions().get(0)));
		}
		// Finalizes the solutions.
		long stop = System.currentTimeMillis();
		adjustSolutions((stop - trueStart) / 1000.0f);
		log.info(String.format("States = %d total (%d non-pruning + %d pruning)", statesCount, statesCount - pruningStates, pruningStates));
		log.info(String.format("Solutions = %d total (%d accepted + %d rejected + %d partials rejected)",
				acceptedSolutionsCount + rejectedPartialSolutionsCount + rejectedSolutionsCount, acceptedSolutionsCount,
				rejectedSolutionsCount, rejectedPartialSolutionsCount));
		log.info(String.format("Transposition table =  %d searches (%d hits + %d misses)",
				transpositionTable.getHitCount() + transpositionTable.getMissCount(), transpositionTable.getHitCount(),
				transpositionTable.getMissCount()));
		log.info(String.format("L1P inferred = %.3f s", (stop - trueStart) / 1000.0f));
	}

	/**
	 * Adjusts the solutions.
	 * @param time
	 *            The computation time.
	 **/
	private void adjustSolutions(float time)
	{
		for (Solution i : getSolutions())
		{
			for (SolutionSequence j : i.getSolutionSequences())
				for (int k = 0; k < j.getAppliedProtectionInstantiations().size(); ++k)
				{
					// We replace the applied PIs in the sequence with the applied PIs in the model, just for coherence.
					AppliedProtectionInstantiation pi = j.getAppliedProtectionInstantiations().get(k);
					for (AppliedProtectionInstantiation l : esp.getModel().getAppliedProtectionInstantiations())
						if (pi.equals(l))
						{
							j.getAppliedProtectionInstantiations().set(k, l);
							break;
						}
				}
			i.setL1pTime(time);
			i.setClientTimeOverhead(esp.getMetricsFramework().getClientTimeOverhead(esp.getModel().getVanillaSolution(), i, null));
			i.setServerTimeOverhead(esp.getMetricsFramework().getServerTimeOverhead(esp.getModel().getVanillaSolution(), i, null));
			i.setClientMemoryOverhead(esp.getMetricsFramework().getClientMemoryOverhead(esp.getModel().getVanillaSolution(), i, null));
			i.setServerMemoryOverhead(esp.getMetricsFramework().getServerMemoryOverhead(esp.getModel().getVanillaSolution(), i, null));
			i.setNetworkOverhead(esp.getMetricsFramework().getNetworkOverhead(esp.getModel().getVanillaSolution(), i, null));
		}
	}

	/**
	 * Merges the partial solutions into the final ones exploring all the tuples.
	 * @param partials
	 *            The partial solutions.
	 * @param start
	 *            The ESP starting time.
	 **/
	private void fullMerge(List<List<Solution>> partials, long start)
	{
		log.fine("Merging partial solutions...");

		partials.sort(new Comparator<List<Solution>>()
		{
			@Override
			public int compare(List<Solution> o1, List<Solution> o2)
			{
				Set<ProtectionObjective> po1 = new HashSet<>();
				for (Solution i : o1)
					for (SolutionSequence j : i.getSolutionSequences())
						for (AppliedProtectionInstantiation k : j.getAppliedProtectionInstantiations())
							po1.addAll(k.getProtectionObjectives());
				double s1 = 0.0;
				for (ProtectionObjective i : po1)
					s1 += i.getApplicationPart().getWeight();

				Set<ProtectionObjective> po2 = new HashSet<>();
				for (Solution i : o2)
					for (SolutionSequence j : i.getSolutionSequences())
						for (AppliedProtectionInstantiation k : j.getAppliedProtectionInstantiations())
							po1.addAll(k.getProtectionObjectives());
				double s2 = 0.0;
				for (ProtectionObjective i : po2)
					s2 += i.getApplicationPart().getWeight();

				if (s1 > s2)
					return -1;
				else if (s2 > s1)
					return 1;
				else
					return 0;
			}
		});

		getSolutions().clear();
		List<Integer> values = new ArrayList<>();
		for (List<Solution> i : partials)
			values.add(i.size());
		List<Integer> vector = new ArrayList<>();
		IntegerTupleWalker w = new IntegerTupleWalker(values, vector);

		int count = 0;
		int timeout = esp.getModel().getPreferences().getL1pTimeLimit() * 1000;
		while (w.computeNext())
		{
			if (timeout > 0 && System.currentTimeMillis() - start > timeout)
			{
				log.info("Timeout reached");
				break;
			}

			Solution s = KbFactory.eINSTANCE.createSolution();
			s.setL1pScore(0);
			for (int i = 0; i < partials.size(); ++i)
			{
				List<Solution> partial = partials.get(i);
				if (!partial.isEmpty())
				{
					Solution local = partial.get(vector.get(i) - 1);
					s.getSolutionSequences().add(local.getSolutionSequences().get(0));
					s.setL1pScore(s.getL1pScore() + local.getL1pScore());
					s.getAttackPaths().addAll(local.getAttackPaths());
				}
			}

			if (s.getSolutionSequences().isEmpty())
				continue;

			// Overhead checks.
			double clientTimeOverheadLimit = Double.POSITIVE_INFINITY;
			Preferences preferences = esp.getModel().getPreferences();
			if (preferences.getL1pClientTimeOverheadPercentage() > 0.0)
				clientTimeOverheadLimit = preferences.getClientTimeOverhead() / 100.0
						* (preferences.getL1pClientTimeOverheadPercentage() / 100.0);
			double serverTimeOverheadLimit = Double.POSITIVE_INFINITY;
			if (preferences.getL1pServerTimeOverheadPercentage() > 0.0)
				serverTimeOverheadLimit = preferences.getServerTimeOverhead() / 100.0
						* (preferences.getL1pServerTimeOverheadPercentage() / 100.0);
			double clientMemoryOverheadLimit = Double.POSITIVE_INFINITY;
			if (preferences.getL1pClientMemoryOverheadPercentage() > 0.0)
				clientMemoryOverheadLimit = preferences.getClientMemoryOverhead() / 100.0
						* (preferences.getL1pClientMemoryOverheadPercentage() / 100.0);
			double serverMemoryOverheadLimit = Double.POSITIVE_INFINITY;
			if (preferences.getL1pServerMemoryOverheadPercentage() > 0.0)
				serverMemoryOverheadLimit = preferences.getServerMemoryOverhead() / 100.0
						* (preferences.getL1pServerMemoryOverheadPercentage() / 100.0);
			double networkOverheadLimit = Double.POSITIVE_INFINITY;
			if (preferences.getL1pNetworkOverheadPercentage() > 0.0)
				networkOverheadLimit = preferences.getNetworkOverhead() / 100.0 * (preferences.getL1pNetworkOverheadPercentage() / 100.0);

			Solution vanillaSolution = esp.getModel().getVanillaSolution();
			MetricsFramework framework = esp.getMetricsFramework();

			double clientTimeOverhead = framework.getClientTimeOverhead(vanillaSolution, s, null);
			double serverTimeOverhead = framework.getServerTimeOverhead(vanillaSolution, s, null);
			double clientMemoryOverhead = framework.getClientMemoryOverhead(vanillaSolution, s, null);
			double serverMemoryOverhead = framework.getServerMemoryOverhead(vanillaSolution, s, null);
			double networkOverhead = framework.getNetworkOverhead(vanillaSolution, s, null);

			if (clientTimeOverhead <= clientTimeOverheadLimit && serverTimeOverhead <= serverTimeOverheadLimit
					&& clientMemoryOverhead <= clientMemoryOverheadLimit && serverMemoryOverhead <= serverMemoryOverheadLimit
					&& networkOverhead <= networkOverheadLimit)
			{
				getSolutions().add(s);
				if (++count >= esp.getModel().getPreferences().getL1pSolutionsCount())
					break;
			}
		}
	}

	/**
	 * Retrieves the score of a max node (a protection solution node) using a genetic algorithm.
	 * @param size
	 *            The number of applied PIs.
	 * @param alpha
	 *            The alpha bound.
	 * @param beta
	 *            The beta bound.
	 * @param searchStart
	 *            The search start time.
	 * @return The score of a max node.
	 **/
	// private double evolve(double alpha, double beta, long searchStart)
	// {
	// List<List<List<AppliedProtectionInstantiation>>> population = smartInitialize();
	// ClearingFunction<AppliedProtectionInstantiation> clearingFunction = null;
	// SelectionFunction<AppliedProtectionInstantiation> selectionFunction = null;
	// CrossoverFunction<AppliedProtectionInstantiation> crossoverFunction = null;
	// MutationFunction<AppliedProtectionInstantiation> mutationFunction = null;
	// FitnessFunction<AppliedProtectionInstantiation> fitnessFunction = null;
	// int matingPoolSize = 1;
	// int elitismSize = 1;
	// long seed = 1;
	// ga.initialize(population, clearingFunction, selectionFunction, crossoverFunction, mutationFunction, fitnessFunction,
	// matingPoolSize,
	// elitismSize, seed);
	//
	// Integer timeout=null;
	// Integer generationLimit=null;
	// TerminationFunction<AppliedProtectionInstantiation> terminationFunction=null;
	// ga.evolve(timeout, generationLimit, terminationFunction);

	// return 0;
	// }

	/**
	 * Creates the initial population for the GA. This method <b>must</b> be deterministic.
	 * @return The initial GA population.
	 **/
	// private List<List<List<AppliedProtectionInstantiation>>> smartInitialize()
	// {
	// List<List<List<AppliedProtectionInstantiation>>> population = new ArrayList<>();
	//
	// // First, we select the best solution (or a very good one, hopefully).
	// population.add(getBestChromosome());
	// // Then, we generate all the other chromosomes with a very strong mutation.
	//
	// return population;
	// }

	/**
	 * Retrieves a possible best chromosome.
	 * @return A candidate best chromosome.
	 **/
	// private List<List<AppliedProtectionInstantiation>> getBestChromosome()
	// {
	// List<List<AppliedProtectionInstantiation>> best = new ArrayList<>();
	//
	// return best;
	// }

	/**
	 * Retrieves the score of a max node (a protection solution node) using the alpha-beta search.
	 * @param alpha
	 *            The alpha bound.
	 * @param beta
	 *            The beta bound.
	 * @param ply
	 *            The current search ply.
	 * @param searchStart
	 *            The search start time.
	 * @return The score of a max node.
	 **/
	private double findMax(double alpha, double beta, int ply, long searchStart)
	{
		int timeLimit = esp.getModel().getPreferences().getL1pTimeLimit() * 1000 / solutionWalker.getCodeCorrelationSets().size();
		int solutionsLimit = esp.getModel().getPreferences().getL1pSolutionsLimit();
		long start = System.currentTimeMillis();
		++statesCount;

		double a = alpha;

		log.finest("Searching the max for " + state);

		Double g = Double.NEGATIVE_INFINITY;
		long lastLogTime = start;
		while (g < beta && solutionWalker.computeNext())
		{
			long now = System.currentTimeMillis();
			long delta = now - start;
			++solutionsCount;

			stateEvaluator.evaluateSolution(state);
			double c = findMin(a, beta, ply - 1);
			if (c > g)
			{
				addSolution(state, c);
				g = c;
			}
			a = Math.max(a, g);

			if (now - lastLogTime >= LOG_TRIGGER)
			{
				log.fine(String.format("%1s  %15d  % 15.3f  % 15.3f  % 15.3f  % 15d  % 15.3f", " ", ply, g, alpha, beta, solutionsCount,
						delta / 1000.0f));
				lastLogTime = now;
			}
			if (timeLimit > 0 && delta > timeLimit)
				break;
			if (solutionsLimit > 0 && solutionsCount > solutionsLimit)
				break;
		}

		return g;
	}

	/**
	 * Retrieves the score of a min node (an attacker node) using the alpha-beta search.
	 * @param alpha
	 *            The alpha bound.
	 * @param beta
	 *            The beta bound.
	 * @param ply
	 *            The current search ply.
	 * @return The score of a min node.
	 **/
	private double findMin(double alpha, double beta, int ply)
	{
		++statesCount;

		StateData data = transpositionTable.getData(state, ply);
		if (data != null)
		{
			if (data.getType() == StateType.EXACT_NODE)
				return data.getValue();
			else if (data.getType() == StateType.LOWER_NODE)
			{
				if (data.getValue() >= beta)
					return data.getValue();
				else
					beta = Math.min(beta, data.getValue());
			}
			else if (data.getType() == StateType.UPPER_NODE)
			{
				if (data.getValue() >= alpha)
					return data.getValue();
				else
					alpha = Math.max(alpha, data.getValue());
			}
		}
		else
			data = transpositionTable.put(state, 0, ply, StateType.INVALID_NODE);
		double b = beta;

		if (ply == 3 && esp.getModel().getPreferences().getL1pRazoringMargin() > 0)
		{
			double value = evaluate();
			if (value + esp.getModel().getPreferences().getL1pRazoringMargin() <= alpha)
			{
				++pruningStates;
				--ply;
			}
		}

		if (ply == 0)
			return evaluate();
		else if (ply == 1 && esp.getModel().getPreferences().getL1pFutilityMargin() > 0)
		{
			double value = evaluate();
			if (value + esp.getModel().getPreferences().getL1pFutilityMargin() <= alpha)
			{
				++pruningStates;
				return value;
			}
		}
		else if (ply == 2 && esp.getModel().getPreferences().getL1pExtendedFutilityMargin() > 0)
		{
			double value = evaluate();
			if (value + esp.getModel().getPreferences().getL1pExtendedFutilityMargin() <= alpha)
			{
				++pruningStates;
				return value;
			}
		}

		log.finest("Searching the min for " + state);

		Double g = Double.POSITIVE_INFINITY;
		Iterator<AttackPath> iterator = attackPaths.iterator();
		while (g > alpha && iterator.hasNext())
		{
			AttackPath i = iterator.next();
			if (esp.getModel().getPreferences().getL1pMultiTreeMultiplier() > 0)
			{
				List<ProtectionObjective> pos = state.getSolutionMap().keySet().iterator().next();
				if (!Collections.containsAny(pos, i.getProtectionObjectives()))
					continue;
			}

			state.getAttackPaths().push(i);
			Double oldg = g;
			g = Math.min(g, findMin(alpha, b, ply - 1));
			b = Math.min(b, g);
			state.getAttackPaths().pop();
			if (g != oldg)
			{
				int index = state.getAttackPaths().size();
				if (state.getPredictedAttackPaths().size() > index)
					state.getPredictedAttackPaths().set(index, i);
				else
					state.getPredictedAttackPaths().add(i);
			}
		}

		if (data != null)
		{
			if (g <= alpha)
			{
				data.setValue(g);
				data.setType(StateType.UPPER_NODE);
			}
			else if (g > alpha && g < beta)
			{
				data.setValue(g);
				data.setType(StateType.EXACT_NODE);
			}
			else if (g >= beta)
			{
				data.setValue(g);
				data.setType(StateType.LOWER_NODE);
			}
		}

		return g;
	}

	/**
	 * Retrieves the score of a leaf.
	 * @return The leaf score.
	 **/
	private double evaluate()
	{
		double score = stateEvaluator.evaluateState(state);

		log.finest("Score for " + state + " = " + score);

		return score;
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(MinimaxSolver.class.getName());
}

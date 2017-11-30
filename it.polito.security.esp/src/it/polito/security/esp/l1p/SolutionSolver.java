package it.polito.security.esp.l1p;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.KbFactory;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.Solution;
import it.polito.security.esp.kb.SolutionSequence;

/**
 * Finds the golden solution.
 * @author Daniele Canavese
 **/
public abstract class SolutionSolver
{
	/** The solution walker. **/
	protected SolutionWalker solutionWalker;
	/** The ESP. **/
	protected final ESP esp;
	/** The current state. **/
	protected State state;
	/** The attack evaluator. **/
	protected AttackEvaluator attackEvaluator;
	/** The protection evaluator. **/
	protected ProtectionEvaluator protectionEvaluator;
	/** The solutions. **/
	private List<Solution> solutions;

	/**
	 * Creates the solver.
	 * @param esp
	 *            The ESP.
	 * @param attackEvaluator
	 *            The attack evaluator.
	 * @param protectionEvaluator
	 *            The protection evaluator.
	 **/
	public SolutionSolver(ESP esp, AttackEvaluator attackEvaluator, ProtectionEvaluator protectionEvaluator)
	{
		this.esp = esp;
		this.attackEvaluator = attackEvaluator;
		this.protectionEvaluator = protectionEvaluator;
		state = new State();
		solutionWalker = new SolutionWalker(esp, state.getSolutionMap());
		solutions = new ArrayList<>();
	}

	/**
	 * Finds the golden solution.
	 **/
	public abstract void run();

	/**
	 * Adds a new solution to the best ones.
	 * @param state
	 *            The state to add.
	 * @param score
	 *            The score of the actual solution.
	 **/
	protected void addSolution(State state, double score)
	{
		Solution solution = KbFactory.eINSTANCE.createSolution();
		for (List<AppliedProtectionInstantiation> i : state.getSolutionMap().values())
		{
			SolutionSequence solutionSequence = KbFactory.eINSTANCE.createSolutionSequence();
			for (AppliedProtectionInstantiation j : i)
				solutionSequence.getAppliedProtectionInstantiations().add(EcoreUtil.copy(j));
			solution.getSolutionSequences().add(solutionSequence);
			solution.getAttackPaths().addAll(state.getPredictedAttackPaths());
		}
		solution.setL1pScore(score);
		solutions.add(0, solution);

		if (solutions.size() > esp.getModel().getPreferences().getL1pSolutionsCount())
			solutions.remove(solutions.size() - 1);
	}

	/**
	 * Retrieves the solutions.
	 * @return The solutions.
	 **/
	public List<Solution> getSolutions()
	{
		return solutions;
	}
}

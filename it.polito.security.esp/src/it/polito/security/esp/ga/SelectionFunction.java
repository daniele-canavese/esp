package it.polito.security.esp.ga;

import java.util.List;

/**
 * A selection function for a genetic algorithm.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public abstract class SelectionFunction<T>
{
	/** The genetic algorithm. **/
	protected GeneticAlgorithm<T> geneticAlgorithm;

	/**
	 * Sets the genetic algorithm.
	 * @param geneticAlgorithm
	 *            The genetic algorithm.
	 **/
	public void setGeneticAlgorithm(GeneticAlgorithm<T> geneticAlgorithm)
	{
		this.geneticAlgorithm = geneticAlgorithm;
	}

	/**
	 * Selects some interesting chromosomes from a population.
	 * @param quantity
	 *            The number of chromosomes to select.
	 * @param selection
	 *            The selection.
	 **/
	public abstract void select(int quantity, List<List<List<T>>> selection);
}

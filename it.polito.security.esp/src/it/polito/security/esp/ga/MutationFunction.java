package it.polito.security.esp.ga;

import java.util.List;

/**
 * A mutation function for a genetic algorithm.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public abstract class MutationFunction<T>
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
	 * Mutate a chromosome.
	 * @param chromosome
	 *            The chromosome to mutate.
	 **/
	public abstract void mutate(List<List<T>> chromosome);
}

package it.polito.security.esp.ga;

import java.util.List;

/**
 * A crossover function for a genetic algorithm.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public abstract class CrossoverFunction<T>
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
	 * Generates a child chromosome.
	 * @param chromosome1
	 *            The first parent chromosome.
	 * @param chromosome2
	 *            The second parent chromosome.
	 * @return The child chromosome.
	 **/
	public abstract List<List<T>> crossover(List<List<T>> chromosome1, List<List<T>> chromosome2);
}

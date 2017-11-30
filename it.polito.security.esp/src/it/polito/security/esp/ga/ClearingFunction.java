package it.polito.security.esp.ga;

/**
 * A clearing function for a genetic algorithm.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public abstract class ClearingFunction<T>
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
	 * Clears the population.
	 **/
	public abstract void clear();
}

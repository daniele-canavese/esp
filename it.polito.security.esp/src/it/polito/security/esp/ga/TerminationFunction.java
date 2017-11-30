package it.polito.security.esp.ga;

/**
 * A termination function.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public abstract class TerminationFunction<T>
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
	 * Checks if the evolution should stop or not.
	 * @return <code>true</code> if the genetic algorithm should stop, <code>false</code> otherwise.
	 **/
	public abstract boolean check();
}

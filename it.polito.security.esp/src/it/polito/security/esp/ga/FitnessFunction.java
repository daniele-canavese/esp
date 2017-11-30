package it.polito.security.esp.ga;

import java.util.List;

/**
 * The fitness function for a genetic algorithm.<br/>
 * As a rule of thumb, the higher the fitness value the better a chromosome is.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public interface FitnessFunction<T>
{
	/**
	 * Retrieves the fitness of a chrommosome.
	 * @param chromosome
	 *            The chromosome to evaluate.
	 * @return The fitness of the chromosome.
	 **/
	public double evaluate(List<List<T>> chromosome);
}

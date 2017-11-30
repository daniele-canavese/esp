package it.polito.security.esp.ga;

import java.util.Arrays;
import java.util.List;

/**
 * The roulette wheel selection method with replacement.<br/>
 * The probability of a chromosome to be selected is proportional to its fitness.
 * @param <T>
 *            The gene class.
 * @author Daniele Canavese
 **/
public class RouletteWheelSelection<T> extends SelectionFunction<T>
{
	/**
	 * Selects some interesting chromosomes from a population.
	 * @param quantity
	 *            The number of chromosomes to select.
	 * @param selection
	 *            The selection.
	 **/
	public void select(int quantity, List<List<List<T>>> selection)
	{
		selection.clear();

		double[] c = new double[geneticAlgorithm.population.size()];
		c[0] = geneticAlgorithm.fitnessValues.get(geneticAlgorithm.population.get(0));
		for (int i = 1; i < geneticAlgorithm.population.size(); i++)
		{
			double fitness = geneticAlgorithm.fitnessValues.get(geneticAlgorithm.population.get(i));
			c[i] = c[i - 1] + fitness;
		}

		for (int i = 0; i < quantity; i++)
		{
			double randomFitness = geneticAlgorithm.random.nextDouble() * c[c.length - 1];
			int index = Arrays.binarySearch(c, randomFitness);
			if (index < 0)
				index = Math.abs(index + 1);
			if (index == geneticAlgorithm.population.size())
				--index;
			selection.add(geneticAlgorithm.population.get(index));
		}
	}
}

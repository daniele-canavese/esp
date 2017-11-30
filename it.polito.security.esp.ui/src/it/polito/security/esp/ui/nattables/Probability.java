package it.polito.security.esp.ui.nattables;

import it.polito.security.esp.kb.AttackStepType;
import it.polito.security.esp.kb.Level;

/**
 * An attack probability.
 * @author Daniele Canavese
 **/
public class Probability
{
	/** The attack step type. **/
	private AttackStepType type;
	/** The guru probability. **/
	private Level guruProbability;
	/** The expert probability. **/
	private Level expertProbability;
	/** The geek probability. **/
	private Level geekProbability;
	/** The amateur probability. **/
	private Level amateurProbability;

	/**
	 * Creates a probability.
	 * @param type
	 *            The attack step type.
	 * @param guruProbability
	 *            The guru probability.
	 * @param expertProbability
	 *            The expert probability.
	 * @param geekProbability
	 *            The geek probability.
	 * @param amateurProbability
	 *            The amateur probability.
	 **/
	public Probability(AttackStepType type, Level guruProbability, Level expertProbability, Level geekProbability, Level amateurProbability)
	{
		this.type = type;
		this.guruProbability = guruProbability;
		this.expertProbability = expertProbability;
		this.geekProbability = geekProbability;
		this.amateurProbability = amateurProbability;
	}

	/**
	 * Retrieves the attack step type.
	 * @return The attack step type.
	 **/
	public AttackStepType getType()
	{
		return type;
	}

	/**
	 * Retrieves the guru probability.
	 * @return The guru probability.
	 **/
	public Level getGuruProbability()
	{
		return guruProbability;
	}

	/**
	 * Retrieves the expert probability.
	 * @return The expert probability.
	 **/
	public Level getExpertProbability()
	{
		return expertProbability;
	}

	/**
	 * Retrieves the geek probability.
	 * @return The geek probability.
	 **/
	public Level getGeekProbability()
	{
		return geekProbability;
	}

	/**
	 * Retrieves the amateur probability.
	 * @return The amateur probability.
	 **/
	public Level getAmateurProbability()
	{
		return amateurProbability;
	}

	/**
	 * Sets the guru probability.
	 * @param probability
	 *            The probability.
	 **/
	public void setGuruProbability(Level probability)
	{
		this.guruProbability = probability;
	}

	/**
	 * Sets the expert probability.
	 * @param probability
	 *            The probability.
	 **/
	public void setExpertProbability(Level probability)
	{
		this.expertProbability = probability;
	}

	/**
	 * Sets the geek probability.
	 * @param probability
	 *            The probability.
	 **/
	public void setGeekProbability(Level probability)
	{
		this.geekProbability = probability;
	}

	/**
	 * Sets the amateur probability.
	 * @param probability
	 *            The probability.
	 **/
	public void setAmateurProbability(Level probability)
	{
		this.amateurProbability = probability;
	}
}

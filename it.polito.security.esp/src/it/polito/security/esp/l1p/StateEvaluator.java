package it.polito.security.esp.l1p;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;
import com.fathzer.soft.javaluator.StaticVariableSet;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartSet;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.AttackMitigation;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.AttackStep;
import it.polito.security.esp.kb.AttackStepProbability;
import it.polito.security.esp.kb.ExpertiseLevel;
import it.polito.security.esp.kb.Level;
import it.polito.security.esp.kb.Protection;
import it.polito.security.esp.metrics.MetricsFramework;

/**
 * The state evaluator.
 * @author Daniele Canavese
 **/
public class StateEvaluator
{
	/** The ESP. **/
	private ESP esp;
	/** The uncertainty formula. **/
	static private final String UNCERTAINTY_FORMULA = "2 * (normalize(halstead_program_size_static) + normalize(cyclomatic_complexity_static))";
	/** The remote instructions formula. **/
	static private final String REMOTE_INSTRUCTIONS_FORMULA = "step(-nr_ins_static, 20) * step(-nr_ins_static$protected, -20) * nr_ins_static$protected * 2";
	/** The alteration detection formula. **/
	static private final String ALTERATION_DETECTION_FORMULA = "5 * nr_of_guarded_bytes";
	/** The alteration avoidance formula. **/
	static private final String ALTERATION_AVOIDANCE_FORMULA = "10 * nr_of_mobile_bytes";
	/** The guru probabilities. **/
	static private final Map<Level, Double> GURU_PROBABILITIES = new HashMap<Level, Double>()
	{
		private static final long serialVersionUID = 1L;
		{
			put(Level.HIGH, 1.0);
			put(Level.MEDIUM, 0.75);
			put(Level.LOW, 0.5);
		}
	};
	/** The expert probabilities. **/
	static private final Map<Level, Double> EXPERT_PROBABILITIES = new HashMap<Level, Double>()
	{
		private static final long serialVersionUID = 1L;
		{
			put(Level.HIGH, 0.7);
			put(Level.MEDIUM, 0.5);
			put(Level.LOW, 0.3);
		}
	};
	/** The amateur probabilities. **/
	static private final Map<Level, Double> AMATEUR_PROBABILITIES = new HashMap<Level, Double>()
	{
		private static final long serialVersionUID = 1L;
		{
			put(Level.HIGH, 0.5);
			put(Level.MEDIUM, 0.3);
			put(Level.LOW, 0.1);
		}
	};
	/** The geek probabilities. **/
	static private final Map<Level, Double> GEEK_PROBABILITIES = new HashMap<Level, Double>()
	{
		private static final long serialVersionUID = 1L;
		{
			put(Level.HIGH, 0.4);
			put(Level.MEDIUM, 0.2);
			put(Level.LOW, 0.05);
		}
	};
	/** The mitigations. **/
	static private final Map<Level, Double> MITIGATIONS = new HashMap<Level, Double>()
	{
		private static final long serialVersionUID = 1L;
		{
			put(Level.HIGH, 0.95);
			put(Level.MEDIUM, 0.5);
			put(Level.LOW, 0.15);
			put(Level.NONE, 0.0);
		}
	};
	/** The attack step uncertainty impact factors. **/
	static private final Map<String, Double> UNCERTAINTY_IMPACT_FACTORS = new HashMap<String, Double>()
	{
		private static final long serialVersionUID = 1L;
		{
			put("dynamic structure and data analysis", 0.2);
			put("dynamic tampering", 0.05);
			put("sniffing", 0.2);
			put("spoofing", 0.05);
			put("static structural code and data recovery", 0.2);
			put("static tampering", 0.05);
		}
	};
	/** The attack step remote instructions impact factors. **/
	static private final Map<String, Double> REMOTE_INSTRUCTIONS_IMPACT_FACTORS = new HashMap<String, Double>()
	{
		private static final long serialVersionUID = 1L;
		{
			put("dynamic structure and data analysis", 0.05);
			put("dynamic tampering", 0.1);
			put("sniffing", 0.25);
			put("spoofing", 0.2);
			put("static structural code and data recovery", 0.05);
			put("static tampering", 0.1);
		}
	};
	/** The attack step alteration detection impact factors. **/
	static private final Map<String, Double> ALTERATION_DETECTION_IMPACT_FACTORS = new HashMap<String, Double>()
	{
		private static final long serialVersionUID = 1L;
		{
			put("dynamic structure and data analysis", 0.05);
			put("dynamic tampering", 0.2);
			put("sniffing", 0.05);
			put("spoofing", 0.05);
			put("static structural code and data recovery", 0.05);
			put("static tampering", 0.2);
		}
	};
	/** The attack step alteration avoidance impact factors. **/
	static private final Map<String, Double> ALTERATION_AVOIDANCE_IMPACT_FACTORS = new HashMap<String, Double>()
	{
		private static final long serialVersionUID = 1L;
		{
			put("dynamic structure and data analysis", 0.05);
			put("dynamic tampering", 0.2);
			put("sniffing", 0.1);
			put("spoofing", 0.15);
			put("static structural code and data recovery", 0.05);
			put("static tampering", 0.2);
		}
	};
	/** The bonus for the encouraged precedences. **/
	static private final double ENCOURAGED_BONUS = 1.5;
	/** The malus for the discouraged precedences. **/
	static private final double DISCOURAGED_MALUS = 1.4;
	/** The broken measures malus. **/
	static private final double BROKEN_MALUS = 10000.0;
	/** The threshold for the broken uncertainties. **/
	static private final double UNCERTAINTY_THRESHOLD = 0.0;
	/** The threshold for the broken remote instructions. **/
	static private final double REMOTE_INSTRUCTIONS_THRESHOLD = 0.0;
	/** The threshold for the broken alteration detections. **/
	static private final double ALTERATION_DETECTION_THRESHOLD = 0.0;
	/** The threshold for the broken alteration avoidances. **/
	static private final double ALTERATION_AVOIDANCE_THRESHOLD = 0.0;
	/** The vanilla set. **/
	static private final Collection<List<AppliedProtectionInstantiation>> vanillaSet = new ArrayList<>();
	/** The current solution uncertainty measures. **/
	private Map<ApplicationPart, Double> uncertainty;
	/** The current solution remote instructions measures. **/
	private Map<ApplicationPart, Double> remoteInstructions;
	/** The current solution alteration detection measures. **/
	private Map<ApplicationPart, Double> alterationDetection;
	/** The current solution alteration avoidance measures. **/
	private Map<ApplicationPart, Double> alterationAvoidance;
	/** The evaluator. **/
	private DoubleEvaluator evaluator;
	/** The step function step(x, y). In short it is if (x >= y) return 1.0 else return 0. **/
	private Function stepFunction;
	/** The normalize function normalize(x). In short it is if (x > 0) return x else return 0. **/
	private Function normalizeFunction;

	/**
	 * Creates the evaluator.
	 * @param esp
	 *            The ESP.
	 **/
	public StateEvaluator(ESP esp)
	{
		this.esp = esp;
		uncertainty = new HashMap<>();
		remoteInstructions = new HashMap<>();
		alterationDetection = new HashMap<>();
		alterationAvoidance = new HashMap<>();
		stepFunction = new Function("step", 2);
		normalizeFunction = new Function("normalize", 1);
		Parameters parameters = DoubleEvaluator.getDefaultParameters();
		parameters.add(stepFunction);
		parameters.add(normalizeFunction);
		evaluator = new DoubleEvaluator(parameters)
		{
			@Override
			protected Double evaluate(Function function, Iterator<Double> arguments, Object context)
			{
				if (function == stepFunction)
				{
					double x = arguments.next();
					double y = arguments.next();
					if (x >= y)
						return 1.0;
					else
						return 0.0;
				}
				else if (function == normalizeFunction)
				{
					double x = arguments.next();
					if (x > 0)
						return x;
					else
						return 0.0;
				}
				else
					return super.evaluate(function, arguments, context);
			}
		};
	}

	/**
	 * Evaluates a state's solution and puts its score into the internal map.
	 * @param state
	 *            The state to analyze.
	 **/
	public void evaluateSolution(State state)
	{
		uncertainty.clear();
		remoteInstructions.clear();
		alterationDetection.clear();
		alterationAvoidance.clear();

		for (ApplicationPart i : esp.getModel().getAssets())
		{
			uncertainty.put(i, getMeasure(UNCERTAINTY_FORMULA, state, i));
			remoteInstructions.put(i, getMeasure(REMOTE_INSTRUCTIONS_FORMULA, state, i));
			alterationDetection.put(i, getMeasure(ALTERATION_DETECTION_FORMULA, state, i));
			alterationAvoidance.put(i, getMeasure(ALTERATION_AVOIDANCE_FORMULA, state, i));
		}
	}

	/**
	 * Evaluates a state.
	 * @param state
	 *            The state to analyze.
	 * @return The state score.
	 **/
	public double evaluateState(State state)
	{
		double score = 0.0;

		for (ApplicationPart i : esp.getModel().getAssets())
		{
			double newUncertainty = uncertainty.get(i) * getMeasureCorrection(MeasureType.UNCERTAINTY, state, i);
			double newRemoteInstructions = remoteInstructions.get(i) * getMeasureCorrection(MeasureType.REMOTE_INSTRUCTIONS, state, i);
			double newAlterationDetection = alterationDetection.get(i) * getMeasureCorrection(MeasureType.ALTERATION_DETECTION, state, i);
			double newAlterationAvoidance = alterationAvoidance.get(i) * getMeasureCorrection(MeasureType.ALTERATION_AVOIDANCE, state, i);

			double s = 0.0;
			s += newUncertainty;
			s += newRemoteInstructions;
			s += newAlterationDetection;
			s += newAlterationAvoidance;
			s *= i.getWeight();
			if (newUncertainty < UNCERTAINTY_THRESHOLD)
				s -= BROKEN_MALUS;
			if (newRemoteInstructions < REMOTE_INSTRUCTIONS_THRESHOLD)
				s -= BROKEN_MALUS;
			if (newAlterationDetection < ALTERATION_DETECTION_THRESHOLD)
				s -= BROKEN_MALUS;
			if (newAlterationAvoidance < ALTERATION_AVOIDANCE_THRESHOLD)
				s -= BROKEN_MALUS;

			score += s;
		}

		return score;
	}

	/**
	 * Computes the measure of an application part.
	 * @param formula
	 *            The measure formula.
	 * @param state
	 *            The state.
	 * @param applicationPart
	 *            The application part.
	 * @return The uncertainty of the application part.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If the ACTC log file cannot be created.
	 **/
	private double getMeasure(String formula, State state, ApplicationPart applicationPart)
	{
		double result = 0.0;

		try
		{
			StaticVariableSet<Double> variables = new StaticVariableSet<Double>();

			Collection<ApplicationPart> parts = new ArrayList<>();
			parts.add(applicationPart);
			for (ApplicationPartSet i : applicationPart.getSets())
				parts.addAll(i.getApplicationParts());

			for (String i : MetricsFramework.METRICS)
			{
				double vanillaMetric = 0.0;
				double protectedMetric = 0.0;
				for (ApplicationPart j : parts)
				{
					vanillaMetric += esp.getMetricsFramework().getMetric(esp.getModel().getVanillaSolution(), vanillaSet, j, i);
					protectedMetric += esp.getMetricsFramework().getMetric(esp.getModel().getVanillaSolution(),
							state.getSolutionMap().values(), j, i);
				}
				variables.set(i, protectedMetric - vanillaMetric);
				variables.set(i + "$protected", protectedMetric);
				variables.set(i + "$vanilla", vanillaMetric);
			}

			double retValue = evaluator.evaluate(formula, variables);
			return retValue;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Computes the correction value for a measure taking into account the attacks.
	 * @param measure
	 *            The measure type.
	 * @param state
	 *            The state.
	 * @param applicationPart
	 *            The application part.
	 * @return The uncertainty of the application part.
	 * @throws IOException
	 *             If the ACTC command cannot be executed.
	 * @throws CoreException
	 *             If the ACTC log file cannot be created.
	 **/
	private double getMeasureCorrection(MeasureType measure, State state, ApplicationPart applicationPart)
	{
		double correction = 1.0;

		for (AttackPath i : state.getAttackPaths())
			for (AttackStep j : i.getAttackSteps())
				if (j.getApplicationParts().contains(applicationPart))
					correction *= 1.0 - getRisk(measure, state, j);

		return correction;
	}

	/**
	 * Computes the risk of an attack step.
	 * @param measure
	 *            The measure type.
	 * @param state
	 *            The state.
	 * @param attackStep
	 *            The attack step.
	 * @return The attack step risk.
	 */
	private double getRisk(MeasureType measure, State state, AttackStep attackStep)
	{
		if (attackStep.getType() == null)
			return 0.0;

		return getProbability(attackStep) * (1.0 - getMitigation(state, attackStep)) * getImpactFactor(measure, attackStep);
	}

	/**
	 * Computes the probability of an attack step.
	 * @param attackStep
	 *            The attack step.
	 * @return The attack step probability.
	 */
	private double getProbability(AttackStep attackStep)
	{
		ExpertiseLevel level = esp.getModel().getAttacker().getExpertise();
		Level probability = Level.HIGH;

		for (AttackStepProbability i : attackStep.getType().getProbabilities())
			if (i.getExpertise() == level)
			{
				probability = i.getProbability();
				break;
			}

		if (level == ExpertiseLevel.GURU)
			return GURU_PROBABILITIES.get(probability);
		else if (level == ExpertiseLevel.EXPERT)
			return EXPERT_PROBABILITIES.get(probability);
		else if (level == ExpertiseLevel.AMATEUR)
			return AMATEUR_PROBABILITIES.get(probability);
		else
			return GEEK_PROBABILITIES.get(probability);
	}

	/**
	 * Computes the impact factor of an attack step.
	 * @param measure
	 *            The measure type.
	 * @param attackStep
	 *            The attack step.
	 * @return The attack step impact factor.
	 */
	private double getImpactFactor(MeasureType measure, AttackStep attackStep)
	{
		if (measure == MeasureType.UNCERTAINTY)
			return UNCERTAINTY_IMPACT_FACTORS.get(attackStep.getType().getName());
		else if (measure == MeasureType.REMOTE_INSTRUCTIONS)
			return REMOTE_INSTRUCTIONS_IMPACT_FACTORS.get(attackStep.getType().getName());
		else if (measure == MeasureType.ALTERATION_DETECTION)
			return ALTERATION_DETECTION_IMPACT_FACTORS.get(attackStep.getType().getName());
		else
			return ALTERATION_AVOIDANCE_IMPACT_FACTORS.get(attackStep.getType().getName());
	}

	/**
	 * Computes the mitigation of an attack step.
	 * @param state
	 *            The state.
	 * @param attackStep
	 *            The attack step.
	 * @return The attack step mitigation.
	 */
	private double getMitigation(State state, AttackStep attackStep)
	{
		double mitigation = 1.0;

		for (List<AppliedProtectionInstantiation> i : state.getSolutionMap().values())
			for (AppliedProtectionInstantiation j : i)
				mitigation *= 1 - getMitigation(state, j, attackStep);

		return 1.0 - mitigation;
	}

	/**
	 * Computes the mitigation of a protection for an attack step.
	 * @param state
	 *            The state.
	 * @param appliedProtectionInstantiation
	 *            The applied PI.
	 * @param attackStep
	 *            The attack step.
	 * @return The attack step mitigation.
	 **/
	private double getMitigation(State state, AppliedProtectionInstantiation appliedProtectionInstantiation, AttackStep attackStep)
	{
		double mitigation = 0.0;

		for (AttackMitigation i : appliedProtectionInstantiation.getAttackMitigations())
			for (AttackPath j : i.getAttackPaths())
				if (j.getAttackSteps().contains(attackStep))
					mitigation = 1.0 - MITIGATIONS.get(i.getLevel());

		for (List<AppliedProtectionInstantiation> i : state.getSolutionMap().values())
			for (AppliedProtectionInstantiation j : i)
				if (i == appliedProtectionInstantiation)
					break;
				else
				{
					Protection protection = j.getProtectionInstantiation().getProtection();
					if (appliedProtectionInstantiation.getProtectionInstantiation().getProtection().getEncouragedPrecedences()
							.contains(protection))
						mitigation *= ENCOURAGED_BONUS;
					else if (appliedProtectionInstantiation.getProtectionInstantiation().getProtection().getDiscouragedPrecedences()
							.contains(protection))
						mitigation /= DISCOURAGED_MALUS;
				}

		return mitigation;
	}
}

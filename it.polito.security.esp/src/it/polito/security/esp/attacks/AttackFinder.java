package it.polito.security.esp.attacks;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IConfigurationElement;
import org.jpl7.Compound;
import org.jpl7.JPL;
import org.jpl7.JPLException;
import org.jpl7.Query;
import org.jpl7.Term;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.Activator;
import it.polito.security.esp.kb.KbFactory;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartType;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.AttackStep;
import it.polito.security.esp.kb.AttackStepType;
import it.polito.security.esp.kb.Property;
import it.polito.security.esp.kb.ProtectionObjective;
import it.polito.security.esp.kb.UseTarget;
import it.polito.security.esp.kb.UseType;
import it.polito.security.esp.util.Collections;
import it.polito.security.esp.util.Eclipse;
import it.polito.security.esp.util.Strings;

/**
 * Finds the attacks and their relative data.
 * @author Daniele Canavese, Leonardo Regano
 **/
public class AttackFinder
{
	/** The ESP. **/
	private ESP esp;

	private float[] times =  new float[5];
	
	/**
	 * Creates the finder.
	 * @param esp
	 *            The ESP.
	 **/
	public AttackFinder(ESP esp)
	{
		this.esp = esp;
		initialized = false;
		attackSteps = new HashMap<>();
		attackPaths = new HashMap<>();
	}

	/**
	 * Runs the attack deduction phase and computes all the relevant data.
	 * @throws Exception
	 **/
	public void run() throws Exception
	{
		log.info("Inferring the attacks...");

		long start = System.currentTimeMillis();
		clear();
		inferProtectionObjectives();
		log.info("Searching attacks with maximum depth "+esp.getModel().getPreferences().getAttacksMaximumDepth());
//		Double timeLimit = null;
//		if (esp.getModel().getPreferences().getAttacksTimeLimit() > 0)
//		{
//			timeLimit = (double) esp.getModel().getPreferences().getAttacksTimeLimit() / esp.getModel().getProtectionObjectivesCount();
//			inferAttackPaths((int) (timeLimit * 1000));
//		}
//		else
			inferAttackPaths(null);
		realizeAttackSteps();
		long stop = System.currentTimeMillis();

		log.info(String.format("Attacks inferred = %d POs, %d paths, %d steps, %.3f s", esp.getModel().getProtectionObjectivesCount(),
				esp.getModel().getAttackPathsCount(), esp.getModel().getAttackStepsCount(), (stop - start) / 1000.0f));
	}

	/**
	 * Clears the attack paths and steps.
	 **/
	private void clear()
	{
		esp.getModel().getProtectionObjectives().clear();
		esp.getModel().getAttackPaths().clear();
		esp.getModel().getAttackSteps().clear();
	}

	/**
	 * Infers the protection objectives.
	 **/
	private void inferProtectionObjectives()
	{
		// Finds all the POs.
		Set<ProtectionObjective> protectionObjectives = new HashSet<>();
		for (ApplicationPart i : esp.getModel().getAssets())
			for (Property j : i.getSecurityProperties())
			{
				ProtectionObjective po = KbFactory.eINSTANCE.createProtectionObjective();
				po.setApplicationPart(i);
				po.setProperty(j);
				protectionObjectives.add(po);
				log.finest("New protection objective = " + po);
			}

		// Removes the included (redundant) POs. A PO is included into another one if:
		// + they share the same property;
		// + the external asset contains the internal asset;
		// + the external asset has a weight greater than or equal to the internal asset weight.
		if (esp.getModel().getPreferences().isAttacksIncludedProtectionObjectivesRemoval())
		{
			Set<ProtectionObjective> inclusions = new HashSet<>();
			for (ProtectionObjective i : protectionObjectives)
				for (ProtectionObjective j : protectionObjectives)
					if (i != j && i.getApplicationPart().contains(j.getApplicationPart()) && i.getProperty() == j.getProperty()
							&& i.getApplicationPart().getWeight() >= j.getApplicationPart().getWeight())
						inclusions.add(j);
			protectionObjectives.removeAll(inclusions);
			if (!inclusions.isEmpty())
				log.info("Included protection objectives removed = " + inclusions.size() + " " + inclusions);

		}

		esp.getModel().getProtectionObjectives().addAll(protectionObjectives);
		log.info("Protection objectives = " + protectionObjectives.size());
	}

	/**
	 * Realizes the attack steps.
	 **/
	private void realizeAttackSteps()
	{
		for (AttackStepType i : esp.getModel().getAttackStepTypes())
			for (AttackStep j : esp.getModel().getAttackSteps())
				if (j.getName().matches(i.getRegex()))
					j.setType(i);
	}

	/**
	 * Infers all the attack paths.
	 * @param timeLimit
	 *            The time limit or <code>null</code> if no time limit is set.
	 * @throws URISyntaxException
	 *             If a Prolog file cannot be found.
	 * @throws IOException
	 *             If some Prolog file cannot be read.
	 **/
	private void inferAttackPaths(Integer timeLimit) throws IOException, URISyntaxException
	{
		initialize();

		log.fine(String.format("%9s  %9s  %65s  %9s  %9s", "Depth", "Parts", "PO", "Attacks", "Time"));
		for (ProtectionObjective i : esp.getModel().getProtectionObjectives())
			findAttackPaths(i, timeLimit);

		// Warns about the unattackable protection objectives.
		Set<ProtectionObjective> unattackableProtectionObjectives = new HashSet<>();
		for (ProtectionObjective i : esp.getModel().getProtectionObjectives())
		{
			boolean unattackable = true;
			for (AttackPath j : esp.getModel().getAttackPaths())
				if (j.getProtectionObjectives().contains(i))
				{
					unattackable = false;
					break;
				}
			if (unattackable)
				unattackableProtectionObjectives.add(i);
		}
		if (!unattackableProtectionObjectives.isEmpty())
			log.warning("Unattackable POs = " + unattackableProtectionObjectives.size() + " " + unattackableProtectionObjectives);
		
		for(int i=0; i<5; i++)
			log.fine("Depth "+(i+1)+": "+times[i]+" s");
	}

	/** The initialized state of the Prolog engine. **/
	private boolean initialized;

	/**
	 * Initializes the Prolog engine, if needed.
	 * @throws URISyntaxException
	 *             If a Prolog file cannot be found.
	 * @throws IOException
	 *             If some Prolog file cannot be read.
	 **/
	private void initialize() throws IOException, URISyntaxException
	{
		if (!initialized)
		{
			// Loads the base Prolog files.
			JPL.setTraditional();
			JPL.init();
			assertProlog("consult('" + Eclipse.getPath(Activator.PLUGIN_ID, "pl/attackPaths.pl").replace('\\', '/') + "')");
			assertProlog("consult('" + Eclipse.getPath(Activator.PLUGIN_ID, "pl/baseClauses.pl").replace('\\', '/') + "')");

			// Loads the other Prolog files.
			for (IConfigurationElement i : Eclipse.getExtensions(Activator.PROLOG_ID))
			{
				String pluginId = i.getDeclaringExtension().getNamespaceIdentifier();
				String plFile = i.getAttribute("plFile");
				assertProlog("consult('" + Eclipse.getPath(pluginId, plFile).replace('\\', '/') + "')");
			}
			initialized = true;
		}
	}

	/**
	 * Translates an application part for the attack path engine.
	 * @param applicationPart
	 *            The application part to translate.
	 * @throws IOException
	 *             If some file cannot be read.
	 **/
	private void assertApplicationPart(ApplicationPart applicationPart) throws IOException
	{
		Set<ApplicationPart> usedParts = new HashSet<>();
		usedParts.add(applicationPart);

		if (applicationPart.isCode())
		{
			for (ApplicationPart i : applicationPart.getApplicationParts())
				if (i.isCode() || (i.isDatum() && i.isAsset()))
				{
					assertProlog("assertz(contains('" + applicationPart.getName() + "'(User), '" + i.getName() + "'(User)))");
					usedParts.add(i);
				}
			for (UseTarget i : applicationPart.getUses())
				if (i.getType() == UseType.ACCESSES && i.getTarget().isAsset())
				{
					assertProlog("assertz(accesses('" + applicationPart.getName() + "'(User), '" + i.getTarget().getName() + "'(User)))");
					assertProlog(
							"assertz(isAccessedBy('" + i.getTarget().getName() + "'(User), '" + applicationPart.getName() + "'(User)))");
					usedParts.add(i.getTarget());
				}
				else if (i.getType() == UseType.CALLS && i.getTarget().getType() != ApplicationPartType.REFERENCE)
				{
					List<String> parameters = new ArrayList<>();
					for (ApplicationPart j : i.getParameters())
						if (j.getType() == ApplicationPartType.CONSTANT)
							parameters.add("constant(" + j.getName() + ")");
						else
							parameters.add(j.getName());
					//TODO: something is definitely wrong in parsing, empty parameters in calls sometimes
					List<String> parameters2 = parameters.stream().filter(s -> !s.isEmpty()).collect(java.util.stream.Collectors.toList());
					assertProlog("assertz(calls('" + applicationPart.getName() + "'(User), '" + i.getTarget().getName() + "'(User), ["
							+ Strings.join(parameters2, ",") + "]))");
					assertProlog("assertz(isCalledBy('" + i.getTarget().getName() + "'(User), '" + applicationPart.getName() + "'(User)))");
					usedParts.add(i.getTarget());
				}
		}
		else if (applicationPart.isDatum() && applicationPart.isAsset())
		{
			for (UseTarget i : applicationPart.getTargetOf())
				if (i.getType() == UseType.ACCESSES)
				{
					assertProlog("assertz(accesses('" + applicationPart.getName() + "'(User), '" + i.getTarget().getName() + "'(User)))");
					assertProlog(
							"assertz(isAccessedBy('" + i.getTarget().getName() + "'(User), '" + applicationPart.getName() + "'(User)))");
					usedParts.add(i.getTarget());
				}
		}

		for (Property i : applicationPart.getProperties())
			assertProlog("assertz(hasProperty('" + applicationPart.getName() + "'(_), " + i.getLiteral() + "))");

		for (ApplicationPart i : usedParts)
			if (i.isCode())
				assertProlog("assertz(code('" + i.getName() + "'(_)))");
			else if (i.isDatum() && i.isAsset())
				assertProlog("assertz(datum('" + i.getName() + "'(_)))");
	}

	/**
	 * Asserts something in the Prolog database.
	 * @param clause
	 *            The clause to assert.
	 * @throws IOException
	 *             If the assertion cannot be performed.
	 **/
	private void assertProlog(String clause) throws IOException
	{
		Query query = new Query(clause);
//		log.fine(clause);
		if (!query.hasSolution())
			throw new IOException("Unable to assert " + clause);
	}

	/**
	 * Asserts some initial application part related clauses.
	 * @throws IOException
	 *             If some Prolog file cannot be read.
	 **/
	private void assertApplicationParts() throws IOException
	{
		assertProlog("assertz(application/1)");
		assertProlog("assertz(contains/2)");
		assertProlog("assertz(code/1)");
		assertProlog("assertz(datum/1)");
		assertProlog("assertz(accesses/2)");
		assertProlog("assertz(isAccessedBy/2)");
		// assertProlog("assertz(decrypts/2)");
		// assertProlog("assertz(isDecryptedBy/2)");
		// assertProlog("assertz(enforcesExecutionOnlyOnceAfterInstall/2)");
		// assertProlog("assertz(hasExecutionOnlyAfterInstallEnforcedBy/2)");
		// assertProlog("assertz(initializes/2)");
		// assertProlog("assertz(isInitializedBy/2)");
		// assertProlog("assertz(receivesFromServerAsCypherText/2)");
		// assertProlog("assertz(receivesFromServerAsPlainText/2)");
		// assertProlog("assertz(enables/2)");
		// assertProlog("assertz(isEnabledBy/2)");
		assertProlog("assertz(hasProperty/2)");
		assertProlog("assertz(calls/3)");
		assertProlog("assertz(isCalledBy/3)");
	}

	/**
	 * Abolishes all the application part related clauses.
	 * @throws IOException
	 *             If some Prolog file cannot be read.
	 **/
	private void abolishApplicationParts() throws IOException
	{
		try
		{
			assertProlog("retractall(application(_))");
			assertProlog("retractall(contains(_, _))");
			assertProlog("retractall(code(_))");
			assertProlog("retractall(datum(_))");
			assertProlog("retractall(accesses(_, _))");
			assertProlog("retractall(isAccessedBy(_, _))");
			 assertProlog("retractall(decrypts(_, _))");
			 assertProlog("retractall(isDecryptedBy(_, _))");
			 assertProlog("retractall(enforcesExecutionOnlyOnceAfterInstall(_, _))");
			 assertProlog("retractall(hasExecutionOnlyAfterInstallEnforcedBy(_, _))");
			 assertProlog("retractall(initializes(_, _))");
			 assertProlog("retractall(isInitializedBy(_, _))");
			 assertProlog("retractall(receivesFromServerAsCypherText(_, _))");
			 assertProlog("retractall(receivesFromServerAsPlainText(_, _))");
			 assertProlog("retractall(enables(_, _))");
			 assertProlog("retractall(isEnabledBy(_, _))");
			assertProlog("retractall(hasProperty(_, _))");
			assertProlog("retractall(calls(_, _, _))");
			assertProlog("retractall(isCalledBy(_, _, _))");

			assertProlog("retractall(application/1)");
			assertProlog("retractall(contains/2)");
			assertProlog("retractall(code/1)");
			assertProlog("retractall(datum/1)");
			assertProlog("retractall(accesses/2)");
			assertProlog("retractall(isAccessedBy/2)");
			 assertProlog("retractall(decrypts/2)");
			 assertProlog("retractall(isDecryptedBy/2)");
			 assertProlog("retractall(enforcesExecutionOnlyOnceAfterInstall/2)");
			 assertProlog("retractall(hasExecutionOnlyAfterInstallEnforcedBy/2)");
			 assertProlog("retractall(initializes/2)");
			 assertProlog("retractall(isInitializedBy/2)");
			 assertProlog("retractall(receivesFromServerAsCypherText/2)");
			 assertProlog("retractall(receivesFromServerAsPlainText/2)");
			 assertProlog("retractall(enables/2)");
			 assertProlog("retractall(isEnabledBy/2)");
			assertProlog("retractall(hasProperty/2)");
			assertProlog("retractall(calls/3)");
			assertProlog("retractall(isCalledBy/3)");
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Finds all the attacks path against a protection objective.
	 * @param protectionObjective
	 *            The protection objective.
	 * @param timeLimit
	 *            The time limit or <code>null</code> if no time limit is set.
	 * @throws IOException
	 *             If something goes wrong.
	 **/
	private void findAttackPaths(ProtectionObjective protectionObjective, Integer timeLimit) throws IOException
	{
		assertApplicationParts();

		log.fine(String.format("%9s  %9s  %65s  %9s  %9s", "-", "-", protectionObjective, "-", "-"));
		long start = System.currentTimeMillis();
		Set<ApplicationPart> relatedParts = new HashSet<>();
		for (int i = 0; i <= esp.getModel().getPreferences().getAttacksMaximumDepth(); ++i)
			if (findAttackPaths(protectionObjective, i, start, timeLimit, relatedParts))
				break;

		abolishApplicationParts();
	}

	/**
	 * Finds all the attacks path against a protection objective.
	 * @param protectionObjective
	 *            The protection objective.
	 * @param depth
	 *            The depth of the search.
	 * @param startTime
	 *            The start time.
	 * @param timeLimit
	 *            The time limit or <code>null</code> if no time limit is set.
	 * @param relatedParts
	 *            The related parts so far.
	 * @return <code>true</code> if the search space was completely explored, <code>false</code> otherwise.
	 * @throws IOException
	 *             If something goes wrong.
	 **/
	private boolean findAttackPaths(ProtectionObjective protectionObjective, int depth, long startTime, Integer timeLimit,
			Set<ApplicationPart> relatedParts) throws IOException
	{
		if (timeLimit != null && System.currentTimeMillis() - startTime > timeLimit)
			return false;

		String attackFact = "breached('" + protectionObjective.getApplicationPart().getName() + "'(_), "
				+ protectionObjective.getProperty().getLiteral() + ")";
		Query attackPathsQuery = new Query("getAttackPath(" + attackFact + ", AttackPath)");
		Vector<Map<?, ?>> attackPathsSolutions = new Vector<>();
		
		int oldAttackSize = esp.getModel().getAttackPaths().size();
		
		try 
		{
			while (attackPathsQuery.hasMoreSolutions())
			{
				Map<?, ?> attackPathSolution = attackPathsQuery.nextSolution();
	
				if (attackPathSolution.get("AttackPath") instanceof Compound)
				{
	
					Compound compound = (Compound) attackPathSolution.get("AttackPath");
					boolean differentPaths = true;
	
					for (Map<?, ?> attackPathSolution2 : attackPathsSolutions)
					{
						differentPaths = false;
						Compound compound2 = (Compound) attackPathSolution2.get("AttackPath");
						for (Term m : compound.toTermArray())
						{
							boolean mIsInPath2 = false;
							for (Term m2 : compound2.toTermArray())
							{
								if (m.toString().equals(m2.toString()))
								{
									mIsInPath2 = true;
									break;
								}
							}
							if (!mIsInPath2)
							{
								differentPaths = true;
								break;
							}
						}
						if (!differentPaths)
							break;
					}
					if (differentPaths)
						attackPathsSolutions.add(attackPathSolution);
				}
				if (timeLimit != null && System.currentTimeMillis() - startTime > timeLimit)
					break;
			}
	
			for (Map<?, ?> i : attackPathsSolutions)
			{
				Compound compound = (Compound) i.get("AttackPath");
				ArrayList<AttackStep> steps = new ArrayList<>();
	
				for (Term m : compound.toTermArray())
				{
					AttackStep attackStep;
					if (attackSteps.containsKey(m.toString().hashCode()))
						attackStep = attackSteps.get(m.toString().hashCode());
					else
					{
						attackStep = KbFactory.eINSTANCE.createAttackStep();
						attackStep.setName(m.toString());
						for (Term j : m.args())
							if (j.arity() == 1 && (j.arg(1).toString().equals("attacker") || j.arg(1).toString().equals("victim")))
							{
								ApplicationPart applicationPart = findApplicationPart(j.name());
								if (applicationPart != null)
									Collections.addUnique(attackStep.getApplicationParts(), applicationPart);
							}
	
						attackSteps.put(m.toString().hashCode(), attackStep);
						esp.getModel().getAttackSteps().add(attackStep);
					}
					steps.add(attackStep);
				}
	
				AttackPath attackPath;
				if (attackPaths.containsKey(steps.hashCode()))
					attackPath = attackPaths.get(steps.hashCode());
				else
				{
					attackPath = KbFactory.eINSTANCE.createAttackPath();
					attackPath.getAttackSteps().addAll(steps);
					attackPaths.put(steps.hashCode(), attackPath);
					if (!esp.getModel().getAttackPaths().contains(attackPath))
					
						for (ProtectionObjective j : esp.getModel().getProtectionObjectives())
							if (j.getApplicationPart() == protectionObjective.getApplicationPart()
									&& j.getProperty() == protectionObjective.getProperty())
							{
								esp.getModel().getAttackPaths().add(attackPath);
								attackPath.getProtectionObjectives().add(j);
								computeAttackPathCost(attackPath);
								break;
							}
				}
			}
	
			long stop = System.currentTimeMillis();
			log.fine(String.format("% 9d  % 9d  %65s  % 9d  % 9.3f", depth, relatedParts.size(), protectionObjective,
					esp.getModel().getAttackPaths().size() - oldAttackSize, (stop - startTime) / 1000.0f));
	
			for(int i = 1; i<depth; i++)
				times[i-1] += (stop - startTime) / 1000.0f;
			
			if (relatedParts.isEmpty())
			{
				relatedParts.add(protectionObjective.getApplicationPart());
				assertApplicationPart(protectionObjective.getApplicationPart());
			}
			else
			{
				Set<ApplicationPart> related = new HashSet<>();
				for (ApplicationPart i : relatedParts)
					related.addAll(findDirectlyRelatedParts(i));
	
				related.removeAll(relatedParts);
	
				if (related.isEmpty())
					return true;
				else
				{
					for (ApplicationPart i : related)
						assertApplicationPart(i);
					relatedParts.addAll(related);
				}
			}
		}
		catch(JPLException e)
		{
			log.severe("JPL Exception with query "+"getAttackPath(" + attackFact + ", AttackPath)");
		}

		return depth > 1 && oldAttackSize == esp.getModel().getAttackPaths().size();
//		return false;
	}

	/**
	 * Finds an application part with a certain name.
	 * @param name
	 *            The name of the application part.
	 * @return The application part or <code>null</code> if no application partw were found.
	 */
	private ApplicationPart findApplicationPart(String name)
	{
		for (ApplicationPart i : esp.getModel().getAllApplicationParts())
			if (i.getName().equals(name))
				return i;

		return null;
	}

	/**
	 * Finds the application parts directly related to another part.
	 * @param applicationPart
	 *            The part.
	 * @return The related parts.
	 */
	private Set<ApplicationPart> findDirectlyRelatedParts(ApplicationPart applicationPart)
	{
		Set<ApplicationPart> related = new HashSet<>();

		if (applicationPart.isCode())
		{
			if (applicationPart.getDeclaringCode() != null)
				related.add(applicationPart.getDeclaringCode());
			related.addAll(applicationPart.getApplicationParts());
			for (UseTarget i : applicationPart.getUses())
				related.add(i.getTarget());
			for (UseTarget i : applicationPart.getTargetOf())
				related.add(i.getUsedBy());
		}
		else if (applicationPart.isDatum())
		{
			if (applicationPart.getDeclaringCode() != null)
				related.add(applicationPart.getDeclaringCode());
			for (UseTarget i : applicationPart.getTargetOf())
				related.add(i.getUsedBy());
		}

		related.add(applicationPart);

		return related;
	}

	/**
	 * Computes the cost of an attack path.
	 * @param attackPath
	 *            The attack path to analyze.
	 **/
	private void computeAttackPathCost(AttackPath attackPath)
	{
		double cost = 0.0f;
		for (ProtectionObjective i : attackPath.getProtectionObjectives())
			cost += i.getApplicationPart().getWeight();
		attackPath.setCost(cost);
	}

	/**
	 * Creates some fake attack paths for all the assets.
	 **/
	public void createFakeAttackPaths()
	{
		int count = 0;
		for (ApplicationPart i : esp.getModel().getAssets())
			for (Property j : i.getSecurityProperties())
			{
				ProtectionObjective po = KbFactory.eINSTANCE.createProtectionObjective();
				po.setApplicationPart(i);
				po.setProperty(j);
				esp.getModel().getProtectionObjectives().add(po);

				AttackPath attackPath = KbFactory.eINSTANCE.createAttackPath();
				attackPath.setCost(1.0);
				attackPath.setKey(false);
				attackPath.getProtectionObjectives().add(po);
				esp.getModel().getAttackPaths().add(attackPath);

				for (AttackStepType k : esp.getModel().getAttackStepTypes())
				{
					AttackStep attackStep = KbFactory.eINSTANCE.createAttackStep();
					attackStep.setName("step" + count++);
					attackStep.setType(k);

					attackPath.getAttackSteps().add(attackStep);
					esp.getModel().getAttackSteps().add(attackStep);
				}
			}
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(AttackFinder.class.getName());
	/** The attack steps. **/
	private Map<Integer, AttackStep> attackSteps;
	/** The attack paths. **/
	private Map<Integer, AttackPath> attackPaths;
}

package it.polito.security.esp.kb;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;

import it.polito.security.esp.kb.ActionType;
import it.polito.security.esp.kb.KbFactory;
import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartSet;
import it.polito.security.esp.kb.ApplicationPartType;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.AttackStep;
import it.polito.security.esp.kb.AttackStepType;
import it.polito.security.esp.kb.Attacker;
import it.polito.security.esp.kb.AttackerTool;
import it.polito.security.esp.kb.AttackerToolType;
import it.polito.security.esp.kb.FunctionDeclaration;
import it.polito.security.esp.kb.Model;
import it.polito.security.esp.kb.Preferences;
import it.polito.security.esp.kb.Protection;
import it.polito.security.esp.kb.ProtectionObjective;
import it.polito.security.esp.kb.Rule;
import it.polito.security.esp.kb.Solution;
import it.polito.security.esp.util.Eclipse;
import it.polito.security.ontologies.Ontology;
import it.polito.security.ontologies.ReasonerType;
import it.polito.security.ontologies.exceptions.CorruptionException;
import it.polito.security.ontologies.exceptions.InconsistencyException;
import it.polito.security.ontologies.exceptions.NoSuchEntityException;
import it.polito.security.ontologies.exceptions.OntologyChangeException;
import it.polito.security.ontologies.exceptions.OntologyCreationException;
import it.polito.security.ontologies.exceptions.ParsingErrorException;
import it.polito.security.ontologies.exceptions.ReasoningInterruptedException;

/**
 * The KB utility class.
 * @author dani
 *
 */
public class KBUtil
{
	/**
	 * The private constructor.
	 **/
	private KBUtil()
	{
	}

	/**
	 * Loads the OWL ontology into the EMF model.
	 * @param file
	 *            The ontology file to load.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws OntologyChangeException
	 *             If an axiom cannot be added.
	 * @throws CoreException
	 *             If the ontology cannot be loaded.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be created.
	 * @throws CorruptionException
	 *             If the ontology is corrupted.
	 **/
	static public Model loadFromOntology(IFile file) throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			NoSuchEntityException, InconsistencyException, ReasoningInterruptedException, ParsingErrorException, IOException,
			OntologyChangeException, OntologyCreationException, CoreException, CorruptionException
	{
		Ontology ontology = new Ontology(file.getContents(), ReasonerType.HERMIT);
		Model model = KbFactory.eINSTANCE.createModel();
		model.setPreferences(KbFactory.eINSTANCE.createPreferences());
		model.setOntology(ontology);

		List<ApplicationPart> applicationParts = new ArrayList<>();
		for (Object i : ontology.deserialize(KbPackage.Literals.APPLICATION_PART, KbFactory.eINSTANCE))
			applicationParts.add((ApplicationPart) i);
		// Adds only the non included application parts as first level application parts.
		for (ApplicationPart i : applicationParts)
			if (i.eContainer() == null && !i.getName().isEmpty())
				model.getApplicationParts().add(i);
		for (Object i : ontology.deserialize(KbPackage.Literals.APPLICATION_PART_SET, KbFactory.eINSTANCE))
			model.getApplicationPartSets().add((ApplicationPartSet) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.ATTACKER, KbFactory.eINSTANCE))
			model.setAttacker((Attacker) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.ATTACKER_TOOL_TYPE, KbFactory.eINSTANCE))
			model.getAttackerToolTypes().add((AttackerToolType) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.ATTACKER_TOOL, KbFactory.eINSTANCE))
			model.getAttackerTools().add((AttackerTool) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.PROTECTION, KbFactory.eINSTANCE))
			model.getProtections().add((Protection) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.PROTECTION_OBJECTIVE, KbFactory.eINSTANCE))
			model.getProtectionObjectives().add((ProtectionObjective) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.APPLIED_PROTECTION_INSTANTIATION, KbFactory.eINSTANCE))
			model.getAppliedProtectionInstantiations().add((AppliedProtectionInstantiation) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.ATTACK_STEP_TYPE, KbFactory.eINSTANCE))
			model.getAttackStepTypes().add((AttackStepType) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.ATTACK_STEP, KbFactory.eINSTANCE))
			model.getAttackSteps().add((AttackStep) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.ATTACK_PATH, KbFactory.eINSTANCE))
			model.getAttackPaths().add((AttackPath) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.PREFERENCES, KbFactory.eINSTANCE))
			model.setPreferences((Preferences) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.RULE, KbFactory.eINSTANCE))
			model.getRules().add((Rule) i);
		for (Object i : ontology.deserialize(KbPackage.Literals.SOLUTION, KbFactory.eINSTANCE))
			if (((Solution) i).getSolutionSequences().isEmpty())
				model.setVanillaSolution((Solution) i);
			else
				model.getSolutions().add((Solution) i);

		try
		{
			ontology.verifyChecks();
		}
		catch (CorruptionException e)
		{
			System.err.println(e.getMap().size() + " corrupted objects on " + ontology.getEObjects().size());
			for (Entry<EObject, String> i : e.getMap().entrySet())
				System.err.println("Object: " + i.getKey() + "\n\tClass: " + i.getKey().getClass() + "\n\tComputed check: " + i.getValue());

			// throw e;
		}

		return model;
	}

	/**
	 * Stores the EMF model into the OWL ontology.
	 * @param model
	 *            The KB model.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws OntologyChangeException
	 *             If the axiom cannot be added.new
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be serialized.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws CoreException
	 *             If the ontology cannot be loaded.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be created.
	 **/
	static public void saveIntoOntology(Model model) throws OntologyChangeException, ParsingErrorException, NoSuchEntityException,
			IOException, InconsistencyException, ReasoningInterruptedException, OntologyCreationException, CoreException
	{
		Ontology ontology = model.getOntology();

		// Adds the new objects.
		for (ApplicationPart i : model.getApplicationParts())
			ontology.serialize(i);
		for (ApplicationPartSet i : model.getApplicationPartSets())
			ontology.serialize(i);
		ontology.serialize(model.getAttacker());
		for (AttackerToolType i : model.getAttackerToolTypes())
			ontology.serialize(i);
		for (AttackerTool i : model.getAttackerTools())
			ontology.serialize(i);
		for (Protection i : model.getProtections())
			ontology.serialize(i);
		for (ProtectionObjective i : model.getProtectionObjectives())
			ontology.serialize(i);
		for (AppliedProtectionInstantiation i : model.getAppliedProtectionInstantiations())
			ontology.serialize(i);
		for (AttackStepType i : model.getAttackStepTypes())
			ontology.serialize(i);
		for (AttackStep i : model.getAttackSteps())
			ontology.serialize(i);
		for (AttackPath i : model.getAttackPaths())
			ontology.serialize(i);
		ontology.serialize(model.getPreferences());
		for (Rule i : model.getRules())
			ontology.serialize(i);
		if(model.getVanillaSolution()!=null)
			ontology.serialize(model.getVanillaSolution());
		for (Solution i : model.getSolutions())
			ontology.serialize(i);
		ontology.flush();

		// Removes the orphan objects.
		Collection<EObject> saved = ontology.getEObjects();
		Collection<EObject> actual = getAllObjects(model);
		Collection<EObject> delta = new HashSet<>();
		delta.addAll(saved);
		delta.removeAll(actual);
		for (EObject i : delta)
			ontology.remove(i);
		ontology.flush();

		// Saves the checks.
		ontology.updateChecks();
		ontology.flush();
	}

	/**
	 * Retrieves all the EMF objects contained/referenced to another EMF object.
	 * @param object
	 *            The object.
	 * @return All the referenced/contained EMF objects.
	 **/
	private static Collection<EObject> getAllObjects(EObject object)
	{
		return getAllObjects(object, new HashSet<>());
	}

	/**
	 * Retrieves all the EMF objects contained/referenced to another EMF object.
	 * @param object
	 *            The object.
	 * @param analyzed
	 *            The objects analyzed so far.
	 * @return All the referenced/contained EMF objects.
	 **/
	private static Collection<EObject> getAllObjects(EObject object, Collection<Object> analyzed)
	{
		Collection<EObject> objects = new HashSet<>();

		if (analyzed.contains(object))
			return objects;

		Collection<EObject> internal = new HashSet<>();
		internal.addAll(object.eContents());
		internal.addAll(object.eCrossReferences());
		objects.add(object);
		analyzed.add(object);

		for (EObject i : internal)
			objects.addAll(getAllObjects(i, analyzed));

		return objects;
	}

	/**
	 * Creates a new empty ontology.
	 * @param preferences
	 *            The preferences to set or <code>null</code> to use the default ones.
	 * @return The ontology.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws OntologyChangeException
	 *             If an axiom cannot be added.
	 * @throws CoreException
	 *             If the ontology cannot be loaded.
	 * @throws OntologyCreationException
	 *             If the ontology cannot be created.
	 **/
	static public Ontology createEmptyOntology(Preferences preferences) throws IOException, OntologyCreationException, CoreException,
			OntologyChangeException, ParsingErrorException, NoSuchEntityException, InconsistencyException, ReasoningInterruptedException
	{
		// First locates all the sub-ontologies.
		Collection<InputStream> streams = new ArrayList<>();

		for (IConfigurationElement i : Eclipse.getExtensions(Activator.ONTOLOGIES_ID))
		{
			String pluginId = i.getDeclaringExtension().getNamespaceIdentifier();
			String owlFile = i.getAttribute("owlFile");
			URL url = new URL("platform:/plugin/" + pluginId + "/" + owlFile);
			streams.add(url.openConnection().getInputStream());
		}

		Ontology ontology = new Ontology("http://security.polito.it/esp/kb/kb.owl", ReasonerType.PELLET, streams);

		// Then sets some default values.
		ontology.serialize(KbFactory.eINSTANCE.createAttacker());
		if (preferences == null)
			preferences = KbFactory.eINSTANCE.createPreferences();

		// NAGRA
		FunctionDeclaration f1 = KbFactory.eINSTANCE.createFunctionDeclaration();
		f1.setName("EVP_DecryptUpdate");
		f1.getParameters().add(ApplicationPartType.IGNORE);
		f1.getParameters().add(ApplicationPartType.PLAINTEXT);
		f1.getParameters().add(ApplicationPartType.IGNORE);
		f1.getParameters().add(ApplicationPartType.CIPHERTEXT);
		f1.getParameters().add(ApplicationPartType.IGNORE);
		FunctionDeclaration f2 = KbFactory.eINSTANCE.createFunctionDeclaration();
		f2.setName("EVP_DecryptInit_ex");
		f2.getParameters().add(ApplicationPartType.IGNORE);
		f2.getParameters().add(ApplicationPartType.IGNORE);
		f2.getParameters().add(ApplicationPartType.IGNORE);
		f2.getParameters().add(ApplicationPartType.CRYPTOGRAPHIC_KEY);
		f2.getParameters().add(ApplicationPartType.INITIALIZATION_VECTOR);
		Rule rule1 = KbFactory.eINSTANCE.createRule();
		rule1.setAction(ActionType.ENCRYPT_AES128_ECB);
		rule1.getFunctionDeclarations().add(f1);
		rule1.getFunctionDeclarations().add(f2);
		ontology.serialize(rule1);

		FunctionDeclaration f3 = KbFactory.eINSTANCE.createFunctionDeclaration();
		f3.setName("cryptoKernelDecryptVanilla");
		f3.getParameters().add(ApplicationPartType.PLAINTEXT);
		f3.getParameters().add(ApplicationPartType.IGNORE);
		f3.getParameters().add(ApplicationPartType.CRYPTOGRAPHIC_KEY);
		f3.getParameters().add(ApplicationPartType.CIPHERTEXT);
		Rule rule2 = KbFactory.eINSTANCE.createRule();
		rule2.setAction(ActionType.ENCRYPT_AES128_ECB);
		rule2.getFunctionDeclarations().add(f3);
		ontology.serialize(rule2);

		FunctionDeclaration f4 = KbFactory.eINSTANCE.createFunctionDeclaration();
		f4.setName("EVP_EncryptInit_ex");
		f4.getParameters().add(ApplicationPartType.IGNORE);
		f4.getParameters().add(ApplicationPartType.IGNORE);
		f4.getParameters().add(ApplicationPartType.IGNORE);
		f4.getParameters().add(ApplicationPartType.CRYPTOGRAPHIC_KEY);
		f4.getParameters().add(ApplicationPartType.INITIALIZATION_VECTOR);
		FunctionDeclaration f5 = KbFactory.eINSTANCE.createFunctionDeclaration();
		f5.setName("EVP_EncryptUpdate");
		f5.getParameters().add(ApplicationPartType.IGNORE);
		f5.getParameters().add(ApplicationPartType.CIPHERTEXT);
		f5.getParameters().add(ApplicationPartType.IGNORE);
		f5.getParameters().add(ApplicationPartType.PLAINTEXT);
		f5.getParameters().add(ApplicationPartType.IGNORE);
		Rule rule3 = KbFactory.eINSTANCE.createRule();
		rule3.setAction(ActionType.ENCRYPT_AES128_ECB);
		rule3.getFunctionDeclarations().add(f4);
		rule3.getFunctionDeclarations().add(f5);
		ontology.serialize(rule3);

		// SFNT
		FunctionDeclaration f6 = KbFactory.eINSTANCE.createFunctionDeclaration();
		f6.setName("int_diamante_ecb_decrypt");
		f6.getParameters().add(ApplicationPartType.CIPHERTEXT);
		f6.getParameters().add(ApplicationPartType.PLAINTEXT);
		f6.getParameters().add(ApplicationPartType.CRYPTOGRAPHIC_KEY);
		Rule rule4 = KbFactory.eINSTANCE.createRule();
		rule4.setAction(ActionType.ENCRYPT_AES128_ECB);
		rule4.getFunctionDeclarations().add(f6);
		ontology.serialize(rule4);

		ontology.serialize(preferences);
		ontology.serialize(KbFactory.eINSTANCE.createSolution());

		return ontology;
	}
}

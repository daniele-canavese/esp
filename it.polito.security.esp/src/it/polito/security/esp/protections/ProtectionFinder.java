package it.polito.security.esp.protections;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.ActionType;
import it.polito.security.esp.kb.KbFactory;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartSet;
import it.polito.security.esp.kb.ApplicationPartType;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.AttackMitigation;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.AttackStep;
import it.polito.security.esp.kb.AttackStepType;
import it.polito.security.esp.kb.Level;
import it.polito.security.esp.kb.Protection;
import it.polito.security.esp.kb.ProtectionFlag;
import it.polito.security.esp.kb.ProtectionInstantiation;
import it.polito.security.esp.kb.ProtectionObjective;
import it.polito.security.esp.kb.UseTarget;
import it.polito.security.esp.kb.UseType;
import it.polito.security.esp.util.Collections;
import it.polito.security.ontologies.exceptions.InconsistencyException;
import it.polito.security.ontologies.exceptions.NoSuchEntityException;
import it.polito.security.ontologies.exceptions.OntologyChangeException;
import it.polito.security.ontologies.exceptions.ParsingErrorException;
import it.polito.security.ontologies.exceptions.ReasoningInterruptedException;

/**
 * Finds the protections and their relative data.
 * @author Daniele Canavese
 **/
public class ProtectionFinder
{
	/** The ESP. **/
	private final ESP esp;
	private HashMap<ProtectionInstantiation, HashMap<Integer, String>> labelToAttestator;
	private HashMap<String, ApplicationPart> attestatorToPart;

	/**
	 * Creates the finder.
	 * @param esp
	 *            The ESP.
	 **/
	public ProtectionFinder(ESP esp)
	{
		this.esp = esp;
		labelToAttestator = new HashMap<>();
		attestatorToPart = new HashMap<>();
	}

	/**
	 * Runs the protection deduction phase and computes all the relevant data.
	 * @throws OntologyChangeException
	 *             If an axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 **/
	public void run() throws InstantiationException, IllegalAccessException, ClassNotFoundException, OntologyChangeException,
			ParsingErrorException, NoSuchEntityException, IOException, InconsistencyException, ReasoningInterruptedException
	{
		log.info("Inferring the protections...");

		long start = System.currentTimeMillis();
		inferDirectMitigations();
		inferIndirectMitigations();
		inferAppliedProtectionInstantiations();
		long stop = System.currentTimeMillis();

		log.info(String.format("Protections inferred = %d protections, %d PIs, %d applied PIs, %.3f s",
				esp.getModel().getProtectionsCount(), esp.getModel().getProtectionInstantiationsCount(),
				esp.getModel().getAppliedProtectionInstantiationsCount(), (stop - start) / 1000.0f));
	}

	/**
	 * Infers the applied protection instantiations.
	 **/
	private void inferAppliedProtectionInstantiations()
	{
		Set<ApplicationPart> parts = new HashSet<>();

		for (ProtectionObjective i : esp.getModel().getProtectionObjectives())
			parts.add(i.getApplicationPart());

		Level minimumLevel = esp.getModel().getPreferences().getProtectionsMinimumAttackMitigation();
		Level mitigationLevel = Level.HIGH;
		while (mitigationLevel != null)
		{
			for (Protection i : esp.getModel().getAvailableProtections())
				if (i.isAutomaticallyDeployable())
					for (ProtectionInstantiation j : i.getInstantiations())
						for (ApplicationPart k : parts)
							addAppliedProtectionInstantiation(j, k, mitigationLevel);

			if (mitigationLevel == minimumLevel)
				break;
			else if (mitigationLevel == Level.HIGH)
				mitigationLevel = Level.MEDIUM;
			else if (mitigationLevel == Level.MEDIUM)
				mitigationLevel = Level.LOW;
			else
				mitigationLevel = null;
		}

		HashSet<ProtectionObjective> pos = new HashSet<>();
		pos.addAll(esp.getModel().getProtectionObjectives());
		for (AppliedProtectionInstantiation i : esp.getModel().getAppliedProtectionInstantiations())
			pos.removeAll(i.getProtectionObjectives());

		if (!pos.isEmpty())
			log.severe("Unprotectable POs = " + pos);

		for (AppliedProtectionInstantiation api : esp.getModel().getAppliedProtectionInstantiations())
		{
			if (api.getAttestatorAnnotation() == null)
				log.finer(api.getApplicationPart() + " " + api.getProtectionInstantiation() + " " + api.hashCode());
			else
				log.finer(api.getApplicationPart() + " " + api.getProtectionInstantiation() + " " + api.getAttestatorAnnotation() + " "
						+ api.hashCode());
		}
	}

	/**
	 * Adds an applied protection instantiation, if needed.
	 * @param pi
	 *            The protection instantiation.
	 * @param part
	 *            The application part.
	 * @param mitigationLevel
	 *            The required mitigation level.
	 **/
	private void addAppliedProtectionInstantiation(ProtectionInstantiation pi, ApplicationPart part, Level mitigationLevel)
	{
		// Skips if the application part type is incompatible.
		if (!pi.getProtection().getApplicationPartTypes().contains(part.getType()))
			return;
		// Skips if some special requirements are not met.
		if (!checkRequirements(pi, part))
			return;

		AppliedProtectionInstantiation appliedProtectionInstantiation = getAppliedPI(pi, part);

		for (AttackMitigation i : pi.getProtection().getMitigations())
			if (i.getLevel() == mitigationLevel)
				for (AttackPath k : i.getAttackPaths())
					for (ProtectionObjective l : k.getProtectionObjectives())
						if (part.equals(l.getApplicationPart()))
						{
							Collections.addUnique(appliedProtectionInstantiation.getAttackMitigations(), i);
							Collections.addUnique(appliedProtectionInstantiation.getProtectionObjectives(), l);
							Collections.addUnique(k.getAppliedProtectionInstantiations(), appliedProtectionInstantiation);
						}

		if (!appliedProtectionInstantiation.getProtectionObjectives().isEmpty())
			Collections.addUnique(esp.getModel().getAppliedProtectionInstantiations(), appliedProtectionInstantiation);
	}

	/**
	 * Finds an already existing applied protection instantiation or create a new one if it does not exist.
	 * @param pi
	 *            The protection instantiation.
	 * @param part
	 *            The application part.
	 * @return The applied protection instantiation.
	 **/
	AppliedProtectionInstantiation getAppliedPI(ProtectionInstantiation pi, ApplicationPart part)
	{
		for (AppliedProtectionInstantiation i : esp.getModel().getAppliedProtectionInstantiations())
			if (i.getProtectionInstantiation().equals(pi) && i.getApplicationPart().equals(part))
				return i;

		AppliedProtectionInstantiation appliedProtectionInstantiation;
		appliedProtectionInstantiation = KbFactory.eINSTANCE.createAppliedProtectionInstantiation();
		appliedProtectionInstantiation.setProtectionInstantiation(pi);
		appliedProtectionInstantiation.setApplicationPart(part);
		appliedProtectionInstantiation.setCodeAnnotation(pi.getCodeAnnotation());

		if (pi.getProtection().getFlags().contains(ProtectionFlag.MERGE_ATTESTATORS))
		{
			// Use a random attestator, if not existing create a new one; then save the attestator annotation in the appliedPI.

			Random random = new Random();
			long seed = 0xF0CACC1A;
			random.setSeed(seed);
			Integer randomLabelIndex = random.nextInt(esp.getModel().getPreferences().getMaxAttestatorsPerProtectionInstantiation());
			HashMap<Integer, String> attMap = labelToAttestator.get(pi);
			if (attMap == null)
			{
				attMap = new HashMap<>();
				labelToAttestator.put(pi, attMap);
			}

			String newAttAnn = attMap.get(randomLabelIndex);
			String label = (((pi.getName() + "_attestator_" + randomLabelIndex.toString()).replace(' ', '_')).replace('(', '_'))
					.replace(')', '_');

			if (newAttAnn == null)
			{
				// TODO evitare di creare due attestatori identici?
				String attAnn = pi.getAttestatorAnnotation();
				String[] attAnnParts = attAnn.split("#");
				newAttAnn = "";

				for (String annPart : attAnnParts)
				{
					String newAnnPart = annPart;
					if (annPart.startsWith("random"))
					{
						String[] choices = annPart.split("\\(")[1].split("\\)")[0].split(",");
						Integer randomIndex = random.nextInt(choices.length);
						newAnnPart = choices[randomIndex].trim();
					}
					else if (annPart.startsWith("label"))
						newAnnPart = label;
					newAttAnn += newAnnPart;
				}
				attMap.put(randomLabelIndex, newAttAnn);
			}

			appliedProtectionInstantiation.setAttestatorAnnotation(newAttAnn);

			// Create the real code region annotation for the asset, using the selected label
			String newAssetAnn = "";
			String[] assetAnnParts = pi.getCodeAnnotation().split("#");
			for (String assetAnnPart : assetAnnParts)
			{
				String newAssetAnnPart = assetAnnPart;
				if (assetAnnPart.startsWith("label"))
					newAssetAnnPart = label;
				newAssetAnn += newAssetAnnPart;
			}
			appliedProtectionInstantiation.setCodeAnnotation(newAssetAnn);

			// Create (if not already done) a code region for the attestator, and bind the asset and the new code region in the same
			// ApplicationPartSet.
			ApplicationPart attestatorRegion = attestatorToPart.get(newAttAnn);
			if (attestatorRegion == null)
			{
				attestatorRegion = KbFactory.eINSTANCE.createApplicationPart();
				attestatorRegion.setName(label);
				for (ApplicationPart fatherRegion : esp.getModel().getApplicationParts())
					if (fatherRegion.isCode() && !fatherRegion.containsAsset() && !fatherRegion.getSourceFilePath().contains("HTTP.c"))
					{
						fatherRegion.getApplicationParts().add(attestatorRegion);
						attestatorRegion.setStartLine(fatherRegion.getBody().getStartLine());
						attestatorRegion.setEndLine(fatherRegion.getBody().getStartLine());
						attestatorRegion.setSourceFilePath(fatherRegion.getSourceFilePath());
						attestatorRegion.setType(ApplicationPartType.ATTESTATOR);
						attestatorRegion.setWeight(0);
						attestatorRegion.setInSystemFile(false);
						attestatorRegion.setDeclaringCode(fatherRegion);
						attestatorRegion.setIndex(0);
						Integer id = 0;
						for (ApplicationPart asset : esp.getModel().getAllApplicationParts())
							if (asset.getId() > id)
								id = asset.getId();
						attestatorRegion.setId(id + 1);
						attestatorToPart.put(newAttAnn, attestatorRegion);
						break;
					}
				log.finest(
						"new attestator region for " + pi.getName() + ", realCodeAnn=" + appliedProtectionInstantiation.getCodeAnnotation()
								+ " realAttAnn=" + appliedProtectionInstantiation.getAttestatorAnnotation() + " attestatorPartHash="
								+ attestatorRegion.hashCode() + " assetPartHash" + part.hashCode());
			}
			ApplicationPartSet set = KbFactory.eINSTANCE.createApplicationPartSet();
			set.getApplicationParts().add(attestatorRegion);
			set.getApplicationParts().add(part);
			set.setAction(ActionType.ATTEST);
			esp.getModel().getApplicationPartSets().add(set);
			log.finest("new set " + attestatorRegion + " " + part);
			esp.updateAssets();
		}

		if (pi.getProtection().getName().equals("data obfuscation"))
		{
			String[] annParts = pi.getVariableAnnotation().split("#");
			String newAnn = "";
			Random random = new Random();
			Long randomNumber = 0L;
			Long max = 0L;
			for (String annPart : annParts)
			{
				String newAnnPart = annPart;
				if (annPart.equals("random"))
				{
					Long upperBound = 1L;
					upperBound = Long.rotateLeft(upperBound, part.getDatumSize() * 8);
					--upperBound;
					randomNumber = random.nextLong();
					randomNumber &= upperBound;
					newAnnPart = randomNumber.toString();
				}
				else if (annPart.equals("vars"))
					newAnnPart = "4";
				else if (annPart.equals("nbits"))
				{
					Long sizeOfRandomNumber = (Long.numberOfTrailingZeros((Long.highestOneBit(randomNumber))) + 1L);
					newAnnPart = sizeOfRandomNumber.toString();
				}
				else if (annPart.equals("min"))
				{
					Integer sizeOfVariableInt = (part.getDatumSize() * 8);
					Double sizeOfVariable = sizeOfVariableInt.doubleValue();
					Double twoPowSizeOfVariable = Math.pow(2.0, sizeOfVariable);
					Double twoPowSizeOfVariableSqrt = Math.sqrt(twoPowSizeOfVariable);
					Double twoPowSizeOfVariableSqrtFloor = Math.floor(twoPowSizeOfVariableSqrt);
					max = twoPowSizeOfVariableSqrtFloor.longValue();

					Integer upperBound = part.getDatumUpperBound();
					Double upperBoundSqrt = Math.sqrt(upperBound);
					Double upperBoundSqrtFloor = Math.floor(upperBoundSqrt);
					Long min = upperBoundSqrtFloor.longValue() + 1L;
					newAnnPart = min.toString();
				}
				else if (annPart.equals("max"))
					newAnnPart = max.toString();

				newAnn += newAnnPart;
			}
			appliedProtectionInstantiation.setVariableAnnotation(newAnn);

			boolean hasAccessSet = false;
			for (ApplicationPartSet set : appliedProtectionInstantiation.getApplicationPart().getSets())
				if (set.getAction().equals(ActionType.ACCESS))
				{
					hasAccessSet = true;
					break;
				}

			if (!hasAccessSet)
			{
				ApplicationPartSet set = KbFactory.eINSTANCE.createApplicationPartSet();
				set.setAction(ActionType.ACCESS);
				set.getApplicationParts().add(appliedProtectionInstantiation.getApplicationPart());
				for (UseTarget target : appliedProtectionInstantiation.getApplicationPart().getTargetOf())
					if (target.getType().equals(UseType.ACCESSES))
					{
						ApplicationPart body = null;
						ApplicationPart function = target.getUsedBy();
						if (function.getType().equals(ApplicationPartType.FUNCTION))
						{
							for (ApplicationPart functionSon : function.getApplicationParts())
								if (functionSon.getStartLine() == function.getBody().getStartLine()
										&& functionSon.getEndLine() == function.getBody().getEndLine())
								{
									body = functionSon;
									break;
								}
							if (body == null)
							{
								body = KbFactory.eINSTANCE.createApplicationPart();
								body.setName(function.getName() + ".body");
								body.setSourceFilePath(function.getSourceFilePath());
								body.setInSystemFile(function.isInSystemFile());
								body.setType(ApplicationPartType.CODE_REGION);
								body.setWeight(0.0);
								body.setStartLine(function.getBody().getStartLine());
								body.setEndLine(function.getBody().getEndLine());
								LinkedList<ApplicationPart> list = new LinkedList<>();
								for (ApplicationPart child : function.getApplicationParts())
									if (!child.getType().equals(ApplicationPartType.PARAMETER))
										list.add(child);
								function.getApplicationParts().removeAll(list);
								body.getApplicationParts().addAll(list);
								function.getApplicationParts().add(body);
								esp.updateAssets();
								log.fine("added body code region, function " + function.getName());
							}
						}
						else
							body = function;
						set.getApplicationParts().add(body);
					}

				esp.getModel().getApplicationPartSets().add(set);
				StringBuilder stringBuilder = new StringBuilder();
				for (ApplicationPart part1 : set.getApplicationParts())
					stringBuilder.append(part1.getName() + " ");
				log.fine("added set " + stringBuilder.toString());
			}
			
			
		}

		if (pi.getName().contains("Tigress"))
		{
			appliedProtectionInstantiation.setCodeAnnotation(null);
			String[] annParts = pi.getToolCommand().split("#");
			String newAnn = "";
//			Random random = new Random();
//			Long randomNumber = 0L;
//			Long max = 0L;
			for (String annPart : annParts)
			{
				String newAnnPart = annPart;
//				if (annPart.equals("random"))
//				{
//					Long upperBound = 1L;
//					upperBound = Long.rotateLeft(upperBound, part.getDatumSize() * 8);
//					--upperBound;
//					randomNumber = random.nextLong();
//					randomNumber &= upperBound;
//					newAnnPart = randomNumber.toString();
//				}
//				else if (annPart.equals("vars"))
//					newAnnPart = "4";
//				else if (annPart.equals("nbits"))
//				{
//					Long sizeOfRandomNumber = (Long.numberOfTrailingZeros((Long.highestOneBit(randomNumber))) + 1L);
//					newAnnPart = sizeOfRandomNumber.toString();
//				}
//				else if (annPart.equals("min"))
//				{
//					Integer sizeOfVariableInt = (part.getDatumSize() * 8);
//					Double sizeOfVariable = sizeOfVariableInt.doubleValue();
//					Double twoPowSizeOfVariable = Math.pow(2.0, sizeOfVariable);
//					Double twoPowSizeOfVariableSqrt = Math.sqrt(twoPowSizeOfVariable);
//					Double twoPowSizeOfVariableSqrtFloor = Math.floor(twoPowSizeOfVariableSqrt);
//					max = twoPowSizeOfVariableSqrtFloor.longValue();
//
//					Integer upperBound = part.getDatumUpperBound();
//					Double upperBoundSqrt = Math.sqrt(upperBound);
//					Double upperBoundSqrtFloor = Math.floor(upperBoundSqrt);
//					Long min = upperBoundSqrtFloor.longValue() + 1L;
//					newAnnPart = min.toString();
//				}
//				else if (annPart.equals("max"))
//					newAnnPart = max.toString();
				
				if(annPart.equals("func"))
				{
					ApplicationPart function = part;
					while(function.getDeclaringCode()!=null)
					{
						function = function.getDeclaringCode();
					}
					if(function.getType().equals(ApplicationPartType.FUNCTION))
						newAnnPart = function.getName();					
				}
//				'#container_func#:#var#'
				else if(annPart.equals("container_func"))
					newAnnPart = part.getDeclaringCode().getName();
				else if(annPart.equals("var"))
					newAnnPart = part.getName();
				
				newAnn += newAnnPart;
			}
			appliedProtectionInstantiation.setToolCommand(newAnn);
		}
		
		return appliedProtectionInstantiation;
	}

	/**
	 * Performs some additional checks for a potential applied protection instantiation.
	 * @param pi
	 *            The protection instantiation to check.
	 * @param part
	 *            The application part where the PI should be deployed.
	 * @return <code>true</code> if the applied PI is applicable, <code>false</code> otherwise.
	 **/
	private boolean checkRequirements(ProtectionInstantiation pi, ApplicationPart part)
	{
		if (pi.getProtection().getFlags().contains(ProtectionFlag.WHOLE_FUNCTION))
		{
			ApplicationPart function = part.getDeclaringCode();
			while (function.getType() != ApplicationPartType.FUNCTION)
				function = function.getDeclaringCode();
			if (part.getStartLine() > function.getBody().getStartLine() || part.getEndLine() < function.getBody().getEndLine())
				return false;
		}
		if (pi.getProtection().getFlags().contains(ProtectionFlag.NO_CONTAINED_CODE_REGIONS))
		{
			for(ApplicationPart containedCodeRegion: part.getApplicationParts())
				if(containedCodeRegion.isCode())
					return false;
		}
		if (pi.getProtection().getFlags().contains(ProtectionFlag.NO_CONTAINED_ASSETS))
		{
			ApplicationPart function = part.getDeclaringCode();
			while (function.getType() != ApplicationPartType.FUNCTION)
				function = function.getDeclaringCode();
			if(function.getAssets().size()>1)
				return false;
		}
		return true;
	}

	/**
	 * Infers the direct mitigations applied to the assets.
	 * @throws OntologyChangeException
	 *             If an axiom cannot be added.
	 * @throws ParsingErrorException
	 *             If the expression is invalid.
	 * @throws NoSuchEntityException
	 *             If one of the involved entities does not exist or if the object is not correctly annotated.
	 * @throws IOException
	 *             If an object cannot be deserialized.
	 * @throws InconsistencyException
	 *             If the ontology is inconsistent.
	 * @throws ReasoningInterruptedException
	 *             If the reasoning is interrupted.
	 * @throws ClassNotFoundException
	 *             If a class can not be found.
	 * @throws IllegalAccessException
	 *             If a Java been class cannot be used.
	 * @throws InstantiationException
	 *             If a Java been class cannot be instantiated.
	 **/
	private void inferDirectMitigations() throws OntologyChangeException, ParsingErrorException, NoSuchEntityException, IOException,
			InconsistencyException, ReasoningInterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		Map<AttackStepType, Set<AttackPath>> map = new HashMap<>();

		for (AttackPath i : esp.getModel().getAttackPaths())
			for (AttackStep j : i.getAttackSteps())
			{
				Set<AttackPath> set;
				if (map.containsKey(j.getType()))
					set = map.get(j.getType());
				else
				{
					set = new HashSet<>();
					map.put(j.getType(), set);
				}
				set.add(i);
			}

		for (Protection i : esp.getModel().getAvailableProtections())
			if (!i.getInstantiations().isEmpty())
				for (AttackMitigation j : i.getMitigations())
					if (map.containsKey(j.getType()))
						for (AttackPath k : map.get(j.getType()))
							for (ProtectionObjective l : k.getProtectionObjectives())
								if (i.getApplicationPartTypes().contains(l.getApplicationPart().getType()))
								{
									j.getAttackPaths().add(k);
									break;
								}
	}

	/**
	 * Infers the indirect mitigations applied to the non-assets.
	 **/
	private void inferIndirectMitigations()
	{
	}

	/** The logger. **/
	private static Logger log = Logger.getLogger(ProtectionFinder.class.getName());
}

package it.polito.security.esp.l1p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;

import it.polito.security.esp.ESP;
import it.polito.security.esp.kb.ActionType;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartSet;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.Protection;
import it.polito.security.esp.util.Collections;

/**
 * A class that find the code correlation sets.
 * @author Daniele Canavese
 **/
public class CorrelationSplitter
{
	/** The ESP. **/
	private ESP esp;

	/**
	 * Creates the splitter.
	 * @param esp
	 *            The ESP.
	 **/
	public CorrelationSplitter(ESP esp)
	{
		this.esp = esp;
	}

	/**
	 * Retrieves the list of code correlation sets.
	 * @return The code correlations sets.
	 **/
	public List<List<ApplicationPart>> getCorrelationSets()
	{
		List<List<ApplicationPart>> sets = new ArrayList<>();

		for (AppliedProtectionInstantiation i : esp.getModel().getAppliedProtectionInstantiations())
		{
			List<ApplicationPart> directlyCorrelatedApplicationParts = getDirectlyCorrelatedApplicationParts(i);
			Collections.addUnique(sets, directlyCorrelatedApplicationParts);
		}

		boolean changed = true;
		while (changed)
		{
			changed = false;
			for (List<ApplicationPart> i : sets)
			{
				Set<Protection> protections1 = getProtections(i);
				for (List<ApplicationPart> j : sets)
					if (i != j)
					{
						Set<Protection> protections2 = getProtections(j);
						if (Collections.containsAny(i, j) || (esp.getModel().getPreferences().isL1pUseACTCPrecedences()
								&& Collections.containsAny(protections1, protections2)))
						{
							i.addAll(j);
							j.clear();
							changed = true;
						}
					}
			}
		}
		Iterator<List<ApplicationPart>> iterator = sets.iterator();
		while (iterator.hasNext())
		{
			List<ApplicationPart> i = iterator.next();
			if (i.size() == 0)
				iterator.remove();
		}

		return sets;
	}

	/**
	 * Retrieves the application parts directly correlated with an applied PI.
	 * @param appliedProtectionInstantiation
	 *            The applied PI.
	 * @return The directly correlated application part set.
	 **/
	private List<ApplicationPart> getDirectlyCorrelatedApplicationParts(AppliedProtectionInstantiation appliedProtectionInstantiation)
	{
		List<ApplicationPart> parts = new ArrayList<>();
		ApplicationPart part = appliedProtectionInstantiation.getApplicationPart();
		Stack<ApplicationPart> aux = new Stack<>();

		// Itself!
		parts.add(part);

		// The application parts in the relevant sets.
		for (ApplicationPartSet i : appliedProtectionInstantiation.getApplicationPart().getSets())
			if (appliedProtectionInstantiation.getProtectionInstantiation().getProtection().getActions().contains(i.getAction()) && !i.getAction().equals(ActionType.ATTEST))
				parts.addAll(i.getApplicationParts());

		// The contained application parts.
		aux.addAll(parts);
		while (!aux.isEmpty())
		{
			ApplicationPart i = aux.pop();
			EList<ApplicationPart> contained = i.getApplicationParts();
			parts.addAll(contained);
		}

		// The parents.
		aux.addAll(parts);
		while (!aux.isEmpty())
		{
			ApplicationPart i = aux.pop();
			ApplicationPart parent = i.getDeclaringCode();
			while (parent != null)
			{
				parts.add(parent);
				parent = parent.getDeclaringCode();
			}
		}

		return parts;
	}

	/**
	 * Retrieves all the protections that can be placed on a set of application parts.
	 * @param applicationParts
	 *            The set of application parts.
	 * @return The protections for the application parts.
	 **/
	private Set<Protection> getProtections(Collection<ApplicationPart> applicationParts)
	{
		Set<Protection> protections = new HashSet<>();

		for (ApplicationPart i : applicationParts)
			for (AppliedProtectionInstantiation j : esp.getModel().getAppliedProtectionInstantiations())
				if (j.getApplicationPart() == i)
					protections.add(j.getProtectionInstantiation().getProtection());

		return protections;
	}
}

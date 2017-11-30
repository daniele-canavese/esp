/**
 */
package it.polito.security.esp.kb;

import it.polito.security.ontologies.Ontology;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.Model#getOntology <em>Ontology</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getApplicationParts <em>Application Parts</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getApplicationPartSets <em>Application Part Sets</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttackPaths <em>Attack Paths</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttackStepTypes <em>Attack Step Types</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttackSteps <em>Attack Steps</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getProtections <em>Protections</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getPreferences <em>Preferences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getRules <em>Rules</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getProtectionObjectives <em>Protection Objectives</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAvailableProtections <em>Available Protections</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAvailableSecondLevelProtections <em>Available Second Level Protections</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAssets <em>Assets</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttacker <em>Attacker</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttackerToolTypes <em>Attacker Tool Types</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttackerTools <em>Attacker Tools</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getVanillaSolution <em>Vanilla Solution</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getSolutions <em>Solutions</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttackStepProbabilities <em>Attack Step Probabilities</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAvailableTools <em>Available Tools</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getApplicationPartsCount <em>Application Parts Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAllApplicationParts <em>All Application Parts</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAssetsCount <em>Assets Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getDataCount <em>Data Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getCodesCount <em>Codes Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getProtectionsCount <em>Protections Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttackerToolsCount <em>Attacker Tools Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttackerToolTypesCount <em>Attacker Tool Types Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAvailableAttackerToolsCount <em>Available Attacker Tools Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAvailableProtectionsCount <em>Available Protections Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttackPathsCount <em>Attack Paths Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttackStepsCount <em>Attack Steps Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAttackStepTypesCount <em>Attack Step Types Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getProtectionObjectivesCount <em>Protection Objectives Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getAppliedProtectionInstantiationsCount <em>Applied Protection Instantiations Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getProtectionInstantiationsCount <em>Protection Instantiations Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getSolutionsCount <em>Solutions Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Model#getKeyAttackPaths <em>Key Attack Paths</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
	/**
	 * Returns the value of the '<em><b>Ontology</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ontology.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ontology</em>' attribute.
	 * @see #setOntology(Ontology)
	 * @see it.polito.security.esp.kb.KbPackage#getModel_Ontology()
	 * @model unique="false" dataType="it.polito.security.esp.kb.Ontology"
	 * @generated
	 */
	Ontology getOntology();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Model#getOntology <em>Ontology</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ontology</em>' attribute.
	 * @see #getOntology()
	 * @generated
	 */
	void setOntology(Ontology value);

	/**
	 * Returns the value of the '<em><b>Application Parts</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ApplicationPart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The contained application parts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Parts</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_ApplicationParts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ApplicationPart> getApplicationParts();

	/**
	 * Returns the value of the '<em><b>Application Part Sets</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ApplicationPartSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The contained application part sets.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Part Sets</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_ApplicationPartSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<ApplicationPartSet> getApplicationPartSets();

	/**
	 * Returns the value of the '<em><b>Attack Paths</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackPath}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack paths.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Paths</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AttackPaths()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttackPath> getAttackPaths();

	/**
	 * Returns the value of the '<em><b>Attack Step Types</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackStepType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack step types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Step Types</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AttackStepTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttackStepType> getAttackStepTypes();

	/**
	 * Returns the value of the '<em><b>Attack Steps</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackStep}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack steps.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Steps</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AttackSteps()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttackStep> getAttackSteps();

	/**
	 * Returns the value of the '<em><b>Protections</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Protection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protections.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protections</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_Protections()
	 * @model containment="true"
	 * @generated
	 */
	EList<Protection> getProtections();

	/**
	 * Returns the value of the '<em><b>Preferences</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The preferences.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Preferences</em>' containment reference.
	 * @see #setPreferences(Preferences)
	 * @see it.polito.security.esp.kb.KbPackage#getModel_Preferences()
	 * @model containment="true"
	 * @generated
	 */
	Preferences getPreferences();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Model#getPreferences <em>Preferences</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preferences</em>' containment reference.
	 * @see #getPreferences()
	 * @generated
	 */
	void setPreferences(Preferences value);

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Rule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The rules.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getRules();

	/**
	 * Returns the value of the '<em><b>Protection Objectives</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ProtectionObjective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection objectives.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protection Objectives</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_ProtectionObjectives()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProtectionObjective> getProtectionObjectives();

	/**
	 * Returns the value of the '<em><b>Applied Protection Instantiations</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AppliedProtectionInstantiation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The applied protection instantiations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applied Protection Instantiations</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AppliedProtectionInstantiations()
	 * @model containment="true"
	 * @generated
	 */
	EList<AppliedProtectionInstantiation> getAppliedProtectionInstantiations();

	/**
	 * Returns the value of the '<em><b>Available Protections</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Protection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The available protections.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Available Protections</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AvailableProtections()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.Protection%>> availableProtections = new <%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.Protection%>>();\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.Protection%>> _protections = this.getProtections();\nfor (final <%it.polito.security.esp.kb.Protection%> i : _protections)\n{\n\tboolean _isEnabled = i.isEnabled();\n\tif (_isEnabled)\n\t{\n\t\tavailableProtections.add(i);\n\t}\n}\nreturn availableProtections;'"
	 * @generated
	 */
	EList<Protection> getAvailableProtections();

	/**
	 * Returns the value of the '<em><b>Available Second Level Protections</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Protection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Second Level Protections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Second Level Protections</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AvailableSecondLevelProtections()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.Protection%>> availableSecondLevelProtections = new <%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.Protection%>>();\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.Protection%>> _protections = this.getProtections();\nfor (final <%it.polito.security.esp.kb.Protection%> i : _protections)\n{\n\tif ((i.isEnabled() && i.isSecondLevel()))\n\t{\n\t\tavailableSecondLevelProtections.add(i);\n\t}\n}\nreturn availableSecondLevelProtections;'"
	 * @generated
	 */
	EList<Protection> getAvailableSecondLevelProtections();

	/**
	 * Returns the value of the '<em><b>Assets</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ApplicationPart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The assets.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assets</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_Assets()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.ApplicationPart%>> assets = new <%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.ApplicationPart%>>();\n<%java.util.Stack%><<%it.polito.security.esp.kb.ApplicationPart%>> parts = new <%java.util.Stack%><<%it.polito.security.esp.kb.ApplicationPart%>>();\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPart%>> _applicationParts = this.getApplicationParts();\n<%com.google.common.collect.Iterables%>.<<%it.polito.security.esp.kb.ApplicationPart%>>addAll(parts, _applicationParts);\nwhile ((!parts.isEmpty()))\n{\n\t{\n\t\t<%it.polito.security.esp.kb.ApplicationPart%> i = parts.pop();\n\t\tboolean _isAsset = i.isAsset();\n\t\tif (_isAsset)\n\t\t{\n\t\t\tassets.add(i);\n\t\t}\n\t\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPart%>> _applicationParts_1 = i.getApplicationParts();\n\t\t<%com.google.common.collect.Iterables%>.<<%it.polito.security.esp.kb.ApplicationPart%>>addAll(parts, _applicationParts_1);\n\t}\n}\nreturn assets;'"
	 * @generated
	 */
	EList<ApplicationPart> getAssets();

	/**
	 * Returns the value of the '<em><b>Attacker</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attacker.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacker</em>' containment reference.
	 * @see #setAttacker(Attacker)
	 * @see it.polito.security.esp.kb.KbPackage#getModel_Attacker()
	 * @model containment="true"
	 * @generated
	 */
	Attacker getAttacker();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Model#getAttacker <em>Attacker</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attacker</em>' containment reference.
	 * @see #getAttacker()
	 * @generated
	 */
	void setAttacker(Attacker value);

	/**
	 * Returns the value of the '<em><b>Attacker Tool Types</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackerToolType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attacker tool types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacker Tool Types</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AttackerToolTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttackerToolType> getAttackerToolTypes();

	/**
	 * Returns the value of the '<em><b>Attacker Tools</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackerTool}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The available attacker tools.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacker Tools</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AttackerTools()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttackerTool> getAttackerTools();

	/**
	 * Returns the value of the '<em><b>Vanilla Solution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The vanilla application solution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vanilla Solution</em>' containment reference.
	 * @see #setVanillaSolution(Solution)
	 * @see it.polito.security.esp.kb.KbPackage#getModel_VanillaSolution()
	 * @model containment="true"
	 * @generated
	 */
	Solution getVanillaSolution();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Model#getVanillaSolution <em>Vanilla Solution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vanilla Solution</em>' containment reference.
	 * @see #getVanillaSolution()
	 * @generated
	 */
	void setVanillaSolution(Solution value);

	/**
	 * Returns the value of the '<em><b>Solutions</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Solution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The solutions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Solutions</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_Solutions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Solution> getSolutions();

	/**
	 * Returns the value of the '<em><b>Attack Step Probabilities</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackStepProbability}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack step probabilities.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Step Probabilities</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AttackStepProbabilities()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttackStepProbability> getAttackStepProbabilities();

	/**
	 * Returns the value of the '<em><b>Available Tools</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackerTool}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The tools available to the attacker.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Available Tools</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AvailableTools()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.AttackerTool%>> tools = new <%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.AttackerTool%>>();\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackerTool%>> _attackerTools = this.getAttackerTools();\nfor (final <%it.polito.security.esp.kb.AttackerTool%> i : _attackerTools)\n{\n\tboolean _isEnabled = i.isEnabled();\n\tif (_isEnabled)\n\t{\n\t\ttools.add(i);\n\t}\n}\nreturn tools;'"
	 * @generated
	 */
	EList<AttackerTool> getAvailableTools();

	/**
	 * Returns the value of the '<em><b>Application Parts Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of application parts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Parts Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_ApplicationPartsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPart%>> _allApplicationParts = this.getAllApplicationParts();\nreturn _allApplicationParts.size();'"
	 * @generated
	 */
	int getApplicationPartsCount();

	/**
	 * Returns the value of the '<em><b>All Application Parts</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ApplicationPart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves all the application parts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>All Application Parts</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AllApplicationParts()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.ApplicationPart%>> parts = new <%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.ApplicationPart%>>();\n<%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.ApplicationPart%>> aux = new <%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.ApplicationPart%>>();\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPart%>> _applicationParts = this.getApplicationParts();\naux.addAll(_applicationParts);\nwhile ((!aux.isEmpty()))\n{\n\t{\n\t\t<%it.polito.security.esp.kb.ApplicationPart%> p = aux.get(0);\n\t\taux.remove(0);\n\t\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPart%>> _applicationParts_1 = p.getApplicationParts();\n\t\tfor (final <%it.polito.security.esp.kb.ApplicationPart%> j : _applicationParts_1)\n\t\t{\n\t\t\taux.add(0, j);\n\t\t}\n\t\tparts.add(p);\n\t}\n}\nreturn parts;'"
	 * @generated
	 */
	EList<ApplicationPart> getAllApplicationParts();

	/**
	 * Returns the value of the '<em><b>Assets Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of assets.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Assets Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AssetsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPart%>> _assets = this.getAssets();\nreturn _assets.size();'"
	 * @generated
	 */
	int getAssetsCount();

	/**
	 * Returns the value of the '<em><b>Data Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of data.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_DataCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='int c = 0;\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPart%>> _applicationParts = this.getApplicationParts();\nfor (final <%it.polito.security.esp.kb.ApplicationPart%> i : _applicationParts)\n{\n\tboolean _isDatum = i.isDatum();\n\tif (_isDatum)\n\t{\n\t\tc = (c + 1);\n\t}\n}\nreturn c;'"
	 * @generated
	 */
	int getDataCount();

	/**
	 * Returns the value of the '<em><b>Codes Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of codes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Codes Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_CodesCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='int c = 0;\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPart%>> _applicationParts = this.getApplicationParts();\nfor (final <%it.polito.security.esp.kb.ApplicationPart%> i : _applicationParts)\n{\n\tboolean _isCode = i.isCode();\n\tif (_isCode)\n\t{\n\t\tc = (c + 1);\n\t}\n}\nreturn c;'"
	 * @generated
	 */
	int getCodesCount();

	/**
	 * Returns the value of the '<em><b>Protections Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of protections.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protections Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_ProtectionsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.Protection%>> _protections = this.getProtections();\nreturn _protections.size();'"
	 * @generated
	 */
	int getProtectionsCount();

	/**
	 * Returns the value of the '<em><b>Attacker Tools Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of attacker tools.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacker Tools Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AttackerToolsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackerTool%>> _attackerTools = this.getAttackerTools();\nreturn _attackerTools.size();'"
	 * @generated
	 */
	int getAttackerToolsCount();

	/**
	 * Returns the value of the '<em><b>Attacker Tool Types Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of attacker tool types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacker Tool Types Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AttackerToolTypesCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackerToolType%>> _attackerToolTypes = this.getAttackerToolTypes();\nreturn _attackerToolTypes.size();'"
	 * @generated
	 */
	int getAttackerToolTypesCount();

	/**
	 * Returns the value of the '<em><b>Available Attacker Tools Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of available attacker tools.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Available Attacker Tools Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AvailableAttackerToolsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackerTool%>> _availableTools = this.getAvailableTools();\nreturn _availableTools.size();'"
	 * @generated
	 */
	int getAvailableAttackerToolsCount();

	/**
	 * Returns the value of the '<em><b>Available Protections Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of available protections.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Available Protections Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AvailableProtectionsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.Protection%>> _availableProtections = this.getAvailableProtections();\nreturn _availableProtections.size();'"
	 * @generated
	 */
	int getAvailableProtectionsCount();

	/**
	 * Returns the value of the '<em><b>Attack Paths Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of attack paths.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Paths Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AttackPathsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackPath%>> _attackPaths = this.getAttackPaths();\nreturn _attackPaths.size();'"
	 * @generated
	 */
	int getAttackPathsCount();

	/**
	 * Returns the value of the '<em><b>Attack Steps Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of attack steps.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Steps Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AttackStepsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackStep%>> _attackSteps = this.getAttackSteps();\nreturn _attackSteps.size();'"
	 * @generated
	 */
	int getAttackStepsCount();

	/**
	 * Returns the value of the '<em><b>Attack Step Types Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of attack step types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Step Types Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AttackStepTypesCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackStepType%>> _attackStepTypes = this.getAttackStepTypes();\nreturn _attackStepTypes.size();'"
	 * @generated
	 */
	int getAttackStepTypesCount();

	/**
	 * Returns the value of the '<em><b>Protection Objectives Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of protection objectives.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protection Objectives Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_ProtectionObjectivesCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ProtectionObjective%>> _protectionObjectives = this.getProtectionObjectives();\nreturn _protectionObjectives.size();'"
	 * @generated
	 */
	int getProtectionObjectivesCount();

	/**
	 * Returns the value of the '<em><b>Applied Protection Instantiations Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of applied protection instantiations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applied Protection Instantiations Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_AppliedProtectionInstantiationsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();\nreturn _appliedProtectionInstantiations.size();'"
	 * @generated
	 */
	int getAppliedProtectionInstantiationsCount();

	/**
	 * Returns the value of the '<em><b>Protection Instantiations Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of protection instantiations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protection Instantiations Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_ProtectionInstantiationsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='int c = 0;\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.Protection%>> _protections = this.getProtections();\nfor (final <%it.polito.security.esp.kb.Protection%> i : _protections)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ProtectionInstantiation%>> _instantiations = i.getInstantiations();\n\tint _size = _instantiations.size();\n\tint _plus = (c + _size);\n\tc = _plus;\n}\nreturn c;'"
	 * @generated
	 */
	int getProtectionInstantiationsCount();

	/**
	 * Returns the value of the '<em><b>Solutions Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the number of solutions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Solutions Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_SolutionsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.Solution%>> _solutions = this.getSolutions();\nreturn _solutions.size();'"
	 * @generated
	 */
	int getSolutionsCount();

	/**
	 * Returns the value of the '<em><b>Key Attack Paths</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackPath}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key Attack Paths</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Attack Paths</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getModel_KeyAttackPaths()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.AttackPath%>> attacks = new <%org.eclipse.emf.common.util.BasicEList%><<%it.polito.security.esp.kb.AttackPath%>>();\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackPath%>> _attackPaths = this.getAttackPaths();\nfor (final <%it.polito.security.esp.kb.AttackPath%> i : _attackPaths)\n{\n\tboolean _isKey = i.isKey();\n\tif (_isKey)\n\t{\n\t\tattacks.add(i);\n\t}\n}\nreturn attacks;'"
	 * @generated
	 */
	EList<AttackPath> getKeyAttackPaths();

} // Model

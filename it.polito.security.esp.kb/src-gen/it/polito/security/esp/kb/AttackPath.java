/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectList;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attack Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An attack path.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.AttackPath#getAttackSteps <em>Attack Steps</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackPath#getProtectionObjectives <em>Protection Objectives</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackPath#getAttackerToolTypes <em>Attacker Tool Types</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackPath#getCost <em>Cost</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackPath#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackPath#isKey <em>Key</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackPath#getId <em>Id</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackPath#getMitigations <em>Mitigations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackPath#getLevel <em>Level</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getAttackPath()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#AttackPath",
	name = "http://security.polito.it/esp/kb#attackPath",
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.ATTACK_PATH__COST, iri = "http://security.polito.it/esp/kb#hasCost"),
		@MapsToDataProperty(id = KbPackage.ATTACK_PATH__KEY, iri = "http://security.polito.it/esp/kb#isKey")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.ATTACK_PATH__PROTECTION_OBJECTIVES, iri = "http://security.polito.it/esp/kb#hasTarget"),
		@MapsToObjectProperty(id = KbPackage.ATTACK_PATH__ATTACKER_TOOL_TYPES, iri = "http://security.polito.it/esp/kb#uses"),
		@MapsToObjectProperty(id = KbPackage.ATTACK_PATH__APPLIED_PROTECTION_INSTANTIATIONS, iri = "http://security.polito.it/esp/kb#isMitigatedBy")
	},
	objectLists =
	{
		@MapsToObjectList
		(
			id = KbPackage.ATTACK_PATH__ATTACK_STEPS,
			startIri = "http://security.polito.it/esp/kb#startsWith",
			nextIri = "http://security.polito.it/esp/kb#isFollowedBy",
			elementIri = "http://security.polito.it/esp/kb#AttackStepInAttackPath",
			elementName = "http://security.polito.it/esp/kb#attackStepInAttackPath",
			propertyIri = "http://security.polito.it/esp/kb#refersTo"
		)
	}
)
public interface AttackPath extends EObject
{
	/**
	 * Returns the value of the '<em><b>Attack Steps</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackStep}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack steps.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Steps</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackPath_AttackSteps()
	 * @model
	 * @generated
	 */
	EList<AttackStep> getAttackSteps();

	/**
	 * Returns the value of the '<em><b>Protection Objectives</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ProtectionObjective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection objectives.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protection Objectives</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackPath_ProtectionObjectives()
	 * @model
	 * @generated
	 */
	EList<ProtectionObjective> getProtectionObjectives();

	/**
	 * Returns the value of the '<em><b>Attacker Tool Types</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackerToolType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attacker tool types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacker Tool Types</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackPath_AttackerToolTypes()
	 * @model
	 * @generated
	 */
	EList<AttackerToolType> getAttackerToolTypes();

	/**
	 * Returns the value of the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The cost.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cost</em>' attribute.
	 * @see #setCost(double)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackPath_Cost()
	 * @model unique="false"
	 * @generated
	 */
	double getCost();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackPath#getCost <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cost</em>' attribute.
	 * @see #getCost()
	 * @generated
	 */
	void setCost(double value);

	/**
	 * Returns the value of the '<em><b>Applied Protection Instantiations</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AppliedProtectionInstantiation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The applied protection instantiations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applied Protection Instantiations</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackPath_AppliedProtectionInstantiations()
	 * @model
	 * @generated
	 */
	EList<AppliedProtectionInstantiation> getAppliedProtectionInstantiations();

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates if this attack path is a key attack or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackPath_Key()
	 * @model unique="false"
	 * @generated
	 */
	boolean isKey();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackPath#isKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #isKey()
	 * @generated
	 */
	void setKey(boolean value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The object id.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackPath_Id()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='int _hashCode = this.hashCode();\nreturn (((long) _hashCode) + (-((long) <%java.lang.Integer%>.MIN_VALUE)));'"
	 * @generated
	 */
	long getId();

	/**
	 * Returns the value of the '<em><b>Mitigations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The mitigations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mitigations</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackPath_Mitigations()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%java.lang.String%> text = \"\";\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();\nfor (final <%it.polito.security.esp.kb.AppliedProtectionInstantiation%> i : _appliedProtectionInstantiations)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackMitigation%>> _attackMitigations = i.getAttackMitigations();\n\tfor (final <%it.polito.security.esp.kb.AttackMitigation%> j : _attackMitigations)\n\t{\n\t\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackPath%>> _attackPaths = j.getAttackPaths();\n\t\tboolean _contains = _attackPaths.contains(this);\n\t\tif (_contains)\n\t\t{\n\t\t\t<%java.lang.String%> _plus = (i + \" (\");\n\t\t\t<%it.polito.security.esp.kb.Level%> _level = j.getLevel();\n\t\t\t<%java.lang.String%> _plus_1 = (_plus + _level);\n\t\t\t<%java.lang.String%> _plus_2 = (_plus_1 + \")\\n\");\n\t\t\ttext = _plus_2;\n\t\t}\n\t}\n}\nreturn text;'"
	 * @generated
	 */
	String getMitigations();

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.Level}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The mitigation level.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see it.polito.security.esp.kb.KbPackage#getAttackPath_Level()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%it.polito.security.esp.kb.Level%> level = <%it.polito.security.esp.kb.Level%>.NONE;\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();\nfor (final <%it.polito.security.esp.kb.AppliedProtectionInstantiation%> i : _appliedProtectionInstantiations)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackMitigation%>> _attackMitigations = i.getAttackMitigations();\n\tfor (final <%it.polito.security.esp.kb.AttackMitigation%> j : _attackMitigations)\n\t{\n\t\tif ((<%com.google.common.base.Objects%>.equal(level, <%it.polito.security.esp.kb.Level%>.NONE) || <%com.google.common.base.Objects%>.equal(level, <%it.polito.security.esp.kb.Level%>.LOW)))\n\t\t{\n\t\t\t<%it.polito.security.esp.kb.Level%> _level = j.getLevel();\n\t\t\tlevel = _level;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif ((<%com.google.common.base.Objects%>.equal(level, <%it.polito.security.esp.kb.Level%>.MEDIUM) && <%com.google.common.base.Objects%>.equal(j.getLevel(), <%it.polito.security.esp.kb.Level%>.HIGH)))\n\t\t\t{\n\t\t\t\t<%it.polito.security.esp.kb.Level%> _level_1 = j.getLevel();\n\t\t\t\tlevel = _level_1;\n\t\t\t}\n\t\t}\n\t}\n}\nreturn level;'"
	 * @generated
	 */
	Level getLevel();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AttackStep%>> _attackSteps = this.getAttackSteps();\nreturn _attackSteps.hashCode();'"
	 * @generated
	 */
	int hashCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Translates the object into a string.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int _hashCode = this.hashCode();\nreturn (\"attack path \" + <%java.lang.Integer%>.valueOf(_hashCode));'"
	 * @generated
	 */
	String toString();

} // AttackPath

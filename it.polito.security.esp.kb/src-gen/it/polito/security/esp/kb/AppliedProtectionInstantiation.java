/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.*;
/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Applied Protection Instantiation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An applied protection instantiation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getProtectionInstantiation <em>Protection Instantiation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getApplicationPart <em>Application Part</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getProtectionObjectives <em>Protection Objectives</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getAttackMitigations <em>Attack Mitigations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getSecondLevelMotivation <em>Second Level Motivation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getVariableAnnotation <em>Variable Annotation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getCodeAnnotation <em>Code Annotation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getVerifierAnnotation <em>Verifier Annotation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getAttestatorAnnotation <em>Attestator Annotation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getToolCommand <em>Tool Command</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getAppliedProtectionInstantiation()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#AppliedProtectionInstantiation",
	name = "http://security.polito.it/esp/kb#appliedProtectionInstantiation",
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION, iri = "http://security.polito.it/esp/kb#uses"),
		@MapsToObjectProperty(id = KbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART, iri = "http://security.polito.it/esp/kb#refersTo"),
		@MapsToObjectProperty(id = KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES, iri = "http://security.polito.it/esp/kb#hasTarget"),
		@MapsToObjectProperty(id = KbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION, iri = "http://security.polito.it/esp/kb#hasSecondLevelMotivation"),
		@MapsToObjectProperty(id = KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS, iri = "http://security.polito.it/esp/kb#mitigates")
	},
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.APPLIED_PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION, iri = "http://security.polito.it/esp/kb#hasVariableAnnotation"),
		@MapsToDataProperty(id = KbPackage.APPLIED_PROTECTION_INSTANTIATION__CODE_ANNOTATION, iri = "http://security.polito.it/esp/kb#hasCodeAnnotation"),
		@MapsToDataProperty(id = KbPackage.APPLIED_PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION, iri = "http://security.polito.it/esp/kb#hasVerifierAnnotation"),
		@MapsToDataProperty(id = KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION, iri = "http://security.polito.it/esp/kb#hasAttestatorAnnotation"),	
		@MapsToDataProperty(id = KbPackage.APPLIED_PROTECTION_INSTANTIATION__TOOL_COMMAND, iri = "http://security.polito.it/esp/kb#hasToolCommand"),	
	}
)
public interface AppliedProtectionInstantiation extends EObject {
	/**
	 * Returns the value of the '<em><b>Protection Instantiation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection instantiation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protection Instantiation</em>' reference.
	 * @see #setProtectionInstantiation(ProtectionInstantiation)
	 * @see it.polito.security.esp.kb.KbPackage#getAppliedProtectionInstantiation_ProtectionInstantiation()
	 * @model
	 * @generated
	 */
	ProtectionInstantiation getProtectionInstantiation();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getProtectionInstantiation <em>Protection Instantiation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protection Instantiation</em>' reference.
	 * @see #getProtectionInstantiation()
	 * @generated
	 */
	void setProtectionInstantiation(ProtectionInstantiation value);

	/**
	 * Returns the value of the '<em><b>Application Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application part.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Part</em>' reference.
	 * @see #setApplicationPart(ApplicationPart)
	 * @see it.polito.security.esp.kb.KbPackage#getAppliedProtectionInstantiation_ApplicationPart()
	 * @model
	 * @generated
	 */
	ApplicationPart getApplicationPart();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getApplicationPart <em>Application Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Part</em>' reference.
	 * @see #getApplicationPart()
	 * @generated
	 */
	void setApplicationPart(ApplicationPart value);

	/**
	 * Returns the value of the '<em><b>Protection Objectives</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ProtectionObjective}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection objectives.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protection Objectives</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAppliedProtectionInstantiation_ProtectionObjectives()
	 * @model
	 * @generated
	 */
	EList<ProtectionObjective> getProtectionObjectives();

	/**
	 * Returns the value of the '<em><b>Attack Mitigations</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackMitigation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack mitigations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Mitigations</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAppliedProtectionInstantiation_AttackMitigations()
	 * @model
	 * @generated
	 */
	EList<AttackMitigation> getAttackMitigations();

	/**
	 * Returns the value of the '<em><b>Second Level Motivation</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.SecondLevelMotivation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this applied protection instantiation is part of a second level solution, why has been decided to apply it.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Second Level Motivation</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAppliedProtectionInstantiation_SecondLevelMotivation()
	 * @model
	 * @generated
	 */
	EList<SecondLevelMotivation> getSecondLevelMotivation();

	/**
	 * Returns the value of the '<em><b>Variable Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The real variable annotation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variable Annotation</em>' attribute.
	 * @see #setVariableAnnotation(String)
	 * @see it.polito.security.esp.kb.KbPackage#getAppliedProtectionInstantiation_VariableAnnotation()
	 * @model unique="false"
	 * @generated
	 */
	String getVariableAnnotation();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getVariableAnnotation <em>Variable Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Annotation</em>' attribute.
	 * @see #getVariableAnnotation()
	 * @generated
	 */
	void setVariableAnnotation(String value);

	/**
	 * Returns the value of the '<em><b>Code Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The real code annotation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Code Annotation</em>' attribute.
	 * @see #setCodeAnnotation(String)
	 * @see it.polito.security.esp.kb.KbPackage#getAppliedProtectionInstantiation_CodeAnnotation()
	 * @model unique="false"
	 * @generated
	 */
	String getCodeAnnotation();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getCodeAnnotation <em>Code Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code Annotation</em>' attribute.
	 * @see #getCodeAnnotation()
	 * @generated
	 */
	void setCodeAnnotation(String value);

	/**
	 * Returns the value of the '<em><b>Verifier Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The real verifier annotation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Verifier Annotation</em>' attribute.
	 * @see #setVerifierAnnotation(String)
	 * @see it.polito.security.esp.kb.KbPackage#getAppliedProtectionInstantiation_VerifierAnnotation()
	 * @model unique="false"
	 * @generated
	 */
	String getVerifierAnnotation();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getVerifierAnnotation <em>Verifier Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verifier Annotation</em>' attribute.
	 * @see #getVerifierAnnotation()
	 * @generated
	 */
	void setVerifierAnnotation(String value);

	/**
	 * Returns the value of the '<em><b>Attestator Annotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The real attestator annotation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attestator Annotation</em>' attribute.
	 * @see #setAttestatorAnnotation(String)
	 * @see it.polito.security.esp.kb.KbPackage#getAppliedProtectionInstantiation_AttestatorAnnotation()
	 * @model unique="false"
	 * @generated
	 */
	String getAttestatorAnnotation();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getAttestatorAnnotation <em>Attestator Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attestator Annotation</em>' attribute.
	 * @see #getAttestatorAnnotation()
	 * @generated
	 */
	void setAttestatorAnnotation(String value);

	/**
	 * Returns the value of the '<em><b>Tool Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection tool command.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tool Command</em>' attribute.
	 * @see #setToolCommand(String)
	 * @see it.polito.security.esp.kb.KbPackage#getAppliedProtectionInstantiation_ToolCommand()
	 * @model unique="false"
	 * @generated
	 */
	String getToolCommand();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AppliedProtectionInstantiation#getToolCommand <em>Tool Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tool Command</em>' attribute.
	 * @see #getToolCommand()
	 * @generated
	 */
	void setToolCommand(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Translates the object into a string.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 * @generated
	 */
	int hashCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compares another object with the current one.
	 * <!-- end-model-doc -->
	 * @model unique="false" objectUnique="false"
	 * @generated
	 */
	boolean equals(Object object);

} // AppliedProtectionInstantiation

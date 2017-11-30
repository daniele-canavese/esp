/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.common.util.EList;

import it.polito.security.ontologies.annotations.*;

import org.eclipse.emf.ecore.EObject;

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
	}
)
public interface AppliedProtectionInstantiation extends EObject
{
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Translates the object into a string.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.util.HashSet%><<%it.polito.security.esp.kb.ApplicationPart%>> locations = new <%java.util.HashSet%><<%it.polito.security.esp.kb.ApplicationPart%>>();\n<%it.polito.security.esp.kb.ApplicationPart%> _applicationPart = this.getApplicationPart();\nlocations.add(_applicationPart);\n<%it.polito.security.esp.kb.ApplicationPart%> _applicationPart_1 = this.getApplicationPart();\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPartSet%>> _sets = _applicationPart_1.getSets();\nfor (final <%it.polito.security.esp.kb.ApplicationPartSet%> i : _sets)\n{\n\t<%it.polito.security.esp.kb.ProtectionInstantiation%> _protectionInstantiation = this.getProtectionInstantiation();\n\t<%it.polito.security.esp.kb.Protection%> _protection = _protectionInstantiation.getProtection();\n\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ActionType%>> _actions = _protection.getActions();\n\t<%it.polito.security.esp.kb.ActionType%> _action = i.getAction();\n\tboolean _contains = _actions.contains(_action);\n\tif (_contains)\n\t{\n\t\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPart%>> _applicationParts = i.getApplicationParts();\n\t\tlocations.addAll(_applicationParts);\n\t}\n}\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.SecondLevelMotivation%>> _secondLevelMotivation = this.getSecondLevelMotivation();\nint _size = _secondLevelMotivation.size();\nboolean _equals = (_size == 0);\nif (_equals)\n{\n\t<%it.polito.security.esp.kb.ProtectionInstantiation%> _protectionInstantiation_1 = this.getProtectionInstantiation();\n\t<%java.lang.String%> _plus = (_protectionInstantiation_1 + \" @ \");\n\t<%java.lang.String%> _join = <%it.security.polito.esp.util.Strings%>.join(locations, \", \");\n\treturn (_plus + _join);\n}\nelse\n{\n\t<%it.polito.security.esp.kb.ProtectionInstantiation%> _protectionInstantiation_2 = this.getProtectionInstantiation();\n\t<%java.lang.String%> _plus_1 = (_protectionInstantiation_2 + \" @ \");\n\t<%java.lang.String%> _join_1 = <%it.security.polito.esp.util.Strings%>.join(locations, \", \");\n\t<%java.lang.String%> _plus_2 = (_plus_1 + _join_1);\n\t<%java.lang.String%> _plus_3 = (_plus_2 + \" [\");\n\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.SecondLevelMotivation%>> _secondLevelMotivation_1 = this.getSecondLevelMotivation();\n\t<%it.polito.security.esp.kb.SecondLevelMotivation%> _get = _secondLevelMotivation_1.get(0);\n\t<%it.polito.security.esp.kb.SecondLevelMotivationType%> _motivationType = _get.getMotivationType();\n\t<%java.lang.String%> _plus_4 = (_plus_3 + _motivationType);\n\treturn (_plus_4 + \"]\");\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%it.polito.security.esp.kb.ProtectionInstantiation%> _protectionInstantiation = this.getProtectionInstantiation();\nint _hashCode = _protectionInstantiation.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%it.polito.security.esp.kb.ApplicationPart%> _applicationPart = this.getApplicationPart();\nint _hashCode_1 = _applicationPart.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\n<%java.lang.String%> _variableAnnotation = this.getVariableAnnotation();\nint _hashCode_2 = _variableAnnotation.hashCode();\nint _plus_2 = ((31 * result) + _hashCode_2);\nresult = _plus_2;\n<%java.lang.String%> _codeAnnotation = this.getCodeAnnotation();\nint _hashCode_3 = _codeAnnotation.hashCode();\nint _plus_3 = ((31 * result) + _hashCode_3);\nresult = _plus_3;\n<%java.lang.String%> _verifierAnnotation = this.getVerifierAnnotation();\nint _hashCode_4 = _verifierAnnotation.hashCode();\nint _plus_4 = ((31 * result) + _hashCode_4);\nresult = _plus_4;\n<%java.lang.String%> _attestatorAnnotation = this.getAttestatorAnnotation();\nint _hashCode_5 = _attestatorAnnotation.hashCode();\nint _plus_5 = ((31 * result) + _hashCode_5);\nresult = _plus_5;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.AppliedProtectionInstantiation%>))\n\t{\n\t\treturn (<%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(this.getProtectionInstantiation(), ((<%it.polito.security.esp.kb.AppliedProtectionInstantiation%>)object).getProtectionInstantiation()) && \n\t\t\t<%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(this.getApplicationPart(), ((<%it.polito.security.esp.kb.AppliedProtectionInstantiation%>)object).getApplicationPart()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // AppliedProtectionInstantiation

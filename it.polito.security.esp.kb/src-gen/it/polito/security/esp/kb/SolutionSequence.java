/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solution Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A solution sequence.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.SolutionSequence#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getSolutionSequence()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#SolutionSequence",
	name = "http://security.polito.it/esp/kb#solutionSequence",
	objectLists =
	{
		@MapsToObjectList
		(
			id = KbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS,
			startIri = "http://security.polito.it/esp/kb#startsWith",
			nextIri = "http://security.polito.it/esp/kb#isFollowedBy",
			elementIri = "http://security.polito.it/esp/kb#AppliedProtectionInstantiationInSequence",
			elementName = "http://security.polito.it/esp/kb#appliedProtectionInstantiationInSequence",
			propertyIri = "http://security.polito.it/esp/kb#refersTo"
		)
	}
)
public interface SolutionSequence extends EObject
{
	/**
	 * Returns the value of the '<em><b>Applied Protection Instantiations</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AppliedProtectionInstantiation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The applied instantiations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applied Protection Instantiations</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getSolutionSequence_AppliedProtectionInstantiations()
	 * @model
	 * @generated
	 */
	EList<AppliedProtectionInstantiation> getAppliedProtectionInstantiations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Translates the object into a string.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();\nreturn _appliedProtectionInstantiations.toString();'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();\nint _hashCode = _appliedProtectionInstantiations.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.SolutionSequence%>))\n\t{\n\t\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();\n\t\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.AppliedProtectionInstantiation%>> _appliedProtectionInstantiations_1 = ((<%it.polito.security.esp.kb.SolutionSequence%>)object).getAppliedProtectionInstantiations();\n\t\treturn <%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(_appliedProtectionInstantiations, _appliedProtectionInstantiations_1);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // SolutionSequence

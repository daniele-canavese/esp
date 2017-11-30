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
 * A representation of the model object '<em><b>Attack Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An attack step.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.AttackStep#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackStep#getType <em>Type</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackStep#getApplicationParts <em>Application Parts</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getAttackStep()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#AttackStep",
	name = "http://security.polito.it/esp/kb#attackStep",
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.ATTACK_STEP__NAME, iri = "http://security.polito.it/esp/kb#hasName")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.ATTACK_STEP__TYPE, iri = "http://security.polito.it/esp/kb#isTypeOf"),
		@MapsToObjectProperty(id = KbPackage.ATTACK_STEP__APPLICATION_PARTS, iri = "http://security.polito.it/esp/kb#affects")
	}
)
public interface AttackStep extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack step name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackStep_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackStep#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack step type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(AttackStepType)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackStep_Type()
	 * @model unique="false" dataType="it.polito.security.esp.kb.AttackStepTypeWithNull"
	 * @generated
	 */
	AttackStepType getType();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackStep#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(AttackStepType value);

	/**
	 * Returns the value of the '<em><b>Application Parts</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ApplicationPart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The affected application parts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Parts</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackStep_ApplicationParts()
	 * @model
	 * @generated
	 */
	EList<ApplicationPart> getApplicationParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\nint _hashCode = this.getName().hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((object == null))\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof &lt;%it.polito.security.esp.kb.AttackStep%&gt;))\n\t{\n\t\t&lt;%java.lang.String%&gt; _name = this.getName();\n\t\t&lt;%java.lang.String%&gt; _name_1 = ((&lt;%it.polito.security.esp.kb.AttackStep%&gt;)object).getName();\n\t\treturn &lt;%com.google.common.base.Objects%&gt;.equal(_name, _name_1);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Translates the object into a string.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getName();'"
	 * @generated
	 */
	String toString();

} // AttackStep

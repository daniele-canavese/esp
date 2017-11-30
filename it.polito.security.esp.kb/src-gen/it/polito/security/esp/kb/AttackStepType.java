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
 * A representation of the model object '<em><b>Attack Step Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An attack step type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.AttackStepType#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackStepType#getRegex <em>Regex</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackStepType#getAttackerTools <em>Attacker Tools</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackStepType#getProbabilities <em>Probabilities</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getAttackStepType()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#AttackStepType",
	name = "http://security.polito.it/esp/kb#attackStepType",
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.ATTACK_STEP_TYPE__NAME, iri = "http://security.polito.it/esp/kb#hasName"),
		@MapsToDataProperty(id = KbPackage.ATTACK_STEP_TYPE__REGEX, iri = "http://security.polito.it/esp/kb#hasRegex")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.ATTACK_STEP_TYPE__ATTACKER_TOOLS, iri = "http://security.polito.it/esp/kb#uses"),
		@MapsToObjectProperty(id = KbPackage.ATTACK_STEP_TYPE__PROBABILITIES, iri = "http://security.polito.it/esp/kb#hasProbability")
	}
)
public interface AttackStepType extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack step type name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackStepType_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackStepType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack step regex.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Regex</em>' attribute.
	 * @see #setRegex(String)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackStepType_Regex()
	 * @model unique="false"
	 * @generated
	 */
	String getRegex();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackStepType#getRegex <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Regex</em>' attribute.
	 * @see #getRegex()
	 * @generated
	 */
	void setRegex(String value);

	/**
	 * Returns the value of the '<em><b>Attacker Tools</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackerToolType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The tools needed to do the attack step.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attacker Tools</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackStepType_AttackerTools()
	 * @model
	 * @generated
	 */
	EList<AttackerToolType> getAttackerTools();

	/**
	 * Returns the value of the '<em><b>Probabilities</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackStepProbability}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack step probabilities.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Probabilities</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackStepType_Probabilities()
	 * @model
	 * @generated
	 */
	EList<AttackStepProbability> getProbabilities();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%java.lang.String%> _name = this.getName();\nint _hashCode = _name.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.AttackStepType%>))\n\t{\n\t\t<%java.lang.String%> _name = this.getName();\n\t\t<%java.lang.String%> _name_1 = ((<%it.polito.security.esp.kb.AttackStepType%>)object).getName();\n\t\treturn <%com.google.common.base.Objects%>.equal(_name, _name_1);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
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

} // AttackStepType

/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectList;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attack Step Probability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An attack step probability.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.AttackStepProbability#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackStepProbability#getExpertise <em>Expertise</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackStepProbability#getProbability <em>Probability</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getAttackStepProbability()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#AttackStepProbability",
	name = "http://security.polito.it/esp/kb#attackStepProbability",
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.ATTACK_STEP_PROBABILITY__NAME, iri = "http://security.polito.it/esp/kb#hasName")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.ATTACK_STEP_PROBABILITY__EXPERTISE, iri = "http://security.polito.it/esp/kb#hasExpertise"),
		@MapsToObjectProperty(id = KbPackage.ATTACK_STEP_PROBABILITY__PROBABILITY, iri = "http://security.polito.it/esp/kb#hasEfficacy")
	}
)
public interface AttackStepProbability extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The probability name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackStepProbability_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackStepProbability#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Expertise</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.ExpertiseLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attacker expertise level.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expertise</em>' attribute.
	 * @see it.polito.security.esp.kb.ExpertiseLevel
	 * @see #setExpertise(ExpertiseLevel)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackStepProbability_Expertise()
	 * @model unique="false"
	 * @generated
	 */
	ExpertiseLevel getExpertise();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackStepProbability#getExpertise <em>Expertise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expertise</em>' attribute.
	 * @see it.polito.security.esp.kb.ExpertiseLevel
	 * @see #getExpertise()
	 * @generated
	 */
	void setExpertise(ExpertiseLevel value);

	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.Level}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack probability.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #setProbability(Level)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackStepProbability_Probability()
	 * @model unique="false"
	 * @generated
	 */
	Level getProbability();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackStepProbability#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(Level value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%it.polito.security.esp.kb.ExpertiseLevel%> _expertise = this.getExpertise();\nint _hashCode = _expertise.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%it.polito.security.esp.kb.Level%> _probability = this.getProbability();\nint _hashCode_1 = _probability.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.AttackStepProbability%>))\n\t{\n\t\treturn (<%com.google.common.base.Objects%>.equal(this.getExpertise(), ((<%it.polito.security.esp.kb.AttackStepProbability%>)object).getExpertise()) && <%com.google.common.base.Objects%>.equal(this.getProbability(), ((<%it.polito.security.esp.kb.AttackStepProbability%>)object).getProbability()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // AttackStepProbability

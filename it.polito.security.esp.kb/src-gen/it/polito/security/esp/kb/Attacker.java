/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attacker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The attacker.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.Attacker#getExpertise <em>Expertise</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Attacker#getBudgetLimit <em>Budget Limit</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getAttacker()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#Attacker",
	name = "http://security.polito.it/esp/kb#attacker",
	singleton = true,
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.ATTACKER__BUDGET_LIMIT, iri = "http://security.polito.it/esp/kb#hasBudgetLimit")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.ATTACKER__EXPERTISE, iri = "http://security.polito.it/esp/kb#hasExpertise")
	}
)
public interface Attacker extends EObject
{
	/**
	 * Returns the value of the '<em><b>Expertise</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.ExpertiseLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expertise.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expertise</em>' attribute.
	 * @see it.polito.security.esp.kb.ExpertiseLevel
	 * @see #setExpertise(ExpertiseLevel)
	 * @see it.polito.security.esp.kb.KbPackage#getAttacker_Expertise()
	 * @model unique="false"
	 * @generated
	 */
	ExpertiseLevel getExpertise();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Attacker#getExpertise <em>Expertise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expertise</em>' attribute.
	 * @see it.polito.security.esp.kb.ExpertiseLevel
	 * @see #getExpertise()
	 * @generated
	 */
	void setExpertise(ExpertiseLevel value);

	/**
	 * Returns the value of the '<em><b>Budget Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attacker budget limit or a negative value if unlimited.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Budget Limit</em>' attribute.
	 * @see #setBudgetLimit(Integer)
	 * @see it.polito.security.esp.kb.KbPackage#getAttacker_BudgetLimit()
	 * @model unique="false" dataType="it.polito.security.esp.kb.Integer"
	 * @generated
	 */
	Integer getBudgetLimit();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Attacker#getBudgetLimit <em>Budget Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Budget Limit</em>' attribute.
	 * @see #getBudgetLimit()
	 * @generated
	 */
	void setBudgetLimit(Integer value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\nint _hashCode = \"attacker\".hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.Attacker%>))\n\t{\n\t\treturn (<%com.google.common.base.Objects%>.equal(this.getExpertise(), ((<%it.polito.security.esp.kb.Attacker%>)object).getExpertise()) && <%com.google.common.base.Objects%>.equal(this.getBudgetLimit(), ((<%it.polito.security.esp.kb.Attacker%>)object).getBudgetLimit()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // Attacker

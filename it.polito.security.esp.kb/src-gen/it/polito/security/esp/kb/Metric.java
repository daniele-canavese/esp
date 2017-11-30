/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.ecore.EObject;

import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToDataProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A metric.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.Metric#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Metric#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getMetric()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#Metric",
	name = "http://security.polito.it/esp/kb#metric",
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.METRIC__NAME, iri = "http://security.polito.it/esp/kb#hasName"),
		@MapsToDataProperty(id = KbPackage.METRIC__VALUE, iri = "http://security.polito.it/esp/kb#hasValue")
	}
)
public interface Metric extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The metric name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see it.polito.security.esp.kb.KbPackage#getMetric_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Metric#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The metric value.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Double)
	 * @see it.polito.security.esp.kb.KbPackage#getMetric_Value()
	 * @model unique="false"
	 * @generated
	 */
	Double getValue();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Metric#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%java.lang.String%> _name = this.getName();\nint _hashCode = _name.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%java.lang.Double%> _value = this.getValue();\nint _hashCode_1 = _value.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nreturn result;'"
	 * @generated
	 */
	int hashCode();

} // Metric

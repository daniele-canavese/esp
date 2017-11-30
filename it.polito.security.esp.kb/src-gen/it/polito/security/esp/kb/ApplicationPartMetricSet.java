/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Part Metric Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A list of metrics for an application part.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.ApplicationPartMetricSet#getApplicationPart <em>Application Part</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.ApplicationPartMetricSet#getMetrics <em>Metrics</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getApplicationPartMetricSet()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#ApplicationPartMetric",
	name = "http://security.polito.it/esp/kb#applicationPartMetric",
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.APPLICATION_PART_METRIC_SET__APPLICATION_PART, iri = "http://security.polito.it/esp/kb#refersTo"),
		@MapsToObjectProperty(id = KbPackage.APPLICATION_PART_METRIC_SET__METRICS, iri = "http://security.polito.it/esp/kb#contains")
	}
)
public interface ApplicationPartMetricSet extends EObject
{
	/**
	 * Returns the value of the '<em><b>Application Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application part.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Part</em>' reference.
	 * @see #setApplicationPart(ApplicationPart)
	 * @see it.polito.security.esp.kb.KbPackage#getApplicationPartMetricSet_ApplicationPart()
	 * @model
	 * @generated
	 */
	ApplicationPart getApplicationPart();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.ApplicationPartMetricSet#getApplicationPart <em>Application Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application Part</em>' reference.
	 * @see #getApplicationPart()
	 * @generated
	 */
	void setApplicationPart(ApplicationPart value);

	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The metrics.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getApplicationPartMetricSet_Metrics()
	 * @model
	 * @generated
	 */
	EList<Metric> getMetrics();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%it.polito.security.esp.kb.ApplicationPart%> _applicationPart = this.getApplicationPart();\nint _hashCode = _applicationPart.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.Metric%>> _metrics = this.getMetrics();\nint _hashCode_1 = _metrics.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nreturn result;'"
	 * @generated
	 */
	int hashCode();

} // ApplicationPartMetricSet

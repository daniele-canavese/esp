/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.common.util.EList;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;
import it.polito.security.ontologies.annotations.MapsToObjectList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A solution.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.Solution#getSolutionSequences <em>Solution Sequences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getAttackPaths <em>Attack Paths</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getApplicationMetrics <em>Application Metrics</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getApplicationPartMetricSets <em>Application Part Metric Sets</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getFirstLevelSolution <em>First Level Solution</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getL1pScore <em>L1p Score</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getL1pTime <em>L1p Time</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getL2pScore <em>L2p Score</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getL2pTime <em>L2p Time</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getClientTimeOverhead <em>Client Time Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getServerTimeOverhead <em>Server Time Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getClientMemoryOverhead <em>Client Memory Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getServerMemoryOverhead <em>Server Memory Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getNetworkOverhead <em>Network Overhead</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Solution#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getSolution()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#Solution",
	name = "http://security.polito.it/esp/kb#solution",
	dataProperties =
	{
			@MapsToDataProperty(id = KbPackage.SOLUTION__L1P_SCORE, iri = "http://security.polito.it/esp/kb#hasL1PScore"),
			@MapsToDataProperty(id = KbPackage.SOLUTION__L1P_TIME, iri = "http://security.polito.it/esp/kb#hasL1PTime"),
			@MapsToDataProperty(id = KbPackage.SOLUTION__L2P_SCORE, iri = "http://security.polito.it/esp/kb#hasL2PScore"),
			@MapsToDataProperty(id = KbPackage.SOLUTION__L2P_TIME, iri = "http://security.polito.it/esp/kb#hasL2PTime"),
			@MapsToDataProperty(id = KbPackage.SOLUTION__CLIENT_TIME_OVERHEAD, iri = "http://security.polito.it/esp/kb#hasClientTimeOverhead"),
			@MapsToDataProperty(id = KbPackage.SOLUTION__SERVER_TIME_OVERHEAD, iri = "http://security.polito.it/esp/kb#hasServerTimeOverhead"),
			@MapsToDataProperty(id = KbPackage.SOLUTION__CLIENT_MEMORY_OVERHEAD, iri = "http://security.polito.it/esp/kb#hasClientMemoryOverhead"),
			@MapsToDataProperty(id = KbPackage.SOLUTION__SERVER_MEMORY_OVERHEAD, iri = "http://security.polito.it/esp/kb#hasServerMemoryOverhead"),
			@MapsToDataProperty(id = KbPackage.SOLUTION__NETWORK_OVERHEAD, iri = "http://security.polito.it/esp/kb#hasNetworkOverhead")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.SOLUTION__SOLUTION_SEQUENCES, iri = "http://security.polito.it/esp/kb#contains"),
		@MapsToObjectProperty(id = KbPackage.SOLUTION__APPLICATION_METRICS, iri = "http://security.polito.it/esp/kb#hasApplicationMetrics"),
		@MapsToObjectProperty(id = KbPackage.SOLUTION__APPLICATION_PART_METRIC_SETS, iri = "http://security.polito.it/esp/kb#hasApplicationPartMetrics"),
		@MapsToObjectProperty(id = KbPackage.SOLUTION__FIRST_LEVEL_SOLUTION, iri = "http://security.polito.it/esp/kb#refersTo")
	},
	objectLists =
	{
		@MapsToObjectList
		(
			id = KbPackage.SOLUTION__ATTACK_PATHS,
			startIri = "http://security.polito.it/esp/kb#startsWith",
			nextIri = "http://security.polito.it/esp/kb#isFollowedBy",
			elementIri = "http://security.polito.it/esp/kb#AttackPathInSequence",
			elementName = "http://security.polito.it/esp/kb#attackPathInSequence",
			propertyIri = "http://security.polito.it/esp/kb#refersTo"
		)
	}
)
public interface Solution extends EObject
{
	/**
	 * Returns the value of the '<em><b>Solution Sequences</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.SolutionSequence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The solution sequences.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Solution Sequences</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_SolutionSequences()
	 * @model
	 * @generated
	 */
	EList<SolutionSequence> getSolutionSequences();

	/**
	 * Returns the value of the '<em><b>Attack Paths</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackPath}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack paths.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Paths</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_AttackPaths()
	 * @model
	 * @generated
	 */
	EList<AttackPath> getAttackPaths();

	/**
	 * Returns the value of the '<em><b>Application Metrics</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application metrics.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Metrics</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_ApplicationMetrics()
	 * @model
	 * @generated
	 */
	EList<Metric> getApplicationMetrics();

	/**
	 * Returns the value of the '<em><b>Application Part Metric Sets</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ApplicationPartMetricSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application part metrics.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Part Metric Sets</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_ApplicationPartMetricSets()
	 * @model
	 * @generated
	 */
	EList<ApplicationPartMetricSet> getApplicationPartMetricSets();

	/**
	 * Returns the value of the '<em><b>First Level Solution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this solution is a second level one, the first level solution on which this is built.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>First Level Solution</em>' reference.
	 * @see #setFirstLevelSolution(Solution)
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_FirstLevelSolution()
	 * @model
	 * @generated
	 */
	Solution getFirstLevelSolution();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Solution#getFirstLevelSolution <em>First Level Solution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Level Solution</em>' reference.
	 * @see #getFirstLevelSolution()
	 * @generated
	 */
	void setFirstLevelSolution(Solution value);

	/**
	 * Returns the value of the '<em><b>L1p Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The L1P score.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Score</em>' attribute.
	 * @see #setL1pScore(double)
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_L1pScore()
	 * @model unique="false"
	 * @generated
	 */
	double getL1pScore();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Solution#getL1pScore <em>L1p Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Score</em>' attribute.
	 * @see #getL1pScore()
	 * @generated
	 */
	void setL1pScore(double value);

	/**
	 * Returns the value of the '<em><b>L1p Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The L1P computation time.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L1p Time</em>' attribute.
	 * @see #setL1pTime(double)
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_L1pTime()
	 * @model unique="false"
	 * @generated
	 */
	double getL1pTime();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Solution#getL1pTime <em>L1p Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L1p Time</em>' attribute.
	 * @see #getL1pTime()
	 * @generated
	 */
	void setL1pTime(double value);

	/**
	 * Returns the value of the '<em><b>L2p Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The L2P score.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Score</em>' attribute.
	 * @see #setL2pScore(double)
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_L2pScore()
	 * @model unique="false"
	 * @generated
	 */
	double getL2pScore();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Solution#getL2pScore <em>L2p Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Score</em>' attribute.
	 * @see #getL2pScore()
	 * @generated
	 */
	void setL2pScore(double value);

	/**
	 * Returns the value of the '<em><b>L2p Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The L2P computation time.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>L2p Time</em>' attribute.
	 * @see #setL2pTime(double)
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_L2pTime()
	 * @model unique="false"
	 * @generated
	 */
	double getL2pTime();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Solution#getL2pTime <em>L2p Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>L2p Time</em>' attribute.
	 * @see #getL2pTime()
	 * @generated
	 */
	void setL2pTime(double value);

	/**
	 * Returns the value of the '<em><b>Client Time Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The client time overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Client Time Overhead</em>' attribute.
	 * @see #setClientTimeOverhead(double)
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_ClientTimeOverhead()
	 * @model unique="false"
	 * @generated
	 */
	double getClientTimeOverhead();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Solution#getClientTimeOverhead <em>Client Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Time Overhead</em>' attribute.
	 * @see #getClientTimeOverhead()
	 * @generated
	 */
	void setClientTimeOverhead(double value);

	/**
	 * Returns the value of the '<em><b>Server Time Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The server time overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Server Time Overhead</em>' attribute.
	 * @see #setServerTimeOverhead(double)
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_ServerTimeOverhead()
	 * @model unique="false"
	 * @generated
	 */
	double getServerTimeOverhead();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Solution#getServerTimeOverhead <em>Server Time Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Time Overhead</em>' attribute.
	 * @see #getServerTimeOverhead()
	 * @generated
	 */
	void setServerTimeOverhead(double value);

	/**
	 * Returns the value of the '<em><b>Client Memory Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The client memory overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Client Memory Overhead</em>' attribute.
	 * @see #setClientMemoryOverhead(double)
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_ClientMemoryOverhead()
	 * @model unique="false"
	 * @generated
	 */
	double getClientMemoryOverhead();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Solution#getClientMemoryOverhead <em>Client Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Client Memory Overhead</em>' attribute.
	 * @see #getClientMemoryOverhead()
	 * @generated
	 */
	void setClientMemoryOverhead(double value);

	/**
	 * Returns the value of the '<em><b>Server Memory Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The server memory overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Server Memory Overhead</em>' attribute.
	 * @see #setServerMemoryOverhead(double)
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_ServerMemoryOverhead()
	 * @model unique="false"
	 * @generated
	 */
	double getServerMemoryOverhead();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Solution#getServerMemoryOverhead <em>Server Memory Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Memory Overhead</em>' attribute.
	 * @see #getServerMemoryOverhead()
	 * @generated
	 */
	void setServerMemoryOverhead(double value);

	/**
	 * Returns the value of the '<em><b>Network Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The network overhead.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Network Overhead</em>' attribute.
	 * @see #setNetworkOverhead(double)
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_NetworkOverhead()
	 * @model unique="false"
	 * @generated
	 */
	double getNetworkOverhead();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Solution#getNetworkOverhead <em>Network Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Network Overhead</em>' attribute.
	 * @see #getNetworkOverhead()
	 * @generated
	 */
	void setNetworkOverhead(double value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The object id.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getSolution_Id()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='int _hashCode = this.hashCode();\nlong h = (((long) _hashCode) + (-((long) <%java.lang.Integer%>.MIN_VALUE)));\n<%it.polito.security.esp.kb.Solution%> _firstLevelSolution = this.getFirstLevelSolution();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_firstLevelSolution, null);\nif (_equals)\n{\n\treturn <%java.lang.Long%>.valueOf(h).toString();\n}\nelse\n{\n\t<%java.lang.String%> _string = <%java.lang.Long%>.valueOf(h).toString();\n\t<%java.lang.String%> _plus = (_string + \" (\");\n\t<%it.polito.security.esp.kb.Solution%> _firstLevelSolution_1 = this.getFirstLevelSolution();\n\t<%java.lang.String%> _id = _firstLevelSolution_1.getId();\n\t<%java.lang.String%> _string_1 = _id.toString();\n\t<%java.lang.String%> _plus_1 = (_plus + _string_1);\n\treturn (_plus_1 + \")\");\n}'"
	 * @generated
	 */
	String getId();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Translates the object into a string.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.SolutionSequence%>> _solutionSequences = this.getSolutionSequences();\nreturn _solutionSequences.toString();'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\nint r = 0;\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.SolutionSequence%>> _solutionSequences = this.getSolutionSequences();\nfor (final <%it.polito.security.esp.kb.SolutionSequence%> i : _solutionSequences)\n{\n\tint _r = r;\n\tint _hashCode = i.hashCode();\n\tr = (_r + _hashCode);\n}\nresult = ((31 * result) + r);\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.Solution%>))\n\t{\n\t\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.SolutionSequence%>> _solutionSequences = this.getSolutionSequences();\n\t\t<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.SolutionSequence%>> _solutionSequences_1 = ((<%it.polito.security.esp.kb.Solution%>)object).getSolutionSequences();\n\t\treturn <%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(_solutionSequences, _solutionSequences_1);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // Solution

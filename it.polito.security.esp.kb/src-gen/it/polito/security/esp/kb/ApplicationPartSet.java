/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application Part Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An application part set.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.ApplicationPartSet#getApplicationParts <em>Application Parts</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.ApplicationPartSet#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getApplicationPartSet()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#ApplicationPartSet",
	name = "http://security.polito.it/esp/kb#applicationPartSet",
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.APPLICATION_PART_SET__APPLICATION_PARTS, iri = "http://security.polito.it/esp/kb#contains"),
		@MapsToObjectProperty(id = KbPackage.APPLICATION_PART_SET__ACTION, iri = "http://security.polito.it/esp/kb#hasAction")
	}
)
public interface ApplicationPartSet extends EObject
{
	/**
	 * Returns the value of the '<em><b>Application Parts</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ApplicationPart}.
	 * It is bidirectional and its opposite is '{@link it.polito.security.esp.kb.ApplicationPart#getSets <em>Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application parts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Parts</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getApplicationPartSet_ApplicationParts()
	 * @see it.polito.security.esp.kb.ApplicationPart#getSets
	 * @model opposite="sets"
	 * @generated
	 */
	EList<ApplicationPart> getApplicationParts();

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.ActionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The action.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see it.polito.security.esp.kb.ActionType
	 * @see #setAction(ActionType)
	 * @see it.polito.security.esp.kb.KbPackage#getApplicationPartSet_Action()
	 * @model unique="false"
	 * @generated
	 */
	ActionType getAction();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.ApplicationPartSet#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see it.polito.security.esp.kb.ActionType
	 * @see #getAction()
	 * @generated
	 */
	void setAction(ActionType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%it.polito.security.esp.kb.ActionType%> _action = this.getAction();\nint _hashCode = _action.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPart%>> _applicationParts = this.getApplicationParts();\nint _hashCode_1 = _applicationParts.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.ApplicationPartSet%>))\n\t{\n\t\treturn (<%com.google.common.base.Objects%>.equal(this.getAction(), ((<%it.polito.security.esp.kb.ApplicationPartSet%>)object).getAction()) && <%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(this.getApplicationParts(), ((<%it.polito.security.esp.kb.ApplicationPartSet%>)object).getApplicationParts()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // ApplicationPartSet

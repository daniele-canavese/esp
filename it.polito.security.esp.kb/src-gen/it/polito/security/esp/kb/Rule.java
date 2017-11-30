/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;
import it.polito.security.ontologies.annotations.MapsToDataProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A rule.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.Rule#getAction <em>Action</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Rule#getFunctionDeclarations <em>Function Declarations</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getRule()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#Rule",
	name = "http://security.polito.it/esp/kb#rule",
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.RULE__ACTION, iri = "http://security.polito.it/esp/kb#hasAction"),
		@MapsToObjectProperty(id = KbPackage.RULE__FUNCTION_DECLARATIONS, iri = "http://security.polito.it/esp/kb#contains")
	}
)
public interface Rule extends EObject
{
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
	 * @see it.polito.security.esp.kb.KbPackage#getRule_Action()
	 * @model unique="false"
	 * @generated
	 */
	ActionType getAction();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Rule#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see it.polito.security.esp.kb.ActionType
	 * @see #getAction()
	 * @generated
	 */
	void setAction(ActionType value);

	/**
	 * Returns the value of the '<em><b>Function Declarations</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.FunctionDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The function declarations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function Declarations</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getRule_FunctionDeclarations()
	 * @model
	 * @generated
	 */
	EList<FunctionDeclaration> getFunctionDeclarations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compares another object with the current one.
	 * <!-- end-model-doc -->
	 * @model unique="false" objectUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.Rule%>))\n\t{\n\t\treturn (<%com.google.common.base.Objects%>.equal(this.getAction(), ((<%it.polito.security.esp.kb.Rule%>)object).getAction()) && <%com.google.common.base.Objects%>.equal(this.getFunctionDeclarations(), ((<%it.polito.security.esp.kb.Rule%>)object).getFunctionDeclarations()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%it.polito.security.esp.kb.ActionType%> _action = this.getAction();\nint _hashCode = _action.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.FunctionDeclaration%>> _functionDeclarations = this.getFunctionDeclarations();\nint _hashCode_1 = _functionDeclarations.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nreturn result;'"
	 * @generated
	 */
	int hashCode();

} // Rule

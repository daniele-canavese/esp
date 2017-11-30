/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectList;
import it.polito.security.ontologies.annotations.MapsToDataProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A function declaration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.FunctionDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.FunctionDeclaration#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getFunctionDeclaration()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#FunctionDeclaration",
	name = "http://security.polito.it/esp/kb#functionDeclaration",
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.FUNCTION_DECLARATION__NAME, iri = "http://security.polito.it/esp/kb#hasName")
	},
	objectLists =
	{
		@MapsToObjectList
		(
			id = KbPackage.FUNCTION_DECLARATION__PARAMETERS,
			startIri = "http://security.polito.it/esp/kb#startsWith",
			nextIri = "http://security.polito.it/esp/kb#isFollowedBy",
			elementIri = "http://security.polito.it/esp/kb#FunctionParameter",
			elementName = "http://security.polito.it/esp/kb#functionParameter",
			propertyIri = "http://security.polito.it/esp/kb#refersTo"
		)
	}
)
public interface FunctionDeclaration extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The function name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see it.polito.security.esp.kb.KbPackage#getFunctionDeclaration_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.FunctionDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' attribute list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ApplicationPartType}.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.ApplicationPartType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The function parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters</em>' attribute list.
	 * @see it.polito.security.esp.kb.ApplicationPartType
	 * @see it.polito.security.esp.kb.KbPackage#getFunctionDeclaration_Parameters()
	 * @model unique="false"
	 * @generated
	 */
	EList<ApplicationPartType> getParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Compares another object with the current one.
	 * <!-- end-model-doc -->
	 * @model unique="false" objectUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.FunctionDeclaration%>))\n\t{\n\t\treturn (<%com.google.common.base.Objects%>.equal(this.getName(), ((<%it.polito.security.esp.kb.FunctionDeclaration%>)object).getName()) && <%com.google.common.base.Objects%>.equal(this.getParameters(), ((<%it.polito.security.esp.kb.FunctionDeclaration%>)object).getParameters()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%java.lang.String%> _name = this.getName();\nint _hashCode = _name.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPartType%>> _parameters = this.getParameters();\nint _hashCode_1 = _parameters.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nreturn result;'"
	 * @generated
	 */
	int hashCode();

} // FunctionDeclaration

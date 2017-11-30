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
 * A representation of the model object '<em><b>Use Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A use target.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.UseTarget#getTarget <em>Target</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.UseTarget#getUsedBy <em>Used By</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.UseTarget#getLine <em>Line</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.UseTarget#getSourceFilePath <em>Source File Path</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.UseTarget#getType <em>Type</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.UseTarget#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getUseTarget()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#UseTarget",
	name = "http://security.polito.it/esp/kb#useTarget",
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.USE_TARGET__LINE, iri = "http://security.polito.it/esp/kb#hasLine"),
		@MapsToDataProperty(id = KbPackage.USE_TARGET__SOURCE_FILE_PATH, iri = "http://security.polito.it/esp/kb#hasSourceFilePath")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.USE_TARGET__TARGET, iri = "http://security.polito.it/esp/kb#hasTarget"),
		@MapsToObjectProperty(id = KbPackage.USE_TARGET__TYPE, iri = "http://security.polito.it/esp/kb#isTypeOf")
	},
	objectLists =
	{
		@MapsToObjectList
		(
			id = KbPackage.USE_TARGET__PARAMETERS,
			startIri = "http://security.polito.it/esp/kb#startsWith",
			nextIri = "http://security.polito.it/esp/kb#isFollowedBy",
			elementIri = "http://security.polito.it/esp/kb#CallParameter",
			elementName = "http://security.polito.it/esp/kb#callParameter",
			propertyIri = "http://security.polito.it/esp/kb#refersTo"
		)
	}
)
public interface UseTarget extends EObject
{
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link it.polito.security.esp.kb.ApplicationPart#getTargetOf <em>Target Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The target application part.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ApplicationPart)
	 * @see it.polito.security.esp.kb.KbPackage#getUseTarget_Target()
	 * @see it.polito.security.esp.kb.ApplicationPart#getTargetOf
	 * @model opposite="targetOf"
	 * @generated
	 */
	ApplicationPart getTarget();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.UseTarget#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ApplicationPart value);

	/**
	 * Returns the value of the '<em><b>Used By</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link it.polito.security.esp.kb.ApplicationPart#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The application parts using this target.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Used By</em>' container reference.
	 * @see #setUsedBy(ApplicationPart)
	 * @see it.polito.security.esp.kb.KbPackage#getUseTarget_UsedBy()
	 * @see it.polito.security.esp.kb.ApplicationPart#getUses
	 * @model opposite="uses" transient="false"
	 * @generated
	 */
	ApplicationPart getUsedBy();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.UseTarget#getUsedBy <em>Used By</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used By</em>' container reference.
	 * @see #getUsedBy()
	 * @generated
	 */
	void setUsedBy(ApplicationPart value);

	/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The line of code where this uses is located.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(int)
	 * @see it.polito.security.esp.kb.KbPackage#getUseTarget_Line()
	 * @model unique="false"
	 * @generated
	 */
	int getLine();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.UseTarget#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(int value);

	/**
	 * Returns the value of the '<em><b>Source File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source file in which the uses is located.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source File Path</em>' attribute.
	 * @see #setSourceFilePath(String)
	 * @see it.polito.security.esp.kb.KbPackage#getUseTarget_SourceFilePath()
	 * @model unique="false"
	 * @generated
	 */
	String getSourceFilePath();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.UseTarget#getSourceFilePath <em>Source File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source File Path</em>' attribute.
	 * @see #getSourceFilePath()
	 * @generated
	 */
	void setSourceFilePath(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.UseType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The use type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see it.polito.security.esp.kb.UseType
	 * @see #setType(UseType)
	 * @see it.polito.security.esp.kb.KbPackage#getUseTarget_Type()
	 * @model unique="false"
	 * @generated
	 */
	UseType getType();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.UseTarget#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see it.polito.security.esp.kb.UseType
	 * @see #getType()
	 * @generated
	 */
	void setType(UseType value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ApplicationPart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The parameter list, if this is a call.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getUseTarget_Parameters()
	 * @model
	 * @generated
	 */
	EList<ApplicationPart> getParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%java.lang.String%> _sourceFilePath = this.getSourceFilePath();\nint _hashCode = _sourceFilePath.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nint _line = this.getLine();\n<%java.lang.String%> _string = <%java.lang.Integer%>.valueOf(_line).toString();\nint _hashCode_1 = _string.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\n<%it.polito.security.esp.kb.UseType%> _type = this.getType();\n<%java.lang.String%> _string_1 = _type.toString();\nint _hashCode_2 = _string_1.hashCode();\nint _plus_2 = ((31 * result) + _hashCode_2);\nresult = _plus_2;\n<%it.polito.security.esp.kb.ApplicationPart%> _target = this.getTarget();\nint _hashCode_3 = _target.hashCode();\nint _plus_3 = ((31 * result) + _hashCode_3);\nresult = _plus_3;\n<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ApplicationPart%>> _parameters = this.getParameters();\nint _hashCode_4 = _parameters.hashCode();\nint _plus_4 = ((31 * result) + _hashCode_4);\nresult = _plus_4;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.UseTarget%>))\n\t{\n\t\treturn ((((<%com.google.common.base.Objects%>.equal(this.getSourceFilePath(), ((<%it.polito.security.esp.kb.UseTarget%>)object).getSourceFilePath()) && (this.getLine() == ((<%it.polito.security.esp.kb.UseTarget%>)object).getLine())) && <%com.google.common.base.Objects%>.equal(this.getType(), ((<%it.polito.security.esp.kb.UseTarget%>)object).getType())) && \n\t\t\t<%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(this.getTarget(), ((<%it.polito.security.esp.kb.UseTarget%>)object).getTarget())) && <%org.eclipse.emf.ecore.util.EcoreUtil%>.equals(this.getParameters(), ((<%it.polito.security.esp.kb.UseTarget%>)object).getParameters()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%it.polito.security.esp.kb.ApplicationPart%> _usedBy = this.getUsedBy();\n<%java.lang.String%> _plus = (_usedBy + \" \");\n<%it.polito.security.esp.kb.UseType%> _type = this.getType();\n<%java.lang.String%> _plus_1 = (_plus + _type);\n<%java.lang.String%> _plus_2 = (_plus_1 + \" \");\n<%it.polito.security.esp.kb.ApplicationPart%> _target = this.getTarget();\n<%java.lang.String%> _plus_3 = (_plus_2 + _target);\n<%java.lang.String%> _plus_4 = (_plus_3 + \" @ \");\nint _line = this.getLine();\nreturn (_plus_4 + <%java.lang.Integer%>.valueOf(_line));'"
	 * @generated
	 */
	String toString();

} // UseTarget

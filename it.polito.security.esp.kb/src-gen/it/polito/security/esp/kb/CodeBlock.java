/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;
import it.polito.security.ontologies.annotations.MapsToIndividual;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A code block.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.CodeBlock#getType <em>Type</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.CodeBlock#getCodeBlocks <em>Code Blocks</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.CodeBlock#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.CodeBlock#getEndLine <em>End Line</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.CodeBlock#getSourceFilePath <em>Source File Path</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getCodeBlock()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#CodeBlock",
	name = "http://security.polito.it/esp/kb#codeBlock",
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.CODE_BLOCK__START_LINE, iri = "http://security.polito.it/esp/kb#hasStartLine"),
		@MapsToDataProperty(id = KbPackage.CODE_BLOCK__END_LINE, iri = "http://security.polito.it/esp/kb#hasEndLine"),
		@MapsToDataProperty(id = KbPackage.CODE_BLOCK__SOURCE_FILE_PATH, iri = "http://security.polito.it/esp/kb#hasSourceFilePath")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.CODE_BLOCK__TYPE, iri = "http://security.polito.it/esp/kb#isTypeOf"),
		@MapsToObjectProperty(id = KbPackage.CODE_BLOCK__CODE_BLOCKS, iri = "http://security.polito.it/esp/kb#contains")
	}
)
public interface CodeBlock extends EObject
{
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.CodeBlockType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The block type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see it.polito.security.esp.kb.CodeBlockType
	 * @see #setType(CodeBlockType)
	 * @see it.polito.security.esp.kb.KbPackage#getCodeBlock_Type()
	 * @model unique="false"
	 * @generated
	 */
	CodeBlockType getType();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.CodeBlock#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see it.polito.security.esp.kb.CodeBlockType
	 * @see #getType()
	 * @generated
	 */
	void setType(CodeBlockType value);

	/**
	 * Returns the value of the '<em><b>Code Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.CodeBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The contained blocks.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Code Blocks</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getCodeBlock_CodeBlocks()
	 * @model containment="true"
	 * @generated
	 */
	EList<CodeBlock> getCodeBlocks();

	/**
	 * Returns the value of the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source file line where this block starts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start Line</em>' attribute.
	 * @see #setStartLine(int)
	 * @see it.polito.security.esp.kb.KbPackage#getCodeBlock_StartLine()
	 * @model unique="false"
	 * @generated
	 */
	int getStartLine();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.CodeBlock#getStartLine <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Line</em>' attribute.
	 * @see #getStartLine()
	 * @generated
	 */
	void setStartLine(int value);

	/**
	 * Returns the value of the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source file line where this block starts.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End Line</em>' attribute.
	 * @see #setEndLine(int)
	 * @see it.polito.security.esp.kb.KbPackage#getCodeBlock_EndLine()
	 * @model unique="false"
	 * @generated
	 */
	int getEndLine();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.CodeBlock#getEndLine <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Line</em>' attribute.
	 * @see #getEndLine()
	 * @generated
	 */
	void setEndLine(int value);

	/**
	 * Returns the value of the '<em><b>Source File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source file in which the uses is located.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source File Path</em>' attribute.
	 * @see #setSourceFilePath(String)
	 * @see it.polito.security.esp.kb.KbPackage#getCodeBlock_SourceFilePath()
	 * @model unique="false"
	 * @generated
	 */
	String getSourceFilePath();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.CodeBlock#getSourceFilePath <em>Source File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source File Path</em>' attribute.
	 * @see #getSourceFilePath()
	 * @generated
	 */
	void setSourceFilePath(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%it.polito.security.esp.kb.CodeBlockType%> _type = this.getType();\n<%java.lang.String%> _string = _type.toString();\nint _hashCode = _string.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%java.lang.String%> _sourceFilePath = this.getSourceFilePath();\nint _hashCode_1 = _sourceFilePath.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\nint _startLine = this.getStartLine();\n<%java.lang.String%> _string_1 = <%java.lang.Integer%>.valueOf(_startLine).toString();\nint _hashCode_2 = _string_1.hashCode();\nint _plus_2 = ((31 * result) + _hashCode_2);\nresult = _plus_2;\nint _endLine = this.getEndLine();\n<%java.lang.String%> _string_2 = <%java.lang.Integer%>.valueOf(_endLine).toString();\nint _hashCode_3 = _string_2.hashCode();\nint _plus_3 = ((31 * result) + _hashCode_3);\nresult = _plus_3;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.CodeBlock%>))\n\t{\n\t\treturn (((<%com.google.common.base.Objects%>.equal(this.getType(), ((<%it.polito.security.esp.kb.CodeBlock%>)object).getType()) && <%com.google.common.base.Objects%>.equal(this.getSourceFilePath(), ((<%it.polito.security.esp.kb.CodeBlock%>)object).getSourceFilePath())) && (this.getStartLine() == ((<%it.polito.security.esp.kb.CodeBlock%>)object).getStartLine())) && \n\t\t\t(this.getEndLine() == ((<%it.polito.security.esp.kb.CodeBlock%>)object).getEndLine()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%it.polito.security.esp.kb.CodeBlockType%> _type = this.getType();\n<%java.lang.String%> _plus = (_type + \" from \");\nint _startLine = this.getStartLine();\n<%java.lang.String%> _plus_1 = (_plus + <%java.lang.Integer%>.valueOf(_startLine));\n<%java.lang.String%> _plus_2 = (_plus_1 + \" to \");\nint _endLine = this.getEndLine();\nreturn (_plus_2 + <%java.lang.Integer%>.valueOf(_endLine));'"
	 * @generated
	 */
	String toString();

} // CodeBlock

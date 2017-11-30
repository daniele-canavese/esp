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
 * A representation of the model object '<em><b>Attack Mitigation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A protection mitigation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.AttackMitigation#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackMitigation#getLevel <em>Level</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackMitigation#getType <em>Type</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackMitigation#getAttackPaths <em>Attack Paths</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackMitigation#getProtection <em>Protection</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getAttackMitigation()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#AttackMitigation",
	name = "http://security.polito.it/esp/kb#attackMitigation",
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.ATTACK_MITIGATION__LEVEL, iri = "http://security.polito.it/esp/kb#hasEfficacy"),
		@MapsToObjectProperty(id = KbPackage.ATTACK_MITIGATION__TYPE, iri = "http://security.polito.it/esp/kb#refersTo"),
		@MapsToObjectProperty(id = KbPackage.ATTACK_MITIGATION__ATTACK_PATHS, iri = "http://security.polito.it/esp/kb#mitigates")
	},
	dataProperties = 
	{
		@MapsToDataProperty(id = KbPackage.ATTACK_MITIGATION__NAME, iri = "http://security.polito.it/esp/kb#hasName"),
	}
)
public interface AttackMitigation extends EObject
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The mitigation name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackMitigation_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackMitigation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.Level}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The mitigation level.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #setLevel(Level)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackMitigation_Level()
	 * @model unique="false"
	 * @generated
	 */
	Level getLevel();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackMitigation#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(Level value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(AttackStepType)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackMitigation_Type()
	 * @model
	 * @generated
	 */
	AttackStepType getType();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackMitigation#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(AttackStepType value);

	/**
	 * Returns the value of the '<em><b>Attack Paths</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackPath}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attack paths.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attack Paths</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackMitigation_AttackPaths()
	 * @model
	 * @generated
	 */
	EList<AttackPath> getAttackPaths();

	/**
	 * Returns the value of the '<em><b>Protection</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link it.polito.security.esp.kb.Protection#getMitigations <em>Mitigations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Protection</em>' container reference.
	 * @see #setProtection(Protection)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackMitigation_Protection()
	 * @see it.polito.security.esp.kb.Protection#getMitigations
	 * @model opposite="mitigations" transient="false"
	 * @generated
	 */
	Protection getProtection();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackMitigation#getProtection <em>Protection</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protection</em>' container reference.
	 * @see #getProtection()
	 * @generated
	 */
	void setProtection(Protection value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%it.polito.security.esp.kb.Level%> _level = this.getLevel();\nint _hashCode = _level.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\n<%it.polito.security.esp.kb.AttackStepType%> _type = this.getType();\nint _hashCode_1 = _type.hashCode();\nint _plus_1 = ((31 * result) + _hashCode_1);\nresult = _plus_1;\n<%java.lang.String%> _name = this.getName();\nint _hashCode_2 = _name.hashCode();\nint _plus_2 = ((31 * result) + _hashCode_2);\nresult = _plus_2;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.AttackMitigation%>))\n\t{\n\t\treturn ((<%com.google.common.base.Objects%>.equal(this.getLevel(), ((<%it.polito.security.esp.kb.AttackMitigation%>)object).getLevel()) && <%com.google.common.base.Objects%>.equal(this.getType(), ((<%it.polito.security.esp.kb.AttackMitigation%>)object).getType())) && <%com.google.common.base.Objects%>.equal(this.getName(), ((<%it.polito.security.esp.kb.AttackMitigation%>)object).getName()));\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // AttackMitigation

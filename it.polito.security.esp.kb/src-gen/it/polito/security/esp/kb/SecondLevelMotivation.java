/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.ecore.EObject;

import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;
/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Second Level Motivation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A second level motivation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.SecondLevelMotivation#getMotivationType <em>Motivation Type</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.SecondLevelMotivation#getFirstLevelAppliedProtectionInstantiations <em>First Level Applied Protection Instantiations</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getSecondLevelMotivation()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#SecondLevelMotivation",
	name = "http://security.polito.it/esp/kb#secondLevelMotivation",
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.SECOND_LEVEL_MOTIVATION__FIRST_LEVEL_APPLIED_PROTECTION_INSTANTIATIONS, iri = "http://security.polito.it/esp/kb#refersTo"),
		@MapsToObjectProperty(id = KbPackage.SECOND_LEVEL_MOTIVATION__MOTIVATION_TYPE, iri = "http://security.polito.it/esp/kb#hasSecondLevelMotivationType")
	}
)
public interface SecondLevelMotivation extends EObject {
	/**
	 * Returns the value of the '<em><b>Motivation Type</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.SecondLevelMotivationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The second level motivation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Motivation Type</em>' attribute.
	 * @see it.polito.security.esp.kb.SecondLevelMotivationType
	 * @see #setMotivationType(SecondLevelMotivationType)
	 * @see it.polito.security.esp.kb.KbPackage#getSecondLevelMotivation_MotivationType()
	 * @model unique="false"
	 * @generated
	 */
	SecondLevelMotivationType getMotivationType();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.SecondLevelMotivation#getMotivationType <em>Motivation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Motivation Type</em>' attribute.
	 * @see it.polito.security.esp.kb.SecondLevelMotivationType
	 * @see #getMotivationType()
	 * @generated
	 */
	void setMotivationType(SecondLevelMotivationType value);

	/**
	 * Returns the value of the '<em><b>First Level Applied Protection Instantiations</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The first level applied protection instantiations to which the motivation refers.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>First Level Applied Protection Instantiations</em>' reference.
	 * @see #setFirstLevelAppliedProtectionInstantiations(AppliedProtectionInstantiation)
	 * @see it.polito.security.esp.kb.KbPackage#getSecondLevelMotivation_FirstLevelAppliedProtectionInstantiations()
	 * @model
	 * @generated
	 */
	AppliedProtectionInstantiation getFirstLevelAppliedProtectionInstantiations();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.SecondLevelMotivation#getFirstLevelAppliedProtectionInstantiations <em>First Level Applied Protection Instantiations</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Level Applied Protection Instantiations</em>' reference.
	 * @see #getFirstLevelAppliedProtectionInstantiations()
	 * @generated
	 */
	void setFirstLevelAppliedProtectionInstantiations(AppliedProtectionInstantiation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%it.polito.security.esp.kb.AppliedProtectionInstantiation%> _firstLevelAppliedProtectionInstantiations = this.getFirstLevelAppliedProtectionInstantiations();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_firstLevelAppliedProtectionInstantiations, null));\nif (_notEquals)\n{\n\t<%it.polito.security.esp.kb.SecondLevelMotivationType%> _motivationType = this.getMotivationType();\n\t<%java.lang.String%> _string = _motivationType.toString();\n\t<%java.lang.String%> _plus = (_string + \" \");\n\t<%it.polito.security.esp.kb.AppliedProtectionInstantiation%> _firstLevelAppliedProtectionInstantiations_1 = this.getFirstLevelAppliedProtectionInstantiations();\n\t<%java.lang.String%> _string_1 = _firstLevelAppliedProtectionInstantiations_1.toString();\n\treturn (_plus + _string_1);\n}\nelse\n{\n\t<%it.polito.security.esp.kb.SecondLevelMotivationType%> _motivationType_1 = this.getMotivationType();\n\treturn _motivationType_1.toString();\n}'"
	 * @generated
	 */
	String toString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%it.polito.security.esp.kb.SecondLevelMotivationType%> _motivationType = this.getMotivationType();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_motivationType, null));\nif (_notEquals)\n{\n\t<%it.polito.security.esp.kb.SecondLevelMotivationType%> _motivationType_1 = this.getMotivationType();\n\tint _hashCode = _motivationType_1.hashCode();\n\tint _plus = ((31 * result) + _hashCode);\n\tresult = _plus;\n}\n<%it.polito.security.esp.kb.AppliedProtectionInstantiation%> _firstLevelAppliedProtectionInstantiations = this.getFirstLevelAppliedProtectionInstantiations();\nboolean _notEquals_1 = (!<%com.google.common.base.Objects%>.equal(_firstLevelAppliedProtectionInstantiations, null));\nif (_notEquals_1)\n{\n\t<%it.polito.security.esp.kb.AppliedProtectionInstantiation%> _firstLevelAppliedProtectionInstantiations_1 = this.getFirstLevelAppliedProtectionInstantiations();\n\tint _hashCode_1 = _firstLevelAppliedProtectionInstantiations_1.hashCode();\n\tint _plus_1 = ((31 * result) + _hashCode_1);\n\tresult = _plus_1;\n}\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.SecondLevelMotivation%>))\n\t{\n\t\t<%it.polito.security.esp.kb.SecondLevelMotivation%> secondLevelMotivation = ((<%it.polito.security.esp.kb.SecondLevelMotivation%>)object);\n\t\tboolean _and = false;\n\t\t<%it.polito.security.esp.kb.SecondLevelMotivationType%> _motivationType = this.getMotivationType();\n\t\tboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_motivationType, null));\n\t\tif (!_notEquals)\n\t\t{\n\t\t\t_and = false;\n\t\t} else\n\t\t{\n\t\t\t<%it.polito.security.esp.kb.AppliedProtectionInstantiation%> _firstLevelAppliedProtectionInstantiations = secondLevelMotivation.getFirstLevelAppliedProtectionInstantiations();\n\t\t\tboolean _notEquals_1 = (!<%com.google.common.base.Objects%>.equal(_firstLevelAppliedProtectionInstantiations, null));\n\t\t\t_and = _notEquals_1;\n\t\t}\n\t\tif (_and)\n\t\t{\n\t\t\tboolean _and_1 = false;\n\t\t\t<%it.polito.security.esp.kb.SecondLevelMotivationType%> _motivationType_1 = this.getMotivationType();\n\t\t\t<%it.polito.security.esp.kb.SecondLevelMotivationType%> _motivationType_2 = secondLevelMotivation.getMotivationType();\n\t\t\tboolean _equals_1 = _motivationType_1.equals(_motivationType_2);\n\t\t\tif (!_equals_1)\n\t\t\t{\n\t\t\t\t_and_1 = false;\n\t\t\t} else\n\t\t\t{\n\t\t\t\t<%it.polito.security.esp.kb.AppliedProtectionInstantiation%> _firstLevelAppliedProtectionInstantiations_1 = this.getFirstLevelAppliedProtectionInstantiations();\n\t\t\t\t<%it.polito.security.esp.kb.AppliedProtectionInstantiation%> _firstLevelAppliedProtectionInstantiations_2 = secondLevelMotivation.getFirstLevelAppliedProtectionInstantiations();\n\t\t\t\tboolean _equals_2 = _firstLevelAppliedProtectionInstantiations_1.equals(_firstLevelAppliedProtectionInstantiations_2);\n\t\t\t\t_and_1 = _equals_2;\n\t\t\t}\n\t\t\treturn _and_1;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tboolean _and_2 = false;\n\t\t\t<%it.polito.security.esp.kb.SecondLevelMotivationType%> _motivationType_3 = this.getMotivationType();\n\t\t\tboolean _equals_3 = <%com.google.common.base.Objects%>.equal(_motivationType_3, null);\n\t\t\tif (!_equals_3)\n\t\t\t{\n\t\t\t\t_and_2 = false;\n\t\t\t} else\n\t\t\t{\n\t\t\t\t<%it.polito.security.esp.kb.AppliedProtectionInstantiation%> _firstLevelAppliedProtectionInstantiations_3 = secondLevelMotivation.getFirstLevelAppliedProtectionInstantiations();\n\t\t\t\tboolean _equals_4 = <%com.google.common.base.Objects%>.equal(_firstLevelAppliedProtectionInstantiations_3, null);\n\t\t\t\t_and_2 = _equals_4;\n\t\t\t}\n\t\t\tif (_and_2)\n\t\t\t{\n\t\t\t\t<%it.polito.security.esp.kb.SecondLevelMotivationType%> _motivationType_4 = this.getMotivationType();\n\t\t\t\t<%it.polito.security.esp.kb.SecondLevelMotivationType%> _motivationType_5 = secondLevelMotivation.getMotivationType();\n\t\t\t\treturn _motivationType_4.equals(_motivationType_5);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // SecondLevelMotivation

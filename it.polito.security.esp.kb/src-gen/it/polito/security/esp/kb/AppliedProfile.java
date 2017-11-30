/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Applied Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An applied profile.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.AppliedProfile#getProtectionProfile <em>Protection Profile</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AppliedProfile#getApplicationPart <em>Application Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.polito.security.esp.kb.KbPackage#getAppliedProfile()
 * @model
 * @generated
 */
public interface AppliedProfile extends EObject
{
  /**
   * Returns the value of the '<em><b>Protection Profile</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The profile.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Protection Profile</em>' reference.
   * @see #setProtectionProfile(ProtectionInstantiation)
   * @see it.polito.security.esp.kb.KbPackage#getAppliedProfile_ProtectionProfile()
   * @model
   * @generated
   */
  ProtectionInstantiation getProtectionProfile();

  /**
   * Sets the value of the '{@link it.polito.security.esp.kb.AppliedProfile#getProtectionProfile <em>Protection Profile</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Protection Profile</em>' reference.
   * @see #getProtectionProfile()
   * @generated
   */
  void setProtectionProfile(ProtectionInstantiation value);

  /**
   * Returns the value of the '<em><b>Application Part</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The asset.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Application Part</em>' reference.
   * @see #setApplicationPart(ApplicationPart)
   * @see it.polito.security.esp.kb.KbPackage#getAppliedProfile_ApplicationPart()
   * @model
   * @generated
   */
  ApplicationPart getApplicationPart();

  /**
   * Sets the value of the '{@link it.polito.security.esp.kb.AppliedProfile#getApplicationPart <em>Application Part</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Application Part</em>' reference.
   * @see #getApplicationPart()
   * @generated
   */
  void setApplicationPart(ApplicationPart value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Translates the object into a string.
   * <!-- end-model-doc -->
   * @model unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%it.polito.security.esp.kb.AppliedProfile%> _this = this;\n<%it.polito.security.esp.kb.ProtectionInstantiation%> _protectionProfile = _this.getProtectionProfile();\n<%java.lang.String%> _plus = (_protectionProfile + \"/\");\n<%it.polito.security.esp.kb.AppliedProfile%> _this_1 = this;\n<%it.polito.security.esp.kb.ApplicationPart%> _applicationPart = _this_1.getApplicationPart();\nreturn (_plus + _applicationPart);'"
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
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%it.polito.security.esp.kb.AppliedProfile%> _this = this;\n<%it.polito.security.esp.kb.ProtectionInstantiation%> _protectionProfile = _this.getProtectionProfile();\nint _hashCode = _protectionProfile.hashCode();\n<%it.polito.security.esp.kb.AppliedProfile%> _this_1 = this;\n<%it.polito.security.esp.kb.ApplicationPart%> _applicationPart = _this_1.getApplicationPart();\nint _hashCode_1 = _applicationPart.hashCode();\nreturn (_hashCode + _hashCode_1);'"
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
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.AppliedProfile%>))\n\t{\n\t\t<%it.polito.security.esp.kb.AppliedProfile%> appliedProfile = ((<%it.polito.security.esp.kb.AppliedProfile%>) object);\n\t\tboolean _and = false;\n\t\t<%it.polito.security.esp.kb.AppliedProfile%> _this = this;\n\t\t<%it.polito.security.esp.kb.ProtectionInstantiation%> _protectionProfile = _this.getProtectionProfile();\n\t\t<%it.polito.security.esp.kb.ProtectionInstantiation%> _protectionProfile_1 = appliedProfile.getProtectionProfile();\n\t\tboolean _equals_1 = _protectionProfile.equals(_protectionProfile_1);\n\t\tif (!_equals_1)\n\t\t{\n\t\t\t_and = false;\n\t\t} else\n\t\t{\n\t\t\t<%it.polito.security.esp.kb.AppliedProfile%> _this_1 = this;\n\t\t\t<%it.polito.security.esp.kb.ApplicationPart%> _applicationPart = _this_1.getApplicationPart();\n\t\t\t<%it.polito.security.esp.kb.ApplicationPart%> _applicationPart_1 = appliedProfile.getApplicationPart();\n\t\t\tboolean _equals_2 = _applicationPart.equals(_applicationPart_1);\n\t\t\t_and = (_equals_1 && _equals_2);\n\t\t}\n\t\treturn _and;\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
   * @generated
   */
  boolean equals(Object object);

} // AppliedProfile

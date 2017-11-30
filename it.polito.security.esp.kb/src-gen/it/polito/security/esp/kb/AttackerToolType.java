/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.ecore.EObject;

import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToDataProperty;;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attacker Tool Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The attacker tool types.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.AttackerToolType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see it.polito.security.esp.kb.KbPackage#getAttackerToolType()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#AttackerToolType",
	name = "http://security.polito.it/esp/kb#attackerToolType",
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.ATTACKER_TOOL_TYPE__NAME, iri = "http://security.polito.it/esp/kb#hasName")
	}
)
public interface AttackerToolType extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The name.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see it.polito.security.esp.kb.KbPackage#getAttackerToolType_Name()
   * @model unique="false"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link it.polito.security.esp.kb.AttackerToolType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Retrieves the object hash code.
   * <!-- end-model-doc -->
   * @model unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%it.polito.security.esp.kb.AttackerToolType%> _this = this;\n<%java.lang.String%> _name = _this.getName();\nreturn _name.hashCode();'"
   * @generated
   */
  int hashCode();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Translates the object into a string.
   * <!-- end-model-doc -->
   * @model unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%it.polito.security.esp.kb.AttackerToolType%> _this = this;\nreturn _this.getName();'"
   * @generated
   */
  String toString();

} // AttackerToolType

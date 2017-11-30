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
 * A representation of the model object '<em><b>Attacker Tool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An attacker tool.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.AttackerTool#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackerTool#getTypes <em>Types</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackerTool#getExpertise <em>Expertise</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackerTool#getCost <em>Cost</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.AttackerTool#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getAttackerTool()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#AttackerTool",
	name = "http://security.polito.it/esp/kb#attackerTool",
	singleton = true,
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.ATTACKER_TOOL__NAME, iri = "http://security.polito.it/esp/kb#hasName"),
		@MapsToDataProperty(id = KbPackage.ATTACKER_TOOL__COST, iri = "http://security.polito.it/esp/kb#hasCost")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.ATTACKER_TOOL__EXPERTISE, iri = "http://security.polito.it/esp/kb#hasExpertise"),
		@MapsToObjectProperty(id = KbPackage.ATTACKER_TOOL__TYPES, iri = "http://security.polito.it/esp/kb#isTypeOf")
	}
)
public interface AttackerTool extends EObject
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
	 * @see it.polito.security.esp.kb.KbPackage#getAttackerTool_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackerTool#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Types</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackerToolType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Types</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackerTool_Types()
	 * @model
	 * @generated
	 */
	EList<AttackerToolType> getTypes();

	/**
	 * Returns the value of the '<em><b>Expertise</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.ExpertiseLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum expertise required.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expertise</em>' attribute.
	 * @see it.polito.security.esp.kb.ExpertiseLevel
	 * @see #setExpertise(ExpertiseLevel)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackerTool_Expertise()
	 * @model unique="false"
	 * @generated
	 */
	ExpertiseLevel getExpertise();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackerTool#getExpertise <em>Expertise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expertise</em>' attribute.
	 * @see it.polito.security.esp.kb.ExpertiseLevel
	 * @see #getExpertise()
	 * @generated
	 */
	void setExpertise(ExpertiseLevel value);

	/**
	 * Returns the value of the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The monetary cost.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cost</em>' attribute.
	 * @see #setCost(int)
	 * @see it.polito.security.esp.kb.KbPackage#getAttackerTool_Cost()
	 * @model unique="false"
	 * @generated
	 */
	int getCost();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.AttackerTool#getCost <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cost</em>' attribute.
	 * @see #getCost()
	 * @generated
	 */
	void setCost(int value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The enabled state of the tool.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getAttackerTool_Enabled()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.ecore.EObject%> _eContainer = this.eContainer();\n<%it.polito.security.esp.kb.Attacker%> attacker = ((<%it.polito.security.esp.kb.Model%>) _eContainer).getAttacker();\nif (((!<%com.google.common.base.Objects%>.equal(attacker.getBudgetLimit(), null)) && (this.getCost() > (attacker.getBudgetLimit()).intValue())))\n{\n\treturn false;\n}\nif ((<%com.google.common.base.Objects%>.equal(attacker.getExpertise(), <%it.polito.security.esp.kb.ExpertiseLevel%>.AMATEUR) && (!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%it.polito.security.esp.kb.ExpertiseLevel%>.AMATEUR))))\n{\n\treturn false;\n}\nif (((<%com.google.common.base.Objects%>.equal(attacker.getExpertise(), <%it.polito.security.esp.kb.ExpertiseLevel%>.GEEK) && (!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%it.polito.security.esp.kb.ExpertiseLevel%>.AMATEUR))) && \n\t(!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%it.polito.security.esp.kb.ExpertiseLevel%>.GEEK))))\n{\n\treturn false;\n}\nif ((((<%com.google.common.base.Objects%>.equal(attacker.getExpertise(), <%it.polito.security.esp.kb.ExpertiseLevel%>.EXPERT) && (!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%it.polito.security.esp.kb.ExpertiseLevel%>.AMATEUR))) && \n\t(!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%it.polito.security.esp.kb.ExpertiseLevel%>.GEEK))) && (!<%com.google.common.base.Objects%>.equal(this.getExpertise(), <%it.polito.security.esp.kb.ExpertiseLevel%>.EXPERT))))\n{\n\treturn false;\n}\nreturn true;'"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the object hash code.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='int result = 17;\n<%java.lang.String%> _name = this.getName();\nint _hashCode = _name.hashCode();\nint _plus = ((31 * result) + _hashCode);\nresult = _plus;\nreturn result;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.AttackerTool%>))\n\t{\n\t\t<%java.lang.String%> _name = this.getName();\n\t\t<%java.lang.String%> _name_1 = ((<%it.polito.security.esp.kb.AttackerTool%>)object).getName();\n\t\treturn <%com.google.common.base.Objects%>.equal(_name, _name_1);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
	 * @generated
	 */
	boolean equals(Object object);

} // AttackerTool

/**
 */
package it.polito.security.esp.kb;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import it.polito.security.ontologies.annotations.MapsToIndividual;
import it.polito.security.ontologies.annotations.MapsToDataProperty;
import it.polito.security.ontologies.annotations.MapsToObjectProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A software protection.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.Protection#getId <em>Id</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#isAutomaticallyDeployable <em>Automatically Deployable</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#isSecondLevel <em>Second Level</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getSecondLevelEnlargmentUsefulness <em>Second Level Enlargment Usefulness</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getSecondLevelCallGraphEnlargmentUsefulness <em>Second Level Call Graph Enlargment Usefulness</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getSecondLevelRepetitionUsefulness <em>Second Level Repetition Usefulness</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getSecondLevelRepetitionInstantiation <em>Second Level Repetition Instantiation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getApplicationPartTypes <em>Application Part Types</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getMitigations <em>Mitigations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getEnforcedSecurityRequirements <em>Enforced Security Requirements</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getForbiddenPrecedences <em>Forbidden Precedences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getDiscouragedPrecedences <em>Discouraged Precedences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getEncouragedPrecedences <em>Encouraged Precedences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getActcPrecedences <em>Actc Precedences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#isSingleton <em>Singleton</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getDefeatedAttackerToolTypes <em>Defeated Attacker Tool Types</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getBlockedAttackerToolTypes <em>Blocked Attacker Tool Types</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getInstantiations <em>Instantiations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getActions <em>Actions</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getFlags <em>Flags</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.Protection#getInstantiationsCount <em>Instantiations Count</em>}</li>
 * </ul>
 *
 * @see it.polito.security.esp.kb.KbPackage#getProtection()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#Protection",
	name = "http://security.polito.it/esp/kb#protection",
	dataProperties =
	{
		@MapsToDataProperty(id = KbPackage.PROTECTION__ID, iri = "http://security.polito.it/esp/kb#hasId"),
		@MapsToDataProperty(id = KbPackage.PROTECTION__NAME, iri = "http://security.polito.it/esp/kb#hasName"),
		@MapsToDataProperty(id = KbPackage.PROTECTION__ENABLED, iri = "http://security.polito.it/esp/kb#isEnabled"),
		@MapsToDataProperty(id = KbPackage.PROTECTION__SINGLETON, iri = "http://security.polito.it/esp/kb#isSingleton"),
		@MapsToDataProperty(id = KbPackage.PROTECTION__SECOND_LEVEL, iri = "http://security.polito.it/esp/kb#isSecondLevel"),
		@MapsToDataProperty(id = KbPackage.PROTECTION__AUTOMATICALLY_DEPLOYABLE, iri = "http://security.polito.it/esp/kb#isAutomaticallyDeployable")
	},
	objectProperties =
	{
		@MapsToObjectProperty(id = KbPackage.PROTECTION__MITIGATIONS, iri = "http://security.polito.it/esp/kb#mitigates"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__INSTANTIATIONS, iri = "http://security.polito.it/esp/kb#contains"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__FORBIDDEN_PRECEDENCES, iri = "http://security.polito.it/esp/kb#cannotBePrecededBy"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__DISCOURAGED_PRECEDENCES, iri = "http://security.polito.it/esp/kb#shouldNotBePrecededBy"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__ENCOURAGED_PRECEDENCES, iri = "http://security.polito.it/esp/kb#shouldBePrecededBy"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__ACTC_PRECEDENCES, iri = "http://security.polito.it/esp/kb#isPrecededInTheACTCBy"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__BLOCKED_ATTACKER_TOOL_TYPES, iri = "http://security.polito.it/esp/kb#blocks"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__DEFEATED_ATTACKER_TOOL_TYPES, iri = "http://security.polito.it/esp/kb#defeats"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__APPLICATION_PART_TYPES, iri = "http://security.polito.it/esp/kb#isApplicableTo"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__ENFORCED_SECURITY_REQUIREMENTS, iri = "http://security.polito.it/esp/kb#enforces"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS, iri= "http://security.polito.it/esp/kb#hasSecondLevelCallGraphEnlargmentUsefulness"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__SECOND_LEVEL_ENLARGMENT_USEFULNESS, iri= "http://security.polito.it/esp/kb#hasSecondLevelEnlargmentUsefulness"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_USEFULNESS, iri= "http://security.polito.it/esp/kb#hasSecondLevelRepetitionUsefulness"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_INSTANTIATION, iri= "http://security.polito.it/esp/kb#hasSecondLevelRepetitionInstantiation"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__ACTIONS, iri= "http://security.polito.it/esp/kb#hasAction"),
		@MapsToObjectProperty(id = KbPackage.PROTECTION__FLAGS, iri= "http://security.polito.it/esp/kb#hasProperty")
	}
)
public interface Protection extends EObject
{
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection id.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_Id()
	 * @model unique="false"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Protection#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Protection#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The enabled state of the protection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_Enabled()
	 * @model unique="false"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Protection#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Automatically Deployable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The automatically deployable state of the protection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Automatically Deployable</em>' attribute.
	 * @see #setAutomaticallyDeployable(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_AutomaticallyDeployable()
	 * @model unique="false"
	 * @generated
	 */
	boolean isAutomaticallyDeployable();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Protection#isAutomaticallyDeployable <em>Automatically Deployable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Automatically Deployable</em>' attribute.
	 * @see #isAutomaticallyDeployable()
	 * @generated
	 */
	void setAutomaticallyDeployable(boolean value);

	/**
	 * Returns the value of the '<em><b>Second Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * True if the protection is a suitable for second level protection
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Second Level</em>' attribute.
	 * @see #setSecondLevel(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_SecondLevel()
	 * @model unique="false"
	 * @generated
	 */
	boolean isSecondLevel();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Protection#isSecondLevel <em>Second Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Level</em>' attribute.
	 * @see #isSecondLevel()
	 * @generated
	 */
	void setSecondLevel(boolean value);

	/**
	 * Returns the value of the '<em><b>Second Level Enlargment Usefulness</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.Level}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * How much is useful in the second level protection decision process to enlarge the areas of code on which the protection is applied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Second Level Enlargment Usefulness</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #setSecondLevelEnlargmentUsefulness(Level)
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_SecondLevelEnlargmentUsefulness()
	 * @model unique="false"
	 * @generated
	 */
	Level getSecondLevelEnlargmentUsefulness();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Protection#getSecondLevelEnlargmentUsefulness <em>Second Level Enlargment Usefulness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Level Enlargment Usefulness</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #getSecondLevelEnlargmentUsefulness()
	 * @generated
	 */
	void setSecondLevelEnlargmentUsefulness(Level value);

	/**
	 * Returns the value of the '<em><b>Second Level Call Graph Enlargment Usefulness</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.Level}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * How much is useful in the second level protection decision process to apply the protection to callers and callees of the function to which the protection is applied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Second Level Call Graph Enlargment Usefulness</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #setSecondLevelCallGraphEnlargmentUsefulness(Level)
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_SecondLevelCallGraphEnlargmentUsefulness()
	 * @model unique="false"
	 * @generated
	 */
	Level getSecondLevelCallGraphEnlargmentUsefulness();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Protection#getSecondLevelCallGraphEnlargmentUsefulness <em>Second Level Call Graph Enlargment Usefulness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Level Call Graph Enlargment Usefulness</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #getSecondLevelCallGraphEnlargmentUsefulness()
	 * @generated
	 */
	void setSecondLevelCallGraphEnlargmentUsefulness(Level value);

	/**
	 * Returns the value of the '<em><b>Second Level Repetition Usefulness</b></em>' attribute.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.Level}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * How much is useful in the second level protection decision process to repeat a protection on other functions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Second Level Repetition Usefulness</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #setSecondLevelRepetitionUsefulness(Level)
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_SecondLevelRepetitionUsefulness()
	 * @model unique="false"
	 * @generated
	 */
	Level getSecondLevelRepetitionUsefulness();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Protection#getSecondLevelRepetitionUsefulness <em>Second Level Repetition Usefulness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Level Repetition Usefulness</em>' attribute.
	 * @see it.polito.security.esp.kb.Level
	 * @see #getSecondLevelRepetitionUsefulness()
	 * @generated
	 */
	void setSecondLevelRepetitionUsefulness(Level value);

	/**
	 * Returns the value of the '<em><b>Second Level Repetition Instantiation</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ProtectionInstantiation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The suggested protection instantiations to repeat the protection in the second level protection decision process.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Second Level Repetition Instantiation</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_SecondLevelRepetitionInstantiation()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProtectionInstantiation> getSecondLevelRepetitionInstantiation();

	/**
	 * Returns the value of the '<em><b>Application Part Types</b></em>' attribute list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ApplicationPartType}.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.ApplicationPartType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The types of application parts which the protection can be applied.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Part Types</em>' attribute list.
	 * @see it.polito.security.esp.kb.ApplicationPartType
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_ApplicationPartTypes()
	 * @model unique="false"
	 * @generated
	 */
	EList<ApplicationPartType> getApplicationPartTypes();

	/**
	 * Returns the value of the '<em><b>Mitigations</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackMitigation}.
	 * It is bidirectional and its opposite is '{@link it.polito.security.esp.kb.AttackMitigation#getProtection <em>Protection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The mitigations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mitigations</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_Mitigations()
	 * @see it.polito.security.esp.kb.AttackMitigation#getProtection
	 * @model opposite="protection" containment="true"
	 * @generated
	 */
	EList<AttackMitigation> getMitigations();

	/**
	 * Returns the value of the '<em><b>Enforced Security Requirements</b></em>' attribute list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Property}.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The security requirements enforced by this protection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Enforced Security Requirements</em>' attribute list.
	 * @see it.polito.security.esp.kb.Property
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_EnforcedSecurityRequirements()
	 * @model unique="false"
	 * @generated
	 */
	EList<Property> getEnforcedSecurityRequirements();

	/**
	 * Returns the value of the '<em><b>Forbidden Precedences</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Protection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protections that cannot precede this one.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Forbidden Precedences</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_ForbiddenPrecedences()
	 * @model
	 * @generated
	 */
	EList<Protection> getForbiddenPrecedences();

	/**
	 * Returns the value of the '<em><b>Discouraged Precedences</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Protection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protections that should not precede this one.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Discouraged Precedences</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_DiscouragedPrecedences()
	 * @model
	 * @generated
	 */
	EList<Protection> getDiscouragedPrecedences();

	/**
	 * Returns the value of the '<em><b>Encouraged Precedences</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Protection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protections that should precede this one.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Encouraged Precedences</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_EncouragedPrecedences()
	 * @model
	 * @generated
	 */
	EList<Protection> getEncouragedPrecedences();

	/**
	 * Returns the value of the '<em><b>Actc Precedences</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.Protection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protections that precede this one in the ACTC work-flow.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actc Precedences</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_ActcPrecedences()
	 * @model
	 * @generated
	 */
	EList<Protection> getActcPrecedences();

	/**
	 * Returns the value of the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The singleton boolean.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Singleton</em>' attribute.
	 * @see #setSingleton(boolean)
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_Singleton()
	 * @model unique="false"
	 * @generated
	 */
	boolean isSingleton();

	/**
	 * Sets the value of the '{@link it.polito.security.esp.kb.Protection#isSingleton <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Singleton</em>' attribute.
	 * @see #isSingleton()
	 * @generated
	 */
	void setSingleton(boolean value);

	/**
	 * Returns the value of the '<em><b>Defeated Attacker Tool Types</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackerToolType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The types of attacker tools that can defeat completely the protection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Defeated Attacker Tool Types</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_DefeatedAttackerToolTypes()
	 * @model
	 * @generated
	 */
	EList<AttackerToolType> getDefeatedAttackerToolTypes();

	/**
	 * Returns the value of the '<em><b>Blocked Attacker Tool Types</b></em>' reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.AttackerToolType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The types of attacker tools blocked by the protection.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Blocked Attacker Tool Types</em>' reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_BlockedAttackerToolTypes()
	 * @model
	 * @generated
	 */
	EList<AttackerToolType> getBlockedAttackerToolTypes();

	/**
	 * Returns the value of the '<em><b>Instantiations</b></em>' containment reference list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ProtectionInstantiation}.
	 * It is bidirectional and its opposite is '{@link it.polito.security.esp.kb.ProtectionInstantiation#getProtection <em>Protection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The protection instantiations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instantiations</em>' containment reference list.
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_Instantiations()
	 * @see it.polito.security.esp.kb.ProtectionInstantiation#getProtection
	 * @model opposite="protection" containment="true"
	 * @generated
	 */
	EList<ProtectionInstantiation> getInstantiations();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' attribute list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ActionType}.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.ActionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The action types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actions</em>' attribute list.
	 * @see it.polito.security.esp.kb.ActionType
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_Actions()
	 * @model unique="false"
	 * @generated
	 */
	EList<ActionType> getActions();

	/**
	 * Returns the value of the '<em><b>Flags</b></em>' attribute list.
	 * The list contents are of type {@link it.polito.security.esp.kb.ProtectionFlag}.
	 * The literals are from the enumeration {@link it.polito.security.esp.kb.ProtectionFlag}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The flags.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Flags</em>' attribute list.
	 * @see it.polito.security.esp.kb.ProtectionFlag
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_Flags()
	 * @model unique="false"
	 * @generated
	 */
	EList<ProtectionFlag> getFlags();

	/**
	 * Returns the value of the '<em><b>Instantiations Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of protection instantiations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instantiations Count</em>' attribute.
	 * @see it.polito.security.esp.kb.KbPackage#getProtection_InstantiationsCount()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%org.eclipse.emf.common.util.EList%><<%it.polito.security.esp.kb.ProtectionInstantiation%>> _instantiations = this.getInstantiations();\nreturn _instantiations.size();'"
	 * @generated
	 */
	int getInstantiationsCount();

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _equals = <%com.google.common.base.Objects%>.equal(object, null);\nif (_equals)\n{\n\treturn false;\n}\nelse\n{\n\tif ((object instanceof <%it.polito.security.esp.kb.Protection%>))\n\t{\n\t\t<%java.lang.String%> _name = this.getName();\n\t\t<%java.lang.String%> _name_1 = ((<%it.polito.security.esp.kb.Protection%>)object).getName();\n\t\treturn <%com.google.common.base.Objects%>.equal(_name, _name_1);\n\t}\n\telse\n\t{\n\t\treturn false;\n\t}\n}'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getName();'"
	 * @generated
	 */
	String toString();

} // Protection

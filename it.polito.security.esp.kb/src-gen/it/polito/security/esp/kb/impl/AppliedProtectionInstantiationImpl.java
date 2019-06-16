/**
 */
package it.polito.security.esp.kb.impl;

import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartSet;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.AttackMitigation;
import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.ProtectionInstantiation;
import it.polito.security.esp.kb.ProtectionObjective;
import it.polito.security.esp.kb.SecondLevelMotivation;
import it.polito.security.esp.kb.SecondLevelMotivationType;

import it.polito.security.esp.util.Strings;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Applied Protection Instantiation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.AppliedProtectionInstantiationImpl#getProtectionInstantiation <em>Protection Instantiation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AppliedProtectionInstantiationImpl#getApplicationPart <em>Application Part</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AppliedProtectionInstantiationImpl#getProtectionObjectives <em>Protection Objectives</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AppliedProtectionInstantiationImpl#getAttackMitigations <em>Attack Mitigations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AppliedProtectionInstantiationImpl#getSecondLevelMotivation <em>Second Level Motivation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AppliedProtectionInstantiationImpl#getVariableAnnotation <em>Variable Annotation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AppliedProtectionInstantiationImpl#getCodeAnnotation <em>Code Annotation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AppliedProtectionInstantiationImpl#getVerifierAnnotation <em>Verifier Annotation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AppliedProtectionInstantiationImpl#getAttestatorAnnotation <em>Attestator Annotation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AppliedProtectionInstantiationImpl#getToolCommand <em>Tool Command</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AppliedProtectionInstantiationImpl extends MinimalEObjectImpl.Container implements AppliedProtectionInstantiation {
	/**
	 * The cached value of the '{@link #getProtectionInstantiation() <em>Protection Instantiation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionInstantiation()
	 * @generated
	 * @ordered
	 */
	protected ProtectionInstantiation protectionInstantiation;

	/**
	 * The cached value of the '{@link #getApplicationPart() <em>Application Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationPart()
	 * @generated
	 * @ordered
	 */
	protected ApplicationPart applicationPart;

	/**
	 * The cached value of the '{@link #getProtectionObjectives() <em>Protection Objectives</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtectionObjectives()
	 * @generated
	 * @ordered
	 */
	protected EList<ProtectionObjective> protectionObjectives;

	/**
	 * The cached value of the '{@link #getAttackMitigations() <em>Attack Mitigations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackMitigations()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackMitigation> attackMitigations;

	/**
	 * The cached value of the '{@link #getSecondLevelMotivation() <em>Second Level Motivation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLevelMotivation()
	 * @generated
	 * @ordered
	 */
	protected EList<SecondLevelMotivation> secondLevelMotivation;

	/**
	 * The default value of the '{@link #getVariableAnnotation() <em>Variable Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAnnotation()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_ANNOTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariableAnnotation() <em>Variable Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAnnotation()
	 * @generated
	 * @ordered
	 */
	protected String variableAnnotation = VARIABLE_ANNOTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCodeAnnotation() <em>Code Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeAnnotation()
	 * @generated
	 * @ordered
	 */
	protected static final String CODE_ANNOTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCodeAnnotation() <em>Code Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeAnnotation()
	 * @generated
	 * @ordered
	 */
	protected String codeAnnotation = CODE_ANNOTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerifierAnnotation() <em>Verifier Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifierAnnotation()
	 * @generated
	 * @ordered
	 */
	protected static final String VERIFIER_ANNOTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVerifierAnnotation() <em>Verifier Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerifierAnnotation()
	 * @generated
	 * @ordered
	 */
	protected String verifierAnnotation = VERIFIER_ANNOTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttestatorAnnotation() <em>Attestator Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttestatorAnnotation()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTESTATOR_ANNOTATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttestatorAnnotation() <em>Attestator Annotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttestatorAnnotation()
	 * @generated
	 * @ordered
	 */
	protected String attestatorAnnotation = ATTESTATOR_ANNOTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getToolCommand() <em>Tool Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToolCommand()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOL_COMMAND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToolCommand() <em>Tool Command</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToolCommand()
	 * @generated
	 * @ordered
	 */
	protected String toolCommand = TOOL_COMMAND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AppliedProtectionInstantiationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return KbPackage.Literals.APPLIED_PROTECTION_INSTANTIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProtectionInstantiation getProtectionInstantiation() {
		if (protectionInstantiation != null && protectionInstantiation.eIsProxy()) {
			InternalEObject oldProtectionInstantiation = (InternalEObject)protectionInstantiation;
			protectionInstantiation = (ProtectionInstantiation)eResolveProxy(oldProtectionInstantiation);
			if (protectionInstantiation != oldProtectionInstantiation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION, oldProtectionInstantiation, protectionInstantiation));
			}
		}
		return protectionInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProtectionInstantiation basicGetProtectionInstantiation() {
		return protectionInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProtectionInstantiation(ProtectionInstantiation newProtectionInstantiation) {
		ProtectionInstantiation oldProtectionInstantiation = protectionInstantiation;
		protectionInstantiation = newProtectionInstantiation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION, oldProtectionInstantiation, protectionInstantiation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApplicationPart getApplicationPart() {
		if (applicationPart != null && applicationPart.eIsProxy()) {
			InternalEObject oldApplicationPart = (InternalEObject)applicationPart;
			applicationPart = (ApplicationPart)eResolveProxy(oldApplicationPart);
			if (applicationPart != oldApplicationPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART, oldApplicationPart, applicationPart));
			}
		}
		return applicationPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart basicGetApplicationPart() {
		return applicationPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setApplicationPart(ApplicationPart newApplicationPart) {
		ApplicationPart oldApplicationPart = applicationPart;
		applicationPart = newApplicationPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART, oldApplicationPart, applicationPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ProtectionObjective> getProtectionObjectives() {
		if (protectionObjectives == null) {
			protectionObjectives = new EObjectResolvingEList<ProtectionObjective>(ProtectionObjective.class, this, KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES);
		}
		return protectionObjectives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttackMitigation> getAttackMitigations() {
		if (attackMitigations == null) {
			attackMitigations = new EObjectResolvingEList<AttackMitigation>(AttackMitigation.class, this, KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS);
		}
		return attackMitigations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SecondLevelMotivation> getSecondLevelMotivation() {
		if (secondLevelMotivation == null) {
			secondLevelMotivation = new EObjectResolvingEList<SecondLevelMotivation>(SecondLevelMotivation.class, this, KbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION);
		}
		return secondLevelMotivation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVariableAnnotation() {
		return variableAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariableAnnotation(String newVariableAnnotation) {
		String oldVariableAnnotation = variableAnnotation;
		variableAnnotation = newVariableAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLIED_PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION, oldVariableAnnotation, variableAnnotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCodeAnnotation() {
		return codeAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCodeAnnotation(String newCodeAnnotation) {
		String oldCodeAnnotation = codeAnnotation;
		codeAnnotation = newCodeAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLIED_PROTECTION_INSTANTIATION__CODE_ANNOTATION, oldCodeAnnotation, codeAnnotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVerifierAnnotation() {
		return verifierAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVerifierAnnotation(String newVerifierAnnotation) {
		String oldVerifierAnnotation = verifierAnnotation;
		verifierAnnotation = newVerifierAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLIED_PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION, oldVerifierAnnotation, verifierAnnotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAttestatorAnnotation() {
		return attestatorAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttestatorAnnotation(String newAttestatorAnnotation) {
		String oldAttestatorAnnotation = attestatorAnnotation;
		attestatorAnnotation = newAttestatorAnnotation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION, oldAttestatorAnnotation, attestatorAnnotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getToolCommand() {
		return toolCommand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setToolCommand(String newToolCommand) {
		String oldToolCommand = toolCommand;
		toolCommand = newToolCommand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLIED_PROTECTION_INSTANTIATION__TOOL_COMMAND, oldToolCommand, toolCommand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		HashSet<ApplicationPart> locations = new HashSet<ApplicationPart>();
		locations.add(this.getApplicationPart());
		EList<ApplicationPartSet> _sets = this.getApplicationPart().getSets();
		for (final ApplicationPartSet i : _sets) {
			boolean _contains = this.getProtectionInstantiation().getProtection().getActions().contains(i.getAction());
			if (_contains) {
				locations.addAll(i.getApplicationParts());
			}
		}
		int _size = this.getSecondLevelMotivation().size();
		boolean _equals = (_size == 0);
		if (_equals) {
			ProtectionInstantiation _protectionInstantiation = this.getProtectionInstantiation();
			String _plus = (_protectionInstantiation + " @ ");
			String _join = Strings.join(locations, ", ");
			return (_plus + _join);
		}
		else {
			ProtectionInstantiation _protectionInstantiation_1 = this.getProtectionInstantiation();
			String _plus_1 = (_protectionInstantiation_1 + " @ ");
			String _join_1 = Strings.join(locations, ", ");
			String _plus_2 = (_plus_1 + _join_1);
			String _plus_3 = (_plus_2 + " [");
			SecondLevelMotivationType _motivationType = this.getSecondLevelMotivation().get(0).getMotivationType();
			String _plus_4 = (_plus_3 + _motivationType);
			return (_plus_4 + "]");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int hashCode() {
		int result = 17;
		int _hashCode = this.getProtectionInstantiation().hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		int _hashCode_1 = this.getApplicationPart().hashCode();
		int _plus_1 = ((31 * result) + _hashCode_1);
		result = _plus_1;
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean equals(final Object object) {
		if ((object == null)) {
			return false;
		}
		else {
			if ((object instanceof AppliedProtectionInstantiation)) {
				return (EcoreUtil.equals(this.getProtectionInstantiation(), ((AppliedProtectionInstantiation)object).getProtectionInstantiation()) && 
					EcoreUtil.equals(this.getApplicationPart(), ((AppliedProtectionInstantiation)object).getApplicationPart()));
			}
			else {
				return false;
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION:
				if (resolve) return getProtectionInstantiation();
				return basicGetProtectionInstantiation();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART:
				if (resolve) return getApplicationPart();
				return basicGetApplicationPart();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES:
				return getProtectionObjectives();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS:
				return getAttackMitigations();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION:
				return getSecondLevelMotivation();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION:
				return getVariableAnnotation();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__CODE_ANNOTATION:
				return getCodeAnnotation();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION:
				return getVerifierAnnotation();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION:
				return getAttestatorAnnotation();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__TOOL_COMMAND:
				return getToolCommand();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION:
				setProtectionInstantiation((ProtectionInstantiation)newValue);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART:
				setApplicationPart((ApplicationPart)newValue);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES:
				getProtectionObjectives().clear();
				getProtectionObjectives().addAll((Collection<? extends ProtectionObjective>)newValue);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS:
				getAttackMitigations().clear();
				getAttackMitigations().addAll((Collection<? extends AttackMitigation>)newValue);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION:
				getSecondLevelMotivation().clear();
				getSecondLevelMotivation().addAll((Collection<? extends SecondLevelMotivation>)newValue);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION:
				setVariableAnnotation((String)newValue);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__CODE_ANNOTATION:
				setCodeAnnotation((String)newValue);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION:
				setVerifierAnnotation((String)newValue);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION:
				setAttestatorAnnotation((String)newValue);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__TOOL_COMMAND:
				setToolCommand((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION:
				setProtectionInstantiation((ProtectionInstantiation)null);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART:
				setApplicationPart((ApplicationPart)null);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES:
				getProtectionObjectives().clear();
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS:
				getAttackMitigations().clear();
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION:
				getSecondLevelMotivation().clear();
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION:
				setVariableAnnotation(VARIABLE_ANNOTATION_EDEFAULT);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__CODE_ANNOTATION:
				setCodeAnnotation(CODE_ANNOTATION_EDEFAULT);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION:
				setVerifierAnnotation(VERIFIER_ANNOTATION_EDEFAULT);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION:
				setAttestatorAnnotation(ATTESTATOR_ANNOTATION_EDEFAULT);
				return;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__TOOL_COMMAND:
				setToolCommand(TOOL_COMMAND_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_INSTANTIATION:
				return protectionInstantiation != null;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__APPLICATION_PART:
				return applicationPart != null;
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__PROTECTION_OBJECTIVES:
				return protectionObjectives != null && !protectionObjectives.isEmpty();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTACK_MITIGATIONS:
				return attackMitigations != null && !attackMitigations.isEmpty();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__SECOND_LEVEL_MOTIVATION:
				return secondLevelMotivation != null && !secondLevelMotivation.isEmpty();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__VARIABLE_ANNOTATION:
				return VARIABLE_ANNOTATION_EDEFAULT == null ? variableAnnotation != null : !VARIABLE_ANNOTATION_EDEFAULT.equals(variableAnnotation);
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__CODE_ANNOTATION:
				return CODE_ANNOTATION_EDEFAULT == null ? codeAnnotation != null : !CODE_ANNOTATION_EDEFAULT.equals(codeAnnotation);
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__VERIFIER_ANNOTATION:
				return VERIFIER_ANNOTATION_EDEFAULT == null ? verifierAnnotation != null : !VERIFIER_ANNOTATION_EDEFAULT.equals(verifierAnnotation);
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__ATTESTATOR_ANNOTATION:
				return ATTESTATOR_ANNOTATION_EDEFAULT == null ? attestatorAnnotation != null : !ATTESTATOR_ANNOTATION_EDEFAULT.equals(attestatorAnnotation);
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION__TOOL_COMMAND:
				return TOOL_COMMAND_EDEFAULT == null ? toolCommand != null : !TOOL_COMMAND_EDEFAULT.equals(toolCommand);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION___TO_STRING:
				return toString();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION___HASH_CODE:
				return hashCode();
			case KbPackage.APPLIED_PROTECTION_INSTANTIATION___EQUALS__OBJECT:
				return equals(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //AppliedProtectionInstantiationImpl

/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.AttackStepProbability;
import it.polito.security.esp.kb.AttackStepType;
import it.polito.security.esp.kb.AttackerToolType;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attack Step Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackStepTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackStepTypeImpl#getRegex <em>Regex</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackStepTypeImpl#getAttackerTools <em>Attacker Tools</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackStepTypeImpl#getProbabilities <em>Probabilities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttackStepTypeImpl extends MinimalEObjectImpl.Container implements AttackStepType
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRegex() <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegex()
	 * @generated
	 * @ordered
	 */
	protected static final String REGEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegex() <em>Regex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegex()
	 * @generated
	 * @ordered
	 */
	protected String regex = REGEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttackerTools() <em>Attacker Tools</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackerTools()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackerToolType> attackerTools;

	/**
	 * The cached value of the '{@link #getProbabilities() <em>Probabilities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbabilities()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackStepProbability> probabilities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackStepTypeImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return KbPackage.Literals.ATTACK_STEP_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_STEP_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegex()
	{
		return regex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegex(String newRegex)
	{
		String oldRegex = regex;
		regex = newRegex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_STEP_TYPE__REGEX, oldRegex, regex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackerToolType> getAttackerTools()
	{
		if (attackerTools == null)
		{
			attackerTools = new EObjectResolvingEList<AttackerToolType>(AttackerToolType.class, this, KbPackage.ATTACK_STEP_TYPE__ATTACKER_TOOLS);
		}
		return attackerTools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackStepProbability> getProbabilities()
	{
		if (probabilities == null)
		{
			probabilities = new EObjectResolvingEList<AttackStepProbability>(AttackStepProbability.class, this, KbPackage.ATTACK_STEP_TYPE__PROBABILITIES);
		}
		return probabilities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		int _hashCode = this.getName().hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean equals(final Object object)
	{
		boolean _equals = Objects.equal(object, null);
		if (_equals)
		{
			return false;
		}
		else
		{
			if ((object instanceof AttackStepType))
			{
				String _name = this.getName();
				String _name_1 = ((AttackStepType)object).getName();
				return Objects.equal(_name, _name_1);
			}
			else
			{
				return false;
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString()
	{
		return this.getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case KbPackage.ATTACK_STEP_TYPE__NAME:
				return getName();
			case KbPackage.ATTACK_STEP_TYPE__REGEX:
				return getRegex();
			case KbPackage.ATTACK_STEP_TYPE__ATTACKER_TOOLS:
				return getAttackerTools();
			case KbPackage.ATTACK_STEP_TYPE__PROBABILITIES:
				return getProbabilities();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case KbPackage.ATTACK_STEP_TYPE__NAME:
				setName((String)newValue);
				return;
			case KbPackage.ATTACK_STEP_TYPE__REGEX:
				setRegex((String)newValue);
				return;
			case KbPackage.ATTACK_STEP_TYPE__ATTACKER_TOOLS:
				getAttackerTools().clear();
				getAttackerTools().addAll((Collection<? extends AttackerToolType>)newValue);
				return;
			case KbPackage.ATTACK_STEP_TYPE__PROBABILITIES:
				getProbabilities().clear();
				getProbabilities().addAll((Collection<? extends AttackStepProbability>)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case KbPackage.ATTACK_STEP_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case KbPackage.ATTACK_STEP_TYPE__REGEX:
				setRegex(REGEX_EDEFAULT);
				return;
			case KbPackage.ATTACK_STEP_TYPE__ATTACKER_TOOLS:
				getAttackerTools().clear();
				return;
			case KbPackage.ATTACK_STEP_TYPE__PROBABILITIES:
				getProbabilities().clear();
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case KbPackage.ATTACK_STEP_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KbPackage.ATTACK_STEP_TYPE__REGEX:
				return REGEX_EDEFAULT == null ? regex != null : !REGEX_EDEFAULT.equals(regex);
			case KbPackage.ATTACK_STEP_TYPE__ATTACKER_TOOLS:
				return attackerTools != null && !attackerTools.isEmpty();
			case KbPackage.ATTACK_STEP_TYPE__PROBABILITIES:
				return probabilities != null && !probabilities.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
	{
		switch (operationID)
		{
			case KbPackage.ATTACK_STEP_TYPE___HASH_CODE:
				return hashCode();
			case KbPackage.ATTACK_STEP_TYPE___EQUALS__OBJECT:
				return equals(arguments.get(0));
			case KbPackage.ATTACK_STEP_TYPE___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AttackStepTypeImpl

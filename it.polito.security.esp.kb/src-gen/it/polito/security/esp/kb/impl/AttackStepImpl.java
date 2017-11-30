/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.AttackStep;
import it.polito.security.esp.kb.AttackStepType;
import it.polito.security.esp.kb.KbPackage;

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
 * An implementation of the model object '<em><b>Attack Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackStepImpl#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackStepImpl#getType <em>Type</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackStepImpl#getApplicationParts <em>Application Parts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttackStepImpl extends MinimalEObjectImpl.Container implements AttackStep
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final AttackStepType TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected AttackStepType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getApplicationParts() <em>Application Parts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationPart> applicationParts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackStepImpl()
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
		return KbPackage.Literals.ATTACK_STEP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_STEP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackStepType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(AttackStepType newType)
	{
		AttackStepType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_STEP__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPart> getApplicationParts()
	{
		if (applicationParts == null)
		{
			applicationParts = new EObjectResolvingEList<ApplicationPart>(ApplicationPart.class, this, KbPackage.ATTACK_STEP__APPLICATION_PARTS);
		}
		return applicationParts;
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
		if ((object == null))
		{
			return false;
		}
		else
		{
			if ((object instanceof AttackStep))
			{
				String _name = this.getName();
				String _name_1 = ((AttackStep)object).getName();
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
			case KbPackage.ATTACK_STEP__NAME:
				return getName();
			case KbPackage.ATTACK_STEP__TYPE:
				return getType();
			case KbPackage.ATTACK_STEP__APPLICATION_PARTS:
				return getApplicationParts();
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
			case KbPackage.ATTACK_STEP__NAME:
				setName((String)newValue);
				return;
			case KbPackage.ATTACK_STEP__TYPE:
				setType((AttackStepType)newValue);
				return;
			case KbPackage.ATTACK_STEP__APPLICATION_PARTS:
				getApplicationParts().clear();
				getApplicationParts().addAll((Collection<? extends ApplicationPart>)newValue);
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
			case KbPackage.ATTACK_STEP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case KbPackage.ATTACK_STEP__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case KbPackage.ATTACK_STEP__APPLICATION_PARTS:
				getApplicationParts().clear();
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
			case KbPackage.ATTACK_STEP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KbPackage.ATTACK_STEP__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case KbPackage.ATTACK_STEP__APPLICATION_PARTS:
				return applicationParts != null && !applicationParts.isEmpty();
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
			case KbPackage.ATTACK_STEP___HASH_CODE:
				return hashCode();
			case KbPackage.ATTACK_STEP___EQUALS__OBJECT:
				return equals(arguments.get(0));
			case KbPackage.ATTACK_STEP___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AttackStepImpl

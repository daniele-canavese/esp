/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.AttackMitigation;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.AttackStepType;
import it.polito.security.esp.kb.Level;
import it.polito.security.esp.kb.Protection;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attack Mitigation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackMitigationImpl#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackMitigationImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackMitigationImpl#getType <em>Type</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackMitigationImpl#getAttackPaths <em>Attack Paths</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackMitigationImpl#getProtection <em>Protection</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttackMitigationImpl extends MinimalEObjectImpl.Container implements AttackMitigation
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
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final Level LEVEL_EDEFAULT = Level.HIGH;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected Level level = LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected AttackStepType type;

	/**
	 * The cached value of the '{@link #getAttackPaths() <em>Attack Paths</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackPath> attackPaths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackMitigationImpl()
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
		return KbPackage.Literals.ATTACK_MITIGATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_MITIGATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getLevel()
	{
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(Level newLevel)
	{
		Level oldLevel = level;
		level = newLevel == null ? LEVEL_EDEFAULT : newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_MITIGATION__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackStepType getType()
	{
		if (type != null && type.eIsProxy())
		{
			InternalEObject oldType = (InternalEObject)type;
			type = (AttackStepType)eResolveProxy(oldType);
			if (type != oldType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KbPackage.ATTACK_MITIGATION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackStepType basicGetType()
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
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_MITIGATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackPath> getAttackPaths()
	{
		if (attackPaths == null)
		{
			attackPaths = new EObjectResolvingEList<AttackPath>(AttackPath.class, this, KbPackage.ATTACK_MITIGATION__ATTACK_PATHS);
		}
		return attackPaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protection getProtection()
	{
		if (eContainerFeatureID() != KbPackage.ATTACK_MITIGATION__PROTECTION) return null;
		return (Protection)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protection basicGetProtection()
	{
		if (eContainerFeatureID() != KbPackage.ATTACK_MITIGATION__PROTECTION) return null;
		return (Protection)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProtection(Protection newProtection, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newProtection, KbPackage.ATTACK_MITIGATION__PROTECTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtection(Protection newProtection)
	{
		if (newProtection != eInternalContainer() || (eContainerFeatureID() != KbPackage.ATTACK_MITIGATION__PROTECTION && newProtection != null))
		{
			if (EcoreUtil.isAncestor(this, newProtection))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProtection != null)
				msgs = ((InternalEObject)newProtection).eInverseAdd(this, KbPackage.PROTECTION__MITIGATIONS, Protection.class, msgs);
			msgs = basicSetProtection(newProtection, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_MITIGATION__PROTECTION, newProtection, newProtection));
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
			if ((object instanceof AttackMitigation))
			{
				String _name = this.getName();
				String _name_1 = ((AttackMitigation)object).getName();
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
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case KbPackage.ATTACK_MITIGATION__PROTECTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetProtection((Protection)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case KbPackage.ATTACK_MITIGATION__PROTECTION:
				return basicSetProtection(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case KbPackage.ATTACK_MITIGATION__PROTECTION:
				return eInternalContainer().eInverseRemove(this, KbPackage.PROTECTION__MITIGATIONS, Protection.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case KbPackage.ATTACK_MITIGATION__NAME:
				return getName();
			case KbPackage.ATTACK_MITIGATION__LEVEL:
				return getLevel();
			case KbPackage.ATTACK_MITIGATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case KbPackage.ATTACK_MITIGATION__ATTACK_PATHS:
				return getAttackPaths();
			case KbPackage.ATTACK_MITIGATION__PROTECTION:
				if (resolve) return getProtection();
				return basicGetProtection();
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
			case KbPackage.ATTACK_MITIGATION__NAME:
				setName((String)newValue);
				return;
			case KbPackage.ATTACK_MITIGATION__LEVEL:
				setLevel((Level)newValue);
				return;
			case KbPackage.ATTACK_MITIGATION__TYPE:
				setType((AttackStepType)newValue);
				return;
			case KbPackage.ATTACK_MITIGATION__ATTACK_PATHS:
				getAttackPaths().clear();
				getAttackPaths().addAll((Collection<? extends AttackPath>)newValue);
				return;
			case KbPackage.ATTACK_MITIGATION__PROTECTION:
				setProtection((Protection)newValue);
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
			case KbPackage.ATTACK_MITIGATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case KbPackage.ATTACK_MITIGATION__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case KbPackage.ATTACK_MITIGATION__TYPE:
				setType((AttackStepType)null);
				return;
			case KbPackage.ATTACK_MITIGATION__ATTACK_PATHS:
				getAttackPaths().clear();
				return;
			case KbPackage.ATTACK_MITIGATION__PROTECTION:
				setProtection((Protection)null);
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
			case KbPackage.ATTACK_MITIGATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KbPackage.ATTACK_MITIGATION__LEVEL:
				return level != LEVEL_EDEFAULT;
			case KbPackage.ATTACK_MITIGATION__TYPE:
				return type != null;
			case KbPackage.ATTACK_MITIGATION__ATTACK_PATHS:
				return attackPaths != null && !attackPaths.isEmpty();
			case KbPackage.ATTACK_MITIGATION__PROTECTION:
				return basicGetProtection() != null;
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
			case KbPackage.ATTACK_MITIGATION___HASH_CODE:
				return hashCode();
			case KbPackage.ATTACK_MITIGATION___EQUALS__OBJECT:
				return equals(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", level: ");
		result.append(level);
		result.append(')');
		return result.toString();
	}

} //AttackMitigationImpl

/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.SecondLevelMotivation;
import it.polito.security.esp.kb.SecondLevelMotivationType;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Second Level Motivation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.SecondLevelMotivationImpl#getMotivationType <em>Motivation Type</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.SecondLevelMotivationImpl#getFirstLevelAppliedProtectionInstantiations <em>First Level Applied Protection Instantiations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecondLevelMotivationImpl extends MinimalEObjectImpl.Container implements SecondLevelMotivation
{
	/**
	 * The default value of the '{@link #getMotivationType() <em>Motivation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMotivationType()
	 * @generated
	 * @ordered
	 */
	protected static final SecondLevelMotivationType MOTIVATION_TYPE_EDEFAULT = SecondLevelMotivationType.KEPT;

	/**
	 * The cached value of the '{@link #getMotivationType() <em>Motivation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMotivationType()
	 * @generated
	 * @ordered
	 */
	protected SecondLevelMotivationType motivationType = MOTIVATION_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFirstLevelAppliedProtectionInstantiations() <em>First Level Applied Protection Instantiations</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstLevelAppliedProtectionInstantiations()
	 * @generated
	 * @ordered
	 */
	protected AppliedProtectionInstantiation firstLevelAppliedProtectionInstantiations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SecondLevelMotivationImpl()
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
		return KbPackage.Literals.SECOND_LEVEL_MOTIVATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecondLevelMotivationType getMotivationType()
	{
		return motivationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMotivationType(SecondLevelMotivationType newMotivationType)
	{
		SecondLevelMotivationType oldMotivationType = motivationType;
		motivationType = newMotivationType == null ? MOTIVATION_TYPE_EDEFAULT : newMotivationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SECOND_LEVEL_MOTIVATION__MOTIVATION_TYPE, oldMotivationType, motivationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppliedProtectionInstantiation getFirstLevelAppliedProtectionInstantiations()
	{
		if (firstLevelAppliedProtectionInstantiations != null && firstLevelAppliedProtectionInstantiations.eIsProxy())
		{
			InternalEObject oldFirstLevelAppliedProtectionInstantiations = (InternalEObject)firstLevelAppliedProtectionInstantiations;
			firstLevelAppliedProtectionInstantiations = (AppliedProtectionInstantiation)eResolveProxy(oldFirstLevelAppliedProtectionInstantiations);
			if (firstLevelAppliedProtectionInstantiations != oldFirstLevelAppliedProtectionInstantiations)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KbPackage.SECOND_LEVEL_MOTIVATION__FIRST_LEVEL_APPLIED_PROTECTION_INSTANTIATIONS, oldFirstLevelAppliedProtectionInstantiations, firstLevelAppliedProtectionInstantiations));
			}
		}
		return firstLevelAppliedProtectionInstantiations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppliedProtectionInstantiation basicGetFirstLevelAppliedProtectionInstantiations()
	{
		return firstLevelAppliedProtectionInstantiations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstLevelAppliedProtectionInstantiations(AppliedProtectionInstantiation newFirstLevelAppliedProtectionInstantiations)
	{
		AppliedProtectionInstantiation oldFirstLevelAppliedProtectionInstantiations = firstLevelAppliedProtectionInstantiations;
		firstLevelAppliedProtectionInstantiations = newFirstLevelAppliedProtectionInstantiations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.SECOND_LEVEL_MOTIVATION__FIRST_LEVEL_APPLIED_PROTECTION_INSTANTIATIONS, oldFirstLevelAppliedProtectionInstantiations, firstLevelAppliedProtectionInstantiations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString()
	{
		AppliedProtectionInstantiation _firstLevelAppliedProtectionInstantiations = this.getFirstLevelAppliedProtectionInstantiations();
		boolean _notEquals = (!Objects.equal(_firstLevelAppliedProtectionInstantiations, null));
		if (_notEquals)
		{
			String _string = this.getMotivationType().toString();
			String _plus = (_string + " ");
			String _string_1 = this.getFirstLevelAppliedProtectionInstantiations().toString();
			return (_plus + _string_1);
		}
		else
		{
			return this.getMotivationType().toString();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		int _hashCode = this.getMotivationType().hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		AppliedProtectionInstantiation _firstLevelAppliedProtectionInstantiations = this.getFirstLevelAppliedProtectionInstantiations();
		boolean _notEquals = (!Objects.equal(_firstLevelAppliedProtectionInstantiations, null));
		if (_notEquals)
		{
			int _hashCode_1 = this.getFirstLevelAppliedProtectionInstantiations().hashCode();
			int _plus_1 = ((31 * result) + _hashCode_1);
			result = _plus_1;
		}
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
			if ((object instanceof SecondLevelMotivation))
			{
				return (Objects.equal(this.getMotivationType(), ((SecondLevelMotivation)object).getMotivationType()) && 
					EcoreUtil.equals(this.getFirstLevelAppliedProtectionInstantiations(), ((SecondLevelMotivation)object).getFirstLevelAppliedProtectionInstantiations()));
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
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case KbPackage.SECOND_LEVEL_MOTIVATION__MOTIVATION_TYPE:
				return getMotivationType();
			case KbPackage.SECOND_LEVEL_MOTIVATION__FIRST_LEVEL_APPLIED_PROTECTION_INSTANTIATIONS:
				if (resolve) return getFirstLevelAppliedProtectionInstantiations();
				return basicGetFirstLevelAppliedProtectionInstantiations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case KbPackage.SECOND_LEVEL_MOTIVATION__MOTIVATION_TYPE:
				setMotivationType((SecondLevelMotivationType)newValue);
				return;
			case KbPackage.SECOND_LEVEL_MOTIVATION__FIRST_LEVEL_APPLIED_PROTECTION_INSTANTIATIONS:
				setFirstLevelAppliedProtectionInstantiations((AppliedProtectionInstantiation)newValue);
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
			case KbPackage.SECOND_LEVEL_MOTIVATION__MOTIVATION_TYPE:
				setMotivationType(MOTIVATION_TYPE_EDEFAULT);
				return;
			case KbPackage.SECOND_LEVEL_MOTIVATION__FIRST_LEVEL_APPLIED_PROTECTION_INSTANTIATIONS:
				setFirstLevelAppliedProtectionInstantiations((AppliedProtectionInstantiation)null);
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
			case KbPackage.SECOND_LEVEL_MOTIVATION__MOTIVATION_TYPE:
				return motivationType != MOTIVATION_TYPE_EDEFAULT;
			case KbPackage.SECOND_LEVEL_MOTIVATION__FIRST_LEVEL_APPLIED_PROTECTION_INSTANTIATIONS:
				return firstLevelAppliedProtectionInstantiations != null;
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
			case KbPackage.SECOND_LEVEL_MOTIVATION___TO_STRING:
				return toString();
			case KbPackage.SECOND_LEVEL_MOTIVATION___HASH_CODE:
				return hashCode();
			case KbPackage.SECOND_LEVEL_MOTIVATION___EQUALS__OBJECT:
				return equals(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //SecondLevelMotivationImpl

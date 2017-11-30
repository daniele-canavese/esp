/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.ActionType;
import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartSet;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Part Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartSetImpl#getApplicationParts <em>Application Parts</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartSetImpl#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationPartSetImpl extends MinimalEObjectImpl.Container implements ApplicationPartSet
{
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
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final ActionType ACTION_EDEFAULT = ActionType.DECRYPT_AES128_CBC;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected ActionType action = ACTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationPartSetImpl()
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
		return KbPackage.Literals.APPLICATION_PART_SET;
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
			applicationParts = new EObjectWithInverseResolvingEList.ManyInverse<ApplicationPart>(ApplicationPart.class, this, KbPackage.APPLICATION_PART_SET__APPLICATION_PARTS, KbPackage.APPLICATION_PART__SETS);
		}
		return applicationParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionType getAction()
	{
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(ActionType newAction)
	{
		ActionType oldAction = action;
		action = newAction == null ? ACTION_EDEFAULT : newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART_SET__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		int _hashCode = this.getAction().toString().hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		int r = 0;
		EList<ApplicationPart> _applicationParts = this.getApplicationParts();
		for (final ApplicationPart i : _applicationParts)
		{
			int _r = r;
			int _hashCode_1 = i.hashCode();
			r = (_r + _hashCode_1);
		}
		result = ((31 * result) + r);
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
			if ((object instanceof ApplicationPartSet))
			{
				return (Objects.equal(this.getAction(), ((ApplicationPartSet)object).getAction()) && EcoreUtil.equals(this.getApplicationParts(), ((ApplicationPartSet)object).getApplicationParts()));
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case KbPackage.APPLICATION_PART_SET__APPLICATION_PARTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getApplicationParts()).basicAdd(otherEnd, msgs);
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
			case KbPackage.APPLICATION_PART_SET__APPLICATION_PARTS:
				return ((InternalEList<?>)getApplicationParts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case KbPackage.APPLICATION_PART_SET__APPLICATION_PARTS:
				return getApplicationParts();
			case KbPackage.APPLICATION_PART_SET__ACTION:
				return getAction();
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
			case KbPackage.APPLICATION_PART_SET__APPLICATION_PARTS:
				getApplicationParts().clear();
				getApplicationParts().addAll((Collection<? extends ApplicationPart>)newValue);
				return;
			case KbPackage.APPLICATION_PART_SET__ACTION:
				setAction((ActionType)newValue);
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
			case KbPackage.APPLICATION_PART_SET__APPLICATION_PARTS:
				getApplicationParts().clear();
				return;
			case KbPackage.APPLICATION_PART_SET__ACTION:
				setAction(ACTION_EDEFAULT);
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
			case KbPackage.APPLICATION_PART_SET__APPLICATION_PARTS:
				return applicationParts != null && !applicationParts.isEmpty();
			case KbPackage.APPLICATION_PART_SET__ACTION:
				return action != ACTION_EDEFAULT;
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
			case KbPackage.APPLICATION_PART_SET___HASH_CODE:
				return hashCode();
			case KbPackage.APPLICATION_PART_SET___EQUALS__OBJECT:
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
		result.append(" (action: ");
		result.append(action);
		result.append(')');
		return result.toString();
	}

} //ApplicationPartSetImpl

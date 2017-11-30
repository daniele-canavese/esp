/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.SolutionSequence;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.SolutionSequenceImpl#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionSequenceImpl extends MinimalEObjectImpl.Container implements SolutionSequence
{
	/**
	 * The cached value of the '{@link #getAppliedProtectionInstantiations() <em>Applied Protection Instantiations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliedProtectionInstantiations()
	 * @generated
	 * @ordered
	 */
	protected EList<AppliedProtectionInstantiation> appliedProtectionInstantiations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionSequenceImpl()
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
		return KbPackage.Literals.SOLUTION_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AppliedProtectionInstantiation> getAppliedProtectionInstantiations()
	{
		if (appliedProtectionInstantiations == null)
		{
			appliedProtectionInstantiations = new EObjectResolvingEList<AppliedProtectionInstantiation>(AppliedProtectionInstantiation.class, this, KbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS);
		}
		return appliedProtectionInstantiations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString()
	{
		return this.getAppliedProtectionInstantiations().toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		int _hashCode = this.getAppliedProtectionInstantiations().hashCode();
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
			if ((object instanceof SolutionSequence))
			{
				return EcoreUtil.equals(this.getAppliedProtectionInstantiations(), ((SolutionSequence)object).getAppliedProtectionInstantiations());
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
			case KbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS:
				return getAppliedProtectionInstantiations();
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
			case KbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS:
				getAppliedProtectionInstantiations().clear();
				getAppliedProtectionInstantiations().addAll((Collection<? extends AppliedProtectionInstantiation>)newValue);
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
			case KbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS:
				getAppliedProtectionInstantiations().clear();
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
			case KbPackage.SOLUTION_SEQUENCE__APPLIED_PROTECTION_INSTANTIATIONS:
				return appliedProtectionInstantiations != null && !appliedProtectionInstantiations.isEmpty();
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
			case KbPackage.SOLUTION_SEQUENCE___TO_STRING:
				return toString();
			case KbPackage.SOLUTION_SEQUENCE___HASH_CODE:
				return hashCode();
			case KbPackage.SOLUTION_SEQUENCE___EQUALS__OBJECT:
				return equals(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //SolutionSequenceImpl

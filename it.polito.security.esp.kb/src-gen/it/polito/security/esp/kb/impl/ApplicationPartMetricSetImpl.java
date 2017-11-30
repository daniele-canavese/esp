/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartMetricSet;
import it.polito.security.esp.kb.Metric;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

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
 * An implementation of the model object '<em><b>Application Part Metric Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartMetricSetImpl#getApplicationPart <em>Application Part</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartMetricSetImpl#getMetrics <em>Metrics</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationPartMetricSetImpl extends MinimalEObjectImpl.Container implements ApplicationPartMetricSet
{
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
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<Metric> metrics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationPartMetricSetImpl()
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
		return KbPackage.Literals.APPLICATION_PART_METRIC_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart getApplicationPart()
	{
		if (applicationPart != null && applicationPart.eIsProxy())
		{
			InternalEObject oldApplicationPart = (InternalEObject)applicationPart;
			applicationPart = (ApplicationPart)eResolveProxy(oldApplicationPart);
			if (applicationPart != oldApplicationPart)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, KbPackage.APPLICATION_PART_METRIC_SET__APPLICATION_PART, oldApplicationPart, applicationPart));
			}
		}
		return applicationPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart basicGetApplicationPart()
	{
		return applicationPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationPart(ApplicationPart newApplicationPart)
	{
		ApplicationPart oldApplicationPart = applicationPart;
		applicationPart = newApplicationPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART_METRIC_SET__APPLICATION_PART, oldApplicationPart, applicationPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Metric> getMetrics()
	{
		if (metrics == null)
		{
			metrics = new EObjectResolvingEList<Metric>(Metric.class, this, KbPackage.APPLICATION_PART_METRIC_SET__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		int _hashCode = this.getApplicationPart().hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		int r = 0;
		EList<Metric> _metrics = this.getMetrics();
		for (final Metric i : _metrics)
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
			if ((object instanceof ApplicationPartMetricSet))
			{
				return (EcoreUtil.equals(this.getApplicationPart(), ((ApplicationPartMetricSet)object).getApplicationPart()) && EcoreUtil.equals(this.getMetrics(), ((ApplicationPartMetricSet)object).getMetrics()));
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
			case KbPackage.APPLICATION_PART_METRIC_SET__APPLICATION_PART:
				if (resolve) return getApplicationPart();
				return basicGetApplicationPart();
			case KbPackage.APPLICATION_PART_METRIC_SET__METRICS:
				return getMetrics();
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
			case KbPackage.APPLICATION_PART_METRIC_SET__APPLICATION_PART:
				setApplicationPart((ApplicationPart)newValue);
				return;
			case KbPackage.APPLICATION_PART_METRIC_SET__METRICS:
				getMetrics().clear();
				getMetrics().addAll((Collection<? extends Metric>)newValue);
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
			case KbPackage.APPLICATION_PART_METRIC_SET__APPLICATION_PART:
				setApplicationPart((ApplicationPart)null);
				return;
			case KbPackage.APPLICATION_PART_METRIC_SET__METRICS:
				getMetrics().clear();
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
			case KbPackage.APPLICATION_PART_METRIC_SET__APPLICATION_PART:
				return applicationPart != null;
			case KbPackage.APPLICATION_PART_METRIC_SET__METRICS:
				return metrics != null && !metrics.isEmpty();
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
			case KbPackage.APPLICATION_PART_METRIC_SET___HASH_CODE:
				return hashCode();
			case KbPackage.APPLICATION_PART_METRIC_SET___EQUALS__OBJECT:
				return equals(arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ApplicationPartMetricSetImpl

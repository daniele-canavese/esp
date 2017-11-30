/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.AttackStepProbability;
import it.polito.security.esp.kb.ExpertiseLevel;
import it.polito.security.esp.kb.Level;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attack Step Probability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackStepProbabilityImpl#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackStepProbabilityImpl#getExpertise <em>Expertise</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackStepProbabilityImpl#getProbability <em>Probability</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttackStepProbabilityImpl extends MinimalEObjectImpl.Container implements AttackStepProbability
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
	 * The default value of the '{@link #getExpertise() <em>Expertise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpertise()
	 * @generated
	 * @ordered
	 */
	protected static final ExpertiseLevel EXPERTISE_EDEFAULT = ExpertiseLevel.AMATEUR;

	/**
	 * The cached value of the '{@link #getExpertise() <em>Expertise</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpertise()
	 * @generated
	 * @ordered
	 */
	protected ExpertiseLevel expertise = EXPERTISE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected static final Level PROBABILITY_EDEFAULT = Level.HIGH;

	/**
	 * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected Level probability = PROBABILITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackStepProbabilityImpl()
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
		return KbPackage.Literals.ATTACK_STEP_PROBABILITY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_STEP_PROBABILITY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpertiseLevel getExpertise()
	{
		return expertise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpertise(ExpertiseLevel newExpertise)
	{
		ExpertiseLevel oldExpertise = expertise;
		expertise = newExpertise == null ? EXPERTISE_EDEFAULT : newExpertise;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_STEP_PROBABILITY__EXPERTISE, oldExpertise, expertise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getProbability()
	{
		return probability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbability(Level newProbability)
	{
		Level oldProbability = probability;
		probability = newProbability == null ? PROBABILITY_EDEFAULT : newProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_STEP_PROBABILITY__PROBABILITY, oldProbability, probability));
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
			if ((object instanceof AttackStepProbability))
			{
				String _name = this.getName();
				String _name_1 = ((AttackStepProbability)object).getName();
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
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case KbPackage.ATTACK_STEP_PROBABILITY__NAME:
				return getName();
			case KbPackage.ATTACK_STEP_PROBABILITY__EXPERTISE:
				return getExpertise();
			case KbPackage.ATTACK_STEP_PROBABILITY__PROBABILITY:
				return getProbability();
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
			case KbPackage.ATTACK_STEP_PROBABILITY__NAME:
				setName((String)newValue);
				return;
			case KbPackage.ATTACK_STEP_PROBABILITY__EXPERTISE:
				setExpertise((ExpertiseLevel)newValue);
				return;
			case KbPackage.ATTACK_STEP_PROBABILITY__PROBABILITY:
				setProbability((Level)newValue);
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
			case KbPackage.ATTACK_STEP_PROBABILITY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case KbPackage.ATTACK_STEP_PROBABILITY__EXPERTISE:
				setExpertise(EXPERTISE_EDEFAULT);
				return;
			case KbPackage.ATTACK_STEP_PROBABILITY__PROBABILITY:
				setProbability(PROBABILITY_EDEFAULT);
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
			case KbPackage.ATTACK_STEP_PROBABILITY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KbPackage.ATTACK_STEP_PROBABILITY__EXPERTISE:
				return expertise != EXPERTISE_EDEFAULT;
			case KbPackage.ATTACK_STEP_PROBABILITY__PROBABILITY:
				return probability != PROBABILITY_EDEFAULT;
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
			case KbPackage.ATTACK_STEP_PROBABILITY___HASH_CODE:
				return hashCode();
			case KbPackage.ATTACK_STEP_PROBABILITY___EQUALS__OBJECT:
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
		result.append(", expertise: ");
		result.append(expertise);
		result.append(", probability: ");
		result.append(probability);
		result.append(')');
		return result.toString();
	}

} //AttackStepProbabilityImpl

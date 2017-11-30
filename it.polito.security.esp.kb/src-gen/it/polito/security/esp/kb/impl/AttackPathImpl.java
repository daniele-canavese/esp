/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.AppliedProtectionInstantiation;
import it.polito.security.esp.kb.AttackMitigation;
import it.polito.security.esp.kb.AttackPath;
import it.polito.security.esp.kb.AttackStep;
import it.polito.security.esp.kb.AttackerToolType;
import it.polito.security.esp.kb.Level;
import it.polito.security.esp.kb.ProtectionObjective;

import it.polito.security.esp.util.Strings;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Map.Entry;

import java.util.Set;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attack Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackPathImpl#getAttackSteps <em>Attack Steps</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackPathImpl#getProtectionObjectives <em>Protection Objectives</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackPathImpl#getAttackerToolTypes <em>Attacker Tool Types</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackPathImpl#getCost <em>Cost</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackPathImpl#getAppliedProtectionInstantiations <em>Applied Protection Instantiations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackPathImpl#isKey <em>Key</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackPathImpl#getId <em>Id</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackPathImpl#getMitigations <em>Mitigations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.AttackPathImpl#getLevel <em>Level</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttackPathImpl extends MinimalEObjectImpl.Container implements AttackPath
{
	/**
	 * The cached value of the '{@link #getAttackSteps() <em>Attack Steps</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackStep> attackSteps;

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
	 * The cached value of the '{@link #getAttackerToolTypes() <em>Attacker Tool Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackerToolTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackerToolType> attackerToolTypes;

	/**
	 * The default value of the '{@link #getCost() <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCost()
	 * @generated
	 * @ordered
	 */
	protected static final double COST_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCost() <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCost()
	 * @generated
	 * @ordered
	 */
	protected double cost = COST_EDEFAULT;

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
	 * The default value of the '{@link #isKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKey()
	 * @generated
	 * @ordered
	 */
	protected static final boolean KEY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKey()
	 * @generated
	 * @ordered
	 */
	protected boolean key = KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;

	/**
	 * The default value of the '{@link #getMitigations() <em>Mitigations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMitigations()
	 * @generated
	 * @ordered
	 */
	protected static final String MITIGATIONS_EDEFAULT = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttackPathImpl()
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
		return KbPackage.Literals.ATTACK_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackStep> getAttackSteps()
	{
		if (attackSteps == null)
		{
			attackSteps = new EObjectResolvingEList<AttackStep>(AttackStep.class, this, KbPackage.ATTACK_PATH__ATTACK_STEPS);
		}
		return attackSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProtectionObjective> getProtectionObjectives()
	{
		if (protectionObjectives == null)
		{
			protectionObjectives = new EObjectResolvingEList<ProtectionObjective>(ProtectionObjective.class, this, KbPackage.ATTACK_PATH__PROTECTION_OBJECTIVES);
		}
		return protectionObjectives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackerToolType> getAttackerToolTypes()
	{
		if (attackerToolTypes == null)
		{
			attackerToolTypes = new EObjectResolvingEList<AttackerToolType>(AttackerToolType.class, this, KbPackage.ATTACK_PATH__ATTACKER_TOOL_TYPES);
		}
		return attackerToolTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCost()
	{
		return cost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCost(double newCost)
	{
		double oldCost = cost;
		cost = newCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_PATH__COST, oldCost, cost));
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
			appliedProtectionInstantiations = new EObjectResolvingEList<AppliedProtectionInstantiation>(AppliedProtectionInstantiation.class, this, KbPackage.ATTACK_PATH__APPLIED_PROTECTION_INSTANTIATIONS);
		}
		return appliedProtectionInstantiations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isKey()
	{
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(boolean newKey)
	{
		boolean oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.ATTACK_PATH__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getId()
	{
		int _hashCode = this.hashCode();
		return (((long) _hashCode) + (-((long) Integer.MIN_VALUE)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMitigations()
	{
		HashMap<AppliedProtectionInstantiation, Level> map = new HashMap<AppliedProtectionInstantiation, Level>();
		EList<AppliedProtectionInstantiation> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();
		for (final AppliedProtectionInstantiation i : _appliedProtectionInstantiations)
		{
			EList<AttackMitigation> _attackMitigations = i.getAttackMitigations();
			for (final AttackMitigation j : _attackMitigations)
			{
				boolean _contains = j.getAttackPaths().contains(this);
				if (_contains)
				{
					boolean _containsKey = map.containsKey(i);
					boolean _not = (!_containsKey);
					if (_not)
					{
						map.put(i, j.getLevel());
					}
					else
					{
						Level _get = map.get(i);
						boolean _equals = Objects.equal(_get, Level.LOW);
						if (_equals)
						{
							map.put(i, j.getLevel());
						}
						else
						{
							if ((Objects.equal(map.get(i), Level.MEDIUM) && Objects.equal(j.getLevel(), Level.HIGH)))
							{
								map.put(i, j.getLevel());
							}
						}
					}
				}
			}
		}
		HashSet<String> values = new HashSet<String>();
		Set<Entry<AppliedProtectionInstantiation, Level>> _entrySet = map.entrySet();
		for (final Entry<AppliedProtectionInstantiation, Level> i_1 : _entrySet)
		{
			AppliedProtectionInstantiation _key = i_1.getKey();
			String _plus = (_key + " (");
			Level _value = i_1.getValue();
			String _plus_1 = (_plus + _value);
			String _plus_2 = (_plus_1 + ")");
			values.add(_plus_2);
		}
		return Strings.join(values, "\n");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getLevel()
	{
		Level level = Level.NONE;
		EList<AppliedProtectionInstantiation> _appliedProtectionInstantiations = this.getAppliedProtectionInstantiations();
		for (final AppliedProtectionInstantiation i : _appliedProtectionInstantiations)
		{
			EList<AttackMitigation> _attackMitigations = i.getAttackMitigations();
			for (final AttackMitigation j : _attackMitigations)
			{
				boolean _contains = j.getAttackPaths().contains(this);
				if (_contains)
				{
					if ((Objects.equal(level, Level.NONE) || Objects.equal(level, Level.LOW)))
					{
						level = j.getLevel();
					}
					else
					{
						if ((Objects.equal(level, Level.MEDIUM) && Objects.equal(j.getLevel(), Level.HIGH)))
						{
							level = j.getLevel();
						}
					}
				}
			}
		}
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		int _hashCode = this.getAttackSteps().hashCode();
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
			if ((object instanceof AttackPath))
			{
				return EcoreUtil.equals(this.getAttackSteps(), ((AttackPath)object).getAttackSteps());
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
		int _hashCode = this.hashCode();
		return ("attack path " + Integer.valueOf(_hashCode));
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
			case KbPackage.ATTACK_PATH__ATTACK_STEPS:
				return getAttackSteps();
			case KbPackage.ATTACK_PATH__PROTECTION_OBJECTIVES:
				return getProtectionObjectives();
			case KbPackage.ATTACK_PATH__ATTACKER_TOOL_TYPES:
				return getAttackerToolTypes();
			case KbPackage.ATTACK_PATH__COST:
				return getCost();
			case KbPackage.ATTACK_PATH__APPLIED_PROTECTION_INSTANTIATIONS:
				return getAppliedProtectionInstantiations();
			case KbPackage.ATTACK_PATH__KEY:
				return isKey();
			case KbPackage.ATTACK_PATH__ID:
				return getId();
			case KbPackage.ATTACK_PATH__MITIGATIONS:
				return getMitigations();
			case KbPackage.ATTACK_PATH__LEVEL:
				return getLevel();
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
			case KbPackage.ATTACK_PATH__ATTACK_STEPS:
				getAttackSteps().clear();
				getAttackSteps().addAll((Collection<? extends AttackStep>)newValue);
				return;
			case KbPackage.ATTACK_PATH__PROTECTION_OBJECTIVES:
				getProtectionObjectives().clear();
				getProtectionObjectives().addAll((Collection<? extends ProtectionObjective>)newValue);
				return;
			case KbPackage.ATTACK_PATH__ATTACKER_TOOL_TYPES:
				getAttackerToolTypes().clear();
				getAttackerToolTypes().addAll((Collection<? extends AttackerToolType>)newValue);
				return;
			case KbPackage.ATTACK_PATH__COST:
				setCost((Double)newValue);
				return;
			case KbPackage.ATTACK_PATH__APPLIED_PROTECTION_INSTANTIATIONS:
				getAppliedProtectionInstantiations().clear();
				getAppliedProtectionInstantiations().addAll((Collection<? extends AppliedProtectionInstantiation>)newValue);
				return;
			case KbPackage.ATTACK_PATH__KEY:
				setKey((Boolean)newValue);
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
			case KbPackage.ATTACK_PATH__ATTACK_STEPS:
				getAttackSteps().clear();
				return;
			case KbPackage.ATTACK_PATH__PROTECTION_OBJECTIVES:
				getProtectionObjectives().clear();
				return;
			case KbPackage.ATTACK_PATH__ATTACKER_TOOL_TYPES:
				getAttackerToolTypes().clear();
				return;
			case KbPackage.ATTACK_PATH__COST:
				setCost(COST_EDEFAULT);
				return;
			case KbPackage.ATTACK_PATH__APPLIED_PROTECTION_INSTANTIATIONS:
				getAppliedProtectionInstantiations().clear();
				return;
			case KbPackage.ATTACK_PATH__KEY:
				setKey(KEY_EDEFAULT);
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
			case KbPackage.ATTACK_PATH__ATTACK_STEPS:
				return attackSteps != null && !attackSteps.isEmpty();
			case KbPackage.ATTACK_PATH__PROTECTION_OBJECTIVES:
				return protectionObjectives != null && !protectionObjectives.isEmpty();
			case KbPackage.ATTACK_PATH__ATTACKER_TOOL_TYPES:
				return attackerToolTypes != null && !attackerToolTypes.isEmpty();
			case KbPackage.ATTACK_PATH__COST:
				return cost != COST_EDEFAULT;
			case KbPackage.ATTACK_PATH__APPLIED_PROTECTION_INSTANTIATIONS:
				return appliedProtectionInstantiations != null && !appliedProtectionInstantiations.isEmpty();
			case KbPackage.ATTACK_PATH__KEY:
				return key != KEY_EDEFAULT;
			case KbPackage.ATTACK_PATH__ID:
				return getId() != ID_EDEFAULT;
			case KbPackage.ATTACK_PATH__MITIGATIONS:
				return MITIGATIONS_EDEFAULT == null ? getMitigations() != null : !MITIGATIONS_EDEFAULT.equals(getMitigations());
			case KbPackage.ATTACK_PATH__LEVEL:
				return getLevel() != LEVEL_EDEFAULT;
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
			case KbPackage.ATTACK_PATH___HASH_CODE:
				return hashCode();
			case KbPackage.ATTACK_PATH___EQUALS__OBJECT:
				return equals(arguments.get(0));
			case KbPackage.ATTACK_PATH___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AttackPathImpl

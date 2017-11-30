/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.ActionType;
import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.ApplicationPartType;
import it.polito.security.esp.kb.AttackMitigation;
import it.polito.security.esp.kb.AttackerToolType;
import it.polito.security.esp.kb.Level;
import it.polito.security.esp.kb.Property;
import it.polito.security.esp.kb.Protection;
import it.polito.security.esp.kb.ProtectionFlag;
import it.polito.security.esp.kb.ProtectionInstantiation;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getId <em>Id</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#isAutomaticallyDeployable <em>Automatically Deployable</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#isSecondLevel <em>Second Level</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getSecondLevelEnlargmentUsefulness <em>Second Level Enlargment Usefulness</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getSecondLevelCallGraphEnlargmentUsefulness <em>Second Level Call Graph Enlargment Usefulness</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getSecondLevelRepetitionUsefulness <em>Second Level Repetition Usefulness</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getSecondLevelRepetitionInstantiation <em>Second Level Repetition Instantiation</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getApplicationPartTypes <em>Application Part Types</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getMitigations <em>Mitigations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getEnforcedSecurityRequirements <em>Enforced Security Requirements</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getForbiddenPrecedences <em>Forbidden Precedences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getDiscouragedPrecedences <em>Discouraged Precedences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getEncouragedPrecedences <em>Encouraged Precedences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getActcPrecedences <em>Actc Precedences</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#isSingleton <em>Singleton</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getDefeatedAttackerToolTypes <em>Defeated Attacker Tool Types</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getBlockedAttackerToolTypes <em>Blocked Attacker Tool Types</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getInstantiations <em>Instantiations</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getFlags <em>Flags</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ProtectionImpl#getInstantiationsCount <em>Instantiations Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProtectionImpl extends MinimalEObjectImpl.Container implements Protection
{
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isAutomaticallyDeployable() <em>Automatically Deployable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutomaticallyDeployable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTOMATICALLY_DEPLOYABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutomaticallyDeployable() <em>Automatically Deployable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutomaticallyDeployable()
	 * @generated
	 * @ordered
	 */
	protected boolean automaticallyDeployable = AUTOMATICALLY_DEPLOYABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSecondLevel() <em>Second Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSecondLevel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SECOND_LEVEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSecondLevel() <em>Second Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSecondLevel()
	 * @generated
	 * @ordered
	 */
	protected boolean secondLevel = SECOND_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecondLevelEnlargmentUsefulness() <em>Second Level Enlargment Usefulness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLevelEnlargmentUsefulness()
	 * @generated
	 * @ordered
	 */
	protected static final Level SECOND_LEVEL_ENLARGMENT_USEFULNESS_EDEFAULT = Level.HIGH;

	/**
	 * The cached value of the '{@link #getSecondLevelEnlargmentUsefulness() <em>Second Level Enlargment Usefulness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLevelEnlargmentUsefulness()
	 * @generated
	 * @ordered
	 */
	protected Level secondLevelEnlargmentUsefulness = SECOND_LEVEL_ENLARGMENT_USEFULNESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecondLevelCallGraphEnlargmentUsefulness() <em>Second Level Call Graph Enlargment Usefulness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLevelCallGraphEnlargmentUsefulness()
	 * @generated
	 * @ordered
	 */
	protected static final Level SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS_EDEFAULT = Level.HIGH;

	/**
	 * The cached value of the '{@link #getSecondLevelCallGraphEnlargmentUsefulness() <em>Second Level Call Graph Enlargment Usefulness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLevelCallGraphEnlargmentUsefulness()
	 * @generated
	 * @ordered
	 */
	protected Level secondLevelCallGraphEnlargmentUsefulness = SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecondLevelRepetitionUsefulness() <em>Second Level Repetition Usefulness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLevelRepetitionUsefulness()
	 * @generated
	 * @ordered
	 */
	protected static final Level SECOND_LEVEL_REPETITION_USEFULNESS_EDEFAULT = Level.HIGH;

	/**
	 * The cached value of the '{@link #getSecondLevelRepetitionUsefulness() <em>Second Level Repetition Usefulness</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLevelRepetitionUsefulness()
	 * @generated
	 * @ordered
	 */
	protected Level secondLevelRepetitionUsefulness = SECOND_LEVEL_REPETITION_USEFULNESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSecondLevelRepetitionInstantiation() <em>Second Level Repetition Instantiation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondLevelRepetitionInstantiation()
	 * @generated
	 * @ordered
	 */
	protected EList<ProtectionInstantiation> secondLevelRepetitionInstantiation;

	/**
	 * The cached value of the '{@link #getApplicationPartTypes() <em>Application Part Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationPartTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationPartType> applicationPartTypes;

	/**
	 * The cached value of the '{@link #getMitigations() <em>Mitigations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMitigations()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackMitigation> mitigations;

	/**
	 * The cached value of the '{@link #getEnforcedSecurityRequirements() <em>Enforced Security Requirements</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnforcedSecurityRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> enforcedSecurityRequirements;

	/**
	 * The cached value of the '{@link #getForbiddenPrecedences() <em>Forbidden Precedences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForbiddenPrecedences()
	 * @generated
	 * @ordered
	 */
	protected EList<Protection> forbiddenPrecedences;

	/**
	 * The cached value of the '{@link #getDiscouragedPrecedences() <em>Discouraged Precedences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscouragedPrecedences()
	 * @generated
	 * @ordered
	 */
	protected EList<Protection> discouragedPrecedences;

	/**
	 * The cached value of the '{@link #getEncouragedPrecedences() <em>Encouraged Precedences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncouragedPrecedences()
	 * @generated
	 * @ordered
	 */
	protected EList<Protection> encouragedPrecedences;

	/**
	 * The cached value of the '{@link #getActcPrecedences() <em>Actc Precedences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActcPrecedences()
	 * @generated
	 * @ordered
	 */
	protected EList<Protection> actcPrecedences;

	/**
	 * The default value of the '{@link #isSingleton() <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSingleton()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SINGLETON_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSingleton() <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSingleton()
	 * @generated
	 * @ordered
	 */
	protected boolean singleton = SINGLETON_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefeatedAttackerToolTypes() <em>Defeated Attacker Tool Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefeatedAttackerToolTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackerToolType> defeatedAttackerToolTypes;

	/**
	 * The cached value of the '{@link #getBlockedAttackerToolTypes() <em>Blocked Attacker Tool Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockedAttackerToolTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttackerToolType> blockedAttackerToolTypes;

	/**
	 * The cached value of the '{@link #getInstantiations() <em>Instantiations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiations()
	 * @generated
	 * @ordered
	 */
	protected EList<ProtectionInstantiation> instantiations;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionType> actions;

	/**
	 * The cached value of the '{@link #getFlags() <em>Flags</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlags()
	 * @generated
	 * @ordered
	 */
	protected EList<ProtectionFlag> flags;

	/**
	 * The default value of the '{@link #getInstantiationsCount() <em>Instantiations Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiationsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int INSTANTIATIONS_COUNT_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProtectionImpl()
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
		return KbPackage.Literals.PROTECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId)
	{
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PROTECTION__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PROTECTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PROTECTION__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutomaticallyDeployable()
	{
		return automaticallyDeployable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutomaticallyDeployable(boolean newAutomaticallyDeployable)
	{
		boolean oldAutomaticallyDeployable = automaticallyDeployable;
		automaticallyDeployable = newAutomaticallyDeployable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PROTECTION__AUTOMATICALLY_DEPLOYABLE, oldAutomaticallyDeployable, automaticallyDeployable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSecondLevel()
	{
		return secondLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondLevel(boolean newSecondLevel)
	{
		boolean oldSecondLevel = secondLevel;
		secondLevel = newSecondLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PROTECTION__SECOND_LEVEL, oldSecondLevel, secondLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getSecondLevelEnlargmentUsefulness()
	{
		return secondLevelEnlargmentUsefulness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondLevelEnlargmentUsefulness(Level newSecondLevelEnlargmentUsefulness)
	{
		Level oldSecondLevelEnlargmentUsefulness = secondLevelEnlargmentUsefulness;
		secondLevelEnlargmentUsefulness = newSecondLevelEnlargmentUsefulness == null ? SECOND_LEVEL_ENLARGMENT_USEFULNESS_EDEFAULT : newSecondLevelEnlargmentUsefulness;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PROTECTION__SECOND_LEVEL_ENLARGMENT_USEFULNESS, oldSecondLevelEnlargmentUsefulness, secondLevelEnlargmentUsefulness));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getSecondLevelCallGraphEnlargmentUsefulness()
	{
		return secondLevelCallGraphEnlargmentUsefulness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondLevelCallGraphEnlargmentUsefulness(Level newSecondLevelCallGraphEnlargmentUsefulness)
	{
		Level oldSecondLevelCallGraphEnlargmentUsefulness = secondLevelCallGraphEnlargmentUsefulness;
		secondLevelCallGraphEnlargmentUsefulness = newSecondLevelCallGraphEnlargmentUsefulness == null ? SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS_EDEFAULT : newSecondLevelCallGraphEnlargmentUsefulness;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PROTECTION__SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS, oldSecondLevelCallGraphEnlargmentUsefulness, secondLevelCallGraphEnlargmentUsefulness));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level getSecondLevelRepetitionUsefulness()
	{
		return secondLevelRepetitionUsefulness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondLevelRepetitionUsefulness(Level newSecondLevelRepetitionUsefulness)
	{
		Level oldSecondLevelRepetitionUsefulness = secondLevelRepetitionUsefulness;
		secondLevelRepetitionUsefulness = newSecondLevelRepetitionUsefulness == null ? SECOND_LEVEL_REPETITION_USEFULNESS_EDEFAULT : newSecondLevelRepetitionUsefulness;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_USEFULNESS, oldSecondLevelRepetitionUsefulness, secondLevelRepetitionUsefulness));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProtectionInstantiation> getSecondLevelRepetitionInstantiation()
	{
		if (secondLevelRepetitionInstantiation == null)
		{
			secondLevelRepetitionInstantiation = new EObjectContainmentEList<ProtectionInstantiation>(ProtectionInstantiation.class, this, KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_INSTANTIATION);
		}
		return secondLevelRepetitionInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPartType> getApplicationPartTypes()
	{
		if (applicationPartTypes == null)
		{
			applicationPartTypes = new EDataTypeEList<ApplicationPartType>(ApplicationPartType.class, this, KbPackage.PROTECTION__APPLICATION_PART_TYPES);
		}
		return applicationPartTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackMitigation> getMitigations()
	{
		if (mitigations == null)
		{
			mitigations = new EObjectContainmentWithInverseEList<AttackMitigation>(AttackMitigation.class, this, KbPackage.PROTECTION__MITIGATIONS, KbPackage.ATTACK_MITIGATION__PROTECTION);
		}
		return mitigations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getEnforcedSecurityRequirements()
	{
		if (enforcedSecurityRequirements == null)
		{
			enforcedSecurityRequirements = new EDataTypeEList<Property>(Property.class, this, KbPackage.PROTECTION__ENFORCED_SECURITY_REQUIREMENTS);
		}
		return enforcedSecurityRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Protection> getForbiddenPrecedences()
	{
		if (forbiddenPrecedences == null)
		{
			forbiddenPrecedences = new EObjectResolvingEList<Protection>(Protection.class, this, KbPackage.PROTECTION__FORBIDDEN_PRECEDENCES);
		}
		return forbiddenPrecedences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Protection> getDiscouragedPrecedences()
	{
		if (discouragedPrecedences == null)
		{
			discouragedPrecedences = new EObjectResolvingEList<Protection>(Protection.class, this, KbPackage.PROTECTION__DISCOURAGED_PRECEDENCES);
		}
		return discouragedPrecedences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Protection> getEncouragedPrecedences()
	{
		if (encouragedPrecedences == null)
		{
			encouragedPrecedences = new EObjectResolvingEList<Protection>(Protection.class, this, KbPackage.PROTECTION__ENCOURAGED_PRECEDENCES);
		}
		return encouragedPrecedences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Protection> getActcPrecedences()
	{
		if (actcPrecedences == null)
		{
			actcPrecedences = new EObjectResolvingEList<Protection>(Protection.class, this, KbPackage.PROTECTION__ACTC_PRECEDENCES);
		}
		return actcPrecedences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSingleton()
	{
		return singleton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleton(boolean newSingleton)
	{
		boolean oldSingleton = singleton;
		singleton = newSingleton;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.PROTECTION__SINGLETON, oldSingleton, singleton));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackerToolType> getDefeatedAttackerToolTypes()
	{
		if (defeatedAttackerToolTypes == null)
		{
			defeatedAttackerToolTypes = new EObjectResolvingEList<AttackerToolType>(AttackerToolType.class, this, KbPackage.PROTECTION__DEFEATED_ATTACKER_TOOL_TYPES);
		}
		return defeatedAttackerToolTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttackerToolType> getBlockedAttackerToolTypes()
	{
		if (blockedAttackerToolTypes == null)
		{
			blockedAttackerToolTypes = new EObjectResolvingEList<AttackerToolType>(AttackerToolType.class, this, KbPackage.PROTECTION__BLOCKED_ATTACKER_TOOL_TYPES);
		}
		return blockedAttackerToolTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProtectionInstantiation> getInstantiations()
	{
		if (instantiations == null)
		{
			instantiations = new EObjectContainmentWithInverseEList<ProtectionInstantiation>(ProtectionInstantiation.class, this, KbPackage.PROTECTION__INSTANTIATIONS, KbPackage.PROTECTION_INSTANTIATION__PROTECTION);
		}
		return instantiations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActionType> getActions()
	{
		if (actions == null)
		{
			actions = new EDataTypeEList<ActionType>(ActionType.class, this, KbPackage.PROTECTION__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProtectionFlag> getFlags()
	{
		if (flags == null)
		{
			flags = new EDataTypeEList<ProtectionFlag>(ProtectionFlag.class, this, KbPackage.PROTECTION__FLAGS);
		}
		return flags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInstantiationsCount()
	{
		return this.getInstantiations().size();
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
			if ((object instanceof Protection))
			{
				String _name = this.getName();
				String _name_1 = ((Protection)object).getName();
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case KbPackage.PROTECTION__MITIGATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMitigations()).basicAdd(otherEnd, msgs);
			case KbPackage.PROTECTION__INSTANTIATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInstantiations()).basicAdd(otherEnd, msgs);
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
			case KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_INSTANTIATION:
				return ((InternalEList<?>)getSecondLevelRepetitionInstantiation()).basicRemove(otherEnd, msgs);
			case KbPackage.PROTECTION__MITIGATIONS:
				return ((InternalEList<?>)getMitigations()).basicRemove(otherEnd, msgs);
			case KbPackage.PROTECTION__INSTANTIATIONS:
				return ((InternalEList<?>)getInstantiations()).basicRemove(otherEnd, msgs);
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
			case KbPackage.PROTECTION__ID:
				return getId();
			case KbPackage.PROTECTION__NAME:
				return getName();
			case KbPackage.PROTECTION__ENABLED:
				return isEnabled();
			case KbPackage.PROTECTION__AUTOMATICALLY_DEPLOYABLE:
				return isAutomaticallyDeployable();
			case KbPackage.PROTECTION__SECOND_LEVEL:
				return isSecondLevel();
			case KbPackage.PROTECTION__SECOND_LEVEL_ENLARGMENT_USEFULNESS:
				return getSecondLevelEnlargmentUsefulness();
			case KbPackage.PROTECTION__SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS:
				return getSecondLevelCallGraphEnlargmentUsefulness();
			case KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_USEFULNESS:
				return getSecondLevelRepetitionUsefulness();
			case KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_INSTANTIATION:
				return getSecondLevelRepetitionInstantiation();
			case KbPackage.PROTECTION__APPLICATION_PART_TYPES:
				return getApplicationPartTypes();
			case KbPackage.PROTECTION__MITIGATIONS:
				return getMitigations();
			case KbPackage.PROTECTION__ENFORCED_SECURITY_REQUIREMENTS:
				return getEnforcedSecurityRequirements();
			case KbPackage.PROTECTION__FORBIDDEN_PRECEDENCES:
				return getForbiddenPrecedences();
			case KbPackage.PROTECTION__DISCOURAGED_PRECEDENCES:
				return getDiscouragedPrecedences();
			case KbPackage.PROTECTION__ENCOURAGED_PRECEDENCES:
				return getEncouragedPrecedences();
			case KbPackage.PROTECTION__ACTC_PRECEDENCES:
				return getActcPrecedences();
			case KbPackage.PROTECTION__SINGLETON:
				return isSingleton();
			case KbPackage.PROTECTION__DEFEATED_ATTACKER_TOOL_TYPES:
				return getDefeatedAttackerToolTypes();
			case KbPackage.PROTECTION__BLOCKED_ATTACKER_TOOL_TYPES:
				return getBlockedAttackerToolTypes();
			case KbPackage.PROTECTION__INSTANTIATIONS:
				return getInstantiations();
			case KbPackage.PROTECTION__ACTIONS:
				return getActions();
			case KbPackage.PROTECTION__FLAGS:
				return getFlags();
			case KbPackage.PROTECTION__INSTANTIATIONS_COUNT:
				return getInstantiationsCount();
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
			case KbPackage.PROTECTION__ID:
				setId((String)newValue);
				return;
			case KbPackage.PROTECTION__NAME:
				setName((String)newValue);
				return;
			case KbPackage.PROTECTION__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case KbPackage.PROTECTION__AUTOMATICALLY_DEPLOYABLE:
				setAutomaticallyDeployable((Boolean)newValue);
				return;
			case KbPackage.PROTECTION__SECOND_LEVEL:
				setSecondLevel((Boolean)newValue);
				return;
			case KbPackage.PROTECTION__SECOND_LEVEL_ENLARGMENT_USEFULNESS:
				setSecondLevelEnlargmentUsefulness((Level)newValue);
				return;
			case KbPackage.PROTECTION__SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS:
				setSecondLevelCallGraphEnlargmentUsefulness((Level)newValue);
				return;
			case KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_USEFULNESS:
				setSecondLevelRepetitionUsefulness((Level)newValue);
				return;
			case KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_INSTANTIATION:
				getSecondLevelRepetitionInstantiation().clear();
				getSecondLevelRepetitionInstantiation().addAll((Collection<? extends ProtectionInstantiation>)newValue);
				return;
			case KbPackage.PROTECTION__APPLICATION_PART_TYPES:
				getApplicationPartTypes().clear();
				getApplicationPartTypes().addAll((Collection<? extends ApplicationPartType>)newValue);
				return;
			case KbPackage.PROTECTION__MITIGATIONS:
				getMitigations().clear();
				getMitigations().addAll((Collection<? extends AttackMitigation>)newValue);
				return;
			case KbPackage.PROTECTION__ENFORCED_SECURITY_REQUIREMENTS:
				getEnforcedSecurityRequirements().clear();
				getEnforcedSecurityRequirements().addAll((Collection<? extends Property>)newValue);
				return;
			case KbPackage.PROTECTION__FORBIDDEN_PRECEDENCES:
				getForbiddenPrecedences().clear();
				getForbiddenPrecedences().addAll((Collection<? extends Protection>)newValue);
				return;
			case KbPackage.PROTECTION__DISCOURAGED_PRECEDENCES:
				getDiscouragedPrecedences().clear();
				getDiscouragedPrecedences().addAll((Collection<? extends Protection>)newValue);
				return;
			case KbPackage.PROTECTION__ENCOURAGED_PRECEDENCES:
				getEncouragedPrecedences().clear();
				getEncouragedPrecedences().addAll((Collection<? extends Protection>)newValue);
				return;
			case KbPackage.PROTECTION__ACTC_PRECEDENCES:
				getActcPrecedences().clear();
				getActcPrecedences().addAll((Collection<? extends Protection>)newValue);
				return;
			case KbPackage.PROTECTION__SINGLETON:
				setSingleton((Boolean)newValue);
				return;
			case KbPackage.PROTECTION__DEFEATED_ATTACKER_TOOL_TYPES:
				getDefeatedAttackerToolTypes().clear();
				getDefeatedAttackerToolTypes().addAll((Collection<? extends AttackerToolType>)newValue);
				return;
			case KbPackage.PROTECTION__BLOCKED_ATTACKER_TOOL_TYPES:
				getBlockedAttackerToolTypes().clear();
				getBlockedAttackerToolTypes().addAll((Collection<? extends AttackerToolType>)newValue);
				return;
			case KbPackage.PROTECTION__INSTANTIATIONS:
				getInstantiations().clear();
				getInstantiations().addAll((Collection<? extends ProtectionInstantiation>)newValue);
				return;
			case KbPackage.PROTECTION__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends ActionType>)newValue);
				return;
			case KbPackage.PROTECTION__FLAGS:
				getFlags().clear();
				getFlags().addAll((Collection<? extends ProtectionFlag>)newValue);
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
			case KbPackage.PROTECTION__ID:
				setId(ID_EDEFAULT);
				return;
			case KbPackage.PROTECTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case KbPackage.PROTECTION__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case KbPackage.PROTECTION__AUTOMATICALLY_DEPLOYABLE:
				setAutomaticallyDeployable(AUTOMATICALLY_DEPLOYABLE_EDEFAULT);
				return;
			case KbPackage.PROTECTION__SECOND_LEVEL:
				setSecondLevel(SECOND_LEVEL_EDEFAULT);
				return;
			case KbPackage.PROTECTION__SECOND_LEVEL_ENLARGMENT_USEFULNESS:
				setSecondLevelEnlargmentUsefulness(SECOND_LEVEL_ENLARGMENT_USEFULNESS_EDEFAULT);
				return;
			case KbPackage.PROTECTION__SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS:
				setSecondLevelCallGraphEnlargmentUsefulness(SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS_EDEFAULT);
				return;
			case KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_USEFULNESS:
				setSecondLevelRepetitionUsefulness(SECOND_LEVEL_REPETITION_USEFULNESS_EDEFAULT);
				return;
			case KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_INSTANTIATION:
				getSecondLevelRepetitionInstantiation().clear();
				return;
			case KbPackage.PROTECTION__APPLICATION_PART_TYPES:
				getApplicationPartTypes().clear();
				return;
			case KbPackage.PROTECTION__MITIGATIONS:
				getMitigations().clear();
				return;
			case KbPackage.PROTECTION__ENFORCED_SECURITY_REQUIREMENTS:
				getEnforcedSecurityRequirements().clear();
				return;
			case KbPackage.PROTECTION__FORBIDDEN_PRECEDENCES:
				getForbiddenPrecedences().clear();
				return;
			case KbPackage.PROTECTION__DISCOURAGED_PRECEDENCES:
				getDiscouragedPrecedences().clear();
				return;
			case KbPackage.PROTECTION__ENCOURAGED_PRECEDENCES:
				getEncouragedPrecedences().clear();
				return;
			case KbPackage.PROTECTION__ACTC_PRECEDENCES:
				getActcPrecedences().clear();
				return;
			case KbPackage.PROTECTION__SINGLETON:
				setSingleton(SINGLETON_EDEFAULT);
				return;
			case KbPackage.PROTECTION__DEFEATED_ATTACKER_TOOL_TYPES:
				getDefeatedAttackerToolTypes().clear();
				return;
			case KbPackage.PROTECTION__BLOCKED_ATTACKER_TOOL_TYPES:
				getBlockedAttackerToolTypes().clear();
				return;
			case KbPackage.PROTECTION__INSTANTIATIONS:
				getInstantiations().clear();
				return;
			case KbPackage.PROTECTION__ACTIONS:
				getActions().clear();
				return;
			case KbPackage.PROTECTION__FLAGS:
				getFlags().clear();
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
			case KbPackage.PROTECTION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case KbPackage.PROTECTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KbPackage.PROTECTION__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case KbPackage.PROTECTION__AUTOMATICALLY_DEPLOYABLE:
				return automaticallyDeployable != AUTOMATICALLY_DEPLOYABLE_EDEFAULT;
			case KbPackage.PROTECTION__SECOND_LEVEL:
				return secondLevel != SECOND_LEVEL_EDEFAULT;
			case KbPackage.PROTECTION__SECOND_LEVEL_ENLARGMENT_USEFULNESS:
				return secondLevelEnlargmentUsefulness != SECOND_LEVEL_ENLARGMENT_USEFULNESS_EDEFAULT;
			case KbPackage.PROTECTION__SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS:
				return secondLevelCallGraphEnlargmentUsefulness != SECOND_LEVEL_CALL_GRAPH_ENLARGMENT_USEFULNESS_EDEFAULT;
			case KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_USEFULNESS:
				return secondLevelRepetitionUsefulness != SECOND_LEVEL_REPETITION_USEFULNESS_EDEFAULT;
			case KbPackage.PROTECTION__SECOND_LEVEL_REPETITION_INSTANTIATION:
				return secondLevelRepetitionInstantiation != null && !secondLevelRepetitionInstantiation.isEmpty();
			case KbPackage.PROTECTION__APPLICATION_PART_TYPES:
				return applicationPartTypes != null && !applicationPartTypes.isEmpty();
			case KbPackage.PROTECTION__MITIGATIONS:
				return mitigations != null && !mitigations.isEmpty();
			case KbPackage.PROTECTION__ENFORCED_SECURITY_REQUIREMENTS:
				return enforcedSecurityRequirements != null && !enforcedSecurityRequirements.isEmpty();
			case KbPackage.PROTECTION__FORBIDDEN_PRECEDENCES:
				return forbiddenPrecedences != null && !forbiddenPrecedences.isEmpty();
			case KbPackage.PROTECTION__DISCOURAGED_PRECEDENCES:
				return discouragedPrecedences != null && !discouragedPrecedences.isEmpty();
			case KbPackage.PROTECTION__ENCOURAGED_PRECEDENCES:
				return encouragedPrecedences != null && !encouragedPrecedences.isEmpty();
			case KbPackage.PROTECTION__ACTC_PRECEDENCES:
				return actcPrecedences != null && !actcPrecedences.isEmpty();
			case KbPackage.PROTECTION__SINGLETON:
				return singleton != SINGLETON_EDEFAULT;
			case KbPackage.PROTECTION__DEFEATED_ATTACKER_TOOL_TYPES:
				return defeatedAttackerToolTypes != null && !defeatedAttackerToolTypes.isEmpty();
			case KbPackage.PROTECTION__BLOCKED_ATTACKER_TOOL_TYPES:
				return blockedAttackerToolTypes != null && !blockedAttackerToolTypes.isEmpty();
			case KbPackage.PROTECTION__INSTANTIATIONS:
				return instantiations != null && !instantiations.isEmpty();
			case KbPackage.PROTECTION__ACTIONS:
				return actions != null && !actions.isEmpty();
			case KbPackage.PROTECTION__FLAGS:
				return flags != null && !flags.isEmpty();
			case KbPackage.PROTECTION__INSTANTIATIONS_COUNT:
				return getInstantiationsCount() != INSTANTIATIONS_COUNT_EDEFAULT;
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
			case KbPackage.PROTECTION___HASH_CODE:
				return hashCode();
			case KbPackage.PROTECTION___EQUALS__OBJECT:
				return equals(arguments.get(0));
			case KbPackage.PROTECTION___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ProtectionImpl

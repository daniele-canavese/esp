/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import com.google.common.collect.Iterables;

import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.ApplicationPart;
import it.polito.security.esp.kb.ApplicationPartSet;
import it.polito.security.esp.kb.ApplicationPartType;
import it.polito.security.esp.kb.CodeBlock;
import it.polito.security.esp.kb.Property;
import it.polito.security.esp.kb.UseTarget;

import java.lang.reflect.InvocationTargetException;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Collection;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getId <em>Id</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getName <em>Name</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getSets <em>Sets</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getType <em>Type</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getSourceFilePath <em>Source File Path</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getDeclaringCode <em>Declaring Code</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getEndLine <em>End Line</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getDatumSize <em>Datum Size</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getDatumLowerBound <em>Datum Lower Bound</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getDatumUpperBound <em>Datum Upper Bound</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#isInSystemFile <em>In System File</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#isGlobal <em>Global</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getShortLocation <em>Short Location</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getSecurityProperties <em>Security Properties</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#isAsset <em>Asset</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#isDisabledAsset <em>Disabled Asset</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getApplicationParts <em>Application Parts</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getUses <em>Uses</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getTargetOf <em>Target Of</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getBody <em>Body</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#isContainsIfdef <em>Contains Ifdef</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getApplicationPartsCount <em>Application Parts Count</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.ApplicationPartImpl#getAssets <em>Assets</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplicationPartImpl extends MinimalEObjectImpl.Container implements ApplicationPart
{
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

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
	 * The cached value of the '{@link #getSets() <em>Sets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationPartSet> sets;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ApplicationPartType TYPE_EDEFAULT = ApplicationPartType.CODE_REGION;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ApplicationPartType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * The default value of the '{@link #getSourceFilePath() <em>Source File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceFilePath() <em>Source File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFilePath()
	 * @generated
	 * @ordered
	 */
	protected String sourceFilePath = SOURCE_FILE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected static final int START_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartLine() <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartLine()
	 * @generated
	 * @ordered
	 */
	protected int startLine = START_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected static final int END_LINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndLine() <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndLine()
	 * @generated
	 * @ordered
	 */
	protected int endLine = END_LINE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDatumSize() <em>Datum Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatumSize()
	 * @generated
	 * @ordered
	 */
	protected static final int DATUM_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDatumSize() <em>Datum Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatumSize()
	 * @generated
	 * @ordered
	 */
	protected int datumSize = DATUM_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDatumLowerBound() <em>Datum Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatumLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final int DATUM_LOWER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDatumLowerBound() <em>Datum Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatumLowerBound()
	 * @generated
	 * @ordered
	 */
	protected int datumLowerBound = DATUM_LOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getDatumUpperBound() <em>Datum Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatumUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final int DATUM_UPPER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDatumUpperBound() <em>Datum Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatumUpperBound()
	 * @generated
	 * @ordered
	 */
	protected int datumUpperBound = DATUM_UPPER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #isInSystemFile() <em>In System File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInSystemFile()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IN_SYSTEM_FILE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInSystemFile() <em>In System File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInSystemFile()
	 * @generated
	 * @ordered
	 */
	protected boolean inSystemFile = IN_SYSTEM_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #isGlobal() <em>Global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGlobal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GLOBAL_EDEFAULT = false;

	/**
	 * The default value of the '{@link #getShortLocation() <em>Short Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShortLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String SHORT_LOCATION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double WEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected double weight = WEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #isAsset() <em>Asset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsset()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ASSET_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isDisabledAsset() <em>Disabled Asset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisabledAsset()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISABLED_ASSET_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getApplicationParts() <em>Application Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ApplicationPart> applicationParts;

	/**
	 * The cached value of the '{@link #getUses() <em>Uses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUses()
	 * @generated
	 * @ordered
	 */
	protected EList<UseTarget> uses;

	/**
	 * The cached value of the '{@link #getTargetOf() <em>Target Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetOf()
	 * @generated
	 * @ordered
	 */
	protected EList<UseTarget> targetOf;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected CodeBlock body;

	/**
	 * The default value of the '{@link #isContainsIfdef() <em>Contains Ifdef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainsIfdef()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINS_IFDEF_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainsIfdef() <em>Contains Ifdef</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainsIfdef()
	 * @generated
	 * @ordered
	 */
	protected boolean containsIfdef = CONTAINS_IFDEF_EDEFAULT;

	/**
	 * The default value of the '{@link #getApplicationPartsCount() <em>Application Parts Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationPartsCount()
	 * @generated
	 * @ordered
	 */
	protected static final int APPLICATION_PARTS_COUNT_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationPartImpl()
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
		return KbPackage.Literals.APPLICATION_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId)
	{
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPartSet> getSets()
	{
		if (sets == null)
		{
			sets = new EObjectWithInverseResolvingEList.ManyInverse<ApplicationPartSet>(ApplicationPartSet.class, this, KbPackage.APPLICATION_PART__SETS, KbPackage.APPLICATION_PART_SET__APPLICATION_PARTS);
		}
		return sets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPartType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ApplicationPartType newType)
	{
		ApplicationPartType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex()
	{
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex)
	{
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties()
	{
		if (properties == null)
		{
			properties = new EDataTypeEList<Property>(Property.class, this, KbPackage.APPLICATION_PART__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceFilePath()
	{
		return sourceFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceFilePath(String newSourceFilePath)
	{
		String oldSourceFilePath = sourceFilePath;
		sourceFilePath = newSourceFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__SOURCE_FILE_PATH, oldSourceFilePath, sourceFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart getDeclaringCode()
	{
		if (eContainerFeatureID() != KbPackage.APPLICATION_PART__DECLARING_CODE) return null;
		return (ApplicationPart)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationPart basicGetDeclaringCode()
	{
		if (eContainerFeatureID() != KbPackage.APPLICATION_PART__DECLARING_CODE) return null;
		return (ApplicationPart)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaringCode(ApplicationPart newDeclaringCode, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newDeclaringCode, KbPackage.APPLICATION_PART__DECLARING_CODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaringCode(ApplicationPart newDeclaringCode)
	{
		if (newDeclaringCode != eInternalContainer() || (eContainerFeatureID() != KbPackage.APPLICATION_PART__DECLARING_CODE && newDeclaringCode != null))
		{
			if (EcoreUtil.isAncestor(this, newDeclaringCode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeclaringCode != null)
				msgs = ((InternalEObject)newDeclaringCode).eInverseAdd(this, KbPackage.APPLICATION_PART__APPLICATION_PARTS, ApplicationPart.class, msgs);
			msgs = basicSetDeclaringCode(newDeclaringCode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__DECLARING_CODE, newDeclaringCode, newDeclaringCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartLine()
	{
		return startLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartLine(int newStartLine)
	{
		int oldStartLine = startLine;
		startLine = newStartLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__START_LINE, oldStartLine, startLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndLine()
	{
		return endLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndLine(int newEndLine)
	{
		int oldEndLine = endLine;
		endLine = newEndLine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__END_LINE, oldEndLine, endLine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDatumSize()
	{
		return datumSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatumSize(int newDatumSize)
	{
		int oldDatumSize = datumSize;
		datumSize = newDatumSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__DATUM_SIZE, oldDatumSize, datumSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDatumLowerBound()
	{
		return datumLowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatumLowerBound(int newDatumLowerBound)
	{
		int oldDatumLowerBound = datumLowerBound;
		datumLowerBound = newDatumLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__DATUM_LOWER_BOUND, oldDatumLowerBound, datumLowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDatumUpperBound()
	{
		return datumUpperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatumUpperBound(int newDatumUpperBound)
	{
		int oldDatumUpperBound = datumUpperBound;
		datumUpperBound = newDatumUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__DATUM_UPPER_BOUND, oldDatumUpperBound, datumUpperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInSystemFile()
	{
		return inSystemFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInSystemFile(boolean newInSystemFile)
	{
		boolean oldInSystemFile = inSystemFile;
		inSystemFile = newInSystemFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__IN_SYSTEM_FILE, oldInSystemFile, inSystemFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGlobal()
	{
		ApplicationPart _declaringCode = this.getDeclaringCode();
		return Objects.equal(_declaringCode, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShortLocation()
	{
		ApplicationPartType _type = this.getType();
		boolean _equals = Objects.equal(_type, ApplicationPartType.REFERENCE);
		if (_equals)
		{
			return "";
		}
		else
		{
			int _startLine = this.getStartLine();
			int _endLine = this.getEndLine();
			boolean _notEquals = (_startLine != _endLine);
			if (_notEquals)
			{
				Path _fileName = Paths.get(this.getSourceFilePath()).getFileName();
				String _plus = (_fileName + " : ");
				int _startLine_1 = this.getStartLine();
				String _plus_1 = (_plus + Integer.valueOf(_startLine_1));
				String _plus_2 = (_plus_1 + "-");
				int _endLine_1 = this.getEndLine();
				return (_plus_2 + Integer.valueOf(_endLine_1));
			}
			else
			{
				Path _fileName_1 = Paths.get(this.getSourceFilePath()).getFileName();
				String _plus_3 = (_fileName_1 + " : ");
				int _startLine_2 = this.getStartLine();
				return (_plus_3 + Integer.valueOf(_startLine_2));
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWeight()
	{
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(double newWeight)
	{
		double oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getSecurityProperties()
	{
		BasicEList<Property> securities = new BasicEList<Property>();
		EList<Property> _properties = this.getProperties();
		for (final Property i : _properties)
		{
			if ((((Objects.equal(i, Property.CONFIDENTIALITY) || Objects.equal(i, Property.HARDCONFIDENTIALITY)) || Objects.equal(i, Property.INTEGRITY)) || Objects.equal(i, Property.PRIVACY)))
			{
				securities.add(i);
			}
		}
		return securities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPart> getParameters()
	{
		BasicEList<ApplicationPart> parameters = new BasicEList<ApplicationPart>();
		EList<ApplicationPart> _applicationParts = this.getApplicationParts();
		for (final ApplicationPart i : _applicationParts)
		{
			ApplicationPartType _type = i.getType();
			boolean _equals = Objects.equal(_type, ApplicationPartType.PARAMETER);
			if (_equals)
			{
				parameters.add(i);
			}
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAsset()
	{
		return ((!this.getSecurityProperties().isEmpty()) && (this.getWeight() > 0.0));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisabledAsset()
	{
		return ((!this.getSecurityProperties().isEmpty()) && (this.getWeight() == 0.0));
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
			applicationParts = new EObjectContainmentWithInverseEList<ApplicationPart>(ApplicationPart.class, this, KbPackage.APPLICATION_PART__APPLICATION_PARTS, KbPackage.APPLICATION_PART__DECLARING_CODE);
		}
		return applicationParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseTarget> getUses()
	{
		if (uses == null)
		{
			uses = new EObjectContainmentWithInverseEList<UseTarget>(UseTarget.class, this, KbPackage.APPLICATION_PART__USES, KbPackage.USE_TARGET__USED_BY);
		}
		return uses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseTarget> getTargetOf()
	{
		if (targetOf == null)
		{
			targetOf = new EObjectWithInverseResolvingEList<UseTarget>(UseTarget.class, this, KbPackage.APPLICATION_PART__TARGET_OF, KbPackage.USE_TARGET__TARGET);
		}
		return targetOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlock getBody()
	{
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(CodeBlock newBody, NotificationChain msgs)
	{
		CodeBlock oldBody = body;
		body = newBody;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(CodeBlock newBody)
	{
		if (newBody != body)
		{
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KbPackage.APPLICATION_PART__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KbPackage.APPLICATION_PART__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContainsIfdef()
	{
		return containsIfdef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainsIfdef(boolean newContainsIfdef)
	{
		boolean oldContainsIfdef = containsIfdef;
		containsIfdef = newContainsIfdef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.APPLICATION_PART__CONTAINS_IFDEF, oldContainsIfdef, containsIfdef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getApplicationPartsCount()
	{
		int count = 1;
		EList<ApplicationPart> _applicationParts = this.getApplicationParts();
		for (final ApplicationPart i : _applicationParts)
		{
			int _applicationPartsCount = i.getApplicationPartsCount();
			int _plus = (count + _applicationPartsCount);
			count = _plus;
		}
		return count;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ApplicationPart> getAssets()
	{
		BasicEList<ApplicationPart> assets = new BasicEList<ApplicationPart>();
		Stack<ApplicationPart> parts = new Stack<ApplicationPart>();
		EList<ApplicationPart> _applicationParts = this.getApplicationParts();
		Iterables.<ApplicationPart>addAll(parts, _applicationParts);
		while ((!parts.isEmpty()))
		{
			{
				ApplicationPart i = parts.pop();
				boolean _isAsset = i.isAsset();
				if (_isAsset)
				{
					assets.add(i);
				}
				EList<ApplicationPart> _applicationParts_1 = i.getApplicationParts();
				Iterables.<ApplicationPart>addAll(parts, _applicationParts_1);
			}
		}
		return assets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean contains(final ApplicationPart part)
	{
		boolean _equals = Objects.equal(this, part);
		if (_equals)
		{
			return true;
		}
		else
		{
			EList<ApplicationPart> _applicationParts = this.getApplicationParts();
			for (final ApplicationPart i : _applicationParts)
			{
				boolean _contains = i.contains(part);
				if (_contains)
				{
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		String _sourceFilePath = this.getSourceFilePath();
		boolean _notEquals = (!Objects.equal(_sourceFilePath, null));
		if (_notEquals)
		{
			int _hashCode = this.getSourceFilePath().hashCode();
			int _plus = ((31 * result) + _hashCode);
			result = _plus;
		}
		int _hashCode_1 = this.getName().hashCode();
		int _plus_1 = ((31 * result) + _hashCode_1);
		result = _plus_1;
		int _hashCode_2 = this.getType().toString().hashCode();
		int _plus_2 = ((31 * result) + _hashCode_2);
		result = _plus_2;
		int _hashCode_3 = Integer.valueOf(this.getStartLine()).toString().hashCode();
		int _plus_3 = ((31 * result) + _hashCode_3);
		result = _plus_3;
		int _hashCode_4 = Integer.valueOf(this.getEndLine()).toString().hashCode();
		int _plus_4 = ((31 * result) + _hashCode_4);
		result = _plus_4;
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
			if ((object instanceof ApplicationPart))
			{
				return ((((Objects.equal(this.getSourceFilePath(), ((ApplicationPart)object).getSourceFilePath()) && Objects.equal(this.getName(), ((ApplicationPart)object).getName())) && Objects.equal(this.getType(), ((ApplicationPart)object).getType())) && (this.getStartLine() == ((ApplicationPart)object).getStartLine())) && 
					(this.getEndLine() == ((ApplicationPart)object).getEndLine()));
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
	public boolean isDatum()
	{
		return ((((((((Objects.equal(this.getType(), ApplicationPartType.CRYPTOGRAPHIC_KEY) || Objects.equal(this.getType(), ApplicationPartType.INTEGER_DATUM)) || 
			Objects.equal(this.getType(), ApplicationPartType.STATIC_INTEGER_ARRAY_DATUM)) || Objects.equal(this.getType(), ApplicationPartType.INTEGER_ARRAY_DATUM)) || 
			Objects.equal(this.getType(), ApplicationPartType.GENERIC_VARIABLE)) || Objects.equal(this.getType(), ApplicationPartType.PARAMETER)) || Objects.equal(this.getType(), ApplicationPartType.INITIALIZATION_VECTOR)) || 
			Objects.equal(this.getType(), ApplicationPartType.PLAINTEXT)) || Objects.equal(this.getType(), ApplicationPartType.CIPHERTEXT));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCode()
	{
		return (Objects.equal(this.getType(), ApplicationPartType.CODE_REGION) || Objects.equal(this.getType(), ApplicationPartType.FUNCTION));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean containsAsset()
	{
		BasicEList<ApplicationPart> aux = new BasicEList<ApplicationPart>();
		aux.addAll(this.getApplicationParts());
		while ((!aux.isEmpty()))
		{
			{
				ApplicationPart p = aux.get(0);
				boolean _isAsset = p.isAsset();
				if (_isAsset)
				{
					return true;
				}
				aux.remove(0);
				EList<ApplicationPart> _applicationParts = p.getApplicationParts();
				for (final ApplicationPart j : _applicationParts)
				{
					aux.add(0, j);
				}
			}
		}
		return false;
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
			case KbPackage.APPLICATION_PART__SETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSets()).basicAdd(otherEnd, msgs);
			case KbPackage.APPLICATION_PART__DECLARING_CODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclaringCode((ApplicationPart)otherEnd, msgs);
			case KbPackage.APPLICATION_PART__APPLICATION_PARTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getApplicationParts()).basicAdd(otherEnd, msgs);
			case KbPackage.APPLICATION_PART__USES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUses()).basicAdd(otherEnd, msgs);
			case KbPackage.APPLICATION_PART__TARGET_OF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetOf()).basicAdd(otherEnd, msgs);
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
			case KbPackage.APPLICATION_PART__SETS:
				return ((InternalEList<?>)getSets()).basicRemove(otherEnd, msgs);
			case KbPackage.APPLICATION_PART__DECLARING_CODE:
				return basicSetDeclaringCode(null, msgs);
			case KbPackage.APPLICATION_PART__APPLICATION_PARTS:
				return ((InternalEList<?>)getApplicationParts()).basicRemove(otherEnd, msgs);
			case KbPackage.APPLICATION_PART__USES:
				return ((InternalEList<?>)getUses()).basicRemove(otherEnd, msgs);
			case KbPackage.APPLICATION_PART__TARGET_OF:
				return ((InternalEList<?>)getTargetOf()).basicRemove(otherEnd, msgs);
			case KbPackage.APPLICATION_PART__BODY:
				return basicSetBody(null, msgs);
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
			case KbPackage.APPLICATION_PART__DECLARING_CODE:
				return eInternalContainer().eInverseRemove(this, KbPackage.APPLICATION_PART__APPLICATION_PARTS, ApplicationPart.class, msgs);
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
			case KbPackage.APPLICATION_PART__ID:
				return getId();
			case KbPackage.APPLICATION_PART__NAME:
				return getName();
			case KbPackage.APPLICATION_PART__SETS:
				return getSets();
			case KbPackage.APPLICATION_PART__TYPE:
				return getType();
			case KbPackage.APPLICATION_PART__INDEX:
				return getIndex();
			case KbPackage.APPLICATION_PART__PROPERTIES:
				return getProperties();
			case KbPackage.APPLICATION_PART__SOURCE_FILE_PATH:
				return getSourceFilePath();
			case KbPackage.APPLICATION_PART__DECLARING_CODE:
				if (resolve) return getDeclaringCode();
				return basicGetDeclaringCode();
			case KbPackage.APPLICATION_PART__START_LINE:
				return getStartLine();
			case KbPackage.APPLICATION_PART__END_LINE:
				return getEndLine();
			case KbPackage.APPLICATION_PART__DATUM_SIZE:
				return getDatumSize();
			case KbPackage.APPLICATION_PART__DATUM_LOWER_BOUND:
				return getDatumLowerBound();
			case KbPackage.APPLICATION_PART__DATUM_UPPER_BOUND:
				return getDatumUpperBound();
			case KbPackage.APPLICATION_PART__IN_SYSTEM_FILE:
				return isInSystemFile();
			case KbPackage.APPLICATION_PART__GLOBAL:
				return isGlobal();
			case KbPackage.APPLICATION_PART__SHORT_LOCATION:
				return getShortLocation();
			case KbPackage.APPLICATION_PART__WEIGHT:
				return getWeight();
			case KbPackage.APPLICATION_PART__SECURITY_PROPERTIES:
				return getSecurityProperties();
			case KbPackage.APPLICATION_PART__PARAMETERS:
				return getParameters();
			case KbPackage.APPLICATION_PART__ASSET:
				return isAsset();
			case KbPackage.APPLICATION_PART__DISABLED_ASSET:
				return isDisabledAsset();
			case KbPackage.APPLICATION_PART__APPLICATION_PARTS:
				return getApplicationParts();
			case KbPackage.APPLICATION_PART__USES:
				return getUses();
			case KbPackage.APPLICATION_PART__TARGET_OF:
				return getTargetOf();
			case KbPackage.APPLICATION_PART__BODY:
				return getBody();
			case KbPackage.APPLICATION_PART__CONTAINS_IFDEF:
				return isContainsIfdef();
			case KbPackage.APPLICATION_PART__APPLICATION_PARTS_COUNT:
				return getApplicationPartsCount();
			case KbPackage.APPLICATION_PART__ASSETS:
				return getAssets();
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
			case KbPackage.APPLICATION_PART__ID:
				setId((Integer)newValue);
				return;
			case KbPackage.APPLICATION_PART__NAME:
				setName((String)newValue);
				return;
			case KbPackage.APPLICATION_PART__SETS:
				getSets().clear();
				getSets().addAll((Collection<? extends ApplicationPartSet>)newValue);
				return;
			case KbPackage.APPLICATION_PART__TYPE:
				setType((ApplicationPartType)newValue);
				return;
			case KbPackage.APPLICATION_PART__INDEX:
				setIndex((Integer)newValue);
				return;
			case KbPackage.APPLICATION_PART__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case KbPackage.APPLICATION_PART__SOURCE_FILE_PATH:
				setSourceFilePath((String)newValue);
				return;
			case KbPackage.APPLICATION_PART__DECLARING_CODE:
				setDeclaringCode((ApplicationPart)newValue);
				return;
			case KbPackage.APPLICATION_PART__START_LINE:
				setStartLine((Integer)newValue);
				return;
			case KbPackage.APPLICATION_PART__END_LINE:
				setEndLine((Integer)newValue);
				return;
			case KbPackage.APPLICATION_PART__DATUM_SIZE:
				setDatumSize((Integer)newValue);
				return;
			case KbPackage.APPLICATION_PART__DATUM_LOWER_BOUND:
				setDatumLowerBound((Integer)newValue);
				return;
			case KbPackage.APPLICATION_PART__DATUM_UPPER_BOUND:
				setDatumUpperBound((Integer)newValue);
				return;
			case KbPackage.APPLICATION_PART__IN_SYSTEM_FILE:
				setInSystemFile((Boolean)newValue);
				return;
			case KbPackage.APPLICATION_PART__WEIGHT:
				setWeight((Double)newValue);
				return;
			case KbPackage.APPLICATION_PART__APPLICATION_PARTS:
				getApplicationParts().clear();
				getApplicationParts().addAll((Collection<? extends ApplicationPart>)newValue);
				return;
			case KbPackage.APPLICATION_PART__USES:
				getUses().clear();
				getUses().addAll((Collection<? extends UseTarget>)newValue);
				return;
			case KbPackage.APPLICATION_PART__TARGET_OF:
				getTargetOf().clear();
				getTargetOf().addAll((Collection<? extends UseTarget>)newValue);
				return;
			case KbPackage.APPLICATION_PART__BODY:
				setBody((CodeBlock)newValue);
				return;
			case KbPackage.APPLICATION_PART__CONTAINS_IFDEF:
				setContainsIfdef((Boolean)newValue);
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
			case KbPackage.APPLICATION_PART__ID:
				setId(ID_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__NAME:
				setName(NAME_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__SETS:
				getSets().clear();
				return;
			case KbPackage.APPLICATION_PART__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__INDEX:
				setIndex(INDEX_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__PROPERTIES:
				getProperties().clear();
				return;
			case KbPackage.APPLICATION_PART__SOURCE_FILE_PATH:
				setSourceFilePath(SOURCE_FILE_PATH_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__DECLARING_CODE:
				setDeclaringCode((ApplicationPart)null);
				return;
			case KbPackage.APPLICATION_PART__START_LINE:
				setStartLine(START_LINE_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__END_LINE:
				setEndLine(END_LINE_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__DATUM_SIZE:
				setDatumSize(DATUM_SIZE_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__DATUM_LOWER_BOUND:
				setDatumLowerBound(DATUM_LOWER_BOUND_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__DATUM_UPPER_BOUND:
				setDatumUpperBound(DATUM_UPPER_BOUND_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__IN_SYSTEM_FILE:
				setInSystemFile(IN_SYSTEM_FILE_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case KbPackage.APPLICATION_PART__APPLICATION_PARTS:
				getApplicationParts().clear();
				return;
			case KbPackage.APPLICATION_PART__USES:
				getUses().clear();
				return;
			case KbPackage.APPLICATION_PART__TARGET_OF:
				getTargetOf().clear();
				return;
			case KbPackage.APPLICATION_PART__BODY:
				setBody((CodeBlock)null);
				return;
			case KbPackage.APPLICATION_PART__CONTAINS_IFDEF:
				setContainsIfdef(CONTAINS_IFDEF_EDEFAULT);
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
			case KbPackage.APPLICATION_PART__ID:
				return id != ID_EDEFAULT;
			case KbPackage.APPLICATION_PART__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case KbPackage.APPLICATION_PART__SETS:
				return sets != null && !sets.isEmpty();
			case KbPackage.APPLICATION_PART__TYPE:
				return type != TYPE_EDEFAULT;
			case KbPackage.APPLICATION_PART__INDEX:
				return index != INDEX_EDEFAULT;
			case KbPackage.APPLICATION_PART__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case KbPackage.APPLICATION_PART__SOURCE_FILE_PATH:
				return SOURCE_FILE_PATH_EDEFAULT == null ? sourceFilePath != null : !SOURCE_FILE_PATH_EDEFAULT.equals(sourceFilePath);
			case KbPackage.APPLICATION_PART__DECLARING_CODE:
				return basicGetDeclaringCode() != null;
			case KbPackage.APPLICATION_PART__START_LINE:
				return startLine != START_LINE_EDEFAULT;
			case KbPackage.APPLICATION_PART__END_LINE:
				return endLine != END_LINE_EDEFAULT;
			case KbPackage.APPLICATION_PART__DATUM_SIZE:
				return datumSize != DATUM_SIZE_EDEFAULT;
			case KbPackage.APPLICATION_PART__DATUM_LOWER_BOUND:
				return datumLowerBound != DATUM_LOWER_BOUND_EDEFAULT;
			case KbPackage.APPLICATION_PART__DATUM_UPPER_BOUND:
				return datumUpperBound != DATUM_UPPER_BOUND_EDEFAULT;
			case KbPackage.APPLICATION_PART__IN_SYSTEM_FILE:
				return inSystemFile != IN_SYSTEM_FILE_EDEFAULT;
			case KbPackage.APPLICATION_PART__GLOBAL:
				return isGlobal() != GLOBAL_EDEFAULT;
			case KbPackage.APPLICATION_PART__SHORT_LOCATION:
				return SHORT_LOCATION_EDEFAULT == null ? getShortLocation() != null : !SHORT_LOCATION_EDEFAULT.equals(getShortLocation());
			case KbPackage.APPLICATION_PART__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case KbPackage.APPLICATION_PART__SECURITY_PROPERTIES:
				return !getSecurityProperties().isEmpty();
			case KbPackage.APPLICATION_PART__PARAMETERS:
				return !getParameters().isEmpty();
			case KbPackage.APPLICATION_PART__ASSET:
				return isAsset() != ASSET_EDEFAULT;
			case KbPackage.APPLICATION_PART__DISABLED_ASSET:
				return isDisabledAsset() != DISABLED_ASSET_EDEFAULT;
			case KbPackage.APPLICATION_PART__APPLICATION_PARTS:
				return applicationParts != null && !applicationParts.isEmpty();
			case KbPackage.APPLICATION_PART__USES:
				return uses != null && !uses.isEmpty();
			case KbPackage.APPLICATION_PART__TARGET_OF:
				return targetOf != null && !targetOf.isEmpty();
			case KbPackage.APPLICATION_PART__BODY:
				return body != null;
			case KbPackage.APPLICATION_PART__CONTAINS_IFDEF:
				return containsIfdef != CONTAINS_IFDEF_EDEFAULT;
			case KbPackage.APPLICATION_PART__APPLICATION_PARTS_COUNT:
				return getApplicationPartsCount() != APPLICATION_PARTS_COUNT_EDEFAULT;
			case KbPackage.APPLICATION_PART__ASSETS:
				return !getAssets().isEmpty();
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
			case KbPackage.APPLICATION_PART___CONTAINS__APPLICATIONPART:
				return contains((ApplicationPart)arguments.get(0));
			case KbPackage.APPLICATION_PART___HASH_CODE:
				return hashCode();
			case KbPackage.APPLICATION_PART___EQUALS__OBJECT:
				return equals(arguments.get(0));
			case KbPackage.APPLICATION_PART___TO_STRING:
				return toString();
			case KbPackage.APPLICATION_PART___IS_DATUM:
				return isDatum();
			case KbPackage.APPLICATION_PART___IS_CODE:
				return isCode();
			case KbPackage.APPLICATION_PART___CONTAINS_ASSET:
				return containsAsset();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ApplicationPartImpl

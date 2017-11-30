/**
 */
package it.polito.security.esp.kb.impl;

import com.google.common.base.Objects;

import it.polito.security.esp.kb.KbPackage;
import it.polito.security.esp.kb.CodeBlock;
import it.polito.security.esp.kb.CodeBlockType;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.polito.security.esp.kb.impl.CodeBlockImpl#getType <em>Type</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.CodeBlockImpl#getCodeBlocks <em>Code Blocks</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.CodeBlockImpl#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.CodeBlockImpl#getEndLine <em>End Line</em>}</li>
 *   <li>{@link it.polito.security.esp.kb.impl.CodeBlockImpl#getSourceFilePath <em>Source File Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodeBlockImpl extends MinimalEObjectImpl.Container implements CodeBlock
{
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final CodeBlockType TYPE_EDEFAULT = CodeBlockType.FOR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected CodeBlockType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCodeBlocks() <em>Code Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodeBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeBlock> codeBlocks;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeBlockImpl()
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
		return KbPackage.Literals.CODE_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeBlockType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(CodeBlockType newType)
	{
		CodeBlockType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.CODE_BLOCK__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeBlock> getCodeBlocks()
	{
		if (codeBlocks == null)
		{
			codeBlocks = new EObjectContainmentEList<CodeBlock>(CodeBlock.class, this, KbPackage.CODE_BLOCK__CODE_BLOCKS);
		}
		return codeBlocks;
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
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.CODE_BLOCK__START_LINE, oldStartLine, startLine));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.CODE_BLOCK__END_LINE, oldEndLine, endLine));
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
			eNotify(new ENotificationImpl(this, Notification.SET, KbPackage.CODE_BLOCK__SOURCE_FILE_PATH, oldSourceFilePath, sourceFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int hashCode()
	{
		int result = 17;
		int _hashCode = this.getType().toString().hashCode();
		int _plus = ((31 * result) + _hashCode);
		result = _plus;
		int _hashCode_1 = this.getSourceFilePath().hashCode();
		int _plus_1 = ((31 * result) + _hashCode_1);
		result = _plus_1;
		int _hashCode_2 = Integer.valueOf(this.getStartLine()).toString().hashCode();
		int _plus_2 = ((31 * result) + _hashCode_2);
		result = _plus_2;
		int _hashCode_3 = Integer.valueOf(this.getEndLine()).toString().hashCode();
		int _plus_3 = ((31 * result) + _hashCode_3);
		result = _plus_3;
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
			if ((object instanceof CodeBlock))
			{
				return (((Objects.equal(this.getType(), ((CodeBlock)object).getType()) && Objects.equal(this.getSourceFilePath(), ((CodeBlock)object).getSourceFilePath())) && (this.getStartLine() == ((CodeBlock)object).getStartLine())) && 
					(this.getEndLine() == ((CodeBlock)object).getEndLine()));
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
		CodeBlockType _type = this.getType();
		String _plus = (_type + " from ");
		int _startLine = this.getStartLine();
		String _plus_1 = (_plus + Integer.valueOf(_startLine));
		String _plus_2 = (_plus_1 + " to ");
		int _endLine = this.getEndLine();
		return (_plus_2 + Integer.valueOf(_endLine));
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
			case KbPackage.CODE_BLOCK__CODE_BLOCKS:
				return ((InternalEList<?>)getCodeBlocks()).basicRemove(otherEnd, msgs);
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
			case KbPackage.CODE_BLOCK__TYPE:
				return getType();
			case KbPackage.CODE_BLOCK__CODE_BLOCKS:
				return getCodeBlocks();
			case KbPackage.CODE_BLOCK__START_LINE:
				return getStartLine();
			case KbPackage.CODE_BLOCK__END_LINE:
				return getEndLine();
			case KbPackage.CODE_BLOCK__SOURCE_FILE_PATH:
				return getSourceFilePath();
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
			case KbPackage.CODE_BLOCK__TYPE:
				setType((CodeBlockType)newValue);
				return;
			case KbPackage.CODE_BLOCK__CODE_BLOCKS:
				getCodeBlocks().clear();
				getCodeBlocks().addAll((Collection<? extends CodeBlock>)newValue);
				return;
			case KbPackage.CODE_BLOCK__START_LINE:
				setStartLine((Integer)newValue);
				return;
			case KbPackage.CODE_BLOCK__END_LINE:
				setEndLine((Integer)newValue);
				return;
			case KbPackage.CODE_BLOCK__SOURCE_FILE_PATH:
				setSourceFilePath((String)newValue);
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
			case KbPackage.CODE_BLOCK__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case KbPackage.CODE_BLOCK__CODE_BLOCKS:
				getCodeBlocks().clear();
				return;
			case KbPackage.CODE_BLOCK__START_LINE:
				setStartLine(START_LINE_EDEFAULT);
				return;
			case KbPackage.CODE_BLOCK__END_LINE:
				setEndLine(END_LINE_EDEFAULT);
				return;
			case KbPackage.CODE_BLOCK__SOURCE_FILE_PATH:
				setSourceFilePath(SOURCE_FILE_PATH_EDEFAULT);
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
			case KbPackage.CODE_BLOCK__TYPE:
				return type != TYPE_EDEFAULT;
			case KbPackage.CODE_BLOCK__CODE_BLOCKS:
				return codeBlocks != null && !codeBlocks.isEmpty();
			case KbPackage.CODE_BLOCK__START_LINE:
				return startLine != START_LINE_EDEFAULT;
			case KbPackage.CODE_BLOCK__END_LINE:
				return endLine != END_LINE_EDEFAULT;
			case KbPackage.CODE_BLOCK__SOURCE_FILE_PATH:
				return SOURCE_FILE_PATH_EDEFAULT == null ? sourceFilePath != null : !SOURCE_FILE_PATH_EDEFAULT.equals(sourceFilePath);
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
			case KbPackage.CODE_BLOCK___HASH_CODE:
				return hashCode();
			case KbPackage.CODE_BLOCK___EQUALS__OBJECT:
				return equals(arguments.get(0));
			case KbPackage.CODE_BLOCK___TO_STRING:
				return toString();
		}
		return super.eInvoke(operationID, arguments);
	}

} //CodeBlockImpl

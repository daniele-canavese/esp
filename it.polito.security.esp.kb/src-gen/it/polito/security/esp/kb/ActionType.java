/**
 */
package it.polito.security.esp.kb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

import it.polito.security.ontologies.annotations.MapsToIndividual;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Action Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The action types.
 * <!-- end-model-doc -->
 * @see it.polito.security.esp.kb.KbPackage#getActionType()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#ActionType",
	name = "http://security.polito.it/esp/kb#",
	singleton = true
)
public enum ActionType implements Enumerator
{
	/**
	 * The '<em><b>DECRYPT AES128 CBC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECRYPT_AES128_CBC_VALUE
	 * @generated
	 * @ordered
	 */
	DECRYPT_AES128_CBC(0, "DECRYPT_AES128_CBC", "decryptAES128-CBC"),

	/**
	 * The '<em><b>DECRYPT AES128 ECB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECRYPT_AES128_ECB_VALUE
	 * @generated
	 * @ordered
	 */
	DECRYPT_AES128_ECB(0, "DECRYPT_AES128_ECB", "decryptAES128-ECB"),

	/**
	 * The '<em><b>ENCRYPT AES128 CBC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENCRYPT_AES128_CBC_VALUE
	 * @generated
	 * @ordered
	 */
	ENCRYPT_AES128_CBC(0, "ENCRYPT_AES128_CBC", "encryptAES128-CBC"),

	/**
	 * The '<em><b>ENCRYPT AES128 ECB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENCRYPT_AES128_ECB_VALUE
	 * @generated
	 * @ordered
	 */
	ENCRYPT_AES128_ECB(0, "ENCRYPT_AES128_ECB", "encryptAES128-ECB"),

	/**
	 * The '<em><b>ATTEST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATTEST_VALUE
	 * @generated
	 * @ordered
	 */
	ATTEST(0, "ATTEST", "attest"),

	/**
	 * The '<em><b>ACCESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCESS_VALUE
	 * @generated
	 * @ordered
	 */
	ACCESS(0, "ACCESS", "access");

	/**
	 * The '<em><b>DECRYPT AES128 CBC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DECRYPT AES128 CBC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECRYPT_AES128_CBC
	 * @model literal="decryptAES128-CBC"
	 * @generated
	 * @ordered
	 */
	public static final int DECRYPT_AES128_CBC_VALUE = 0;

	/**
	 * The '<em><b>DECRYPT AES128 ECB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DECRYPT AES128 ECB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECRYPT_AES128_ECB
	 * @model literal="decryptAES128-ECB"
	 * @generated
	 * @ordered
	 */
	public static final int DECRYPT_AES128_ECB_VALUE = 0;

	/**
	 * The '<em><b>ENCRYPT AES128 CBC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENCRYPT AES128 CBC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENCRYPT_AES128_CBC
	 * @model literal="encryptAES128-CBC"
	 * @generated
	 * @ordered
	 */
	public static final int ENCRYPT_AES128_CBC_VALUE = 0;

	/**
	 * The '<em><b>ENCRYPT AES128 ECB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENCRYPT AES128 ECB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENCRYPT_AES128_ECB
	 * @model literal="encryptAES128-ECB"
	 * @generated
	 * @ordered
	 */
	public static final int ENCRYPT_AES128_ECB_VALUE = 0;

	/**
	 * The '<em><b>ATTEST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ATTEST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATTEST
	 * @model literal="attest"
	 * @generated
	 * @ordered
	 */
	public static final int ATTEST_VALUE = 0;

	/**
	 * The '<em><b>ACCESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACCESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCESS
	 * @model literal="access"
	 * @generated
	 * @ordered
	 */
	public static final int ACCESS_VALUE = 0;

	/**
	 * An array of all the '<em><b>Action Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ActionType[] VALUES_ARRAY =
		new ActionType[]
		{
			DECRYPT_AES128_CBC,
			DECRYPT_AES128_ECB,
			ENCRYPT_AES128_CBC,
			ENCRYPT_AES128_ECB,
			ATTEST,
			ACCESS,
		};

	/**
	 * A public read-only list of all the '<em><b>Action Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ActionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Action Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ActionType get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ActionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Action Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ActionType getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ActionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Action Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ActionType get(int value)
	{
		switch (value)
		{
			case DECRYPT_AES128_CBC_VALUE: return DECRYPT_AES128_CBC;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ActionType(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
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
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //ActionType

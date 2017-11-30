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
 * A representation of the literals of the enumeration '<em><b>Protection Flag</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * The protection flags.
 * <!-- end-model-doc -->
 * @see it.polito.security.esp.kb.KbPackage#getProtectionFlag()
 * @model
 * @generated
 */
@MapsToIndividual
(
	iri = "http://security.polito.it/esp/kb#ProtectionFlag",
	name = "http://security.polito.it/esp/kb#",
	singleton = true
)
public enum ProtectionFlag implements Enumerator
{
	/**
	 * The '<em><b>WHOLE FUNCTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WHOLE_FUNCTION_VALUE
	 * @generated
	 * @ordered
	 */
	WHOLE_FUNCTION(0, "WHOLE_FUNCTION", "wholeFunction"),

	/**
	 * The '<em><b>ONE PER FUNCTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONE_PER_FUNCTION_VALUE
	 * @generated
	 * @ordered
	 */
	ONE_PER_FUNCTION(0, "ONE_PER_FUNCTION", "onePerFunction"),

	/**
	 * The '<em><b>MERGE ATTESTATORS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MERGE_ATTESTATORS_VALUE
	 * @generated
	 * @ordered
	 */
	MERGE_ATTESTATORS(0, "MERGE_ATTESTATORS", "mergeAttestators");

	/**
	 * The '<em><b>WHOLE FUNCTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WHOLE FUNCTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WHOLE_FUNCTION
	 * @model literal="wholeFunction"
	 * @generated
	 * @ordered
	 */
	public static final int WHOLE_FUNCTION_VALUE = 0;

	/**
	 * The '<em><b>ONE PER FUNCTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ONE PER FUNCTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONE_PER_FUNCTION
	 * @model literal="onePerFunction"
	 * @generated
	 * @ordered
	 */
	public static final int ONE_PER_FUNCTION_VALUE = 0;

	/**
	 * The '<em><b>MERGE ATTESTATORS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MERGE ATTESTATORS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MERGE_ATTESTATORS
	 * @model literal="mergeAttestators"
	 * @generated
	 * @ordered
	 */
	public static final int MERGE_ATTESTATORS_VALUE = 0;

	/**
	 * An array of all the '<em><b>Protection Flag</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ProtectionFlag[] VALUES_ARRAY =
		new ProtectionFlag[]
		{
			WHOLE_FUNCTION,
			ONE_PER_FUNCTION,
			MERGE_ATTESTATORS,
		};

	/**
	 * A public read-only list of all the '<em><b>Protection Flag</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ProtectionFlag> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Protection Flag</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ProtectionFlag get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ProtectionFlag result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Protection Flag</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ProtectionFlag getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			ProtectionFlag result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Protection Flag</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ProtectionFlag get(int value)
	{
		switch (value)
		{
			case WHOLE_FUNCTION_VALUE: return WHOLE_FUNCTION;
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
	private ProtectionFlag(int value, String name, String literal)
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
	
} //ProtectionFlag

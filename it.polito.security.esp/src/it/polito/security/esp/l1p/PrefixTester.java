package it.polito.security.esp.l1p;

import java.util.List;

/**
 * A permutation prefix checker.
 * @author Daniele Canavese
 * @param <T>
 *            The type of the array elements.
 **/
public interface PrefixTester<T>
{
	/**
	 * Checks if a vector prefix is valid. This method must check if the first @a size elements of @a vector are valid.
	 * @param vector
	 *            The vector to check.
	 * @param size
	 *            The number of elements to check.
	 * @return <code>true</code> if the prefix is valid, <code>false</code> otherwise.
	 **/
	public boolean isValid(List<T> vector, int size);
}

package it.polito.security.esp.ui.dialogs;

/**
 * A pair of two objects.
 * @author Daniele Canavese
 **/
public class Pair<K, V>
{
	/** The key. **/
	private K key;
	/** The value. **/
	private V value;

	/**
	 * Creates the pair.
	 * @param key
	 *            The key.
	 * @param value
	 *            The value.
	 **/
	public Pair(K key, V value)
	{
		this.key = key;
		this.value = value;
	}

	/**
	 * Retrieves the key.
	 * @return The key.
	 **/
	public K getKey()
	{
		return key;
	}

	/**
	 * Retrieves the value.
	 * @return The value.
	 */
	public V getValue()
	{
		return value;
	}
}

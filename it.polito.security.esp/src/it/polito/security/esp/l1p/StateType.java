package it.polito.security.esp.l1p;

/**
 * The state type in a transposition table.
 * @author Daniele Canavese
 **/
public enum StateType
{
	/** A node with an exact score. **/
	EXACT_NODE,
	/** A node with an upper bound value. **/
	UPPER_NODE,
	/** A node with a lower bound value. **/
	LOWER_NODE,
	/** A node with an invalid value. **/
	INVALID_NODE
}

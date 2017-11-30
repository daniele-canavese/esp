package it.polito.security.esp.l1p;

/**
 * The measure types.
 * @author Daniele Canavese
 **/
public enum MeasureType
{
	/** The confusion related to an asset. **/
	UNCERTAINTY,
	/** The number of instructions moved to a safe server. **/
	REMOTE_INSTRUCTIONS,
	/** The ability to detect an unwanted modification. **/
	ALTERATION_DETECTION,
	/** The ability to negate an unwanted modification. **/
	ALTERATION_AVOIDANCE
}

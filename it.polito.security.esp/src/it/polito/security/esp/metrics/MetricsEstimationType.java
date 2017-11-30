package it.polito.security.esp.metrics;

/**
 * The metrics estimation type.
 * @author Daniele Canavese
 **/
public enum MetricsEstimationType
{
	/** Use always the ACTC to compute a metric. Works everywhere. **/
	ACTC,
	/** Fast estimation with asset-independent factors. Works everywhere. **/
	FAST1,
	/** Fast estimation with asset-dependent factors. Works everywhere. **/
	FAST2,
	/** Full estimation approach. Only for the minimax search. **/
	FULL
}

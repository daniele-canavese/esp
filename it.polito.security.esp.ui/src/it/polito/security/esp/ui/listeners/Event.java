package it.polito.security.esp.ui.listeners;

/**
 * A non-hierarchical event.
 * @author Daniele Canavese
 **/
public enum Event
{
	/** One or more application part has been updated. **/
	APPLICATION_PARTS_UPDATED,
	/** The attacker has been updated. **/
	ATTACKER_UPDATED,
	/** One or more attack path has been updated. **/
	ATTACK_PATH_UPDATED,
	/** One or more attack step has been updated. **/
	ATTACK_STEP_UPDATED,
	/** One or more protection has been updated. **/
	PROTECTIONS_UPDATED,
	/** The solutions have been updated. **/
	SOLUTIONS_UPDATED
}

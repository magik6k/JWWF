package net.magik6k.jwwf.event;

import net.magik6k.jwwf.core.User;

public interface JwwfEvent {

	/**
	 * Returns instance of user for which the event was fired
	 *
	 * @return User instance or null if no user is associated with this event
	 */
	public User getUser();
}

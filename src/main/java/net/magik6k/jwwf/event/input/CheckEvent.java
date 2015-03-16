package net.magik6k.jwwf.event.input;

import net.magik6k.jwwf.core.User;

public class CheckEvent extends BasicInputEvent {
	private final boolean state;

	public CheckEvent(User user, Object payload, boolean state) {
		super(user, payload);
		this.state = state;
	}

	/**
	 * @return Returns new state of checkable widget
	 */
	public boolean getState() {
		return state;
	}
}

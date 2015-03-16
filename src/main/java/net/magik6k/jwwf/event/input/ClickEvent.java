package net.magik6k.jwwf.event.input;

import net.magik6k.jwwf.core.User;

public class ClickEvent extends BasicInputEvent {

	public ClickEvent(User user, Object payload) {
		super(user, payload);
	}
}

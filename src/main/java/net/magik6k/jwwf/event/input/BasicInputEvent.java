package net.magik6k.jwwf.event.input;

import net.magik6k.jwwf.core.User;
import net.magik6k.jwwf.event.InputEvent;

public class BasicInputEvent implements InputEvent {
	private final User user;
	private final Object payload;

	public BasicInputEvent(User user, Object payload) {
		this.user = user;
		this.payload = payload;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public Object getPayload() {
		return payload;
	}
}

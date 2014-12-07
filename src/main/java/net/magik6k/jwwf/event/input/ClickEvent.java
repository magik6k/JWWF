package net.magik6k.jwwf.event.input;

import net.magik6k.jwwf.core.User;
import net.magik6k.jwwf.event.InputEvent;

public class ClickEvent implements InputEvent{
	private final User user;
	
	public ClickEvent(User user){
		this.user = user;
	}
	
	@Override
	public User getUser() {
		return user;
	}

}

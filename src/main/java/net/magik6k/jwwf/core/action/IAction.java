package net.magik6k.jwwf.core.action;

import net.magik6k.jwwf.core.UserState;

public interface IAction {
	public void performAction(UserState userState, String data);
}

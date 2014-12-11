package net.magik6k.jwwf.core.action;

import net.magik6k.jwwf.core.UserState;

public class UserData implements IAction {

	@Override
	public void performAction(UserState userState, String data) {
		userState.userDataRecv((String)data.subSequence(1, data.indexOf(";")), 
				(String)data.subSequence( data.indexOf(";")+1, data.length()));
	}

}

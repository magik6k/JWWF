package net.magik6k.jwwf.core.action;

import net.magik6k.jwwf.core.UserState;

public class ButtonClick implements IAction {

	@Override
	public void performAction(UserState userState, String data) {
		try {
			userState.pushDataToWidget(
					userState.actionHandlers.get(new Integer((String) data.subSequence(1, data.length()))), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

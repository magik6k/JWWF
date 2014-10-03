package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.Actions;
import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;
import net.magik6k.jwwf.handlers.CheckHandler;

public class CheckBox extends Widget{
	private CheckHandler clickHandler;
	/**
	 * @param user Destination user
	 * @param label Default label
	 */
	public CheckBox(User user, CheckHandler clickHandler) {
		super(user, Actions.CHECK_STATE);
		this.clickHandler = clickHandler;
		this.sendElement();
	}
	
	@Override
	public String getName() {
		return "CheckBox";
	}

	@Override
	public String getData() {
		return "{}";
	}
	
	/**
	 * Internal use only
	 */
	public void handleData(String data){
		clickHandler.checked(data.equals("1"));
	}
}

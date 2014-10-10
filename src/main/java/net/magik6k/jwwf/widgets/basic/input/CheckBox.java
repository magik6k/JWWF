package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Actions;
import net.magik6k.jwwf.handlers.CheckHandler;

/**
 * Basic check box
 */
public class CheckBox extends Widget{
	private CheckHandler checkHandler;
	/**
	 * @param checkHandler handler claaed when checkbox changes it's state
	 */
	public CheckBox(CheckHandler checkHandler) {
		super(Actions.CHECK_STATE);
		this.checkHandler = checkHandler;
		this.sendElement();
	}
	
	/**
	 * Sets new handler for button click
	 * @param checkHandler New handler
	 */
	public void setHandler(CheckHandler checkHandler){
		this.checkHandler = checkHandler;
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
		checkHandler.checked(data.equals("1"));
	}
}

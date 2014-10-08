package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Actions;
import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.handlers.CheckHandler;
import net.magik6k.jwwf.handlers.ClickHandler;

/**
 * Basic check box
 */
public class CheckBox extends Widget{
	private CheckHandler checkHandler;
	/**
	 * @param label Default label
	 */
	public CheckBox(CheckHandler clickHandler) {
		super(Actions.CHECK_STATE);
		this.checkHandler = clickHandler;
		this.sendElement();
	}
	
	/**
	 * Sets new handler for button click
	 * @param checkHandler New handler
	 */
	public void setHandler(CheckHandler clickHandler){
		this.checkHandler = clickHandler;
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

package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Actions;
import net.magik6k.jwwf.handlers.CheckHandler;

/**
 * Basic check box
 */
public class CheckBox extends Widget{
	private CheckHandler checkHandler;
	private boolean state;
	
	/**
	 * @param checkHandler handler called when checkbox changes it's state
	 */
	public CheckBox(CheckHandler checkHandler) {
		super(Actions.CHECK_STATE);
		this.checkHandler = checkHandler;
		this.sendElement();
	}
	
	public CheckBox() {
		super(Actions.CHECK_STATE);
		this.sendElement();
	}
	
	/**
	 * Sets new check handler
	 * @param checkHandler New handler
	 * @return This instance for chaining
	 */
	public CheckBox setHandler(CheckHandler checkHandler){
		this.checkHandler = checkHandler;
		return this;
	}
	
	/**
	 * Returns boolean indicating checkbox selection
	 * @return State of this widget
	 */
	public boolean getState(){
		return state;
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
		state = data.equals("1");
		if(checkHandler != null)
			checkHandler.checked(state);
	}
}

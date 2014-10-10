package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Actions;
import net.magik6k.jwwf.util.RadioGroup;

public class RadioButton extends Widget{
	private RadioGroup radioGroup;
	private Object userdata;
	/**
	 * @param label Default label
	 */
	public RadioButton(RadioGroup radioGroup) {
		super(Actions.SELECT);
		attach(radioGroup);
		this.radioGroup = radioGroup;
		this.sendElement();
	}
	
	public RadioButton(RadioGroup radioGroup, Object userdata) {
		super(Actions.CHECK_STATE);
		attach(radioGroup);
		this.radioGroup = radioGroup;
		this.userdata = userdata;
		this.sendElement();
	}
	
	/**
	 * Sets new handler for button click
	 * @param checkHandler New handler
	 */
	public void setGroup(RadioGroup radioGroup){
		this.radioGroup = radioGroup;
		attach(radioGroup);
	}
	
	@Override
	public String getName() {
		return "RadioButton";
	}

	@Override
	public String getData() {
		return "{\"group\":"+String.valueOf(radioGroup.getID())+"}";
	}
	
	/**
	 * Internal use only
	 */
	public void handleData(String data){
		radioGroup.select(userdata);
	}
}

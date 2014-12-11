package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.core.action.Actions;
import net.magik6k.jwwf.util.RadioGroup;

/**
 * As part of {@link RadioGroup} acts as option in single-selection group
 */
public class RadioButton extends Widget{
	private RadioGroup radioGroup;
	private Object userdata;
	/**
	 * @param radioGroup Default group to bind button to
	 */
	public RadioButton(RadioGroup radioGroup) {
		super(Actions.SELECT);
		attach(radioGroup);
		this.radioGroup = radioGroup;
		this.sendElement();
	}
	
	/**
	 * @param radioGroup Default group to bind button to
	 * @param userdata data to store in button
	 */
	public RadioButton(RadioGroup radioGroup, Object userdata) {
		super(Actions.CHECK_STATE);
		attach(radioGroup);
		this.radioGroup = radioGroup;
		this.userdata = userdata;
		this.sendElement();
	}
	
	/**
	 * Sets new handler for button click
	 * @param radioGroup group to bind button to
	 * @return This instance for chaining
	 */
	public RadioButton setGroup(RadioGroup radioGroup){
		this.radioGroup = radioGroup;
		attach(radioGroup);
		return this;
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

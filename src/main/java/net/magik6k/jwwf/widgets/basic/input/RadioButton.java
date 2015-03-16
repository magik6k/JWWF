package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.core.action.Actions;
import net.magik6k.jwwf.util.RadioGroup;

/**
 * As part of {@link RadioGroup} acts as option in single-selection group
 */
public class RadioButton extends Widget {
	private RadioGroup radioGroup;
	private String label = "";
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
	 * @param label      Label
	 * @param radioGroup Default group to bind button to
	 */
	public RadioButton(String label, RadioGroup radioGroup) {
		super(Actions.SELECT);
		attach(radioGroup);
		this.label = label;
		this.radioGroup = radioGroup;
		this.sendElement();
	}

	/**
	 * @param radioGroup Default group to bind button to
	 * @param userdata   data to store in button
	 */
	public RadioButton(RadioGroup radioGroup, Object userdata) {
		super(Actions.CHECK_STATE);
		attach(radioGroup);
		this.radioGroup = radioGroup;
		this.userdata = userdata;
		this.sendElement();
	}

	/**
	 * @param label      Label
	 * @param radioGroup Default group to bind button to
	 * @param userdata   data to store in button
	 */
	public RadioButton(String label, RadioGroup radioGroup, Object userdata) {
		super(Actions.CHECK_STATE);
		attach(radioGroup);
		this.label = label;
		this.radioGroup = radioGroup;
		this.userdata = userdata;
		this.sendElement();
	}

	/**
	 * Sets new handler for button click
	 *
	 * @param radioGroup group to bind button to
	 * @return This instance for chaining
	 */
	public RadioButton setGroup(RadioGroup radioGroup) {
		this.radioGroup = radioGroup;
		attach(radioGroup);
		return this;
	}

	/**
	 * @param label Label to set
	 * @return This RadioButton
	 */
	public RadioButton setLabel(String label) {
		this.label = label;
		this.sendElement();
		return this;
	}

	@Override
	public String getName() {
		return "RadioButton";
	}

	@Override
	public String getData() {
		return "{\"group\":" + String.valueOf(radioGroup.getID()) + ", \"label\":\"" + label + "\"}";
	}

	/**
	 * Internal use only
	 *
	 * @param data Data
	 */
	public void handleData(String data) {
		radioGroup.select(userdata);
	}
}

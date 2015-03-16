package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.action.Actions;
import net.magik6k.jwwf.event.input.CheckEvent;
import net.magik6k.jwwf.handlers.CheckHandler;
import net.magik6k.jwwf.util.Json;
import net.magik6k.jwwf.widgets.basic.input.generic.BasicInput;

public class CheckButton extends BasicInput {
	private CheckHandler checkHandler;
	private boolean state;
	private String label;

	/**
	 * @param checkHandler handler called when checkbox changes it's state
	 */
	public CheckButton(CheckHandler checkHandler) {
		super(Actions.CHECK_STATE);
		this.checkHandler = checkHandler;
		this.sendElement();
	}

	/**
	 * @param label        Button label
	 * @param checkHandler handler called when checkbox changes it's state
	 */
	public CheckButton(String label, CheckHandler checkHandler) {
		super(Actions.CHECK_STATE);
		this.label = label;
		this.checkHandler = checkHandler;
		this.sendElement();
	}

	/**
	 * @param label Button label
	 */
	public CheckButton(String label) {
		super(Actions.CHECK_STATE);
		this.label = label;
		this.sendElement();
	}

	public CheckButton() {
		super(Actions.CHECK_STATE);
		this.sendElement();
	}

	/**
	 * Sets new check handler
	 *
	 * @param checkHandler New handler
	 * @return This instance for chaining
	 */
	public CheckButton setHandler(CheckHandler checkHandler) {
		this.checkHandler = checkHandler;
		return this;
	}

	/**
	 * Returns boolean indicating checkbox selection
	 *
	 * @return State of this widget
	 */
	public boolean getState() {
		return state;
	}

	/**
	 * @param state New state
	 * @return This instance for chaining
	 */
	public CheckButton setSate(boolean state) {
		this.state = state;
		this.sendElement();
		return this;
	}

	/**
	 * @return Current button label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label Label to set
	 * @return This instance for chaining
	 */
	public CheckButton setLabel(String label) {
		this.label = label;
		this.sendElement();
		return this;
	}

	@Override
	public String getName() {
		return "CheckButton";
	}

	@Override
	public String getData() {
		return "{\"state\":" + String.valueOf(state) + ",\"label\":" + Json.escapeString(label) + "}";
	}

	/**
	 * Internal use only
	 *
	 * @param data Data
	 */
	public void handleData(String data) {
		state = data.equals("1");
		sendEvent(new CheckEvent(this.user, getPayload(), state));
		if (checkHandler != null)
			checkHandler.checked(state);
	}
}

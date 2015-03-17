package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.action.Actions;
import net.magik6k.jwwf.enums.Type;
import net.magik6k.jwwf.event.input.ClickEvent;
import net.magik6k.jwwf.handlers.ClickHandler;
import net.magik6k.jwwf.util.Json;
import net.magik6k.jwwf.widgets.basic.input.generic.BasicInput;

/**
 * User-clickable button
 */
public class Button extends BasicInput {
	private String label;
	private ClickHandler clickHandler;
	private Type type = Type.DEFAULT;

	/**
	 * @param label        Default label
	 * @param clickHandler handler to be invoked when button is pressed by user
	 * @param type Button type
	 */
	public Button(String label, Type type, ClickHandler clickHandler) {
		super(Actions.BUTTON_CLICK);
		this.type = type;
		this.label = label;
		this.clickHandler = clickHandler;
		this.sendElement();
	}

	/**
	 * @param label Default label
	 * @param type Button type
	 */
	public Button(String label, Type type) {
		super(Actions.BUTTON_CLICK);
		this.type = type;
		this.label = label;
		this.sendElement();
	}

	/**
	 * @param label        Default label
	 * @param clickHandler handler to be invoked when button is pressed by user
	 */
	public Button(String label, ClickHandler clickHandler) {
		super(Actions.BUTTON_CLICK);
		this.label = label;
		this.clickHandler = clickHandler;
		this.sendElement();
	}

	/**
	 * @param label Default label
	 */
	public Button(String label) {
		super(Actions.BUTTON_CLICK);
		this.label = label;
		this.sendElement();
	}

	/**
	 * Sets new label
	 *
	 * @param label Label
	 * @return This button
	 */
	public Button setLabel(String label) {
		this.label = label;
		this.sendElement();
		return this;
	}

	/**
	 * Sets type
	 *
	 * @param type Type to set
	 * @return This button
	 */
	public Button setType(Type type) {
		this.type = type;
		this.sendElement();
		return this;
	}

	/**
	 * Sets new handler for button click
	 *
	 * @param clickHandler New handler
	 * @return This button
	 */
	public Button setHandler(ClickHandler clickHandler) {
		this.clickHandler = clickHandler;
		return this;
	}

	@Override
	public String getName() {
		return "Button";
	}

	@Override
	public String getData() {
		return "{\"label\":" + Json.escapeString(label) + ", \"type\":\"" + type.name + "\"}";
	}

	/**
	 * Internal use only
	 *
	 * @param data Data
	 */
	protected void handleData(String data) {
		try {
			sendEvent(new ClickEvent(this.user, getPayload()));
			if (clickHandler != null)
				clickHandler.clicked();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

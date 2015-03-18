package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.action.Actions;
import net.magik6k.jwwf.enums.Type;
import net.magik6k.jwwf.event.input.TextInputEvent;
import net.magik6k.jwwf.handlers.TextHandler;
import net.magik6k.jwwf.util.Json;
import net.magik6k.jwwf.widgets.basic.input.generic.BasicInput;

/**
 * Input for passwords
 */
public class PasswordInput extends BasicInput {
	private Type status = Type.DEFAULT;
	private String placeholder;
	private String text = "";
	private boolean sendTextUpdate;
	private TextHandler handler;

	/**
	 * @param placeholder Hint text
	 * @param defaultText Default text
	 * @param status Initial status
	 * @param handler Text handler
	 */
	public PasswordInput(String placeholder, String defaultText, Type status, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.text = defaultText;
		sendTextUpdate = true;
		this.handler = handler;
		this.status = status;
		this.sendElement();
	}

	/**
	 * @param placeholder Hint text
	 * @param status Initial status
	 * @param handler Text handler
	 */
	public PasswordInput(String placeholder, Type status, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.handler = handler;
		this.status = status;
		this.sendElement();
	}

	/**
	 * @param placeholder Hint text
	 * @param defaultText Default text
	 * @param status Initial status
	 */
	public PasswordInput(String placeholder, String defaultText, Type status) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.text = defaultText;
		sendTextUpdate = true;
		this.status = status;
		this.sendElement();
	}

	/**
	 * @param placeholder Hint text
	 * @param status Initial status
	 */
	public PasswordInput(String placeholder, Type status) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.status = status;
		this.sendElement();
	}

	/**
	 * @param status Initial status
	 */
	public PasswordInput(Type status) {
		super(Actions.TEXT_INPUT);
		this.status = status;
		this.sendElement();
	}

	/**
	 * @param placeholder Hint text
	 * @param defaultText Default text
	 * @param handler     Text handler
	 */
	public PasswordInput(String placeholder, String defaultText, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.handler = handler;
		this.text = defaultText;
		sendTextUpdate = true;
		this.sendElement();
	}

	/**
	 * @param placeholder Hint text
	 * @param handler     Text handler
	 */
	public PasswordInput(String placeholder, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.handler = handler;
		this.sendElement();
	}

	/**
	 * @param placeholder Hint text
	 * @param defaultText Default text
	 */
	public PasswordInput(String placeholder, String defaultText) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.text = defaultText;
		sendTextUpdate = true;
		this.sendElement();
	}

	/**
	 * @param placeholder Hint text
	 */
	public PasswordInput(String placeholder) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.sendElement();
	}

	/**
	 * Sets new text
	 *
	 * @param text Text to set
	 * @return This PasswordInput
	 */
	public PasswordInput setText(String text) {
		this.text = text;
		sendTextUpdate = true;
		this.sendElement();
		return this;
	}

	/**
	 * Sets new placeholder text
	 *
	 * @param placeholder Placeholder text
	 * @return This PasswordInput
	 */
	public PasswordInput setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
		this.sendElement();
		return this;
	}

	/**
	 * Sets new TextHandler
	 *
	 * @param handler New text handler
	 * @return This PasswordInput
	 */
	public PasswordInput setTextHandler(TextHandler handler) {
		this.handler = handler;
		return this;
	}

	/**
	 * @param status Status to be set
	 * @return This PasswordInput
	 */
	public PasswordInput setStatus(Type status) {
		this.status = status;
		this.sendElement();
		return this;
	}

	/**
	 * Returns entered text
	 *
	 * @return Entered text
	 */
	public String getText() {
		return text;
	}

	@Override
	public String getName() {
		return "PasswordInput";
	}

	@Override
	public String getData() {
		if (sendTextUpdate) {
			sendTextUpdate = false;
			return "{\"placeholder\":" + Json.escapeString(placeholder) + ",\"text\":"
					+ Json.escapeString(text) + ", \"type\":\""+status.name+"\"}";
		}
		return "{\"placeholder\":" + Json.escapeString(placeholder) + ", \"type\":\""+status.name+"\"}";
	}

	/**
	 * Internal use only
	 *
	 * @param data Data
	 */
	public void handleData(String data) {
		if (data == null) return;
		text = data;
		sendEvent(new TextInputEvent(this.user, getPayload(), data));
		if (handler != null)
			handler.onType(data);
	}
}

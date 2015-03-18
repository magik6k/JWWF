package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.action.Actions;
import net.magik6k.jwwf.enums.Type;
import net.magik6k.jwwf.event.input.TextInputEvent;
import net.magik6k.jwwf.handlers.TextHandler;
import net.magik6k.jwwf.util.Json;
import net.magik6k.jwwf.widgets.basic.input.generic.BasicInput;

/**
 * Input for user data
 */
public class TextInput extends BasicInput {
	private Type status = Type.DEFAULT;
	private String placeholder;
	private String text = "";
	private boolean sendTextUpdate;
	private TextHandler handler;

	/**
	 * @param placeholder Hint text
	 * @param defaultText Default text
	 * @param status Initial status
	 * @param handler     Handler of typed text
	 */
	public TextInput(String placeholder, String defaultText, Type status, TextHandler handler) {
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
	 * @param handler     Handler of typed text
	 */
	public TextInput(String placeholder, Type status, TextHandler handler) {
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
	public TextInput(String placeholder, String defaultText, Type status) {
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
	public TextInput(String placeholder, Type status) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.status = status;
		this.sendElement();
	}

	/**
	 * @param status Initial status
	 */
	public TextInput(Type status) {
		super(Actions.TEXT_INPUT);
		this.status = status;
		this.sendElement();
	}

	/**
	 * @param placeholder Hint text
	 * @param defaultText Default text
	 * @param handler     Handler of typed text
	 */
	public TextInput(String placeholder, String defaultText, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.text = defaultText;
		sendTextUpdate = true;
		this.handler = handler;
		this.sendElement();
	}

	/**
	 * @param placeholder Hint text
	 * @param handler     Handler of typed text
	 */
	public TextInput(String placeholder, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.handler = handler;
		this.sendElement();
	}

	/**
	 * @param placeholder Hint text
	 * @param defaultText Default text
	 */
	public TextInput(String placeholder, String defaultText) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.text = defaultText;
		sendTextUpdate = true;
		this.sendElement();
	}

	/**
	 * @param placeholder Hint text
	 */
	public TextInput(String placeholder) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.sendElement();
	}

	public TextInput() {
		super(Actions.TEXT_INPUT);
		this.sendElement();
	}

	/**
	 * Sets new placeholder text
	 *
	 * @param placeholder Placeholder text
	 * @return This instance for chaining
	 */
	public TextInput setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
		this.sendElement();
		return this;
	}

	/**
	 * Sets new text
	 *
	 * @param text Text to set
	 * @return This instance for chaining
	 */
	public TextInput setText(String text) {
		this.text = text;
		sendTextUpdate = true;
		this.sendElement();
		return this;
	}

	/**
	 * Sets new TextHandler
	 *
	 * @param handler New text handler
	 * @return This TextInput
	 */
	public TextInput setTextHandler(TextHandler handler) {
		this.handler = handler;
		return this;
	}

	/**
	 * @param status Status to be set
	 * @return This TextInput
	 */
	public TextInput setStatus(Type status) {
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
		return "TextInput";
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

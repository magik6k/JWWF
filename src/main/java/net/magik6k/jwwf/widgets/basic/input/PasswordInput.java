package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Actions;
import net.magik6k.jwwf.handlers.TextHandler;
import net.magik6k.jwwf.util.Json;

/**
 * Input for passwords
 */
public class PasswordInput extends Widget{
	private String placeholder;
	private String text = "";
	private boolean sendTextUpdate;
	private TextHandler handler;
	
	/**
	 * @param placeholder Hint text
	 * @param defaultText Default text
	 * @param handler Handler of typed text
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
	 * @param handler Handler of typed text
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
	public PasswordInput(String placeholder,  String defaultText) {
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
	 * @param text Text to set
	 * @return This instance for chaining
	 */
	public PasswordInput setText(String text){
		this.text = text;
		sendTextUpdate = true;
		this.sendElement();
		return this;
	}
	
	/**
	 * Sets new placeholder text
	 * @param placeholder Placeholder text
	 * @return This instance for chaining
	 */
	public PasswordInput setPlaceholder(String placeholder)
	{
		this.placeholder = placeholder;
		this.sendElement();
		return this;
	}
	
	/**
	 * Returns entered text
	 * @return Entered text
	 */
	public String getText(){
		return text;
	}
	
	@Override
	public String getName() {
		return "PasswordInput";
	}

	@Override
	public String getData() {
		if(sendTextUpdate){
			sendTextUpdate = false;
			return "{\"placeholder\":"+Json.escapeString(placeholder)+",\"text\":"
				+Json.escapeString(text)+"}";
		}
		return "{\"placeholder\":"+Json.escapeString(placeholder)+"}";
	}
	
	/**
	 * Internal use only
	 */
	public void handleData(String data){
		if(data == null)return;
		if(handler != null)handler.onType(data);
		text = data;
	}
}

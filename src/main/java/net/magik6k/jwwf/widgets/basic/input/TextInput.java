package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Actions;
import net.magik6k.jwwf.handlers.TextHandler;
import net.magik6k.jwwf.util.Json;

/**
 * Input for user data
 */
public class TextInput extends Widget {
	private String placeholder;
	private String text = "";
	private boolean sendTextUpdate;
	private TextHandler handler;
	
	/**
	 * @param text Hint text
	 * @param defaultText Default text
	 * @param handler Handler of typed text
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
	 * @param text Hint text
	 * @param handler Handler of typed text
	 */
	public TextInput(String placeholder, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.handler = handler;
		this.sendElement();
	}
	
	/**
	 * @param text Hint text
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
	 * @param text Hint text
	 */
	public TextInput(String placeholder) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.sendElement();
	}
	
	/**
	 * @param text Hint text
	 */
	public TextInput() {
		super(Actions.TEXT_INPUT);
		this.sendElement();
	}
	
	/**
	 * Sets new placeholder text
	 * @param placeholder Placeholder text
	 */
	public void setPlaceholder(String placeholder){
		this.placeholder = placeholder;
		this.sendElement();
	}
	
	/**
	 * Sets new text
	 * @param text Text to set
	 */
	public void setText(String text){
		this.text = text;
		sendTextUpdate = true;
		this.sendElement();
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
		return "TextInput";
	}

	@Override
	public String getData() {
		if(sendTextUpdate){
			sendTextUpdate = false;
			return "{\"placeholder\":\""+Json.escapeString(placeholder)+"\",\"text\":\""
					+Json.escapeString(text)+"\"}";
		}		
		return "{\"placeholder\":\""+Json.escapeString(placeholder)+"\"}";
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

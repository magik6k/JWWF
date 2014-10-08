package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.core.Actions;
import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.handlers.TextHandler;
import net.magik6k.jwwf.util.Json;

/**
 * Input for passwords
 */
public class PasswordInput extends Widget{
	private String placeholder;
	private String text = "";
	private TextHandler handler;
	/**
	 * @param text Hint text
	 */
	public PasswordInput(String placeholder, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.handler = handler;
		this.sendElement();
	}
	
	/**
	 * @param text Hint text
	 */
	public PasswordInput(String placeholder) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.sendElement();
	}
	
	/**
	 * Sets new placeholder text
	 * @param text Placeholder text
	 */
	public void setPlaceholder(String placeholder)
	{
		this.placeholder = placeholder;
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
		return "PasswordInput";
	}

	@Override
	public String getData() {
		return "{\"text\":\""+Json.escapeString(placeholder)+"\"}";//TODO: Escape/rename text
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

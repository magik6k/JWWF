package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.core.Actions;
import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.handlers.TextHandler;

/**
 * Input for user data
 */
public class TextInput extends Widget {
	private String placeholder;
	private String text = "";
	private TextHandler handler;
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
	 */
	public TextInput(String placeholder) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.sendElement();
	}
	
	/**
	 * Sets new placeholder text
	 * @param placeholder Placeholder text
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
		return "TextInput";
	}

	@Override
	public String getData() {
		return "{\"text\":\""+placeholder+"\"}";//TODO: Escape text
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

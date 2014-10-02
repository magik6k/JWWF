package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.Actions;
import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;
import net.magik6k.jwwf.handlers.TextHandler;

public class TextInput extends Widget {
	private String text;
	private TextHandler handler;
	/**
	 * @param user Destination user
	 * @param text Hint text
	 */
	public TextInput(User user, String text, TextHandler handler) {
		super(user, Actions.TEXT_INPUT);
		this.text = text;
		this.handler = handler;
		this.sendElement();
	}
	
	/**
	 * Sets new text
	 * @param text Text
	 */
	public void setText(String text)
	{
		this.text = text;
		this.sendElement();
	}
	
	@Override
	public String getName() {
		return "TextInput";
	}

	@Override
	public String getData() {
		return "{\"text\":\""+text+"\"}";//TODO: Escape text
	}
	
	/**
	 * Internal use only
	 */
	public void handleData(String data){
		handler.onType(data);
	}
}

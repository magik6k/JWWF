package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.core.Actions;
import net.magik6k.jwwf.core.User;
import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.handlers.TextHandler;

public class PasswordInput extends Widget{
	private String placeholder;
	private String text = "";
	private TextHandler handler;
	/**
	 * @param user Destination user
	 * @param text Hint text
	 */
	public PasswordInput(User user, String placeholder, TextHandler handler) {
		super(user, Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.handler = handler;
		this.sendElement();
	}
	
	/**
	 * @param user Destination user
	 * @param text Hint text
	 */
	public PasswordInput(User user, String placeholder) {
		super(user, Actions.TEXT_INPUT);
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
	
	public String getText(){
		return text;
	}
	
	@Override
	public String getName() {
		return "PasswordInput";
	}

	@Override
	public String getData() {
		return "{\"text\":\""+placeholder+"\"}";//TODO: Escape/rename text
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

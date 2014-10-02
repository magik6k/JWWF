package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

public class TextInput extends Widget {
	private String text;
	/**
	 * @param user Destination user
	 * @param text Hint text
	 */
	public TextInput(User user, String text) {
		super(user);
		this.text = text;
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
		return "TextLabel";
	}

	@Override
	public String getData() {
		return "{\"text\":\""+text+"\"}";//TODO: Escape text
	}
	
	/**
	 * Internal use only
	 */
	public void handleData(String data){
		
	}
}

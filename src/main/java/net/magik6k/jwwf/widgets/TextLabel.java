package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

/**
 * Basic container of text
 */
public class TextLabel extends Widget {
	private String text;
	/**
	 * @param user Destination user
	 * @param text Default text
	 */
	public TextLabel(User user, String text) {
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
}

package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

/**
 * Basic span
 * @author lukasz
 *
 */
public class TextLabel extends Widget {
	private String text;
	public TextLabel(User user, String text) {
		super(user);
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

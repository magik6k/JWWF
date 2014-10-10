package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.util.Json;

/**
 * Basic container of text
 */
public class TextLabel extends Widget {
	private String text;
	/**
	 * @param text Default text
	 */
	public TextLabel(String text) {
		super();
		this.text = text.replace("\n", "<br/>");
		this.sendElement();
	}
	
	/**
	 * Sets new text
	 * @param text Text
	 */
	public void setText(String text)
	{
		this.text = text.replace("\n", "<br/>");
		this.sendElement();
	}
	
	@Override
	public String getName() {
		return "TextLabel";
	}

	@Override
	public String getData() {
		return "{\"text\":\""+Json.escapeString(text)+"\"}";
	}
}

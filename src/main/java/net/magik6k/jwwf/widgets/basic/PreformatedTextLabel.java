package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.util.Json;

/**
 * Somewhat like TextLabel but automatically fromats text.
 * Good for basic code/log display
 */
public class PreformatedTextLabel extends Widget {
	private String text;

	/**
	 * @param text Default text
	 */
	public PreformatedTextLabel(String text) {
		super();
		this.text = text;
		this.sendElement();
	}

	/**
	 * Sets new text
	 *
	 * @param text Text
	 * @return This instance of object for chaining
	 */
	public PreformatedTextLabel setText(String text) {
		this.text = text;
		this.sendElement();
		return this;
	}

	@Override
	public String getName() {
		return "PreformattedTextLabel";
	}

	@Override
	public String getData() {
		return "{\"text\":" + Json.escapeString(text) + "}";
	}
}

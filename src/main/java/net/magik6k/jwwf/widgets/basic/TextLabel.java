package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.util.Json;

/**
 * Basic container of text
 */
public class TextLabel extends Widget {
	private String text;
	private boolean textWrap = false;
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
	 * @return This instance of object for chaining
	 */
	public TextLabel setText(String text)
	{
		this.text = text.replace("\n", "<br/>");
		this.sendElement();
		return this;
	}
	
	/**
	 * Sets text wrapping
	 * @param textWrap If set to false text will not be wrapped
	 * @return This instance of object for chaining
	 */
	public TextLabel setTextWrapping(boolean textWrap){
		this.textWrap = textWrap;
		return this;
	}
	
	@Override
	public String getName() {
		return "TextLabel";
	}

	@Override
	public String getData() {
		StringBuilder dataBuilder = new StringBuilder(48);
		dataBuilder.append("{\"text\":");
		dataBuilder.append(Json.escapeString(text));
		if(!textWrap){
			dataBuilder.append(",\"nowrap\":true");
		}
		dataBuilder.append("}");
		
		return dataBuilder.toString();
	}

}

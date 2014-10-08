package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.core.Actions;
import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.handlers.ClickHandler;
import net.magik6k.jwwf.util.Json;

/**
 * User-clickable button
 */
public class Button extends Widget{
	private String label;
	private ClickHandler clickHandler;
	/**
	 * @param label Default label
	 */
	public Button(String label, ClickHandler clickHandler) {
		super(Actions.BUTTON_CLICK);
		this.label = label;
		this.clickHandler = clickHandler;
		this.sendElement();
	}
	
	/**
	 * Sets new label
	 * @param label Label
	 */
	public void setlabel(String label)
	{
		this.label = label;
		this.sendElement();
	}
	
	/**
	 * Sets new handler for button click
	 * @param clickHandler New handler
	 */
	public void setHandler(ClickHandler clickHandler){
		this.clickHandler = clickHandler;
	}
	
	@Override
	public String getName() {
		return "Button";
	}

	@Override
	public String getData() {
		return "{\"label\":\""+Json.escapeString(label)+"\"}";//TODO: Escape text
	}
	
	/**
	 * Internal use only
	 */
	protected void handleData(String data){
		try {
			clickHandler.clicked();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Actions;
import net.magik6k.jwwf.handlers.ClickHandler;
import net.magik6k.jwwf.util.Json;

/**
 * Link clickable by user with server-side handler
 */
public class InternalLink extends Widget{
	private String label;
	private ClickHandler clickHandler;
	
	/**
	 * @param label Default label
	 * @param clickHandler handler to be invoked when link is pressed by user
	 */
	public InternalLink(String label, ClickHandler clickHandler) {
		super(Actions.BUTTON_CLICK);
		this.label = label;
		this.clickHandler = clickHandler;
		this.sendElement();
	}
	
	/**
	 * @param label Default label
	 */
	public InternalLink(String label) {
		super(Actions.BUTTON_CLICK);
		this.label = label;
		this.sendElement();
	}
	
	/**
	 * Sets new label
	 * @param label New label
	 * @return This instance for chaining
	 */
	public InternalLink setlabel(String label)
	{
		this.label = label;
		this.sendElement();
		return this;
	}
	
	/**
	 * Sets new handler for button click
	 * @param clickHandler New handler
	 * @return This instance for chaining
	 */
	public InternalLink setHandler(ClickHandler clickHandler){
		this.clickHandler = clickHandler;
		return this;
	}
	
	@Override
	public String getName() {
		return "InternalLink";
	}

	@Override
	public String getData() {
		return "{\"label\":"+Json.escapeString(label)+"}";
	}
	
	/**
	 * Internal use only
	 */
	public void handleData(String data){
		try {
			if(clickHandler != null)
				clickHandler.clicked();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.core.Actions;
import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.handlers.ClickHandler;

/**
 * Link clickable by user with server-side handler
 */
public class InternalLink extends Widget{
	private String label;
	private ClickHandler clickHandler;
	/**
	 * @param label Default label
	 */
	public InternalLink(String label, ClickHandler clickHandler) {
		super(Actions.BUTTON_CLICK);
		this.label = label;
		this.clickHandler = clickHandler;
		this.sendElement();
	}
	
	/**
	 * Sets new label
	 * @param label New label
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
		return "InternalLink";
	}

	@Override
	public String getData() {
		return "{\"label\":\""+label+"\"}";//TODO: Escape text
	}
	
	/**
	 * Internal use only
	 */
	public void handleData(String data){
		try {
			clickHandler.clicked();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

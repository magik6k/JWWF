package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.Actions;
import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;
import net.magik6k.jwwf.handlers.ClickHandler;

public class Button extends Widget{
	private String label;
	private ClickHandler clickHandler;
	/**
	 * @param user Destination user
	 * @param label Default label
	 */
	public Button(User user, String label, ClickHandler clickHandler) {
		super(user, Actions.BUTTON_CLICK);
		this.label = label;
		this.clickHandler = clickHandler;
		this.sendElement();
	}
	
	/**
	 * Sets new text
	 * @param label Label
	 */
	public void setlabel(String label)
	{
		this.label = label;
		this.sendElement();
	}
	
	@Override
	public String getName() {
		return "Button";
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

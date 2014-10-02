package net.magik6k.jwwf.widgets;

import java.util.concurrent.Callable;

import net.magik6k.jwwf.Actions;
import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

public class Button extends Widget{
	private String label;
	private Callable<Void> clickHandler;
	/**
	 * @param user Destination user
	 * @param label Default label
	 */
	public Button(User user, String label, Callable<Void> clickHandler) {
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
			clickHandler.call();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

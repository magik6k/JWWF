package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.Connection;
import net.magik6k.jwwf.Widget;

/**
 * Special panel to add widgets to. Created internally
 */
public class MainFrame extends Widget{

	private int content = -1;
	
	public MainFrame(int id, Connection creator) {
		super(id, creator);
		this.sendElement();
	}

	@Override
	public String getName() {
		return "MainFrame";
	}

	@Override
	public String getData() {
		return "{\"content\":"+String.valueOf(content)+"}";
	}

	/**
	 * Adds widget to page
	 * @param widget Widget/container to present
	 */
	public void put(Widget widget) {
		content = widget.getID();
		this.sendElement();
	}
}

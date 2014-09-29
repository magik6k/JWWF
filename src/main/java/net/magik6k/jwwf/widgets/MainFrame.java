package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.Connection;
import net.magik6k.jwwf.Widget;

/**
 * root div
 * @author lukasz
 *
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

	public void put(Widget widget) {
		content = widget.getID();
		this.sendElement();
	}
}

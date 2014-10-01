package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

public class FixedPanel extends Widget{
	private int content = -1;
	private int x,y;
	public FixedPanel(User user, int x, int y, Widget widget) {
		super(user);
		content = widget.getID();
		this.x = x;
		this.y = y;
		this.sendElement();
	}
	
	public FixedPanel(User user, int x, int y) {
		super(user);
		this.x = x;
		this.y = y;
		this.sendElement();
	}
	
	public FixedPanel(User user) {
		super(user);
		this.sendElement();
	}

	@Override
	public String getName() {
		return "FixedPanel";
	}

	@Override
	public String getData() {
		return "{\"content\":"+String.valueOf(content)+",\"x\":"+String.valueOf(x)+",\"y\":"+String.valueOf(y)+"}";
	}

	public void put(Widget widget) {
		content = widget.getID();
		this.sendElement();
	}
}

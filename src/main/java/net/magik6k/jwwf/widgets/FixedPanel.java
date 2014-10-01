package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

/**
 * This panel places its content based on top-left corner of the window,
 * the content is 'fixed'
 */
public class FixedPanel extends Widget{
	private int content = -1;
	private int x,y;
	
	/**
	 * @param user Destination user
	 * @param x X-Offset
	 * @param y Y-Offset
	 * @param widget Default content
	 */
	public FixedPanel(User user, int x, int y, Widget widget) {
		super(user);
		content = widget.getID();
		this.x = x;
		this.y = y;
		this.sendElement();
	}
	
	/**
	 * @param user Destination user
	 * @param x X-Offset
	 * @param y Y-Offset
	 */
	public FixedPanel(User user, int x, int y) {
		super(user);
		this.x = x;
		this.y = y;
		this.sendElement();
	}
	
	/**
	 * @param user Destination user
	 */
	public FixedPanel(User user) {
		super(user);
		this.sendElement();
	}

	/**
	 * Sets content
	 * @param widget new content of panel
	 */
	public void put(Widget widget) {
		content = widget.getID();
		this.sendElement();
	}
	
	/**
	 * @param x X-Offset
	 * @param y Y-Offset
	 */
	public void setOffset(int x, int y) {
		this.x = x;
		this.y = y;
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
}

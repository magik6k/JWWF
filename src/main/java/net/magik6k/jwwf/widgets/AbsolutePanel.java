package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

/**
 * This panel allows to 'move' its content from oridinal place by x,y pixels
 * @author lukasz
 *
 */
public class AbsolutePanel extends Widget{
	private int content = -1;
	private int x,y;
	
	/**
	 * @param user Destination user
	 * @param x X-Offset
	 * @param y Y-Offset
	 * @param widget Default content
	 */
	public AbsolutePanel(User user, int x, int y, Widget widget) {
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
	public AbsolutePanel(User user, int x, int y) {
		super(user);
		this.x = x;
		this.y = y;
		this.sendElement();
	}
	
	/**
	 * @param user Destination user
	 */
	public AbsolutePanel(User user) {
		super(user);
		this.sendElement();
	}

	/**
	 * @param widget Content
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
		return "AbsolutePanel";
	}

	@Override
	public String getData() {
		return "{\"content\":"+String.valueOf(content)+",\"x\":"+String.valueOf(x)+",\"y\":"+String.valueOf(y)+"}";
	}
}

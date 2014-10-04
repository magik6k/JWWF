package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.core.Widget;

/**
 * This panel places its content based on top-left corner of the window,
 * the content is 'fixed'
 */
public class FixedPanel extends Widget{
	private Widget content;
	private int x,y;
	
	/**
	 * @param user Destination user
	 * @param x X-Offset
	 * @param y Y-Offset
	 * @param widget Default content
	 */
	public FixedPanel(int x, int y, Widget widget) {
		super();
		attach(widget);
		content = widget;
		this.x = x;
		this.y = y;
		this.sendElement();
	}
	
	/**
	 * @param user Destination user
	 * @param x X-Offset
	 * @param y Y-Offset
	 */
	public FixedPanel(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.sendElement();
	}
	
	/**
	 * @param user Destination user
	 */
	public FixedPanel() {
		super();
		this.sendElement();
	}

	/**
	 * Sets content
	 * @param widget new content of panel
	 */
	public void put(Widget widget) {
		attach(widget);
		content = widget;
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
		return "{\"content\":"+String.valueOf(content.getID())+",\"x\":"+String.valueOf(x)+",\"y\":"+String.valueOf(y)+"}";
	}	
}

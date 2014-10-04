package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.core.Widget;

/**
 * This panel allows to 'move' its content from oridinal place by x,y pixels
 * @author lukasz
 *
 */
public class AbsolutePanel extends Widget{
	private Widget content;
	private int x,y;
	
	/**
	 * @param x X-Offset
	 * @param y Y-Offset
	 * @param widget Default content
	 */
	public AbsolutePanel(int x, int y, Widget widget) {
		super();
		attach(widget);
		content = widget;
		this.x = x;
		this.y = y;
		this.sendElement();
	}
	
	/**
	 * @param x X-Offset
	 * @param y Y-Offset
	 */
	public AbsolutePanel(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.sendElement();
	}
	
	/**
	 */
	public AbsolutePanel() {
		super();
		this.sendElement();
	}

	/**
	 * @param widget Widget to store
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
		return "AbsolutePanel";
	}

	@Override
	public String getData() {
		return "{\"content\":"+String.valueOf(content.getID())+",\"x\":"+String.valueOf(x)+",\"y\":"+String.valueOf(y)+"}";
	}
}

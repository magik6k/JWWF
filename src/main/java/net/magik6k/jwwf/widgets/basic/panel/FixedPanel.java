package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.Widget;

/**
 * This panel places its content based on top-left corner of the window,
 * the content is 'fixed'
 */
public class FixedPanel extends Widget{
	private Widget content;
	private int x,y;
	
	/**
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
	
	/**
	 * Removes stored element
	 */
	public void remove(){
		content = null;
		this.sendElement();
	}
	
	@Override
	public String getName() {
		return "FixedPanel";
	}

	@Override
	public String getData() {
		return "{\"content\":"+String.valueOf(content!=null?content.getID():-1)+",\"x\":"+String.valueOf(x)+",\"y\":"+String.valueOf(y)+"}";
	}	
}

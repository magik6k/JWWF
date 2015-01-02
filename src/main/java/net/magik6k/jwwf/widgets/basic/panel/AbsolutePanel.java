package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.IWidgetFactory;
import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.widgets.basic.panel.generic.Panel;

/**
 * This panel allows to 'move' its content from original place
 * @author lukasz
 *
 */
public class AbsolutePanel extends Panel{
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
	 * Puts widget at first free index
	 * @param widget Widget to put
	 * @return index of element in container
	 */
	@Override
	public int put(Widget widget) {
		attach(widget);
		content = widget;
		this.sendElement();
		return 0;
	}
	
	/**
	 * Creates new widget and puts it to container
	 * @param factory Factory of new widget
	 * @return Instance of created widget
	 */
	public Widget put(IWidgetFactory factory){
		Widget widget = factory.getWidget();
		put(widget);
		return widget;
	}
	
	/**
	 * @param x X-Offset
	 * @param y Y-Offset
	 * @return This instance for chaining
	 */
	public AbsolutePanel setOffset(int x, int y) {
		this.x = x;
		this.y = y;
		this.sendElement();
		return this;
	}
	
	/**
	 * Removes stored element
	 * @return This instance for chaining
	 */
	public AbsolutePanel remove(){
		content = null;
		this.sendElement();
		return this;
	}
	
	@Override
	public String getName() {
		return "AbsolutePanel";
	}

	@Override
	public String getData() {
		return "{\"content\":"+String.valueOf(content!=null?content.getID():-1)+",\"x\":"+String.valueOf(x)+",\"y\":"+String.valueOf(y)+"}";
	}
}

package net.magik6k.jwwf.widgets.basic.panel.virtual;

import net.magik6k.jwwf.core.IWidgetFactory;
import net.magik6k.jwwf.core.Widget;

public abstract class LinePanel extends Panel{
	/**
	 * Puts new widget to the container
	 * @param widget Widget to put
	 * @param index id of 'cell' in the container to put widget to(numbered from 0)
	 * @return This instance for chaining
	 */	
	public abstract LinePanel put(Widget widget, int index);
	
	/**
	 * Creates new widget and puts it to container
	 * @param factory Factory of new widget
	 * @param index index id of 'cell' in the container to put widget to(numbered from 0)
	 * @return Instance of created widget
	 */
	public Widget put(IWidgetFactory factory, int index){
		Widget widget = factory.getWidget();
		put(widget, index);
		return widget;
	}
	
	
}

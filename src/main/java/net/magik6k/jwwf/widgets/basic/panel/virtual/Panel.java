package net.magik6k.jwwf.widgets.basic.panel.virtual;

import net.magik6k.jwwf.core.IWidgetFactory;
import net.magik6k.jwwf.core.Widget;

public abstract class Panel extends Widget{
	/**
	 * Puts widget at first free index
	 * @param widget Widget to put
	 * @return index of element in container
	 */
	public abstract int put(Widget widget);
	
	/**
	 * Creates new widget and puts it to container at first free index
	 * @param factory Factory of new widget
	 * @return Instance of created widget
	 */
	public Widget put(IWidgetFactory factory){
		Widget widget = factory.getWidget();
		put(widget);
		return widget;
	}
}

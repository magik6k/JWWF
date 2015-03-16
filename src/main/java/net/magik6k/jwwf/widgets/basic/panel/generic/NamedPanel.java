package net.magik6k.jwwf.widgets.basic.panel.generic;

import net.magik6k.jwwf.core.IWidgetFactory;
import net.magik6k.jwwf.core.Widget;

public abstract class NamedPanel extends Widget {
	/**
	 * Puts new widget to the container
	 *
	 * @param widget Widget to put
	 * @param name   Name of tab
	 * @param index  id of 'cell' in the container to put widget to(numbered from 0)
	 * @return This instance for chaining
	 */
	public abstract NamedPanel put(Widget widget, String name, int index);

	/**
	 * Puts widget at first free index
	 *
	 * @param widget Widget to put
	 * @param name   Name of tab
	 * @return index of element in container
	 */
	public abstract int put(Widget widget, String name);

	/**
	 * Creates new widget and puts it to container at first free index
	 *
	 * @param factory Factory of new widget
	 * @param name    Name of tab
	 * @return Instance of created widget
	 */
	public Widget put(IWidgetFactory factory, String name) {
		Widget widget = factory.getWidget();
		put(widget, name);
		return widget;
	}

	/**
	 * Creates new widget and puts it to container
	 *
	 * @param factory Factory of new widget
	 * @param name    Name of tab
	 * @param index   index id of 'cell' in the container to put widget to(numbered from 0)
	 * @return Instance of created widget
	 */
	public Widget put(IWidgetFactory factory, String name, int index) {
		Widget widget = factory.getWidget();
		put(widget, name, index);
		return widget;
	}
}

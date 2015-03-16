package net.magik6k.jwwf.widgets.basic.panel.generic;

import net.magik6k.jwwf.core.IWidgetFactory;
import net.magik6k.jwwf.core.Widget;

public abstract class ArrayPanel extends AbstractPanel {
	/**
	 * Set widget to certain cell in table
	 *
	 * @param widget Widget to set
	 * @param x      Column
	 * @param y      Row
	 * @return This instance for chaining
	 * @throws IndexOutOfBoundsException when specified coordinates are out of range
	 */
	public abstract ArrayPanel put(Widget widget, int x, int y) throws IndexOutOfBoundsException;

	/**
	 * Creates new widget and puts it to container
	 *
	 * @param factory Factory of new widget
	 * @param x       Column
	 * @param y       Row
	 * @return Instance of created widget
	 * @throws IndexOutOfBoundsException when specified coordinates are out of range
	 */
	public Widget put(IWidgetFactory factory, int x, int y) throws IndexOutOfBoundsException {
		Widget widget = factory.getWidget();
		put(widget, x, y);
		return widget;
	}
}

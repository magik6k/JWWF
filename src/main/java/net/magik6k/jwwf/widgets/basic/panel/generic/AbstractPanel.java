package net.magik6k.jwwf.widgets.basic.panel.generic;

import net.magik6k.jwwf.core.IWidgetFactory;
import net.magik6k.jwwf.core.Widget;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractPanel extends Widget {
	/**
	 * Puts widget at first free index
	 *
	 * @param widget Widget to put
	 * @return index of element in container
	 * @throws IndexOutOfBoundsException when there is no more space
	 */
	public abstract int put(Widget widget) throws IndexOutOfBoundsException;

	/**
	 * Creates new widget and puts it to container at first free index
	 *
	 * @param factory Factory of new widget
	 * @return Instance of created widget
	 * @throws IndexOutOfBoundsException when there is no more space
	 */
	public Widget put(IWidgetFactory factory) throws IndexOutOfBoundsException {
		Widget widget = factory.getWidget();
		put(widget);
		return widget;
	}

	/**
	 * Adds all widgets from given iterable
	 *
	 * @param widgets Iterable object containing widgets
	 * @return Index of last added element
	 * @throws IndexOutOfBoundsException when there is no more space
	 */
	public int put(Iterable<? extends Widget> widgets) throws IndexOutOfBoundsException {
		int last = -1;
		for (Widget widget : widgets) {
			last = put(widget);
		}
		return last;
	}

	/**
	 * Creates widgets instance from given iterable and adds it to this panel
	 *
	 * @param factories Iterable object containing widget factories
	 * @return List of created widgets
	 * @throws IndexOutOfBoundsException when there is no more space
	 */
	public List<Widget> putFactories(Iterable<? extends IWidgetFactory> factories) throws IndexOutOfBoundsException {
		List<Widget> instances = new LinkedList<Widget>();
		for (IWidgetFactory factory : factories) {
			instances.add(put(factory));
		}
		return instances;
	}
}

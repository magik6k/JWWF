package net.magik6k.jwwf.widgets.basic.panel.generic;

import java.util.LinkedList;
import java.util.List;

import net.magik6k.jwwf.core.IWidgetFactory;
import net.magik6k.jwwf.core.Widget;

public abstract class LinePanel extends AbstractPanel {
	/**
	 * Puts new widget to the container
	 * @param widget Widget to put
	 * @param index id of 'cell' in the container to put widget to(numbered from 0)
	 * @return This instance for chaining
	 * @throws IndexOutOfBoundsException when specified index is negative or there is no more space
	 */	
	public abstract LinePanel put(Widget widget, int index)throws IndexOutOfBoundsException;
	
	/**
	 * Creates new widget and puts it to container
	 * @param factory Factory of new widget
	 * @param index index id of 'cell' in the container to put widget to(numbered from 0)
	 * @return Instance of created widget
	 * @throws IndexOutOfBoundsException when specified index is negative or there is no more space
	 */
	public Widget put(IWidgetFactory factory, int index)throws IndexOutOfBoundsException {
		Widget widget = factory.getWidget();
		put(widget, index);
		return widget;
	}
	
	/**
	 * Adds all widgets from given iterable
	 * @param widgets Iterable object containing widgets
	 * @param startIndex index at wich adding will start
	 * @return Index of last added element
	 * @throws IndexOutOfBoundsException when specified startIndex is negative or there is no more space
	 */
	public int put(Iterable<? extends Widget> widgets, int startIndex)throws IndexOutOfBoundsException {
		int index = startIndex;
		for(Widget widget : widgets){
			put(widget, index);
			++index;
		}		
		return index;
	}
	
	/**
	 * Creates widgets instance from given iterable and adds it to this panel
	 * @param factories Iterable object containing widget factories
	 * @param startIndex index at wich adding will start
	 * @return List of created widgets
	 * @throws IndexOutOfBoundsException when specified startIndex is negative or there is no more space
	 */
	public List<Widget> putFactories(Iterable<? extends IWidgetFactory> factories, int startIndex)throws IndexOutOfBoundsException {
		int index = startIndex;
		List<Widget> instances = new LinkedList<Widget>();
		for(IWidgetFactory factory : factories){
			instances.add(put(factory, index));
			++index;
		}
		return instances;
	}
	
}

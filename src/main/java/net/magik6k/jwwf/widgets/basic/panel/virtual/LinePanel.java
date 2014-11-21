package net.magik6k.jwwf.widgets.basic.panel.virtual;

import java.util.LinkedList;
import java.util.List;

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
	
	/**
	 * Adds all widgets from given iterable
	 * @param widgets Iterable object containing widgets
	 * @param startIndex index at wich adding will start
	 * @return Index of last added element
	 */
	public int put(Iterable<Widget> widgets, int startIndex){
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
	 * @return List of created widgets
	 */
	public List<Widget> putFactories(Iterable<IWidgetFactory> factories, int startIndex){
		int index = startIndex;
		List<Widget> instances = new LinkedList<Widget>();
		for(IWidgetFactory factory : factories){
			instances.add(put(factory, index));
			++index;
		}
		return instances;
	}
	
}

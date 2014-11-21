package net.magik6k.jwwf.widgets.basic.panel.virtual;

import java.util.LinkedList;
import java.util.List;

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
	
	/**
	 * Adds all widgets from given iterable
	 * @param widgets Iterable object containing widgets
	 * @return Index of last added element
	 */
	public int put(Iterable<Widget> widgets){
		int last = -1;
		for(Widget widget : widgets){
			last = put(widget);
		}		
		return last;
	}
	
	/**
	 * Creates widgets instance from given iterable and adds it to this panel
	 * @param factories Iterable object containing widget factories
	 * @return List of created widgets
	 */
	public List<Widget> putFactories(Iterable<IWidgetFactory> factories){
		List<Widget> instances = new LinkedList<Widget>();
		for(IWidgetFactory factory : factories){
			instances.add(put(factory));
		}		
		return instances;
	}
}

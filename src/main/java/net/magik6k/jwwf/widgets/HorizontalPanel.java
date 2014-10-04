package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.core.Widget;

/**
 * This panel places its elements in horizontal line
 */
public class HorizontalPanel extends Widget{

	private Widget[] content;
	
	/**
	 * @param user Destination user
	 * @param width Default height of the container
	 */
	public HorizontalPanel(int width) {
		super();
		content = new Widget[width];
		for(int i = 0; i < content.length; ++i)content[i] = null;
		this.sendElement();
	}

	/**
	 * @param user Destination user
	 * @param width Default height of the container
	 * @param widgets Default widgets
	 */	
	public HorizontalPanel(int width, Widget... widgets) {
		super();
		content = new Widget[width];		
		
		for(int i = 0; i < content.length; ++i)	{
			if(i < widgets.length && widgets[i] != null){
				attach(widgets[i]);
				content[i] = widgets[i];
			}
		}
		
		this.sendElement();
	}
	
	@Override
	public String getName() {
		return "HorizontalPanel";
	}

	@Override
	public String getData() {
		String data = "";
		for(int i = 0; i < content.length; ++i)
		{
			if(i > 0)data += ",";
			data += "\"" + String.valueOf(content[i].getID()) + "\"";
		}
		return "{\"content\":["+data+"]}";
	}

	/**
	 * Puts new widget to the container
	 * @param widget Widget to put
	 * @param index id of 'cell' in the container to put widget to(numbered from 0)
	 */
	public void put(Widget widget, int index) {
		attach(widget);
		content[index] = widget;
		this.sendElement();
	}	
}

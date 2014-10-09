package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.util.NamedWidget;

public class TabbedPanel extends Widget{
	private NamedWidget[] content;
	
	/**
	 * @param width Default height of the container
	 */
	public TabbedPanel(int width) {
		super();
		content = new NamedWidget[width];
		for(int i = 0; i < content.length; ++i)content[i] = null;
		this.sendElement();
	}

	/**
	 * @param width Default height of the container
	 * @param widgets Default widgets
	 */	
	public TabbedPanel(int width, NamedWidget... widgets) {
		super();
		content = new NamedWidget[width];		
		
		for(int i = 0; i < content.length; ++i)	{
			if(i < widgets.length && widgets[i] != null){
				attach(widgets[i].widget);
				content[i] = widgets[i];
			}
		}
		
		this.sendElement();
	}
	
	@Override
	public String getName() {
		return "TabbedPanel";
	}

	@Override
	public String getData() {
		String data = "";
		for(int i = 0; i < content.length; ++i)
		{
			if(i > 0)data += ",";
			data += "{\"widget\":" + String.valueOf(content[i].widget.getID()) + ",\"name\":\""+content[i].name+"\"}";
		}
		return "{\"content\":["+data+"]}";
	}

	/**
	 * Puts new widget to the container
	 * @param widget Widget to put
	 * @param name Name of tab
	 * @param index id of 'cell' in the container to put widget to(numbered from 0)
	 */
	public void put(Widget widget, String name, int index) {
		attach(widget);
		content[index] = new NamedWidget(widget, name);
		this.sendElement();
	}	
}

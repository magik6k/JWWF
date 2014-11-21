package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.IWidgetFactory;
import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.util.NamedWidget;
import net.magik6k.jwwf.widgets.basic.panel.virtual.NamedPanel;

/**
 * Panel with many tabs
 */
public class TabbedPanel extends NamedPanel{
	private NamedWidget[] content;
	
	/**
	 * @param width Default width of the container
	 */
	public TabbedPanel(int width) {
		super();
		content = new NamedWidget[width];
		for(int i = 0; i < content.length; ++i)content[i] = null;
		this.sendElement();
	}

	/**
	 * @param width Default width of the container
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
			data += "{\"widget\":" + String.valueOf(content[i].widget!=null?content[i].widget.getID():-1) + ",\"name\":\""+content[i].name+"\"}";
		}
		return "{\"content\":["+data+"]}";
	}

	/**
	 * Puts new widget to the container
	 * @param widget Widget to put
	 * @param name Name of tab
	 * @param index id of 'cell' in the container to put widget to(numbered from 0)
	 * @return This instance for chaining
	 */
	public TabbedPanel put(Widget widget, String name, int index) {
		if(widget == null)return this;
		attach(widget);
		content[index] = new NamedWidget(widget, name);
		this.sendElement();
		return this;
	}
	
	/**
	 * Puts widget at first free index
	 * @param widget Widget to put
	 * @param name Name of tab
	 * @return index of element in container
	 */
	public int put(Widget widget, String name) {
		if(widget == null)return -1;
		attach(widget);
		for(int i = 0; i < content.length; ++i)
			if(content[i] == null){
				content[i] = new NamedWidget(widget, name);
				this.sendElement();
				return i;
			}
		return -1;
	}
	
	//TODO: Tab setting
}

package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.core.User;
import net.magik6k.jwwf.core.Widget;

/**
 * This panel places its elements in horizontal line
 */
public class HorizontalPanel extends Widget{

	private int[] content;
	
	/**
	 * @param user Destination user
	 * @param width Default height of the container
	 */
	public HorizontalPanel(User user, int width) {
		super(user);
		content = new int[width];
		for(int i = 0; i < content.length; ++i)content[i] = -1;
		this.sendElement();
	}

	/**
	 * @param user Destination user
	 * @param width Default height of the container
	 * @param widgets Default widgets
	 */	
	public HorizontalPanel(User user, int width, Widget... widgets) {
		super(user);
		content = new int[width];		
		
		for(int i = 0; i < content.length; ++i)	{
			content[i] = i < widgets.length ? widgets[i].getID() : -1;
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
			data += "\"" + String.valueOf(content[i]) + "\"";
		}
		return "{\"content\":["+data+"]}";
	}

	/**
	 * Puts new widget to the container
	 * @param widget Widget to put
	 * @param index id of 'cell' in the container to put widget to(numbered from 0)
	 */
	public void put(Widget widget, int index) {
		content[index] = widget.getID();
		this.sendElement();
	}	
}

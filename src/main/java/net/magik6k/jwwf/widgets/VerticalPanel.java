package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

/**
 * This panel places its elements in vertical line
 */
public class VerticalPanel extends Widget{

	private int[] content;
	
	/**
	 * @param user Destination user
	 * @param height Default height of the container
	 */	
	public VerticalPanel(User user, int height) {
		super(user);
		content = new int[height];
		for(int i = 0; i < content.length; ++i)content[i] = -1;
		this.sendElement();
	}

	/**
	 * @param user Destination user
	 * @param height Default height of the container
	 * @param widgets Default widgets
	 */	
	public VerticalPanel(User user, int height, Widget... widgets) {
		super(user);
		content = new int[height];		
		
		for(int i = 0; i < content.length; ++i)	{
			content[i] = i < widgets.length ? widgets[i].getID() : -1;
		}
		
		this.sendElement();
	}
	
	@Override
	public String getName() {
		return "VerticalPanel";
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

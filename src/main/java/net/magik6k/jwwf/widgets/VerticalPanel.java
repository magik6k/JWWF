package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

public class VerticalPanel extends Widget{

	private int[] content;
	
	public VerticalPanel(User user, int height) {
		super(user);
		content = new int[height];
		for(int i = 0; i < content.length; ++i)content[i] = -1;
		this.sendElement();
	}

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

	public void put(Widget widget, int index) {
		content[index] = widget.getID();
		this.sendElement();
	}	
}

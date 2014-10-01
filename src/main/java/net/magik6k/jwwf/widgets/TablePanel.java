package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

public class TablePanel extends Widget{
private int[][] content;
	
	public TablePanel(User user, int width, int height) {
		super(user);
		content = new int[height][width];
		for(int i = 0; i < content.length; ++i)
			for(int j = 0; j < content[i].length; ++j)
				content[i][j] = -1;
		
		this.sendElement();
	}

	public TablePanel(User user, int width, int height, Widget... widgets) {
		super(user);
		content = new int[height][width];		
		
		for(int i = 0; i < content.length; ++i)
			for(int j = 0; j < content[i].length; ++j){
				content[i][j] = (i*width)+j < widgets.length ? widgets[(i*width)+j].getID() : -1;
			}
		
		this.sendElement();
	}
	
	@Override
	public String getName() {
		return "TablePanel";
	}

	@Override
	public String getData() {
		String data = "";
		for(int i = 0; i < content.length; ++i)
		{
			if(i > 0)data += ",";
			data += "[";
			for(int j = 0; j < content[i].length; ++j)
			{
				if(j > 0)data += ",";
				data += "\"" + String.valueOf(content[i][j]) + "\"";
			}
			data += "]";
		}
		return "{\"content\":["+data+"]}";
	}

	public void put(Widget widget, int x, int y) {
		content[x][y] = widget.getID();
		this.sendElement();
	}	
}

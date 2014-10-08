package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Widget;

/**
 * A simple table container
 */
public class TablePanel extends Widget{
	private Widget[][] content;
	
	/**
	 * @param width Width of the table(number of columns)
	 * @param height Height of the table(number of rows)
	 */
	public TablePanel(int width, int height) {
		super();
		content = new Widget[height][width];
		for(int i = 0; i < content.length; ++i)
			for(int j = 0; j < content[i].length; ++j)
				content[i][j] = null;
		
		this.sendElement();
	}
	
	/**
	 * @param width Width of the table(number of columns)
	 * @param height Height of the table(number of rows)
	 * @param widgets Default set of widgets, from top-left to bottom-right
	 */
	public TablePanel(int width, int height, Widget... widgets) {
		super();
		content = new Widget[height][width];		
		
		for(int i = 0; i < content.length; ++i)
			for(int j = 0; j < content[i].length; ++j){
				if((i*width)+j < widgets.length && widgets[(i*width)+j] != null){
					attach(widgets[(i*width)+j]);
					content[i][j] = widgets[(i*width)+j];
				}
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
				data += "\"" + String.valueOf(content[i][j]!=null?content[i][j].getID():-1) + "\"";
			}
			data += "]";
		}
		return "{\"content\":["+data+"]}";
	}

	/**
	 * Set widget to certain cell in table
	 * @param widget Widget to set
	 * @param x Column
	 * @param y Row
	 */
	public void put(Widget widget, int x, int y) {
		attach(widget);
		content[x][y] = widget;
		this.sendElement();
	}	
}

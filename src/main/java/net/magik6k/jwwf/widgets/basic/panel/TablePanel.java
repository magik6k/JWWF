package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.Widget;

/**
 * A simple table container
 */
public class TablePanel extends Widget{
	private Widget[][] content;
	private float verticalSpacing = 0;
	private float horizontalSpacing = 0;
	
	
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
	
	/**
	 * @param width Width of the table(number of columns)
	 * @param height Height of the table(number of rows)
	 * @param verticalSpacing vertical space betwen elements in pixels
	 * @param horizontalSpacing horizontal space betwen elements in pixels
	 * @param widgets Default set of widgets, from top-left to bottom-right
	 */
	public TablePanel(int width, int height, float verticalSpacing, float horizontalSpacing, Widget... widgets) {
		super();
		content = new Widget[height][width];		
		this.verticalSpacing = verticalSpacing;
		this.horizontalSpacing = horizontalSpacing;		
		
		for(int i = 0; i < content.length; ++i)
			for(int j = 0; j < content[i].length; ++j){
				if((i*width)+j < widgets.length && widgets[(i*width)+j] != null){
					attach(widgets[(i*width)+j]);
					content[i][j] = widgets[(i*width)+j];
				}
			}
		
		this.sendElement();
	}
	
	/**
	 * Sets space betwen elements
	 * @param verticalSpacing vertical space betwen elements in pixels
	 * @param horizontalSpacing horizontal space betwen elements in pixels
	 */
	public void setSpacing(float verticalSpacing, float horizontalSpacing){
		this.verticalSpacing = verticalSpacing;
		this.horizontalSpacing = horizontalSpacing;
		this.sendElement();
	}
	
	/**
	 * Sets space betwen elements
	 * @param verticalSpacing vertical space betwen elements in pixels
	 */
	public void setVerticalSpacing(float verticalSpacing){
		this.verticalSpacing = verticalSpacing;
		this.sendElement();
	}
	
	/**
	 * Sets space betwen elements
	 * @param horizontalSpacing horizontal space betwen elements in pixels
	 */
	public void setHorizontalSpacing(float horizontalSpacing){
		this.horizontalSpacing = horizontalSpacing;
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
		return "{\"content\":["+data+"],\"hspace\":"+String.valueOf(horizontalSpacing)
				+",\"vspace\":"+String.valueOf(verticalSpacing)+"}";
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

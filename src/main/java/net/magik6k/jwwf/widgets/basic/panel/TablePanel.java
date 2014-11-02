package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.PanelAlign;

/**
 * A simple table container
 */
public class TablePanel extends Widget{
	private Widget[][] content;
	private float verticalSpacing = 0;
	private float horizontalSpacing = 0;
	private PanelAlign align = PanelAlign.LEFT;
	
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
	 * Sets align of elementd inside container. this is important when
	 * container has few elements with different widths or/and heights
	 * @param align Alignment type valid for this container
	 * @return This instance for chaining
	 */
	public TablePanel setElementAlign(PanelAlign align){
		this.align = align;
		this.sendElement();
		return this;
	}
	
	/**
	 * Sets space betwen elements
	 * @param verticalSpacing vertical space betwen elements in pixels
	 * @param horizontalSpacing horizontal space betwen elements in pixels
	 * @return This instance for chaining
	 */
	public TablePanel setSpacing(float verticalSpacing, float horizontalSpacing){
		this.verticalSpacing = verticalSpacing;
		this.horizontalSpacing = horizontalSpacing;
		this.sendElement();
		return this;
	}
	
	/**
	 * Sets space betwen elements
	 * @param verticalSpacing vertical space betwen elements in pixels
	 * @return This instance for chaining
	 */
	public TablePanel setVerticalSpacing(float verticalSpacing){
		this.verticalSpacing = verticalSpacing;
		this.sendElement();
		return this;
	}
	
	/**
	 * Sets space betwen elements
	 * @param horizontalSpacing horizontal space betwen elements in pixels
	 */
	public TablePanel setHorizontalSpacing(float horizontalSpacing){
		this.horizontalSpacing = horizontalSpacing;
		this.sendElement();
		return this;
	}
	
	@Override
	public String getName() {
		return "TablePanel";
	}

	/**
	 * Removes all elements stored in this container
	 * @return This instance for chaining
	 */
	public TablePanel removeAll(){
		for(int i = 0; i < content.length; ++i)
			for(int j = 0; j < content[i].length; ++j)
				content[i][j] = null;
		this.sendElement();
		return this;
	}
	
	/**
	 * Removes element at specified position
	 * @param x Column
	 * @param y Row
	 * @return This instance for chaining
	 */
	public TablePanel removeAt(int x, int y){
		content[x][y] = null;
		this.sendElement();
		return this;
	}
	
	/**
	 * Removes all elements that are instance of specified element
	 * @param widget Instance of widget to remove from container
	 * @return This instance for chaining
	 */
	public TablePanel remove(Widget widget){
		for(int i = 0; i < content.length; ++i)
			for(int j = 0; j < content[i].length; ++j)
				if(content[i][j] == widget)content[i][j] = null;
		this.sendElement();
		return this;
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
				+",\"vspace\":"+String.valueOf(verticalSpacing)+
				",\"align\":\""+align.propertyName+"\"}";
	}

	/**
	 * Set widget to certain cell in table
	 * @param widget Widget to set
	 * @param x Column
	 * @param y Row
	 * @return This instance for chaining
	 */
	public TablePanel put(Widget widget, int x, int y) {
		attach(widget);
		content[x][y] = widget;
		this.sendElement();
		return this;
	}
	
	/**
	 * Puts widget at first free index
	 * @param widget Widget to put
	 * @return index of element in container
	 */
	public int put(Widget widget) {
		attach(widget);
		for(int i = 0; i < content.length; ++i)
			for(int j = 0; j < content[i].length; ++j)
				if(content[i][j] == null){
					content[i][j] = widget;
					this.sendElement();
					return i;
				}
		return -1;
	}
	
}

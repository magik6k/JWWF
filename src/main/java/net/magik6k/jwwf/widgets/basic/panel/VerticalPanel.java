package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.PanelAlign;
import net.magik6k.jwwf.widgets.basic.panel.virtual.LinePanel;

/**
 * This panel places its elements in vertical line
 */
public class VerticalPanel extends LinePanel{

	private Widget[] content;
	private float elementSpacing = 0;
	private PanelAlign align = PanelAlign.LEFT;
	/**
	 * @param height Default height of the container
	 */	
	public VerticalPanel(int height) {
		super();
		content = new Widget[height];
		for(int i = 0; i < content.length; ++i)content[i] = null;
		this.sendElement();
	}

	/**
	 * @param height Default height of the container
	 * @param widgets Default widgets
	 */	
	public VerticalPanel(int height, Widget... widgets) {
		super();
		content = new Widget[height];		
		
		for(int i = 0; i < content.length; ++i)	{
			if(i < widgets.length && widgets[i] != null){
				attach(widgets[i]);
				content[i] = widgets[i];
			}
		}
		
		this.sendElement();
	}
	
	/**
	 * @param height Default height of the container
	 * @param elementSpacing pixels betwen each element
	 * @param widgets Default widgets
	 */	
	public VerticalPanel(int height, float elementSpacing, Widget... widgets) {
		super();
		content = new Widget[height];		
		this.elementSpacing = elementSpacing;
		
		for(int i = 0; i < content.length; ++i)	{
			if(i < widgets.length && widgets[i] != null){
				attach(widgets[i]);
				content[i] = widgets[i];
			}
		}
		
		this.sendElement();
	}
	
	/**
	 * @param height Default height of the container
	 * @param elementSpacing pixels betwen each element
	 */	
	public VerticalPanel(int height, float elementSpacing) {
		super();
		content = new Widget[height];		
		this.elementSpacing = elementSpacing;
		
		this.sendElement();
	}
	
	/**
	 * Sets align of elementd inside container. this is important when
	 * container has few elements with different widths
	 * @param align Alignment type valid for this container
	 * @return This instance for chaining
	 */
	public VerticalPanel setElementAlign(PanelAlign align){
		if(	align == PanelAlign.LEFT ||
			align == PanelAlign.MIDDLE ||
			align == PanelAlign.RIGHT){
			this.align = align;
			this.sendElement();
		}
		return this;
	}
	
	/**
	 * Sets space betwen each element.
	 * @param elementSpacing pixels betwen each element
	 * @return This instance for chaining
	 */
	public VerticalPanel setElementSpacing(float elementSpacing){
		this.elementSpacing = elementSpacing;
		this.sendElement();
		return this;
	}
	
	/**
	 * Removes all elements stored in this container
	 * @return This instance for chaining
	 */
	public VerticalPanel removeAll(){
		for(int i = 0; i < content.length; ++i)content[i] = null;
		this.sendElement();
		return this;
	}
	
	/**
	 * Removes element at specified position
	 * @param index index of element to remove
	 * @return This instance for chaining
	 */
	public VerticalPanel removeAt(int index){
		content[index] = null;
		this.sendElement();
		return this;
	}
	
	/**
	 * Removes all elements that are instance of specified element
	 * @param widget Instance of widget to remove from container
	 * @return This instance for chaining
	 */
	public VerticalPanel remove(Widget widget){
		for(int i = 0; i < content.length; ++i)
			if(content[i] == widget)content[i] = null;
		this.sendElement();
		return this;
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
			data += "\"" + String.valueOf(content[i]!=null?content[i].getID():-1) + "\"";
		}
		return "{\"content\":["+data+"],\"spacing\":"+String.valueOf(elementSpacing)
				+",\"align\":\""+align.propertyName+"\"}";
	}

	/**
	 * Puts new widget to the container
	 * @param widget Widget to put
	 * @param index id of 'cell' in the container to put widget to(numbered from 0)
	 * @return This instance for chaining
	 */	
	public VerticalPanel put(Widget widget, int index) {
		if(index < 0 || index >= content.length)throw new IndexOutOfBoundsException();
		attach(widget);
		content[index] = widget;
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
			if(content[i] == null){
				content[i] = widget;
				this.sendElement();
				return i;
			}
		throw new IndexOutOfBoundsException();
		//return -1;
	}
}

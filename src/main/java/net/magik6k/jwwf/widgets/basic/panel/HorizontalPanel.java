package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.PanelAlign;

/**
 * This panel places its elements in horizontal line
 */
public class HorizontalPanel extends Widget{

	private Widget[] content;
	private float elementSpacing = 0;
	private PanelAlign align = PanelAlign.LEFT;
	/**
	 * @param width Default height of the container
	 */
	public HorizontalPanel(int width) {
		super();
		content = new Widget[width];
		for(int i = 0; i < content.length; ++i)content[i] = null;
		this.sendElement();
	}

	/**
	 * @param width Default height of the container
	 * @param widgets Default widgets
	 */	
	public HorizontalPanel(int width, Widget... widgets) {
		super();
		content = new Widget[width];		
		
		for(int i = 0; i < content.length; ++i)	{
			if(i < widgets.length && widgets[i] != null){
				attach(widgets[i]);
				content[i] = widgets[i];
			}
		}
		
		this.sendElement();
	}
	
	/**
	 * @param width Default height of the container
	 * @param elementSpacing pixels betwen each element
	 * @param widgets Default widgets
	 */	
	public HorizontalPanel(int width, float elementSpacing, Widget... widgets) {
		super();
		content = new Widget[width];		
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
	 * @param width Default height of the container
	 * @param elementSpacing pixels betwen each element
	 */	
	public HorizontalPanel(int width, float elementSpacing) {
		super();
		content = new Widget[width];		
		this.elementSpacing = elementSpacing;
		
		this.sendElement();
	}
	
	/**
	 * Sets align of elementd inside container. this is important when
	 * container has few elements with different heights
	 * @param align Alignment type valid for this container
	 */
	public void setElementAlign(PanelAlign align){
		if(	align == PanelAlign.TOP ||
			align == PanelAlign.MIDDLE ||
			align == PanelAlign.BOTTOM){
			this.align = align;
			this.sendElement();
		}		
	}
	
	/**
	 * Sets space betwen each element.
	 * @param elementSpacing pixels betwen each element
	 */
	public void setElementSpacing(float elementSpacing){
		this.elementSpacing = elementSpacing;
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
			data += "\"" + String.valueOf(content[i].getID()) + "\"";
		}
		return "{\"content\":["+data+"],\"spacing\":"+String.valueOf(elementSpacing)+
				",\"align\":\""+align.propertyName+"\"}";
	}

	/**
	 * Puts new widget to the container
	 * @param widget Widget to put
	 * @param index id of 'cell' in the container to put widget to(numbered from 0)
	 */
	public void put(Widget widget, int index) {
		attach(widget);
		content[index] = widget;
		this.sendElement();
	}	
}
package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Widget;

/**
 * This widget is a simple image 
 */
public class Image extends Widget {
	private String url;
	private int w = -1,h = -1;
	
	/**
	 * @param url URL of the image; must be accesible by user
	 */
	public Image(String url) {
		super();
		this.url = url;
		this.sendElement();
	}
	
	/**
	 * @param w width of image, left -1 when not used(will be resized or scaled)
	 * @param h width of image, left -1 when not used(will be resized or scaled)
	 * @param url URL of the image; must be accesible by user
	 */
	public Image(int w, int h, String url) {
		super();
		this.url = url;
		this.w = w;
		this.h = h;
		this.sendElement();
	}

	/**
	 * Sets size of the image
	 * @param w width of image, left -1 when not used(will be resized or scaled)
	 * @param h width of image, left -1 when not used(will be resized or scaled)
	 */
	public void setSize(int w, int h)
	{
		this.w = w;
		this.h = h;
		this.sendElement();
	}
	
	/**
	 * Sets URL of the image
	 * @param url URL of the image; must be accesible by user
	 */
	public void setURL(String url)
	{
		this.url = url;
		this.sendElement();
	}
	
	@Override
	public String getName() {
		return "Image";
	}

	@Override
	public String getData() {
		return "{\"url\":\""+url+"\",\"size\":["+String.valueOf(w)+","+String.valueOf(h)+"]}";//TODO: Escape url
	}
}
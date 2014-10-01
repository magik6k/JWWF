package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

/**
 * This widget is a simple image 
 */
public class Image extends Widget {
	private String url;
	private int w = -1,h = -1;
	
	/**
	 * @param user Destination user
	 * @param url URL of the image; must be accesible by user
	 */
	public Image(User user, String url) {
		super(user);
		this.url = url;
		this.sendElement();
	}
	
	/**
	 * @param user Destination user
	 * @param w width of image, left -1 when not used(will be resized or scaled)
	 * @param h width of image, left -1 when not used(will be resized or scaled)
	 * @param url URL of the image; must be accesible by user
	 */
	public Image(User user, int w, int h, String url) {
		super(user);
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

package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.util.Json;

/**
 * This widget is a simple image 
 */
public class Image extends Widget {
	private String url;
	private String altText;
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
	 * @param w width of image, left -1 when not used(will be resized or scaled)
	 * @param h width of image, left -1 when not used(will be resized or scaled)
	 * @param url URL of the image; must be accesible by user
	 * @param alternativeText Text to display when image is not loaded
	 */
	public Image(int w, int h, String url, String alternativeText) {
		super();
		this.url = url;
		this.w = w;
		this.h = h;
		this.altText = alternativeText;
		this.sendElement();
	}

	/**
	 * Sets size of the image
	 * @param w width of image, left -1 when not used(will be resized or scaled)
	 * @param h width of image, left -1 when not used(will be resized or scaled)
	 */
	public void setSize(int w, int h){
		this.w = w;
		this.h = h;
		this.sendElement();
	}
	
	/**
	 * Sets alternative text to be displayed when there
	 * is problem displaying the image
	 */
	public void setAlternativeText(String text){
		this.altText = text;
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
		String res = "{\"url\":"+Json.escapeString(url)+",\"size\":["+String.valueOf(w)+","+String.valueOf(h)+"]";
		if(altText != null){
			res += ",\"alt\":"+Json.escapeString(altText)+"";
		}
		res += "}";		
		return res;
	}
}

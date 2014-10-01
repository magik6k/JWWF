package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

public class Image extends Widget {
	private String url;
	private int w = -1,h = -1;
	public Image(User user, String url) {
		super(user);
		this.url = url;
		this.sendElement();
	}
	
	public Image(User user, int w, int h, String url) {
		super(user);
		this.url = url;
		this.w = w;
		this.h = h;
		this.sendElement();
	}

	public void setSize(int w, int h)
	{
		this.w = w;
		this.h = h;
		this.sendElement();
	}
	
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

package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

public class Image extends Widget {
	private String url;
	public Image(User user, String url) {
		super(user);
		this.url = url;
		this.sendElement();
	}

	@Override
	public String getName() {
		return "Image";
	}

	@Override
	public String getData() {
		return "{\"url\":\""+url+"\"}";//TODO: Escape text
	}
}

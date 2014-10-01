package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

public class ExternalLink extends Widget {
	private String url, label;
	public ExternalLink(User user, String url, String label) {
		super(user);
		this.url = url;
		this.label = label;
		this.sendElement();
	}

	public void setURL(String url)
	{
		this.url = url;
		this.sendElement();
	}
	
	public void setLabel(String label)
	{
		this.label = label;
		this.sendElement();
	}
	
	@Override
	public String getName() {
		return "ExternalLink";
	}

	@Override
	public String getData() {
		return "{\"url\":\""+url+"\",\"label\":\""+label+"\"}";//TODO: Escape text
	}
}

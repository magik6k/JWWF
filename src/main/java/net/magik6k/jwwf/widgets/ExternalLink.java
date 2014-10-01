package net.magik6k.jwwf.widgets;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;

/**
 * This panel is much like {@link TextLabel} except it is a link to another resourcue(eg. webpage)
 */
public class ExternalLink extends Widget {
	private String url, label;
	
	/**
	 * @param user Destination user
	 * @param url URL of destination resource
	 * @param label Name of the link
	 */
	public ExternalLink(User user, String url, String label) {
		super(user);
		this.url = url;
		this.label = label;
		this.sendElement();
	}

	/**
	 * Sets links url
	 * @param url URL of destination resource
	 */
	public void setURL(String url)
	{
		this.url = url;
		this.sendElement();
	}
	
	/**
	 * Sets links name
	 * @param label Name of the link
	 */
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

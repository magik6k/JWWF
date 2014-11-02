package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.util.Json;

/**
 * This panel is much like {@link TextLabel} except it is a link to another resourcue(eg. webpage)
 */
public class ExternalLink extends Widget {
	private String url, label;
	
	/**
	 * @param url URL of destination resource
	 * @param label Name of the link
	 */
	public ExternalLink(String url, String label) {
		super();
		this.url = url;
		this.label = label;
		this.sendElement();
	}

	/**
	 * Sets links url
	 * @param url URL of destination resource
	 * @return This instance for chaining
	 */
	public ExternalLink setURL(String url)
	{
		this.url = url;
		this.sendElement();
		return this;
	}
	
	/**
	 * Sets links name
	 * @param label Name of the link
	 * @return This instance for chaining
	 */
	public ExternalLink setLabel(String label)
	{
		this.label = label;
		this.sendElement();
		return this;
	}
	
	@Override
	public String getName() {
		return "ExternalLink";
	}

	@Override
	public String getData() {
		return "{\"url\":"+Json.escapeString(url)+",\"label\":"+Json.escapeString(label)+"}";
	}
}

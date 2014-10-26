package net.magik6k.jwwf.core;

import net.magik6k.jwwf.util.Json;

import org.eclipse.jetty.websocket.WebSocket.Connection;


/**
 * Special panel to add widgets to. Created internally
 */
public final class MainFrame extends Widget{

	private int content = -1;
	private String title = "Java Web Widget Framework";
	private User user;
	
	public MainFrame(int id, Connection creator) {
		super(id, creator);
		this.sendElement();
	}

	@Override
	public String getName() {
		return "MainFrame";
	}

	@Override
	public String getData() {
		return "{\"content\":"+String.valueOf(content)+", \"title\":"+Json.escapeString(title)+"}";
	}

	protected void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Adds widget to page
	 * @param widget Widget/container to present
	 * @return This instance for chaining
	 */
	public MainFrame put(Widget widget) {
		widget.addTo(user);
		content = widget!= null?widget.getID():-1;
		this.sendElement();
		return this;
	}
	
	/**
	 * Sets page title
	 * @param title new title
	 * @return This instance for chaining
	 */
	public MainFrame setTitle(String title){
		this.title = title;
		this.sendElement();
		return this;
	}
	
	
}

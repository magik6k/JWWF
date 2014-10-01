package net.magik6k.jwwf;

import org.java_websocket.WebSocket;

/**
 * Client descriptor
 * Internal use only
 */
public class Connection {
	protected final WebSocket connection;
	
	public Connection(WebSocket connection) {
		this.connection = connection;
	}
}

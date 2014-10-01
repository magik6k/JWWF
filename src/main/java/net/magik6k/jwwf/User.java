package net.magik6k.jwwf;

import net.magik6k.jwwf.widgets.MainFrame;

import org.java_websocket.WebSocket;

public abstract class User {
	private final Connection connection;
	private int id = 1;//0 is for MainFrame
	
	/**
	 * User is constructed per each connection incoming
	 * @param rootFrame Special panel to put all other panels into(like page body)
	 * @param connection connection passed to super-constructor / only used internally
	 */
	public User(MainFrame rootFrame, Connection connection){
		this.connection = connection;
	}

	protected Connection getConnection() {
		return connection;
	}
	
	protected int nextElementId() {
		return id++;
	}
}

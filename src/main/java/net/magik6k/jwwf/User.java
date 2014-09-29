package net.magik6k.jwwf;

import net.magik6k.jwwf.widgets.MainFrame;

import org.java_websocket.WebSocket;

public abstract class User {
	private final Connection connection;
	private int id = 1;//0 is for MainFrame
	
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

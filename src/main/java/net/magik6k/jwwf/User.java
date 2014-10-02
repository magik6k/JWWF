package net.magik6k.jwwf;

import java.util.HashMap;

import net.magik6k.jwwf.widgets.MainFrame;

import org.java_websocket.WebSocket;

public abstract class User {
	private final Connection connection;
	private int id = 1;//0 is for MainFrame
	private HashMap<Integer, DataHandler> actionHandlers = new HashMap<Integer, DataHandler>();
	
	
	/**
	 * User is constructed per each connection incoming
	 * @param rootFrame Special panel to put all other panels into(like page body)
	 * @param connection connection passed to super-constructor / only used internally
	 */
	public User(MainFrame rootFrame, Connection connection){
		this.connection = connection;
	}

	protected final Connection getConnection() {
		return connection;
	}
	
	protected final int nextElementId() {
		return id++;
	}
	
	protected final void onData(String msg){
		if(msg.startsWith(Actions.BUTTON_CLICK.apiName))
		{
			actionHandlers.get(new Integer((String) msg.subSequence(1, msg.length()))).handleData(msg);
		}
	}
	protected final void setActionHandler(int id, DataHandler dataHandler){
		actionHandlers.put(id, dataHandler);
	}
}

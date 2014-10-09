package net.magik6k.jwwf.core;

import java.util.HashMap;

public abstract class User {
	private final Connection connection;
	private int id = 1;//0 is for MainFrame
	private HashMap<Integer, Widget> actionHandlers = new HashMap<Integer, Widget>();
	public final UserData userData;
	
	/**
	 * User is constructed per each connection incoming
	 * @param rootFrame Special panel to put all other panels into(like page body)
	 * @param connection connection passed to super-constructor / only used internally
	 */
	public User(MainFrame rootFrame, Connection connection){
		this.connection = connection;
		rootFrame.setUser(this);
		userData = new UserData(this);
	}

	protected final Connection getConnection() {
		return connection;
	}
	
	protected final int nextElementId() {
		return id++;
	}
	
	protected final void onData(String msg){
		if(msg.startsWith(Actions.BUTTON_CLICK.apiName)){//B18
			actionHandlers.get(new Integer((String) msg.subSequence(1, msg.length()))).handleData(msg);
			
		}else if(msg.startsWith(Actions.TEXT_INPUT.apiName)){//T18;text
			actionHandlers.get(new Integer((String) msg.subSequence(1, msg.indexOf(";"))))
				.handleData((String) msg.subSequence( msg.indexOf(";")+1, msg.length()));
			
		}else if(msg.startsWith(Actions.CHECK_STATE.apiName)){//C18;1
			actionHandlers.get(new Integer((String) msg.subSequence(1, msg.indexOf(";"))))
			.handleData((String) msg.subSequence( msg.indexOf(";")+1, msg.length()));
		}else if(msg.startsWith(Actions.SELECT.apiName)){//S18;1
			actionHandlers.get(new Integer((String) msg.subSequence(1, msg.indexOf(";"))))
			.handleData((String) msg.subSequence( msg.indexOf(";")+1, msg.length()));
		}else if(msg.startsWith(Actions.USERDATA.apiName)){//Ukey;value
			userData.recvData((String)msg.subSequence(1, msg.indexOf(";")), (String)msg.subSequence( msg.indexOf(";")+1, msg.length()));
		}
	}
	protected final void setActionHandler(int id, Widget dataHandler){
		actionHandlers.put(id, dataHandler);
	}
}

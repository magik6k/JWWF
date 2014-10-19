package net.magik6k.jwwf.core;

import java.util.HashMap;

import net.magik6k.jwwf.enums.Actions;

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
	/**
	 * This function is called when user disconnects for some reason,
	 * If user has some resourcues that need manual cleanup override
	 * this function
	 */
	public void destroy(){};

	protected final Connection getConnection() {
		return connection;
	}
	
	protected final int nextElementId() {
		return id++;
	}
	
	protected final void onData(String msg){
		if(msg.startsWith(Actions.BUTTON_CLICK.apiName)){//B18
			try {
				actionHandlers.get(new Integer((String) msg.subSequence(1, msg.length()))).handleData(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(msg.startsWith(Actions.TEXT_INPUT.apiName)){//T18;text
			try {
				actionHandlers.get(new Integer((String) msg.subSequence(1, msg.indexOf(";"))))
					.handleData((String) msg.subSequence( msg.indexOf(";")+1, msg.length()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(msg.startsWith(Actions.CHECK_STATE.apiName)){//C18;1
			try {
				actionHandlers.get(new Integer((String) msg.subSequence(1, msg.indexOf(";"))))
				.handleData((String) msg.subSequence( msg.indexOf(";")+1, msg.length()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(msg.startsWith(Actions.SELECT.apiName)){//S18;1
			try {
				actionHandlers.get(new Integer((String) msg.subSequence(1, msg.indexOf(";"))))
				.handleData((String) msg.subSequence( msg.indexOf(";")+1, msg.length()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(msg.startsWith(Actions.USERDATA.apiName)){//Ukey;value
			userData.recvData((String)msg.subSequence(1, msg.indexOf(";")), (String)msg.subSequence( msg.indexOf(";")+1, msg.length()));
		}
	}
	protected final void setActionHandler(int id, Widget dataHandler){
		actionHandlers.put(id, dataHandler);
	}
}

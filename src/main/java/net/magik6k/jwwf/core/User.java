package net.magik6k.jwwf.core;

import java.util.HashMap;

import net.magik6k.jwwf.enums.Actions;

import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

public abstract class User implements OnTextMessage{
	private Connection connection;
	private int id = 1;//0 is for MainFrame
	private HashMap<Integer, Widget> actionHandlers = new HashMap<Integer, Widget>();
	protected MainFrame rootFrame;
	public UserData userData;
	
	protected abstract void initializeUser(MainFrame rootFrame);
	
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
	
	private final void onData(String msg){
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
			
		}else if(msg.startsWith(Actions.SLIDE.apiName)){//L18;0.12345
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
	@Override
	public void onOpen(Connection connection) {
		this.connection = connection;
		connection.setMaxTextMessageSize(1024*1024);//TODO: make configurable
		rootFrame = new MainFrame(0, connection);
		rootFrame.setUser(this);
		userData = new UserData(this);
		connection.setMaxIdleTime(JwwfServer.userIdleTime);
		initializeUser(rootFrame);
	}
	@Override
	public void onClose(int closeCode, String message) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onMessage(String data) {
		this.onData(data);		
	}
}

package net.magik6k.jwwf.core;

import net.magik6k.jwwf.core.action.Actions;

import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

public abstract class User implements OnTextMessage{
	private Connection connection;
	private int id = 1;//0 is for MainFrame
	//private HashMap<Integer, Widget> actionHandlers = new HashMap<Integer, Widget>();
	protected MainFrame rootFrame;
	private UserState userState;
	
	/**
	 * @deprecated Use getUserData method
	 */
	@Deprecated
	public UserData userData;
	
	protected abstract void initializeUser(MainFrame rootFrame);
	
	/**
	 * This function is called when user disconnects for some reason,
	 * If user has some resourcues that need manual cleanup override
	 * this function
	 */
	public void destroy(){};//FIXME: Is this actually called?

	protected final Connection getConnection() {
		return connection;
	}
	
	protected final int nextElementId() {
		return id++;
	}
	
	private final void onData(String data){
		Actions.processData(userState, data);
	}
	
	protected final void setActionHandler(int id, Widget dataHandler){
		userState.actionHandlers.put(id, dataHandler);
	}
	
	@Override
	public void onOpen(Connection connection) {
		this.connection = connection;
		connection.setMaxTextMessageSize(1024*1024);//TODO: make configurable
		rootFrame = new MainFrame(0, connection);
		rootFrame.setUser(this);
		userState = new UserState();
		userState.userData = new UserData(this);
		userData = userState.userData;
		
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
	
	public UserData getUserData(){
		return userState.userData;
	}
}

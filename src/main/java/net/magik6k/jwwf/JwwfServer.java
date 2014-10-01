package net.magik6k.jwwf;

import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;

import net.magik6k.jwwf.widgets.MainFrame;

import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class JwwfServer extends WebSocketServer{

	private HashMap<WebSocket, User> connections = new HashMap<WebSocket, User>();
	private final Class<? extends User> user;
	
	/**
	 * Server constructor
	 * @param user User handler class
	 * @param port Port to bind server to
	 * @throws UnknownHostException
	 */
	public JwwfServer( Class<? extends User> user, int port) throws UnknownHostException {
		super( new InetSocketAddress( port ), Collections.singletonList( (Draft)new Draft_17() ) );
		this.user = user;
	}
	
	/**
	 * Server constructor
	 * @param user User handler class
	 * @param address Address to bind server to
	 * @throws UnknownHostException
	 */
	public JwwfServer( Class<? extends User> user, InetSocketAddress address) {
		super( address, Collections.singletonList( (Draft)new Draft_17() ) );
		this.user = user;
	}

	@Override
	public void onClose(WebSocket arg0, int arg1, String arg2, boolean arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(WebSocket arg0, Exception arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(WebSocket arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onOpen(WebSocket arg0, ClientHandshake arg1) {
		// TODO Auto-generated method stub
		System.out.printf("HI. hash: %d, str: %s\n", arg0.hashCode(), arg0.toString());
		Connection connection = new Connection(arg0);
		MainFrame mainFrame = new MainFrame(0, connection);
		try {
			User u = user.getDeclaredConstructor(MainFrame.class, Connection.class).newInstance(mainFrame, connection);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		//User userInstance = user.getDeclaredConstructor(user).newInstance(mainFrame, connection);
		
	}

	
	
	
}
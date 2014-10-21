package net.magik6k.jwwf.core.servlet;

import javax.servlet.http.HttpServletRequest;

import net.magik6k.jwwf.core.util.UserFactory;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class APISocketServlet extends WebSocketServlet{
	
	private static final long serialVersionUID = -7312431906619293571L;
	private final UserFactory userFactory;
	
	public APISocketServlet(UserFactory userFactory) {
		this.userFactory = userFactory;
	}
	
	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request,
			String protocol) {
		System.out.println("Doing new Websc");
		return userFactory.createUser();
	}

}

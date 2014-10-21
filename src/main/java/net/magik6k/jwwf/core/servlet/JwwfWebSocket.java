package net.magik6k.jwwf.core.servlet;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

class JwwfWebSocket extends WebSocketServlet{
	
	private static final long serialVersionUID = -7312431906619293571L;

	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request,
			String protocol) {
		return null;
	}

}

package net.magik6k.jwwf.core;

import net.magik6k.jwwf.core.servlet.ClientServlet;
import net.magik6k.jwwf.handlers.LogHandler;
import net.magik6k.jwwf.handlers.NullLogHandler;
import net.magik6k.jwwf.handlers.StdLogHandler;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyServer {
	//XXX: https://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty
	//XXX: ->>>>>> https://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty#Creating_Servlets
	//XXX: ->>>>>> http://www.eclipse.org/jetty/documentation/current/jetty-websocket-server-api.html
	
	Server server;
	ServletContextHandler context;
	
	public static LogHandler logger = new StdLogHandler();
	
	/**
	 * Server constructor
	 * @param port Port to bind server to 
	 */
	public JettyServer(int port) {
		server = new Server(port);
		
        context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
	}
	
	/**
	 * Binds webapp to address, by default '/'
	 * @param user
	 * @param url
	 */
	public JettyServer bind(Class<? extends User> user, String url){
		context.addServlet(new ServletHolder(new ClientServlet()),url + "*");
		return this;
	}
	
	/**
	 * Binds webapp to '/' address
	 * @param user
	 * @param url
	 */
	public JettyServer bind(Class<? extends User> user){
		bind(user, "/");
		return this;
	}
	
	public JettyServer start(){
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public static void debugOutput(boolean enable){
		logger.enableDebug(enable);
	}
	
	public static void setQuietLogger(){
		logger = new NullLogHandler();
	}
	
}

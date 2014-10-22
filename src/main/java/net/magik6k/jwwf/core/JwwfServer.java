package net.magik6k.jwwf.core;

import net.magik6k.jwwf.core.servlet.SkinServlet;
import net.magik6k.jwwf.core.servlet.WebClientServelt;
import net.magik6k.jwwf.core.servlet.APISocketServlet;
import net.magik6k.jwwf.core.util.UserFactory;
import net.magik6k.jwwf.handlers.LogHandler;
import net.magik6k.jwwf.handlers.NullLogHandler;
import net.magik6k.jwwf.handlers.StdLogHandler;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JwwfServer {
	//XXX: https://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty
	//XXX: ->>>>>> https://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty#Creating_Servlets
	//XXX: ->>>>>> http://www.eclipse.org/jetty/documentation/current/jetty-websocket-server-api.html
	
	Server server;
	ServletContextHandler context;
	
	public static LogHandler logger = new StdLogHandler();
	public static int userIdleTime = Integer.MAX_VALUE;
	/**
	 * Server constructor
	 * @param port Port to bind server to 
	 */
	public JwwfServer(int port) {
		server = new Server(port);
		
        context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
	}
	
	/**
	 * Binds webapp to address, by default '/'
	 * @param user User class for web application
	 * @param url Url to bind to, myst begin and end with /, like /foo/bar/
	 * @return JwwfServer instance to allow chaining
	 */
	public JwwfServer bindWebapp(final Class<? extends User> user, String url){
		context.addServlet(new ServletHolder(new WebClientServelt()),url + "");
		context.addServlet(new ServletHolder(new SkinServlet()),url + "skins/*");
		context.addServlet(new ServletHolder(new APISocketServlet(new UserFactory() {
			
			@Override
			public User createUser() {				
				try {
					return user.getDeclaredConstructor().newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		})),url + "wshnd");
		return this;
	}
	
	/**
	 * Binds webapp to '/' address
	 * @param user
	 * @return JwwfServer instance to allow chaining
	 */
	public JwwfServer bindWebapp(Class<? extends User> user){
		bindWebapp(user, "/");
		return this;
	}
	
	/**
	 * Binds Jetty servlet to URL, this allows creation of REST APIs, etc
	 * @param servletHolder Jetty servlet holder
	 * @param url URL to bind servlet to
	 * @return JwwfServer instance to allow chaining
	 */
	public JwwfServer bindJettyServlet(ServletHolder servletHolder, String url){
		context.addServlet(servletHolder, url);
		return this;
	}
	
	/**
	 * Starts Jetty server in background
	 * @return JwwfServer instance to allow chaining
	 */
	public JwwfServer start(){
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	/**
	 * Starts Jetty server and waits for it
	 * @return JwwfServer instance to allow chaining
	 */
	public JwwfServer startAndJoin(){
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	/**
	 * Waits for jetty server
	 * @return JwwfServer instance to allow chaining
	 */
	public JwwfServer join(){
		try {
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

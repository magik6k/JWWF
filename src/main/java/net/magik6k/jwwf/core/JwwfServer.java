package net.magik6k.jwwf.core;

import net.magik6k.jwwf.core.plugin.ClientCreator;
import net.magik6k.jwwf.core.plugin.IPluginGlobal;
import net.magik6k.jwwf.core.plugin.IPluginWebapp;
import net.magik6k.jwwf.core.servlet.APISocketServlet;
import net.magik6k.jwwf.core.servlet.ResourceServlet;
import net.magik6k.jwwf.core.servlet.SkinServlet;
import net.magik6k.jwwf.core.servlet.WebClientServelt;
import net.magik6k.jwwf.core.util.UserFactory;
import net.magik6k.jwwf.core.util.WebClientCreator;
import net.magik6k.jwwf.handlers.LogHandler;
import net.magik6k.jwwf.handlers.NullLogHandler;
import net.magik6k.jwwf.handlers.StdLogHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;
import java.util.LinkedList;
import java.util.List;

public class JwwfServer {
	private Server server;
	private ServletContextHandler context;
	private LinkedList<JwwfPlugin> plugins = new LinkedList<>();
	private final WebClientCreator clientCreator = new WebClientCreator();
	private final JwwfServer jwwfServer = this;

	public static LogHandler logger = new StdLogHandler();
	public static int userIdleTime = Integer.MAX_VALUE;

	/**
	 * Server constructor
	 *
	 * @param port Port to bind server to
	 */
	public JwwfServer(int port) {
		server = new Server(port);

		context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
	}

	/**
	 * Binds webapp to address
	 *
	 * @param user User class for the web application
	 * @param url  Url to bind to, myst begin and end with /, like /foo/bar/
	 * @return This JwwfServer
	 */
	public JwwfServer bindWebapp(final Class<? extends User> user, String url) {
		if (!url.endsWith("/"))
			url = url + "/";

		context.addServlet(new ServletHolder(new WebClientServelt(clientCreator)), url + "");
		context.addServlet(new ServletHolder(new SkinServlet()), url + "__jwwf/skins/*");
		ServletHolder fontServletHolder = new ServletHolder(new ResourceServlet());
		fontServletHolder.setInitParameter("basePackage", "net/magik6k/jwwf/assets/fonts");
		context.addServlet(fontServletHolder, url + "__jwwf/fonts/*");
		context.addServlet(new ServletHolder(new APISocketServlet(new UserFactory() {

			@Override
			public User createUser() {
				try {
					User u = user.getDeclaredConstructor().newInstance();
					u.setServer(jwwfServer);
					return u;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		})), url + "__jwwf/socket");

		for (JwwfPlugin plugin : plugins) {
			if (plugin instanceof IPluginWebapp)
				((IPluginWebapp) plugin).onWebappBound(this, url);
		}

		return this;
	}

	/**
	 * Binds webapp to '/' address
	 *
	 * @param user User class for the web application
	 * @return This JwwfServer
	 * @see #bindServlet(ServletHolder, String)
	 */
	public JwwfServer bindWebapp(Class<? extends User> user) {
		bindWebapp(user, "/");
		return this;
	}

	/**
	 * <p>Binds ServletHolder to URL, this allows creation of REST APIs, etc</p>
	 * <p>PLUGINS: Plugin servlets should have url's like /__jwwf/myplugin/stuff</p>
	 *
	 * @param servletHolder Servlet holder
	 * @param url           URL to bind servlet to
	 * @return This JwwfServer
	 */
	public JwwfServer bindServlet(ServletHolder servletHolder, String url) {
		context.addServlet(servletHolder, url);
		return this;
	}

	/**
	 * <p>Binds ServletHolder to URL, this allows creation of REST APIs, etc</p>
	 * <p>PLUGINS: Plugin servlets should have url's like /__jwwf/myplugin/stuff</p>
	 *
	 * @param servlet Servlet holder
	 * @param url     URL to bind servlet to
	 * @return This JwwfServer
	 */
	public JwwfServer bindServlet(Servlet servlet, String url) {
		context.addServlet(new ServletHolder(servlet), url);
		return this;
	}

	/**
	 * Attahes new plugin to this server
	 *
	 * @param plugin Plugin to attach
	 * @return This JwwfServer
	 */
	public JwwfServer attachPlugin(JwwfPlugin plugin) {
		plugins.add(plugin);
		if (plugin instanceof IPluginGlobal)
			((IPluginGlobal) plugin).onAttach(this);
		return this;
	}

	/**
	 * This method provides interface to client creator
	 *
	 * @return {@link ClientCreator} instance
	 */
	public ClientCreator getCreator() {
		return clientCreator;
	}

	/**
	 * Starts Jetty server in background
	 *
	 * @return This JwwfServer
	 */
	public JwwfServer start() {
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * Starts Jetty server and waits for it
	 *
	 * @return This JwwfServer
	 */
	public JwwfServer startAndJoin() {
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
	 *
	 * @return This JwwfServer
	 */
	public JwwfServer join() {
		try {
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	/**
	 * This method returns list containing instances of all plugins
	 * attached to this server.
	 *
	 * @return List containing instances of attached plugins.
	 */
	@SuppressWarnings("unchecked")
	public List<JwwfPlugin> getPlugins() {
		return (List<JwwfPlugin>) plugins.clone();
	}

	/**
	 * <p>
	 * Sometimes you have to release your application and you can't set proxy for
	 * websocket connections, you need to set url of api here.
	 * </p><p>
	 * Default(automatic) address is ws://"+document.location.host+"/__jwwf/socket,
	 * Generally it should be ws[s]://[bound adress]/__jwwf/socket
	 * </p>
	 *
	 * @param url Url to set
	 */
	public void setApiUrl(String url) {
		clientCreator.setApiServer(url);
	}

	public static void debugOutput(boolean enable) {
		logger.enableDebug(enable);
	}

	public static void setQuietLogger() {
		logger = new NullLogHandler();
	}

}

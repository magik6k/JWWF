package net.magik6k.jwwf.core.plugin;

import net.magik6k.jwwf.core.JwwfServer;

/**
 * Plugins with this interface will get notified when a webapp is bound to server
 */
public interface IPluginWebapp {
	public void onWebappBound(JwwfServer server, String url);
}

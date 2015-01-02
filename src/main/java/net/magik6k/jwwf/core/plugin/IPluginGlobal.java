package net.magik6k.jwwf.core.plugin;

import net.magik6k.jwwf.core.JwwfServer;

/**
 * Plugins with this interface will get notified when it's attached to server
 */
public interface IPluginGlobal {
	public void onAttach(JwwfServer server);
}

package net.magik6k.jwwf.example.plugin;

import net.magik6k.jwwf.core.JwwfPlugin;
import net.magik6k.jwwf.core.JwwfServer;
import net.magik6k.jwwf.core.plugin.IPluginGlobal;

public class ExamplePlugin extends JwwfPlugin implements IPluginGlobal{

	@Override
	public void onAttach(JwwfServer server) {
		server.getCreator().registerWidget("ExamplePluginWidget"
				, "return {element: $('<b>This comes from plugin</b>').addClass('example'), data:{}}", "");
		
		server.getCreator().appendHead("<style>.example{color:red;}</style>");
	}
	
}

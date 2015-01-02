package net.magik6k.jwwf.example.plugin;

import net.magik6k.jwwf.core.Widget;

public class ExamplePluginWidget extends Widget{

	public ExamplePluginWidget(){
		
	}
	
	@Override
	public String getName() {
		return "ExamplePluginWidget";
	}

	@Override
	public String getData() {
		return "{}";
	}

}

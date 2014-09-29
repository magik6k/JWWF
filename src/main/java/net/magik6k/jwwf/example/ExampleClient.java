package net.magik6k.jwwf.example;

import net.magik6k.jwwf.Connection;
import net.magik6k.jwwf.User;
import net.magik6k.jwwf.widgets.MainFrame;
import net.magik6k.jwwf.widgets.TextLabel;

public class ExampleClient extends User{

	public ExampleClient(MainFrame rootFrame, Connection connection) {
		super(rootFrame, connection);
		System.out.println("Got new client!");
		
		rootFrame.put(new TextLabel(this, "test"));
	}

}

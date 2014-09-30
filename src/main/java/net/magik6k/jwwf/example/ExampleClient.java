package net.magik6k.jwwf.example;

import net.magik6k.jwwf.Connection;
import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;
import net.magik6k.jwwf.widgets.HorizontalPanel;
import net.magik6k.jwwf.widgets.MainFrame;
import net.magik6k.jwwf.widgets.TextLabel;
import net.magik6k.jwwf.widgets.VerticalPanel;

public class ExampleClient extends User{

	public ExampleClient(MainFrame rootFrame, Connection connection) {
		super(rootFrame, connection);
		System.out.println("Got new client!");
		
		Widget hp1 = new HorizontalPanel(this, 2, new TextLabel(this, "test"), new TextLabel(this, "test2"));
		Widget hp2 = new HorizontalPanel(this, 2, new TextLabel(this, "test3"), new TextLabel(this, "test4"));
		
		rootFrame.put(new VerticalPanel(this, 2, hp1, hp2));
	}

}

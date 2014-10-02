package net.magik6k.jwwf.example;

import java.util.Random;

import sun.security.util.Password;
import net.magik6k.jwwf.Connection;
import net.magik6k.jwwf.User;
import net.magik6k.jwwf.Widget;
import net.magik6k.jwwf.handlers.ClickHandler;
import net.magik6k.jwwf.handlers.TextHandler;
import net.magik6k.jwwf.widgets.AbsolutePanel;
import net.magik6k.jwwf.widgets.Button;
import net.magik6k.jwwf.widgets.ExternalLink;
import net.magik6k.jwwf.widgets.FixedPanel;
import net.magik6k.jwwf.widgets.HorizontalPanel;
import net.magik6k.jwwf.widgets.Image;
import net.magik6k.jwwf.widgets.InternalLink;
import net.magik6k.jwwf.widgets.MainFrame;
import net.magik6k.jwwf.widgets.PasswordInput;
import net.magik6k.jwwf.widgets.TablePanel;
import net.magik6k.jwwf.widgets.TextInput;
import net.magik6k.jwwf.widgets.TextLabel;
import net.magik6k.jwwf.widgets.VerticalPanel;

public class ExampleClient extends User{

	public ExampleClient(MainFrame rootFrame, Connection connection) {
		super(rootFrame, connection);
		System.out.println("Got new client!");
		
		final FixedPanel cat = new FixedPanel(this, 400, 400, new Image(this, 200, -1, "http://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Cat_cleaning_itself.jpg/1280px-Cat_cleaning_itself.jpg"));
		
		Widget button  = new Button(this, "testButton", new ClickHandler() {
			@Override
			public void clicked() {
				cat.setOffset(new Random().nextInt(401), 400);
			}
		});
		
		Widget hp1 = new HorizontalPanel(this, 2, new ExternalLink(this, "http://nativehttp.org", "test"), new TextLabel(this, "test2"));
		Widget hp2 = new AbsolutePanel(this, 0, 200,
				new HorizontalPanel(this, 2, button, new TextLabel(this, "test4")));
		
		ClickHandler internalLinkHandler = new ClickHandler() {
			@Override
			public void clicked(){
				cat.setOffset(400,new Random().nextInt(401));
			}			
		};
		
		final TextLabel intext = new TextLabel(this, "t13");
		
		Widget table = new TablePanel(this, 3, 3, 
				new TextLabel(this, "t11"),new TextLabel(this, "t12"),intext,
				new InternalLink(this, "t21",internalLinkHandler),new TextLabel(this, "t22"),new TextLabel(this, "t23"),
				new TextLabel(this, "t31"),new TextLabel(this, "t32"),new TextLabel(this, "t33"));
		
		TextInput input = new TextInput(this, "lkdifgj", new TextHandler() {
			
			@Override
			public void onType(String data) {
				intext.setText(data.toUpperCase());
			}
		});
		
		PasswordInput passInput = new PasswordInput(this, "pass", new TextHandler() {
			
			@Override
			public void onType(String data) {
				intext.setText("Pass:"+data);
			}
		});
		
		rootFrame.put(new VerticalPanel(this, 6, hp1, hp2, table, cat, input, passInput));
	}

}

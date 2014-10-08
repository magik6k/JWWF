package net.magik6k.jwwf.example;

import net.magik6k.jwwf.handlers.ClickHandler;
import net.magik6k.jwwf.widgets.basic.Button;
import net.magik6k.jwwf.widgets.basic.PasswordInput;
import net.magik6k.jwwf.widgets.basic.TextInput;
import net.magik6k.jwwf.widgets.basic.TextLabel;
import net.magik6k.jwwf.widgets.basic.VerticalPanel;

public class LoginPanel extends VerticalPanel{

	private final TextInput loginField;
	private final PasswordInput passwordField;
	private final Button loginButton;
	
	
	public LoginPanel() {
		super(3);
		
		loginField = new TextInput("login", null);
		passwordField = new PasswordInput("password", null);
		
		
		
		loginButton = new Button("LOGIN!", new ClickHandler() {
			@Override
			public void clicked() {
				if(loginField.getText().equals("user") && passwordField.getText().equals("password"))
				{
					put(new TextLabel("Logged In!"), 2);
				}
			}
		});
		
		this.put(loginField, 0);
		this.put(passwordField, 1);
		this.put(loginButton, 2);
		System.out.println("constructed");
	}
	
}

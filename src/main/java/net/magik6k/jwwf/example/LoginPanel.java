package net.magik6k.jwwf.example;

import net.magik6k.jwwf.User;
import net.magik6k.jwwf.handlers.ClickHandler;
import net.magik6k.jwwf.widgets.Button;
import net.magik6k.jwwf.widgets.PasswordInput;
import net.magik6k.jwwf.widgets.TextInput;
import net.magik6k.jwwf.widgets.TextLabel;
import net.magik6k.jwwf.widgets.VerticalPanel;

public class LoginPanel extends VerticalPanel{

	private final TextInput loginField;
	private final PasswordInput passwordField;
	private final Button loginButton;
	
	
	public LoginPanel(final User user) {
		super(user, 3);
		
		loginField = new TextInput(user, "login", null);
		passwordField = new PasswordInput(user, "password", null);
		
		
		
		loginButton = new Button(user, "LOGIN!", new ClickHandler() {
			@Override
			public void clicked() {
				if(loginField.getText().equals("user") && passwordField.getText().equals("password"))
				{
					put(new TextLabel(user, "Logged In!"), 2);
				}
			}
		});
		
		this.put(loginField, 0);
		this.put(passwordField, 1);
		this.put(loginButton, 2);
		System.out.println("constructed");
	}
	
}

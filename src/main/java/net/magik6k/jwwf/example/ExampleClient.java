package net.magik6k.jwwf.example;

import net.magik6k.jwwf.core.Connection;
import net.magik6k.jwwf.core.User;
import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.handlers.CheckHandler;
import net.magik6k.jwwf.handlers.ClickHandler;
import net.magik6k.jwwf.handlers.TextHandler;
import net.magik6k.jwwf.widgets.AbsolutePanel;
import net.magik6k.jwwf.widgets.Button;
import net.magik6k.jwwf.widgets.CheckBox;
import net.magik6k.jwwf.widgets.ExternalLink;
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

		/* Example TextLabel*/
		TextLabel textLabelExample = new TextLabel(this, "This is example text");
		
		/*Image example*/
		
		TextLabel imageDesc = new TextLabel(this, "Image");
		Image image = new Image(this, 200, -1, "http://upload.wikimedia.org/wikipedia/commons/5/5c/View_from_the_Window_at_Le_Gras%2C_Joseph_Nic%C3%A9phore_Ni%C3%A9pce.jpg");
		
		/* Example VerticalPanel */
		
		TextLabel verticalPanelDesc = new TextLabel(this, "VerticalPanel");
		VerticalPanel verticalPanel = new VerticalPanel(this, 3,
				new TextLabel(this, "e1"),new TextLabel(this, "e2"),new TextLabel(this, "e3"));
		
		/* Example HorizontalPanel */
		
		TextLabel horizontalPanelDesc = new TextLabel(this, "HorizontalPanel");
		HorizontalPanel horizontalPanel = new HorizontalPanel(this, 3,
				new TextLabel(this, "e1"),new TextLabel(this, "e2"),new TextLabel(this, "e3"));
		
		/* Example TablePanel */
		
		TextLabel tablePanelDesc = new TextLabel(this, "TablePanel");
		TablePanel tablePanel = new TablePanel(this, 2, 2,
				new TextLabel(this, "e1"),new TextLabel(this, "e2"),
				new TextLabel(this, "e3"),new TextLabel(this, "e4"));
		
		/* Example AbsolutePanel */
		
		TextLabel absolutePanelDesc = new TextLabel(this, "AbsolutePanel");
		AbsolutePanel absolutePanel = new AbsolutePanel(this, 200, 8, 
				new TextLabel(this, "AbsolutePanel content"));
		
		/* Example ExternalLink*/
		
		TextLabel externalLinkDesc = new TextLabel(this, "External link");
		ExternalLink externalLink = new ExternalLink(this, "http://example.org", "example");
		
		/* Example InternalLink */
		
		final TextLabel internalLinkDesc = new TextLabel(this, "Internal link");
		InternalLink internalLink = new InternalLink(this, "example", new ClickHandler() {
			private int clicks = 0;
			
			@Override
			public void clicked() {
				internalLinkDesc.setText("Internal link("+String.valueOf(++clicks)+")");
			}
		});
		
		/* Example Button */
		
		final TextLabel buttonDesc = new TextLabel(this, "Button");
		Button button = new Button(this, "example", new ClickHandler() {
			private int clicks = 0;
			
			@Override
			public void clicked() {
				buttonDesc.setText("Button("+String.valueOf(++clicks)+")");
			}
		});
		
		/* Example TextInput */
		
		final TextLabel textInputDesc = new TextLabel(this, "TextInput");
		TextInput textInput = new TextInput(this, "TextInput", new TextHandler() {
			
			@Override
			public void onType(String data) {
				textInputDesc.setText("TextInput("+data+")");
			}
		});
		
		/* Example PasswordInput */		
		
		final TextLabel passwordInputDesc = new TextLabel(this, "PasswordInput");
		PasswordInput passwordInput = new PasswordInput(this, "PasswordInput", new TextHandler() {
			
			@Override
			public void onType(String data) {
				passwordInputDesc.setText("PasswordInput("+data+")");
			}
		});
		
		/* Example CheckBox */
		
		final TextLabel checkBoxDesc = new TextLabel(this, "CheckBox");
		CheckBox checkBox = new CheckBox(this, new CheckHandler() {
			@Override
			public void checked(boolean state) {
				checkBoxDesc.setText("CheckBox("+String.valueOf(state)+")");
			}
		});
		
		/* Custom panel example */		
		Widget customPanel = new LoginPanel(this);		
		TextLabel customPanelDesc = new TextLabel(this, "Custom panel");
		
		//Container for all examples
		Widget exapmles = new TablePanel(this, 2, 13, 
				textLabelExample,	null,
				imageDesc,			image,
				verticalPanelDesc,	verticalPanel,
				horizontalPanelDesc,horizontalPanel,
				tablePanelDesc,		tablePanel,
				absolutePanelDesc,	absolutePanel,
				externalLinkDesc,	externalLink,
				internalLinkDesc,	internalLink,
				buttonDesc,			button,
				textInputDesc,		textInput,
				passwordInputDesc,	passwordInput,
				checkBoxDesc,		checkBox,
				customPanelDesc,	customPanel);
		
		rootFrame.put(exapmles);
	}

}

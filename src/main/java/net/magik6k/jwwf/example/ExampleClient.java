package net.magik6k.jwwf.example;

import net.magik6k.jwwf.core.Connection;
import net.magik6k.jwwf.core.MainFrame;
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
import net.magik6k.jwwf.widgets.PasswordInput;
import net.magik6k.jwwf.widgets.TablePanel;
import net.magik6k.jwwf.widgets.TextArea;
import net.magik6k.jwwf.widgets.TextInput;
import net.magik6k.jwwf.widgets.TextLabel;
import net.magik6k.jwwf.widgets.VerticalPanel;

public class ExampleClient extends User{

	public ExampleClient(MainFrame rootFrame, Connection connection) {
		super(rootFrame, connection);
		System.out.println("Got new client!");

		/* Example TextLabel*/
		TextLabel textLabelExample = new TextLabel("This is example text");
		
		/*Image example*/
		
		TextLabel imageDesc = new TextLabel("Image");
		Image image = new Image(200, -1, "http://upload.wikimedia.org/wikipedia/commons/5/5c/View_from_the_Window_at_Le_Gras%2C_Joseph_Nic%C3%A9phore_Ni%C3%A9pce.jpg");
		
		/* Example VerticalPanel */
		
		TextLabel verticalPanelDesc = new TextLabel("VerticalPanel");
		VerticalPanel verticalPanel = new VerticalPanel(3,
				new TextLabel("e1"),new TextLabel("e2"),new TextLabel("e3"));
		
		/* Example HorizontalPanel */
		
		TextLabel horizontalPanelDesc = new TextLabel("HorizontalPanel");
		HorizontalPanel horizontalPanel = new HorizontalPanel(3,
				new TextLabel("e1"),new TextLabel("e2"),new TextLabel("e3"));
		
		/* Example TablePanel */
		
		TextLabel tablePanelDesc = new TextLabel("TablePanel");
		TablePanel tablePanel = new TablePanel(2, 2,
				new TextLabel("e1"),new TextLabel("e2"),
				new TextLabel("e3"),new TextLabel("e4"));
		
		/* Example AbsolutePanel */
		
		TextLabel absolutePanelDesc = new TextLabel("AbsolutePanel");
		AbsolutePanel absolutePanel = new AbsolutePanel(200, 8, 
				new TextLabel("AbsolutePanel content"));
		
		/* Example ExternalLink*/
		
		TextLabel externalLinkDesc = new TextLabel("External link");
		ExternalLink externalLink = new ExternalLink("http://example.org", "example");
		
		/* Example InternalLink */
		
		final TextLabel internalLinkDesc = new TextLabel("Internal link");
		InternalLink internalLink = new InternalLink("example", new ClickHandler() {
			private int clicks = 0;
			
			@Override
			public void clicked() {
				internalLinkDesc.setText("Internal link("+String.valueOf(++clicks)+")");
			}
		});
		
		/* Example Button */
		
		final TextLabel buttonDesc = new TextLabel("Button");
		Button button = new Button("example", new ClickHandler() {
			private int clicks = 0;
			
			@Override
			public void clicked() {
				buttonDesc.setText("Button("+String.valueOf(++clicks)+")");
			}
		});
		
		/* Example TextInput */
		
		final TextLabel textInputDesc = new TextLabel("TextInput");
		TextInput textInput = new TextInput("TextInput", new TextHandler() {
			
			@Override
			public void onType(String data) {
				textInputDesc.setText("TextInput("+data+")");
			}
		});
		
		/* Example PasswordInput */		
		
		final TextLabel passwordInputDesc = new TextLabel("PasswordInput");
		PasswordInput passwordInput = new PasswordInput("PasswordInput", new TextHandler() {
			
			@Override
			public void onType(String data) {
				passwordInputDesc.setText("PasswordInput("+data+")");
			}
		});
		
		/* Example CheckBox */
		
		final TextLabel checkBoxDesc = new TextLabel("CheckBox");
		CheckBox checkBox = new CheckBox(new CheckHandler() {
			@Override
			public void checked(boolean state) {
				checkBoxDesc.setText("CheckBox("+String.valueOf(state)+")");
			}
		});
		
		/* Example TextArea */
		
		final TextLabel textAreaDesc = new TextLabel("TextArea");
		TextArea textArea = new TextArea("Text area", new TextHandler() {
			@Override
			public void onType(String data) {
				textAreaDesc.setText("TextArea("+data+")");
			}
		});
		
		/* Custom panel example */		
		Widget customPanel = new LoginPanel();		
		TextLabel customPanelDesc = new TextLabel("Custom panel");
		
		//Container for all examples
		Widget exapmles = new TablePanel(2, 14, 
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
				textAreaDesc,		textArea,
				checkBoxDesc,		checkBox,
				customPanelDesc,	customPanel);
		
		rootFrame.put(exapmles);
	}

}

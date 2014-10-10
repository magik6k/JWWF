package net.magik6k.jwwf.example;

import net.magik6k.jwwf.core.Connection;
import net.magik6k.jwwf.core.MainFrame;
import net.magik6k.jwwf.core.User;
import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.handlers.CheckHandler;
import net.magik6k.jwwf.handlers.ClickHandler;
import net.magik6k.jwwf.handlers.SelectionHandler;
import net.magik6k.jwwf.handlers.TextHandler;
import net.magik6k.jwwf.handlers.UserDataHandler;
import net.magik6k.jwwf.util.NamedWidget;
import net.magik6k.jwwf.util.RadioGroup;
import net.magik6k.jwwf.widgets.basic.AbsolutePanel;
import net.magik6k.jwwf.widgets.basic.Button;
import net.magik6k.jwwf.widgets.basic.CheckBox;
import net.magik6k.jwwf.widgets.basic.ExternalLink;
import net.magik6k.jwwf.widgets.basic.HorizontalPanel;
import net.magik6k.jwwf.widgets.basic.Image;
import net.magik6k.jwwf.widgets.basic.InternalLink;
import net.magik6k.jwwf.widgets.basic.PasswordInput;
import net.magik6k.jwwf.widgets.basic.RadioButton;
import net.magik6k.jwwf.widgets.basic.TabbedPanel;
import net.magik6k.jwwf.widgets.basic.TablePanel;
import net.magik6k.jwwf.widgets.basic.TextArea;
import net.magik6k.jwwf.widgets.basic.TextInput;
import net.magik6k.jwwf.widgets.basic.TextLabel;
import net.magik6k.jwwf.widgets.basic.VerticalPanel;

public class ExampleClient extends User{

	public ExampleClient(MainFrame rootFrame, Connection connection) {
		super(rootFrame, connection);
		System.out.println("Got new client!");

		/* Example TextLabel*/
		TextLabel textLabelExample = new TextLabel("This is example text");
		
		/*Image example*/
		
		TextLabel imageDesc = new TextLabel("Image");
		Image image = new Image(200, -1, "http://upload.wikimedia.org/wikipedia/commons/5/5c/View_from_the_Window_at_Le_Gras%2C_Joseph_Nic%C3%A9phore_Ni%C3%A9pce.jpg");
		image.setAlternativeText("Old photo");
		
		/* Example VerticalPanel */
		
		TextLabel verticalPanelDesc = new TextLabel("VerticalPanel");
		VerticalPanel verticalPanel = new VerticalPanel(3,
				new TextLabel("e1"),new TextLabel("e2"),new TextLabel("e3"));
		
		/* Example HorizontalPanel */
		
		TextLabel horizontalPanelDesc = new TextLabel("HorizontalPanel");
		HorizontalPanel horizontalPanel = new HorizontalPanel(3,8,
				new TextLabel("e1"),new TextLabel("e2"),new TextLabel("e3"));
		
		/* Example TablePanel */
		
		TextLabel tablePanelDesc = new TextLabel("TablePanel");
		TablePanel tablePanel = new TablePanel(2, 2,
				new TextLabel("e1"),new TextLabel("e2"),
				new TextLabel("e3"),new TextLabel("e4"));
		tablePanel.setSpacing(24, 24);
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
		
		/* Example RadioButton*/
		
		final TextLabel radioButtonDesc = new TextLabel("RadioButton");
		
		RadioGroup group = new RadioGroup(new SelectionHandler() {
			@Override
			public void select(Object selectionData) {
				radioButtonDesc.setText("RadioButton("+(String)selectionData+")");
			}
		});
		
		HorizontalPanel radioButtons = new HorizontalPanel(2, 
				new RadioButton(group, "Button1"), new RadioButton(group, "Button2"));
		
		/* Example TextArea */
		
		final TextLabel textAreaDesc = new TextLabel("TextArea");
		TextArea textArea = new TextArea("Text area", new TextHandler() {
			@Override
			public void onType(String data) {
				textAreaDesc.setText("TextArea("+data+")");
			}
		});
		
		/* Exapmle TabbedPanel */
		
		TextLabel tabbedPanelDesc = new TextLabel("Tabbed panel");
		
		TextLabel tabbedPanelContent1 = new TextLabel("Example1");
		TextLabel tabbedPanelContent2 = new TextLabel("Example2");
		TextLabel tabbedPanelContent3 = new TextLabel("Example3");
		
		TabbedPanel tabbedPanel = new TabbedPanel(3, 
				new NamedWidget(tabbedPanelContent1, "Tab 1"),
				new NamedWidget(tabbedPanelContent2, "Tab 2"),
				new NamedWidget(tabbedPanelContent3, "Tab 3"));
		
		/* Custom panel example */		
		Widget customPanel = new LoginPanel();		
		TextLabel customPanelDesc = new TextLabel("Custom panel");
		
		/* UserData example*/
		
		final TextLabel userDataDesc = new TextLabel("UserData");
		
		userData.get("exampleKey", new UserDataHandler() {
			@Override
			public void data(String key, String value) {
				userDataDesc.setText("UserData:"+value);
			}
		});
		
		TextInput userDataInput = new TextInput("UserData", new TextHandler() {
			@Override
			public void onType(String data) {
				userDataDesc.setText("UserData:"+data);
				userData.set("exampleKey", data);
			}
		});
		
		//Container for all examples
		Widget exapmles = new TablePanel(2, 17, 
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
				radioButtonDesc,	radioButtons,
				tabbedPanelDesc,	tabbedPanel,
				customPanelDesc,	customPanel,
				userDataDesc,		userDataInput);
		
		rootFrame.put(exapmles);
	}

}

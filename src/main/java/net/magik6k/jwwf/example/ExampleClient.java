package net.magik6k.jwwf.example;

import net.magik6k.jwwf.core.MainFrame;
import net.magik6k.jwwf.core.User;
import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.PanelAlign;
import net.magik6k.jwwf.event.InputEvent;
import net.magik6k.jwwf.handlers.CheckHandler;
import net.magik6k.jwwf.handlers.ClickHandler;
import net.magik6k.jwwf.handlers.SelectionHandler;
import net.magik6k.jwwf.handlers.SlideHandler;
import net.magik6k.jwwf.handlers.TextHandler;
import net.magik6k.jwwf.handlers.UserDataHandler;
import net.magik6k.jwwf.util.NamedWidget;
import net.magik6k.jwwf.util.RadioGroup;
import net.magik6k.jwwf.widgets.basic.ExternalLink;
import net.magik6k.jwwf.widgets.basic.Image;
import net.magik6k.jwwf.widgets.basic.PreformattedTextLabel;
import net.magik6k.jwwf.widgets.basic.ProgressBar;
import net.magik6k.jwwf.widgets.basic.TextLabel;
import net.magik6k.jwwf.widgets.basic.input.Button;
import net.magik6k.jwwf.widgets.basic.input.CheckBox;
import net.magik6k.jwwf.widgets.basic.input.InternalLink;
import net.magik6k.jwwf.widgets.basic.input.PasswordInput;
import net.magik6k.jwwf.widgets.basic.input.RadioButton;
import net.magik6k.jwwf.widgets.basic.input.Slider;
import net.magik6k.jwwf.widgets.basic.input.TextArea;
import net.magik6k.jwwf.widgets.basic.input.TextInput;
import net.magik6k.jwwf.widgets.basic.panel.AbsolutePanel;
import net.magik6k.jwwf.widgets.basic.panel.HorizontalPanel;
import net.magik6k.jwwf.widgets.basic.panel.TabbedPanel;
import net.magik6k.jwwf.widgets.basic.panel.TablePanel;
import net.magik6k.jwwf.widgets.basic.panel.VerticalPanel;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class ExampleClient extends User{

	@Override
	protected void initializeUser(MainFrame rootFrame) {
		System.out.println("Got new client!");

		/* Example TextLabel*/
		TextLabel textLabelExample = new TextLabel("This is example text");
		PreformattedTextLabel preformattedTextLabelExample = 
			new PreformattedTextLabel("This is example\nPreformattedTextLabel\n. . .");
		
		/*Image example*/
		TextLabel imageDesc = new TextLabel("Image");
		Image image = new Image(200, -1, "http://upload.wikimedia.org/wikipedia/commons/5/5c/View_from_the_Window_at_Le_Gras%2C_Joseph_Nic%C3%A9phore_Ni%C3%A9pce.jpg");
		image.setAlternativeText("Old photo");
		
		/* Example VerticalPanel */		
		TextLabel verticalPanelDesc = new TextLabel("VerticalPanel");
		VerticalPanel verticalPanel = new VerticalPanel(3,
				new TextLabel("e1"),new TextLabel("e2e2"),new TextLabel("e3"));
		verticalPanel.setElementAlign(PanelAlign.MIDDLE);
		
		/* Example HorizontalPanel */		
		TextLabel horizontalPanelDesc = new TextLabel("HorizontalPanel");
		HorizontalPanel horizontalPanel = new HorizontalPanel(3,8,
				new TextLabel("e1"),new TextLabel("e2\ne2"),new TextLabel("e3"));
		horizontalPanel.setElementAlign(PanelAlign.MIDDLE);
		
		/* Example TablePanel */		
		TextLabel tablePanelDesc = new TextLabel("TablePanel");
		TablePanel tablePanel = new TablePanel(2, 2,
				new TextLabel("e1"),new TextLabel("e2"),
				new TextLabel("e3"),new TextLabel("e4"));
		tablePanel.setSpacing(16, 16);
		
		/* Example AbsolutePanel */		
		TextLabel absolutePanelDesc = new TextLabel("AbsolutePanel");
		AbsolutePanel absolutePanel = new AbsolutePanel(200, 8, 
				new TextLabel("AbsolutePanel content").setTextWrapping(false));
		
		/* Exapmle TabbedPanel */		
		TextLabel tabbedPanelDesc = new TextLabel("Tabbed panel");
		
		TextLabel tabbedPanelContent1 = new TextLabel("Example1");
		TextLabel tabbedPanelContent2 = new TextLabel("Example2");
		TextLabel tabbedPanelContent3 = new TextLabel("Example3");
		
		TabbedPanel tabbedPanel = new TabbedPanel(3, 
				new NamedWidget(tabbedPanelContent1, "Tab 1"),
				new NamedWidget(tabbedPanelContent2, "Tab 2"),
				new NamedWidget(tabbedPanelContent3, "Tab 3"));
		
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
		
		/* Example ProgressBar */
		
		TextLabel progressBarDesc = new TextLabel("ProgressBar");
		final ProgressBar progressBar = new ProgressBar(255, 0.5);		
		
		/* Example Slider */
		
		final TextLabel sliderDesc = new TextLabel("Slider");
		Slider slider = new Slider(new SlideHandler() {
			
			@Override
			public void slide(double position) {
				sliderDesc.setText("Slider: " + String.valueOf(position));
				progressBar.setProgress(position/120.0);
			}
		}, 30, 0, 120);
		
		
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
		
		/* Custom panel example */		
		Widget customPanel = new LoginPanel();		
		TextLabel customPanelDesc = new TextLabel("Custom panel");
		
		/* UserData example*/		
		TextLabel userDataDesc = new TextLabel("UserData");
		final TextInput userDataInput = new TextInput("UserData", "ThisWillPersist", new TextHandler() {
			@Override
			public void onType(String data) {
				userData.set("exampleKey", data);
			}
		});
		
		userData.get("exampleKey", new UserDataHandler() {
			@Override
			public void data(String key, String value) {
				userDataInput.setText(value);
			}
		});
		
		/* EventBus example */
		
		TextLabel busExampleDesc = new TextLabel("EventBus");
		final TextLabel busExample = new TextLabel("Events: 0");
		
		Object handler = new Object(){
			int events = 0;
			
			@Subscribe
			public void onInputAction(InputEvent e){
				busExample.setText("Events: " + String.valueOf(++events));
			}
		};
		
		EventBus exampleBus = new EventBus();
		exampleBus.register(handler);
		button.setEventBus(exampleBus);
		internalLink.setEventBus(exampleBus);
		slider.setEventBus(exampleBus);
		textInput.setEventBus(exampleBus);
		passwordInput.setEventBus(exampleBus);
		//...
		
		//Container for all examples
		Widget exapmles = new TablePanel(2, 20,
				textLabelExample,	preformattedTextLabelExample,
				imageDesc,			image,
				verticalPanelDesc,	verticalPanel,
				horizontalPanelDesc,horizontalPanel,
				tablePanelDesc,		tablePanel,
				absolutePanelDesc,	absolutePanel,
				tabbedPanelDesc,	tabbedPanel,
				externalLinkDesc,	externalLink,
				internalLinkDesc,	internalLink,
				buttonDesc,			button,
				progressBarDesc,	progressBar,
				sliderDesc,			slider,
				textInputDesc,		textInput,
				passwordInputDesc,	passwordInput,
				textAreaDesc,		textArea,
				checkBoxDesc,		checkBox,
				radioButtonDesc,	radioButtons,
				customPanelDesc,	customPanel,
				userDataDesc,		userDataInput,
				busExampleDesc,		busExample);
		
		rootFrame.setTitle("Example Jwwf WebApp");
		rootFrame.put(exapmles);
	}

}

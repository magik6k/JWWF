package net.magik6k.jwwf.core.action;

import net.magik6k.jwwf.core.UserState;


public enum Actions {
	BUTTON_CLICK("B", new ButtonClick()),
	TEXT_INPUT("T", new TextInput()),
	CHECK_STATE("C", new CheckState()),
	SELECT("S", new Select()),
	SLIDE("L", new Slide()),
	USERDATA("U", new UserData());
	
	public final String apiName;
	private final IAction handler;
	
	private Actions(String apiName, IAction handler) {
		this.apiName = apiName;
		this.handler = handler;
	}
	
	public static void processData(UserState userState, String data){
		for(Actions action : Actions.values()){
			if(data.startsWith(action.apiName)){
				action.handler.performAction(userState, data);
			}
		}
	}
	
	
}

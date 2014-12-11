package net.magik6k.jwwf.core;

import java.util.HashMap;

public class UserState {
	public final HashMap<Integer, Widget> actionHandlers = new HashMap<Integer, Widget>();
	public UserData userData;
	
	public void pushDataToWidget(Widget widget, String data) throws Exception{
		//We should check if the widget actually belongs to user
		widget.handleData(data);
	}
	
	public void userDataRecv(String key, String value){
		userData.recvData(key, value);
	}
}

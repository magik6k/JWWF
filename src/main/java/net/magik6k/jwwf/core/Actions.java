package net.magik6k.jwwf.core;


public enum Actions {
	BUTTON_CLICK("B"),
	TEXT_INPUT("T"),
	CHECK_STATE("C"),
	SELECT("S"),
	USERDATA("U");
	
	
	public final String apiName;
	
	private Actions(String apiName) {
		this.apiName = apiName;
	}
}

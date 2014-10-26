package net.magik6k.jwwf.enums;


public enum Actions {
	BUTTON_CLICK("B"),
	TEXT_INPUT("T"),
	CHECK_STATE("C"),
	SELECT("S"),
	SLIDE("L"),
	USERDATA("U");
	
	
	public final String apiName;
	
	private Actions(String apiName) {
		this.apiName = apiName;
	}
}

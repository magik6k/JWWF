package net.magik6k.jwwf;


public enum Actions {
	BUTTON_CLICK("B"),
	LINK_CLICK("L"),
	TEXT_INPUT("T");
	
	public final String apiName;
	
	private Actions(String apiName) {
		this.apiName = apiName;
	}
}

package net.magik6k.jwwf;


public enum Actions {
	BUTTON_CLICK("B"),
	LINK_CLICK("L");
	
	public final String apiName;
	
	private Actions(String apiName) {
		this.apiName = apiName;
	}
}

package net.magik6k.jwwf;


public enum Actions {
	BUTTON_CLICK("B");
	
	public final String apiName;
	
	private Actions(String apiName) {
		this.apiName = apiName;
	}
}

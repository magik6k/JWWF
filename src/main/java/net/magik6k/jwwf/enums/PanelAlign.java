package net.magik6k.jwwf.enums;

public enum PanelAlign {
	/**
	 * Valid for HorizontalPanel
	 */
	TOP("top"),
	/**
	 * Valid for VerticalPanel
	 */
	LEFT("left"),
	/**
	 * Valid for VerticalPanel and HorizontalPanel
	 */
	MIDDLE("middle"),
	/**
	 * Valid for VerticalPanel
	 */
	RIGHT("right"),
	/**
	 * Valid for HorizontalPanel
	 */
	BOTTOM("bottom");
	
	public final String propertyName;
	
	private PanelAlign(String propertyName) {
		this.propertyName = propertyName;
	}
}

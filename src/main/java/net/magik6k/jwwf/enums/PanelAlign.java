package net.magik6k.jwwf.enums;

public enum PanelAlign {
	
	/**
	 * Valid for HorizontalPanel, TablePanel(used as top-center)
	 */
	TOP("top"),
	
	/**
	 * Valid for VerticalPanel, TablePanel(used as middle-left)
	 */
	LEFT("left"),
	
	/**
	 * Valid for VerticalPanel and HorizontalPanel, TablePanel
	 */
	MIDDLE("middle"),
	
	/**
	 * Valid for VerticalPanel and HorizontalPanel, TablePanel, same as MIDDLE
	 */
	CENTER("middle"),
	
	/**
	 * Valid for VerticalPanel, TablePanel(used as middle-right)
	 */
	RIGHT("right"),
	
	/**
	 * Valid for HorizontalPanel, TablePanel(used as bottom-center)
	 */
	BOTTOM("bottom"),
	
	/**
	 * Valid for TablePanel
	 */
	TOPLEFT("topleft"),

	/**
	 * Valid for TablePanel
	 */
	TOPRIGHT("topright"),
	
	/**
	 * Valid for TablePanel
	 */
	MIDDLELEFT("middleleft"),

	/**
	 * Valid for TablePanel
	 */
	MIDDLERIGHT("middleright"),

	/**
	 * Valid for TablePanel
	 */
	BOTTOMLEFT("bottomleft"),

	/**
	 * Valid for TablePanel
	 */
	BOTTOMRIGHT("bottomright");
	public final String propertyName;
	
	private PanelAlign(String propertyName) {
		this.propertyName = propertyName;
	}
}

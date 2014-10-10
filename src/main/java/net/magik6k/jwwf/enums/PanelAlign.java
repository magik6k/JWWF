package net.magik6k.jwwf.enums;

/**
 * List of all possible aligns used for panles
 */
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
	TOP_LEFT("topleft"),

	/**
	 * Valid for TablePanel
	 */
	TOP_RIGHT("topright"),
	
	/**
	 * Valid for TablePanel
	 */
	MIDDLE_LEFT("middleleft"),

	/**
	 * Valid for TablePanel
	 */
	MIDDLE_RIGHT("middleright"),

	/**
	 * Valid for TablePanel
	 */
	BOTTOM_LEFT("bottomleft"),

	/**
	 * Valid for TablePanel
	 */
	BOTTOM_RIGHT("bottomright");
	public final String propertyName;
	
	private PanelAlign(String propertyName) {
		this.propertyName = propertyName;
	}
}

package net.magik6k.jwwf.core;


/**
 * Special panel to add widgets to. Created internally
 */
public final class MainFrame extends Widget{

	private int content = -1;
	private User user;
	
	public MainFrame(int id, Connection creator) {
		super(id, creator);
		this.sendElement();
	}

	@Override
	public String getName() {
		return "MainFrame";
	}

	@Override
	public String getData() {
		return "{\"content\":"+String.valueOf(content)+"}";
	}

	protected void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Adds widget to page
	 * @param widget Widget/container to present
	 */
	public void put(Widget widget) {
		widget.addTo(user);
		content = widget!= null?widget.getID():-1;
		this.sendElement();
	}
}

package net.magik6k.jwwf.util;

import net.magik6k.jwwf.core.Group;
import net.magik6k.jwwf.handlers.SelectionHandler;

public final class RadioGroup extends Group{
	private SelectionHandler handler;

	public RadioGroup(SelectionHandler handler) {
		this.handler = handler;
	}
	
	/**
	 * Internal use only
	 */
	public void select(Object userdata) {
		handler.select(userdata);
	}
	
	
}

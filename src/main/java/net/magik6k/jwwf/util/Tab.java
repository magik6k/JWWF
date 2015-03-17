package net.magik6k.jwwf.util;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Type;

/**
 * Simple wrapper for widget
 */
public class Tab {
	public final Type type;
	public final Widget widget;
	public final String name;

	public Tab(Widget widget, String name) {
		this.widget = widget;
		this.name = name;
		this.type = Type.DEFAULT;
	}

	public Tab(Widget widget, String name, Type type) {
		this.widget = widget;
		this.name = name;
		this.type = type;
	}
}

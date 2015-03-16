package net.magik6k.jwwf.util;

import net.magik6k.jwwf.core.Widget;

/**
 * Simple wrapper for widget
 */
public class NamedWidget {
	public final Widget widget;
	public final String name;

	public NamedWidget(Widget widget, String name) {
		this.widget = widget;
		this.name = name;
	}
}

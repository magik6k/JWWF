package net.magik6k.jwwf.widgets.special;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.widgets.basic.panel.Panel;

/**
 * Created by magik6k on 3/26/15.
 */
public class PanelWidgetWrapper extends Panel {
	public final Widget widget;

	public PanelWidgetWrapper(Widget widget) {
		super(12, 1, widget);
		this.widget = widget;
	}

	public PanelWidgetWrapper(Widget widget, int width) {
		super(width, 1, widget);
		this.widget = widget;
	}
}

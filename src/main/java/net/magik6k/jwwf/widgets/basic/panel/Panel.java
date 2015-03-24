package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.widgets.basic.panel.generic.LinePanel;

/**
 * Panel, used to hold elements in {@link net.magik6k.jwwf.widgets.basic.panel.Row Rows}.
 * Each panel have specified width that is a number
 * between 1 and 12 and represents number of fields
 * the panel will take inside row. Default width is
 * 6. Panel can hold nested rows. This panel is the
 * twitter bootstrap panel.
 */
public class Panel extends LinePanel {
	protected Widget[] content;
	protected byte width = 6;

	/**
	 * Creates new panel with default 6 width
	 * @param elements Number of elements
	 */
	public Panel(int elements) {
		super();
		content = new Widget[elements];
		for (int i = 0; i < content.length; ++i) content[i] = null;
		this.sendElement();
	}

	/**
	 * Creates new panel with default 4 width
	 * @param width Panel width(0 to 12)
	 * @param elements Number of elements
	 */
	public Panel(int width, int elements) {
		super();

		if(width < 0 || width > 12)
			throw new IllegalArgumentException("Panel width must be within 0-12 range");
		this.width = (byte) width;

		content = new Widget[elements];
		for (int i = 0; i < content.length; ++i) content[i] = null;
		this.sendElement();
	}

	/**
	 * @param elements Number of elements
	 * @param widgets Default widgets
	 */
	public Panel(int elements, Widget... widgets) {
		super();
		content = new Widget[elements];

		for (int i = 0; i < content.length; ++i) {
			if (i < widgets.length && widgets[i] != null) {
				attach(widgets[i]);
				content[i] = widgets[i];
			}
		}
		this.sendElement();
	}

	/**
	 * Creates new panel with default 6 width and one widget
	 * @param widget Widget to store in this panel
	 */
	public Panel(Widget widget) {
		this(1, widget);
	}

	/**
	 * @param width Panel width(0 to 12)
	 * @param elements Number of elements
	 * @param elements Default widgets
	 */
	public Panel(int width, int elements, Widget... widgets) {
		super();

		if(width < 0 || width > 12)
			throw new IllegalArgumentException("Panel width must be within 0-12 range");
		this.width = (byte) width;

		content = new Widget[elements];

		for (int i = 0; i < content.length; ++i) {
			if (i < widgets.length && widgets[i] != null) {
				attach(widgets[i]);
				content[i] = widgets[i];
			}
		}

		this.sendElement();
	}

	/**
	 * Sets new width for this element
	 * @param width New width 0 to 12
	 * @return This panel
	 */
	public Panel setWidth(int width) {
		if(width < 0 || width > 12)
			throw new IllegalArgumentException("Panel width must be within 0-12 range");
		this.width = (byte) width;
		this.sendElement();
		return this;
	}

	@Override
	public LinePanel put(Widget widget, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= content.length) throw new IndexOutOfBoundsException();
		attach(widget);
		content[index] = widget;
		this.sendElement();
		return this;
	}

	@Override
	public int put(Widget widget) throws IndexOutOfBoundsException {
		attach(widget);
		for (int i = 0; i < content.length; ++i)
			if (content[i] == null) {
				content[i] = widget;
				this.sendElement();
				return i;
			}
		throw new IndexOutOfBoundsException();
	}

	@Override
	public String getName() {
		return "Panel";
	}

	@Override
	public String getData() {
		String data = "";
		for (int i = 0; i < content.length; ++i) {
			if (i > 0) data += ",";
			data += "\"" + String.valueOf(content[i] != null ? content[i].getID() : -1) + "\"";
		}
	return new StringBuilder().append("{\"width\":").append(width).append(",\"content\":[").append(data).append("]}").toString();
	}
}

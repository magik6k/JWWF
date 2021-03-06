package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.widgets.basic.panel.generic.LinePanel;

/**
 * Row holds panels in a 'responsive' row. Each
 * panel has specified width, when width of elements
 * in a row is greater than 12, elements will flow
 * into next row.
 */
public class Row extends LinePanel {
	private Widget[] content;

	/**
	 * @param elements Number of elements
	 */
	public Row(int elements) {
		super();
		content = new Widget[elements];
		for (int i = 0; i < content.length; ++i) content[i] = null;
		this.sendElement();
	}

	/**
	 * @param elements Number of elements
	 * @param widgets Default widgets
	 */
	public Row(int elements, Widget... widgets) {
		super();
		content = new Widget[elements];

		for (int i = 0; i < content.length; ++i) {
			if (i < widgets.length && widgets[i] != null) {
				Widget widget = widgets[i];
				if(!(widget instanceof Panel))
					widget = new Panel(widget);
				attach(widget);
				content[i] = widget;
			}
		}

		this.sendElement();
	}

	@Override
	public LinePanel put(Widget widget, int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= content.length) throw new IndexOutOfBoundsException();

		if(!(widget instanceof Panel))
			widget = new Panel(widget);
		attach(widget);

		content[index] = widget;
		this.sendElement();
		return this;
	}

	@Override
	public int put(Widget widget) throws IndexOutOfBoundsException {
		if(!(widget instanceof Panel))
			widget = new Panel(widget);
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
		return "Row";
	}

	@Override
	public String getData() {
		String data = "";
		for (int i = 0; i < content.length; ++i) {
			if (i > 0) data += ",";
			data += "\"" + String.valueOf(content[i] != null ? content[i].getID() : -1) + "\"";
		}
		return new StringBuilder().append("{\"content\":[").append(data).append("]}").toString();
	}
}

package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Type;
import net.magik6k.jwwf.util.Json;

/**
 * Created by magik6k on 3/19/15.
 */
public class NamedPanel extends Panel {
	private String name = "Unnamed";
	private Type type = Type.DEFAULT;

	/**
	 * Creates new panel with default 6 width
	 * @param elements Number of elements
	 */
	public NamedPanel(int elements) {
		super(elements);
	}

	/**
	 * Creates new panel with default 4 width
	 * @param width Panel width(0 to 12)
	 * @param elements Number of elements
	 */
	public NamedPanel(int width, int elements) {
		super(width, elements);
	}

	/**
	 * @param elements Number of elements
	 * @param widgets Default widgets
	 */
	public NamedPanel(int elements, Widget... widgets) {
		super(elements, widgets);
	}

	/**
	 * Creates new panel with default 6 width and one widget
	 * @param widget Widget to store in this panel
	 */
	public NamedPanel(Widget widget) {
		this(1, widget);
	}

	/**
	 * @param width Panel width(0 to 12)
	 * @param elements Number of elements
	 * @param elements Default widgets
	 */
	public NamedPanel(int width, int elements, Widget... widgets) {
		super(width, elements, widgets);
	}

	/**
	 * Creates new panel with default 6 width
	 * @param elements Number of elements
	 * @param type Type of the panel
	 */
	public NamedPanel(int elements, Type type) {
		super(elements);
		this.type = type;
	}

	/**
	 * Creates new panel with default 4 width
	 * @param width Panel width(0 to 12)
	 * @param elements Number of elements
	 * @param type Type of the panel
	 */
	public NamedPanel(int width, int elements, Type type) {
		super(width, elements);
		this.type = type;
	}

	/**
	 * @param elements Number of elements
	 * @param type Type of the panel
	 * @param widgets Default widgets
	 */
	public NamedPanel(int elements, Type type, Widget... widgets) {
		super(elements, widgets);
		this.type = type;
	}

	/**
	 * Creates new panel with default 6 width and one widget
	 * @param widget Widget to store in this panel
	 * @param type Type of the panel
	 */
	public NamedPanel(Widget widget, Type type) {
		this(1, widget);
		this.type = type;
	}

	/**
	 * @param width Panel width(0 to 12)
	 * @param elements Number of elements
	 * @param elements Default widgets
	 * @param type Type of the panel
	 */
	public NamedPanel(int width, int elements, Type type, Widget... widgets) {
		super(width, elements, widgets);
		this.type = type;
	}

	/**
	 * Creates new panel with default 6 width
	 * @param elements Number of elements
	 * @param name Initial name / label
	 */
	public NamedPanel(int elements, String name) {
		super(elements);
		this.name = name;
	}

	/**
	 * Creates new panel with default 4 width
	 * @param width Panel width(0 to 12)
	 * @param elements Number of elements
	 * @param name Initial name / label
	 */
	public NamedPanel(int width, int elements, String name) {
		super(width, elements);
		this.name = name;
	}

	/**
	 * @param elements Number of elements
	 * @param name Initial name / label
	 * @param widgets Default widgets
	 */
	public NamedPanel(int elements, String name, Widget... widgets) {
		super(elements, widgets);
		this.name = name;
	}

	/**
	 * Creates new panel with default 6 width and one widget
	 * @param widget Widget to store in this panel
	 * @param name Initial name / label
	 */
	public NamedPanel(Widget widget, String name) {
		this(1, widget);
		this.name = name;
	}

	/**
	 * @param width Panel width(0 to 12)
	 * @param elements Number of elements
	 * @param name Initial name / label
	 * @param elements Default widgets
	 */
	public NamedPanel(int width, int elements, String name, Widget... widgets) {
		super(width, elements, widgets);
		this.name = name;
	}

	/**
	 * Creates new panel with default 6 width
	 * @param elements Number of elements
	 * @param name Initial name / label
	 * @param type Type of the panel
	 */
	public NamedPanel(int elements, String name, Type type) {
		super(elements);
		this.name = name;
		this.type = type;
	}

	/**
	 * Creates new panel with default 4 width
	 * @param width Panel width(0 to 12)
	 * @param elements Number of elements
	 * @param name Initial name / label
	 * @param type Type of the panel
	 */
	public NamedPanel(int width, int elements, String name, Type type) {
		super(width, elements);
		this.name = name;
		this.type = type;
	}

	/**
	 * @param elements Number of elements
	 * @param name Initial name / label
	 * @param type Type of the panel
	 * @param widgets Default widgets
	 */
	public NamedPanel(int elements, String name, Type type, Widget... widgets) {
		super(elements, widgets);
		this.name = name;
		this.type = type;
	}

	/**
	 * Creates new panel with default 6 width and one widget
	 * @param widget Widget to store in this panel
	 * @param name Initial name / label
	 * @param type Type of the panel
	 */
	public NamedPanel(Widget widget, String name, Type type) {
		this(1, widget);
		this.name = name;
		this.type = type;
	}

	/**
	 * @param width Panel width(0 to 12)
	 * @param elements Number of elements
	 * @param name Initial name / label
	 * @param type Type of the panel
	 * @param elements Default widgets
	 */
	public NamedPanel(int width, int elements, String name, Type type, Widget... widgets) {
		super(width, elements, widgets);
		this.name = name;
		this.type = type;
	}

	/**
	 * @param name Name to set
	 * @return This widget
	 */
	public NamedPanel setName(String name) {
		this.name = name;
		this.sendElement();
		return this;
	}

	/**
	 * @param type Type to set
	 * @return This widget
	 */
	public NamedPanel setType(Type type) {
		this.type = type;
		return this;
	}

	/**
	 * @return INTERNAL widget name
	 */
	@Override
	public String getName() {
		return "NamedPanel";
	}

	@Override
	public String getData() {
		String data = "";
		for (int i = 0; i < content.length; ++i) {
			if (i > 0) data += ",";
			data += "\"" + String.valueOf(content[i] != null ? content[i].getID() : -1) + "\"";
		}
	return new StringBuilder().append("{\"type\":\"").append(type.name)
			.append("\",\"width\":").append(width)
			.append(",\"name\":").append(Json.escapeString(name))
			.append(",\"content\":[").append(data)
			.append("]}").toString();
	}
}

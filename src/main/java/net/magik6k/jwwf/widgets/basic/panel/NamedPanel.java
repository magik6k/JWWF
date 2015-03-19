package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Type;
import net.magik6k.jwwf.util.Json;

/**
 * Created by magik6k on 3/19/15.
 */
public class NamedPanel extends Widget {
	private String name = "Unnamed";
	private Type type = Type.DEFAULT;
	protected Widget content;

	/**
	 * Creates new panel with default 6 width and one widget
	 * @param widget Widget to store in this panel
	 */
	public NamedPanel(Widget widget) {
		attach(widget);
		content = widget;
	}
	/**
	 * Creates new panel with default 6 width and one widget
	 * @param widget Widget to store in this panel
	 * @param type Type of the panel
	 */
	public NamedPanel(Widget widget, Type type) {
		this(widget);
		this.type = type;
	}

	/**
	 * Creates new panel with default 6 width and one widget
	 * @param widget Widget to store in this panel
	 * @param name Initial name / label
	 */
	public NamedPanel(Widget widget, String name) {
		this(widget);
		this.name = name;
	}

	/**
	 * Creates new panel with default 6 width and one widget
	 * @param widget Widget to store in this panel
	 * @param name Initial name / label
	 * @param type Type of the panel
	 */
	public NamedPanel(Widget widget, String name, Type type) {
		this(widget);
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
		return new StringBuilder().append("{\"type\":\"").append(type.name)
			.append("\",\"name\":").append(Json.escapeString(name))
			.append(",\"content\":").append(String.valueOf(content != null ? content.getID() : -1))
			.append("}").toString();
	}
}

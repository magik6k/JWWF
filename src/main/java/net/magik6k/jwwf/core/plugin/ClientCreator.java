package net.magik6k.jwwf.core.plugin;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.example.plugin.ExamplePlugin;

public interface ClientCreator {

	/**
	 * Appends some code before end of client HTML head
	 *
	 * @param code Code to append
	 */
	public void appendHead(String code);

	/**
	 * <p>Registers new widget in client creator. Parameters create and update should
	 * contain two javascript functions bodies:
	 * </p>
	 * <ul>
	 * <li>create(data): {element, data} - data argument is object from java widget method {@link Widget#getData() getData}
	 * It must return object with two fields - element containing DOM element created by this widget,
	 * and data object that can be reused later. The function gets called when new widget is created</li>
	 * <li>update(widget, data): void - widget is object containing element and data fields from create methods,
	 * second argumnet is object from java widget method {@link Widget#getData() getData}.
	 * The function is caled when update to a widget arrives from java side</li>
	 * </ul>
	 *
	 * @param name   Name of widget, should not contain white characters, should fit in 7 bit ascii space and be json-safe string
	 * @param create Body of create function. Javascript code, 'data' argument is provided
	 * @param upate  Body of upate function. Javascript code, 'widget' and 'data' arguments are provided
	 * @see Widget
	 * @see ExamplePlugin
	 */
	public void registerWidget(String name, String create, String upate);
}

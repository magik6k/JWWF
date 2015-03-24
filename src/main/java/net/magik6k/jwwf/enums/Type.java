package net.magik6k.jwwf.enums;

import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * Types/statuses of an element
 */
public enum Type {
	/**
	 * The default element type
	 */
	DEFAULT("default"),

	/**
	 * Elements marked with this type are seen as primary.
	 * Usually blue.
	 */
	PRIMARY("primary"),

	/**
	 * Elements marked with this type are seen
	 * as 'positive status' of something.
	 * Usually green
	 */
	SUCCESS("success"),

	/**
	 * Elements marked with this type are seen
	 * as informative. Usually blue.
	 */
	INFO("info"),

	/**
	 * Elements marked with this type are seen
	 * as 'potential danger'. Usually yellow.
	 */
	WARNING("warning"),

	/**
	 * Elements marked with this type are seen
	 * as 'danger'. Usually red.
	 */
	DANGER("danger");

	public final String name;

	Type(String name) {
		this.name = name;
	}
}

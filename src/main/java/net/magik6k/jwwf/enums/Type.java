package net.magik6k.jwwf.enums;

import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * Created by magik6k on 3/16/15.
 */
public enum Type {
	DEFAULT("default"),
	PRIMARY("primary"),
	SUCCESS("success"),
	INFO("info"),
	WARNING("warning"),
	DANGER("danger");

	public final String name;

	Type(String name) {
		this.name = name;
	}
}

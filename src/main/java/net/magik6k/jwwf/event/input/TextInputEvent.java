package net.magik6k.jwwf.event.input;

import net.magik6k.jwwf.core.User;

public class TextInputEvent extends BasicInputEvent {

	private final String text;

	public TextInputEvent(User user, Object payload, String text) {
		super(user, payload);
		this.text = text;
	}

	/**
	 * @return Text in widget
	 */
	public String getText() {
		return text;
	}

}

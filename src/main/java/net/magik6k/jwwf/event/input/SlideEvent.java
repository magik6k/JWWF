package net.magik6k.jwwf.event.input;

import net.magik6k.jwwf.core.User;

public class SlideEvent extends BasicInputEvent{
	private final double position;
	
	public SlideEvent(User user, Object payload, double position) {
		super(user, payload);
		this.position = position;
	}
	
	/**
	 * @return Returns new position of slider
	 */
	public double getPosition() {
		return position;
	}
}

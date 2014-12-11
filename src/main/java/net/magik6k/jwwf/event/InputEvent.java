package net.magik6k.jwwf.event;

public interface InputEvent extends JwwfEvent {
	
	/**
	 * @return User-definied data set in input widget using setPayload
	 */
	public Object getPayload();
}

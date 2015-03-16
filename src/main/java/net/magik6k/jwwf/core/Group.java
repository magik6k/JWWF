package net.magik6k.jwwf.core;

public class Group extends Attachable {
	private int id;

	public Group() {
		id = -1;
	}

	public final int getID() {
		if (id < 0) throw new IllegalStateException("Cannot get ID of element without user");
		return id;
	}

	protected final void addTo(User owner) throws IllegalStateException {
		if (id < 0)
			id = owner.nextElementId();

	}
}

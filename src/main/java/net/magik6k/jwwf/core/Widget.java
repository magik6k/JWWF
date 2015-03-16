package net.magik6k.jwwf.core;

import net.magik6k.jwwf.core.action.Actions;
import org.eclipse.jetty.websocket.WebSocket.Connection;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public abstract class Widget extends Attachable {

	private Connection connection;
	private int id;
	private Actions action;
	private Queue<Attachable> waitingForUser;

	/**
	 * <p>This variable holds refference to user associated with this widget.
	 * Initially it's null, and is set when widget is attached to another.</p>
	 * <p>DO NOT MANUALLY SET THIS VARIABLE UNLESS YOU RALLY KNOW WHAT
	 * YOU ARE DOING.</p>
	 * <p>Setting this variable may cause things to fail badly.</p>
	 */
	protected User user;

	protected Widget(int id, Connection connection) {
		this.id = id;
		this.connection = connection;
	}

	public Widget(Actions actionType) {
		connection = null;
		id = -1;
		action = actionType;
	}

	public Widget() {
		connection = null;
		id = -1;
	}

	/**
	 * Used to get internal widget name
	 *
	 * @return Internal name of this widget, Usually name of widget class
	 */
	public abstract String getName();

	/**
	 * @return Data to send to client side
	 */
	public abstract String getData();

	public final int getID() {
		if (id < 0) throw new IllegalStateException("Cannot get ID of element without user");
		return id;
	}

	private final String getElement() {
		return "{\"id\":" + String.valueOf(id) + ",\"type\":\"" + getName() + "\", \"data\":" + getData() + "}";
	}

	/**
	 * Used to indicate that this instance of widget requires sending an update
	 * To client side. Calling this method will trigger {@link #getData()} method.
	 */
	protected final void sendElement() {
		if (connection == null) return;
		try {
			connection.sendMessage(getElement());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected final void addTo(User owner) throws IllegalStateException {
		if (connection != null && owner.getConnection() != connection)
			throw new IllegalStateException("Instance of widget can exist only for one user");

		if (id < 0)
			id = owner.nextElementId();
		connection = owner.getConnection();

		if (action != null)
			owner.setActionHandler(id, this);

		if (user == null) {
			user = owner;
			onAttach();
		}

		if (waitingForUser != null) {
			Attachable w;
			while ((w = waitingForUser.poll()) != null) {
				w.addTo(owner);
			}
			waitingForUser = null;
		}

		sendElement();
	}

	/**
	 * Used to declare that instance of widget is 'held' by this widget.
	 * If this widget is container it must invoke this method for all widgets it stores
	 *
	 * @param widget Widget that is stored in this widget
	 */
	protected final void attach(Attachable widget) {
		if (user != null) {
			widget.addTo(user);
		} else {
			if (waitingForUser == null) waitingForUser = new LinkedList<Attachable>();
			waitingForUser.add(widget);
		}
	}

	/**
	 * This method is triggered when data arrives from client side
	 *
	 * @param data Data that arrived from client side
	 * @throws Exception An exception that can be thrown in case something went wrong
	 */
	protected void handleData(String data) throws Exception {
	}

	/**
	 * This method is called when this widget is assigned to user for the first time.
	 * Note that if you are overriding widget that already extends {@link Widget} class,
	 * you should call super method.
	 */
	protected void onAttach() {
	}

	;
}

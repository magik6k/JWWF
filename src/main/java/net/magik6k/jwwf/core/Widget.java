package net.magik6k.jwwf.core;

import java.util.LinkedList;
import java.util.Queue;



public abstract class Widget extends Attachable{
	
	private Connection connection;
	private int id;
	private Actions action;
	private User user;
	private Queue<Attachable> waitingForUser;
	
	/**
	 * Internal use only
	 * @param id
	 * @param connection
	 */
	protected Widget(int id, Connection connection) {
		this.id = id;
		this.connection = connection;
	}
	
	public Widget(Actions actionType){
		connection = null;
		id = -1;
		action = actionType;
	}
	
	public Widget(){
		connection = null;
		id = -1;
	}
	
	public abstract String getName();
	public abstract String getData();
	
	public final int getID(){
		if(id < 0)throw new IllegalStateException("Cannot get ID of element without user");
		return id;
	}
	
	private final String getElement(){
		return "{\"id\":"+String.valueOf(id)+",\"type\":\""+getName()+"\", \"data\":"+getData()+"}";
	}
	
	protected final void sendElement(){
		if(connection == null)return;
		connection.connection.send(getElement());
	}
	
	protected final void addTo(User owner)throws IllegalStateException {
		if(connection!=null&&owner.getConnection() == connection)
			throw new IllegalStateException("Instance of widget can exist only for one user");
		
		if(id < 0)
			id = owner.nextElementId();
		connection = owner.getConnection();		
		
		if(action != null)
			owner.setActionHandler(id, this);
		
		user = owner;
		
		if(waitingForUser != null){
			Attachable w;
			while((w = waitingForUser.poll())!=null){
				w.addTo(owner);
			}
			waitingForUser = null;
		}
		
		sendElement();
	}	
	
	/**
	 * If the widget is container it must invoke this metkod for all widgets it stores
	 * @param widget Widget that is stored in this widget
	 */
	protected final void attach(Attachable widget){
		if(user != null){
			widget.addTo(user);
		}else{
			if(waitingForUser == null)waitingForUser = new LinkedList<Attachable>();
			waitingForUser.add(widget);
		}
	}
	
	protected void handleData(String data){}
}

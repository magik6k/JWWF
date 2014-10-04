package net.magik6k.jwwf.core;



public abstract class Widget extends DataHandler{
	
	private final Connection connection;
	private int id;
	
	/**
	 * Internal use only
	 * @param id
	 * @param connection
	 */
	protected Widget(int id, Connection connection) {
		this.id = id;
		this.connection = connection;
	}
	
	public abstract String getName();
	public abstract String getData();
	
	public Widget(User creator){
		connection = creator.getConnection();
		id = creator.nextElementId();
	}
	
	public Widget(User creator, Actions actionType){
		connection = creator.getConnection();
		id = creator.nextElementId();
		creator.setActionHandler(id, this);
	}
	
	public int getID(){
		return id;
	}
	
	private String getElement(){
		return "{\"id\":"+String.valueOf(id)+",\"type\":\""+getName()+"\", \"data\":"+getData()+"}";
	}
	
	protected void sendElement(){
		connection.connection.send(getElement());
	}
	protected void handleData(String data){}
}

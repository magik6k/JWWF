package net.magik6k.jwwf;


public abstract class Widget {
	
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
	public int getID(){
		return id;
	}
	
	private String getElement(){
		return "{\"id\":"+String.valueOf(id)+",\"type\":\""+getName()+"\", \"data\":"+getData()+"}";
	}
	
	protected void sendElement(){
		connection.connection.send(getElement());
	}
	
}

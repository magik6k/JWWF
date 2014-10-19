package net.magik6k.jwwf.handlers;

/**
 * Logger used inside the server, allowing developer
 * to create own output for server logs
 */
public abstract class LogHandler {
	
	private boolean debug = false;
	
	public void enableDebug(boolean debug){
		this.debug = debug;
	}
	
	public void debug(String source, String message){
		if(debug)msg("[debug: "+source+"] "+message);
	}
	
	public void info(String source, String message){
		msg("[info: "+source+"] "+message);
	}
	
	/**
	 * Logs a message
	 * @param message Message to display
	 */
	protected abstract void msg(String message);
}

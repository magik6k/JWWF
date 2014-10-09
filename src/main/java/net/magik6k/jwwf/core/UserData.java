package net.magik6k.jwwf.core;

import java.util.HashMap;
import java.util.LinkedList;

import net.magik6k.jwwf.handlers.UserDataHandler;
import net.magik6k.jwwf.util.Json;

/**
 * Utility mechanism that allows app creator to save user data on his/her
 * computer. Data is stored using WebStorage, allowing storage of up to
 * 5MiB by default.
 */
public class UserData {
	private HashMap<String,String> cache = new HashMap<String,String>();
	private HashMap<String,LinkedList<UserDataHandler>> waitingHandlers = 
			new HashMap<String,LinkedList<UserDataHandler>>();
	private Connection connection;
	
	public UserData(User user){
		connection = user.getConnection();
	}
	
	/**
	 * Gets userData string. if data exists in cache the callback is fired
	 * immediately, if not async request is sent to user. If user don't have
	 * requested data, the callback won't be triggered
	 */
	public void get(String key, UserDataHandler handler){
		if(cache.containsKey(key)){
			handler.data(key, cache.get(key));
			return;
		}
		connection.connection.send("{\"id\":-1,\"type\":\"storageGet\",\"key\":\""
				+Json.escapeString(key)+"\"}");
		if(waitingHandlers.containsKey(key)){
			waitingHandlers.get(key).push(handler);
		}else{
			LinkedList<UserDataHandler> ll = new LinkedList<UserDataHandler>();
			ll.push(handler);
			waitingHandlers.put(key, ll);
		}
	}
	
	/**
	 * Gets userData from cache, if userData is not cached(has not requested,
	 * or set earlier) null will be returned.
	 */
	public String getCached(String key){
		return cache.get(key);
	}
	
	/**
	 * Sets userData for user, data is set in cache and sent to user
	 */
	public void set(String key, String value){
		cache.put(key, value);
		connection.connection.send("{\"id\":-1,\"type\":\"storageSet\",\"key\":\""
				+Json.escapeString(key)+"\",\"value\":\""+Json.escapeString(value)+"\"}");
	}
	
	protected void recvData(String key, String value) {
		cache.put(key, value);
		if(waitingHandlers.containsKey(key)){
			LinkedList<UserDataHandler> tempHandlers = waitingHandlers.remove(key);
			for(UserDataHandler dataHandler : tempHandlers){
				dataHandler.data(key, value);
			}
		}
	}
}

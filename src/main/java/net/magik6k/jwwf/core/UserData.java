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
	private User user;
	
	public UserData(User user){
		this.user = user;
	}
	
	/**
	 * Gets userData string. if data exists in cache the callback is fired
	 * immediately, if not async request is sent to user. If user don't have
	 * requested data, empty string will arrive
	 * @param key Requested key
	 * @param handler Handler to be invoked when data arrives
	 */
	public void get(String key, UserDataHandler handler){
		if(cache.containsKey(key)){
			try {
				handler.data(key, cache.get(key));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}
		
		user.sendGlobal("JWWF-storageGet", "{\"key\":"+Json.escapeString(key)+"}");

		if(waitingHandlers.containsKey(key)){
			waitingHandlers.get(key).push(handler);
		}else{
			LinkedList<UserDataHandler> ll = new LinkedList<UserDataHandler>();
			ll.push(handler);
			waitingHandlers.put(key, ll);
		}
	}
	
	/**
	 * Gets userData from cache, if userData is not cached(i.e. has not been requested,
	 * or set earlier) null will be returned.
	 * @param key Requested key
	 * @return Requested value or null if not in cache
	 */
	public String getCached(String key){
		return cache.get(key);
	}
	
	/**
	 * Sets userData for user, data is set in cache and sent to user
	 * @param key Name of value
	 * @param value Data to be set
	 */
	public void set(String key, String value){
		cache.put(key, value);
		user.sendGlobal("JWWF-storageSet", "{\"key\":"+Json.escapeString(key)+",\"value\":"+Json.escapeString(value)+"}");
	}
	
	protected void recvData(String key, String value) {
		cache.put(key, value);
		if(waitingHandlers.containsKey(key)){
			LinkedList<UserDataHandler> tempHandlers = waitingHandlers.remove(key);
			for(UserDataHandler dataHandler : tempHandlers){
				try {
					dataHandler.data(key, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

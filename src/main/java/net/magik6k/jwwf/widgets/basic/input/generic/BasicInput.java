package net.magik6k.jwwf.widgets.basic.input.generic;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.core.action.Actions;
import net.magik6k.jwwf.event.InputEvent;

import com.google.common.eventbus.EventBus;

public abstract class BasicInput extends Widget{
	private EventBus eventBus;
	private Object payload;
	protected abstract void handleData(String data);
	
	protected BasicInput(){super();}
	protected BasicInput(Actions action){super(action);}
	
	/**
	 * Input widget can send events to Guava {@link EventBus},
	 * @param eventBus EventBus that will consume input events
	 * @return This instance for chaining
	 */
	public BasicInput setEventBus(EventBus eventBus){
		this.eventBus = eventBus;
		return this;
	}
	
	/**
	 * Sets user-defined payload. Useful when using along with Guava {@link EventBus}
	 * @param payload Any object to be set as userdata
	 * @return This instance for chaining
	 */
	public BasicInput setPayload(Object payload){
		this.payload = payload;
		return this;
	}
	
	/**
	 * @return Payload data definied in setPayload
	 */
	public Object getPayload() {
		return payload;
	}
	
	protected void sendEvent(InputEvent event) {
		if(eventBus != null){
			eventBus.post(event);
		}
	}
}

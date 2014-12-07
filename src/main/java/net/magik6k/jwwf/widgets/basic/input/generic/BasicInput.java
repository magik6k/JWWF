package net.magik6k.jwwf.widgets.basic.input.generic;

import com.google.common.eventbus.EventBus;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.event.InputEvent;

public abstract class BasicInput extends Widget{
	private EventBus eventBus;
	protected abstract void handleData(String data);
	
	/**
	 * Input widget can send events to Guava {@link EventBus},
	 * @param eventBus EventBus that will consume input events
	 */
	public void setEventBus(EventBus eventBus){
		this.eventBus = eventBus;
	}
	
	protected void sendEvent(InputEvent event) {
		if(eventBus != null)
			eventBus.post(event);
	}
	
}

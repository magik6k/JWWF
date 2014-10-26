package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Actions;
import net.magik6k.jwwf.handlers.SlideHandler;

public class Slider extends Widget{

	private double minValue = 0;
	private double maxValue = 100;
	private double value = 0.5;
	private SlideHandler handler;
	
	/**
	 * Creates new slider input, with default value range from 0 to 1
	 * @param value Default value
	 */
	public Slider(double value) {
		super(Actions.SLIDE);
		this.value = value;
	}
	
	/**
	 * Creates new slider input, with default value range from 0 to 1
	 * @param handler Handler for user input
	 */
	public Slider(SlideHandler handler) {
		super(Actions.SLIDE);
		this.handler = handler;
	}
	
	/**
	 * Creates new slider input, with default value range from 0 to 1
	 * @param handler Handler for user input
	 * @param value Default value
	 */
	public Slider(SlideHandler handler, double value) {
		super(Actions.SLIDE);
		this.handler = handler;
		this.value = value;
	}
	
	/**
	 * Creates new slider input
	 * @param minValue Min slider value
	 * @param maxValue Max slider value
	 */
	public Slider(double minValue, double maxValue) {
		super(Actions.SLIDE);
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	
	/**
	 * Creates new slider input
	 * @param handler Handler for user input
	 * @param minValue Min slider value
	 * @param maxValue Max slider value
	 */
	public Slider(SlideHandler handler, double minValue, double maxValue) {
		super(Actions.SLIDE);
		this.handler = handler;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	
	/**
	 * Creates new slider input
	 * @param handler Handler for user input
	 * @param value Default value
	 * @param minValue Min slider value
	 * @param maxValue Max slider value
	 */
	public Slider(SlideHandler handler, double value, double minValue, double maxValue) {
		super(Actions.SLIDE);
		this.handler = handler;
		this.minValue = minValue;
		this.maxValue = maxValue;
	}
	
	/**
	 * Sets range of value that user can pick on slider
	 * @param minValue Min value
	 * @param maxValue Max value
	 * @return This instance for chaining
	 */
	public Slider setValueRange(double minValue, double maxValue) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.sendElement();
		return this;
	}
	
	/**
	 * Sets minimal value that user can pick on slider
	 * @param minValue Min value
	 * @return This instance for chaining
	 */
	public Slider setMinValue(double minValue){
		this.minValue = minValue;
		this.sendElement();
		return this;
	}
	
	/**
	 * Sets minimal value that user can pick on slider
	 * @param maxValue Max value
	 * @return This instance for chaining
	 */
	public Slider setMaxValue(double maxValue){
		this.maxValue = maxValue;
		this.sendElement();
		return this;
	}
	
	/**
	 * Sets slider value
	 * @param value New value
	 * @return This instance for chaining
	 */
	public Slider setValue(double value){
		this.value = value;
		this.sendElement();
		return this;
	}
	
	/**
	 * Returns value set on slider
	 * @return Slider value
	 */
	public double getValue(){
		return value;
	}
	
	@Override
	public String getName() {
		return "Slider";
	}

	@Override
	public String getData() {
		
		return "{\"value\":"+String.valueOf(value)+", \"min\":"+String.valueOf(minValue)+",\"max\":"+String.valueOf(maxValue)+"}";
	}
	
	/**
	 * Internal use only
	 */
	public void handleData(String data){
		value = Double.valueOf(data);
		if(handler != null)
			handler.slide(value);
	}
	
}

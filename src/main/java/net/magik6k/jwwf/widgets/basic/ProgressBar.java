package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Widget;

/**
 * Simple progress indicator
 */
public class ProgressBar extends Widget{

	private double progress = 0;
	private int width = 256;
	
	/**
	 * Creates new ProgressBar with default width of 256px
	 */
	public ProgressBar() {
		super();
	}
	
	/**
	 * Creates new ProgressBar
	 * @param width Width of created ProgressBar
	 */
	public ProgressBar(int width) {
		super();
		this.width = width;
	}
	
	/**
	 * Creates new ProgressBar
	 * @param width Width of created ProgressBar
	 * @param progress Initial progress, from 0 to 1
	 */
	public ProgressBar(int width, double progress) {
		super();
		this.width = width;
		this.progress = progress;
	}
	
	/**
	 * Sets progress
	 * @param progress New Progress, from 0 to 1
	 * @return This instance for chaining
	 */
	public ProgressBar setProgress(double progress){
		this.progress = progress;
		sendElement();
		return this;
	}
	
	/**
	 * Sets new width
	 * @param width New width
	 * @return This instance for chaining
	 */
	public ProgressBar setWidth(int width){
		this.width = width;
		sendElement();
		return this;
	}
	
	@Override
	public String getName() {
		return "ProgressBar";
	}

	@Override
	public String getData() {
		return "{\"progress\":"+String.valueOf(progress*100)+",\"width\":"+String.valueOf(width)+"}";
	}

}

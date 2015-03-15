package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Widget;

/**
 * Simple progress indicator
 */
public class ProgressBar extends Widget{

	private double progress = 0;
	
	/**
	 * Creates new ProgressBar with default width of 256px
	 */
	public ProgressBar() {
		super();
	}

	/**
	 * Creates new ProgressBar
	 * @param progress Initial progress, from 0 to 1
	 */
	public ProgressBar(double progress) {
		super();
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
	
	@Override
	public String getName() {
		return "ProgressBar";
	}

	@Override
	public String getData() {
		return new StringBuilder().append("{\"progress\":").append(String.valueOf(progress * 100)).append("}").toString();
	}

}

package net.magik6k.jwwf.widgets.basic;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Type;

/**
 * Simple progress indicator
 */
public class ProgressBar extends Widget {
	private Type type = Type.DEFAULT;
	private double progress = 0;

	/**
	 * Creates new ProgressBar with default width of 256px
	 *
	 * @param type Bar type
	 */
	public ProgressBar(Type type) {
		super();
		this.type = type;
	}

	/**
	 * Creates new ProgressBar
	 *
	 * @param type Bar type
	 * @param progress Initial progress, from 0 to 1
	 */
	public ProgressBar(Type type, double progress) {
		super();
		this.type = type;
		this.progress = progress;
	}

	/**
	 * Creates new ProgressBar with default width of 256px
	 */
	public ProgressBar() {
		super();
	}

	/**
	 * Creates new ProgressBar
	 *
	 * @param progress Initial progress, from 0 to 1
	 */
	public ProgressBar(double progress) {
		super();
		this.progress = progress;
	}

	/**
	 * Sets progress
	 *
	 * @param progress New Progress, from 0 to 1
	 * @return This instance for chaining
	 */
	public ProgressBar setProgress(double progress) {
		this.progress = progress;
		sendElement();
		return this;
	}

	/**
	 * Sets type
	 *
	 * @param type Type to set
	 * @return This progress bar
	 */
	public ProgressBar setType(Type type) {
		this.type = type;
		this.sendElement();
		return this;
	}

	@Override
	public String getName() {
		return "ProgressBar";
	}

	@Override
	public String getData() {
		return new StringBuilder().append("{\"progress\":").append(String.valueOf(progress * 100))
				.append(",\"type\":\"").append(type.name).append("\"}").toString();
	}

}

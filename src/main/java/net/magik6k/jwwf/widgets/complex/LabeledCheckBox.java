package net.magik6k.jwwf.widgets.complex;

import net.magik6k.jwwf.handlers.CheckHandler;
import net.magik6k.jwwf.widgets.basic.TextLabel;
import net.magik6k.jwwf.widgets.basic.input.CheckBox;
import net.magik6k.jwwf.widgets.basic.panel.Panel;

/**
 * {@link CheckBox} with {@link TextLabel}
 */
public class LabeledCheckBox extends Panel {

	public final CheckBox checkBox;
	public final TextLabel label;
	
	public LabeledCheckBox(String label, CheckHandler checkHandler) {
		super(2);
		
		this.label = new TextLabel(label);
		checkBox = new CheckBox(checkHandler);
		
		put(this.label, 0);
		put(checkBox, 1);
	}

	public LabeledCheckBox(String label) {
		super(2);
		
		this.label = new TextLabel(label);
		checkBox = new CheckBox();
		
		put(this.label, 0);
		put(checkBox, 1);
	}
	
	
	public LabeledCheckBox setLabel(String label) {
		this.label.setText(label);
		return this;
	}
	
	public boolean getState() {
		return checkBox.getState();
	}
	
}

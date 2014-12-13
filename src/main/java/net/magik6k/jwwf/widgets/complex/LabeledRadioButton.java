package net.magik6k.jwwf.widgets.complex;

import net.magik6k.jwwf.util.RadioGroup;
import net.magik6k.jwwf.widgets.basic.TextLabel;
import net.magik6k.jwwf.widgets.basic.input.RadioButton;
import net.magik6k.jwwf.widgets.basic.panel.HorizontalPanel;

/**
 * {@link RadioButton} with {@link TextLabel}
 */
public class LabeledRadioButton extends HorizontalPanel{
	public final RadioButton radioButton;
	public final TextLabel label;
	
	public LabeledRadioButton(String label, RadioGroup radioGroup) {
		super(2);
		
		this.label = new TextLabel(label);
		radioButton = new RadioButton(radioGroup);
		
		put(this.label, 0);
		put(radioButton, 1);
	}
}

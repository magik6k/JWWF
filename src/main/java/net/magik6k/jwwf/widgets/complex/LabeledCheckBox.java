package net.magik6k.jwwf.widgets.complex;

import net.magik6k.jwwf.handlers.CheckHandler;
import net.magik6k.jwwf.widgets.basic.TextLabel;
import net.magik6k.jwwf.widgets.basic.input.CheckBox;
import net.magik6k.jwwf.widgets.basic.panel.HorizontalPanel;

public class LabeledCheckBox extends HorizontalPanel{

	public final CheckBox checkBox;
	public final TextLabel label;
	
	public LabeledCheckBox(String label, CheckHandler checkHandler) {
		super(2);
		
		this.label = new TextLabel(label);
		checkBox = new CheckBox(checkHandler);
		
		put(this.label, 1);
		put(checkBox, 2);
	}

}

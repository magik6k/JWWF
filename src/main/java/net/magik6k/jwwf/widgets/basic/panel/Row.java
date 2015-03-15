package net.magik6k.jwwf.widgets.basic.panel;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.widgets.basic.panel.generic.LinePanel;

/**
 * Created by magik6k on 3/15/15.
 */
public class Row extends LinePanel {
    private Widget[] content;

    /**
     * @param elements Number of elements
     */
    public Row(int elements) {
        super();
        content = new Widget[elements];
        for(int i = 0; i < content.length; ++i)content[i] = null;
        this.sendElement();
    }

    /**
     * @param elements Number of elements
     * @param elements Default widgets
     */
    public Row(int elements, Widget... widgets) {
        super();
        content = new Widget[elements];

        for(int i = 0; i < content.length; ++i)	{
            if(i < widgets.length && widgets[i] != null){
                attach(widgets[i]);
                content[i] = widgets[i];
            }
        }

        this.sendElement();
    }

    @Override
    public LinePanel put(Widget widget, int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= content.length)throw new IndexOutOfBoundsException();
        attach(widget);
        content[index] = widget;
        this.sendElement();
        return this;
    }

    @Override
    public int put(Widget widget) throws IndexOutOfBoundsException {
        attach(widget);
        for(int i = 0; i < content.length; ++i)
            if(content[i] == null){
                content[i] = widget;
                this.sendElement();
                return i;
            }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String getName() {
        return "Row";
    }

    @Override
    public String getData() {
        String data = "";
        for(int i = 0; i < content.length; ++i) {
            if(i > 0)data += ",";
            data += "\"" + String.valueOf(content[i]!=null?content[i].getID():-1) + "\"";
        }
        return new StringBuilder().append("{\"content\":[").append(data).append("]}").toString();
    }
}

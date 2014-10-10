package net.magik6k.jwwf.widgets.basic.input;

import net.magik6k.jwwf.core.Widget;
import net.magik6k.jwwf.enums.Actions;
import net.magik6k.jwwf.handlers.TextHandler;
import net.magik6k.jwwf.util.Json;

/**
 * Scrollable {@link TextInput} with multiple rows
 */
public class TextArea extends Widget{
	private String placeholder;
	private String text = "";
	private boolean sendTextUpdate;
	private TextHandler handler;
	private short cols = 20;
	private short rows = 3;
	
	/**
	 * @param placeholder Hint text
	 * @param defaultText Default text
	 * @param cols Column amount, by default 20
	 * @param rows Row amount, by default 3
	 * @param handler Handler of typed text
	 */
	public TextArea(String placeholder, String defaultText, int cols, int rows, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.handler = handler;
		this.text = defaultText;
		sendTextUpdate = true;
		this.cols = (short)cols;
		this.rows = (short)rows;
		this.sendElement();
	}
	
	/**
	 * @param placeholder Hint text
	 * @param cols Column amount, by default 20
	 * @param rows Row amount, by default 3
	 * @param handler Handler of typed text
	 */
	public TextArea(String placeholder, int cols, int rows, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.handler = handler;
		this.cols = (short)cols;
		this.rows = (short)rows;
		this.sendElement();
	}
	
	/**
	 * @param placeholder Hint text
	 * @param defaultText Default text
	 * @param handler Handler of typed text
	 */
	public TextArea(String placeholder, String defaultText, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.handler = handler;
		this.text = defaultText;
		sendTextUpdate = true;
		this.sendElement();
	}
	
	/**
	 * @param placeholder Hint text
	 * @param handler Handler of typed text
	 */
	public TextArea(String placeholder, TextHandler handler) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.handler = handler;
		this.sendElement();
	}
	
	/**
	 * @param placeholder Hint text
	 * @param cols Column amount, by default 20
	 * @param rows Row amount, by default 3
	 */
	public TextArea(String placeholder, short cols, short rows) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.cols = cols;
		this.rows = rows;
		this.sendElement();
	}
	
	/**
	 * @param placeholder Hint text
	 * @param defaultText Default text
	 */
	public TextArea(String placeholder, String defaultText) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.text = defaultText;
		sendTextUpdate = true;
		this.sendElement();
	}
	
	/**
	 * @param placeholder Hint text
	 */
	public TextArea(String placeholder) {
		super(Actions.TEXT_INPUT);
		this.placeholder = placeholder;
		this.sendElement();
	}
	
	/**
	 * Sets new text
	 * @param text Text to set
	 */
	public void setText(String text){
		this.text = text;
		sendTextUpdate = true;
		this.sendElement();
	}
	
	/**
	 * Sets size of the widget
	 * @param cols Column amount, by default 20
	 * @param rows Row amount, by default 3
	 */
	public void setSize(short cols, short rows){
		this.cols = cols;
		this.rows = rows;
		this.sendElement();
	}
	
	/**
	 * Sets new placeholder text
	 * @param placeholder Placeholder text
	 */
	public void setPlaceholder(String placeholder)
	{
		this.placeholder = placeholder;
		this.sendElement();
	}
	
	/**
	 * Returns entered text
	 * @return Entered text
	 */
	public String getText(){
		return text;
	}
	
	@Override
	public String getName() {
		return "TextArea";
	}

	@Override
	public String getData() {
		if(sendTextUpdate){
			sendTextUpdate = false;
			return "{\"placeholder\":\""+Json.escapeString(placeholder)+"\",\"text\":\""
					+Json.escapeString(text)+"\",\"cols\":"
					+String.valueOf(cols)+",\"rows\":"+String.valueOf(rows)+"}";
		}
		return "{\"placeholder\":\""+Json.escapeString(placeholder)+"\",\"cols\":"
				+String.valueOf(cols)+",\"rows\":"+String.valueOf(rows)+"}";
	}
	
	/**
	 * Internal use only
	 */
	public void handleData(String data){
		if(data == null)return;
		if(handler != null)handler.onType(data);
		text = data;
	}
}

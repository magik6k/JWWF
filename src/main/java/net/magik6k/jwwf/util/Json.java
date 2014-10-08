package net.magik6k.jwwf.util;

public class Json {
	public static String escapeString(String in){
		//TODO, make it faster
		return in.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n","\\n");
	}
}

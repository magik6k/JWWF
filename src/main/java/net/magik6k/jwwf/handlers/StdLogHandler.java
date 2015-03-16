package net.magik6k.jwwf.handlers;

public class StdLogHandler extends LogHandler {
	@Override
	public void msg(String message) {
		System.out.println(message);
	}
}

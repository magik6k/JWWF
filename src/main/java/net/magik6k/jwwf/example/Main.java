package net.magik6k.jwwf.example;

import java.net.UnknownHostException;

import net.magik6k.jwwf.core.JwwfServer;

import org.java_websocket.WebSocketImpl;

public class Main {
	public static void main(String[] args){
		WebSocketImpl.DEBUG = false;
		int port;
		try {
			port = new Integer( args[ 0 ] );
		} catch ( Exception e ) {
			System.out.println( "No port specified. Defaulting to 8888" );
			port = 8888;
		}
		JwwfServer.debugOutput(true);
		try {
			new JwwfServer( ExampleClient.class, port ).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}

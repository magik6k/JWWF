package net.magik6k.jwwf.example;

import net.magik6k.jwwf.core.JwwfServer;

public class Main {
	public static void main(String[] args){
		int port;
		try {
			port = new Integer( args[ 0 ] );
		} catch ( Exception e ) {
			System.out.println( "No port specified. Defaulting to 8888" );
			port = 8888;
		}
		JwwfServer.debugOutput(true);
		JwwfServer server = new JwwfServer(port).bindWebapp(ExampleClient.class).start();
		server.start();
	}
}

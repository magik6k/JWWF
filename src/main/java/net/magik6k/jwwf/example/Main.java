package net.magik6k.jwwf.example;

import net.magik6k.jwwf.core.JettyServer;

public class Main {
	public static void main(String[] args){
		int port;
		try {
			port = new Integer( args[ 0 ] );
		} catch ( Exception e ) {
			System.out.println( "No port specified. Defaulting to 8888" );
			port = 8888;
		}
		JettyServer.debugOutput(true);
		JettyServer server = new JettyServer(port).bind(ExampleClient.class).start();
		server.start();
	}
}

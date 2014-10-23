package net.magik6k.jwwf.core.util;

import java.io.File;
import java.net.MalformedURLException;
import java.util.LinkedList;

import net.magik6k.jwwf.core.JwwfServer;


public class WebClientCreator {
	public static final WebClientCreator instance = new WebClientCreator();
	
	private final String widgetObjectName = "widgets";
	private final String precompiledCode;
	
	private WebClientCreator() {
		JwwfServer.logger.debug("WebClientCreator", "Compiling web client");
		precompiledCode = generate();
	}
	
	public String getClient(){
		return precompiledCode;
	}
	
	private String generate(){
		String widgetCode = generateWidgetCode(getAllWidgets(null));
		String client = ResourceReader.instance.readFile("index.html");
		
		return client.replace("/*?WidgetImpl*/", widgetCode);
	}
	
	private String generateWidgetCode(Iterable<File> files){
		
		StringBuilder codeBuilder = new StringBuilder(16384);
		
		for(File file : files){
			if(file.isFile()){
				try {
					codeBuilder.append(widgetObjectName);
					codeBuilder.append("[\"");
					
					String fileName = file.getName();
					codeBuilder.append(fileName.substring(0, fileName.length()-3));
					
					codeBuilder.append("\"]=");					
					codeBuilder.append(ResourceReader.instance.readFile(file.toURI().toURL()));
										
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		}
		return codeBuilder.toString();
	}
	
	private LinkedList<File> getAllWidgets(File dir){
		File directory = dir != null ? dir : ResourceReader.instance.readDirectory("widgets");
		
		LinkedList<File> res = new LinkedList<File>();
		for(File file: directory.listFiles()){
			if(file.isDirectory()){
				res.addAll(getAllWidgets(file));
			}else{
				res.add(file);
			}
		}
		return res;
	}	
	
	
	
}

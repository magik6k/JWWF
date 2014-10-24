package net.magik6k.jwwf.core.util;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String widgetCode = generateWidgetCode(getAllWidgets("widgets"));
		String client = ResourceReader.instance.readFile("index.html");
		
		return client.replace("/*?WidgetImpl*/", widgetCode);
	}
	
	private String generateWidgetCode(Iterable<String> files){
		
		StringBuilder codeBuilder = new StringBuilder(16384);
		
		for(String file : files){
			codeBuilder.append(widgetObjectName);
			codeBuilder.append("[\"");
			
			codeBuilder.append(file.substring(file.lastIndexOf("/")+1, file.lastIndexOf(".js")));
			
			codeBuilder.append("\"]=");					
			codeBuilder.append(ResourceReader.instance.readFile(file));
		}
		return codeBuilder.toString();
	}
	
	private LinkedList<String> getAllWidgets(String dir){
		List<String> dirent = ResourceReader.instance.readDirectory(dir, ".js");
		LinkedList<String> res = new LinkedList<String>();
		
		for(String f : dirent){
			if(f.endsWith(".js")){
				res.add(f.substring(f.lastIndexOf(ResourceReader.fileBase)+ResourceReader.fileBase.length()));
			}else{
				res.addAll(getAllWidgets(f.substring(f.lastIndexOf(ResourceReader.fileBase)+ResourceReader.fileBase.length())));
			}
		}
		
		return res;
	}	
	
	
	
}

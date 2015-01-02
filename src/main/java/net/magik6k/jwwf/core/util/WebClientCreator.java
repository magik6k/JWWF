package net.magik6k.jwwf.core.util;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.magik6k.jwwf.core.JwwfServer;


public class WebClientCreator {
	public static final WebClientCreator instance = new WebClientCreator();
	
	private final String widgetObjectName = "widgets";
	private String precompiledCode;
	private String apiServer = "ws://\"+document.location.host+\"/__jwwf/socket";	
	
	private WebClientCreator() {
		
		precompiledCode = generate();
	}
	
	public String getClient(){
		return precompiledCode;
	}
	
	public void setApiServer(String apiServer){
		this.apiServer = apiServer;
		precompiledCode = generate();
	}
	
	private String generate(){
		JwwfServer.logger.debug("WebClientCreator", "Compiling web client");
		String widgetCode = generateWidgetCode(getAllWidgets("webclient/widgets"));
		String client = ResourceReader.instance.readFile("webclient/index.html");
		
		client = client.replace("/*?WidgetImpl*/", widgetCode);
		client = doIncludes(client);
		
		client = client.replace("/*?apiServer*/", apiServer);
		
		return client;
	}
	
	private String doIncludes(String inClient){
		String res = inClient;
		
		Pattern pat = Pattern.compile("\\/\\*\\?\\!(.+)\\*\\/");
		Matcher matcher = pat.matcher(inClient);
		
		while (matcher.find()) {
			res = res.replace(matcher.group(0), 
					ResourceReader.instance.readFile("webclient/includes/" + matcher.group(1)));			
		}
		
		return res;
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

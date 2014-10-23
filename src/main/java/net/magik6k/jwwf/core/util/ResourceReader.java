package net.magik6k.jwwf.core.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class ResourceReader {
	public static final String fileBase = "net/magik6k/jwwf/assets/";
	public static final ResourceReader instance = new ResourceReader();
	
	public String readFile(URL url){
		try {
			return Resources.toString(url, Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String readFile(String fileName){
		URL url = Resources.getResource(new StringBuilder(fileBase).append(fileName).toString());
		return readFile(url);
	}
	public File readDirectory(String directoryName){
		URL uri = Resources.getResource(new StringBuilder(fileBase).append(directoryName).toString());
		try {
			return new File(uri.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

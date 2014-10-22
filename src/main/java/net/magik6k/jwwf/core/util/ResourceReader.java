package net.magik6k.jwwf.core.util;

import java.io.IOException;
import java.net.URL;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class ResourceReader {
	public static final String fileBase = "net/magik6k/jwwf/assets/";
	public static final ResourceReader instance = new ResourceReader();
	
	public String readFile(String fileName){
		URL url = Resources.getResource(fileBase + fileName);
		try {
			return Resources.toString(url, Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

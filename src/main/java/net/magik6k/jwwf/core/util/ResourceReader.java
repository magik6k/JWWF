package net.magik6k.jwwf.core.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceReader {
	public static final String fileBase = "net/magik6k/jwwf/assets/";
	public static final ResourceReader instance = new ResourceReader();
	
	public String readFile(String fileName){
		Path uri = null;
		try {
			uri = Paths.get(this.getClass().getResource(fileBase + fileName).toURI());
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		
		try {			
			return new String(Files.readAllBytes(uri), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

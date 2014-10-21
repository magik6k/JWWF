package net.magik6k.jwwf.core.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ResourceReader {
	public static final String fileBase = "net/magik6k/jwwf/assets/";
	public static final ResourceReader instance = new ResourceReader();
	
	public String readFile(String fileName){
		ClassLoader classLoader = this.getClass().getClassLoader();
		
		File file = new File(classLoader
				.getResource(fileBase + fileName)
				.getFile());
		try {
			return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package net.magik6k.jwwf.core.util;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ResourceReader {
	public static final String fileBase = "net/magik6k/jwwf/assets/";

	public static final ResourceReader instance = new ResourceReader();

	public String readFile(URL url) {
		try {
			return Resources.toString(url, Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String readFile(String fileName) {
		URL url = Resources.getResource(new StringBuilder(fileBase).append(fileName).toString());
		return readFile(url);
	}

	public List<String> readDirectory(String directoryName, String jarCheckForExt) {
		final String path = new StringBuilder(fileBase).append(directoryName).toString();
		final File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
		List<String> res = new LinkedList<String>();

		if (jarFile.isFile()) {  // Run with JAR file
			JarFile jar;
			try {
				jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while (entries.hasMoreElements()) {
					final String name = entries.nextElement().getName();
					if (name.startsWith(path) && name.endsWith(jarCheckForExt)) {
						res.add(name);
					}
				}
				jar.close();

			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else {
			final URL url = Resources.getResource(path);
			if (url != null) {
				try {
					final File dir = new File(url.toURI());
					for (File file : dir.listFiles()) {
						res.add(file.getPath());
					}
				} catch (URISyntaxException ex) {
				}
			}
		}
		return res;
	}

}

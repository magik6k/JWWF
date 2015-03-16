package net.magik6k.jwwf.core.util;

import net.magik6k.jwwf.core.JwwfServer;
import net.magik6k.jwwf.core.plugin.ClientCreator;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebClientCreator implements ClientCreator {
	private final String widgetObjectName = "widgets";
	private String precompiledCode;
	private String code;
	private String apiServer = "ws://\"+document.location.host+\"/__jwwf/socket";
	private StringBuilder header = new StringBuilder();
	private LinkedList<Entry<String, String>> specialWidgets = new LinkedList<>();

	public WebClientCreator() {
		precompiledCode = generateStatic();
		code = generate();
	}

	public String getClient() {
		return code;
	}

	public void setApiServer(String apiServer) {
		this.apiServer = apiServer;
		code = generate();
	}

	@Override
	public void appendHead(String what) {
		header.append(what);
		code = generate();
	}

	@Override
	public void registerWidget(final String name, String create, String update) {
		final String code = new StringBuilder().append("{create:function(data, id){").append(create)
				.append("},update:function(widget, data){").append(update).append("}};").toString();

		specialWidgets.add(new Entry<String, String>() {

			@Override
			public String setValue(String value) {
				return null;
			}

			@Override
			public String getValue() {
				return code;
			}

			@Override
			public String getKey() {
				return name;
			}
		});

		precompiledCode = generateStatic();
		this.code = generate();
	}

	private String generate() {
		return precompiledCode
				.replace("<!--?!HEAD-->", header.toString())
				.replace("/*?apiServer*/", apiServer);
	}

	private String generateStatic() {
		JwwfServer.logger.debug("WebClientCreator", "Compiling web client");
		String widgetCode = generateWidgetCode(getAllWidgets("webclient/widgets"));
		String client = ResourceReader.instance.readFile("webclient/index.html");

		client = client.replace("/*?WidgetImpl*/", widgetCode);
		client = doIncludes(client);

		return client;
	}

	private String doIncludes(String inClient) {
		String res = inClient;

		Pattern pat = Pattern.compile("\\/\\*\\?\\!(.+)\\*\\/");
		Matcher matcher = pat.matcher(inClient);

		while (matcher.find()) {
			res = res.replace(matcher.group(0),
					ResourceReader.instance.readFile("webclient/includes/" + matcher.group(1)));
		}

		return res;
	}

	private String generateWidgetCode(Iterable<String> files) {

		StringBuilder codeBuilder = new StringBuilder(16384);

		for (String file : files) {
			codeBuilder.append(widgetObjectName);
			codeBuilder.append("[\"");

			codeBuilder.append(file.substring(file.lastIndexOf("/") + 1, file.lastIndexOf(".js")));

			codeBuilder.append("\"]=");
			codeBuilder.append(ResourceReader.instance.readFile(file));
			codeBuilder.append("\n");
		}

		for (Entry<String, String> widget : specialWidgets) {
			codeBuilder.append(widgetObjectName);
			codeBuilder.append("[\"");
			codeBuilder.append(widget.getKey());
			codeBuilder.append("\"]=");

			codeBuilder.append(widget.getValue());
			codeBuilder.append("\n");
		}
		return codeBuilder.toString();
	}

	private LinkedList<String> getAllWidgets(String dir) {
		List<String> dirent = ResourceReader.instance.readDirectory(dir, ".js");
		LinkedList<String> res = new LinkedList<String>();

		for (String f : dirent) {
			if (f.endsWith(".js")) {
				res.add(f.substring(f.lastIndexOf(ResourceReader.fileBase) + ResourceReader.fileBase.length()));
			} else {
				res.addAll(getAllWidgets(f.substring(f.lastIndexOf(ResourceReader.fileBase) + ResourceReader.fileBase.length())));
			}
		}

		return res;
	}
}

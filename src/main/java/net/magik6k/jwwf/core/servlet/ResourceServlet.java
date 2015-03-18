package net.magik6k.jwwf.core.servlet;

import com.google.common.io.Resources;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

/**
 * Created by magik6k on 3/18/15.
 */
public class ResourceServlet extends HttpServlet {
	private String basePackage;

	@Override
	public void init() throws ServletException {
		this.basePackage = getInitParameter("basePackage");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		URL url = Resources.getResource(new StringBuilder(basePackage).append(request.getPathInfo()).toString());
		byte[] data = Resources.toByteArray(url);
		response.getOutputStream().write(data);

		response.setStatus(HttpServletResponse.SC_OK);
	}
}

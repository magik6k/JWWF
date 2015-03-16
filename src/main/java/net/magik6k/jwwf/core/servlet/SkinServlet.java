package net.magik6k.jwwf.core.servlet;

import net.magik6k.jwwf.core.util.ResourceReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SkinServlet extends HttpServlet {
	private static final long serialVersionUID = -4228685451957270735L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/css");
		response.setStatus(HttpServletResponse.SC_OK);

		if (request.getRequestURL().toString().endsWith(".css"))
			response.getWriter().write(ResourceReader.instance.readFile("skins/default/bootstrap.css"));
		else
			response.getWriter().write(ResourceReader.instance.readFile("skins/default/bootstrap.js"));
	}
}

package net.magik6k.jwwf.core.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.magik6k.jwwf.core.util.WebClientCreator;

public class WebClientServelt extends HttpServlet{

	private static final long serialVersionUID = -4228685451957270735L;
	private final WebClientCreator creator;
	
	public WebClientServelt(WebClientCreator creator){
		this.creator = creator;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        
        response.getWriter().println(creator.getClient());
    }

}

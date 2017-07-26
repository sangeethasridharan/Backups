package com.pack;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class HtmlServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}

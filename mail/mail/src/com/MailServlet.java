package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().println("Hello, world");
		SendMail sm = new SendMail();
		String status = sm.mail();
		PrintWriter out = resp.getWriter();
		out.println(status);
	}
}

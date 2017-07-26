package servlet;

import java.io.*;
import controller.ContactController;
import helper.*;
import javax.servlet.http.*;

public class ContactServlet extends HttpServlet {
	ContactController cc = new ContactController();
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
	PrintWriter out = resp.getWriter();
	String str=	Utils.getRequestBody(req);
	String strr = cc.create(str);
	out.println(strr);
	}
	
	
	
}

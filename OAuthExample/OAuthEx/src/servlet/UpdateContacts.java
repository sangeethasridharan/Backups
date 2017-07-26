package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

import org.codehaus.jackson.map.ObjectMapper;

import beans.Name;
import controller.ContactController;
import helper.*;

public class UpdateContacts extends HttpServlet{
	ContactController cc = new ContactController();
	public void doPut(HttpServletRequest req, HttpServletResponse resp)throws IOException
	{
		String str=	Utils.getRequestBody(req);
		
		String strr = cc.update(str);
		PrintWriter out = resp.getWriter();
		out.println(strr);
	}
}

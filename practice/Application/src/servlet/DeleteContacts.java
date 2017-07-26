package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.*;

import beans.Name;
import helper.Utils;

import controller.*;

public class DeleteContacts extends HttpServlet {
	
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		ContactController cc = new ContactController();
		PrintWriter out = resp.getWriter();
		String str=	Utils.getRequestBody(req);
		List<Name> strr = cc.delete(str);
		out.println(strr);
	}

}

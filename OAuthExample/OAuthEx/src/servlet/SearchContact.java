package servlet;

import java.io.*;
import java.util.HashMap;
import java.util.List;

import controller.ContactController;

import javax.servlet.http.*;

import org.codehaus.jackson.map.ObjectMapper;

import beans.Name;

public class SearchContact extends HttpServlet{
    ContactController cc = new ContactController();
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		try
		{
	  String name = req.getParameter("val");
      List<Name> objectName=  (List<Name>) cc.search(name);
      resp.getWriter().write(new ObjectMapper().writeValueAsString(objectName));
		}
		catch(Exception e)
		{
			resp.getWriter().write("Not Available");
		}
	}
}

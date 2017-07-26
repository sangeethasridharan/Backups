package com.contacts;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ContactsServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	 String name,mobileno;
	 resp.setContentType("text/html");
	 PrintWriter out = resp.getWriter();
	 Map<String,HashMap<String,String>> map = new HashMap<String,HashMap<String,String>>();
	 
	 HttpSession session=req.getSession();
	 if (session.isNew())
	 {
		 session.setAttribute("userID",map); 
	 }
	 else
	 {
		 map = (Map<String,HashMap<String,String>>)session.getAttribute("userID");
		 name = req.getParameter("name");
		 mobileno = req.getParameter("mobno");
		 map.put(name, new HashMap<String,String>());
		 map.get(name).put("MobileNo",mobileno);
		 map.keySet().removeIf(Objects::isNull);
		 out.println(map);
	 }
	 
	 out.println("<html><body align='center'><form method='post' action='ContactsServlet'>");
	 out.println("<fieldset style='width:1310px'><legend>Add Contacts</legend>");
	 out.println("Name<input type='text' name='name' required placeholder='Enter name' autofocus/>");
	 out.println("MobileNumber<input type='text' name='mobno' required placeholder='Enter mobile number'/>");
	 out.println("<input type='Submit' value='add contacts'/>");
	 out.println("</fieldset></form></body></html>");
	 
	}
}

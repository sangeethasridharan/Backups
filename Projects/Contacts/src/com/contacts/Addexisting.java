package com.contacts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

public class Addexisting extends HttpServlet {
	String existName="",landNo="";
	Map<String,HashMap<String,String>> mapex;
public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
 {
	 resp.setContentType("text/html");
	 PrintWriter out = resp.getWriter();
	 out.println("<html><body align='center'><form method='post' action='Addexisting'>");
	 out.println("<fieldset style='width:1310px'><legend>Add ExistingContacts</legend>");
	 out.println("<label>EnterName</label><input type='text' name='existname' required placeholder='Enter name' autofocus/>");
	 out.println("LandLineNumber<input type='text' name='landlineno' required placeholder='Enter LandLine number'/>");
	 out.println("<input type='Submit' value='add contacts'/>");
	
	 out.println("</fieldset></form></body></html>");
	 existName = req.getParameter("existname");
	 
	 HttpSession session=req.getSession(false);
	 if(session == null)
	 {
		 session = req.getSession();
	 }
     mapex=(Map<String,HashMap<String,String>>)session.getAttribute("userID");
    if(mapex.containsKey(existName))
    {
     landNo = req.getParameter("landlineno");
     mapex.get(existName).put("Landline",landNo);
    }
    out.println(mapex);
 }
}

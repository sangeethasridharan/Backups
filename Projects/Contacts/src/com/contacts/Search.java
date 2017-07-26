package com.contacts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Search extends HttpServlet{
	String searchName="";
	Map<String,HashMap<String,String>> mapex;
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	 {
		 
		 resp.setContentType("text/html");
		 PrintWriter out = resp.getWriter();
		 out.println("<html><body align='center'><form method='post' action='Search'>");
		 out.println("<fieldset style='width:1310px'><legend>Search Contacts</legend>");
		 out.println("<label>EnterName To Search</label><input type='text' name='searchName' required placeholder='Enter name' autofocus/>");
		 
		 out.println("<input type='Submit' value='Enter'/><br>");
		 
		 out.println("</fieldset></form></body></html>");
		 
		 HttpSession session=req.getSession(false);
		 if(session == null)
		 {
			 session = req.getSession();
		 }
		 
		 
	     mapex=(Map<String,HashMap<String,String>>)session.getAttribute("userID");
	     searchName = req.getParameter("searchName");
	     if(mapex.containsKey(searchName))
	     {
	    	 out.println("<form align='center'><h2>"+mapex.get(searchName)+"</h2></form><br>");
	     }
	 }
}

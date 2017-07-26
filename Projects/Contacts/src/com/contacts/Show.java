package com.contacts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Show extends HttpServlet{
	Map<String,HashMap<String,String>> mapex ;
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	 {
		 
		 resp.setContentType("text/html");
		 PrintWriter out = resp.getWriter();
		 out.println("<html><body align='center'><form method='post' action='Show'>");
		 out.println("<fieldset style='width:1310px'><legend>Show Contacts</legend>");
		 
		 
		 HttpSession session=req.getSession(false);
		 if(session == null)
		 {
			 session = req.getSession();
		 }
		 
		 
	     mapex=(Map<String,HashMap<String,String>>)session.getAttribute("userID");
	     out.println("<label align='center'><h1><u><b>#.....CONTACTS....#</b></u></h1></label>");
	     Set<String> keySet = mapex.keySet();
	     Iterator<String> keySetIterator = keySet.iterator();
	     while (keySetIterator.hasNext()) {
	    	 String key = keySetIterator.next();
	    	 out.println("<form align='center'><h2>" +key+"</h2></form><br>");
	    	   
	    	 }
	     out.println("</fieldset></form></body></html>");
	 }	 
}

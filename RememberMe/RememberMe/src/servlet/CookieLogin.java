package servlet;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CookieLogin extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String s = "";
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = req.getReader();
		    while ((line = reader.readLine()) != null)
		       jb.append(line);
		       s = jb.toString();
		  } catch (Exception e) { }
		
		
		System.out.println(s);
		ObjectMapper obj = new ObjectMapper();
		Map<String, String> map = obj.readValue(s, new TypeReference<Map<String,String>>(){});
		
		String email = map.get("emailId");
		String password = map.get("password");
		
		HttpSession session = req.getSession(false);
		
		Cookie[] cookie1 = req.getCookies();
		if(cookie1 != null)
		{
			Cookie cookies = cookie1[0];
			if(cookies.getName().equals("JSESSIONID"))
			{
				cookies.setMaxAge(0);
		        cookies.setValue(null);
		        resp.addCookie(cookies);
		        
		        if(email != null && password != null)
				{
					if(!email.isEmpty() && !password.isEmpty())
					{
						Cookie ck = new Cookie("email",email);
						ck.setMaxAge(365 * 24 * 60 * 60);
						resp.addCookie(ck);
						out.println("Welcome!!! "+ck.getValue());
						RequestDispatcher rd = req.getRequestDispatcher("/profile.html");
				        rd.include(req, resp);
					}
					else
					{
						out.println("false");
					}
				}
				else
				{
					out.println("false");
				}
		        
		        
			}
			else
			{
			          Cookie cookie = cookie1[0];
			          out.println("Welcome Back!!!  "+cookie.getValue());
			          RequestDispatcher rd = req.getRequestDispatcher("/profile.html");
				      rd.include(req, resp);
			}
		}
		
	}

}

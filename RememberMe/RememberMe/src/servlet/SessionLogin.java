package servlet;

import java.io.*;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SessionLogin extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		String s = "";
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = req.getReader();
		    while ((line = reader.readLine()) != null)
		       jb.append(line);
		       s = jb.toString();
		  } catch (Exception e) { }
		
		String sessionEmail = (String)session.getAttribute("email");
		if(sessionEmail !=null){
			out.println("Welcome Back From session !!!  "+ sessionEmail);
	        RequestDispatcher rd = req.getRequestDispatcher("/profile.html");
		    rd.include(req, resp);
		    return;
		}
		  
		System.out.println(s);
		ObjectMapper obj = new ObjectMapper();
		Map<String, String> map = obj.readValue(s, new TypeReference<Map<String,String>>(){});
		
		String email = map.get("emailId");
		System.out.println(email);
		String password = map.get("password");
		String sessName = null;
		
		session.setAttribute("email", email);
		
		out.println("Welcome Back!!!  "+ email);
        RequestDispatcher rd = req.getRequestDispatcher("/profile.html");
	    rd.include(req, resp);
	
		/*Cookie[] cookie = req.getCookies();
		if(cookie != null)
		{
			Cookie cookies = cookie[0];
			if(cookies.getName().equals("JSESSIONID"))
			{
				
				sessName =(String)session.getAttribute("email");
				out.println("Welcome Back!!!  "+ sessName);
		        RequestDispatcher rd = req.getRequestDispatcher("/profile.html");
			    rd.include(req, resp);
				System.out.println(sessName);
			}
			else if(session==null || !req.isRequestedSessionIdValid())
			{
				if(email != null && password != null)
				{
					if(!email.isEmpty() && !password.isEmpty())
					{ 
						session.setAttribute("email", email);
						sessName = (String)session.getAttribute("email");
						out.println("Welcome!!!  "+ sessName);
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
				RequestDispatcher rd = req.getRequestDispatcher("/profile.html");
			    rd.include(req, resp);
			}
		}*/
		
	}
		
}

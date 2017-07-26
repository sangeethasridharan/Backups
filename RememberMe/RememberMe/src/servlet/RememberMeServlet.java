package servlet;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RememberMeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Cookie[] ck1 = req.getCookies();
		HttpSession session = req.getSession(false);
		
			if(ck1 != null) {
				Cookie cookie = null;
				
					cookie = ck1[0];
					if(cookie.getName().equals("JSESSIONID"))
			          {
			        	
			        	String sname = (String)session.getAttribute("email"); 
			        	out.println("Welcome Back!!!  "+sname);
				          RequestDispatcher rd = req.getRequestDispatcher("/profile.html");
					      rd.include(req, resp);
						/*cookie.setMaxAge(0);
				        cookie.setValue(null);
				        resp.addCookie(cookie);*/
				        
			          }
			          else
			          {
			        	  out.println("Welcome Back!!!  "+cookie.getValue());
				          RequestDispatcher rd = req.getRequestDispatcher("/profile.html");
					      rd.include(req, resp);
			          }
			          
			          
			          
			       
			}
			else
			{
				resp.sendRedirect("index.jsp");
			}	
	}
}

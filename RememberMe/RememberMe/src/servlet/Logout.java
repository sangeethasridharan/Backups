package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Logout extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Cookie[] ck1 = req.getCookies();
		
		HttpSession session = req.getSession(false);
		if(session != null)
		{
			session.invalidate();
			resp.sendRedirect("index.jsp");
		}
		
		if(ck1 != null) {
		      
		          Cookie cookie = ck1[0];
		          cookie.setMaxAge(0);
		          cookie.setValue(null);
		          resp.addCookie(cookie);
		          out.println("LoggedOut successfully!!");

		      resp.sendRedirect("index.jsp");
		}
		
		
		
		
	}

}

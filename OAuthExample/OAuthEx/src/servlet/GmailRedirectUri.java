package servlet;


import java.io.*;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.*;

public class GmailRedirectUri extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		String authcode = req.getParameter("code");
		RedirectAccess ra = new RedirectAccess();
		
		
		if(authcode != null){
			String accesstoken = ra.getAccessToken(authcode);
			String datas = ra.files(accesstoken);
			
			Map<String,String> map = ra.datas(datas);
			System.out.println(map);
			HttpSession session = req.getSession();
			session.setAttribute("email",map.get("email"));
			
			resp.sendRedirect("showdetails.html");
			
			
//			out.println(new ObjectMapper().writeValueAsString(map));
			
			
//			PrintWriter out = resp.getWriter();
//			out.println("<html><body>");
//			out.println("<form align='center'>");
//			out.print("<table style='width:100% height:100%'><tr><th>Picture</th><th>Details</th></tr>");
//	        out.print("<tr><td><iframe src='"+map.get("picture")+"' width='50%' height='80%'></iframe></td><td>");
//			out.println("ID : "+map.get("id"));
//			out.println("Email : "+map.get("email"));
//			out.print("</td></tr>");
//			out.println("</table></body></html>");
			
		}
		else
		{
			resp.sendRedirect("index.html");
			
		}
	}

}

package spring;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.*;  
import org.springframework.web.servlet.ModelAndView;  

import java.io.*;

@SuppressWarnings("serial")
@Controller  

public class ControllerClass extends HttpServlet{
	
	@RequestMapping("/rememberme")  
	public ModelAndView rememberMe(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Cookie[] ck1 = req.getCookies();
		ModelAndView mv = null;	
			if(ck1 != null) {
			      for (int i = 0; i < ck1.length; i++) {
			          Cookie cookie = ck1[i];
			          out.println("Welcome Back!!!  "+cookie.getValue());
			          RequestDispatcher rd = req.getRequestDispatcher("/profile.html");
				      rd.include(req, resp);
			       }
			}
			else
			{
				mv = new ModelAndView();
				mv.setViewName("index");
			}
			return mv;	
	}
}

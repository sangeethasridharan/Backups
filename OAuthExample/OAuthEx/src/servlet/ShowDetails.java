package servlet;

import java.io.*;
import java.util.*;
import beans.*;
import controller.RedirectAccess;
import javax.servlet.http.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShowDetails extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
		RedirectAccess ra = new RedirectAccess();
		HttpSession session = req.getSession();
	    String email = (String)session.getAttribute("email");
	    List<PersonalData> list = ra.showdetails(email);
	    resp.getWriter().write(new ObjectMapper().writeValueAsString(list));
    }
}

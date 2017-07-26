package servlet;


import java.io.IOException;
import java.util.List;
import javax.servlet.http.*;

import org.codehaus.jackson.map.ObjectMapper;

import beans.Name;
import controller.ContactController;

public class ShowContact extends HttpServlet {
	ContactController cc = new ContactController();
      public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
      {
    	  List<Name> list = cc.show();
    	  resp.getWriter().write(new ObjectMapper().writeValueAsString(list));
      }
}

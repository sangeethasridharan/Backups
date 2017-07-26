package servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class GmailSyncAppServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.sendRedirect("https://accounts.google.com/o/oauth2/v2/auth?scope=https://mail.google.com/ &access_type=offline&include_granted_scopes=true&redirect_uri=http://localhost:8889/gmailredirecturi&response_type=code&client_id=368553155358-66k5hpkp2o1349igavna6f864cqelkb5.apps.googleusercontent.com");
	}
}

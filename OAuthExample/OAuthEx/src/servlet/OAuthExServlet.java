package servlet;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class OAuthExServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/plain");
		resp.sendRedirect("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.profile+https://www.googleapis.com/auth/userinfo.email&access_type=offline&redirect_uri=http://1-dot-cmsproject-166607.appspot.com/gmailredirecturi&response_type=code&client_id=37662606906-c27jc6ishsiup9od6i9cqmu5johlh5uo.apps.googleusercontent.com&prompt=consent");
	
	}
}

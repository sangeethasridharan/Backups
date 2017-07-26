package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GmailRedirectUri extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String authcode = req.getParameter("code");
	    
		/*PrintWriter out = resp.getWriter();
		out.println(authcode);*/
	    
		HttpSession session = req.getSession();
        session.setAttribute("codes", authcode);
        doPost(req,resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		 
		 HttpSession session = req.getSession();
	     String aucode = (String)session.getAttribute("codes");
	     PrintWriter out = resp.getWriter();
	     
		 out.println(aucode);
		 RequestDispatcher rd = req.getRequestDispatcher("https://www.googleapis.com/oauth2/v4/token?code="+aucode+"&client_id=368553155358-66k5hpkp2o1349igavna6f864cqelkb5.apps.googleusercontent.com&client_secret=myEGjaqr1chv75IirAIKoYU6&redirect_uri=http://localhost:8889/gmailredirecturi&grant_type=authorization_code");
		 rd.forward(req, resp);
		 
        /*URL url = new URL("https://www.googleapis.com/oauth2/v4/token&code="+aucode+"&client_id=368553155358-66k5hpkp2o1349igavna6f864cqelkb5.apps.googleusercontent.com&client_secret=myEGjaqr1chv75IirAIKoYU6&redirect_uri=http://localhost:8822/gmailredirecturi&grant_type=authorization_code");
		
		HttpURLConnection huc = (HttpURLConnection)url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
		String data;
		StringBuffer sb = new StringBuffer();
		while((data = br.readLine()) != null)
		{
			sb.append(data);
		}
		
		out.println(sb);
		*/
	}

}

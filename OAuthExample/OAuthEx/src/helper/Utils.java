package helper;

import java.io.*;
import javax.servlet.http.*;
public class Utils extends HttpServlet {
	public static String getRequestBody(HttpServletRequest req){
		String s = "";
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = req.getReader();
		    while ((line = reader.readLine()) != null)
		       jb.append(line);
		       s = jb.toString();
		  } catch (Exception e) { }
		  return s;
	}
}	
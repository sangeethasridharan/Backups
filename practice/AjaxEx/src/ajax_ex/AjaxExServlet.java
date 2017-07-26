package ajax_ex;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.jdo.PersistenceManager;

import javax.servlet.http.*;
import javax.jdo.Query;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;






@SuppressWarnings("serial")
public class AjaxExServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		URL url = new URL("http://api-demo-py.appspot.com/getAllUsers");
		
		HttpURLConnection huc = (HttpURLConnection)url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
		String data;
		StringBuffer sb = new StringBuffer();
		while((data = br.readLine()) != null)
		{
			sb.append(data);
		}
		
		System.out.println(sb);
		
		ObjectMapper obj = new ObjectMapper();

		
		
		Map<String,ArrayList<NewPojo>> mar = obj.readValue(sb.toString(), new TypeReference<HashMap<String,Object>>(){});
		System.out.println(mar);
		
		ArrayList<NewPojo> arrylist=mar.get("msg");
	    System.out.println(arrylist);
	    
	    AjaxPojo nw = null;
	    PersistenceManager pm = null;
	    for(int i=0;i<arrylist.size();i++)
	    {
	    nw = obj.readValue(obj.writeValueAsString(arrylist.get(i)),new TypeReference<AjaxPojo>(){});
	    System.out.println(nw);
	    pm = PMF.get().getPersistenceManager();
		pm.makePersistent(nw);
	    }
	    
	   
		long str=Long.parseLong(req.getParameter("strv"));  
		long end=Long.parseLong(req.getParameter("endv")); 
		String name = req.getParameter("pname");
		
		Query q = pm.newQuery(AjaxPojo.class);
		q.setRange(str,end);
		@SuppressWarnings("unchecked")
		List<AjaxPojo> li = (List<AjaxPojo>)q.execute(); 
		out.println(li);
		
		
	}
}

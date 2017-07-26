package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.*;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;



import javax.jdo.PersistenceManager;

import javax.servlet.http.*;



public class HttpUrl extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/HTML");
		
		
		URL url = new URL("https://randomuser.me/api?inc=results,gender,name&noinfo");
		
		
		HttpURLConnection hu = (HttpURLConnection)url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(hu.getInputStream()));
		String data;
		StringBuffer sb = new StringBuffer();
		while((data = br.readLine()) != null)
		{
			sb.append(data);
		}
		System.out.println(sb);
		
		ObjectMapper obj = new ObjectMapper();
		Map<String ,Object> r = obj.readValue(sb.toString(), new TypeReference<Map<String,Object>>(){});
		System.out.println(r);
		
		
		PojoHttpUrl phu = obj.readValue(sb.toString(), new TypeReference<PojoHttpUrl>(){});
		System.out.println("Success");
		
		PojoHttpUrl phu1 = new PojoHttpUrl();
		
		
        PersistenceManager pm = PMF.get().getPersistenceManager();
        {
        	pm.makePersistent(phu1);
        }
	}
	
	
}

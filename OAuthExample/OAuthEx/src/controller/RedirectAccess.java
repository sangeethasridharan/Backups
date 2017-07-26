package controller;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.jdo.Query;
import javax.jdo.PersistenceManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;


import beans.*;
import helper.PMF;

public class RedirectAccess {
	public static final PersistenceManager pm = PMF.get().getPersistenceManager();
	public String getAccessToken(String authcode) throws IOException
	{
	        URL url = new URL("https://www.googleapis.com/oauth2/v4/token");
	        String params = "code="+authcode+"&client_id=37662606906-c27jc6ishsiup9od6i9cqmu5johlh5uo.apps.googleusercontent.com&client_secret=M3DylIePunXT2QVht15Ffgze&redirect_uri=http://1-dot-cmsproject-166607.appspot.com/gmailredirecturi&grant_type=authorization_code";
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        
	        con.setRequestMethod("POST");
	        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        con.setDoOutput(true);
            
	        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
	        wr.write(params);
	        wr.flush();
	      
	        System.out.println(con.getResponseCode());
	        System.out.println(con.getResponseMessage()); 
		
		// Get the response
        String tokens = new String();
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            tokens+=line;
        }

        //Output the response
        System.out.println(tokens);
        
        // Mapping JSON
        ObjectMapper obj = new ObjectMapper();
        
        TokenAccess pojo= obj.readValue(tokens, TokenAccess.class);
        System.out.println(pojo.getAccess_token());
		String accesstoken = pojo.getAccess_token();
		return accesstoken;
	}
	
	public String files(String accesstoken) throws IOException
	{

		URL url = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + accesstoken);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		String line, datas = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		while ((line = reader.readLine()) != null) {
		datas += line;
		}
        //Output the response
        System.out.println(datas);
		return datas;
		
	}
	
	public Map<String,String> datas(String data) throws JsonParseException, JsonMappingException, IOException
	{
	
		 ObjectMapper obj = new ObjectMapper();
		 PersonalData pd = obj.readValue(data,PersonalData.class);
		 pm.makePersistent(pd);
//		 System.out.println(pd.getEmail());
//		 System.out.println(pd.getFamily_name());
		 Map<String,String> map = obj.readValue(data, new TypeReference<Map<String,String>>(){});
		 System.out.println(map.get("id"));
		 
		 return map;
		 
	}
	
	public List<PersonalData> showdetails(String emails)
	{
		Query q = pm.newQuery(PersonalData.class,"email == emails");
	    q.declareParameters("String emails");
	    
	    List<PersonalData> result =  (List<PersonalData>) q.execute(emails);
	    
	    System.out.println(emails);
	    return result;
		 
	}

}

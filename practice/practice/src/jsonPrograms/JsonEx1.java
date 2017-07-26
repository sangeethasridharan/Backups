package jsonPrograms;

import java.io.*;

import java.net.*;
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
public class JsonEx1 {

	
	
	public static void main(String ar[]) throws Exception
	{
		URL url = new URL("https://randomuser.me/api/?results=10&inc=,gender,name&noinfo");
		HttpURLConnection hu = (HttpURLConnection)url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(hu.getInputStream()));
		String data;
		StringBuffer sb = new StringBuffer();
		while((data = br.readLine()) != null)
		{
			sb.append(data);
		}
		String orgstr=sb.toString();
		System.out.println(orgstr);
		
		ObjectMapper obj = new ObjectMapper();
		//obj.writeValue(new File("jsonData.json"),sb);
		
		//String jstr = obj.writeValueAsString(sb);
		//System.out.println(jstr);
		
		//JavaType myList= obj.convertValue(jstr, obj.getTypeFactory().constructCollectionType(ArrayList.class, Results.class));
        
		//obj.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		//final TypeReference<List<MyClass>> typeref
	   // = new TypeReference<List<MyClass>>() {};
		//JSON.parse(jstr);
		
	   //final List<Results> list = obj.readValue( jstr, myList);
	    Map<String ,ArrayList<MyClass>> r = obj.readValue(sb.toString(), new TypeReference<Map<String,ArrayList<MyClass>>>(){});
	    System.out.println(r);
	    ArrayList<MyClass> arrylist=r.get("results");
	    System.out.println(arrylist);
	   
	    MyClass r1=obj.readValue(obj.writeValueAsString(arrylist.get(0)),new TypeReference<MyClass>(){});
	    System.out.println(r1);
	   
	    Name className = obj.readValue(obj.writeValueAsString(r1.getName()), new TypeReference<Name>(){});
	    System.out.println(className.getFirst());
	   
	   
	   
	/*   for(Map.Entry map: m.entrySet())
	   {
		   if(map.getKey().equals("title"))
		   System.out.println(map);
	   } */
	   System.out.println(r1.getName());
	   
	    
	   //System.out.println(obj.writeValueAsString(list));
	}
}

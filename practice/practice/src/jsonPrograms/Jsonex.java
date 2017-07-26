package jsonPrograms;

import java.io.*;
import java.net.*;
import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
// @JsonIgnoreProperties(ignoreUnknown = true)
public class Jsonex {
 
	@SuppressWarnings("unchecked")
	public MyClass showData()
	{
		try
		{   
			
			URL url = new URL("https://randomuser.me/api/?results=1&&inc=gender,name&noinfo");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			
			
			String data;
			StringBuffer buff = new StringBuffer();
			while((data=br.readLine()) != null)
			{
				buff.append(data);
			}
			
			ObjectMapper mapper = new ObjectMapper();
			
			Map<String,Object> map1 = mapper.readValue(buff.toString(),new TypeReference<Map<String,Object>>(){});
		    System.out.println(map1);
		    mapper.writeValue(new File("jsonData.json"),map1);
		    

		
		}
		catch (IOException e) {
            e.printStackTrace();
		}
		return null;
		
	}
    public static void main(String a[]){
    		Jsonex js = new Jsonex();
    	//Status status = js.showData();
    	//System.out.println(status.getFirst());
    	//System.out.println(status.getLast());
    	//System.out.println(status.getGender()); 
    		js.showData();
        
        
    }
}
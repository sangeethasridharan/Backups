package controller;

import java.io.*;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import java.util.*;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import helper.PMF;
import beans.*
;

import javax.jdo.Extent;

public class ContactController  {
	public static final PersistenceManager pm = PMF.get().getPersistenceManager();
	
	public String create(String str) throws JsonParseException, JsonMappingException, IOException 
	{
		
        ObjectMapper obj = new ObjectMapper();
        
        System.out.println(str);
        Map<String ,ArrayList<MyClass>> r = obj.readValue(str.toString(), new TypeReference<Map<String,ArrayList<MyClass>>>(){});
	    System.out.println(r);
	    ArrayList<MyClass> arrylist=r.get("results");
	    System.out.println(arrylist);
	   
	    MyClass r1=obj.readValue(obj.writeValueAsString(arrylist.get(0)),new TypeReference<MyClass>(){});
	    System.out.println(r1);
	   
	        
	    Name className = obj.readValue(obj.writeValueAsString(r1.getName()), new TypeReference<Name>(){});
		    System.out.println(className.getFirst());
		    
		   
			pm.makePersistent(className);
			
			String fname = className.getFirst();
			
			return fname;
	}
	
	public List<Name> search(String name)
	{
		  
		    System.out.println("First Name "+name);
		    Query q = pm.newQuery(Name.class,"first == name");
		    q.declareParameters("String name");
		    
		    List<Name> result =  (List<Name>) q.execute(name);
		    
		    result.get(0);
		    return result;
		    
	}
	
	public List<Name> show()
	{
		
		//List<Name> list = new ArrayList<Name>();
		Query q = pm.newQuery(Name.class);
		
		List<Name> list = (List<Name>) q.execute();
		list.get(0);
		return list;
		
	}
	
	public String update(String str ) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper obj = new ObjectMapper();
		System.out.println(str);
	    Map<String,String> ar = obj.readValue(str, new TypeReference<Map<String,String>>(){});
		Name na = new Name();
		na.setFirst(ar.get("first"));
		na.setLast(ar.get("last"));
		na.setTitle(ar.get("title"));
		pm.makePersistent(na);
		return "Updated Successfully";
	}
	
	public String delete(String str)
	{
		System.out.println(str);
		Key k = KeyFactory.createKey(Name.class.getSimpleName(), str);
        Name name = pm.getObjectById(Name.class, k);
        pm.deletePersistent(name);
        
		return "Deleted Successfully";
	}
	
}

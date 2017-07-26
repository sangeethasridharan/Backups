package jsonPrograms;

import java.util.*;

public class MyClass {
	
	private String gender;
	private Map<String, String> name;
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setName(Map<String, String> name) {
		this.name = name;
	}
	
	public Map<String,String> getName()
	{
		return name;
	}
//	public String toString() {
//        return "Results1 [Gender=" + gender + ", name=" + name + "]";
//    }
    
	
	public String toString()
	{
		return "gender :"+gender+" Name :"+name; 
	}

}


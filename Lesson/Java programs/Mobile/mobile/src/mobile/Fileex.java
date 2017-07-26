package mobile;

import java.io.*;
import java.util.*;

public class Fileex {
	public static void main(String args[])
	                            throws IOException, ClassNotFoundException {
	    HashMap<String, Object> fileObj = new HashMap<String, Object>();

	    ArrayList<String> cols = new ArrayList<String>();
	    cols.add("a");
	    cols.add("b");
	    cols.add("c");
	    fileObj.put("mylist", cols);
	    {
	        File file = new File("temp");
	        FileOutputStream f = new FileOutputStream(file);
	        ObjectOutputStream s = new ObjectOutputStream(f);
	        s.writeObject(fileObj);
	        s.close();
	    }
	    File file = new File("temp");
	    FileInputStream f = new FileInputStream(file);
	    ObjectInputStream s = new ObjectInputStream(f);
	    HashMap<String, Object> fileObj2 = (HashMap<String, Object>) s.readObject();
	    s.close();

	    Assert.assertEquals(fileObj.hashCode(), fileObj2.hashCode());
	    Assert.assertEquals(fileObj.toString(), fileObj2.toString());
	    Assert.assertTrue(fileObj.equals(fileObj2));
	}
	}

import java.util.*;
import java.io.*;

class Example
{
  public static void main(String ar[])throws Exception
  {
    Map<String, HashMap<String,String>> map = new HashMap<String, HashMap<String,String>>();
    map.put("1",new HashMap<String,String>());
    map.get("1").put("san","short");
    map.get("1").put("sangy","long");
    System.out.println(map);
    String s = map.get("1").get("sangy");
    System.out.println(s);
  }
}

import java.util.*;

class Arrayex
{
  public static void main(String ar[])
  {
    Map<String, HashMap<String,String>> m = new HashMap<String, HashMap<String,String>>();
    m.put("1",new HashMap<String,String>());
    m.get("1").put("san",null);
    String sm = m.get("1").get("san");
    System.out.println(sm);
    m.get("1").put("san","short");
    m.get("1").put("sangy","long");
    System.out.println(m);

    Scanner sc = new Scanner(System.in);
    System.out.println("san/sangy");
    String s = sc.nextLine();
    if(s.equals("san"))
    {
    String s1 = m.get("1").get("san");
    System.out.println(s1);
    }
    else
    {
    m.get("1").get("sangy");
    System.out.println(m);
    Set<String> s11 = m.keySet();
    m.values();
    System.out.println(s11);
    System.out.println(m);
    m.get("sangy");
    System.out.println(m);
    }
  }
}

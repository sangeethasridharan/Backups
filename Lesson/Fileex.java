import java.util.*;

class Fileex1
{
public void addNew(Map<String, HashMap<String,String>> h)
{
    System.out.println("Added Successfully....." +h);
}

public void addExisting(String name, String no, Map<String, HashMap<String,String>> map)
{
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter your Name");
   String nameToSearch = sc.nextLine();
   if(name.equals(nameToSearch))
   {
     System.out.println("Do you want to add another number???? \n1.LandlineNumber \n2.Exit");
     int o;
     o = Integer.parseInt(sc.nextLine());

       switch(o)
       {
       case 1:
       System.out.println("Landline Number");
       String lno = sc.nextLine();
       map.get(name).put("LandlineNumber",lno);
       System.out.println("Added......");
       System.out.println(map);
       break;

       case 2:
       System.exit(0);
       break;

       default:
       System.out.println("Enter Correctly");
       System.exit(0);
       }

   }else
   {
     System.out.println("Please add your contact...");
   }
}

public void showContacts(String name)
{
   System.out.println(name);
}

public void search(String name, Map<String, HashMap<String,String>> map)
{
   Scanner sc = new Scanner(System.in);
   System.out.println("Name");
   String nameToSearch = sc.nextLine();
   if(name.equals(nameToSearch))
   {
     System.out.println("****** CONTACTS ******");
     System.out.println("Choose what you want to see ??? \n1. MobileNumber \n2. LandlineNumber \n3. Both");
     System.out.println("Enter the number to proceed : ");
     int opt = Integer.parseInt(sc.nextLine());
     if(opt == 1)
     {
       String s1 = map.get(name).get("Number");
       System.out.println("Number -> "+s1);
     }
     else if(opt == 2)
     {
       String s2 = map.get(name).get("LandlineNumber");
       System.out.println("LandlineNumber -> "+s2);
     }
     else
     {
       String s3 = map.get(name).get("Number");
       System.out.println("Number -> "+s3);
       String s4 = map.get(name).get("LandlineNumber");
       System.out.println("LandlineNumber -> "+s4);
     }
   }
}
}

class Fileex
{
public static void main(String ar[])
{
  Fileex1 f1 = new Fileex1();

  Scanner s = new Scanner(System.in);
  int l;
  Map<String, HashMap<String,String>> m = new HashMap<String, HashMap<String,String>>();
  String name="",no="";


  do
  {
  System.out.println("****** CONTACTS ******");
  System.out.println("1. Add New Contacts \n2. Add Existing Contacts \n3. Show Contacts \n4. Search \n5. Exit \n");
  System.out.println("Enter the number to proceed : ");
  l = Integer.parseInt(s.nextLine());

  switch(l)
  {
  case 1:
  System.out.println("Name: ");
  name = s.nextLine();
  System.out.println("Number: ");
  no = s.nextLine();
  m.put(name,new HashMap<String,String>());
  m.get(name).put("Number",no);
  f1.addNew(m);
  break;

  case 2:
  f1.addExisting(name,no,m);
  break;

  case 3:
  f1.showContacts(name);
  break;

  case 4:
  f1.search(name,m);
  break;

  case 5:
  System.exit(0);
  break;

  default:
  System.exit(0);
  }
}while(l!=5);
}
}

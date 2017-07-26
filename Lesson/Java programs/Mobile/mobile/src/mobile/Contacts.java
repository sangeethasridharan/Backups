package mobile;
import java.io.*;
import java.util.*;

class Process
{
	
	public static void addNew(String n,String no,HashMap<String,String> t) throws Exception
	{
		t.put(n,no);
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("t");
		p.load(fis);
		FileOutputStream fos = new FileOutputStream("ContactsAvailable.txt");
		p.store(fos, "Name and Number added");
	}
	
	public static void addExisting(String na, String no,HashMap<String, String> t) throws Exception
	{
		String an ="",ln="",ei="",od="";
		Properties p1 = new Properties();
		FileInputStream fis = new FileInputStream("ContactsAvailable.txt");
		p1.load(fis);
		HashMap<String,HashMap<String,String>> hm = new HashMap<>();
		if(fis.equals(na))
		{   
			Scanner s1 = new Scanner(System.in);
			System.out.println("What you want to add ???? \n1. AnotherNumber \n2.Landline Number \n3.Email ID \n4.Other Details  \n5.Exit");
			int o;
			o = Integer.parseInt(s1.nextLine());
			do
			{
			switch(o)
			{
			case 1:
			System.out.println("Another Number");
			an = s1.nextLine();
			t.put(na,no);
			hm.put(an,t);
			break;
			
			case 2:
			System.out.println("Landline Number");
			ln = s1.nextLine();
			t.put(no,an);
			hm.put(ln,t);
			break;
			
			case 3:
			System.out.println("Email ID");
			ei = s1.nextLine();
			t.put(an,ln);
			hm.put(ei,t);
			break;
			
			case 4:
			System.out.println("Other Details");
			od = s1.nextLine();
			t.put(ln,ei);
			hm.put(od,t);
			break;
			
			case 5:
			System.exit(0); 
			
			default:
			System.out.println("Enter Correctly");
			o = Integer.parseInt(s1.nextLine());
			}
			}while(o<6);
			
		}
		
		FileOutputStream fos = new FileOutputStream("hm");
		p1.store(fos, "Other details added");
	
	}
	
}
public class Contacts {
  public static void main(String ar[]) throws Exception
  {
      while(true)
      {
	  Scanner sc = new Scanner(System.in);
	  int in = 0;
	  String na="",no="";
	  HashMap<String,String> t = new HashMap<>();
	  
	  System.out.println("****** CONTACTS ******");
	  System.out.println("Enter the number to proceed : ");
	  System.out.print("1. Add New Contacts \n2. Add Existing Contacts \n3. Search \n4. Group Contacts \n5. Show Contacts \n6.Exit \n");
	  in = sc.nextInt();
	  do
	  {
	  switch(in)
	  {
	  case 1:
		  Scanner s = new Scanner(System.in);
		  System.out.println("Name: ");
		  na = s.nextLine();
		  System.out.println("Number: ");
		  no = s.nextLine();
		  Process.addNew(na,no,t);
		  System.out.println("Do you want to add anything else ???? [Y/N]");
		  String y = s.nextLine();
		  if(y.equals("Y"))
		  {
			  Process.addExisting(na,no,t);  
		  }
		  else
		  {
			  System.exit(0);
		  }
			  
		  break;
		  
	  case 2:
		  Process.addExisting(na,no,t);
		  break;
		  
	 /* case 3:
		  Process.search();
		  break;
		  
	  case 5:
		  Process.showExisting();
		  break; */
		  
	  case 3:
		  System.exit(0); 
		  
	  default:
		  System.out.println("Enter correctly \n"); 
		  in = sc.nextInt();
	  }
	  }while(in<4);
      }
  }
}

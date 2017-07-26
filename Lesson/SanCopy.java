public static void search()
	{
		
	}
	
	public static void showExisting()
	{
		
	}
	
	public static void group()
	{
		
	}





          case 3:
		  Process.search();
		  break;
		  
	  case 4:
		  Process.group();
		  break;
		  
	  case 5:
		  Process.showExisting();
		  break;



                  FileInputStream fin = null;
		  FileOutputStream out = null;
		  try {
		         fin = new FileInputStream(Process.addNew());
		         out = new FileOutputStream("ContactsAvailable.txt");
		         
		         int c;
		         while ((c = fin.read()) != -1) {
		            out.write(c);
		         }
		      }finally {
		         if (fin != null) {
		            fin.close();
		         }
		         if (out != null) {
		            out.close();
		         }
		      }






HashMap<Integer,String> lh = new HashMap<Integer,String>();
		String no ="";
		int in = 0;
		
			
		    lh.put(1,sn);
			System.out.println("Number \n");
			no = s.nextLine();
			lh.put(2,no);
			Scanner sc = new Scanner(System.in);
			  
			  System.out.println("****** CONTACTS ******");
			  System.out.println("Enter the number to proceed : ");
			  System.out.print("1. Add New Contacts \n2. Add Existing Contacts \n3. Search \n4. Group Contacts \n5. Show Contacts \n");
			  in = sc.nextInt();
			  do
			  {
			  switch(in)
			  {
			  case 1:
				  Process.addNew(sn);
				  break;
				  
			  case 2:
				  Process.addExisting();
				  break;
				  
			  default:
				  System.out.println("Enter correctly \n"); 
				  in = sc.nextInt();
			  }
			  }while(in<3);








LinkedHashMap<Integer,String> lh1 = new LinkedHashMap<Integer,String>();
		    String n1 ="";
		    System.out.println("Enter Existing Name to add Details");
		    n1 = s.nextLine();
		    String sn1 = (addNew(String sn));
			if(lh1.containsValue(n1))
		    {
		    	System.out.println("What you want to add ???? \n1. AnotherNumber \n2.Landline Number \n3.Email ID \n4. Address \n5.OtherDetail");
		    	int o = Integer.parseInt(s.next());
		    	do
		    	{
		    	switch(o)
		    	{
		    	case 1:
		    		System.out.println("Number");
					String no1 = s.nextLine();
					lh1.put(3,no1);
					break;
					
		    	case 2:
		    		System.out.println("Landline Number");
					String lno = s.nextLine();
					lh1.put(4,lno);
					break;
		  		  
		  	    case 3:
		  	    	System.out.println("Email ID");
					String e = s.nextLine();
					lh1.put(5,e);
					break;
		  		  
		  	    case 4:
		  	    	System.out.println("Address");
					String ad = s.nextLine();
					lh1.put(6,ad);
					break;
		  		  
		  	    case 5:
		  	    	System.out.println("Other Details");
					String od = s.nextLine();
					lh1.put(7,od);
					break;
		  		  
		  	    default:
		  		  System.out.println("Enter correctly"); 	
		    	}
		    	}while(true);
		    	
		    }







for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
            String key = entry.getKey();
            System.out.println("Name = " + key);
            System.out.println("Another Number = " + entry.getValue());
        }






System.out.println("Do you want to add anything else ???? [Y/N]");
		  String y = s.nextLine();
		  if(y.equals("Y"))
		  {
			  Process.addExisting(na,no,t);
				break;
		  }
		  else
		  {
			  System.exit(0);
		  }
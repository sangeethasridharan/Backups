package ExceptionHandling;

import java.io.*;

class ZeroException extends Exception{
	String msg;

	ZeroException(String msg)
	{
		this.msg = msg;
	}
	
	public String toString(){ 
	    return (msg);
	}
}

public class Exception_Ex {
public static void main(String ae[]) throws NumberFormatException, IOException
  {
	  int x,y,div,i;
	  try
	  {
		  DataInputStream dis = new DataInputStream(System.in);
		  x=Integer.parseInt(dis.readLine());
		  y=Integer.parseInt(dis.readLine());
		  try
		  {
			  if(y==0)
			  {
				throw new ZeroException("Anything divided by zero is infinite");  
			  }  
			  else
			  {
				  div = x/y;
				  System.out.println("Division: "+div);
			  }
		  }catch(ZeroException ex)
		  {
			  System.out.println(ex);
		  }
		  finally
		  {
			 System.out.println("Inner Final Block");
			 for(i=1;i<=10;i++)
			 {
				 if(i%5==0)
					 throw new ArithmeticException(" -->Exception");
				 else
				     System.out.println("i = " +i);
			 }
		  }
		  
		 
	  }catch(ArithmeticException ex1)
	  {
		  System.out.println("Exception while handling"+ ex1.getMessage());
	  }
	  finally
	  {
		  System.out.println("Outer Final Block");
	  }
  }
}

package ExceptionHandling;

import java.util.*;

class StringException extends Exception{
	String msg;

	StringException(String msg)
	{
		this.msg = msg;
	}
	
	public String toString(){ 
	    return msg;
	}
}

interface Square
{
	
}

interface Cube
{
	
}

class Exception_Handling implements Square
{
	private static int a;
	Exception_Handling(int a)
	{
		Exception_Handling.a=a;
	}
	
	public static void square_Method()
	{
		int square = a*a;
		System.out.println("Square: "+square);
	}
}
	
class Exception_Handling1 implements Cube
{
	private static int b;
	
	Exception_Handling1(int b)
	{
		Exception_Handling1.b=b;
	}

	public static void cube_Method()
	{
		int cube = b*b*b;
		System.out.println("Cube: "+cube);
	}
}

public class Exception_Ex1 {
public static void main(String ar[]) 
{
	int a=0,b=0;
	Scanner sc = new Scanner(System.in);
	System.out.println("Choose the option: \n1. Square \n2. Cube");
	int option = Integer.parseInt(sc.nextLine());
	
	switch(option)
	{
	case 1:
		System.out.println("Enter Number: ");
		a=Integer.parseInt(sc.nextLine());	
		Exception_Handling eh = new Exception_Handling(a);
		if(eh instanceof Square)
			Exception_Handling.square_Method();
		break;
		
	case 2:
		System.out.println("Enter Number: ");
		b=Integer.parseInt(sc.nextLine());	
		Exception_Handling1 eh1 = new Exception_Handling1(b);
		if(eh1 instanceof Square)
			Exception_Handling1.cube_Method();
		break;
		
	default:
		try
		{
			throw new StringException("You Entered Wrongly");
		}
		catch(StringException ex)
		{
			System.out.println(ex);
		}
	}
	
}
}

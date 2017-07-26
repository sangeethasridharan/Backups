import java.util.*;

class Simple
{
public static void show()
{
System.out.println("show");
}

public static void show1()
{
System.out.println("show1");
}
}
public class Simple1
{
public static void main(String ar[])
{
Scanner s = new Scanner(System.in);
int n = Integer.parseInt(s.nextLine());
switch(n)
{
case 1:
Simple1.show();
break;

case 2:
Simple1.show1();
break;

default:
System.exit(0);
}
}
}
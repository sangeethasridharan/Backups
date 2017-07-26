package list;
import java.util.*;

class Example1 {

	public static void data() {

		Vector<String> v = new Vector<String>();
		v.add("addition");
		v.add("subtraction");
		v.add("multiplication");
		v.add("division");
		ArrayList<String> al = new ArrayList<String>(v);
		System.out.println(al);
		al.remove(3);
		System.out.println(al);
		al.add("Division");
		System.out.println(al);

	}
}

class Example2 extends Example1
{


	static void stck()
	{

		Stack<Integer> st = new Stack<Integer>();
		System.out.println("stack: " + st);

		st.push(42);
		st.push(66);
		st.push(99);

		System.out.println("stack: " + st);

		try {
		System.out.println("pop -> " +st.pop());
		System.out.println("stack: " + st);
		st.pop();
		st.pop();
		st.pop();

		}
		catch (EmptyStackException e)
		{
			System.out.println("stack: " + st);
			System.out.println("empty stack");
		}


	}


}

class Example
{
	public static void main(String ar[])
	{
		Example2.data();
	    Example2.stck();
	}

}

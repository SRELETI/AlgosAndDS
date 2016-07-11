
public class StackExampleApp {
	public static void main(String args[])
	{
		int length=5;
		StackExample se=new StackExample(length);
		System.out.println(se.isEmpty());
		se.pop();
		se.push(5);
		se.push(6);
		se.push(7);
		se.push(8);
		se.push(9);
		System.out.println(se.isEmpty());
		System.out.println(se.peek());
		System.out.println(se.size());
		se.push(10);
	}
}

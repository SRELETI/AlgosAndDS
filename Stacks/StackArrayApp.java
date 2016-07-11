
public class StackArrayApp {
	public static void main(String args[])
	{
		StackArray sa = new StackArray(5);
		sa.push(5);
		sa.push(4);
		sa.push(3);
		sa.display();
		sa.pop();
		sa.push(3);
		sa.push(2);
		sa.push(1);
		sa.push(0);
		sa.display();
		System.out.println(sa.isFull());
		sa.pop();
		sa.pop();
		sa.pop();
		sa.pop();
		sa.pop();
		sa.pop();
		System.out.println(sa.isEmpty());
	}
}

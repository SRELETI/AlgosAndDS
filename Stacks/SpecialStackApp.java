
public class SpecialStackApp {
	public static void main(String args[])
	{
		SpecialStack ss = new SpecialStack(5);
		ss.push(5);
		ss.push(4);
		ss.push(3);
		ss.push(6);
		ss.push(7);
		ss.pop();
		ss.pop();
		ss.pop();
		System.out.println(ss.getMin());
	}
}

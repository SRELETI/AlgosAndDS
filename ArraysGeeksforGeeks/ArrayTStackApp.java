
public class ArrayTStackApp {
	public static void main(String args[])
	{
		ArrayTStack ats = new ArrayTStack(5,5);
		ats.pop();
		ats.pop2();
		ats.push1(5);
		ats.push2(5);
		ats.push1(4);
		ats.push1(3);
		ats.push1(2);
		ats.push1(1);
		ats.push1(0);
		//ats.push1(4);
		ats.push2(4);
		ats.push2(3);
		ats.push2(2);
		ats.push2(1);
		ats.display();
		ats.display2();
		ats.push2(0);
		//ats.pop();
		//System.out.println(ats.isEmpty1());
		
	}
}

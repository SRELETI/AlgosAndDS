
public class TwoStackArrayApp {
	public static void main(String args[])
	{
		TwoStackArray tsa = new TwoStackArray(2,2);
		tsa.push1(3);
		tsa.push1(3);
		System.out.println(tsa.isFull());
		tsa.push1(3);
		tsa.pop();
		tsa.display1();
		tsa.push2(4);
		tsa.push2(4);
		System.out.println(tsa.isFull2());
		tsa.push2(4);
		tsa.pop2();
		tsa.display2();
	}
}

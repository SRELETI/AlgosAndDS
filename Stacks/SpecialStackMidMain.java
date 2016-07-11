
public class SpecialStackMidMain {
	public static void main(String args[])
	{
		SpecialStackMidList ss = new SpecialStackMidList();
		ss.push(4);
		ss.push(3);
		ss.push(2);
		ss.push(1);
		ss.display();
		System.out.println(ss.middle());
		System.out.println(ss.deleteMiddle());
		ss.display();
		System.out.println(ss.middle());
		System.out.println(ss.deleteMiddle());
		ss.display();
		System.out.println(ss.middle());
		System.out.println(ss.deleteMiddle());
		ss.display();
		System.out.println(ss.middle());
		System.out.println(ss.deleteMiddle());
	/*	System.out.println(ss.middle());
		System.out.println(ss.pop());
		System.out.println(ss.middle());
		ss.pop();
		ss.display();
		System.out.println(ss.middle());
		ss.pop();
		System.out.println(ss.middle());*/
	}
}

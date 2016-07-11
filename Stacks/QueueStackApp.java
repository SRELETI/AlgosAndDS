
public class QueueStackApp {
	public static void main(String args[])
	{
		StackQueue sq = new StackQueue();
		sq.push2(5);
		sq.push2(4);
		sq.push2(3);
		sq.push2(2);
		sq.push2(1);
		System.out.println(sq.pop2());
		System.out.println(sq.pop2());
		System.out.println(sq.pop2());
		System.out.println(sq.pop2());
		System.out.println(sq.pop2());
	}
}

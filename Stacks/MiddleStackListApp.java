
public class MiddleStackListApp {
	public static void main(String args[])
	{
		MiddleStackList msl = new MiddleStackList();
		msl.push(4);
		msl.push(3);
		msl.push(5);
		msl.push(6);
		msl.push(8);
		msl.pop();
		msl.pop();
		
		System.out.println(msl.getMiddle());
	}
}

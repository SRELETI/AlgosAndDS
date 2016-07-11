
public class StackReverseMain {
	public static void main(String args[])
	{
		StackReverse sr = new StackReverse(4);
		sr.push(4);
		sr.push(3);
		sr.push(2);
		sr.push(1);
		sr.display();
		sr.reverse();
		sr.display();
	}
}

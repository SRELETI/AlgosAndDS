
public class LinkStackApp {
	public static void main(String args[])
	{
		LinkStack ls = new LinkStack();
		ls.push(5);
		ls.push(4);
		ls.push(3);
		ls.pop();
		ls.pop();
		ls.pop();
		ls.pop();
		ls.display();
	}
	
}

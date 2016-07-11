
public class LeftViewApp {

	public static void main(String args[])
	{
		LeftView l = new LeftView();
		
		l.head = new TreePrint(12);
		l.head.left = new TreePrint(10);
		l.head.right = new TreePrint(30);
		l.head.right.left = new TreePrint(25);
		l.head.right.right = new TreePrint(40);
		
		l.left();
	}
}


public class LCABTApp {

	public static void main(String args[])
	{
		LCABT l = new LCABT();
		
		l.head = new TreePrint(1);
		l.head.left = new TreePrint(2);
		l.head.right = new TreePrint(3);
		
		l.head.left.left = new TreePrint(4);
		l.head.left.right = new TreePrint(5);
		
		l.printLCA(6, 5);
	}
}

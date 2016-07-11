
public class VerticalPrintHashMapApp {
	
	public static void main(String args[])
	{
		VerticalPrintHashMap v = new VerticalPrintHashMap();
		v.head = new TreePrint(1);
		v.head.left = new TreePrint(2);
		v.head.right = new TreePrint(3);
		v.head.left.left = new TreePrint(4);
		v.head.left.right = new TreePrint(5);
		v.head.right.left = new TreePrint(6);
		v.head.right.right = new TreePrint(7);
		v.head.right.left.right = new TreePrint(8);
		v.head.right.right.right = new TreePrint(9);
		
		v.printVertical();
	}
}


public class LeafNodesSameApp {

	public static void main(String args[])
	{
		LeafNodesSame l = new LeafNodesSame();
		
		l.head = new TreePrint(1);
	//	l.head.left = new TreePrint(2);
	//	l.head.right = new TreePrint(3);
	//	l.head.right.left = new TreePrint(4);
		System.out.println(l.leafCheck(l.head));
	//	l.leafNode();
	}
}


public class LevelLeafApp {

	public static void main(String args[])
	{
		LevelLeaf l = new LevelLeaf();
		
		l.head = new TreePrint(1);
	//	l.head.left = new TreePrint(2);
		l.head.right = new TreePrint(3);
	//	l.head.left.left = new TreePrint(4);
		l.head.right.left = new TreePrint(5);
		l.head.right.left.left = new TreePrint(6);
		
		l.findLeaf();
	}
}

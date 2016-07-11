
public class LeafLevelItApp {

	public static void main(String args[])
	{
		LeafLevelIt i = new LeafLevelIt();
		
		i.head = new TreePrint(1);
		i.head.left = new TreePrint(2);
		i.head.right = new TreePrint(3);
		i.head.left.left = new TreePrint(4);
		
		i.head.right.left = new TreePrint(5);
		i.head.right.right = new TreePrint(6);
		
		i.head.right.right.right = new TreePrint(8);
		i.head.right.left.right = new TreePrint(7);
		i.head.right.left.right.left = new TreePrint(9);
		
		i.head.right.right.right.right = new TreePrint(10);
		
		i.head.right.right.right.right.left = new TreePrint(11);
		
		i.leaf(i.head);
	}
}

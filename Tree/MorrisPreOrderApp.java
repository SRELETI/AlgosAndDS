
public class MorrisPreOrderApp {

	public static void main(String args[])
	{
		MorrisPreOrder m = new MorrisPreOrder();
		
		m.head = new TreePrint(1);
		m.head.left = new TreePrint(2);
		m.head.right = new TreePrint(3);
		
		m.head.left.left = new TreePrint(4);
		m.head.left.right = new TreePrint(5);
		
		m.head.right.left= new TreePrint(6);
		m.head.right.right = new TreePrint(7);
		
		m.head.left.left.left = new TreePrint(8);
		m.head.left.left.right = new TreePrint(9);
		
		m.head.left.right.left = new TreePrint(10);
		m.head.left.right.right = new TreePrint(11);
		
		m.Morris(m.head);
		
		System.out.println();
		
		m.morris_inorder(m.head);
		
		
	}
}

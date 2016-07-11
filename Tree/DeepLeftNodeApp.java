
public class DeepLeftNodeApp {

	
	public static void main(String args[])
	{
		DeepLeftNode d = new DeepLeftNode();
		
		d.head = new TreePrint(1);
		d.head.left = new TreePrint(2);
		d.head.left.left = new TreePrint(4);
		
		d.head.right = new TreePrint(3);
		d.head.right.left = new TreePrint(5);
		d.head.right.right = new TreePrint(6);
		d.head.right.left.right = new TreePrint(7);
		d.head.right.left.right.left = new TreePrint(9);
		
		d.head.right.right.right = new TreePrint(8);
		d.head.right.right.right.right = new TreePrint(9);
		
		d.calc();
	}
}

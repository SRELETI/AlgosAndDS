
public class KdistanceApp {

	public static void main(String args[])
	{
		Kdistance k = new Kdistance();
		
		k.head = new TreePrint(1);
		k.head.left = new TreePrint(2);
		k.head.right = new TreePrint(3);
		
		k.head.left.left = new TreePrint(4);
		k.head.left.right = new TreePrint(5);
		
		k.head.right.left = new TreePrint(6);
		k.head.right.left.right = new TreePrint(8);
		
		k.head.right.right = new TreePrint(7);
		
		k.kdis(1);
	}
}

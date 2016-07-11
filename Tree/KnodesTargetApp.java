
public class KnodesTargetApp {

	public static void main(String args[])
	{
		KnodeTarget k = new KnodeTarget();
		
		k.head = new TreePrint(20);
		
		k.head.left = new TreePrint(8);
		
		k.head.right = new TreePrint(22);
		
		k.head.left.left = new TreePrint(4);
		
		k.head.left.right = new TreePrint(12);
		k.head.left.right.left = new TreePrint(10);
		k.head.left.right.right = new TreePrint(14);
		
		k.target = k.head.left.right.right;
		
		k.print(3);
	}
	
}

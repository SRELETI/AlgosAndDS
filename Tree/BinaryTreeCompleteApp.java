
public class BinaryTreeCompleteApp {

	public static void main (String args[])
	{
		BinaryTreeComplete b = new BinaryTreeComplete();
		
		b.head = new TreePrint(1);
	//	b.head.left = new TreePrint(2);
		b.head.right = new TreePrint(3);
		
		System.out.print(b.check(b.head));
	}
}


public class ReverseAlternateApp {
	
	public static void main(String args[])
	{
		ReverseAlternate r = new ReverseAlternate();
		r.head = new TreePrint(1);
		r.head.left = new TreePrint(2);
		r.head.right = new TreePrint(3);
		r.head.left.left = new TreePrint(4);
		r.head.left.right = new TreePrint(5);
		r.head.right.left = new TreePrint(6);
		r.head.right.right = new TreePrint(7);
		r.head.left.left.left = new TreePrint (8);
		r.head.left.left.right = new TreePrint(9);
		r.head.left.right.left = new TreePrint(10);
		r.head.left.right.right = new TreePrint (11);
		
		r.head.right.left.left = new TreePrint (12);
		r.head.right.left.right = new TreePrint(13);
		r.head.right.right.left = new TreePrint(14);
		r.head.right.right.right = new TreePrint (15);
		r.reverse();
	}
}

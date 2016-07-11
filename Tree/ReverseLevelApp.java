
public class ReverseLevelApp {

	public static void main(String args[])
	{
		ReverseLevelorder r = new ReverseLevelorder();
		
		r.head = new TreePrint(1);
		r.head.left = new TreePrint(2);
		r.head.right = new TreePrint(3);
		r.head.left.left = new TreePrint(4);
		r.head.left.right = new TreePrint(5);
		
	//	r.getLevelReverse();
		
		r.reversePrint();
	}
}


public class MaxLeafSumApp {

	public static void main(String args[])
	{
		MaxLeafSum m = new MaxLeafSum();
		
		m.head = new TreePrint(10);
		m.head.left = new TreePrint(-2);
		m.head.right = new TreePrint(7);
		m.head.left.left = new TreePrint(8);
		m.head.left.right = new TreePrint(-4);
		
		m.maxLeaf();
	}
}

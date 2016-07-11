
public class ConvertTreeApp {

	public static void main(String args[])
	{
		ConvertTree ct = new ConvertTree();
		
		ct.head = new TreePrint(10);
		ct.head.left = new TreePrint(-2);
		ct.head.right = new TreePrint(6);
		ct.head.left.left = new TreePrint(8);
		ct.head.left.right = new TreePrint(-4);
		ct.head.right.left = new TreePrint(7);
		ct.head.right.right = new TreePrint(5);
		
		ct.isSumTree();
	}
}

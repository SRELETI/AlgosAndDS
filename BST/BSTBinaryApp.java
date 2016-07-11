
public class BSTBinaryApp {

	public static void main(String args[])
	{
		BSTBinary b = new BSTBinary();
		
		b.insert(3);
		b.insert(2);
		b.insert(5);
		b.insert(1);
		b.head.left.right = new TreePrint(7);
		
		b.isBST();
		b.isRecBST();
		
		b.isBSTArr();
		b.isBSTTemp();
	}
}

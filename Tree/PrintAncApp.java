
public class PrintAncApp {

	public static void main(String args[])
	{
		PrintAnc p = new PrintAnc();
		
		p.head = new TreePrint(1);
		p.head.left = new TreePrint(2);
		p.head.right = new TreePrint(3);
		p.head.left.right = new TreePrint(4);
		p.head.left.right.right = new TreePrint(5);
		
		p.printanc(6);
	}
}

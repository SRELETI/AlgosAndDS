
public class LISApp {

	public static void main(String args[])
	{
		LIS s = new LIS();
		
		s.first = new TreePrintDP(10);
		s.first.left = new TreePrintDP(20);
		s.first.right = new TreePrintDP(30);
		s.first.left.left = new TreePrintDP(40);
		s.first.left.right = new TreePrintDP(50);
		s.first.right.right = new TreePrintDP(60);
		s.first.left.right.left = new TreePrintDP(70);
		s.first.left.right.right = new TreePrintDP(80);
		
		s.head = new TreePrint(10);
		s.head.left = new TreePrint(20);
		s.head.right = new TreePrint(30);
		s.head.left.left = new TreePrint(40);
		s.head.left.right = new TreePrint(50);
		s.head.right.right = new TreePrint(60);
		s.head.left.right.left = new TreePrint(70);
		s.head.left.right.right = new TreePrint(80);
		
		s.cal();
		
		s.mem_cal();
		
	}
}

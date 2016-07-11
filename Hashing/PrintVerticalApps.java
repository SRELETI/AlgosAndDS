
public class PrintVerticalApps {

	public static void main(String args[])
	{
		PrintVertical p = new PrintVertical();
		
		p.head = new TreePrint(1);
		p.head.left = new TreePrint(2);
		p.head.right = new TreePrint(3);
		p.head.left.left = new TreePrint(4);
		p.head.left.right = new TreePrint(5);
		
		p.head.right.left = new TreePrint(6);
		p.head.right.right = new TreePrint(7);
		
		p.head.right.left.right = new TreePrint(8);
		p.head.right.right.right = new TreePrint(9);
		
	//	p.printVert(p.head);
		
		
		int[] arr1={1,4,2};
		int[] arr2={1,4,4,2};
		
		System.out.println(p.checkSubset(arr1, arr2));
	}
}

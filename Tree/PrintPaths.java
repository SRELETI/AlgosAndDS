
public class PrintPaths {

	private TreeInt root;
	
	public PrintPaths () {
		root = null;
	}
	
	public void printPath(TreeInt temp, int[] arr, int i) {
		if(temp == null)
			return;
		arr[i++] = temp.data;
		if(temp.left==null && temp.right==null)
		{
			printArray(arr,i);
			return;
		}
		printPath(temp.left,arr,i);
		printPath(temp.right,arr,i);
		
	}
	
	private void printArray(int[] arr, int end) {
		for(int i=0;i<end;i++) 
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	
	public static void main(String args[]) {
		PrintPaths p = new PrintPaths();
		p.root = new TreeInt(10);
		p.root.left = new TreeInt(8);
		p.root.right = new TreeInt(2);
		p.root.left.left = new TreeInt(3);
		p.root.left.right = new TreeInt(5);
		p.root.right.left = new TreeInt(2);
		
		p.printPath(p.root, new int[100], 0);
	}
}

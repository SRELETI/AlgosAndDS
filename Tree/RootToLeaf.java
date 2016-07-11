import java.util.Arrays;


public class RootToLeaf {

	private TreeInt root;
	
	public RootToLeaf() {
		root = null;
	}
	private void printArray(int[] arr, int i) {
		for(int k=0;k<i;k++)
			System.out.print(arr[k]+" ");
		System.out.println();
	}
	public void rootToleaf(TreeInt temp, int[] arr, int i)
	{
		if(temp==null)
		{
			return;
		}
		arr[i++] = temp.data;
		if(temp.left==null && temp.right==null)
		{
			printArray(arr,i);
			return;
		}
		
		rootToleaf(temp.left,arr,i);
		rootToleaf(temp.right,arr,i);
	}
	
	public static void main(String args[]) {
		RootToLeaf r = new RootToLeaf();
		r.root = new TreeInt(1);
		r.root.left = new TreeInt(2);
		r.root.right = new TreeInt(3);
		r.root.left.left = new TreeInt(4);
	//	r.root.left.right = new TreeInt(5);
		int[] arr = new int[20]; 
		r.rootToleaf(r.root, arr, 0);
	}
}

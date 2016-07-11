class Wrapper_max {
	int count=0;
}
public class MaxWidth {

	private TreeInt root;
	
	public MaxWidth() {
		root = null;
	}
	
	public void maxWidth(TreeInt temp) {
		if(temp==null)
			return;
		Wrapper_max max = new Wrapper_max();
		int height = getheight(temp);
		int count=0;
		for(int i=0;i<height;i++)
		{
			max.count=0;
			findMax(temp,i,max);
			if(max.count>count)
				count = max.count;
		}
		System.out.println(count);
	}
	
	private void findMax(TreeInt temp, int k,Wrapper_max max) {
		if(temp==null)
			return;
		if(k==0)
		{
			max.count++;
			return;
		}
		findMax(temp.left,k-1,max);
		findMax(temp.right,k-1,max);
	}
	private int getheight(TreeInt temp) {
		if(temp == null)
			return 0;
		if(temp.left==null && temp.right == null)
			return 1;
		int left = getheight(temp.left);
		int right = getheight(temp.right);
		return Math.max(left, right)+1;
	}
	private void findMaxWidth(TreeInt temp, int[] arr, int i) {
		if(temp == null)
			return;
		arr[i]++;
		if(temp.left==null && temp.right==null)
			return;
		findMaxWidth(temp.left,arr,i+1);
		findMaxWidth(temp.right,arr,i+1);
	}
	
	private void findArrMax(int[] arr) {
		if(arr.length==0)
			return;
		int max = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>max)
				max = arr[i];
		}
		System.out.println(max);
	}
	
	public static void main(String args[]) {
		MaxWidth m = new MaxWidth();
		m.root = new TreeInt(1);
		m.root.left = new TreeInt(2);
		m.root.right = new TreeInt(3);
		m.root.left.left = new TreeInt(4);
		m.root.left.right = new TreeInt(5);
		m.root.right.right = new TreeInt(8);
		m.root.right.right.left = new TreeInt(6);
		m.root.right.right.right = new TreeInt(7);
		m.root.left.left.left = new TreeInt(6);
		m.root.left.left.right = new TreeInt(7);
		m.maxWidth(m.root);
		int[] arr = new int[m.getheight(m.root)];
		m.findMaxWidth(m.root, arr, 0);
		m.findArrMax(arr);
	}
}

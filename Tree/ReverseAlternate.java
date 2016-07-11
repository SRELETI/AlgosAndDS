import java.util.Arrays;


public class ReverseAlternate {

	public TreePrint head;
	
	public ReverseAlternate()
	{
		head = null;
	}
	private class Wrapper
	{
		int length = 0;
	}
	public void reverse()
	{
		System.out.println("before the reversing ");
		levelOrder(head);
		System.out.println();
		int[] arr = new int[100];
		Wrapper h = new Wrapper();
		findInorder(head,arr,h,0);
	//	System.out.println(Arrays.toString(arr));
	//  System.out.println(h.length);
		Wrapper s = new Wrapper();
		reverse(arr,h.length);
	//	System.out.println(Arrays.toString(arr));
		
		modInorder(head,arr,s,0);
		System.out.println("After reversing ");
		levelOrder(head);
	}
	
	private void levelOrder(TreePrint node)
	{
		if(node == null)
			return;
		QueueArr q = new QueueArr(20);
		while(node!=null)
		{
			System.out.print(node.data+" ");
			if(node.left != null)
				q.enqueue(node.left);
			if(node.right!=null)
				q.enqueue(node.right);
			node = q.dequeue();
		}
	}
	
	private void modInorder(TreePrint node, int[] arr, Wrapper h, int level)
	{
		if(node == null)
			return;
		modInorder(node.left, arr, h, level+1);
		if(level%2 == 1)
			node.data = arr[h.length++];
		
		modInorder(node.right, arr, h, level+1);
	}
	
	private void findInorder(TreePrint node, int[] arr, Wrapper h, int level)
	{
		if(node == null)
			return;
		findInorder(node.left,arr,h,level+1);
		if(level%2==1)
			arr[h.length++]=node.data;
		findInorder(node.right,arr,h,level+1);
	}
	
	private void reverse(int[] arr, int length)
	{
		int left = 0;
		int right =length-1;
		while(left<right)
		{
			int temp =arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	
}

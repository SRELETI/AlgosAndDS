import java.util.Arrays;


public class CheckTriplet {

	public TreePrint head;
	
	public CheckTriplet()
	{
		head = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head == null)
		{
			head = newNode;
			return;
		}
		TreePrint parent;
		TreePrint temp = head;
		while(temp!=null)
		{
			parent = temp;
			if(value<temp.data)
			{
				temp = temp.left;
				if(temp == null)
				{
					parent.left = newNode;
					return;
				}
			}
			else
			{
				temp = temp.right;
				if(temp == null)
				{
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	private class Wrapper
	{
		int size = 0;
	}
	public boolean check(TreePrint node)
	{
		if(node == null)
			return false;
		int[] arr = new int[20];
		Wrapper s = new Wrapper();
		inorder(node,arr,s);
		System.out.println(Arrays.toString(arr));
		return checkArr(arr,s);
	}
	
	private boolean checkArr(int[] arr,Wrapper s)
	{
		
	//	System.out.println(Arrays.toString(arr));
		for(int i=0;i<s.size-2;i++)
		{
			int j=i+1;
			int k =s.size-1;
			while(j<k)
			{
				if(arr[i]+arr[j]+arr[k] == 0)
				{
					System.out.println("Triplet found "+ arr[i]+" "+arr[j]+" "+arr[k]);
					return true;
				}
				else if (arr[i]+arr[j]+arr[k]<0)
					j++;
				else
					k--;
			}
		}
		return false;
	}
	
	private void inorder(TreePrint node, int[] arr, Wrapper s)
	{
		if(node!=null)
		{
			inorder(node.left,arr,s);
			arr[s.size] = node.data;
			s.size = s.size+1;
			inorder(node.right,arr,s);
		}
	}
	
	public static void main(String args[])
	{
		CheckTriplet c = new CheckTriplet();
		
		c.insert(6);
		c.insert(-13);
		c.insert(14);
		c.insert(-8);
		c.insert(13);
		c.insert(15);
		c.insert(7);
		
		System.out.println(c.check(c.head));
	}
}

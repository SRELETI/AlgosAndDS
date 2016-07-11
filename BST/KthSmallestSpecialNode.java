
public class KthSmallestSpecialNode {

	public TreeCount head;
	
	public KthSmallestSpecialNode()
	{
		head = null;
	}
	
	public void insert(int value)
	{
		TreeCount newNode = new TreeCount(value);
		if(head == null)
		{
			head = newNode;
			return;
		}
		else
		{
			TreeCount parent;
			TreeCount temp = head;
			while(temp!=null)
			{
				parent = temp;
				if(value<temp.data)
				{
					parent.count++;
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
	}
	
	public void kthsmall(TreeCount node, int k)
	{
		if(node == null)
			return;
		int result =-1;
		while(node!=null)
		{
			if(node.count+1==k)
			{
				result = node.data;
				System.out.println(result);
				return;
			}
			else if(k>node.count+1)
			{
				k = k - (node.count+1);
				node = node.right;
			}
			else
			{
				node = node.left;
			}
		}
	}
	
	public static void main(String args[])
	{
		KthSmallestSpecialNode k = new KthSmallestSpecialNode();
		
		k.insert(20);
		k.insert(22);
		k.insert(8);
		k.insert(4);
		k.insert(12);
		k.insert(10);
		k.insert(14);
		
	//	System.out.println(k.head.count);
		
		k.kthsmall(k.head, 7);
	}
}

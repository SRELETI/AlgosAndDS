
public class PrintedSorted {

	public TreePrint head;
	
	public PrintedSorted()
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
	
	public TreePrint inorderSuc(TreePrint node,int key, TreePrint suc)
	{
		if(node == null)
			return null;
		if(node.data == key)
		{
			if(node.right!=null)
			{
				TreePrint temp = node.right;
				while(temp.right!=null)
					temp = temp.right;
				suc = temp;
			}
		}
		if(key<node.data)
		{
			suc = node;
			node = inorderSuc(node.left,key,suc);
			if(node !=null)
			{
				suc = node;
			}
		}
		else
		{
			node = inorderSuc(node.right,key,suc);
			if(node!=null)
				suc = node;
		}
		return suc;
	}
	public void printSorted(int[] arr, int start, int end)
	{
		if(start>end)
			return;
		printSorted(arr,start*2+1,end);
		System.out.print(arr[start]+" ");
		printSorted(arr,start*2+2,end);
	}
	
	private TreePrint min(TreePrint node)
	{
		if(node == null)
			return null;
		while(node.left!=null)
			node = node.left;
		return node;
	}
	public TreePrint suc(TreePrint root, TreePrint node)
	{
		if(node.right!=null)
			return min(node.right);
		TreePrint suc = null;
		while(root!=null)
		{
			if(node.data<root.data)
			{
				suc = root;
				root = root.left;
			}
			else if(node.data>root.data)
				root = root.right;
			else
				break;
		}
		return suc;
	}
	
	private class Wrapper
	{
		int value=0;
	}
	public void inorder(TreePrint node, int k, Wrapper count)
	{
		if(node!=null)
		{
			inorder(node.left,k,count);
			count.value++;
			if(count.value==k)
				System.out.println(node.data+" ");
			inorder(node.right,k,count);
		}
	}
	
	public void reverseInorder(TreePrint node, int k, Wrapper count)
	{
		if(node!=null)
		{
			reverseInorder(node.right,k,count);
			count.value++;
			if(count.value==k)
			{
				System.out.println(node.data+" ");
			}
			reverseInorder(node.left,k,count);
		}
	}
	public static void main(String args[])
	{
		PrintedSorted p = new PrintedSorted();
		
		p.insert(20);
		p.insert(22);
	//	p.insert(35);
		p.insert(8);
		p.insert(4);
		p.insert(12);
		p.insert(10);
		p.insert(14);
		Wrapper k = p.new Wrapper();
	//	p.inorder(p.head, 8, s);
		p.reverseInorder(p.head, 5, k);
	/*	TreePrint res = p.suc(p.head, p.head.right);
		System.out.println(res == null ? null : res.data);
		TreePrint result = p.inorderSuc(p.head, 7, null);
		System.out.println(result == null ? null : result.data);
		int[] arr = {4,2,5,1,3};
		*/
	//	p.printSorted(arr, 0, arr.length-1);
	}
}

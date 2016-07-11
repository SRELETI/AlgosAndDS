import java.util.Stack;


public class TreePrintInter {
	
	private TreePrint first;
	
	public TreePrintInter()
	{
		first=null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(first==null)
		{
			first=newNode;
			return;
		}
		TreePrint parent;
		TreePrint current=first;
		while(true)
		{
			parent=current;
			if(value<current.data)
			{
				current=current.left;
				if(current==null)
				{
					parent.left=newNode;
					return;
				}
			}
			else
			{
				current=current.right;
				if(current==null)
				{
					parent.right=newNode;
					return;
				}
			}
		}
	}
	
	
	public TreePrint find(int value)
	{
		TreePrint current=first;
		if(current==null)
			return null;
		while(current.data!=value)
		{
			if(value<current.data)
			{
				current=current.left;
			}
			else
				current=current.right;
			if(current==null)
				return null;
		}
		return current;
	}
	
	public void printPaths()
	{
		int[] arr = new int[100];
		int len=0;
		printPath(first,arr,len);
	}
	
	public void printPath(TreePrint temp,int[] arr,int len)
	{
		if(temp==null)
			return;
		
		arr[len]=temp.data;
		len++;
		if(temp.left==null && temp.right==null)
			printArray(arr,len);
		else
		{
			printPath(temp.left,arr,len);
			printPath(temp.right,arr,len);
		}
	}
	
	public void printArray(int[] arr, int leng)
	{
		for(int i=0;i<leng;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public void display(TreePrint node)
	{
		TreePrint cur = node;
		while(cur.right!=node)
		{
			cur.display();
			cur=cur.right;
		}
		System.out.print(cur.data);
	}
	public TreePrint listConvert()
	{
		TreePrint result=listConversion(first);
		display(result);
		return result;
	}
	
	public void join(TreePrint one, TreePrint two)
	{
		one.right=two;
		two.left=one;
	}
	private TreePrint append(TreePrint one, TreePrint two)
	{
		if(one==null)
			return two;
		if(two==null)
			return one;
		TreePrint last = one.left;
		TreePrint last2= two.left;
		join(last,two);
		join(last2,one);
		return one;
	}
	private TreePrint listConversion(TreePrint head)
	{
		if(head==null)
			return null;
		TreePrint left=listConversion(head.left);
		TreePrint right=listConversion(head.right);
		
		head.left=head;
		head.right=head;
		left=append(left,head);
		left=append(left,right);
		return left;
	}
	
	public int height(TreePrint head)
	{
		if(head==null)
			return 0;
		int hh = height(head.left);
		int rr = height(head.right);
		if(hh>rr)
			return hh+1;
		else
			return rr+1;
	}
	
	public void levelOrder()
	{
		int height = height(first);
		//System.out.println(height);
		for(int i=1;i<=height;i++)
			levelOrderPrint(first,i);
	}
	
	public void levelOrderPrint(TreePrint head, int level)
	{
		if(head==null)
			return;
		if(level==1)
			System.out.print(head.data+" ");
		else
		{
			levelOrderPrint(head.left,level-1);
			levelOrderPrint(head.right,level-1);	
		}
	}
	
	public void levelOrderPrinting()
	{
		levelOrderPrints(first);
	}
	
	public void levelOrderPrints(TreePrint head)
	{
		QueueArr qa = new QueueArr(10);
		TreePrint temp = head;
		while(temp!=null)
		{
			System.out.println(temp.data);
			if(temp.left!=null)
				qa.enqueue(temp.left);
			if(temp.right!=null)
				qa.enqueue(temp.right);
			temp=qa.dequeue();
		}
	}
	
	public void leafNodes()
	{
		int count = leafNode(first);
		System.out.println("No of leaf nodes "+ count);
	}
	
	public int leafNode(TreePrint head)
	{
		if(head==null)
			return 0;
		if(head.left==null && head.right==null)
			return 1;
		else
			return leafNode(head.left)+leafNode(head.right);
	}
	
	public void spiral()
	{
		int height = height(first);
		boolean order =false;
		for (int i=1;i<=height;i++)
		{
			printSpiral(first,i,order);
			if(order==false)
				order=true;
			else
				order=false;
		}
	}
	public void printSpiral(TreePrint head, int level, boolean order)
	{
		if(head==null)
			return;
		if(level==1)
		{
			System.out.print(head.data);
		}
		else
		{
			if(order==true)
			{
				printSpiral(head.left,level-1,order);
				printSpiral(head.right,level-1,order);
			}
			else
			{
				printSpiral(head.right,level-1,order);
				printSpiral(head.left,level-1,order);
			}
		}
	}
	
	
	public void spiral_iterative()
	{
		spiralOrder_iterative(first);
	}
	
	public void spiralOrder_iterative(TreePrint head)
	{
		if(head==null)
			return;
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		s1.push(head);
		while(!s1.isEmpty() || s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				TreePrint temp = (TreePrint) s1.pop();
				System.out.print(temp.data+" ");
				if(temp.right!=null)
				{
					s2.push(temp.right);
				}
				if(temp.left!=null)
				{
					s2.push(temp.left);
				}
			}
			while(!s2.isEmpty())
			{
				TreePrint temp = (TreePrint) s2.pop();
				System.out.print(temp.data+" ");
				if(temp.left!=null)
					s1.push(temp.left);
				if(temp.right!=null)
					s1.push(temp.right);
			}
		}
	}
}

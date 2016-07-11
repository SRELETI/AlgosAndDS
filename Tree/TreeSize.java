import java.util.Stack;


public class TreeSize {
	private TreeInorder root;
	
	public TreeSize()
	{
		root=null;
	}
	
	public void insert(int value)
	{
		TreeInorder newNode = new TreeInorder(value);
		if(root == null)
		{
			root = newNode;
		}
		else
		{
			TreeInorder parent = root;
			TreeInorder current = root;
			while(current!=null)
			{
				parent=current;
				if(value<current.key)
				{
					current=current.lchild;
					if(current==null)
					{
						parent.lchild=newNode;
						return;
					}
				}
				else
				{
					current=current.rchild;
					if(current==null)
					{
						parent.rchild=newNode;
						return;
					}
				}
			}
		}
	}
	
	public int call_size()
	{
		return size(root);
	}
	public int size(TreeInorder temp)
	{
		if(temp==null)
			return 0;
		int size2 = size(temp.lchild);
		int size3 = size(temp.rchild);
		return size2+size3+1;
	}
	
	public int size_it()
	{
		TreeInorder current = root;
		Stack s = new Stack();
		int count=0;
		while(true)
		{
			if(current!=null)
			{
				s.push(current);
				current=current.lchild;
			}
			else
			{
				if(!s.isEmpty())
				{
					current=(TreeInorder) s.pop();
					count++;
					current=current.rchild;
				}
				else
				{
					return count;
				}
			}
		}
	}
	
	public int depth_fun()
	{
		return depth(root);
	}
	public int depth(TreeInorder temp)
	{
		if(temp==null)
			return 0;
		return Math.max(depth(temp.lchild),depth(temp.rchild))+1;
	}
	
	public void delete()
	{
		root=deleteNode(root);
		if(root==null)
			System.out.println("Success");
	}
	public TreeInorder deleteNode(TreeInorder temp)
	{
		if(temp==null)
			return null;
		deleteNode(temp.lchild);
		deleteNode(temp.rchild);
		System.out.print(temp.key+" ");
		temp=null;
		return temp;
	}
}

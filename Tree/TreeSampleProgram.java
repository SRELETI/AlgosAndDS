
public class TreeSampleProgram {
	private TreeSample root;
	
	public TreeSampleProgram()
	{
		root=null;
	}
	
	public TreeSample find(int key)
	{
		TreeSample current = root;
		if(current.key==key)
		{
			return current;
		}
		else
		{
			while(current.key!=key)
			{
				if(current.key>key)
				{
					current=current.lchild;
				}
				else
					current=current.rchild;
					if(current==null)
						return null;
			}
		}
		return current;
	}
	
	public void insert(int key, int value)
	{
		TreeSample newNode = new TreeSample(key,value);
		if(root==null)
		{
			root=newNode;
			return;
		}
		else
		{
			TreeSample current=root;
			TreeSample parent;
			while(true)
			{
				parent=current;
				if(key<current.key)
				{
					current=parent.lchild;
					if(current==null)
					{
						parent.lchild=newNode;
						return;
					}
				}
				else
				{
					current=parent.rchild;
					if(current==null)
					{
						parent.rchild=newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inorder(TreeSample Node)
	{
		if(Node==null)
			return;
		inorder(Node.lchild);
		System.out.print(Node.key+" ");
		inorder(Node.rchild);
	}
	
	public boolean deleteNode(int key)
	{
		TreeSample current=root;
		TreeSample parent=root;
		boolean isleft = false;
		while(current.key!=key)
		{
			parent = current;
			if(current.key>key)
			{
				current=current.lchild;
				isleft=true;
			}
			else
			{
				isleft=false;
				current=current.rchild;
			}
			if(current==null)
				return false;
		}
		
		// case 1 
		if(current.lchild==null && current.rchild==null)
		{
			if(current==root)
			{
				root = null;
			}
			else if(isleft)
			{
				parent.lchild=null;
			}
			else
				parent.rchild=null;
			return true;
		}
		else if (current.rchild==null)
		{
			if(current==root)
				root=current.lchild;
			else if(isleft)
			{
				parent.lchild=current.lchild;
			}
			else
				parent.rchild=current.lchild;
			return true;
		}
		else if(current.lchild==null)
		{
			if(current==root)
				root=current.rchild;
			else if(isleft)
				parent.lchild=current.rchild;
			else
				parent.rchild=current.rchild;
			return true;
		}
		
		else
		{
			TreeSample result = getSuccessor(current);
			if(current==root)
				root = result;
			else if(isleft)
			{
				parent.lchild=result;
			}
			else
				parent.rchild=result;
			result.lchild=current.lchild;
			return true;
		}
	}
	
	public TreeSample getSuccessor(TreeSample cur)
	{
		TreeSample sucP = cur;
		TreeSample suc = cur;
		TreeSample current=cur.rchild;
		while(current!=null)
		{
			sucP = suc;
			suc = current;
			current=current.lchild;
		}
		if(suc!=cur.rchild)
		{
			sucP.lchild=suc.rchild;
			suc.rchild = cur.rchild;
		}
		return suc;
	}
	
	public TreeSample getMin()
	{
		TreeSample current = root;
		TreeSample parent = root;
		while(current!= null)
		{
			parent=current;
			current=current.lchild;
		}
		return parent;
	}
	
	public static void main(String args[])
	{
		TreeSampleProgram ts = new TreeSampleProgram();
		ts.insert(1, 1);
		ts.insert(2, 2);
		ts.insert(3, 3);
		ts.insert(4, 4);
		ts.deleteNode(2);
		ts.inorder(ts.root);
	}
}

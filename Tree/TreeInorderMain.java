import java.util.Stack;
public class TreeInorderMain {
	private TreeInorder root;
	
	public TreeInorderMain()
	{
		root = null;
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
			boolean isLeftFlag=false;
			while(true)
			{
				parent=current;
				if(value<current.key)
				{
					current=current.lchild;
					isLeftFlag=true;
				}
				else
				{
					isLeftFlag=false;
					current=current.rchild;
				}
				if(current==null)
				{
					if(isLeftFlag)
					{
						parent.lchild=newNode;
					}
					else
						parent.rchild=newNode;
					return;
				}
			}
		}
	}
	
	public void inorder(TreeInorder temp)
	{
		Stack s = new Stack();
		TreeInorder current=root;
		boolean done=false;
		while(!done)
		if(current!=null)
		{
			s.push(current);
			current=current.lchild;
		}
		else
		{
			if(s.isEmpty()== false)
			{
				current= (TreeInorder) s.pop();
				System.out.print(current.key+" ");
				current=current.rchild;
			}
			else
			{
				done=true;
			}
		}
	}
	
	public void traverse()
	{
		inorder(root);
	}
	
	
	public void preorder(TreeInorder temp)
	{
		Stack s = new Stack();
		TreeInorder current=root;
		boolean done=false;
		while(!done)
		if(current!=null)
		{
			System.out.print(current.key+" ");
			s.push(current);
			current=current.lchild;
		}
		else
		{
			if(s.isEmpty()== false)
			{
				current= (TreeInorder) s.pop();
				//int cur_value=current.key;
				current=current.rchild;
				//System.out.print(cur_value);
			}
			else
			{
				done=true;
			}
		}
	}
	
	public void traversePre()
	{
		preorder(root);
	}
	public void postorder(TreeInorder temp)
	{
		Stack s = new Stack();
		TreeInorder current=root;
		boolean done=false;
		while(!done)
		if(current!=null)
		{
			//System.out.print(current.key+" ");
			s.push(current);
			current=current.lchild;
		}
		else
		{
			if(s.isEmpty()== false)
			{
				current= (TreeInorder) s.pop();
				current=current.rchild;
			}
			else
			{
				done=true;
			}
		}
	}
	
	public void traversePost()
	{
		postorder(root);
	}
	
}

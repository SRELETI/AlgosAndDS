import java.util.Stack;


public class InorderRecNo {
	private TreePrint head;
	
	public InorderRecNo()
	{
		head = null;
	}
	
	public void insert(int value)
	{
		TreePrint newNode = new TreePrint(value);
		if(head==null)
		{
			head = newNode;
		}
		else
		{
			TreePrint parent;
			TreePrint cur = head;
			while(true)
			{
				parent = cur;
				if(value<cur.data)
				{
					cur = cur.left;
					if(cur==null)
					{
						parent.left=newNode;
						return;
					}
				}
				else
				{
					cur = cur.right;
					if(cur == null)
					{
						parent.right=newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inorder()
	{
		Stack<TreePrint> s = new Stack();
		boolean done=false;
		TreePrint temp = head;
		while(!done)
		{
			if(temp!=null)
			{
				s.push(temp);
				temp=temp.left;
			}
			else
			{
				if(!s.isEmpty())
				{
					temp=s.pop();
					System.out.print(temp.data+" ");
					temp=temp.right;
				}
				else
					done=true;
			}
		}
	}
}

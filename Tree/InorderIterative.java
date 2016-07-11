import java.util.Stack;

import com.ibm.db2.jcc.sqlj.e;


public class InorderIterative {

	private TreePrint head;
	
	public InorderIterative()
	{
		head = null;
	}
	
	public void inorder(TreePrint node)
	{
		if(node == null)
			return;
		Stack<TreePrint> s = new Stack<TreePrint>();
		boolean check=false;
		while(!check)
		{
			if(node!=null)
			{
				s.push(node);
				node = node.left;
			}
			else
			{
				if(!s.isEmpty())
				{
					node = s.pop();
					System.out.print(node.data+" ");
					node = node.right;
				}
				else
				{
					check =true;
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		InorderIterative i = new InorderIterative();
		i.head = new TreePrint(1);
		i.head.left = new TreePrint(2);
		i.head.right = new TreePrint(3);
		i.head.left.left = new TreePrint(4);
		i.head.left.right = new TreePrint(5);
		
		i.inorder(i.head);
	}
}

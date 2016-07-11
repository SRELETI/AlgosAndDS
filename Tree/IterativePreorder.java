import java.util.Stack;

import com.ibm.db2.jcc.sqlj.e;


public class IterativePreorder {

	public TreePrint head;
	
	public IterativePreorder()
	{
		head = null;
	}
	
	public void iterative(TreePrint node)
	{
		if(node == null)
			return;
		Stack<TreePrint> s = new Stack<TreePrint>();
		boolean flag = false;
		
		while(flag == false)
		{
			if(node!=null)
			{
				s.push(node);
				System.out.print(node.data+" ");
				node = node.left;
			}
			else
			{
				if(!s.isEmpty())
				{
					node =s.pop();
					node = node.right;
				}
				else
				{
					flag = true;
				}
			}
			
		}
	}
	
	
}

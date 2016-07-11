import java.util.Stack;


public class IterativePostStack {

	public TreePrint head;
	
	public IterativePostStack()
	{
		head = null;
	}
	
	public void Iterative_stack(TreePrint node)
	{
		if(node == null)
			return;
		
		Stack<TreePrint> s = new Stack<TreePrint>();
		
		do
		{
			while(node !=null)
			{
				if(node.right!=null)
					s.push(node.right);
				s.push(node);
				node = node.left;
			}
				node =s.pop();
				if(node.right !=null && !s.isEmpty() &&node.right == s.peek())
				{
					s.pop();
					s.push(node);
					node = node.right;
					
				}
				else
				{
					System.out.print(node.data+" ");
					node = null;
					
				}
		}while(!s.isEmpty());
	}
	
	
}

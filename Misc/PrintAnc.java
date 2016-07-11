import java.util.Stack;


public class PrintAnc {

	public TreePrint head;
	
	public PrintAnc()
	{
		head = null;
	}
	
	public void printanc(int key)
	{
		print(head,key);
	}
	
	private void print(TreePrint node, int key)
	{
		if(node == null)
			return;
		
		Stack<TreePrint> s = new Stack<TreePrint>();
		
		while(true)
		{
			if(node == null)
				return;
			
			while(node !=null && node.data!=key)
			{
				s.push(node);
				node = node.left;
			}
			
			if(node != null && node.data== key)
				break;
			
			if(!s.isEmpty() && s.peek().right==null)
			{
				node = s.pop();
				
				while(!s.isEmpty() && s.peek().right == node)
					node = s.pop();
			}
			node = !s.isEmpty() ? s.peek().right : null;
		}
		
		while(!s.isEmpty())
		{
			node = s.pop();
			System.out.print(node.data+" ");
		}
	}
}

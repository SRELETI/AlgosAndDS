import java.util.Stack;


public class PrintAns {

	public TreePrint head;
	
	public PrintAns()
	{
		head = null;
	}
	
	public void print(TreePrint node,int key)
	{
		if(node == null)
			return;
		Stack<TreePrint> s = new Stack<TreePrint>();
		
		while(true)
		{
			while(node!=null && node.data != key)
			{
				s.push(node);
				node = node.left;
			}
			
			if(node!=null && node.data==key)
				break;
			
			if(s.peek().right == null)
			{
				node = s.pop();
				
				while(!s.isEmpty() && s.peek().right==node)
					node = s.pop();
			}
			node = s.isEmpty() ? null: s.peek().right; 
		}
		
		while(!s.isEmpty())
		{
			node = s.pop();
			System.out.print(node.data+" ");
		}
	}
	
	public static void main(String args[])
	{
		PrintAns p = new PrintAns();
		
		p.head = new TreePrint(1);
		p.head.left = new TreePrint(2);
		p.head.right = new TreePrint(3);
		p.head.left.left = new TreePrint(4);
		p.head.left.right = new TreePrint(5);
		p.head.right.left = new TreePrint(6);
		p.head.right.right = new TreePrint(7);
		p.print(p.head, 7);
	}
}

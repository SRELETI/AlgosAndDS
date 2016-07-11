
public class IterativePostOrder {

	private TreeInt root;
	
	public IterativePostOrder() {
		root = null;
	}
	
	public void postOrder(TreeInt temp) {
		if(temp == null)
			return;
		StackTree s = new StackTree();
		while(true)
		{
			while(temp!=null) {
				if(temp.right!=null)
					s.push(temp.right);
				s.push(temp);
				temp = temp.left;
			}
			if(s.isEmpty())
				return;
			temp = s.pop();
			if(!s.isEmpty() && temp.right == s.peek())
			{
				s.pop();
				s.push(temp);
				temp = temp.right;
			}
			else
			{
				temp.display();
				temp = null;
			}
		}
		
	}
	
	public static void main(String args[]) {
		IterativePostOrder i = new IterativePostOrder();
		i.root = new TreeInt(1);
		i.root.left = new TreeInt(2);
		i.root.right = new TreeInt(3);
		i.root.left.left = new TreeInt(4);
		i.root.left.right = new TreeInt(5);
		i.root.right.left = new TreeInt(6);
		i.root.right.right = new TreeInt(7);
		
		i.postOrder(i.root);
	}
}


public class PostOrderTrav {

	private TreeInt root;
	
	public PostOrderTrav() {
		root = null;
	}
	
	public void postOrder(TreeInt temp) {
		if(temp==null)
			return;
		StackTree s1 = new StackTree();
		StackTree s2 = new StackTree();
		
		s1.push(temp);
		while(!s1.isEmpty())
		{
			temp = s1.pop();
			s2.push(temp);
			if(temp.left!=null)
				s1.push(temp.left);
			if(temp.right!=null)
				s1.push(temp.right);
		}
		
		while(!s2.isEmpty())
		{
			s2.pop().display();
		}
	}
	
	public static void main(String args[]) {
		PostOrderTrav p = new PostOrderTrav();
		p.root = new TreeInt(1);
		p.root.left = new TreeInt(2);
		p.root.right = new TreeInt(3);
		p.root.left.left = new TreeInt(4);
		p.root.left.right = new TreeInt(5);
		p.root.right.left = new TreeInt(6);
		p.root.right.right = new TreeInt(7);
		
		p.postOrder(p.root);
	}
}


public class PreOrderTraversal {

	private TreeInt root;
	
	public PreOrderTraversal() {
		root = null;
	}
	
	public void preOrder(TreeInt temp) {
		if(temp == null)
			return;
		StackTree s = new StackTree();
		s.push(temp);
		while(!s.isEmpty())
		{
			temp = s.pop();
			temp.display();
			if(temp.right!=null)
				s.push(temp.right);
			if(temp.left!=null)
				s.push(temp.left);
		}
	}
	
	public static void main(String args[]) {
		PreOrderTraversal p = new PreOrderTraversal();
		p.root = new TreeInt(10);
		p.root.left = new TreeInt(8);
		p.root.right = new TreeInt(2);
		p.root.left.left = new TreeInt(3);
		p.root.left.right = new TreeInt(5);
		p.root.right.left = new TreeInt(2);
		
		p.preOrder(p.root);
	}
}

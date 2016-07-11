
public class InorderTraversal {

	private TreeInt root;
	
	public InorderTraversal() {
		root = null;
	}
	
	public void inorder(TreeInt temp) {
		if(temp == null)
			return;
		StackTreeInt s = new StackTreeInt();
		while(true) {
			if(temp!=null)
			{
				s.push(temp);
				temp = temp.left;
			}
			else
			{
				if(s.isEmpty())
					return;
				temp = s.pop();
				temp.display();
				temp = temp.right;
			}
		}
	}
	
	public static void main(String args[]) {
		InorderTraversal i = new InorderTraversal() ;
		i.root = new TreeInt(1);
		i.root.left = new TreeInt(2);
		i.root.right = new TreeInt(3);
		i.root.left.left = new TreeInt(4);
		i.root.left.right = new TreeInt(5);
		
		i.inorder(i.root);
	}
}

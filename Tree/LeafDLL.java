
public class LeafDLL {

	private TreeInt root;
	private TreeInt head;
	
	public LeafDLL() {
		root=null;
		head=null;
	}
	
	public TreeInt leaf(TreeInt temp) {
		if(temp==null)
			return temp;
		if(temp.left==null && temp.right==null)
		{
			temp.right = head;
			if(head!=null)
				head.left = temp;
			head = temp;
			return null;
		}
		
		temp.right = leaf(temp.right);
		temp.left = leaf(temp.left);
		return temp;
	}
	
	public void inorder(TreeInt temp) {
		if(temp!=null)
		{
			inorder(temp.left);
			temp.display();
			inorder(temp.right);
		}
	}
	
	public void display(TreeInt temp) {
		while(temp!=null)
		{
			temp.display();
			temp = temp.right;
		}
	}
	
	public static void main(String args[]) {
		LeafDLL l = new LeafDLL();
		
		l.root = new TreeInt(1);
		l.root.left = new TreeInt(2);
		l.root.right = new TreeInt(3);
		l.root.left.left = new TreeInt(4);
		l.root.left.right = new TreeInt(5);
		l.root.left.left.left = new TreeInt(7);
		l.root.left.left.right = new TreeInt(8);
		
		l.root.right.right = new TreeInt(6);
		l.root.right.right.left = new TreeInt(9);
		l.root.right.right.right = new TreeInt(10);
		
		l.inorder(l.root);
		System.out.println();
		TreeInt temp = l.leaf(l.root);
		l.inorder(temp);
		System.out.println();
		l.display(l.head);
		
	}
}


public class Traversals {

	private TreeInt root;
	
	public Traversals() {
		root = null;
	}
	
	public void inorder(TreeInt temp) {
		if(temp==null)
			return;
		inorder(temp.left);
		temp.display();
		inorder(temp.right);
	}
	
	public void preorder(TreeInt temp) {
		if(temp==null)
			return;
		temp.display();
		preorder(temp.left);
		preorder(temp.right);
	}
	
	public void postorder(TreeInt temp) {
		if(temp==null)
			return;
		postorder(temp.left);
		postorder(temp.right);
		temp.display();
	}
	
	public static void main(String args[]) {
		Traversals t = new Traversals();
		t.root = new TreeInt(1);
		t.root.left = new TreeInt(2);
		t.root.right = new TreeInt(3);
		t.root.left.right = new TreeInt(5);
		t.root.left.left = new TreeInt(4);
		
		t.inorder(t.root);
		System.out.println();
		t.preorder(t.root);
		System.out.println();
		t.postorder(t.root);
	}
}

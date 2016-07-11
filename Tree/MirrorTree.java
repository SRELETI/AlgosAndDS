
public class MirrorTree {

	private TreeInt root;
	
	public MirrorTree() {
		root = null;
	}
	
	public void MirrorTree(TreeInt temp) {
		if(temp == null)
			return;
		MirrorTree(temp.left);
		MirrorTree(temp.right);
		TreeInt temp2= temp.left;
		temp.left = temp.right;
		temp.right = temp2;
	}
	public void inorder(TreeInt temp) {
		if(temp==null)
			return;
		inorder(temp.left);
		temp.display();
		inorder(temp.right);
	}
	public static void main(String args[]) {
		MirrorTree m = new MirrorTree();
		m.root = new TreeInt(1);
		m.root.left = new TreeInt(3);
		m.root.right = new TreeInt(2);
		m.root.right.left = new TreeInt(5);
		m.root.right.right = new TreeInt(4);
		
		m.inorder(m.root);
		System.out.println();
		m.MirrorTree(m.root);
		m.inorder(m.root);
	}
}

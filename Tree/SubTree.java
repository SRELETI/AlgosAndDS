
public class SubTree {

	private TreeInt root;
	private TreeInt root2;
	public SubTree() {
		root = null;
		root2 = null;
	}
	
	public boolean isSubTree(TreeInt temp, TreeInt temp2) {
		if(temp==null && temp2==null)
			return true;
		if(temp==null)
			return true;
		if(temp2==null)
			return false;
		if(temp.data==temp2.data)
			return isSubTree(temp.left,temp2.left) && isSubTree(temp.right,temp2.right);
		else
			return isSubTree(temp,temp2.left) || isSubTree(temp,temp2.right);
	}
	
	public static void main(String args[]) {
		SubTree s = new SubTree();
		s.root = new TreeInt(10);
		s.root.left = new TreeInt(4);
		s.root.right = new TreeInt(6);
		s.root.left.right = new TreeInt(30);
		
		s.root2 = new TreeInt(26);
		s.root2.left = new TreeInt(10);
		s.root2.right = new TreeInt(3);
		s.root2.left.left = new TreeInt(5);
		s.root2.left.right = new TreeInt(6);
		s.root2.left.left.right = new TreeInt(30);
		s.root2.right.right = new TreeInt(3);
		
		System.out.println(s.isSubTree(s.root, s.root2));
	}
}

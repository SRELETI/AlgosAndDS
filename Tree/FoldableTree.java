
public class FoldableTree {

	private TreeInt root;
	
	public FoldableTree() {
		root = null;
	}
	
	public boolean isFoldable(TreeInt temp) {
		if(temp == null)
			return true;
		return isSame(temp.left,temp.right);
	}
	
	private boolean isSame(TreeInt temp1, TreeInt temp2) {
		if(temp1==null && temp2==null)
			return true;
		if(temp1==null || temp2==null)
			return false;
		return isSame(temp1.left,temp2.right) && isSame(temp1.right,temp2.left);
	}
	
	public static void main(String args[]) {
		FoldableTree f = new FoldableTree();
		f.root = new TreeInt(10);
		f.root.left = new TreeInt(7);
		f.root.right = new TreeInt(15);
		f.root.left.right = new TreeInt(9);
		f.root.left.left = new TreeInt(11);
		
		System.out.println(f.isFoldable(f.root));
	}
}

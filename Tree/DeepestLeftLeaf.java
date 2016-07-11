class Wrapper_maxs {
	int val = Integer.MIN_VALUE;
	TreeInt node= null;
}
public class DeepestLeftLeaf {

	private TreeInt root;
	
	public DeepestLeftLeaf() {
		root = null;
	}
	
	public void deepest(TreeInt temp, Wrapper_maxs lev, int level, boolean isLeft) {
		if(temp == null)
			return;
		if(temp.left==null && temp.right==null && level>lev.val && isLeft==true)
		{
			lev.val = level;
			lev.node = temp;
			return;
		}
		deepest(temp.left,lev,level+1,true);
		deepest(temp.right,lev,level+1,false);
	}
	
	public static void main(String args[]) {
		DeepestLeftLeaf d = new DeepestLeftLeaf();
		d.root = new TreeInt(1);
		d.root.left = new TreeInt(2);
		d.root.right = new TreeInt(3);
		d.root.left.left =new TreeInt(4);
		d.root.right.left = new TreeInt(5);
		d.root.right.right = new TreeInt(6);
		d.root.right.left.right = new TreeInt(7);
		d.root.right.left.right.left = new TreeInt(9);
		d.root.right.right.right = new TreeInt(8);
		d.root.right.right.right.right = new TreeInt(10);
		Wrapper_maxs lev = new Wrapper_maxs();
		d.deepest(d.root, lev, 0, false);
		System.out.println(lev.node.data);
		
	}
}

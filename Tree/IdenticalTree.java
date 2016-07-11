
public class IdenticalTree {

	private TreeInt root1;
	private TreeInt root2;
	
	public IdenticalTree() {
		root1 = null;
		root2 = null;
	}
	
	public boolean isIdentical(TreeInt temp1, TreeInt temp2) {
		if(temp1==null && temp2==null)
			return true;
		if(temp1==null || temp2==null)
			return false;
		if(temp1.data!=temp2.data)
			return false;
		return isIdentical(temp1.left,temp2.left) && isIdentical(temp1.right,temp2.right);
	}
	
	public static void main(String args[]) {
		IdenticalTree i = new IdenticalTree();
		i.root1 = new TreeInt(1);
		i.root1.left =new TreeInt(2);
		i.root1.right = new TreeInt(3);
		i.root1.left.left = new TreeInt(4);
		i.root1.left.right = new TreeInt(5);
		
		i.root2 = new TreeInt(1);
		i.root2.left = new TreeInt(2);
		i.root2.right = new TreeInt(3);
		i.root2.left.left = new TreeInt(4);
	//	i.root2.left.right = new TreeInt(5);
		
		System.out.println(i.isIdentical(i.root1, i.root2));
		
	}
}

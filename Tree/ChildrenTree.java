
public class ChildrenTree {

	private TreeInt root;
	
	public ChildrenTree () {
		root = null;
	}
	
	public boolean isChildren(TreeInt temp) {
		if(temp == null)
			return true;
		if(temp.left==null && temp.right==null)
			return true;
		int left_data =0;
		int right_data = 0;
		if(temp.left!=null)
			left_data = temp.left.data;
		if(temp.right!=null)
			right_data = temp.right.data;
		if(left_data+right_data!=temp.data)
			return false;
		return isChildren(temp.left) && isChildren(temp.right);
	}
	
	public boolean isChildren_another(TreeInt temp) {
		if(temp == null)
			return true;
		if(temp.left==null && temp.right==null)
			return true;
		boolean result_left = isChildren_another(temp.left);
		boolean result_right = isChildren_another(temp.right);
		if(result_left==false || result_right==false)
			return false;
		int left_data =0;
		int right_data = 0;
		if(temp.left!=null)
			left_data = temp.left.data;
		if(temp.right!=null)
			right_data = temp.right.data;
		if(left_data+right_data!=temp.data)
			return false;
		else
			return true;
	}
	public static void main(String args[]) {
		ChildrenTree c = new ChildrenTree();
		c.root = new TreeInt(10);
		c.root.left = new TreeInt(8);
		c.root.right = new TreeInt(2);
		c.root.left.left = new TreeInt(3);
		c.root.left.right = new TreeInt(7);
		c.root.right.left = new TreeInt(2);
		System.out.println(c.isChildren_another(c.root));
		System.out.println(c.isChildren(c.root));
	}
}

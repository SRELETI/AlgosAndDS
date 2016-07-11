
public class DoubleTree {

	private TreeInt root;
	
	public DoubleTree() {
		root = null;
	}
	
	public TreeInt doubleTree(TreeInt temp) {
		if(temp == null)
			return temp;
		TreeInt left = doubleTree(temp.left);
		TreeInt right = doubleTree(temp.right);
		temp.left = new TreeInt(temp.data);
		temp.right = right;
		temp.left.left = left;
		return temp;
	}
	
	public void doubleTree_pre(TreeInt temp) {
		if(temp == null)
			return ;
		TreeInt now = temp.left;
		temp.left = new TreeInt(temp.data);
		temp.left.left = now;
		doubleTree_pre(temp.left.left);
		doubleTree_pre(temp.right);
	}
	
	public void doubleTree_in(TreeInt temp) {
		if(temp == null)
			return ;
		doubleTree_in(temp.left);
		TreeInt now = temp.left;
		temp.left = new TreeInt(temp.data);
		temp.left.left = now;
		doubleTree_in(temp.right);
	}
	
	public void inorder(TreeInt temp) {
		if(temp!=null)
		{
			inorder(temp.left);
			temp.display();
			inorder(temp.right);
		}
	}
	public static void  main(String args[]) {
		DoubleTree d = new DoubleTree();
		d.root = new TreeInt(1);
		d.root.left = new TreeInt(2);
		d.root.right = new TreeInt(3);
		d.root.left.left = new TreeInt(4);
		d.root.left.right = new TreeInt(5);
		
		d.inorder(d.root);
		System.out.println();
	//	d.doubleTree_in(d.root);
	//	d.doubleTree_pre(d.root);
		TreeInt temp = d.doubleTree(d.root);
		d.inorder(temp);
	}

} 

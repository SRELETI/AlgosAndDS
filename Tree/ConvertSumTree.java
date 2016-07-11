
public class ConvertSumTree {

	private TreeInt root;
	
	public ConvertSumTree() {
		root = null;
	}
	
	public int convert(TreeInt temp) {
		if(temp == null)
			return 0;
		int old_val=0;
		if(temp.left==null && temp.right==null)
		{
			old_val = temp.data;
			temp.data = 0;
			return old_val;
		}
		int left = convert(temp.left);
		int right = convert(temp.right);
		old_val = temp.data;
		temp.data = left+right;
		return old_val + temp.data;
	}
	
	public void inorder(TreeInt temp) {
		if(temp!=null) {
			inorder(temp.left);
			temp.display();
			inorder(temp.right);
		}
	}
	public static void main(String args[]) {
		ConvertSumTree c = new ConvertSumTree();
		c.root = new TreeInt(10);
		c.root.left = new TreeInt(-2);
		c.root.right = new TreeInt(6);
		c.root.left.left =  new TreeInt(8);
		c.root.left.right = new TreeInt(-4);
		c.root.right.left = new TreeInt(7);
		c.root.right.right = new TreeInt(5);
		
		c.inorder(c.root);
		System.out.println();
		c.convert(c.root);
		c.inorder(c.root);
		
	}
}

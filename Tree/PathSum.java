class Wrapper_path {
	int val = 0;
}
public class PathSum {

	private TreeInt root;
	
	public PathSum() {
		root = null;
	}
	
	public TreeInt path(TreeInt temp, int k, Wrapper_path sum) {
		if(temp == null)
			return temp;
		Wrapper_path left = new Wrapper_path();
		Wrapper_path right = new Wrapper_path();
		left.val = sum.val+temp.data;
		right.val = left.val;
		temp.left = path(temp.left,k,left);
		temp.right = path(temp.right,k,right);
		
		sum.val = Math.max(left.val, right.val);
		if(sum.val<k)
		{
			temp = null;
		}
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
	
	public static void main(String args[]) {
		PathSum p = new PathSum();
		p.root = new TreeInt(1);
		p.root.left = new TreeInt(2);
		p.root.right= new TreeInt(3);
		p.root.left.left = new TreeInt(4);
		p.root.left.right = new TreeInt(5);
		p.root.right.left = new TreeInt(6);
		p.root.right.right = new TreeInt(7);
		p.root.left.left.left = new TreeInt(8);
		p.root.left.left.right = new TreeInt(9);
		p.root.left.left.right.left = new TreeInt(13);
		p.root.left.left.right.right =  new TreeInt(14);
		p.root.left.left.right.right.left = new TreeInt(15);
		p.root.left.right.left = new TreeInt(12);
		p.root.right.right.left = new TreeInt(10);
		p.root.right.right.left.right = new TreeInt(11);
		
		p.inorder(p.root);
		Wrapper_path sum = new Wrapper_path();
		TreeInt temp = p.path(p.root, 45, sum);
		System.out.println();
		System.out.println(temp==null ? "null" : temp.data);
		p.inorder(temp);
	}
}

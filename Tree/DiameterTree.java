class Wrapper_latest {
		int count = 0;
	}

public class DiameterTree {

	private TreeInt root;
	
	public DiameterTree() {
		root = null;
	}
	
	private int diameter(TreeInt temp, Wrapper_latest max) {
		if(temp == null)
			return 0;
		if(temp.left==null && temp.right==null)
			return 1;
		int left = diameter(temp.left,max);
		int right = diameter(temp.right,max);
		int result = Math.max(Math.max(left, right),(left+right+1));
		if(result>max.count)
			max.count= result;
		return Math.max(left, right)+1;
	}
	
	public static void main(String args[]) {
		DiameterTree d = new DiameterTree();
		d.root = new TreeInt(1);
		d.root.left = new TreeInt(2);
		d.root.right = new TreeInt(3);
		d.root.left.left = new TreeInt(4);
		d.root.left.right = new TreeInt(5);
		d.root.left.right.left= new TreeInt(6);
		d.root.left.right.right = new TreeInt(7);
		d.root.right.right = new TreeInt(8);
		d.root.right.right.right = new TreeInt(9);
		d.root.right.right.right.right = new TreeInt(10);
		d.root.right.right.right.left = new TreeInt(11);
		d.root.right.right.right.left.left = new TreeInt(12);
		d.root.right.right.right.left.right = new TreeInt(13);
		
		Wrapper_latest max = new Wrapper_latest();
		d.diameter(d.root, max);
		System.out.println(max.count);
	}
}

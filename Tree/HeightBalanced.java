class Wrapper_ind {
	int count =0;
}
public class HeightBalanced {

	private TreeInt root;
	
	public HeightBalanced() {
		root = null;
	}
	
	public boolean heightBal(TreeInt temp, Wrapper_ind height) {
		if(temp == null)
			return true;
		if(temp.left==null && temp.right == null)
			return true;
		Wrapper_ind left = new Wrapper_ind();
		Wrapper_ind right = new Wrapper_ind();
		boolean left_hand = heightBal(temp.left,left);
		boolean right_hand = heightBal(temp.right,right);
		height.count = Math.max(left.count,right.count)+1;
		if(Math.abs(left.count-right.count)<=1 && left_hand && right_hand)
			return true;
		else
			return false;
	}
	
	public static void main(String args[]) {
		HeightBalanced h = new HeightBalanced();
		h.root = new TreeInt(1);
		h.root.left = new TreeInt(2);
		h.root.right = new TreeInt(3);
		h.root.left.left = new TreeInt(4);
		h.root.left.right = new TreeInt(5);
		h.root.left.left.left = new TreeInt(7);
	//	h.root.left.left.left.left = new TreeInt(8);
		h.root.right.left = new TreeInt(6);
		Wrapper_ind height = new Wrapper_ind();
		System.out.println(h.heightBal(h.root, height));
	}
}

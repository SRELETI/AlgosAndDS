
public class MaxDepthHeight {

	private TreeInt root;
	
	public MaxDepthHeight() {
		root = null;
	}
	
	public int depth(TreeInt temp) {
		if(temp==null)
			return 0;
		return Math.max(depth(temp.left), depth(temp.right))+1;
	}
	
	public static void main(String args[]) {
		MaxDepthHeight m = new MaxDepthHeight();
		m.root = new TreeInt(1);
		m.root.left = new TreeInt(2);
		m.root.right = new TreeInt(3);
		m.root.left.left = new TreeInt(4);
		System.out.println(m.depth(m.root));
	}
}

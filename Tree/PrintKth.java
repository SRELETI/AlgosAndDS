class Wrapper_cc {
	int val = 0;
}
public class PrintKth {

	public void print(TreeInt node, int k, Wrapper_cc count) {
		if(node ==null)
			return;
		print(node.left,k,count);
		count.val++;
		if(count.val==k) {
			System.out.print(node.data+" ");
			return;
		}
		print(node.right,k,count);
	}
	
	public static void main(String args[]) {
		PrintKth p = new PrintKth();
		TreeInt root = new TreeInt(20);
		root.left = new TreeInt(8);
		root.right = new TreeInt(22);
		root.left.left = new TreeInt(4);
		root.left.right = new TreeInt(12);
		root.left.right.left = new TreeInt(10);
		root.left.right.right = new TreeInt(14);
		Wrapper_cc count = new Wrapper_cc();
		p.print(root, 5, count);
	}
}


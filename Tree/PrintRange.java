
public class PrintRange {

	public void print(TreeInt root, int k1, int k2) {
		if(root==null)
			return;
		if(root.data>k1) {
			print(root.left,k1,k2);
		}
		if(k1<=root.data && root.data<=k2) {
			System.out.print(root.data+" ");
		}
		if(root.data<k2) {
			print(root.right,k1,k2);
		}
	}
	
	public static void main(String args[]) {
		PrintRange p = new PrintRange();
		TreeInt root = new TreeInt(20);
		root.left = new TreeInt(8);
		root.right = new TreeInt(22);
		root.left.left = new TreeInt(4);
		root.left.right = new TreeInt(12);
		p.print(root, 10, 22);
	}
}

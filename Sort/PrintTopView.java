import java.util.HashMap;


public class PrintTopView {

	public void printTop(TreeInt root, HashMap<Integer,TreeInt> hash, int hd) {
		if(root == null)
			return;
		if(hash.containsKey(hd)==false) {
			hash.put(hd,root);
			System.out.println(root.data);
		}
		printTop(root.left,hash,hd-1);
		printTop(root.right,hash,hd+1);
	}
	
	public static void main(String args[]) {
		PrintTopView p = new PrintTopView();
		TreeInt root = new TreeInt(1);
		root.left = new TreeInt(2);
		root.right = new TreeInt(3);
	//	root.left.left = new TreeInt(4);
		root.left.right = new TreeInt(4);
		root.left.right.right = new TreeInt(5);
		root.left.right.right.right = new TreeInt(6);
		HashMap<Integer,TreeInt> hash = new HashMap<Integer,TreeInt>();
		p.printTop(root, hash, 0);
	}
}

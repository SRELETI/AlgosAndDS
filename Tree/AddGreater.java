class Wrapper_val {
	int val = 0;
}
public class AddGreater {

	public void addGreater(TreeInt root, Wrapper_val prev) {
		if(root==null)
			return;
		addGreater(root.right,prev);
		prev.val +=root.data;
		root.data =prev.val;
		addGreater(root.left,prev);
	}
	
	public void display(TreeInt node) {
		if(node!=null) {
			display(node.left);
			System.out.print(node.data+" ");
			display(node.right);
		}
	}
	
	public static void main(String args[]) {
		AddGreater a = new AddGreater();
		TreeInt root = new TreeInt(50);
		root.left = new TreeInt(30);
		root.right = new TreeInt(70);
		root.left.left = new TreeInt(20);
		root.left.right = new TreeInt(40);
		root.right.left = new TreeInt(60);
		root.right.right = new TreeInt(80);
		
		a.display(root);
		Wrapper_val prev = new Wrapper_val();
		a.addGreater(root, prev);
		System.out.println();
		a.display(root);
	}
	
}

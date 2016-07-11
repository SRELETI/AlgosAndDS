
public class PrintAncestors {

	private TreeInt root;
	
	public PrintAncestors() {
		root = null;
	}
	
	public boolean printAnc(TreeInt temp, int key) {
		if(temp==null)
			return false;
		if(temp.data == key)
			return true;
		if(printAnc(temp.left,key)||printAnc(temp.right,key))
		{
			temp.display();
			return true;
		}
		else
			return false;
	}
	
	public static void main(String args[]) {
		PrintAncestors p = new PrintAncestors();
		p.root = new TreeInt(1);
		p.root.left = new TreeInt(2);
		p.root.right = new TreeInt(3);
		p.root.left.left = new TreeInt(4);
		p.root.left.right = new TreeInt(5);
		p.root.left.left.left = new TreeInt(7);
		
		p.printAnc(p.root, 3);
	}
}

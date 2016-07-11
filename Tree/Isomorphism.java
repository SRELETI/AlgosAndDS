
public class Isomorphism {

	private TreeInt root;
	private TreeInt root2;
	public Isomorphism() {
		root = null;
		root2 = null;
	}
	
	public boolean isIso(TreeInt temp1, TreeInt temp2) {
		if(temp1==null && temp2==null)
			return true;
		if(temp1==null || temp2==null)
			return false;
		if(temp1.data==temp2.data)
		{
			return (isIso(temp1.left,temp2.left) && isIso(temp1.right,temp2.right)) || (isIso(temp1.left,temp2.right) && isIso(temp1.right,temp2.left));
		}
		else 
			return false;
	}
	
	public static void main(String args[]) {
		Isomorphism i = new Isomorphism();
		i.root = new TreeInt(1);
		i.root.left = new TreeInt(2);
		i.root.right = new TreeInt(3);
		i.root.left.left = new TreeInt(4);
		i.root.left.right = new TreeInt(5);
		i.root.left.right.left = new TreeInt(7);
		i.root.left.right.right = new TreeInt(8);
		i.root.right.left = new TreeInt(6);
		
		i.root2 = new TreeInt(1);
		i.root2.left = new TreeInt(3);
		i.root2.right = new TreeInt(2);
		i.root2.left.right = new TreeInt(7);
		i.root2.right.left = new TreeInt(4);
		i.root2.right.right = new TreeInt(5);
		i.root2.right.right.left = new TreeInt(8);
		i.root2.right.right.right = new TreeInt(7);
		
		System.out.println(i.isIso(i.root, i.root2));
	}
}

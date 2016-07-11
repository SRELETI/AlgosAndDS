class Wrapper_boolean {
	boolean n1=false;
	boolean n2 = false;
}
public class CheckLCA {

	public TreeInt getLCA(TreeInt node, int n1, int n2,Wrapper_boolean check) {
		if(node==null)
			return null;
		if(node.data<n1 && node.data<n2) 
			return getLCA(node.right,n1,n2,check);
		if(node.data>n1 && node.data>n2) 
			return getLCA(node.left,n1,n2,check);
		if(node.data==n1) 
			check.n1= true;
		if(node.data==n2)
			check.n2 = true;
		return node;
	}
	
	public TreeInt lca(TreeInt node, int n1, int n2) {
		Wrapper_boolean check = new Wrapper_boolean();
		TreeInt temp = getLCA(node,n1,n2,check);
		if((check.n1==true && check.n2==true) || (check.n1 == true && isPresent(temp.right,n2)) || (check.n2==true && isPresent(temp.left,n1)) || (isPresent(temp.left,n1) && isPresent(temp.right,n2)))
				return temp;
		return null;
	}
	
	public boolean isPresent(TreeInt node, int val) {
		if(node==null) 
			return false;
		if(node.data==val) 
			return true;
		if(node.data>val) {
			return isPresent(node.left,val);
		}
		else 
			return isPresent(node.right,val);
	}
	public static void main(String args[]) {
		CheckLCA c = new CheckLCA();
		TreeInt root = new TreeInt(20);
		root.left = new TreeInt(8);
		root.right = new TreeInt(22);
		root.left.left = new TreeInt(4);
		root.left.right = new TreeInt(12);
		root.left.right.left = new TreeInt(10);
		root.left.right.right = new TreeInt(14);
		
		TreeInt temp = c.lca(root, 8, 13);
		System.out.println(temp==null?"null":temp.data);
		
	}
}

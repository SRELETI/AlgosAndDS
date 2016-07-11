
public class RootLeafSum {

	private TreeInt root;
	
	public RootLeafSum() {
		root = null;
	}
	
	public boolean isThere(TreeInt temp, int sum) {
		if(temp == null)
			return sum==0;
		sum = sum-temp.data;
		if(temp.left==null && temp.right==null)
		{
			return sum==0;
		}
		return isThere(temp.left,sum) || isThere(temp.right,sum);
	}
	
	public static void main(String args[]) {
		RootLeafSum r = new RootLeafSum();
		r.root = new TreeInt(10);
		r.root.left = new TreeInt(8);
		r.root.right = new TreeInt(2);
		r.root.left.left = new TreeInt(3);
		r.root.left.right = new TreeInt(5);
		r.root.right.left = new TreeInt(2);
		
		System.out.println(r.isThere(r.root, 15));
	}
}

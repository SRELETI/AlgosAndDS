
public class LeastCommonAnc {

	private TreeInt root;
	public LeastCommonAnc() {
		root = null;
	}
	
	
	
	public int findLCA(TreeInt temp,int n1, int n2) {
		if(temp==null)
			return -1;
		ListExampleTree h1 = new ListExampleTree();
		ListExampleTree h2 = new ListExampleTree();
		if(findLCA(temp,n1,h1) ==false || findLCA(temp,n2,h2)==false)
			return -1;
		while(h1.head!=null && h2.head!=null)
		{
			if(h1.head.data==h2.head.data)
				return h1.head.data;
			h1.head = h1.head.next;
			h2.head = h2.head.next;
		}
		return -1;
	}
	
	private boolean findLCA(TreeInt temp, int n1, ListExampleTree hs) {
		if(temp==null)
			return false;
		hs.insert(temp.data);
		if(temp.data==n1)
			return true;
		if(findLCA(temp.left,n1,hs)==true || findLCA(temp.right,n1,hs)==true)
			return true;
		hs.delete();
		return false;
	}
	
	public static void main(String args[]) {
		LeastCommonAnc l = new LeastCommonAnc();
		
		l.root = new TreeInt(1);
		l.root.left = new TreeInt(2);
		l.root.right = new TreeInt(3);
		l.root.left.left = new TreeInt(4);
		l.root.left.right = new TreeInt(5);
		l.root.right.left = new TreeInt(6);
		l.root.right.right = new TreeInt(7);
		
		System.out.println(l.findLCA(l.root, 3, 4));
	}
	
}

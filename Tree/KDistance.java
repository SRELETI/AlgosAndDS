
public class KDistance {

	private TreeInt root;
	
	public KDistance() {
		root = null;
	}
	
	public void kDistance(TreeInt temp, int k) {
		if(temp == null)
			return;
		if(k==0)
		{
			System.out.print(temp.data+" ");
			return;
		}
		kDistance(temp.left,k-1);
		kDistance(temp.right,k-1);
	}
	
	public static void main(String args[]) {
		KDistance d = new KDistance();
		d.root = new TreeInt(1);
		d.root.left = new TreeInt(2);
		d.root.right = new TreeInt(3);
		d.root.left.left = new TreeInt(4);
		d.root.left.right = new TreeInt(5);
		d.root.right.left = new TreeInt(8);
		
		d.kDistance(d.root, 2);
	}
}

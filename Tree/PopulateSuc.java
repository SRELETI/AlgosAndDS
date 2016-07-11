
public class PopulateSuc {

	private TreeConnect root;
	private TreeConnect prev;
	public PopulateSuc() {
		root = null;
	}
	
	public void populate(TreeConnect temp) {
		if(temp!=null)
		{
			populate(temp.right);
			temp.nextRight = prev;
			prev = temp;
			populate(temp.left);
		}
	}
	
	public static void main(String args[]) {
		PopulateSuc p = new PopulateSuc();
		p.root = new TreeConnect(10);
		p.root.left = new TreeConnect(8);
		p.root.right = new TreeConnect(12);
		p.root.left.left = new TreeConnect(3);
		
		p.populate(p.root);
		
		TreeConnect temp = p.root.left.left;
		
		while(temp!=null) {
			System.out.print(temp.data+" Its next "+((temp.nextRight!=null) ? temp.nextRight.data : -1)+" ,");
			temp = temp.nextRight;
		}
	}
}

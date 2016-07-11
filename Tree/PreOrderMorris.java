
public class PreOrderMorris {

	private TreeInt root;
	
	public PreOrderMorris() {
		root = null;
	}
	
	public void preOrder(TreeInt temp) {
		if(temp ==null)
			return;
		TreeInt p;
		while(temp!=null)
		{
			if(temp.left==null)
			{
				temp.display();
				temp = temp.right;
			}
			else
			{
				p = temp.left;
				while(p.right!=null && p.right!=temp)
					p = p.right;
				if(p.right==null)
				{
					p.right = temp;
					temp.display();
					temp = temp.left;
				}
				else
				{
					p.right=null;
					temp = temp.right;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		PreOrderMorris p = new PreOrderMorris();
		p.root = new TreeInt(1);
		p.root.left = new TreeInt(2);
		p.root.right = new TreeInt(3);
		
		p.root.left.left = new TreeInt(4);
		p.root.left.right = new TreeInt(5);
		
		p.root.right.left = new TreeInt(6);
		p.root.right.right = new TreeInt(7);
		
		p.root.left.left.left = new TreeInt(8);
		p.root.left.left.right = new TreeInt(9);
		
		p.root.left.right.left = new TreeInt(10);
		p.root.left.right.right = new TreeInt(11);
		
		p.preOrder(p.root);
	}
}

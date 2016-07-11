
public class ConvertChildren {

	private TreeInt root;
	
	public ConvertChildren() {
		root = null;
	}
	
	public void inorder(TreeInt temp) {
		if(temp==null)
			return;
		inorder(temp.left);
		temp.display();
		inorder(temp.right);
	}
	public TreeInt convert(TreeInt temp) {
		if(temp == null || (temp.left==null && temp.right==null))
				return temp;
		TreeInt left = convert(temp.left);
		TreeInt right = convert(temp.right);
		int left_data = 0;
		int right_data = 0;
		if(left!=null)
			left_data = left.data;
		if(right!=null)
			right_data = right.data;
		int diff = (left_data+right_data)-temp.data;
		if(diff>0)
			temp.data= temp.data+ diff;
		else
		{
			addDown(temp,-diff);
		}
		return temp;
	}
	
	public void addDown(TreeInt temp, int diff) {
		while(temp!=null) {
			if(temp.left!=null)
			{
				temp.left.data = temp.left.data+diff;
				temp = temp.left;
			}
			else if(temp.right!=null)
			{
				temp.right.data = temp.right.data+diff;
				temp = temp.right;
			}
			else 
				break;
		}
	}
	
	public static void main(String args[]) {
		ConvertChildren c = new ConvertChildren();
		c.root = new TreeInt(50);
		c.root.left = new TreeInt(7);
		c.root.right = new TreeInt(2);
		c.root.left.left = new TreeInt(3);
		c.root.left.right = new TreeInt(5);
		c.root.right.left = new TreeInt(1);
		c.root.right.right = new TreeInt(30);
		
		c.inorder(c.root);
		System.out.println();
		TreeInt temp = c.convert(c.root);
		c.inorder(temp);
		System.out.println();
		
		
		
	}
}

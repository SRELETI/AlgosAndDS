
public class InorderOpt {

	private TreeInt root;
	
	public InorderOpt() {
		root = null;
	}
	
	public void inorder(TreeInt temp) {
		if(temp==null)
			return;
		while(true)
		{
			if(temp==null)
				break;
			if(temp.left==null)
			{
				System.out.print(temp.data+" ");
				temp = temp.right;
			}
			else
			{
				TreeInt now = temp.left;
				while(now.right!=null && now.right!=temp)
					now = now.right;
				if(now.right==null)
				{
					now.right = temp;
					temp = temp.left;
				}
				else
				{
					now.right = null;
					temp.display();
					temp = temp.right;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		InorderOpt i = new InorderOpt();
		i.root = new TreeInt(1);
		i.root.left = new TreeInt(2);
		i.root.right = new TreeInt(3);
		i.root.left.left = new TreeInt(4);
		i.root.left.right = new TreeInt(5);
		
		i.inorder(i.root);
	}
}

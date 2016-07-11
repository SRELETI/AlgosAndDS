
public class InorderOpt {
	
	private TreePrint head;
	
	public InorderOpt()
	{
		head = null;
	}
	
	public void inorder(TreePrint node)
	{
		TreePrint temp;
		while(node!=null)
		{
			if(node.left==null)
			{
				System.out.print(node.data+" ");
				node = node.right;
			}
			else
			{
				temp = node.left;
				while(temp.right!=node && temp.left!=null)
					temp = temp.right;
				
				if(temp.right==null)
				{
					temp.right=node;
					node = node.left;
				}
				else
				{
					temp.right=null;
					System.out.print(node.data+" ");
					node=node.right;
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		InorderOpt i = new InorderOpt();
		i.head = new TreePrint(1);
		i.head.left = new TreePrint(2);
		i.head.right = new TreePrint(3);
		i.head.left.left = new TreePrint(4);
		i.head.left.right = new TreePrint(5);
		
		i.inorder(i.head);
	}
}


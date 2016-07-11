
public class Populate {

	public TreePrintExt head;
	private TreePrintExt p;
	public Populate()
	{
		head = null;
		p = null;
	}
	public void assignNow()
	{
		
		assign(head);
	//	print(head);
	}
	public void assign(TreePrintExt node)
	{
		if(node!=null)
		{
			assign(node.right);
			node.rightExt = p;
			System.out.println("The inorder successor of"+node.data+" is "+ (node.rightExt == null ? null : node.rightExt.data));
			p = node;
			assign(node.left);
		}
	}
	
	private void print(TreePrintExt node)
	{
		if(node!=null)
		{
			print(node.left);
			System.out.println(node.rightExt == null ? null : node.rightExt.data);
			print(node.right);
		}
	}
	
	public static void main(String args[])
	{
		Populate p = new Populate();
		
		p.head = new TreePrintExt(1);
		p.head.left = new TreePrintExt(2);
		p.head.right = new TreePrintExt(3);
		p.head.left.left = new TreePrintExt(4);
		p.head.left.right = new TreePrintExt(5);
		p.head.right.left = new TreePrintExt(6);
		p.head.right.right = new TreePrintExt(7);
		
		p.assignNow();
	}
}

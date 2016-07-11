
public class DeleteNodeApp {

	public static void main(String args[])
	{
		DeleteNode d = new DeleteNode();
		
		d.head = new TreePrint(1);
		d.head.left = new TreePrint(2);
		d.head.right = new TreePrint(3);
		d.head.left.left = new TreePrint(4);
		d.head.left.right = new TreePrint(5);
		
		d.delete(8);
	}
}

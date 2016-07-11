
public class TreeLinkedListApp {

	public static void main(String args[])
	{
		TreeLinkedList l = new TreeLinkedList();
		
		l.tree = new TreePrint(1);
		l.tree.left = new TreePrint(2);
		l.tree.right = new TreePrint(3);
		l.tree.left.left = new TreePrint(4);
		l.tree.left.right = new TreePrint(5);
		l.tree.left.left.left = new TreePrint(7);
		l.tree.left.left.right = new TreePrint(8);
		
		l.tree.right.right = new TreePrint(6);
		l.tree.right.right.left = new TreePrint(9);
		l.tree.right.right.right = new TreePrint(10);
		
		l.tree();
	}
}

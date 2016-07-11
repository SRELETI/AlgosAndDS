
public class AncestorNodeApp {

	public static void main(String args[])
	{
		AncestorsNode an = new AncestorsNode();
		an.head = new TreePrint(1);
		an.head.left = new TreePrint(2);
		an.head.right = new TreePrint(3);
		an.head.left.left = new TreePrint(4);
		an.head.left.right = new TreePrint(5);
		an.head.left.left.left = new TreePrint(7);
		
		an.getAnc(3);
		
	}
}

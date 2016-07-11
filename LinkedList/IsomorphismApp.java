
public class IsomorphismApp {

	public static void main(String args[])
	{
		Isomorphism i = new Isomorphism();
		
		i.head2 = new TreePrint(1);
		i.head2.left = new TreePrint(3);
		i.head2.right = new TreePrint(2);
		i.head2.left.right = new TreePrint(6);
		i.head2.right.left = new TreePrint(4);
		i.head2.right.right = new TreePrint(5);
		i.head2.right.right.left = new TreePrint(7);
		i.head2.right.right.right = new TreePrint(8);
		
		i.head1 = new TreePrint(1);
		i.head1.left = new TreePrint(2);
		i.head1.right = new TreePrint(3);
		i.head1.right.right = new TreePrint(6);
		i.head1.left.left = new TreePrint(4);
		i.head1.left.right = new TreePrint(5);
		i.head1.left.right.left = new TreePrint(7);
		i.head1.left.right.right = new TreePrint(8);
		
		i.isIso();
	}
}

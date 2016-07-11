
public class Identical {
	private TreePrint head1;
	private TreePrint head2;
	
	public Identical()
	{
		head1 = null;
		head2 = null;
	}
	
	public boolean identicalTrees(TreePrint node1, TreePrint node2)
	{
		if(node1 == null && node2 == null)
			return true;
		if(node1 == null || node2 == null)
			return false;
		return (node1.data == node2.data && identicalTrees(node1.left,node2.left)== true && identicalTrees(node1.right, node2.right) == true);
	}
	
	public static void main(String args[])
	{
		Identical i = new Identical();
		i.head1 = new TreePrint(1);
		i.head1.left = new TreePrint(2);
		i.head1.right = new TreePrint(3);
		i.head1.left.left = new TreePrint(4);
		i.head1.left.right = new TreePrint(5);
		
		i.head2 = new TreePrint(1);
		i.head2.left = new TreePrint(4);
		i.head2.right = new TreePrint(3);
		i.head2.left.left = new TreePrint(4);
		i.head2.left.right = new TreePrint(5);
		
		System.out.println(i.identicalTrees(i.head1, i.head2));
	}
}

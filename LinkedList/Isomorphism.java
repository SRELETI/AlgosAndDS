
public class Isomorphism {

	public TreePrint head1;
	public TreePrint head2;
	public Isomorphism()
	{
		head1 = null;
		head2 = null;
	}
	
	public void isIso()
	{
		boolean result = checkIso(head1, head2);
		System.out.println(result == true ? "Yes they are Isomorphic " : "No they are not isomorphic ");
	}
	
	private boolean checkIso(TreePrint node1, TreePrint node2)
	{
		if(node1 == null && node2 == null)
			return true;
		if(node1 == null || node2 == null)
			return false;
		if(node1.data != node2.data)
			return false;
		
		return ((checkIso(node1.left,node2.left) == true && checkIso(node1.right,node2.right)==true) || (checkIso(node1.left,node2.right)==true && checkIso(node1.right,node2.left)==true) );
	}
}

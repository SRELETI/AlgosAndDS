
public class Isomorphic {

	public TreePrint node1;
	public TreePrint node2;
	
	public Isomorphic()
	{
		node1= null;
		node2 = null;
	}
	
	private boolean isIso(TreePrint node, TreePrint nod)
	{
		if(node== null && nod == null)
			return true;
		if(node == null || nod == null)
			return false;
		if(node.data !=nod.data)
			return false;
		return ((isIso(node.left,nod.left)==true && isIso(node.right,nod.right) ==true )||(isIso(node.left,nod.right)==true && isIso(node.right,nod.left)==true));
	}
	
	public void checkIso()
	{
		boolean result = isIso(node1,node2);
		System.out.println(result);
	}
	
	public static void main(String args[])
	{
		Isomorphic i = new Isomorphic();
		
		i.node1 = new TreePrint(1);
		i.node1.left = new TreePrint(2);
		i.node1.right = new TreePrint(3);
		i.node1.left.left = new TreePrint(4);
		i.node1.left.right = new TreePrint(5);
		
		i.node2 = new TreePrint(1);
		i.node2.left = new TreePrint(3);
		i.node2.right = new TreePrint(2);
		i.node2.right.left = new TreePrint(4);
		i.node2.right.right = new TreePrint(6);
		
		i.checkIso();
			
	}
}

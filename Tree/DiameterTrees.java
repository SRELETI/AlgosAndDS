
public class DiameterTrees {

	private TreePrint head;
	
	public DiameterTrees()
	{
		head = null;
	}
	
	public void diameter()
	{
		int result = diameterCount(head);
		System.out.println(result);
	}
	
	private int diameterCount(TreePrint node)
	{
		if(node == null)
			return 0;
		
		int left_h = height(node.left);
		int right_h = height(node.right);
		
		int ldia=diameterCount(node.left);
		int rdia = diameterCount(node.right);
		
		return Math.max(left_h+right_h+1, Math.max(ldia,rdia));
		
	}
	
	private class Wrapper
	{
		int value =0;
	}
	private int dia(TreePrint node, Wrapper h)
	{
		if(node == null)
			return 0;
		Wrapper lh = new Wrapper();
		Wrapper rh = new Wrapper();
		
		int la = dia(node.left,lh);
		int ra = dia(node.right,rh);
		
		h.value = Math.max(lh.value,rh.value)+1;
		return(Math.max(lh.value+rh.value+1, Math.max(la, ra)));
	}
	
	private int height(TreePrint node)
	{
		if( node == null)
			return 0;
		return Math.max(height(node.left), height(node.right))+1;
	}
	
	public void diam()
	{
		Wrapper h = new Wrapper();
		int result = dia(head,h);
		System.out.println(result);
	}
	public static void main(String args[])
	{
		DiameterTrees d = new DiameterTrees();
		
		d.head = new TreePrint(1);
		d.head.left = new TreePrint(2);
		d.head.right = new TreePrint(3);
		d.head.left.left = new TreePrint(4);
		d.head.left.right = new TreePrint(5);
		
		d.diameter();
		d.diam();
//		System.out.println(d.diam());
	}
}

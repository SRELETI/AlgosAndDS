
public class CeilString {

	public static void main(String args[])
	{
		TreePrint s = new TreePrint(8);
		s.left = new TreePrint(4);
		s.right = new TreePrint(12);
		s.left.left = new TreePrint(2);
		s.left.right = new TreePrint(6);
		s.right.left = new TreePrint(10);
		s.right.right = new TreePrint(14);
		CeilString c = new CeilString();
		for(int i=0;i<16;i++)
		{
			c.floor_cal(s,i);
		}
		
	}
	
	private class Wrapper
	{
		int count=-1;
	}
	public void ceil_cal(TreePrint node, int ceil)
	{
		Wrapper s = new Wrapper();
		ceil(node,ceil,s);
		System.out.println(ceil+" "+s.count);
	}
	public void floor_cal(TreePrint node, int ceil)
	{
		Wrapper s = new Wrapper();
		floor(node,ceil,s);
		System.out.println(ceil+" "+s.count);
	}
	public void ceil(TreePrint node, int ceil, Wrapper ceil_data)
	{
		if(node == null)
			return; 
		if(node.data<ceil)
		{
			ceil_data.count = node.data;
			ceil(node.right,ceil,ceil_data);
		}
		else if(node.data>ceil)
		{
			ceil(node.left,ceil,ceil_data);
		}
		if(node.data == ceil)
			ceil_data.count= node.data;
	}
	
	public void floor(TreePrint node, int ceil, Wrapper ceil_data)
	{
		if(node == null)
			return; 
		if(node.data<ceil)
		{
			ceil_data.count = node.data;
			ceil(node.right,ceil,ceil_data);
		}
		else if(node.data>ceil)
		{
			ceil(node.left,ceil,ceil_data);
		}
		if(node.data == ceil)
			ceil_data.count= node.data;
	}
}

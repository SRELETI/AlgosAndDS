
public class TreePrint {
	public int data;
	public TreePrint left;
	public TreePrint right;
	
	public TreePrint(int value)
	{
		data=value;
		left=null;
		right=null;
	}
	
	public void display()
	{
		System.out.print(data+" ");
	}
	
}

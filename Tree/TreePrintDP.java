
public class TreePrintDP {

	public int data;
	public int LISS;
	public TreePrintDP left;
	public TreePrintDP right;
	
	public TreePrintDP (int value)
	{
		data =value;
		LISS =0;
		left =null;
		right = null;
	}
	
	public void display()
	{
		System.out.print(data+" "+LISS+" ");
	}
}


public class TreePrintExt {
	public int data;
	public TreePrintExt left;
	public TreePrintExt right;
	public TreePrintExt rightExt;
	
	public TreePrintExt(int value)
	{
		data = value;
		left = null;
		right = null;
		rightExt = null;
	}
	
	public void display(int value)
	{
		System.out.print(data+" ");
	}
}

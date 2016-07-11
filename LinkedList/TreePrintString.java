
public class TreePrintString {

	public String data;
	public TreePrintString left;
	public TreePrintString right;
	
	public TreePrintString(String value)
	{
		data = value;
		left = null;
		right = null;
	}
	
	public void display()
	{
		System.out.print(data+" ");
	}
}

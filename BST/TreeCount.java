
public class TreeCount {

	public int data;
	public int count;
	public TreeCount left;
	public TreeCount right;
	
	public TreeCount(int value)
	{
		data =value;
		count =0;
		left = null;
		right = null;
	}
	
	public void display()
	{
		System.out.print(data+" ");
	}
}

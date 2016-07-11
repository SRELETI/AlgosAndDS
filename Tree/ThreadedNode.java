
public class ThreadedNode {
	public int data;
	public ThreadedNode left;
	public ThreadedNode right;
	public boolean check;
	
	public ThreadedNode(int value)
	{
		data = value;
		left = null;
		right = null;
		check = false;
	}
	
	public void display()
	{
		System.out.print(data+" ");
	}
}

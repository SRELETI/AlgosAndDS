
public class TreeInorder {
	public int key;
	public TreeInorder lchild;
	public TreeInorder rchild;
	
	public TreeInorder( int value)
	{
		key=value;
		lchild=null;
		rchild=null;
	}
	
	public void display()
	{
		System.out.print(key+" ");
	}
}

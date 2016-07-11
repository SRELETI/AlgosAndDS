
public class TreeSample {
	public int key;
	public int data;
	public TreeSample lchild;
	public TreeSample rchild;
	
	public TreeSample(int keys, int val)
	{
		key=keys;
		data=val;
		lchild=null;
		rchild=null;
	}
	public void display()
	{
		System.out.print(key+" ");
	}
}


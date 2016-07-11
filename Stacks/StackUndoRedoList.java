
public class StackUndoRedoList {
	private String[] main;
	private int capacity;
	private int elements1;
	public StackUndoRedoList(int length)
	{
		capacity=length;
		main= new String[capacity];
		elements1=0;
	}
	public void push(String value)
	{
		main[elements1++]=value;
	}
	public String pop()
	{
		String result=main[elements1-1];
		elements1--;
		return result;
	}
	public boolean isEmpty()
	{
		return elements1==0;
	}
	public boolean isFull()
	{
		return elements1==capacity;
	}
	public void display()
	{
		for(int i=0;i<elements1;i++)
		{
			System.out.print(main[i]+" ");
		}
		System.out.println();
	}
	public void clear()
	{
		elements1=0;
	}
}

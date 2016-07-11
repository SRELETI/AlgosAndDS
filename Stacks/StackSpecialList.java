
public class StackSpecialList {
	private StackSpecial original;
	private StackSpecial duplicate;
	public StackSpecialList()
	{
		original=null;
		duplicate=null;
	}
	public void push(int value)
	{
		StackSpecial newNode = new StackSpecial(value);
		if(original==null)
		{
			original=newNode;
			duplicate=newNode;
		}
		else
		{
			if(newNode.data<duplicate.data)
			{
				newNode.next=original;
				original=newNode;
				newNode.next=duplicate;
				duplicate=newNode;
			}
			else
			{
				newNode.next=original;
				original=newNode;
			}
		}
	}
	public int pop()
	{
		int result;
		if(original.data>duplicate.data)
		{	
			result=original.data;
			original=original.next;
		}
		else
		{
			result=original.data;
			original=original.next;
			duplicate=duplicate.next;
		}
		return result;
	}
	public boolean isEmpty()
	{
		return original==null;
	}
	public int getMin()
	{
		return duplicate.data;
	}
}

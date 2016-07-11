
public class SCLList {
	public SCL current;
	public SCLList()
	{
		current=null;
	}
	public boolean isEmpty()
	{
		return current==null;
	}
	public void insertFirst(int data)
	{
		SCL newNode=new SCL(data);
		if(current==null)
		{
			current=newNode;
			newNode.next=current;
		}
		else
		{
			
		}
	}
}

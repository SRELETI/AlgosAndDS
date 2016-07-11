
public class CLinkedList {
	private CLink current;
	public CLinkedList()
	{
		current=null;
	}
	public boolean isEmpty()
	{
		return current==null;
	}
	public void insertcurrent(int data)
	{
		CLink newNode=new CLink(data);
		if(isEmpty())
		{
			current=newNode;
			newNode.next=current;
		}
		if(current.next==current)
		{
			newNode.next=current;
			current.next=newNode;
			current=newNode;
		}
		else
		{
			CLink temp=current.next;
			current.next=newNode;
			newNode.next=temp;
		}
	}
	public void deletecurrent()
	{
		if(current==null)
			System.out.println("Circular list is empty");
		if(current.next==current)
		{
			current=null;
		}
		else
		{
			CLink temp=current.next.next;
			current.next=temp;
		}
	}
	public void display()
	{
		CLink temp=current;
		do
		{
			temp.display();
			temp=temp.next;
		}while(temp!=current);
	}
}


public class DeleteRec {
	public LinkedList head;
	public DeleteRec()
	{
		head=null;
	}
	
	public void add(int value)
	{
		LinkedList newNode = new LinkedList(value);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			newNode.next=head;
			head=newNode;
		}
	}
	
	public int remove()
	{
		int result=head.data;
		head=head.next;
		return result;
	}
	
	public void display()
	{
		LinkedList current = head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
	
	public void delete(LinkedList node)
	{
		if(node==null || node.next==null)
			return;
		node.next=node.next.next;
		delete(node.next);
	}
	
}

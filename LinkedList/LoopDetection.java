
public class LoopDetection {
	public LinkedList head;
	public LoopDetection()
	{
		head=null;
	}
	public void addFront(int value)
	{
		LinkedList newNode = new LinkedList(value);
		newNode.next=head;
		head=newNode;
	}
	public void display()
	{
		LinkedList current=head;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
	}
	public void detectLoop()
	{
		LinkedList slow=head;
		LinkedList fast=head;
		while(slow!=null && fast !=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
			{
				System.out.println("There is a loop ");
				return;
			}
		}
		System.out.println("No Loop");
	}
}

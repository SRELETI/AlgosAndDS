
public class StackLinkedList {
	private StackLink first;
	private int maxSize;
	private int elements;
	public StackLinkedList(int size)
	{
		maxSize=size;
		first=null;
		elements=0;
	}
	public void push(int data)
	{
		if(isFull())
		{
			System.out.println("The stack is Full");
			return;
		}
		StackLink newNode=new StackLink(data);
		newNode.next=first;
		first=newNode;
		elements++;
	}
	public void pop()
	{
		if(isEmpty())
		{
			System.out.println("The Stack is empty");
			return;
		}
		StackLink temp=first;
		first=first.next;
		System.out.print("The popped element is: ");
		temp.display();
		elements--;
	}
	public boolean isEmpty()
	{
		return first==null;
	}
	public boolean isFull()
	{
		return elements==maxSize;
	}
	public void display()
	{
		StackLink sl=first;
		while(sl!=null)
		{
			sl.display();
			sl=sl.next;
		}
		System.out.println();
	}
}


class PracticeLink
{
	int data;
	PracticeLink next;
	public PracticeLink(int val)
	{
		data = val;
		next=null;
	}
	public void display()
	{
		System.out.print(data+" ");
	}
	
}
public class Insertion {

	public PracticeLink head;
	
	public Insertion()
	{
		head = null;
	}
	
	public void insertion(int val)
	{
		PracticeLink newNode = new PracticeLink(val);
		newNode.next= head;
		head = newNode;	
	}
	
	public void insertAtLast(int val)
	{
		PracticeLink newNode = new PracticeLink(val);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			PracticeLink temp = head;
			while(temp.next!=null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	
	public void insertionAfterNode(int val, PracticeLink temp)
	{
		PracticeLink newNode = new PracticeLink(val);
		if(head==null){
			newNode = head;
			return;
		}
		if(temp==head){
			newNode.next = head.next;
			head.next = newNode;
			return;
		}
		PracticeLink temp2 = head;
		while(temp2!=temp)
		{
			temp2 = temp2.next;
			
		}
		newNode.next = temp2.next;
		temp2.next = newNode;
	}
	
	public void display()
	{
		PracticeLink temp = head;
		while(temp!=null)
		{
			temp.display();
			temp = temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		Insertion  i = new Insertion();
		i.insertion(6);
		i.display();
		i.insertion(7);
		i.display();
		i.insertion(1);
		i.display();
		i.insertAtLast(4);
		i.display();
		i.insertionAfterNode(8,i.head.next);
		i.display();
		i.insertionAfterNode(10,i.head.next.next.next.next);
		i.display();
	}
}

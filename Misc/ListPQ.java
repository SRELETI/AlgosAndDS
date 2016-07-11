
public class ListPQ {
	private LinkPQ first;
	public ListPQ()
	{
		first=null;
	}
	public void insert(int key)
	{
		LinkPQ newNode=new LinkPQ(key);
		LinkPQ current=first;
		LinkPQ previous=null;
		while(current!=null && key> current.data)
		{
			previous=current;
			current=current.next;
		}
		if(previous==null)
		{
			newNode.next=current;
			first=newNode;
			System.out.println("Inserted new node at first");
		}
		else
		{
			newNode.next=previous.next;
			previous.next=newNode;
			current=newNode;
			System.out.println("Inserted new node elsewhere ");
		}
	}
	public void delete()
	{
		LinkPQ result=first;
		first=first.next;
		System.out.println("The Link that is deleted is: "+result);
	}
	public void display()
	{
		LinkPQ current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.println();
	}
}

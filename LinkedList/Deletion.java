class PracticeDel
{
	int data;
	PracticeDel next;
	
	public PracticeDel(int val)
	{
		data = val;
		next = null;
	}
	
	public void display()
	{
		System.out.print(data+" ");
	}
}
public class Deletion {

	private PracticeDel head;
	
	public Deletion () {
		head = null;
	}
	
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		newNode.next = head;
		head = newNode;
	}
	
	public void delete(int key)
	{
		if(head==null)
			return;
		else
		{
			PracticeDel prev = null;
			PracticeDel temp = head;
			while(temp!=null)
			{
				if(temp.data==key)
					break;
				prev= temp;
				temp =temp.next;
			}
			if(temp==null)
				return;
			if(prev==null)
				head= head.next;
			else
				prev.next = temp.next;
				
		}
	}
	public void display()
	{
		PracticeDel temp = head;
		while(temp!=null)
		{
			temp.display();
			temp = temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		Deletion d = new Deletion();
		d.insertion(7);
		d.insertion(1);
		d.insertion(3);
		d.insertion(2);
		d.display();
		d.delete(1);
		d.display();
	}
}

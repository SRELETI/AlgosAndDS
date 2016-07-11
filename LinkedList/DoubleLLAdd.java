class DoubleLL {
	int data;
	DoubleLL next;
	DoubleLL prev;
	
	public DoubleLL(int val) {
		data = val;
		next = null;
		prev = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}

public class DoubleLLAdd {

	private DoubleLL head;
	
	public DoubleLLAdd() {
		head = null;
	}
	
	public void add(int val) {
		DoubleLL newNode = new DoubleLL(val);
		if(head == null)
			head = newNode;
		else
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}
	
	public void addAfter(int val, int after) {
		if(head==null)
			return;
		DoubleLL temp = head;
		while(temp!=null)
		{
			if(temp.data == after)
			{
				DoubleLL newNode = new DoubleLL(val);
				DoubleLL temp_node = temp.next;
				temp.next = newNode;
				newNode.prev = temp;
				newNode.next = temp_node;
				temp_node.prev = newNode;
				return;
			}
			temp = temp.next;
		}
	}
	
	public void addEnd(int val) {
		DoubleLL newNode = new DoubleLL(val);
		if(head==null)
			head = newNode;
		else
		{
			DoubleLL temp = head;
			while(temp.next!=null)
				temp = temp.next;
			temp.next = newNode;
			newNode.prev = temp;
		}
	}
	
	public void addBefore(int val, int before)
	{
		if(head == null)
			return;
		DoubleLL newNode = new DoubleLL(val);
		DoubleLL temp = head;
		DoubleLL prev = null;
		while(temp!=null)
		{
			if(temp.data == before)
			{
				if(prev == null)
				{
					newNode.next = head;
					head.prev = newNode;
					head = newNode;
				}
				else
				{
					newNode.next = temp;
					temp.prev = newNode;
					prev.next = newNode;
					newNode.prev = prev;
				}
				break;
			}
			prev = temp;
			temp = temp.next;
		}
	}
	
	public void display()
	{
		DoubleLL temp = head;
		DoubleLL last= null;
		while(temp!=null)
		{
			temp.display();
			last = temp;
			temp = temp.next;
		}
		System.out.println();
		while(last!=null)
		{
			last.display();
			last = last.prev;
		}
		System.out.println();
			
	}
	
	public static void main(String args[])
	{
		DoubleLLAdd d = new DoubleLLAdd();
		d.add(6);
		d.add(7);
	//	d.add(1);
		d.addEnd(4);
		d.addAfter(8, 7);
		d.addBefore(1, 7);
		
		d.display();
	}
}

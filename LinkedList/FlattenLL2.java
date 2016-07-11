class Flatten_node {
	int data;
	Flatten_node next;
	Flatten_node child;
	
	public Flatten_node(int val) {
		data = val;
		next = null;
		child = null;
	}
	
	public void display() {
		System.out.print(data+" ");
	}
}

public class FlattenLL2 {
	
	private Flatten_node head;
	private Flatten_node last;
	public FlattenLL2()
	{
		head = null;
		last = null;
	}
	
	public void insertion(int val)
	{
		Flatten_node newNode = new Flatten_node(val);
		if(head == null)
			head = newNode;
		else
			last.next = newNode;
		last = newNode;
	}
	
	public void flatten()
	{
		if(head==null)
			return;
		Flatten_node cur = head;
		Flatten_node temp;
		while(cur!=null)
		{
			if(cur.child!=null)
			{
				last.next = cur.child;
				temp = cur.child;
				while(temp.next!=null)
					temp = temp.next;
				last = temp;
			}
			cur = cur.next;
		}
	}
	
	public void display()
	{
		Flatten_node temp = head;
		while(temp!=null)
		{
			temp.display();
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String args[])
	{
		FlattenLL2 f = new FlattenLL2();
		f.insertion(10);
		
		f.insertion(5);
		f.insertion(12);
		f.insertion(7);
		f.insertion(11);
		
		f.head.child = new Flatten_node(4);
		f.head.child.next = new Flatten_node(20);
		f.head.child.next.next = new Flatten_node(13);
		f.head.child.next.child = new Flatten_node(2);
		f.head.child.next.next.child = new Flatten_node(16);
		f.head.child.next.next.child.child = new Flatten_node(3);
		f.head.next.next.next.child = new Flatten_node(17);
		f.head.next.next.next.child.child = new Flatten_node(9);
		f.head.next.next.next.child.child.child = new Flatten_node(19);
		f.head.next.next.next.child.next = new Flatten_node(6);
		f.head.next.next.next.child.child.next = new Flatten_node(8);
		f.head.next.next.next.child.child.child.next = new Flatten_node(15);
		
		f.flatten();
		
		f.display();
	}
}

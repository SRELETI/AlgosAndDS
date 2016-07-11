
public class NthNode {
	private PracticeDel head;
	public NthNode()
	{
		head = null;
	}
	public void insertion(int val)
	{
		PracticeDel newNode = new PracticeDel(val);
		newNode.next= head;
		head = newNode;	
	}
	public void getNthNode(int k)
	{
		int count =0;
		PracticeDel temp = head;
		while(temp!=null)
		{
			if(count==k)
			{
				temp.display();
				return;
			}
			count++;
			temp = temp.next;
		}
	}
	
	public static void main(String args[])
	{
		NthNode n = new NthNode();
		n.insertion(1);
		n.insertion(4);
		n.insertion(1);
		n.insertion(12);
		n.insertion(1);
		n.getNthNode(3);
	}
}

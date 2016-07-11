
public class GraphLinkList {

	public GraphLink head;
	public GraphLink last;
	
	public GraphLinkList()
	{
		head = null;
		last = null;
	}
	
	public void insert(char val)
	{
		GraphLink g = new GraphLink(val);
		if(head == null)
		{
			head = g;
			last = g;
			return;
		}
		else
		{
			last.next = g;
			last = g;
		}
	}
	
	public boolean find(char val)
	{
		GraphLink g = head;
		while(g!=null)
		{
			if(g.label== val)
				return true;
		}
		return false;
	}
	
//	public void display()
}

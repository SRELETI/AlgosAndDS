
public class GraphLink {

	public char label;
	public int index;
	public GraphLink next;
	public int count = -1;
	public GraphLink(char lab)
	{
		label = lab;
		index = count+1;
		next = null;
	}
	
	public void display()
	{
		System.out.print(label+" ");
	}
}

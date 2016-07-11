
public class Graph {

	public char label;
	public boolean isVisited;
	
	public Graph(char lab)
	{
		label = lab;
		isVisited = false;
	}
	
	public void display()
	{
		System.out.print(label+" ");
	}
}

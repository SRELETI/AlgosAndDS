
public class Graphs {

	public char label;
	public boolean isVisited;
	
	public Graphs(char lab)
	{
		label = lab;
		isVisited = false;
	}
	
	public void display()
	{
		System.out.print(label+" ");
	}
}

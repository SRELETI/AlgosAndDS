import java.util.Stack;


public class CompleteGraphs {

	private static int MAX_SIZE =20;
	
	private Graphs[] arr;
	
	private int[][] adj;
	
	private int elements;
	
	
	public CompleteGraphs()
	{
		arr = new Graphs[MAX_SIZE];
		
		adj = new int[MAX_SIZE][MAX_SIZE];
		
		elements=0;
		
		for(int i=0;i<MAX_SIZE;i++)
		{
			for(int j=0;j<MAX_SIZE;j++)
			{
				adj[i][j] = 0;
			}
		}
	}
	
	public void addVertex(char lab)
	{
		Graphs g = new Graphs(lab);
		arr[elements++]=g;
	}
	
	public void addEdge(int start,int end)
	{
		adj[start][end] = 1;
		adj[end][start] = 1;
	}
	
	public void displayLabel(int v)
	{
		arr[v].display();
	}
	
	public void dfs()
	{
		arr[0].isVisited = true;
		arr[0].display();
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		while(!s.isEmpty())
		{
			int v = getnextUnvisited(s.peek());
			if(v==-1)
				s.pop();
			else
			{
				arr[v].isVisited = true;
				arr[v].display();
				s.push(v);
			}
		}
		
		for(int i=0;i<elements;i++)
			arr[i].isVisited = false;
	}
	
	public int getnextUnvisited(int v)
	{
		for(int i=0;i<elements;i++)
		{
			if(adj[v][i] == 1 && arr[i].isVisited == false)
				return i;
		}
		return -1;
	}
}

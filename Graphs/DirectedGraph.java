import java.util.Stack;


public class DirectedGraph {

	private Graph[] arr;
	private int[][] adj;
	
	private int elements;
	private final static int MAX_SIZE = 20;
	
	public DirectedGraph()
	{
		arr= new Graph[MAX_SIZE];
		adj = new int[MAX_SIZE][MAX_SIZE];
		elements = 0;
		for(int i=0;i<MAX_SIZE;i++)
		{
			for(int j=0;j<MAX_SIZE;j++)
			{
				adj[i][j]=0;
			}
		}
	}
	
	public void addVertex(char lab)
	{
		Graph g= new Graph(lab);
		arr[elements++]=g;
	}
	
	public void addEdge(int start,int end)
	{
		adj[start][end] = 1;
	}
	
	public void display(int v)
	{
		arr[v].display();
	}
	
	public void dfs()
	{
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<elements;i++)
		{
			
			arr[i].isVisited = true;
			arr[i].display();
			s.push(i);
			while(!s.isEmpty())
			{
				int v = getNextUnVisited(s.peek());
				if(v==-1)
					s.pop();
				else
				{
					arr[v].isVisited = true;
					arr[v].display();
					s.push(v);
				}
			}
			for(int j=0;j<elements;j++)
				arr[j].isVisited = false;
			System.out.println();
			
		}
		
	}
	
	public int getNextUnVisited(int v)
	{
		for(int i=0;i<elements;i++)
		{
			if(adj[v][i]==1 && arr[i].isVisited==false)
				return i;
		}
		return -1;
	}
	
	public static void main(String args[])
	{
		DirectedGraph d = new DirectedGraph();
		
		d.addVertex('A');
		d.addVertex('B');
		d.addVertex('C');
		d.addVertex('D');
		d.addVertex('E');
		
		d.addEdge(0, 2);
		d.addEdge(1, 0);
		d.addEdge(1, 4);
		d.addEdge(3, 4);
		d.addEdge(4, 2);
		
		d.dfs();
		
	}
}

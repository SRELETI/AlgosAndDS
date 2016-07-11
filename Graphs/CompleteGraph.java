import java.util.Stack;


public class CompleteGraph {

	private static final int MAX_SIZE = 20;
	private Graph[] arr;
	private int[][] adj;
	int elements;
	
	public CompleteGraph()
	{
		arr = new Graph[MAX_SIZE];
		elements=0;
		adj = new int[MAX_SIZE][MAX_SIZE];
		
		for(int i=0;i<MAX_SIZE;i++)
		{
			for(int j=0;j<MAX_SIZE;j++)
			{
				adj[i][j] = 0;
			}
		}
	}
	
	public void addVertex(char v)
	{
		Graph g = new Graph(v);
		arr[elements++]=g;
	}
	
	public void addEdge(int start,int end)
	{
		adj[start][end]=1;
		adj[end][start]=1;
	}
	
	public void displayLagel(int ind)
	{
		arr[ind].display();
	}
	
	public void dfs()
	{
		arr[0].isVisited = true;
		arr[0].display();
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		while(!s.isEmpty())
		{
			int v = getUnvisitedNode(s.peek());
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
	
	
	public int getUnvisitedNode(int v)
	{
		for(int i=v;i<elements;i++)
		{
			if(adj[v][i]==1 && arr[i].isVisited==false)
				return i;
		}
		return -1;
	}
	
	public static void main(String args[])
	{
		CompleteGraph g = new CompleteGraph();
		
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
		g.addVertex('H');
		g.addVertex('I');
	//	g.addVertex('J');
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(0, 4);
		g.addEdge(1, 5);
		g.addEdge(1, 7);
		g.addEdge(3, 6);
		g.addEdge(3, 8);
		
		g.dfs();
		
	}
}



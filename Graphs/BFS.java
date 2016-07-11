
public class BFS {

	private final int MAX_SIZE = 20;
	
	private Graphs[] arr;
	
	private int[][] adj;
	
	private int elements;
	
	public BFS()
	{
		arr = new Graphs[MAX_SIZE];
		
		adj = new int[MAX_SIZE][MAX_SIZE];
		
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
		Graphs g = new Graphs(lab);
		arr[elements++] = g;		
	}
	
	public void addEdge(int start,int end)
	{
		adj[start][end] = 1;
		adj[end][start] = 1;
	}
	
	public void display(int v)
	{
		arr[v].display();
	}
	
	public void bfs()
	{
		arr[0].isVisited = true;
		arr[0].display();
		QueueInt q = new QueueInt(20);
		q.insert(0);
		while(!q.isempty())
		{
			int v = getnextUnvisited(q.peek());
			if(v==-1)
				q.delete();
			else
			{
				arr[v].isVisited = true;
				arr[v].display();
				q.insert(v);
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
	
	public static void main(String args[])
	{
		BFS b = new BFS();
		
		b.addVertex('A');
		b.addVertex('B');
		b.addVertex('C');
		b.addVertex('D');
		b.addVertex('E');
		b.addVertex('F');
		b.addVertex('G');
		b.addVertex('H');
		b.addVertex('I');
	//	b.addVertex('J');
		
		b.addEdge(0, 1);
		b.addEdge(0, 2);
		b.addEdge(0, 3);
		b.addEdge(0, 4);
		b.addEdge(1, 5);
		b.addEdge(1, 7);
		b.addEdge(3, 6);
		b.addEdge(3, 8);
		
		b.bfs();
		
	//	b.bfs();
	}
}

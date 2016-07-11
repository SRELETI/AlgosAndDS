import java.util.Stack;


public class EverythingTillNow {

	private Graphs[] arr;
	private final int MAX_SIZE = 20;
	private int adj[][];
	private int elements;
	
	public EverythingTillNow()
	{
		arr = new Graphs[MAX_SIZE];
		adj = new int[MAX_SIZE][MAX_SIZE];
		elements=0;
		
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
		arr[elements++]=g;
	}
	
	public void addEdge(int start,int end)
	{
		adj[start][end]=1;
		adj[end][start]=1;
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
		
		for(int i=0;i<elements;i++)
		{
			arr[i].isVisited = false;
		}
		
	}
	
	public int getNextUnVisited(int v)
	{
		for(int i=0;i<elements;i++)
		{
			if(adj[v][i] == 1 && arr[i].isVisited == false)
				return i;
		}
		return -1;
	}
	
	public void bfs()
	{
		arr[0].isVisited = true;
		arr[0].display();
		QueueInt q = new QueueInt(20);
		
		q.insert(0);
		
		while(!q.isempty())
		{
			int v = getNextUnVisited(q.peek());
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
	
	public void mst()
	{
		arr[0].isVisited = true;
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(0);
		
		while(!s.isEmpty())
		{
			int v = getNextUnVisited(s.peek());
			if(v==-1)
				s.pop();
			else
			{
				arr[v].isVisited = true;
				display(s.peek(),v);
				s.push(v);
			}
		}
		
		for(int i=0;i<elements;i++)
			arr[i].isVisited = false;
	}
	
	public void display(int v, int v2)
	{
		System.out.print(arr[v].label+""+arr[v2].label+" ");
	}
	
	
	public static void main(String args[])
	{
		EverythingTillNow g = new EverythingTillNow();
		
	/*	theGraph.addVertex('A'); // 0 (start for mst)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(0, 2); // AC
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(0, 4); // AE
		theGraph.addEdge(1, 2); // BC
		theGraph.addEdge(1, 3); // BD
		theGraph.addEdge(1, 4); // BE
		theGraph.addEdge(2, 3); // CD
		theGraph.addEdge(2, 4); // CE
		theGraph.addEdge(3, 4); // DE
		
		theGraph.mst();
		System.out.println();
		theGraph.dfs();
		System.out.println();
		theGraph.bfs();
	*/	
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
		System.out.println();
		g.bfs();
		System.out.println();
		g.mst();
		
	}
}


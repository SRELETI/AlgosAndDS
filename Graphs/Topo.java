
public class Topo {

	private Graph[] arr;
	private int elements;
	private int[][] adj;
	private final int MAX_SIZE = 20;
	
	private char[] result;
	
	public Topo()
	{
		arr = new Graph[MAX_SIZE];
		adj = new int[MAX_SIZE][MAX_SIZE];
		elements=0;
		for(int i=0;i<MAX_SIZE;i++)
		{
			for(int j=0;j<MAX_SIZE;j++)
			{
				adj[i][j] = 0;
			}
		}
		result = new char[MAX_SIZE];
	}
	
	public void addVertex(char lab)
	{
		Graph g = new Graph(lab);
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
	
	public void topo()
	{
		int org_elements = elements;
		while(elements>0)
		{
			int last = noSuc();
			if(last == -1)
			{
				System.out.println("The graph contains cycles, topological order cannot be constructed ");
				return;
			}
			else
			{
				result[elements-1] = arr[last].label;
				delete(last);
			}
		}
		
		for(int i=0;i<org_elements;i++)
			System.out.print(result[i]+" ");
	}
	
	public int noSuc()
	{
		boolean flag;
		for(int i=0;i<elements;i++)
		{
			flag = false;
			for(int j=0;j<elements;j++)
			{
				if(adj[i][j]!=0)
				{
					flag = true;
					break;
				}
				
			}
			if(flag!=true)
				return i;
		}
		return -1;
	}
	
	public void delete(int v)
	{
		if(v!=elements-1)
		{
			for(int i=v;i<elements-1;i++)
				arr[i]=arr[i+1];
			for(int i=v;i<elements-1;i++)
				deleteRows(i,elements);
			for(int i=v;i<elements-1;i++)
				deleteCols(i,elements);
		}
		elements--;
	}
	
	public void deleteRows(int v, int length)
	{
		for(int i=0;i<length;i++)
			adj[v][i] = adj[v+1][i];
	}
	
	public void deleteCols(int v, int length)
	{
		for(int i=0;i<length;i++)
			adj[i][v] = adj[i][v+1];
	}
	
	
	public static void main(String args[])
	{
		Topo theGraph = new Topo();
		theGraph.addVertex('A'); // 0
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addVertex('F'); // 5
		theGraph.addVertex('G'); // 6
		theGraph.addVertex('H'); // 7

		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(0, 4); // AE
		theGraph.addEdge(1, 4); // BE
		theGraph.addEdge(2, 5); // CF
		theGraph.addEdge(3, 6); // DG
		theGraph.addEdge(4, 6); // EG
		theGraph.addEdge(5, 7); // FH
		theGraph.addEdge(6, 7); // GH
		
		theGraph.topo();
	}
}

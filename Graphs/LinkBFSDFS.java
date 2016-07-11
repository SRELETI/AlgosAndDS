import java.util.Stack;


public class LinkBFSDFS {

	private GraphLinkList[] adj;
	private Graph[] arr;
	private int elements;
	private static final int MAX_SIZE=20;
	
	public LinkBFSDFS()
	{
		adj = new GraphLinkList[MAX_SIZE];
		arr =new Graph[MAX_SIZE];
		elements = 0;
		for(int i=0;i<MAX_SIZE;i++)
			adj[i] = new GraphLinkList();
	}
	
	public void addVertex(char val)
	{
		Graph g = new Graph(val);
		arr[elements++]= g;
	}
	
	public void addEdge(int start, int end)
	{
		adj[start].insert(arr[end].label);
		adj[end].insert(arr[start].label);
	}
	
	public void display(int v)
	{
		arr[v].display();
	}
	public int getIndex(char lab)
	{
		for(int i=0;i<elements;i++)
		{
			if(arr[i].label==lab)
				return i;
		}
		return -1;
	}
	public void dfs()
	{
		arr[0].isVisited = true;
		System.out.println("Succes");
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
		
		for(int i = 0;i<elements;i++)
			arr[i].isVisited= false;
		System.out.println();
		
	}
	
	public int getNextUnVisited(int v)
	{
		GraphLink temp =adj[v].head;
		while(temp!=null)
		{
			int index = getIndex(temp.label);
			if(arr[index].isVisited == false)
				return index;
			temp = temp.next;
		}
		return -1;
	}
	
	public static void main(String args[])
	{
		LinkBFSDFS g = new LinkBFSDFS();
		
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
		System.out.println("Program started");
		g.dfs();
	}
}

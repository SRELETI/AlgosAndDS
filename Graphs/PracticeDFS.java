import java.util.Stack;


public class PracticeDFS {

	public Graphs[] arr;
	public int count;
	public int[][] adj;
	public final int SIZE = 20;
	
	public PracticeDFS() {
		arr = new Graphs[SIZE];
		count=0;
		adj = new int[SIZE][SIZE];
	}
	
	public void addNode(char val) {
		arr[count++] = new Graphs(val);
	}
	
	public void addEdge(int x, int y) {
		adj[x][y]=1;
		adj[y][x]=1;
	}
	
	public void DFS() {
		Stack<Integer> s = new Stack<Integer>();
		arr[0].isVisited =true;
		arr[0].display();
		s.push(0);
		while(!s.isEmpty()) {
			int ind = getNextUnvisited(s.peek());
			if(ind==-1) 
				s.pop();
			else
			{
				arr[ind].isVisited=true;
				arr[ind].display();
				s.push(ind);
			}
		}
		
		for(int i=0;i<count;i++) {
			arr[i].isVisited=false;
		}
	}
	
	private int getNextUnvisited(int v) {
		for(int i=0;i<SIZE;i++) {
			if(adj[v][i]==1 && arr[i].isVisited==false) 
				return i;
		}
		return -1;
	}
	
	public static void main(String args[]) {
		PracticeDFS p = new PracticeDFS();
		p.addNode('A');
		p.addNode('B');
		p.addNode('C');
		p.addNode('D');
		p.addNode('E');
		
		p.addEdge(0, 1);
		p.addEdge(1, 0);
		p.addEdge(1, 2);
		p.addEdge(2, 1);
		p.addEdge(0, 3);
		p.addEdge(3, 0);
		p.addEdge(3, 4);
		p.addEdge(4, 3);
			
		p.DFS();
		p.BFS();
	}
	
	public void BFS() {
		QueueInt q = new QueueInt(SIZE);
		arr[0].isVisited = true;
		arr[0].display();
		q.insert(0);
		while(!q.isempty()) {
			int ind = getNextUnvisited(q.peek());
			if(ind==-1) 
				q.delete();
			else
			{
				arr[ind].isVisited=true;
				arr[ind].display();
				q.insert(ind);
			}
		}
		for(int i=0;i<count;i++) {
			arr[i].isVisited=false;
		}
	}
}

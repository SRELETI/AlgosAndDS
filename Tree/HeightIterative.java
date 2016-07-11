
public class HeightIterative {

	private Tree_node root;
	
	public HeightIterative() {
		root = null;
	}
	
	public int height(Tree_node temp) {
		if(temp==null)
			return 0;
		Queue_tree q = new Queue_tree();
		int height=0;
		int nodeCount=0;
		q.enqueue(temp);
		while(true)
		{
			nodeCount = q.size();
			if(nodeCount==0)
				return height;
			else
				height++;
			while(nodeCount>0)
			{
				temp = q.dequeue();
				if(temp.prev!=null)
					q.enqueue(temp.prev);
				if(temp.next!=null)
					q.enqueue(temp.next);
				nodeCount--;
			}
		}
	}
	
	public static void main(String args[]) {
		HeightIterative h = new HeightIterative();
		h.root = new Tree_node(1);
		h.root.prev = new Tree_node(2);
		h.root.next = new Tree_node(3);
		h.root.prev.prev = new Tree_node(4);
		h.root.prev.next = new Tree_node(5);
		
		System.out.println(h.height(h.root));
	}
}

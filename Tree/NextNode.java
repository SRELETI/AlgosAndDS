
public class NextNode {

	private Tree_node root;
	
	public NextNode() {
		root = null;
	}
	
	public void next(Tree_node temp, int key) {
		if(temp == null)
			return;
		Queue_tree q= new Queue_tree();
		int nodeCount= 0;
		q.enqueue(temp);
		while(true)
		{
			nodeCount = q.size();
		//	System.out.println(nodeCount);
			if(nodeCount==0)
			{
				System.out.print("Key not found");
				return;
			}
			while(nodeCount>0)
			{
				temp = q.dequeue();
				if(temp.data==key)
				{
					if(nodeCount==1)
						System.out.println("null");
					else
						System.out.println(q.dequeue().data);
					return;
				}
				if(temp.prev!=null)
					q.enqueue(temp.prev);
				if(temp.next!=null)
					q.enqueue(temp.next);
				nodeCount--;
			}
		}
	}
	
	public static void main(String args[]) {
		NextNode n = new NextNode();
		n.root = new Tree_node(10);
		n.root.prev = new Tree_node(2);
		n.root.next = new Tree_node(6);
		n.root.prev.prev = new Tree_node(8);
		n.root.prev.next = new Tree_node(4);
		n.root.next.next = new Tree_node(5);
		
		n.next(n.root, 5);
	}
}

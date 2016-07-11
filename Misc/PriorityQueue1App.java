
public class PriorityQueue1App {
	public static void main(String args[])
	{
		int length=5;
		PriorityQueue1 pq=new PriorityQueue1(length);
		pq.insertion(5);
		pq.insertion(3);
		pq.insertion(4);
		pq.insertion(1);
		pq.insertion(2);
		pq.delete();
		pq.delete();
		pq.delete();
		pq.delete();
		
		pq.insertion(6);
		pq.insertion(7);
		pq.insertion(8);
		
		pq.delete();
		//pq.insertion(7);
		
	}
}

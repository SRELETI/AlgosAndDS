
public class ListExampleTree {

	public ListTree head;
	public ListTree last;
	
	public ListExampleTree() {
		head = null;
		last = null;
	}
	
	public void insert(int val){
		ListTree newNode = new ListTree(val);
		if(head == null)
		{
			head = newNode;
			last = newNode;
		}
		else
		{
			last.next= newNode;
			last = newNode;
		}
	}
	
	public void delete() {
		if(head==null)
			return;
		head = head.next;
	}
}

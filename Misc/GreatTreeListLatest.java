
public class GreatTreeListLatest {
	public LinkLatestDouble head;
	public LinkLatestDouble convert(LinkLatestDouble head) {
		if(head==null)
			return head;
		LinkLatestDouble aList = convert(head.prev);
		LinkLatestDouble bList = convert(head.next);
		
		head.prev = head;
		head.next = head;
		
		aList = append(aList,head);
		aList  = append(aList,bList);
		return aList;
	}
	
	public LinkLatestDouble append(LinkLatestDouble first, LinkLatestDouble second) {
		if(first==null)
			return second;
		if(second==null)
			return first;
		LinkLatestDouble aLast = first.prev;
		LinkLatestDouble bLast = second.prev;
		
		join(second,aLast);
		join(first,bLast);
		return first;
	}
	
	private void join(LinkLatestDouble firstList, LinkLatestDouble node) {
		firstList.prev = node;
		node.next = firstList;
	}
	
	public void display(LinkLatestDouble head) {
		LinkLatestDouble temp = head;
		do{
			System.out.print(temp.data+" ");
			temp =temp.next;
		}while(temp!=head);
		System.out.println();
	}
	public static void main(String args[]) {
		GreatTreeListLatest g = new GreatTreeListLatest();
		g.head = new LinkLatestDouble(4);
		g.head.prev = new LinkLatestDouble(2);
		g.head.next = new LinkLatestDouble(6);
		g.head.prev.prev = new LinkLatestDouble(1);
		g.head.prev.next = new LinkLatestDouble(3);
		g.head.next.prev = new LinkLatestDouble(5);
		g.head.next.next = new LinkLatestDouble(7);
		
		LinkLatestDouble temp  = g.convert(g.head);
		g.display(temp);
	}
}

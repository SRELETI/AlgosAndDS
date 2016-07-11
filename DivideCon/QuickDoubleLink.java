
class Link3
{
	public int data;
	public Link3 next;
	public Link3 prev;
	
	public Link3(int val)
	{
		data =val;
		next =null;
		prev = null;
	}
	
	public void display()
	{
		System.out.print(data+" ");
	}
}
public class QuickDoubleLink {
	public Link3 head;
	 
	 public void sort()
	 {
		 Link3 temp = head;
		 while(temp.next!=null)
			 temp = temp.next;
		 Link3 last = temp;
		 sorting(head,last);
		 display(head);
	 }
	 
	 public void sorting(Link3 head, Link3 last)
	 {
		 if(last==null || head==last || head ==last.next )
		 {
			 return;
		 }
		 Link3 pivot = findPivot(head,last);
	//	 System.out.println(head.data);
	//	 System.out.println(pivot.data);
		 sorting(head,pivot.prev);
		 sorting(pivot.next,last);
	 }
	 
	 private Link3 findPivot(Link3 head, Link3 last)
	 {
		 Link3 pivot = last;
		 Link3 itr =head;
		 Link3 temp = head;
		 while(itr!=pivot)
		 {
			 if(itr.data < pivot.data)
			 {
				 int test = itr.data;
				 itr.data = temp.data;
				 temp.data = test;
				 temp = temp.next;
			 }
			 itr= itr.next;
		 }
		 int t = temp.data;
		 temp.data = pivot.data;
		 pivot.data = t;
		 return temp;
	 }
	 public void display(Link3 temp)
	 {
		 while(temp!=null)
		 {
			 temp.display();
			 temp = temp.next;
		 }
	 }
	 
	 public static void main(String args[])
	 {
		 QuickDoubleLink q = new QuickDoubleLink();
		 q.head = new Link3(30);
		 q.head.next = new Link3(3);
		 q.head.next.prev = q.head;
		 q.head.next.next = new Link3(4);
		 q.head.next.next.prev = q.head.next;
		 q.head.next.next.next = new Link3(20);
		 q.head.next.next.next.prev = q.head.next.next;
		 q.head.next.next.next.next = new Link3(5);
		 q.head.next.next.next.next.prev= q.head.next.next.next;
		 q.sort();
	 }
}

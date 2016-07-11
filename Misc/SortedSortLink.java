
public class SortedSortLink {
	private SortedSort first;
	public SortedSortLink()
	{
		first=null;
	}
	public void insertSort(int data)
	{
		 SortedSort newNode=new SortedSort(data);
		 SortedSort previous=null;
		 SortedSort current=first;
		 while(current!=null && data>current.data)
		 {
			 previous=current;
			 current=current.next;
		 }
		 if(previous==null)
			 first=newNode;
		 else
			 previous.next=newNode;
		 newNode.next=current;
	}
	public SortedSort removeFirst()
	{
		SortedSort temp=first;
		first=first.next;
		return temp;
	}
}

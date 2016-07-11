import java.util.HashMap;import java.util.HashMap;


class LinkLRU{
	public int data;
	public int key;
	public LinkLRU next;
	public LinkLRU prev;
	public LinkLRU(int key,int val)
	{
		data = val;
		this.key = key;
		next = null;
		prev =null;
	}
	public void display()
	{
		System.out.print(data+" ");
	}
}
class Queue_temp
{
	public LinkLRU head;
	public LinkLRU tail;
	int count = 0;
	int max_count;
	public Queue_temp(int cap)
	{
		head = null;
		tail = null;
		max_count = cap;
	}
	public LinkLRU add(int key, int val)
	{
		LinkLRU newNode = new LinkLRU(key,val);
		if(head == null)
		{
			head = newNode;
			tail = newNode;
			count++;
			return head;
		}
		else
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			count++;
			return head;
		}
	}
	
	public int delete()
	{
		if(head == null)
			return -1;
		else if(head==tail)
		{
			LinkLRU temp = head;
			head=null;
			tail = null;
			count--;
			return temp.key;
		}
		else
		{
			LinkLRU result = tail;
			LinkLRU temp = tail.prev;
			tail.prev = null;
			temp.next = null;
			tail = temp;
			count--;
			return result.key;
		}
	}
	public boolean isFull()
	{
		return count == max_count;
	}
	
	public int peek()
	{
		return head.data;
	}
	public int last()
	{
		return tail.data;
	}
}


public class LRUCache {

	private HashMap<Integer,LinkLRU> h ;
	private Queue_temp q ;
	int max;
	public LRUCache(int capacity)
	{
		h= new HashMap<Integer,LinkLRU>(capacity);
		q= new Queue_temp(capacity);
		max = capacity;
	}
	
	public int get(int key)
	{
		if(h.containsKey(key)==true)
			return (h.get(key)).data;
		return -1;
		
	}
	
	public void set(int key, int value)
	{
		if(h.containsKey(key)==false )
			add(q,h,key,value);
		else
		{
			LinkLRU temp = h.get(key);
			if(temp.data!=q.peek())
			{
				temp.prev.next = temp.next;
				if(temp.next!=null)
					temp.next.prev= temp.prev;
				if(temp.data == q.last())
				{
					q.tail = temp.prev;
					q.tail.next = null;
				}
				temp.next = q.head;
				q.head.prev = temp;
				q.head = temp;
				temp.data = value;
			}
			else
			{
			    temp.data = value;
			}
		}
	}
	
	public void add(Queue_temp a, HashMap<Integer,LinkLRU> h , int key, int val)
	{
		if(a.isFull() || h.size()>max)
		{
			int del = q.delete();
			h.remove(del);
		}
			LinkLRU temp = q.add(key,val);
			h.put(key, temp);
			return;
	}

/*	public void dis()
	{
		q.display();
	}
	*/
	public static void main(String args[])
	{
		LRUCache l = new LRUCache(2);
		l.set(2, 1);
		l.set(1, 1);
		System.out.println(l.get(2));
		l.set(4, 1);
		System.out.println(l.get(1));
		System.out.println(l.get(4));
		l.set(1,5);
		System.out.println(l.get(1));
		System.out.println(l.get(2));
	//	System.out.println(l.h.keySet());
	//	l.dis();
	}
}

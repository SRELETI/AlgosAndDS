class Heap4
{
	int data;
	public Heap4(int val)
	{
		data = val;
	}
	public void setKey(int val)
	{
		data = val;
	}
	
	public int getKey()
	{
		return data;
	}
}
public class HeapSortExample2 {

	public Heap4 arr[];
	public int length;
	public int cur_length;
	public HeapSortExample2(int val)
	{
		arr = new Heap4[val];
		length = val;
		cur_length = 0;
	}
	
	public void insert(int val)
	{
		if(cur_length==length)
			return;
		Heap4 temp = new Heap4(val);
		arr[cur_length]=temp;
		tickleUp(cur_length++);
	}
	
	public void tickleUp(int index)
	{
		int parent = (index-1)/2;
		Heap4 temp = arr[index];
		while(index>0 && arr[parent].getKey()<temp.getKey())
		{
			arr[index]=arr[parent];
			index = parent;
			parent= (parent-1)/2;
		}
		arr[index] = temp;
	}
	
	public Heap4 delete()
	{
		if(cur_length==0)
			return null;
		Heap4 delete_node = arr[0];
		arr[0]= arr[--cur_length];
		tickleDown(0);
		return delete_node;
	}
	
	public void tickleDown(int index)
	{
		int largestChild;
		int lchild;
		int rchild;
		Heap4 temp = arr[index];
		while(index<cur_length/2)
		{
		//	System.out.println(index+" "+cur_length);
			lchild = 2*index+1;
			rchild = lchild+1;
			if(rchild<cur_length && arr[rchild].getKey()>arr[lchild].getKey())
				largestChild = rchild;
			else
				largestChild = lchild;
			if(arr[largestChild].getKey()<=temp.getKey())
				break;
			arr[index] = arr[largestChild];
			index = largestChild;
		}
		arr[index] = temp;
	}
	
	public void change(int index, int val)
	{
		if(index<0 || index>=cur_length)
			return;
		int oldValue = arr[index].getKey();
		arr[index].setKey(val);
		if(oldValue<val)
		{
			tickleUp(index);
		}
		else
			tickleDown(index);
	}
	
	public void display()
	{
		for(int i=0;i<cur_length;i++)
			System.out.print(arr[i].getKey()+" ");
	}
	
	public static void main(String args[])
	{
		HeapSortExample2 h = new HeapSortExample2(10);
		h.insert(70);
		h.insert(60);
		h.insert(40);
		h.insert(80);
		h.insert(50);
		h.insert(55);
		Heap4 del = h.delete();
		System.out.println(del.getKey());
		System.out.println(h.delete().getKey());
	//	h.display();
		System.out.println(h.delete().getKey());
		System.out.println(h.delete().getKey());
		System.out.println(h.delete().getKey());
		System.out.println(h.delete().getKey());
	}
}

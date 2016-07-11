import java.util.Arrays;


class heap3
{
	int data;
	
	public heap3(int val)
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
public class HeapExample {

	private heap3 arr[];
	private int length;
	private int cur_length;
	public HeapExample(int val)
	{
		arr = new heap3[val];
		length = val;
		cur_length = 0;
	}
	
	public void insert(int val)
	{
		if(cur_length==length)
			return;
		arr[cur_length] = new heap3(val);
		tickleUp(cur_length++);
	}
	
	public void tickleUp(int index)
	{
		int parent = (index-1)/2;
		heap3 temp = arr[index];
		while(index>0 && arr[parent].getKey()<temp.getKey())
		{
			arr[index] = arr[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		arr[index]=temp;
	}
	
	public heap3 delete()
	{
		heap3 delete_node = arr[0];
		arr[0] = arr[--cur_length];
		trickleDown(0);
		return delete_node;
	}
	
	public void trickleDown(int index)
	{
		int largerChild;
		heap3 top = arr[index];
		int lchild;
		int rchild;
		while(index<cur_length/2)
		{
			lchild = 2*index+1;
			rchild = lchild+1;
			if(rchild<cur_length && arr[rchild].getKey()>arr[lchild].getKey())
				largerChild = rchild;
			else
				largerChild = lchild;
			
			if(top.getKey()>=arr[largerChild].getKey())
				break;
			arr[index] = arr[largerChild];
			index = largerChild;
		}
		arr[index] = top;
	}
	
	public void changeKey(int index, int val)
	{
		if(index<0 || index>=cur_length)
			return;
		int oldValue = arr[index].getKey();
		arr[index].setKey(val);
		if(oldValue<val)
			tickleUp(index);
		else
			trickleDown(index);
	}
	public void display()
	{
		for(int i=0;i<cur_length;i++)
			System.out.print(arr[i].getKey()+" ");
		System.out.println();
	}
	
	public static void main(String args[])
	{
		HeapExample h = new HeapExample(10);
		h.insert(70);
		h.insert(40);
		h.insert(50);
		h.insert(20);
		h.insert(60);
		h.insert(100);
	//	heap3 delete_node = h.delete();
		h.display();
	//	System.out.println(delete_node.getKey());
	}
}

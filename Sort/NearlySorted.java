import java.util.Arrays;



public class NearlySorted {

	public int data[];
	public int k;
	public int cur;
	public NearlySorted(int val)
	{
		data = new int[val];
		k=val;
		cur=0;
	}
	
	public void insert(int value)
	{
		if(cur==k)
			return;
		data[cur]=value;
		tickleUp(cur);
		cur++;
	}
	
	public void tickleUp(int index)
	{
		int parent = (index-1)/2;
		int temp = data[index];
		while(index>0 && data[parent]>temp)
		{
			data[index]=data[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		data[index] = temp;
	}
	
	public int delete()
	{
		if(cur==0)
			return -1;
		int del = data[0];
		data[0]	= data[--cur];
		tickleDown(0);
		return del;
	}
	
	public void tickleDown(int index)
	{
		int largestChild;
		int lchild;
		int rchild;
		int temp = data[index];
		while(index<cur/2)
		{
			lchild = 2*index+1;
			rchild = lchild+1;
			if(rchild<cur && data[rchild]<data[lchild])
				largestChild = rchild;
			else
				largestChild = lchild;
			if(data[largestChild]>=temp)
				break;
			data[index]=data[largestChild];
			index= largestChild;
		}
		data[index]= temp;
	}
	
	public static void main(String args[])
	{
		int[] arr = {2,6,3,12,56,8};
		int k =3;
		NearlySorted n = new NearlySorted(k);
		for(int i=0;i<k;i++)
		{
		//	System.out.println(arr[i]);
			n.insert(arr[i]);
		}
		int del;
		for(int i=k;i<arr.length;i++)
		{
			del = n.delete();
			n.insert(arr[i]);
		//	System.out.println(del);
			arr[i-k]=del;
		}
	//	System.out.println(Arrays.toString(arr));
		for(int i=arr.length-k;i<arr.length;i++)
			arr[i]=n.delete();
		System.out.println(Arrays.toString(arr));
	}
	
}

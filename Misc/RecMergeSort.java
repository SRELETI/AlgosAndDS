
public class RecMergeSort {
	private int[] arr;
	private int nElements;
	public RecMergeSort(int length)
	{
		arr=new int[length];
		nElements=0;
	}
	public void insert(int data)
	{
		arr[nElements]=data;
		nElements++;
	}
	public void sorting()
	{
		merge_sort(arr);
	}
	public int[] merge_sort(int[] arr)
	{
		if(arr.length<=1)
			return arr;
		int left[]=new int[arr.length/2];
		int right[]=new int[arr.length-left.length];
		for(int i=0;i<left.length;i++)
		{
			left[i]=arr[i];
		}
		for(int i=0;i<right.length;i++)
		{
			right[i]=arr[left.length+i];
		}
		merge_sort(left);
		merge_sort(right);
		merge(arr,left,right);
		return arr;
	}
	public void merge(int[] arr,int[] left,int[] right)
	{
		int i=0,j=0,k=0;
		while(i<left.length && j<right.length)
		{
			if(left[i]<right[j])
				arr[k++]=left[i++];
			else
				arr[k++]=right[j++];
		}
		while(i<left.length)
			arr[k++]=left[i++];
		while(j<right.length)
			arr[k++]=right[j++];
	}
	public void display()
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

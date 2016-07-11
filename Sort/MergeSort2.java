
public class MergeSort2 {
	public int[] arr;
	private int elements;
	public MergeSort2(int length)
	{
		arr = new int[length];
		elements=0;
	}
	public void insert(int value)
	{
		arr[elements++]=value;
	}
	public void display()
	{
		for(int i=0;i<elements;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public void merge(int[] arr2)
	{
		if(arr2.length<=1)
			return;
		int[] left= new int[arr2.length/2];
		int[] right = new int[arr2.length-arr2.length/2];
		for(int i=0;i<arr2.length/2;i++)
		{
			left[i]=arr2[i];
		}
		for(int i=arr2.length/2;i<arr2.length;i++)
		{
			right[i-arr2.length/2]=arr2[i];
		}
		merge(left);
		merge(right);
		mergeSort(arr2,left,right);
	}
	public void mergeSort(int[] arr3, int[] left, int[] right)
	{
		int i=0,j=0,k=0;
		while(i<left.length && j<right.length)
		{
			if(left[i]<=right[j])
				arr3[k++]=left[i++];
			else if(right[j]<left[i])
				arr3[k++]=right[j++];
		}
		while(i<left.length)
			arr3[k++]=left[i++];
		while(j<right.length)
			arr3[k++]=right[j++];
	}
}

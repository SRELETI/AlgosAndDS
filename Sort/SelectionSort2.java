
public class SelectionSort2 {
	public int[] arr;
	private int elements;
	public SelectionSort2(int length)
	{
		arr = new int[length];
		elements=0;
	}
	public void add(int value)
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
	
	public void selectionSort()
	{
		for(int i=0;i<arr.length-1;i++)
		{
			int iMin=i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]<arr[iMin])
					iMin=j;
			}
			int temp=arr[i];
			arr[i]=arr[iMin];
			arr[iMin]=temp;
		}
	}
	
	public void bubbleSort()
	{
		for(int i=0;i<arr.length;i++)
		{
			boolean flag=false;
			for(int j=0;j+1<arr.length-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					flag=true;
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			if(flag==false)
				return;
		}
	}
	
	public void insertionSort()
	{
		for(int i=1;i<arr.length;i++)
		{
			int key=arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>key)
			{
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
	}
	
	public void mergeSort(int[] input)
	{
		if(input.length<=1)
			return;
		int[] left= new int[input.length/2];
		int[] right = new int[input.length-(input.length/2)];
		for(int i=0;i<input.length/2;i++)
		{
			left[i]=input[i];
		}
		for(int i=input.length/2;i<input.length;i++)
		{
			right[i-input.length/2]=input[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(input,left,right);
	}
	
	public void merge(int[] arr2, int[] left, int[] right)
	{
		int i=0,j=0,k=0;
		while(i<left.length && j<right.length)
		{
			if(left[i]<right[j])
			{
				arr2[k++]=left[i++];
			}
			else if(left[i]>right[j])
				arr2[k++]=right[j++];
			else
			{
				arr2[k++]=left[i++];
				j++;
			}
		}
		while(i<left.length)
		{
			arr2[k++]=left[i++];
		}
		while(j<right.length)
		{
			arr2[k++]=right[j++];
		}
	}
}

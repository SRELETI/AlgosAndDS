
public class OrderedArray {
	private int[] arr;
	private int elements;
	public OrderedArray(int length)
	{
		arr=new int[length];
		elements=0;
	}
	public void size()
	{
		System.out.println(elements);
	}
	public int find(int value)
	{
		int start=0;
		int end=elements-1;
		while(start<=end)
		{
			int middle=(start+end)/2;
			if(arr[middle]==value)
			{
				System.out.println("The element is found at index "+middle);
				return middle;
			}
			if(arr[middle]>value)
				end=middle-1;
			else
				start=middle+1;
		}
		System.out.println("The element u have searched for is not in the array");
		return -1;
	}
	public void insert(int value)
	{
		int start=0;
		int end=elements-1;
		int result=-1;
		while(start<=end)
		{
			int middle=(start+end)/2;
			if((arr[middle]>value && middle-1<0) || (arr[middle]>value && arr[middle-1]<value))
			{
				result=middle; 
				break;
			}
			if(arr[middle]<value && arr[middle+1]>value)
			{
				result=middle+1;
				break;
			}
			if(arr[middle]>value)
				end=middle-1;
			else
				start=middle+1;
		}
		if(result==-1)
		{
			arr[elements]=value;
			elements++;
		}
		else
		{
			arr[elements]=arr[elements-1];
			elements++;
			for(int i=elements-1;i>result;i--)
				arr[i]=arr[i-1];
			arr[result]=value;
		}
	}
	public void display()
	{
		for(int i=0;i<elements;i++)
		{
			if(i==0)
				System.out.print('[');
			System.out.print(arr[i]);
			if(i!=elements-1)
			{
				System.out.print(',');
			}
			else
			{
				System.out.println(']');
			}
		}
	}
	public void delete(int value)
	{
		int result_index=find(value);
		if(result_index==-1)
			System.out.println("The element is not in the list to delete");
		else
		{
			for(int i=result_index;i<elements-1;i++)
				arr[i]=arr[i+1];
			elements--;
			System.out.println("The element "+value+" is deleted");
		}
	}
	public int[] merge(int[] arr1,int[] arr2)
	{
		int length1=arr1.length;
		int length2=arr2.length;
		int length;
		if(length1>=length2)
			length=length1;
		else
			length=length2;
		int[] result_arr=new int[2*length];
		int i=0,j=0,k=0;
		while(i<length1 && j<length2)
		{
			if(arr1[i]>arr2[j])
			{
				result_arr[k]=arr2[j];
				k++;
				j++;
			}
			else
			{
				result_arr[k]=arr1[i];
				k++;
				i++;
			}
		}
		while(i<length1)
		{
			result_arr[k]=arr1[i];
			k++;
			i++;	
		}
		while(j<length2)
		{
			result_arr[k]=arr2[j];
			k++;
			j++;
		}
		return result_arr;
	}
}


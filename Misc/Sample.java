
public class Sample {
	private int[] arr;
	private int elements;
	public Sample(int length)
	{
		arr=new int[length];
		elements=0;
	}
	public void insert(int value)
	{
		arr[elements]=value;
		elements++;
	}
	public void search(int value)
	{
		for(int i=0;i<elements;i++)
		{
			if(arr[i]==value)
			{
				System.out.println("Element found at index "+i);
				return;
			}
		}
		System.out.println("Element is not found");
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
		int i;
		for(i=0;i<elements;i++)
		{
			if(arr[i]==value)
				break;
		}
		if(i==elements)
		{
			System.out.println("The value "+value+ " is not found");
		}
		else if(i==elements-1)
		{
			elements--;
			System.out.println("Last element deleted");
		}
		else
		{
			for(int j=i;j<elements;j++)
			{
				arr[j]=arr[j+1];
			}
			System.out.println("The value "+value+ " is deleted");
			elements--;
		}
	}
	public int getMax()
	{
		int max=0;
		if(elements==0)
		{
			System.out.println("The Array is empty");
			return -1;
		}
		for(int i=1;i<elements;i++)
		{
			if(arr[max]<arr[i])
				max=i;
		}
		int result=arr[max];
		System.out.println("The max element in the array is "+result);
		return result;
	}
	public void removeMax(int value)
	{
		delete(value);
	}
	public void nodup(int value)
	{
		for(int i=0;i<elements;i++)
		{
			if(arr[i]==value)
			{
				for(int j=i+1;j<elements;j++)
				{
					if(arr[i]==arr[j])
						arr[j]=Integer.MIN_VALUE;
				}
			}
		}
		display();
		for(int i=elements-1;i>=0;i--)
		{
			if(arr[i]==Integer.MIN_VALUE)
			{
				delete(arr[i]);
			}
		}
	}
	public void sort()
	{
		for(int i=0;i<elements;i++)
		{
			for(int j=1;j<elements-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	public void SelectionSort()
	{
		int min;
		for(int i=0;i<elements-1;i++)
		{
			min=i;
			for(int j=i+1;j<elements;j++)
			{
				if(arr[j]<arr[i])
					min=j;
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
	}
	public void InsertionSort()
	{
		for(int i=1;i<elements;i++)
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
}

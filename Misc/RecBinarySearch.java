
public class RecBinarySearch {
	private int[] arr;
	private int length;
	public RecBinarySearch()
	{
		arr=new int[30];
		length=0;
	}
	public int binarySearch(int element, int start, int end)
	{
		if(start>end)
			return -1;
		int middle=(start+end)/2;
		if(arr[middle]==element)
			return middle;
		else if(element>arr[middle])
		{
			return binarySearch(element,middle+1,end);
		}
		else
			return binarySearch(element,start,middle-1);
	}
	public void insert(int data)
	{
		int i=0;
		for(i=0;i<length;i++)
		{
			if(arr[i]>data)
				break;
		}
		int j;
		for( j=length;j>i;j--)
			arr[j]=arr[j-1];
		arr[i]=data;
		length++;
	}
	public void display()
	{
		for(int i=0;i<length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public int search(int element)
	{
		return binarySearch(element,0,length-1);
	}
	
}

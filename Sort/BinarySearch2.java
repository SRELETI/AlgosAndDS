
public class BinarySearch2 {
	private int[] arr;
	private int elements;
	public BinarySearch2(int length)
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
	
	public int binarySearch(int value)
	{
		int l=0;
		int r=arr.length-1;
		System.out.println(arr.length);
		while(l<=r)
		{
			int middle=l+(r-l)/2;
			if(arr[middle]==value)
				return middle;
			else if(arr[middle]<value)
				l=middle+1;
			else
				r=middle-1;
		}
		return -1;
	}
	public int binarySearch(int value,int l,int r)
	{
		if(r<l)
			return -1;
		int middle=l+(r-l)/2;
		if(arr[middle]==value)
			return middle;
		else if(arr[middle]<value)
			return binarySearch(value,middle+1,r);
		else
			return binarySearch(value,l,middle-1);
	}
	
}


public class Binarysearch {
	public int search(int arr[],int value)
	{
		int left=0;
		int right=arr.length-1;
		while(left<=right)
		{
			int middle=(left+right)/2;
			if(arr[middle]==value)
				return middle;
			else if(arr[middle]>value)
				right=middle-1;
			else 
				left=middle+1;
		}
		return -1;
	}
	public static void main(String args[])
	{
		int arr[]={4,6,7,9,10,12};
		Binarysearch bs=new Binarysearch();
		System.out.print(bs.search(arr, 15));
	}
}

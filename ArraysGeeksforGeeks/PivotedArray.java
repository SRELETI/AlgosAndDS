
public class PivotedArray {
	public int pivoted(int arr[],int key)
	{
		int left=0;
		int right=arr.length-1;
		while(left<=right)
		{
			int middle=(left+right)/2;
			if(arr[middle]==key)
				return middle;
			else if(arr[left]<arr[middle])
			{
				if(arr[left]<=key && key<arr[middle])
				{
					right=middle-1;
				}
				else
					left=middle+1;
			}
			else
			{
				if(arr[middle]<key && key <=arr[right])
					left=middle+1;
				else
					right=middle-1;
			}
		}
		return -1;
	}
	public int pivotedElement(int[] ar)
	{
		int left=0;
		int right=ar.length-1;
		while(ar[left]>ar[right])
		{
			int middle=left+((right-left)/2);
			if(ar[middle]>ar[right])
				left=middle+1;
			else
				right=middle;
		}
		return left;
	}
	public static void main(String args[])
	{
		int arr[]={4,5,6,1,2,3};
		PivotedArray pa = new PivotedArray();
		System.out.println(pa.pivoted(arr, 8));
		System.out.println(pa.pivotedElement(arr));
	}
}

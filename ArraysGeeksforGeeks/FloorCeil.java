
public class FloorCeil {
	public static int ceil(int arr[], int x)
	{
		int len=arr.length;
		if(x<=arr[0])
			return 0;
		for(int i=0;i<len-1;i++)
		{
			if(arr[i]==x)
				return i;
			else if(arr[i]< x && arr[i+1]>=x)
				return i+1;
		}
		return -1;
	}
	public static int floor(int arr[], int x)
	{
		int len=arr.length;
		if(arr[len-1]<x)
			return len-1;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==x)
				return i;
			if(arr[i-1]<=x && arr[i]>x)
				return i-1;
		}
		return -1;
	}
	public static int binary_ceil(int[] arr,int left, int right, int x)
	{
		if(x<=arr[0])
			return 0;
		if(x>arr[right])
			return -1;
		int middle=(left+right)/2;
		if(arr[middle]==x)
			return middle;
		else if(arr[middle]<x)
		{
			if(middle+1<=right && x<=arr[middle+1])
				return middle+1;
			else
				return binary_ceil(arr,middle+1,right,x);
		}
		else
		{
			if(middle-1<left && arr[middle-1]<x)
				return middle;
			else
				return binary_ceil(arr,left,middle-1,x);
		}
		
	}
	public static int binary_floor(int[] arr, int left, int right, int x)
	{
		if(x<arr[0])
			return -1;
		if(x>=arr[right])
			return right;
		int middle=left+(right-left)/2;
		if(arr[middle]==x)
			return middle;
		if(arr[middle]>x)
		{
			if(middle-1>=left && arr[middle-1]<x)
				return middle-1;
			else
				return binary_floor(arr,left,middle-1,x);
		}
		else
		{
			if(middle+1<=right && arr[middle+1]>=x)
				return middle;
			else
				return binary_floor(arr,middle+1,right,x);
		}
	}
	public static void main(String args[])
	{
		int arr[]={1,2,8,10,10,12,19};
		System.out.println(ceil(arr,19));
		System.out.println(floor(arr,11));
		System.out.println(binary_ceil(arr,0,arr.length-1,20));
		System.out.println(binary_floor(arr,0,arr.length-1,11));
	}
}

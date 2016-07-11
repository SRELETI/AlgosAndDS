
public class CountOcc {
	public static void main(String args[])
	{
		int[] arr= {1,1,2,2,2,2,3};
		count(arr,4);
		count_app(arr,4);
	}
	public static void count(int[] arr, int x)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==x)
				count++;
		}
		System.out.println("The element "+x+" occured "+count+" times");
	}
	public static void count_app(int[] arr, int x)
	{
		int low=count_mod(arr,0,arr.length-1,x);
		int high=count_mod_high(arr,0,arr.length-1,x);
		int result=high-low+1;
		if(result==1)
			System.out.println(" The element is not present ");
		else
			System.out.println("The element "+x+" has repeated "+result+" times");
	}
	
	public static int count_mod(int[] arr, int left, int right, int x)
	{
			if(left>right)
				return -1;
			int middle=left+(right-left)/2;
			if((middle-1<left || arr[middle-1]!=x ) && arr[middle]==x)
				return middle;
			if(arr[middle]>=x)
				return count_mod(arr,left,middle-1,x);
			else
				return count_mod(arr,middle+1,right,x);
	}
	public static int count_mod_high(int arr[], int left, int right, int x)
	{
			if(left>right)
				return -1;
			int middle=left+(right-left)/2;
			if((middle+1>right || arr[middle+1]!=x ) && arr[middle]==x)
				return middle;
			if(arr[middle]>x)
				return count_mod_high(arr,left,middle-1,x);
			else
				return count_mod_high(arr,middle+1,right,x);
	}
}

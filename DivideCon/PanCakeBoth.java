import java.util.Arrays;


public class PanCakeBoth {

	public void firstMethod(int[] arr)
	{
		System.out.println(Arrays.toString(arr));
		for(int i=arr.length-1;i>=0;i--)
		{
			int max = findMax(arr,i);
			flip(arr,max);
			flip(arr,i);
		}
		System.out.println(Arrays.toString(arr));
	}
	private void flip(int[] arr, int end)
	{
		int temp,start=0;
		while(start<end)
		{
			temp =arr[start];
			arr[start]= arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
	private int findMax(int[] arr, int i)
	{
		int max=0;
		for(int j=1;j<=i;j++)
		{
			if(arr[j]>arr[max])
				max = j;
		}
		return max;
	}
	
	public static void main(String args[])
	{
		PanCakeBoth p = new PanCakeBoth();
		int[] arr = {8,9,5,6,4,2,3,1};
		p.firstMethod(arr);
		p.second_method(arr);
	}
	
	public void second_method(int[] arr)
	{
		
		int i,j;
		for(i=1;i<arr.length;i++)
		{
			j= ceil(arr,0,i-1,arr[i]);
			if(j!=-1)
			{
				flip(arr,j-1);
				flip(arr,i-1);
				flip(arr,i);
				flip(arr,j);
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	private int ceil(int[] arr, int low, int high, int val)
	{
		if(val<=arr[low])
			return low;
		if(val>arr[high])
			return -1;
		int mid = (low+high)>>1;
		if(arr[mid]==val)
			return mid;
		else if(val>arr[mid])
		{
			if(mid+1<=high && val<=arr[mid+1])
				return mid+1;
			else
				return ceil(arr,mid+1,high,val);
		}
		else
		{
			if(mid-1>=low && val>arr[mid-1])
				return mid;
			else
				return ceil(arr,low,mid-1,val);
		}
	}
}

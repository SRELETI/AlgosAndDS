import java.util.Arrays;


public class PancakeMod {

	public void modified(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			int j = ceil(arr,0,i-1,arr[i]);
			
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
	private void flip(int[] arr, int i)
	{
		int temp,start=0;
		while(start<i)
		{
			temp = arr[start];
			arr[start]= arr[i];
			arr[i]=temp;
			start++;
			i--;
		}
	}
	public int ceil(int[] arr, int low,int high, int val)
	{
		if(val<=arr[low])
			return low;
		if(val>arr[high])
			return -1;
		int mid = (low+high)/2;
		if(arr[mid]==val)
			return mid;
		if(arr[mid]>val)
		{
			if(mid-1>=low && val>arr[mid-1])
				return mid;
			else
				return ceil(arr,low,mid-1,val);
		}
		else
		{
			if(mid+1<=high && arr[mid+1]>=val)
				return mid+1;
			else
				return ceil(arr,mid+1,high,val);
		}
	}
	
	public static void main(String args[])
	{
		int[] arr = {18, 40, 35, 12, 30, 35, 20, 6, 90, 80};
		PancakeMod p = new PancakeMod();
		p.modified(arr);
	}
}

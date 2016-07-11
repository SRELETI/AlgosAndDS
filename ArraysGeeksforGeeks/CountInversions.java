
public class CountInversions {

	public void inversion(int[] arr)
	{
		int inv_count=0;
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
					inv_count++;
			}
		}
		System.out.println(inv_count);
	}
	
	public static void main(String args[])
	{
		CountInversions c = new CountInversions();
		int[] arr  = {2,4,1,3,5};
	//	c.inversion(arr);
	//	c.merge_st(arr);
		int[] temp = {1,2,3,3,3,3,10};
		c.maj(temp, 7);
		c.majority(temp, 7);
	}
	
	public void merge_st(int[] arr)
	{
		int len = arr.length;
		int[] temp = new int[len];
		int result = merge_sort(arr,temp,0,arr.length-1);
		System.out.println(result);
	}
	
	private int merge_sort(int[] arr, int[] temp , int start, int end)
	{
		int mid, inv_count=0;
		if(end>start)
		{
			mid = (start+end)/2;
			inv_count = merge_sort(arr,temp,start,mid);
			inv_count = inv_count + merge_sort(arr,temp,mid+1,end);
			
			inv_count = inv_count + merge(arr,temp,start,mid+1,end);
		}
		return inv_count;
	}
	
	
	private int merge(int[] arr, int[] temp, int start, int mid, int end)
	{
		int inv_count=0;
		int i,j,k;
		i = start;
		j = mid;
		k = start;
		
		while(i<=mid-1 && j<=end)
		{
			if(arr[i]<=arr[j])
				temp[k++] = arr[i++];
			else 
			{
				temp[k++] = arr[j++];
				inv_count = inv_count + mid-i;
			}
			
		}
		while(i<=mid-1)
		{
			temp[k++]= arr[i++];
		}
		while(j<=end)
		{
			temp[k++] = arr[j++];
		}
		
		for(i=start;i<=end;i++)
			arr[i] = temp[i];
		
		return inv_count;
	}
	
	
	public void maj(int[] arr, int element)
	{
		for(int i=0;i<arr.length/2;i++)
		{
			if(arr[i]==element)
			{
				if(arr[i+arr.length/2]==element)
				{
					System.out.println("yes majority element ");
					return;
				}
			}
		}
	}
	
	
	public void majority(int[] arr, int element)
	{
		int majority_index = majority_ind(arr,element,0,arr.length-1);
		if(majority_index == -1)
		{
			System.out.println("No Such element found");
			return;
		}
		if(majority_index+ arr.length/2 <= arr.length && arr[majority_index+(arr.length/2)]==element)
		{
			System.out.println("yes majority element found ");
		}
		else 
		{
			System.out.println("No Najority element found ");
		}
	}
	
	private int majority_ind(int[] arr, int element, int start, int end)
	{
		if(start>end)
			return -1;
		else
		{
			int mid = (start+end)/2;
			if(mid<end && arr[mid+1]==element && arr[mid]!=arr[mid])
				return mid+1;
			else if(mid==0 || mid>start && arr[mid]==element && arr[mid-1]!=arr[mid])
				return mid;
			else if(arr[mid]<element)
				return majority_ind(arr,element,mid+1,end);
			else
				return majority_ind(arr,element,start,mid-1);
		}
	}
}

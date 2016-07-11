
public class MissNum {

	public void missing(int[] arr)
	{
		if(arr[0]!=0)
		{
			System.out.println(0);
			return ;
		}
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i+1]-arr[i]!=1)
			{
				System.out.println(arr[i]+1);
				return;
			}
				
		}
		System.out.println(arr[arr.length-1]+1);
		
	}
	
	public int binary_missing(int[] arr,int start, int end)
	{
		if(start>end)
			return end+1;
		if(arr[start]!=start)
			return start;
		int middle = start + (end -start)/2;
		if(arr[middle]>middle)
			return binary_missing(arr,start,middle-1);
		else 
			return binary_missing(arr,middle+1,end);
	}
	public static void main(String args[])
	{
		int[] arr = {0, 1, 2, 6, 9};
		MissNum m = new MissNum();
		m.missing(arr);
		System.out.println(m.binary_missing(arr, 0, 4));
	}
}

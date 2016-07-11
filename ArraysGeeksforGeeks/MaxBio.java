
public class MaxBio {

	public void bio(int[] arr)
	{
		if(arr.length==0)
		{
			System.out.println("invalid input ");
			return;
		}
		if(arr.length==1)
		{
			System.out.println(1);
			System.out.println(arr[0]);
			return;
		}
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		
		left[0]=1;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i-1]<arr[i])
				left[i]=left[i-1]+1;
			else
				left[i]=1;
		}
		
		right[arr.length-1]=1;
		for(int i=arr.length-2;i>=0;i--)
		{
			if(arr[i]>arr[i+1])
				right[i]=right[i+1]+1;
			else
				right[i]=1;
		}
		
		int max = left[0]+right[0]-1;
		int start = 0;
		int end = 1-right[0];
		for(int i=1;i<arr.length;i++)
		{
			if(left[i]+right[i]-1>max)
			{
				start = i-left[i]+1;
				end = i+right[i]-1;
				max = left[i]+right[i]-1;
			}
		}
		System.out.println(max);
		for(int i=start;i<=end;i++)
			System.out.print(arr[i]+" ");
	}
	
	public static void main(String args[])
	{
		int[] arr = {12, 4, 78, 90, 45, 23};
		MaxBio m = new MaxBio();
		m.bio(arr);
	}
}

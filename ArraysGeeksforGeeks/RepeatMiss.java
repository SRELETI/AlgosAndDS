import java.util.Arrays;


public class RepeatMiss {
	public static void main(String args[])
	{
		int[] arr = {6,1,5,4,4,2};
		//repeat(arr);
		//repeat_count(arr);
		repeat_count_mod(arr);
	}
	public static void repeat(int[] arr)
	{
		Arrays.sort(arr);
		int temp=arr[0];
		if(arr[0]!=1)
			System.out.println("Missing element is "+1);
		if(arr[arr.length-1]!=arr.length)
			System.out.println("Missing element is "+arr.length);
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]-arr[i-1]==0)
			{
				System.out.println("Repeating element is "+arr[i]);
			}
			if(arr[i]-arr[i-1]>1)
			{
				System.out.println("The missing element is "+(arr[i-1]+1));
			}
		}
	}
	public static void repeat_count(int[] arr)
	{
		int[] count= new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			if(count[arr[i]-1]!=0)
			{
				System.out.println("the repeating element is "+arr[i]);
			}
			else
			{
				count[arr[i]-1]=1;
			}			
		}
		for(int i=0;i<count.length;i++)
		{
			if(count[i]==0)
			{
				System.out.println("the missing element is "+(i+1));
				break;
			}
				
		}
	}
	public static void repeat_count_mod(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[Math.abs(arr[i])-1]<0)
			{
				System.out.println("The repeating element is "+Math.abs(arr[i]));
			}
			else
			{
				arr[Math.abs(arr[i])-1]=-arr[Math.abs(arr[i])-1];
			}
		}
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>0)
			{
				System.out.println("the missing element is "+(i+1));
				break;
			}
		}
	}
}

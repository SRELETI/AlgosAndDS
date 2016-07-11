
public class TwoRepeating {
	public static void repeat(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
					System.out.println(arr[i]);
			}
		}
	}
	public static void mof_repeat(int[] arr)
	{
		int[] count = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			if(count[arr[i]]==1)
				System.out.println(arr[i]);
			count[arr[i]]++;
		}
	}
	public static void max_mod_repeat(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[Math.abs(arr[i])]>0)
				arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
			else
				System.out.println(Math.abs(arr[i]));
		}
	}
	public static void main(String args[])
	{
		int arr[]= {4,2,4,5,2,3,1};
		repeat(arr);
		mof_repeat(arr);
		max_mod_repeat(arr);
	}
}

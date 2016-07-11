import java.util.Arrays;


public class Triplet {
	public static void main(String args[])
	{
		int[] arr={12, 3, 4, 1, 6, 9};
		triple(arr,24);
		mod_triple(arr,24);
	}
	public static void triple(int[] arr, int sum)
	{
		for(int i=0;i<arr.length-2;i++)
		{
			for(int j=i+1;j<arr.length-1;j++)
			{
				for(int k=j+1;k<arr.length;k++)
				{
					if(arr[i]+arr[j]+arr[k]==sum)
					{
						System.out.println("The triplet is present at following indexes "+arr[i]+" "+arr[j]+" "+arr[k]);
					}
				}
			}
		}
	}
	public static void mod_triple(int[] arr, int sum)
	{
		Arrays.sort(arr);
		for(int i=0;i<arr.length-2;i++)
		{
			int left=i+1;
			int right=arr.length-1;
			while(left<arr.length && right>=0)
			{
				if(arr[left]+arr[right]+arr[i]==sum)
				{
					System.out.println("The triplet is "+arr[i]+" "+arr[left]+" "+arr[right]);
					return;
				}
				else if(arr[i]+arr[left]+arr[right]<sum)
					left++;
				else
					right--;
			}
		}
		System.out.println("The triplet is not found ");
	}
	
}

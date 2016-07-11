import java.util.Arrays;


public class Repeat {
	
	public static void main(String[] args)
	{
		int[] arr = {4,2,4,5,6,3,5};
		repeat(arr);
		repeat_mod(arr);
		repeat_mod2(arr);
		int[] arr2={0,1,1,0,1,2,1,2,0,0,0,1};
		sort(arr2);
	}
	public static void repeat(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
					System.out.println("The repeated elements are "+arr[i]);
			}
		}
	}
	public static void repeat_mod(int[] arr)
	{
		boolean count[] = new boolean[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			if(count[arr[i]]!=false)
				System.out.println(arr[i]);
			count[arr[i]]=true;
		}
	}
	public static void repeat_mod2(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[Math.abs(arr[i])]>0)
				arr[Math.abs(arr[i])]=-arr[Math.abs(arr[i])];
			else
				System.out.println(Math.abs(arr[i]));
		}
	}
	public static void sort(int[] arr)
	{
		int left=0;
		int middle=0;
		int right=arr.length-1;
		while(middle<=right)
		{
			if(arr[middle]==0)
			{
				arr[middle]=arr[left];
				arr[left]=0;
				left++;
				middle++;
				
			}
			if(arr[middle]==1 && middle<=right)
				middle++;
			if(arr[middle]==2 && middle<=right)
			{
				arr[middle]=arr[right];
				arr[right]=2;
				right--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}	

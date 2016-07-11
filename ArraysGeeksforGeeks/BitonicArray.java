import java.util.Arrays;


public class BitonicArray {
	public static void main(String args[])
	{
		int[] arr = {40,30,20,10};
		biotonic(arr);
	}
	public static void biotonic(int arr[])
	{
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int count=1;
		left[0]=1;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i-1]<=arr[i])
			{
				count=count+1;
				left[i]=count;
			}
			else
			{
				count=1;
				left[i]=count;
			}
		}
		System.out.println(Arrays.toString(left));
		right[arr.length-1]=1;
		for(int i=arr.length-2;i>=0;i--)
		{
			if(arr[i]>=arr[i+1])
			{
				count=count+1;
				right[i]=count;
			}
			else
			{
				count=1;
				right[i]=count;
			}
		}
		int max_bio=0;
		int index=-1;
		for(int i=0;i<left.length;i++)
		{
			if(left[i]+right[i]-1>max_bio)
			{
				max_bio=left[i]+right[i]-1;
				index=i;
			}
		}
		System.out.println("The biotonic series is of length "+max_bio+ " with k at "+index);
	}

}

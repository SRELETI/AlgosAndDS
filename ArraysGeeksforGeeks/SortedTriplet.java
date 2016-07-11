import java.util.Arrays;


public class SortedTriplet {
	public static void main(String args[])
	{
		int[] arr = { 1, 2, 3, 8,7,5,6,10,11};
		triplet(arr);
	}
	public static void triplet(int[] arr)
	{
		int[] left = new int[arr.length];
		int[] right = new int [arr.length];
		int min=0;
		int max=arr.length-1;
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<=arr[min])
			{
				min=i;
				left[i]=-1;
			}
			else
				left[i]=min;
		}
		for(int i=arr.length-1;i>=0;i--)
		{
			if(arr[i]>=arr[max])
			{
				max=i;
				right[i]=-1;
			}
			else
				right[i]=max;
		}
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		int left_index=1;
		int right_index=arr.length-2;
		while(left_index<arr.length-2 && right_index>=1)
		{
			if(left[left_index]!=-1 && right[right_index]!=-1 && arr[left_index]<arr[right_index])
			{
				System.out.println("The triplet is "+arr[left[left_index]]+" "+arr[left_index]+" "+arr[right_index]+" "+arr[right[right_index]]);
				return;
			}
			if(left[left_index]==-1 || arr[left_index]>arr[right_index])
				left_index++;
			if(right[right_index]==-1)
				right_index--;
		}
		System.out.println("no such triplet");
	}
}

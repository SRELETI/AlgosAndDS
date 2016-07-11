import java.util.Arrays;


public class CountingSortExample {

	public void countSort(int[] arr)
	{
		if(arr.length<=1)
			return;
		int min = arr[0];
		int max = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<min)
				min = arr[i];
			if(arr[i]>max)
				max = arr[i];
		}
		int range = max-min+1;
		int[] count = new int[range];
		for(int i=0;i<arr.length;i++)
			count[arr[i]-min]++;
		for(int i=1;i<count.length;i++)
			count[i]= count[i]+count[i-1];
		int j=0;
		for(int i=0;i<count.length;i++)
		{
			while(j<count[i])
				arr[j++]=i+min;
		}
	}
	public static void main(String args[])
	{
		int[] arr = {54, 67, 13, 24, 76, 37, 97, 10, 67, 24, 6, 28, 5, 19, 63, 1, 71, 83, 97, 24};
		CountingSortExample c = new CountingSortExample();
		System.out.println(Arrays.toString(arr));
		c.countSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

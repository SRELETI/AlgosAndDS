import java.util.Arrays;


public class StockSpan {
	public static void main(String args[])
	{
		int[] arr = {100, 80, 60, 70, 60, 75, 85};
		stock(arr);
	}
	public static void stock(int[] arr)
	{
		int stock[] = new int[arr.length];
		int count;
		for(int i=0;i<arr.length;i++)
		{
			count=1;
			for(int j=i-1;j>=0;j--)
			{
				if(arr[j]<arr[i])
					count++;
				else 
					break;
			}
			stock[i]=count;
		}
		System.out.println(Arrays.toString(stock));
	}
}

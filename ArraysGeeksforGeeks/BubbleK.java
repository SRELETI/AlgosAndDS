import java.util.Arrays;


public class BubbleK {

	public void bubble(int[] arr,int k)
	{
		for(int i=0;i<k;i++)
		{
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j]= arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for(int i =arr.length-k;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		
	}
	
	public static void main(String args[])
	{
		BubbleK b = new BubbleK();
		int[] rr = {1,23,12,9,30,2,50};
		b.bubble(rr,2);
	}
}

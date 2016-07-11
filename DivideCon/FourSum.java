import java.util.Arrays;


public class FourSum {

	public void four(int[] arr, int p)
	{
		for(int i=0;i<arr.length-3;i++)
		{
			for(int j=i+1;j<arr.length-2;j++)
			{
				for(int k=j+1;k<arr.length-1;k++)
				{
					for(int l=k+1;l<arr.length;l++)
					{
						if(arr[i]+arr[j]+arr[k]+arr[l]==p)
							System.out.println("Found: "+i+" "+j+" "+k+" "+l);
					}
				}
			}
		}
	}
	
	public void four_second(int[] arr, int p)
	{
		Arrays.sort(arr);
		int k,l;
		for(int i=0;i<arr.length-3;i++)
		{
			for(int j=i+1;j<arr.length-2;j++)
			{
				k = j+1;
				l = arr.length-1;
				
				while(k<l)
				{
					int temp =arr[i]+arr[j]+arr[k]+arr[l];
					if(temp==p)
					{
						System.out.println("Found at: "+i+" "+j+" "+k+" "+l);
						k++;
						l--;
					}
					else if(temp<p)
						k++;
					else
						l--;
				}
			}
		}
	}
	
	
	public static void main(String args[])
	{
		int[] arr = {16, 17, 4, 3, 5, 2};
		FourSum f = new FourSum();
	//	f.four(arr, 91);
	//	f.four_second(arr, 91);
		f.nextGreater(arr);
	}
	
	public void nextGreater(int[] arr)
	{
		int max=arr[arr.length-1];
		arr[arr.length-1]=-1;
		for(int i=arr.length-2;i>=0;i--)
		{
			int temp =max;
			if(arr[i]>max)
				max=arr[i];
			arr[i] =temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}

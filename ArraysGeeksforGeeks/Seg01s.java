import java.util.Arrays;


public class Seg01s {

	public void seg(int[] arr)
	{
		int i=0;
		int j=0;
		for(i=0;i<arr.length;i++)
		{
			if(arr[i]!=1)
			{
				arr[j]=arr[i];
				j++;
			}
		}
		
		for(i=j;i<arr.length;i++)
			arr[i]=1;
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void main(String args[])
	{
		Seg01s s = new Seg01s();
		int[] arr = {0,1,0,1,0,0,1,1,1,0};
		s.seg(arr);
		s.seg2(arr);
	}
	
	
	public void seg2(int[] arr)
	{
		int start = 0;
		int end = arr.length-1;
		while(start<end)
		{
			while(arr[start]==0 && start<end)
				start++;
			while(arr[end]==1 && end>start)
				end--;
			if(start<end)
			{
				arr[start]=0;
				arr[end]=1;
				start++;
				end--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}

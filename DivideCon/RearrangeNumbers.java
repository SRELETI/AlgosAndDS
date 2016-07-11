import java.util.Arrays;



public class RearrangeNumbers {

	public void rearrange(int[] arr)
	{
		int i=0;
		int j;
		for(j=0;j<arr.length;j++)
		{
			if(arr[j]<0)
			{
				swap(arr,i,j);
				i++;
			}
		}
		
		int pos = i;
		int neg = 0;
		while(pos<arr.length && neg<pos && arr[neg]<0)
		{
			swap(arr,pos,neg);
			pos++;
			neg=neg+2;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void swap(int[] arr, int i,int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String args[])
	{
		int[] arr  = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		RearrangeNumbers r = new RearrangeNumbers();
		r.rearrange(arr);
		
	}
}

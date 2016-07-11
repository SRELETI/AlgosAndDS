import java.util.Arrays;


public class ProductArr {

	public void construct(int[] arr)
	{
		int[] prod = new int[arr.length];
		int temp =1;
		int left[] = new int[arr.length];
		int right[] = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			left[i]=temp;
			temp = temp * arr[i];
		}
		
		temp =1;
		for(int i=arr.length-1;i>=0;i--)
		{
			right[i]= temp;
			temp = temp*arr[i];
		}
		for(int i=0;i<prod.length;i++)
			prod[i]= left[i]*right[i];
		
		System.out.println(Arrays.toString(prod));
	}
	
	public static void main(String args[])
	{
		ProductArr p = new ProductArr();
		int[] arr = {10,3,5,6,2};
		p.construct(arr);
		p.con(arr);
	}
	
	public void con(int[] arr)
	{
		int[] prod = new int[arr.length];
		int temp=1;
		for(int i=0;i<arr.length;i++)
		{
			prod[i]= temp;
			temp = temp*arr[i];
		}
		
		temp = 1;
		for(int i=arr.length-1;i>=0;i--)
		{
			prod[i]=prod[i]*temp;
			temp = temp * arr[i];
		}
		
		System.out.println(Arrays.toString(prod));
	}
	
	
}

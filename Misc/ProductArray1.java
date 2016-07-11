import java.util.Arrays;


public class ProductArray1 {
	public static void main(String args[])
	{
		int[] arr = {10,3,5,6,2};
		product(arr);
	}
	public static void product(int[] arr)
	{
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		left[0]=1;
		right[arr.length-1]=1;
		for(int i=1;i<arr.length;i++)
			left[i]=left[i-1]*arr[i-1];
		for(int i=arr.length-2;i>=0;i--)
			right[i]=right[i+1]*arr[i+1];
		int[] product = new int[arr.length];
		for (int i=0;i<product.length;i++)
			product[i]=left[i]*right[i];
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(product));
	}
}

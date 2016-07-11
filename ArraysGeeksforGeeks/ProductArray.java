import java.util.Arrays;


public class ProductArray {
	public static void product(int[] arr)
	{
		int[] left=new int[arr.length];
		int[] right= new int[arr.length];
		int[] prod= new int[arr.length];
		left[0]=1;
		right[arr.length-1]=1;
		for(int i=1;i<arr.length;i++)
			left[i]=left[i-1]*arr[i-1];
		for(int j=arr.length-2;j>=0;j--)
			right[j]=right[j+1]*arr[j+1];
		for(int i=0;i<arr.length;i++)
			prod[i]=left[i]*right[i];
		System.out.println(Arrays.toString(prod));
	}
	public static void main(String args[])
	{
		int[] arr = {10,3,5,6,2};
		product(arr);
	}
}

import java.util.Arrays;


public class ArrayRotate {

	public void rot(int[] arr,int d)
	{
		int[] temp = new int[d];
		for(int i=0;i<d;i++)
			temp[i]=arr[i];
		int j=0;
		for(int i=d;i<arr.length;i++)
			arr[j++]=arr[i];
		j=0;
		for(int i=arr.length-d;i<arr.length;i++)
			arr[i]=temp[j++];
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String args[])
	{
		ArrayRotate a = new ArrayRotate();
		int[] arr = {1,2,3,4,5};
	//	a.rot(arr, 0);
	//	a.rot_2(arr, 4);
	//	a.arr_rot(arr, 0);
		a.rot_rev(arr, 4);
	}
	
	public void rot_2(int[] arr, int d)
	{
		for(int i=0;i<d;i++)
		{
			int temp = arr[0];
			int j;
			for(j=1;j<arr.length;j++)
				arr[j-1]=arr[j];
			arr[j-1]=temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	private int gcd(int a, int b)
	{
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	public void arr_rot(int[] arr, int d)
	{
		int j,temp,k;
		for(int i=0;i<gcd(d,arr.length);i++)
		{
			temp = arr[i];
			j=i;
			while(true)
			{
				k = j+d;
				if(k>=arr.length)
					k = k-arr.length;
				if(k==i)
					break;
				arr[j]=arr[k];
				j=k;
			}
			arr[j]=temp;
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public void rot_rev(int[] arr, int d)
	{
		reverse(arr,0,d-1);
		reverse(arr,d,arr.length-1);
		reverse(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	private void reverse(int[] arr, int start, int end)
	{
		while(start<end)
		{
			int temp =arr[start];
			arr[start]= arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
}

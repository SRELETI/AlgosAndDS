import java.util.Arrays;


public class RotateArray {
	public int[] rotate(int arr[],int n,int d)
	{
		int[] temp=new int[d];
		for(int i=0;i<d;i++)
			temp[i]=arr[i];
		for(int i=0;d+i<n;i++)
			arr[i]=arr[d+i];
		for(int i=n-d,j=0;i<n && j<d;i++,j++)
			arr[i]=temp[j];
		return arr;
	}
	public void second_rotate(int arr[],int n,int d)
	{
		for(int i=0;i<d;i++)
			left_rotate(arr);
		System.out.println(Arrays.toString(arr));
	}
	public void left_rotate(int arr[])
	{
		int i;
		int temp=arr[0];
		for(i=0;i+1<arr.length;i++)
			arr[i]=arr[i+1];
		arr[i]=temp;
	}
	public int gcd(int n,int d)
	{
		if(d==0)
			return n;
		return gcd(d,n%d);
	}
	public int[] third_rotate(int arr[],int n,int d)
	{
		int i,j,k,temp;
		int result=gcd(n,d);
		for(i=0;i<result;i++)
		{
			temp=arr[i];
			j=i;
			while(true)
			{
				k=j+d;
				if(k>=n)
					k=k-n;
				if(k==i)
					break;
				arr[j]=arr[k];
				j=k;
			}
			arr[j]=temp;
		}
		return arr;
	}
	public int[] fourth_rotate_reversal(int[] arr, int n, int d)
	{
		reverse(arr,0,d-1);
		reverse(arr,d,n-1);
		reverse(arr,0,n-1);
		return arr;
	}
	public void reverse(int[] arr, int start, int end)
	{
		while(start<end)
		{
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
	public static void main(String args[])
	{
		int ar[]= {1,2,3,4,5,6,7};
		RotateArray ra = new RotateArray();
		//System.out.println(Arrays.toString(ra.rotate(ar,ar.length,6)));
		//ra.second_rotate(ar, ar.length, 6);
		//System.out.println(Arrays.toString(ra.third_rotate(ar, ar.length, 6)));
		System.out.println(Arrays.toString(ra.fourth_rotate_reversal(ar, ar.length, 6)));
	}
}

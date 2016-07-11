
public class Miss {

	public void missing(int[] arr)
	{
		int n =arr.length+1;
		int sum = (n*(n+1))/2;
		for(int i=0;i<n-1;i++)
			sum = sum-arr[i];
		System.out.println(sum);
	}
	
	public void missing_XOR(int[] arr)
	{
		int n = arr.length;
		int xor1=0;
		int xor2=0;
		for(int i=1;i<=n+1;i++)
			xor1 = xor1 ^ i;
		for(int i=0;i<n;i++)
			xor2 = xor2 ^ arr[i];
		
		System.out.println(xor1 ^ xor2);
	}
	
	public static void main(String args[])
	{
		Miss m = new Miss();
		int[] arr = {1,2,3,5};
		m.missing(arr);
		m.missing_XOR(arr);
	}
}

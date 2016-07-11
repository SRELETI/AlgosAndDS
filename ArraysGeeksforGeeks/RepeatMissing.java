
public class RepeatMissing {

	public void repeat(int[] arr,int size)
	{
		for(int i=0;i<size;i++)
		{
			if(arr[Math.abs(arr[i])-1]<0)
			{
				System.out.println(Math.abs(arr[i]));
			}
			else
			{
				arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
			}
		}
		
		for(int i=0;i<size;i++)
		{
			if(arr[i]>0)
			{
				System.out.println(i+1);
				return;
			}
		}
	}
	
	public void repeat2(int[] arr, int size)
	{
		float n_sum = (size*(size+1))/2;
		float x =0;
		float y=0;
		float arr_sum=0;
		for(int i=0;i<size;i++)
			arr_sum = arr_sum +arr[i];
		float s = n_sum - arr_sum;
		float n_prod = fact(size);
		float arr_prod=arr[0];
		for(int i=1;i<arr.length;i++)
			arr_prod = arr_prod*arr[i];
	//	System.out.println(n_prod+" "+arr_prod);
		float sp = n_prod/arr_prod;
		float k = (int) (s/(sp-1));
		y = k+s;
	//	System.out.println(sp);
		
		System.out.println(k+" "+y);
	}
	
	public static void main(String args[])
	{
		int[] arr = {1, 3, 4, 5, 5, 6, 2};
		int size = arr.length;
		RepeatMissing r = new RepeatMissing();
		r.repeat2(arr, size);
		r.repeat3(arr, size);
	}
	
	private int fact(int len)
	{
		if(len ==1)
			return 1;
		return len *fact(len-1);
	}
	
	public void repeat3(int[] arr, int size)
	{
		int xo=arr[0];
		
		for(int i=1;i<size;i++)
		{
			xo = xo ^ arr[i];
		}
		for(int i=1;i<=size;i++)
		{
			xo = xo ^ i;
		}
		
		
		int x = 0;
		int y = 0;
	//	System.out.println(xo);
		int set_bit = xo & ~(xo-1);
		for(int i=0;i<size;i++)
		{
			if((arr[i] & set_bit)!=0)
			{
				
				x = x ^ arr[i];
			}
			else
				y = y ^ arr[i];
				
		}
		
		for(int i=1;i<=size;i++)
		{
			if((i & set_bit) !=0)
			{
				x = x ^ i;
			}
			else 
				y = y ^ i;
		}
		System.out.println(x+" "+y);
	}
}

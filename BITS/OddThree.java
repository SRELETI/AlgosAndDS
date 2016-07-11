
public class OddThree {

	public void find(int[] arr)
	{
		int result = 0;
		int sum,j;
		for(int i=0;i<Integer.SIZE;i++)
		{
			sum=0;
			j= 1<<i;
			for(int k=0;k<arr.length;k++)
			{
				if((arr[k]&j)>0)
					sum++;
			}
		//	System.out.println(sum);
			if(sum%3!=0)
				result = result | j;
		}
		System.out.println(result);
	}
	
	public boolean isSign(int one, int two)
	{
		return ((one ^ two) >0 ? false:true);
	}
	
	public void swap(int a, int b)
	{
		System.out.println(a+" "+b);
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println(a+" "+b);
	}
	public static void  main(String args[])
	{
		int[] arr= {3,3,3,2};
		OddThree o = new OddThree();
	//	o.find(arr);
	//	System.out.println(o.isSign(-1, 12));
	//	o.swap(1, -2);
		o.check(28, 0, 3, 2);
	}
	
	public void check(int num, int p1,int p2, int n)
	{
		int result = (1<<n) -1;
		System.out.println(result);
		int set1 = (num >> p1) & ((1<<n)-1);
		System.out.println(set1);
		int set2 = (num >> p2) & ((1<<n)-1);
		System.out.println(set2);
		int result_xor = set1 ^ set2;
		result_xor = (result_xor <<p1) | (result_xor <<p2);
		result_xor = num ^ result_xor;
		System.out.println(result_xor);
		
	}
}

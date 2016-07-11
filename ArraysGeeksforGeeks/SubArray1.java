
public class SubArray1 {
	
	private int[] arr;
	private int[] subarr;
	
	public SubArray1(int length, int sublength)
	{
		arr = new int[length];
		subarr = new int[sublength];
	}
	
	public boolean check(int[] arr1, int[] sub)
	{
		if(sub.length==0)
			return true;
		if(arr1.length == 0)
			return false;
		
		int i = 0;
		int j=0;
		int count=0;
		while(i<arr1.length && j<sub.length)
		{
			if(arr1[i]==sub[j])
			{
				i++;
				j++;
				count++;
			}
			else
			{
				i++;
				count=0;
			}
		}
		return count==sub.length;
	}
	
	
	
	public static void main(String args[])
	{
		SubArray1 s = new SubArray1(4,2);
		s.arr[0]=1;
		s.arr[1]=2;
		s.arr[2]=3;
		s.arr[3]=4;
		
		s.subarr[0]=1;
		s.subarr[1]=3;
		
		System.out.print(s.check(s.arr,s.subarr));
		
	}
}

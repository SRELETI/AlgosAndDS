
public class MajorityCheck {

	
	public void maj(int[] arr)
	{
		int index = checkMaj(arr);
		int count = 0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==index)
				count++;
		}
		if(count>arr.length/2)
			System.out.println(index);
	}
	
	private int checkMaj(int[] arr)
	{
		int count=1;
		int start =0;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==arr[i-1])
				count++;
			else
				count--;
			if(count==0)
			{
				start = i;
				count = 1;
			}
		}
		return arr[start];
	}
	
	public static void main(String args[])
	{
		MajorityCheck m = new MajorityCheck();
		int[] arr = {-1,-3,-10,0,60};
	//	m.maj(arr);
	//	m.odd(arr);
	//	m.sum2(arr);
		m.maxProduct(arr);
	}
	
	public void odd(int[] arr)
	{
		int res = 0;
		for(int i=0;i<arr.length;i++)
			res = res ^ arr[i];
		System.out.println(res);
	}
	
	public void sum(int[] arr)
	{
		int maxSoFar = 0;
		int maxEndHere = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			maxEndHere = maxEndHere+arr[i];
			if(maxEndHere<0)
				maxEndHere = 0;
			if(maxEndHere>maxSoFar)
				maxSoFar = maxEndHere;
		}
		System.out.println(maxSoFar);
	}
	
	public void sum2(int[] arr)
	{
		int maxEndingHere = arr[0];
		int maxSoFar = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			maxEndingHere = Math.max(arr[i], maxEndingHere+arr[i]);
		//	System.out.println(maxSoFar);
			maxSoFar =  Math.max(maxSoFar, maxEndingHere);
		}
		System.out.println(maxSoFar);
	}
	
	public void maxProduct(int[] arr)
	{
		int maxEndingHere = 1;
		int minEndingHere = 1;
		int maxSoFar = 1;
		int start=-1;
		int result=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>0)
			{
				if(i==0 || maxEndingHere==1 && minEndingHere ==1)
					start = i;
				maxEndingHere = maxEndingHere * arr[i];
				minEndingHere = Math.min(minEndingHere*arr[i], 1);
			}
			else if(arr[i]==0)
			{
				maxEndingHere =1;
				minEndingHere = 1;
				
			}
			else
			{
				if(i==0 || minEndingHere ==1 && maxEndingHere==1)
					start=i;
				int temp =maxEndingHere;
				maxEndingHere = Math.max(minEndingHere*arr[i], 1);
				minEndingHere = temp * arr[i];
			}
			if(maxSoFar<maxEndingHere)
			{
				result =start;
				maxSoFar = maxEndingHere;
			}
		}
		System.out.println(maxSoFar);
		System.out.println("The start index "+result);
	}
	
	
}

import java.util.HashMap;


public class RepeatingElements {

	public void repeat(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]==arr[i])
					System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	}
	
	
	public void repeat2(int[] arr)
	{
		HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(h.containsKey(arr[i]))
				System.out.print(arr[i]+" ");
			else 
				h.put(arr[i], 1);
		}
		
		System.out.println();
	}
	
	public void repeat3(int[] arr)
	{
		int len = arr.length-2;
		int sum = (len*(len+1))/2;
		int prod = fact(len);
		
		int arr_sum = arr[0];
		for(int i=1;i<arr.length;i++)
			arr_sum = arr_sum+arr[i];
		int arr_prod = arr[0];
		for(int i=1;i<arr.length;i++)
			arr_prod = arr_prod*arr[i];
		
		int result_sum = arr_sum-sum;
		int result_prod = arr_prod/prod;
		
		int result_eq = (int) Math.sqrt((((int) Math.pow(result_sum, 2)) - 4*result_prod));
		int x = (result_sum+result_eq)/2;
		int y = (result_sum-result_eq)/2;
		System.out.println(x +" "+ y);
	}
	
	private int fact(int len)
	{
		if(len ==1)
			return 1;
		return len*fact(len-1);
	}
	
	public void repeat4(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[Math.abs(arr[i])]<0)
				System.out.print(Math.abs(arr[Math.abs(arr[i])])+" ");
			else
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
		}
		System.out.println();
	}
	
	public static void main(String args[])
	{
		int[] arr = {4,2,4,5,2,3,1};
		RepeatingElements r = new RepeatingElements();
		r.repeat(arr);
		r.repeat2(arr);
		r.repeat3(arr);
		r.repeat4(arr);
	}
}

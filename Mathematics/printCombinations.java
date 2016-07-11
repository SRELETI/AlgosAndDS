import java.util.Arrays;


public class printCombinations {

	public void print(int[] arr, int start, int n, String result)
	{
		if(result.length()==n)
		{
			System.out.println(result);
			return;
		}
			for(int i=start;i<arr.length;i++)
			{
				print(arr,i+1,n,result+arr[i]);
				if(i!=arr.length-1 && arr[i]==arr[i+1])
					i++;
			}
	}
	
	public static void main(String args[])
	{
		printCombinations p = new printCombinations();
		int[] arr = {1,2,1};
		int n=2;
		String result="";
		Arrays.sort(arr);
		p.print(arr, 0, n, result);
	}
}

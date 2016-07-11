import java.util.Arrays;


public class TripleSum {

	public void sum(int[] arr, int sum)
	{
		int left,right;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
		{
			left = i+1;
			right = arr.length-1;
			while(left<right)
			{
				if(arr[i]+arr[left]+arr[right]== sum)
				{
					System.out.println("The indexes at"+arr[i]+" "+arr[left]+" "+arr[right]);
					return;
				}
				else if(arr[i]+arr[left]+arr[right]>sum)
					right--;
				else
					left++;
			}
		}
	}
	
	public static void main(String args[])
	{
		int[] arr = {1,4,45,6,10,8};
		TripleSum t = new TripleSum();
		t.sum(arr, 22);
	}
}

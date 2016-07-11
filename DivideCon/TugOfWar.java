class Wrapper
{
	int val=Integer.MAX_VALUE;
}

public class TugOfWar {

	public void tug(int[] arr)
	{
		int n=arr.length;
		int sum=0;
		boolean cur_element[] = new boolean[arr.length];
		boolean soln [] = new boolean[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			sum = sum+arr[i];
			cur_element[i]=soln[i]=false;
		}
		Wrapper min_diff = new Wrapper();
		tugOfWarUtil(arr,n,cur_element,0,soln,sum,0,0,min_diff);
		System.out.println("The first sub array :");
		for(int i=0;i<soln.length;i++)
		{
			if(soln[i]==true)
				System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("The second sub array :");
		for(int i=0;i<soln.length;i++)
		{
			if(soln[i]==false)
				System.out.print(arr[i]+" ");
		}
	}
	
	public void tugOfWarUtil(int[] arr, int n, boolean[] cur_element, int no_of_selected, boolean[] soln, int sum, int cur_sum, int cur_pos, Wrapper min_diff)
	{
		if(cur_pos==n)
			return;
		if(n/2-no_of_selected>n-cur_pos)
			return;
		tugOfWarUtil(arr,n,cur_element,no_of_selected,soln,sum,cur_sum,cur_pos+1,min_diff);
		no_of_selected++;
		cur_sum = cur_sum+arr[cur_pos];
		cur_element[cur_pos]=true;
		if(no_of_selected==n/2)
		{
			if(Math.abs((sum/2)-cur_sum)<min_diff.val)
			{
				min_diff.val= Math.abs((sum/2)-cur_sum);
				for(int i=0;i<cur_element.length;i++)
					soln[i]=cur_element[i];
			}
		}
		else
		{
			tugOfWarUtil(arr,n,cur_element,no_of_selected,soln,sum,cur_sum,cur_pos+1,min_diff);
		}
		cur_element[cur_pos]=false;
	}
	
	public static void main(String args[])
	{
		int[] arr = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		TugOfWar t = new TugOfWar();
		t.tug(arr);
	}
}

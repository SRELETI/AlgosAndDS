
public class MaxCont {
	private int[] arr;
	private int elements;
	public MaxCont(int length)
	{
		arr=new int[length];
		elements=0;
	}
	public void insert(int value)
	{
		arr[elements++]=value;
	}
	public int sum()
	{
		int max_ending_here=0;
		int max_so_far=0;
		for (int i=0;i<arr.length;i++)
		{
			max_ending_here=max_ending_here+arr[i];
			if(max_ending_here<0)
				max_ending_here=0;
			else if(max_ending_here>max_so_far)
			{
				max_so_far=max_ending_here;
			}
		}
		return max_so_far;
	}
	public int modified_sum()
	{
		int max_so_far=arr[0];
		int curr_max=arr[0];
		int i;
		int low_index=0,high_index=0;
		for(i=1;i<arr.length;i++)
		{
			int temp=curr_max;
			curr_max=Math.max(arr[i], curr_max*arr[i]);
			if(curr_max==arr[i])
				low_index=i;
			max_so_far=Math.max(max_so_far,curr_max);
			if(max_so_far==curr_max)
				high_index=i;
		}
		System.out.println(low_index+" "+high_index);
		return max_so_far;
	}
	public static void main(String args[])
	{
		int length=5;
		MaxCont mc = new MaxCont(length);
		mc.insert(-5);
		mc.insert(-2);
		mc.insert(-3);
		mc.insert(6);
		mc.insert(-2);
		System.out.println(mc.sum());
		System.out.println(mc.modified_sum());
	}
}

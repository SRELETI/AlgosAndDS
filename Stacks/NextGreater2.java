
public class NextGreater2 {
	private int[] inp_arr;
	private StackArray bpr;
	private int length;
	public NextGreater2(int[] arr)
	{
		inp_arr=arr;
		length=arr.length;
		bpr=new StackArray(length);
	}
	public void greater()
	{
		bpr.push(inp_arr[0]);
		for(int i=1;i<inp_arr.length;i++)
		{
			int next=inp_arr[i];
			while(!bpr.isEmpty())
			{
				int ch= bpr.pop();
				if(next>ch)
				{
					System.out.println("The next greater element for "+ch+" ----> "+next);
				}
				else
				{
					bpr.push(ch);
					break;
				}
			}
			bpr.push(next);
		}
		while(!bpr.isEmpty())
		{
			int ch=bpr.pop();
			System.out.println("The next greater element for "+ch+ " ----> " +(-1));
		}
	}
}

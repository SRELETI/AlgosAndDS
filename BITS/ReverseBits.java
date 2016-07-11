
public class ReverseBits {

	public void reverse(int c)
	{
		
		int result = 0;
		for(int i=0;i<Integer.SIZE;i++)
		{
			if((c & 1<<i)>0)
			{
				result = result | 1<<((Integer.SIZE-1)-i);
			}
		}
		System.out.println(result);
	}
	
	public static void main(String args[])
	{
		ReverseBits r = new ReverseBits();
		r.reverse(2);
		r.countAB(2, 3);
	}
	
	public void countAB(int x, int y)
	{
		int result_no = x^y;
		System.out.println(count(result_no));
	}
	
	private int count(int x)
	{
		int s = x;
		int count =0;
		while(s>0)
		{
			s = s & (s-1);
			count++;
		}
		return count;
	}
}

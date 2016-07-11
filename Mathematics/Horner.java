
public class Horner {

	public void horner(int[] num, int pow)
	{
		int result = 0;
		for(int i=0;i<num.length;i++)
		{
			result = result*pow + num[i];
		}
		System.out.println(result);
	}
	public static void main(String args[])
	{
		Horner h = new Horner();
		int[] num = {2,0,3,1};
		int pow = 2;
	//	h.horner(num, pow);
		h.towers(4, 'A', 'B', 'C');
	}
	
	public void towers(int n, char start, char mid, char end)
	{
		if(n==1)
		{
			System.out.println("move disk 1 from "+start+" to "+end+" tower");
			return;
		}
		towers(n-1,start,end,mid);
		System.out.println("move disk "+n+" from "+start+" to "+end);
		towers(n-1,mid,start,end);
	}
}

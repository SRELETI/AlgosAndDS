
public class OppSign {
	public static void main(String args[])
	{
		int x= 100;
		int y= 100;
		System.out.println(opp(x,y));
		System.out.println(opp2(x,y));
	}
	public static boolean opp(int x, int y)
	{
		return ((x^y)<0);
	}
	public static boolean opp2(int x, int y)
	{
		return x<0 ? y>=0 : y<0;
	}
}

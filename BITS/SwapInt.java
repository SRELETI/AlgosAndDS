
public class SwapInt {
	public static void main(String args[])
	{
		int x=5;
		int y=3;
		swap(x,y);
	}
	public static void swap(int x,int y)
	{
		x=x ^ y;
		y=x ^ y;
		x=x ^ y;
		System.out.println("The y value is "+y +" And xa value is "+x);
	}
}

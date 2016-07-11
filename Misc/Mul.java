
public class Mul {
	public static void main(String args[])
	{
		System.out.println(mult(10,0));
	}
	public static int mult(int x,int y)
	{
		if(y==0)
			return 0;
		return x+mult(x,y-1);
	}
}


public class Divisble7 {

	public boolean divisble7(int num)
	{
		if(num<0)
			return divisble7(-num);
		if(num==0 || num==7)
			return true;
		if(num<10)
			return false;
		return divisble7(num/10-2*(num-num/10*10));
	}
	
	public static void main(String args[])
	{
		Divisble7 d = new Divisble7();
		int num=371;
	//	System.out.println(num/10*10);
		System.out.println(d.divisble7(7));
	}
}

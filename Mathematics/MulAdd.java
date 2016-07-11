
public class MulAdd {

	public int mulAdd(int x, int y)
	{
		if(y==0)
			return 0;
		if(y>0)
			return x + mulAdd(x,y-1);
		
		return -mulAdd(x,-y);
	}
	
	public static void main(String args[])
	{
		MulAdd m = new MulAdd();
		System.out.println(m.mulAdd(3, 5));
		System.out.println(m.power(2,5));
		System.out.println(m.power2(2,5));
		System.out.println(m.power3(2,-5));
	}
	
	public int power(int x, int y)
	{
		if(y==0)
			return 1;
		if(y%2==0)
			return power(x,y/2)*power(x,y/2);
		else
			return x*power(x,y/2)*power(x,y/2);
	}
	
	public int power2(int x, int y)
	{
		if(y==0)
			return 1;
		int temp = power2(x,y/2);
		if(y%2==0)
			return temp*temp;
		else
			return x*temp*temp;
	}
	
	public double power3(int x, int y)
	{
		if(y==0)
			return 1;
		double temp = power3(x,y/2);
		if(y%2==0)
			return temp*temp;
		else
		{
			if(y>0)
				return x*(temp*temp);
			else
				return (temp*temp)/x;
		}
	}
	
}

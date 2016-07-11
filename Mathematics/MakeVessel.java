
public class MakeVessel {

	private Vessel v1;
	private Vessel v2;
	
	public MakeVessel(int vv, int vvv)
	{
		v1 = new Vessel(vv);
		v2 = new Vessel(vvv);
	}
	
	public int gcd()
	{
		return gcd(v1.capacity,v2.capacity);
	}
	
	public int gcd(int a,int b)
	{
		if(b==0)
			return a;
		return gcd(b,b%a);
	}
	public boolean makeOne()
	{
		if(gcd()!=1)
			return false;
		v1.current=v1.capacity;
		int temp1,temp2;
		while(v1.current!=1)
		{
			temp1 = v1.current;
			if(temp1+v2.current>=v2.capacity)
			{
				temp2 = temp1-(v2.capacity-v2.current);
				v2.current=0;
				v1.current = temp2;
			}
			else
			{
				v2.current = v2.current+v1.current;
				v1.current=v1.capacity;
			}
		}
		return true;
	}
	
	public static void main(String args[])
	{
		MakeVessel m = new MakeVessel(3,7);
		System.out.println(m.makeOne());
		
	}
}

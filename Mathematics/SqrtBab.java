
public class SqrtBab {

	public void sqrt(float x)
	{
		double m = x;
		double n =1;
		double e =0.000001;
		while(m-n>e)
		{
			m= (m+n)/2;
			n = x/m;
		}
		System.out.println(m);
	}
	
	public static void main(String args[])
	{
		SqrtBab s = new SqrtBab();
		s.sqrt(50);
	}
}


public class Count10Cons {

	public void count(int length)
	{
		if(length==0)
		{
			System.out.println(0);
			return;
		}
	//	int[] a = new int[length];
	//	int[] b = new int[length];
	//	a[0]=b[0]=1;
		int a=1;
		int b=1;
		int a_temp;
		for(int i=1;i<length;i++)
		{
			a_temp = a+b;
			b = a;
			a = a_temp;
		//	a[i]=a[i-1]+b[i-1];
		//	b[i]=a[i-1];
		}
		System.out.println(a+b);
	}
	
	public static void main(String args[])
	{
		Count10Cons c = new Count10Cons();
		c.count(4);
	}
}

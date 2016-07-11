
public class Sqrt {

	public int sqrt(int x) {
		int h=0;
		while((long)1<<h * (long)1<<h <=x)
			h++;
		h--;
		int res = 1<<h;
		int b=h-1;
		while(b>=0)
		{
			if((long)(res | 1<<b) * (long)(res | 1<<b) <=x)
				res = res | 1<<b;
			b--;
		}
		return res;
	}
	
	public static void main(String args[]) {
		Sqrt s = new Sqrt();
		System.out.println(s.sqrt(Integer.MAX_VALUE));
	}
}

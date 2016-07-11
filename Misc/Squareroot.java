

public class Squareroot {

	
	 public int sqrt(int x) {
	        if(x==0)
	            return 0;
	        int h=0;
	        while(((long)1<<h) * ((long)1<<h)<=x)
	            h++;
	        h--;
	        int res = 1<<h;
	        int b = h-1;
	        while(b>=0)
	        {
	            if((long)(res|1<<b) * (long)(res|1<<b)<=x)
	                res = res | 1<<b;
	            b--;
	        }
	        return res;
	    }
	
	public static void main(String args[]) {
		Squareroot s = new Squareroot();
		System.out.println(s.sqrt(2147483647));
	}
}

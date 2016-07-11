
public class DivideInteger {

	public int divide(int dividend, int divisor) {
		if(dividend==0)
			return 0;
		int mask = 0x1;
		int que = 0;
		while(divisor<=dividend) {
			divisor = divisor<<1;
			mask = mask<<1;
		}
		
		while(mask>0) {
			divisor = divisor>>1;
			mask = mask>>1;
			
			if(dividend>=divisor) {
				dividend = dividend-divisor;
				que = que | mask;
			}
		}
		return que;
	}
	
	public int divide2(int dividend, int divisor) {
        long quotient = 0;
        long mask = 0x1;
        long div = divisor;
        long divd = dividend;
        if(divisor<0)
	        div = -div;
	    if(dividend<0)
	        divd = -divd;
        while(div<=divd) {
            div = div<<1;
            mask = mask<<1;
        }
        
        while(mask>0)
        {
            div = div>>1;
            mask=mask>>1;
            if(divd>=div) {
                divd = divd-div;
                quotient = quotient | mask;
            }
        }
        if(dividend<0 || divisor<0)
            return -(int)quotient;
        return (int)quotient;
    }
	public static void main(String args[]) {
		DivideInteger d = new DivideInteger();
		System.out.print(d.divide2(2147483647, 1));
	}
}

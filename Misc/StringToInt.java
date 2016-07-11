
public class StringToInt {

	public int atoi(String str) {
	       if(str.length()==0)
	    	   return 0;
	       int sign = 1;
	       int base  =0;
	       int i=0;
	       while(str.charAt(i)==' ')
	    	   i++;
	       if(str.charAt(i)=='-' || str.charAt(i)=='+')
	       {
	    	   sign = str.charAt(i)=='+' ? 1:-1;
	       }
	       while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9' )
	       {
	    	   if(base>Integer.MAX_VALUE/10 || base ==Integer.MAX_VALUE/10 && str.charAt(i)>'7')
	    	   {
	    		   if(sign==1)
	    			   return Integer.MAX_VALUE;
	    		   else
	    			   return Integer.MIN_VALUE;
	    	   }
	    	   base = base *10 + Character.getNumericValue(str.charAt(i));
	    	   i++;
	       }
	       return base*sign;
	    }
	
	public static void main(String args[]) {
		StringToInt s = new StringToInt();
		System.out.println(s.atoi("010"));
	}
}

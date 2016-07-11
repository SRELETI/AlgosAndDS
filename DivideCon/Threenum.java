import java.util.HashSet;
import java.util.Set;


public class Threenum {

	   public int singleNumber(int[] A) {
	        int result =0;
	        int test;
	        for(int i=0;i<32;i++)
	        {
	            test = 1<<i;
	            int sum = 0;
	            for(int j=0;j<A.length;j++)
	            {
	                if((A[j] & test)!=0)
	                    sum++;
	            }
	            if(test == 1<<31)
	            	System.out.println(sum);
	            if(sum%3!=0)
	                result = result | test;
	           
	        }	        	
	        return result;
	    }
	   
	   public static void main(String args[])
	   {
		//   int[] arr = {-2,-2,-1,-1,-3,-1,-3,-3,-4,-2};
		  Set s = new HashSet();
		  String input = "aaaaaaa";
		  s.add("aaaa");
		  s.add("aaa");
		   Threenum g = new Threenum();
		   System.out.println(g.wordBreak(input, s));
		//   System.out.println(g.singleNumber(arr));
	   }
	   public boolean wordBreak(String s, Set<String> dict) {
	        if(dict.isEmpty())
	            return false;
	        if(dict.contains(s))
	            return true;
	        int start=0;
	        String ss;
	        int[] count = new int[s.length()+1];
	        count[0]=0;
	        int j=0;
	        for(int i=1;i<=s.length();i++)
	        {
	            ss = s.substring(start,i);
	            if(dict.contains(ss))
	            {
	                start = i;
	                count[++j]=start;
	                System.out.println(count[j]);
	            }
	        }
	        return count[j]==s.length() ? true:false;
	    }
	
}




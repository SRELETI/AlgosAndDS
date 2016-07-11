public class Solution {
    public String reverseWords(String s) {
        s = s.trim();  
        System.out.println(s);
       StringBuilder ss = new StringBuilder(s);
      
       s = reverseNow(ss);
       s.trim();
       return s;
    }
    public String reverseNow(StringBuilder s)
    {
        int start =0;
            
        reverse(s,0,s.length()-1);
    
        for (int k=1;k<s.length();k++)
        {
            if(s.charAt(k)==' ' && s.charAt(k-1)==' ')
                s.deleteCharAt(k-1);
            else if(s.charAt(k)==' ')
            {
                reverse(s,start,k-1);
                start = k+1;
            }
            else if(k==s.length()-1)
            {
                reverse(s,start,k);
            }
        }
      
        return s.toString();
    }
    
    public void reverse(StringBuilder s, int start, int end)
    {
        while(start<=end)
        {
            char val = s.charAt(start);
            s.setCharAt(start,s.charAt(end));
            s.setCharAt(end,val);
            start++;
            end--;
        }
    }
    
    public static void main(String args[])
    {
    	String s ="   a  b ";
    	Solution ss = new Solution();
    	ss.reverseWords(s);
    }
    
}

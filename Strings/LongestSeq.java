import java.util.HashMap;


public class LongestSeq {

	public void longest(String s)
	{
		HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		int cur_len =1;
		int max_len =1;
		int prev_index=-1;
		int i;
		h.put(s.charAt(0), 0);
		int start=0;
		int end=-1;
		for(i=1;i<s.length();i++)
		{
			prev_index = h.get(s.charAt(i)) == null ? -1 : h.get(s.charAt(i));
			if(prev_index==-1 || i-cur_len>prev_index)
			{
				cur_len++;
			}
			else
			{
				if(cur_len>max_len)
				{
					start = end+1;
					max_len = cur_len;
					end = i-1;
				}
				cur_len = i-prev_index;
				
			}
			h.put(s.charAt(i), i);
		}
		
		if(cur_len>max_len)
		{
			max_len = cur_len;
			start = end+1;
			end = i-1;
		}
		System.out.println(s.substring(start, end+1));
		System.out.println(max_len);
	}
	
	public static void main(String args[])
	{
		String s = "Sudep";
		LongestSeq l = new LongestSeq();
		l.longest(s);
	}
}

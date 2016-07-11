import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class LetterComb {
	
	public static void main(String args[]) {
		LetterComb l = new LetterComb();
		String S = "aaa";
		String[] L = {"a","a"};
		List<Integer> ii = l.findSubstring(S, L);
		Iterator<Integer> it = ii.iterator();
		while(it.hasNext())
		{
			System.out.print((int)it.next());
		}
	}
	public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ll = new ArrayList<Integer>();
		if(S.length()==0)
			return ll;
		HashMap<String,Integer> map_full = new HashMap<String,Integer>();
		HashMap<String,Integer> map_working = new HashMap<String,Integer>();
		int length = L[0].length();
		int limit = L.length*length;
		
		for(int i=0;i<L.length;i++)
		{
			if(map_full.containsKey(L[i])==true)
				map_full.put(L[i], map_full.get(L[i])+1);
			else
				map_full.put(L[i], 1);
		}
		for(int i=S.length();i>=limit;i--)
		{
			int start = i-length;
			String word = S.substring(start,start+length);
			while(map_full.containsKey(word)==true && map_full.get(word)>0)
			{
				map_full.put(word, map_full.get(word)-1);
				if(map_working.containsKey(word))
					map_working.put(word, map_working.get(word)+1);
				else
					map_working.put(word, 1);
				if(i-start==limit)
				{
					ll.add(start);
					break;
				}
				start = start-length;
				if(start>=0)
				    word = S.substring(start, start+length);
			}
			Iterator<String> it = map_working.keySet().iterator();
			while(it.hasNext())
			{
				String temp = (String)it.next();
				map_full.put(temp, map_full.get(temp)+map_working.get(temp));
			}
			map_working.clear();
		}
		return ll;
    }
	}

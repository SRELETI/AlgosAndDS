import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class StringRepeating {

	public void repeating(String input) {
		HashMap<Character,Integer> h = new LinkedHashMap<Character,Integer>();
		
		for(int i=0;i<input.length();i++) {
			if(h.containsKey(input.charAt(i))) 
				h.put(input.charAt(i), h.get(input.charAt(i))+1);
			else
				h.put(input.charAt(i), 1);
		}
		
		for(Entry<Character, Integer> ch : h.entrySet()) {
			if(ch.getValue()==1) {
				System.out.println(ch.getKey()+" ");
				break;
			}
		}
		
	}
	
	public static void main(String args[]) {
		StringRepeating s = new StringRepeating();
		s.repeating("GeeksforGeeks");
		s.oneIteration("GeeksforGeeks");
		s.iterationTwo("GeeksforGeeks");
	}
	
	
	public void oneIteration(String input) {
		Set<Character> se = new HashSet<Character>();
		List<Character> le = new ArrayList<Character>();
		
		for(int i=0;i<input.length();i++) {
			if(se.contains(input.charAt(i)))
				continue;
			if(le.contains(input.charAt(i))) {
				le.remove(le.indexOf(input.charAt(i)));
				se.add(input.charAt(i));
			}
			else
				le.add(input.charAt(i));
		}
		System.out.println(le.size()==0 ? 0:le.get(0));
	}
	
	public void iterationTwo(String input) {
		HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		for(int i=0;i<input.length();i++) {
			if(h.containsKey(input.charAt(i))) 
				h.put(input.charAt(i), h.get(input.charAt(i))+1);
			else
				h.put(input.charAt(i), 1);
		}
		
		for(int i=0;i<input.length();i++) {
			if(h.get(input.charAt(i))==1) {
				System.out.println(input.charAt(i));
				return;
			}
		}
	}
}

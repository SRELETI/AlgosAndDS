import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class SmallestWindow {

	public void smallest(String text, String pat) {
		if(text.length()==0 || pat.length()==0 || text.length()<pat.length()) 
			return;
		int patL = pat.length();
		int start = -1;
		int end = text.length();
		
		Deque<Integer> queue = new LinkedList<Integer>();
		Map<Character,Integer> mp = new HashMap<Character,Integer>();
		
		for(int i=0;i<patL;i++) {
			char temp = pat.charAt(i);
			mp.put(temp, mp.containsKey(temp) ? mp.get(temp)+1:1);
		}
		
		for(int i=0;i<text.length();i++) {
			char temp = text.charAt(i);
			if(mp.containsKey(temp)==false)
				continue;
			int n = mp.get(temp);
			mp.put(temp, n-1);
			if(n>0) {
				patL--;
			}
			queue.add(i);
			char head = text.charAt(queue.peek());
			while(mp.get(head)<0) {
				queue.poll();
				mp.put(head, mp.get(head)+1);
				head = text.charAt(queue.peek());
			}
			
			if(patL==0) {
				int newLength = queue.peekLast()-queue.peek()+1;
				if(newLength < end-start) {
					end = queue.peekLast()+1;
					start = queue.peek();
				}
			}
			
		}
		if(patL==0) {
			System.out.println(text.substring(start, end));
		}
	}
	
	public static void main(String args[]) {
		SmallestWindow s = new SmallestWindow();
		s.smallest("this is a test string", "tist");
	}
}

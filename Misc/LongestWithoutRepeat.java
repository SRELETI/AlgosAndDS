import java.util.HashMap;
import java.util.Map;


public class LongestWithoutRepeat {

	public void repeat(String text) {
		if(text.length()==0)
			return;
		Map<Character,Integer> mp = new HashMap<Character,Integer>();
		int start =0;
		int maxLength=0;
		for(int i=0;i<text.length();i++) {
			start = Math.max(start, mp.containsKey(text.charAt(i))?mp.get(text.charAt(i))+1:0);
			maxLength = Math.max(maxLength, i-start+1);
				mp.put(text.charAt(i), i);
		}
		System.out.println(maxLength);
	}
	
	public static void main(String args[]){
		LongestWithoutRepeat l = new LongestWithoutRepeat();
		String text = "GEEKSFORGEEKS";
		l.repeat(text);
	}
}

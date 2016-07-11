import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class SetStrings {

	public void setOfStrings(List<String> strings) {
		if(strings.size()==0)
			return;
		HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
		
		String first = strings.get(0);
		for(int i=0;i<first.length();i++) {
			if(hash.containsKey(first.charAt(i))==false) {
				hash.put(first.charAt(i), i);
			}
		}
		
		for(int i=1;i<strings.size();i++) {
			String temp = strings.get(i);
			Iterator<Character> k = hash.keySet().iterator();
			while(k.hasNext()) {
				char t = k.next();
				if(temp.contains(""+t)==false) {
				//	System.out.println(t);
					hash.remove(t);
				}
			}
		}
		Iterator<Character> kk = hash.keySet().iterator(); 
		while(kk.hasNext()) {
			System.out.println(kk.next());
		}
	}
	
	public static void main(String args[]) {
		SetStrings setString  = new SetStrings();
		String[] temp = {"sudeep","sachin","sandeep"};
		List<String> list = Arrays.asList(temp);
		setString.setOfStrings(list);
	}
}

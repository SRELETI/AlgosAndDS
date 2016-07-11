import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class ProductsSolution {

	public static void main(String args[]) {
		int[] arr = {1,7,3,4};
	//	findProduct(arr);
	}
	
	public List<String> findRepeatedDnaSequence(String s) {
        List<String> ls = new ArrayList<String>();
	        if(s==null || s.length()==0)
	            return ls;
	        Map<String,Integer> map = new HashMap<String,Integer>();
	        for(int i=0;i<s.length()-10;i++) {
	            String temp = s.substring(i,i+10);
	            if(map.containsKey(temp)) {
	            	int val = map.get(temp);
	            	map.put(temp,val+1);
	            }
	            else {
	            	map.put(temp, 1);
	            }
	        }
	        Iterator i = map.entrySet().iterator();
	        while(i.hasNext()) {
	        	
	            Map.Entry<String,Integer> pair = (Entry<String, Integer>) i.next();
	            if(pair.getValue()>1) 
	                ls.add(pair.getKey());
	        }
	        return ls;
    }
	
	    public List<String> findRepeatedDnaSequences(String s) {
	        List<String> ls = new ArrayList<String>();
	        if(s==null || s.length()==0)
	            return ls;
	        Map<String,Integer> map = new HashMap<String,Integer>();
	        for(int i=0;i<s.length()-10;i++) {
	            if(ls.contains(s.substring(i,i+10))) 
	            	continue;
	            if(map.containsKey(s.substring(i,i+10))) {
	            	map.remove(s.substring(i,i+10));
	            	ls.add(s.substring(i,i+10));
	            }
	            else {
	            	map.put(s.substring(i,i+10), 1);
	            }
	        }
	        return ls;
	    }
	
}

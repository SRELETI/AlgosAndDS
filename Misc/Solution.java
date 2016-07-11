import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner s = new Scanner(new InputStreamReader(System.in));
    	int testCases = Integer.parseInt(s.nextLine());
    	for(int i=0;i<testCases;i++) {
    		String text = s.nextLine();
    		Map<Long,Integer> map  = new HashMap<Long,Integer>();
    		for(int j=0;j<text.length();j++) {
    			int[] count = new int[26];
        		for(int k=j;k<text.length();k++) {
        			count[text.charAt(k)-'a']++;
        			long key = hash(count);
        			if(map.containsKey(key)) {
        				int val = map.get(key);
        				map.put(key, val+1);
        			}
        			else
        				map.put(key, 1);
        		}
    		}
    		
    		Iterator<Long> iterator = map.keySet().iterator();
    		int total = 0;
    		while(iterator.hasNext()) {
    			long key = iterator.next();
    			int val = map.get(key);
    			total += ((val*(val-1))/2);
    		}
    		System.out.println(total);
    	}
    }
    
    private static long hash(int[] count) {
    	long t=1;
    	int ret = 0;
    	for(int i=0;i<26;i++) {
    		ret += (t*count[i]);
    		t = t * (1000003);
    	}
    	return ret;
    }
}
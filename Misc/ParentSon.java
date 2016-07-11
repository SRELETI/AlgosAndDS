import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class ParentSon {

	 public static void main(String[] args) throws IOException {
	   ParentSon main = new ParentSon();
	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   String s;
	   while ((s = in.readLine()) != null) {
		   main.processStr(s);
	   }
	 }
	 
	 public void processStr(String s) {
		 Map<String,Integer> map = new TreeMap<String,Integer>();
		 String[] s_arr = s.split(",");
		 int num=-1;
	//	 System.out.println(Arrays.toString(s_arr));
		 for(int i=0;i<s_arr.length;i++) {
			 if(isInteger(s_arr[i])==false) {
				 String[] temp = s_arr[i].split("->");
				 if(map.containsKey(temp[0])) {
					 int val = map.get(temp[0]);
					 map.put(temp[1], val+1);
				 }
				 else {
					 map.put(temp[0], 1);
					 map.put(temp[1], 2);
				 }
			 }
			 else {
				 num= Integer.parseInt(s_arr[i]);
			 }
		 }
		 boolean flag = false;
		 if(num>0) {
			 Iterator<Entry<String,Integer>> i= map.entrySet().iterator();
			 while(i.hasNext()) {
				 Map.Entry<String,Integer> pair = (Map.Entry<String,Integer>) i.next();
				 if(pair.getValue()==num) {
					 if(flag==false) {
						 System.out.print(pair.getKey());
						 flag=true;
					 }
					 else {
						 System.out.print(","+pair.getKey());
					 }
				 }
			 }
		 }
		 
	 }
	 
	 public static boolean isInteger(String s) {
		    try { 
		        Integer.parseInt(s); 
		    } catch(NumberFormatException e) { 
		        return false; 
		    }
		    // only got here if we didn't return false
		    return true;
		}
}






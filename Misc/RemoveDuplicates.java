import java.util.Arrays;
import java.util.HashMap;


public class RemoveDuplicates {

	public char[] removeFirst(char[] str)  {
		if(str.length<=1)
			return str;
		HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
		
		for(int i=0;i<str.length;i++) {
			if(hash.containsKey(str[i])==false) {
				hash.put(str[i],i);
				
			}
			else {
				str[i]=0;
			}
		}
		return str;
	}
	
	public char[] removeLast(char[] str) {
		if(str.length<2)
			return str;
		quickSort(str,0,str.length-1);
		int i=0;
		for(int j=1;j<str.length;j++) {
			if(str[j]!=str[i]) {
				i++;
				str[i]=str[j];
			}
		}
		return Arrays.copyOfRange(str, 0, i+1);
	}
	
	
	public void quickSort(char[] str,int left, int right) {
		if(left<right) {
			int part = partition(str,left,right);
			quickSort(str,left,part-1);
			quickSort(str,part+1,right);
		}
 	}
	
	public int partition(char[] str, int left, int right) {
		int start = left;
		int last = right;
		for(int i=left;i<right;i++) {
			if(str[i]<str[last]) {
				swap(str,i,start);
				start++;
			}
		}
		swap(str,start,last);
		return last;
	}
	
	public void swap(char[]str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
	
}

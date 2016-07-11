import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class Booking {

	private long a = 25214903917L;
	private long c = 11;
	private long previous = 1;
	public static void main(String args[]) throws FileNotFoundException {
		Booking book = new Booking();
		int[] arr = {3,6,61,6,7,9,1,7,7,2,7,7,2,388,3,72,7};
	//	book.sortOrder(arr);
		int[] arr1 = {5,3,7,1,9};
		int[] arr2 = {5,6,7};
		int[] arr3 = {1,2,3,4,5};
	//	book.printSameArr(arr1, arr2, arr3);
	//	book.isSame(arr1, arr2, arr3);
	//	book.getTopNWords(4);
		book.convertBaseAB("255", 10, 16);
	//	String filePath="C:\\Users\\IBM_ADMIN\\Desktop\\TODO.txt";
	//	book.longestWord(filePath, arr);
	//	book.getConIncSeq(arr);
	//	book.findUnique(arr3, arr2);
	}
	
	public long rand() {
		long r = a*previous + c;
		previous = r;
		return r;
	}
	
	public void findUnique(int[] arr, int[] arr2) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i],1);
		}
		for(int i=0;i<arr2.length;i++) {
			if(map.containsKey(arr2[i])) 
				map.remove(arr2[i]);
			else
				System.out.println(arr2[i]);
		}
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void sortOrder(String[] arr) {
		
		if(arr==null || arr.length==0) return;
		Map<Character,String> firsts = new HashMap<Character,String>();
		Map<Character,String> lasts = new HashMap<Character,String>();
		for(int i=0;i<arr.length;i++) {
			char first = arr[i].toLowerCase().charAt(0);
			firsts.put(first, arr[i]);
			char last = arr[i].toLowerCase().charAt(arr[i].length()-1);
			lasts.put(last, arr[i]);
		}
		List<String> output = new LinkedList<String>();
		for(Entry<Character, String> entry: firsts.entrySet()) {
			Character key = entry.getKey();
			if(lasts.containsKey(key)==false) {
				output.add(entry.getValue());
				break;
			}
		}
		
		while(output.size()<arr.length) {
			String lastString = output.get(output.size()-1);
			char last = lastString.charAt(lastString.length()-1);
			System.out.println(output);
			output.add(firsts.get(last));
		}
		System.out.println(output);
	}
	
	public boolean contain(String str, char[] arr) {
		if(str==null || str.length()==0 && arr!=null) return false;
		if(arr==null) return true;
		for(int i=0;i<arr.length;i++) {
			if(str.indexOf(arr[i])==-1) 
				return false;
		}
		return true;
	}
	
	public boolean contain2(String str, char[] arr) {
		if(str==null || str.length()==0 && arr!=null) return false;
		if(arr==null) return true;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<str.length();i++) {
			map.put(str.charAt(i), map.containsKey(str.charAt(i))==true ? map.get(str.charAt(i))+1:1);
		}
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i]) && map.get(arr[i])>0) {
				map.put(arr[i], map.get(arr[i])-1);
			}
			else 
				return false;
		}
		return true;
	}
	
	public void printSameArr(int[] arr1,int[] arr2, int[] arr3) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Arrays.sort(arr3);
		int i=0,j=0,k=0;
		while(i<arr1.length && j<arr2.length && k<arr3.length) {
			if(arr1[i]<arr2[j] && arr1[i]<arr3[k]) 
				i++;
			else if(arr2[j]<arr1[i] && arr2[j]<arr3[k]) 
				j++;
			else if(arr3[k]<arr1[i] && arr3[k]>arr2[j]) 
				k++;
			else {
				int temp_i = i;
				int temp_j = j;
				int temp_k = k;
				boolean arr12 = false;
				boolean arr23 = false;
				if(arr1[temp_i]==arr2[temp_j] || arr1[temp_i]==arr3[temp_k]) {
					arr12 = true;
					i++;
				}
				if(arr2[temp_j]==arr3[temp_k] || arr2[temp_j]==arr1[temp_i]) {
					arr23=true;
					j++;
				}
				if(arr3[temp_k]==arr2[temp_j] || arr3[temp_k]==arr1[temp_i])
					k++;
				if(arr12) 
					System.out.println(arr1[temp_i]);
				else 
					System.out.println(arr2[temp_j]);
			}
		}
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]==arr2[j]) {
				System.out.println(arr1[i]);
				i++;j++;
			}
			else if(arr1[i]<arr2[j])
				i++;
			else
				j++;
		}
		
		while(i<arr1.length && k<arr3.length) {
			if(arr1[i]==arr3[k]) {
				System.out.println(arr1[i]);
				i++;k++;
			}
			else if(arr1[i]<arr3[k])
				i++;
			else
				k++;
		}
		
		while(k<arr3.length && j<arr2.length) {
			if(arr3[k]==arr2[j]) {
				System.out.println(arr3[k]);
				k++;j++;
			}
			else if(arr3[k]<arr2[j])
				k++;
			else
				j++;
		}
		
	}
	
	public void isSame(int[] arr1,int[] arr2, int[] arr3) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr1.length;i++) {
			map.put(arr1[i], map.containsKey(arr1[i])?map.get(arr1[i])+1:1);
		}
		for(int i=0;i<arr2.length;i++) {
			map.put(arr2[i], map.containsKey(arr2[i])?map.get(arr2[i])-1:1);
			if(map.containsKey(arr2[i]) && map.get(arr2[i])==0) {
				System.out.println(arr2[i]);
				map.remove(arr2[i]);
			}
		}
		for(int i=0;i<arr3.length;i++) {
			map.put(arr3[i], map.containsKey(arr3[i])?map.get(arr3[i])-1:1);
			if(map.containsKey(arr3[i]) && map.get(arr3[i])==0) {
				System.out.println(arr3[i]);
				map.remove(arr3[i]);
			}
		}		
	}
	
	public void getTopNWords(int n) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\IBM_ADMIN\\Desktop\\TODO.txt")));
		Scanner s = new Scanner(br);
		Map<String,Integer> map = new HashMap<String,Integer>();
		while(s.hasNext()) {
			Pattern p = Pattern.compile("\\w+");
			String line  = s.nextLine();
			Matcher m = p.matcher(line);
			while(m.find()) {
				String word= line.substring(m.start(), m.end()).toLowerCase();
				map.put(word, map.containsKey(word)? map.get(word)+1: 1);
			}
		}
		
		List<Node_List> list = new ArrayList<Node_List>();
		for(Entry<String, Integer> entry: map.entrySet()) {
			list.add(new Node_List(entry.getKey(),entry.getValue()));
		}
		
		Collections.sort(list, new Comparator<Node_List>() {

			@Override
			public int compare(Node_List arg0, Node_List arg1) {
				// TODO Auto-generated method stub
				if(arg0.count>arg1.count)
					return -1;
				else if(arg0.count<arg1.count)
					return 1;
				else
					return 0;
			}
			
		});
		Iterator<Node_List> it = list.iterator();
		while(it.hasNext()) {
			Node_List node = it.next();
			System.out.println(node.word+" "+node.count);
		}
	/*	for(int i=0;i<n;i++) {
			if(it.hasNext()==false)
				return;
			System.out.println(it.next().word+" "+it.next().count);
			
		}
		*/
 	}
	
	public void convertBaseAB(String num, int A, int B) {
		if(num==null) return;
		int numTotal = 0;
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		map.put('A', 10);
		map.put('B', 11);
		map.put('C', 12);
		map.put('D', 13);
		map.put('E', 14);
		map.put('F', 15);
		Map<Integer,Character> map2 = new HashMap<Integer,Character>();
		map2.put(10,'A');
		map2.put(11, 'B');
		map2.put(12, 'C');
		map2.put(13,'D');
		map2.put(14, 'E');
		map2.put(15,'F');
		for(int i=0;i<num.length();i++) {
			int val;
			if(isNumeric(num.charAt(i))) {
				val = Character.getNumericValue(num.charAt(i));
			}
			else {
				val = map.get(num.toUpperCase().charAt(i));
			}
			numTotal = numTotal*A+val;
		}
	//	System.out.println(numTotal);
		StringBuilder sb = new StringBuilder("");
		while(numTotal>0) {
			int val = numTotal%B;
			if(val>=10) 
				sb.append(map2.get(val));
			else
				sb.append(val);
			numTotal = numTotal/B;
		}
		System.out.println(sb.toString());
 	}
	
	private boolean isNumeric(char c) {
	//	System.out.println((int)c);
		if(((int)c)>=48 &&((int) c)<=57)
			return true;
		return false;
	}
	
	
	private void getConIncSeq(int[] arr) {
		List<List<Integer>> outerList = new LinkedList<List<Integer>>();
		List<Integer> innerList = new LinkedList<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(innerList.size()==0 || innerList.get(innerList.size()-1)<=arr[i])
				innerList.add(arr[i]);
			else {
				outerList.add(innerList);
				innerList = new LinkedList<>();
				innerList.add(arr[i]);
			}
		}
		if(innerList.size()>0) 
			outerList.add(innerList);
		Iterator<List<Integer>> iterator = outerList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public void longestWord(String filePath, char[] arr) throws FileNotFoundException {
		if(filePath==null || filePath.length()==0) return;
		Scanner s = new Scanner(new BufferedReader((new FileReader(filePath))));
		int maxLength = 0;
		String longest = "";
		while(s.hasNext()) {
			String word = s.nextLine();
			int i=0;
			for(i=0;i<arr.length;i++) {
				if(word.indexOf(arr[i])<0)break;
			}
			if(i==arr.length && word.length()>maxLength) {
				maxLength = word.length();
				longest = word;
			}
		}
		System.out.println("Longest word is "+longest+" and its length is "+maxLength);
	}
}

class Node_List {
	public String word="";
	public int count = 0;
	public Node_List(String word, int count) {
		this.word = word;
		this.count  = count;
	}
	
}
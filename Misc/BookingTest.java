import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class BookingTest {

	public List<List<Integer>> nondecreasing_subsequences(int[] input) {
		int i=0;
		// create a list of list to store the sequences
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		// iterate over the list.
		while(i<input.length) {
			List<Integer> list = new LinkedList<Integer>();
			// add the element to list and then check if the next elements is greater than or equal to
			// this element, if greater, add the next element to same list. do this until the condition becomes
			// false. then add the list to list of list and do the same for other elements.
			list.add(input[i++]);
			while(i<input.length && input[i-1]<=input[i]) {
				list.add(input[i++]);
			}
			lists.add(list);
		}
		// return the list of list
		return lists;
	}
	
	
	public List<List<String>> all_anagram_groups(String[] words) {
		// main logic here is that, the strings which are anagrams have same sorted order
		// so sort each string, remove and whitespaces and store the string is map, with key as sorted value and
		// value as original string. by doing, this all anagrams are stored under the same key. then iterate over the 
		// map and print them. 
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for(int i=0;i<words.length;i++) {
			char[] word = words[i].toCharArray();
			Arrays.sort(word);
			String sorted_word = new String(word);
			sorted_word = sorted_word.trim();
			if(map.containsKey(sorted_word)) {
				List<String> group = map.get(sorted_word);
				group.add(words[i]);
				map.put(sorted_word, group);
			}
			else {
				List<String> group = new LinkedList<String>();
				group.add(words[i]);
				map.put(sorted_word, group);
			}
		}
		List<List<String>> lists = new LinkedList<List<String>>();
		for(Entry<String,List<String>> entry:map.entrySet()) {
			lists.add(entry.getValue());
		}
		return lists;
	}
	
	public List<String> sort_numerically(String[] words) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		// store all the numbers which are not formed by combining other numbers
		// example: 19, it cannot be formed by combining any numbers
		// example: 25, it can be formed using twenty and five. so dont store it.
		map.put("one", 1); 
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		map.put("ten",10);
		map.put("eleven", 11);
		map.put("twelve", 12);
		map.put("thirteen", 13);
		map.put("fourteen", 14);
		map.put("fifteen", 15);
		map.put("sixteen", 16);
		map.put("seventeen", 17);
		map.put("eighteen", 18);
		map.put("nineteen",19);
		map.put("twenty", 20); 
		map.put("thirty", 30);
		map.put("forty", 40);
		map.put("fifty", 50);
		map.put("sixty", 60);
		map.put("seventy", 70);
		map.put("eighty", 80);
		map.put("ninty", 90);
		Map<String,Integer> mapHun = new HashMap<String,Integer>();
		mapHun.put("hundred", 100);
		Map<String,Integer> mapMax = new HashMap<String, Integer>();
		mapMax.put("thousand", 1000);
		mapMax.put("million", 1000000);
		// now convert the numbers which are represented in words into numbers using the above maps, The map stores
		// the values in decreasing order. The key in the map is the integer value and the value is the english word of the number
		// assumptions: the english word representation of numbers doesn't contain any punctuation marks and "and" word. 
		Map<Integer,String> sorted_map = new TreeMap<Integer,String>(Collections.reverseOrder());
		for(int i=0;i<words.length;i++) {
			// divide the english representation of numbers based on spaces.
			String[] word = words[i].split("\\s+");
			int total_sum = 0;
			int inter_sum = 0;
			for(int j=0;j<word.length;j++) {
				// add the numbers which are present in map to the intermediate sum
				if(map.containsKey(word[j])) {
					int val = map.get(word[j]);
					inter_sum += val;
				}
				// if the word is hundred, then multiply it 
				else if(mapHun.containsKey(word[j])) {
					int val = mapHun.get(word[j]);
					inter_sum = inter_sum * val;
				}
				// if the word is thousand or million, just mul to intermediate sum and add total to total sum.
				// set intermediate to zero, this will make sure that all the hundreds(if value is thousand) or thousands and hundreds(if value is million)
				// on the right are handled properly.
				// if the number is greater than millions, that ie billions and trillions, just add this values to the mapMax, it will take care.
				else if(mapMax.containsKey(word[j])){
					int val = mapMax.get(word[j]);
					total_sum += (inter_sum*val);
					inter_sum = 0;
				}
			}
			// put the integer representation and string representation of number is map.
			sorted_map.put(total_sum+inter_sum, words[i]);
		}
		// add the result to the a list and return the list
		List<String> result = new LinkedList<String>();
		for(Entry<Integer,String> entry: sorted_map.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}
	
	// BFS to find the distance between two pages, 
	// assumptions: url is taken in the form of string for simplicity. 
	// assumptions: unique urls. however even if we come across the same url again, we can deal with scenario using a visited array.
	public int get_hops_from(String page1, String page2) {
		// queue for keeping track of nodes
		Queue<String> queue = new LinkedList<String>();
		// keeps track of distance between the source and destination
		int distance = 0;
		// keeps track of nodes at each level in the graph
		int nodeCount = 0;
		// check if page1 is same as page2 
		if(page1.equals(page2)) {
			return distance;
		}
		queue.add(page1);
		while(true) {
			// if destination page not found, then return integer max value
			if(queue.isEmpty()) {
				return Integer.MAX_VALUE;
			}
			// get count of pages at this level
			nodeCount = queue.size();
			// increase the distance, as we are moving to the next level.
			distance++;
			// loop while all the pages at a level are checked and and its children are added to the queue
			while(nodeCount>0) {
				page1 = queue.remove();
				List<String> pages = get_links(page1);
				for(String page:pages) {
					if(page.equals(page2))
						return distance;
					queue.add(page);
				}
				// for each page traversed in a level, decrease the nodeCount 
				nodeCount--;
			}
		}
	}
	
	public List<String> get_links(String page) {
		return new ArrayList<String>();
	}
	
	public static void main(String args[]) {
		BookingTest b = new BookingTest();
	//	int[] arr =  {3,6,61,6,7,9,1,7,7,2,7,7,2,388,3,72,7};
	//	System.out.println(b.nondecreasing_subsequences(arr));
	//	String[] list = {"pear","dirty room","amleth","reap","tinsel","tesla","hamlet","dormitory","listen","silent"};
	//	System.out.println(b.all_anagram_groups(list));
		String[] words = { "seventy five",                                                                                                     
			    "two hundred forty one",                                                                                           
			    "three thousand",                                                                                          
			    "one million thirty five thousand twelve",
			    "twenty", 
			    "five hundred thousand",
			    "two hundred" };
	//	System.out.println(b.sort_numerically(words));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner s = new Scanner(br);
		
		while(true) {
			int val = s.nextInt();
			System.out.println(val);
		}
	}
	
	
	
}

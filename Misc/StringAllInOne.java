import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class StringAllInOne {

	public void maxRepeatChar(String text) {
		if(text==null || text.length()==0)
			 return;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<text.length();i++) {
			if(map.containsKey(text.charAt(i))) {
				int val = map.get(text.charAt(i));
				map.put(text.charAt(i), val+1);
			}
			else
				map.put(text.charAt(i), 1);
		}
		
		int max = 0;
		char maxVal =0;
		Iterator<Character> i = map.keySet().iterator();
		while(i.hasNext()) {
			char key = i.next();
			if(map.get(key)>max) {
				max = map.get(key);
				maxVal = key;
			}
		}
		
		System.out.println("Maximum value is "+maxVal+" and it is repeated "+max);
	}
	
	/*
	 * Permutations of a string
	 * start = start location of the string
	 * end = length of the string
	 * 
	 * Example: text = "ABC"
	 * start = 0
	 * end = 3
	 */
	public void printPermutations(StringBuilder text, int start, int end) {
		if(start==end) {
			System.out.println(text.toString());
			return;
		}
		for(int i=start;i<end;i++) {
			swap(text,i,start);
			printPermutations(text,start+1,end);
			swap(text,i,start);
		}
	}
	
	private void swap(StringBuilder text, int start, int end) {
		char temp = text.charAt(start);
		text.setCharAt(start, text.charAt(end));
		text.setCharAt(end, temp);
	}
	
	/*
	 * Divide a string into N equal parts
	 */
	public void nEqual(String text, int divide) {
		if(text==null || text.length()==0) return;
		int length = text.length();
		if(length%divide!=0) 
			return;
		int inc=0;
		while(inc<length) {
			inc++;
			System.out.print(text.charAt(inc-1));
			if(inc%divide==0) 
				System.out.println();
		}
	}
	
	/*
	 * Find the first non-repeating character
	 */
	public void firstNonRepeat(String text) {
		if(text==null || text.length()==0) return;
		List<Character> list = new LinkedList<Character>();
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<text.length();i++) {
			if(set.contains(text.charAt(i))) 
				continue;
			if(list.contains(text.charAt(i))) {
				set.add(text.charAt(i));
				char ch = text.charAt(i);
				int index = list.indexOf(ch);
			//	System.out.println(text.charAt(i)+" "+index);
				list.remove(index);
			}
			else {
				list.add(text.charAt(i));
			}
		}
		System.out.println("The first non repeating character is "+list.remove(0));
	}
	
	public void firstNonRepeat2(String text) {
		if(text==null || text.length()==0) return;
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		for(int i=0;i<text.length();i++) {
			if(map.containsKey(text.charAt(i))) {
				int val = map.get(text.charAt(i));
				map.put(text.charAt(i),val+1);
			}
			else {
				map.put(text.charAt(i), 1);
			}
		}
		
		for(Entry<Character, Integer> entry :map.entrySet()) {
			if(entry.getValue()==1) {
				System.out.println("The first non repeating character is "+entry.getKey());
				break;
			}
		}
	}
	
	/*
	 * Print items in the array which contains all the characters of a given word
	 */
	public void printWordsInList(String[] arr, String word) {
		Map<Character,Integer> map = fillWord(word);
		int count = word.length();
		for(int i=0;i<arr.length;i++) {
			String list = arr[i];
			int inc=0;
			for(int j=0;j<list.length();j++) {
				if(map.containsKey(list.charAt(j)) == true && map.get(list.charAt(j))>0) {
					inc++;
					int val = map.get(list.charAt(j));
					map.put(list.charAt(j), val-1);
				}
			}
			if(inc == count) {
				System.out.println(list);
			}
			
			map = fillWord(word);
		}
	}
	
	public Map<Character,Integer> fillWord(String word) {
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<word.length();i++) {
			if(map.containsKey(word.charAt(i))) {
				int val = map.get(word.charAt(i));
				map.put(word.charAt(i), val+1);
			}
			else 
				map.put(word.charAt(i),1);
		}
		return map;
	}
	
	/*
	 * Reverse words in a string
	 */
	public void reverseString(StringBuilder word) {
		if(word==null || word.length()<2)
			return;
		int word_begin = 0;
		int inc = 0;
		while(inc<=word.length()) {
			if(inc==word.length()) {
				reverse(word,word_begin,inc-1);
			}
			else if(word.charAt(inc)==' ') {
				reverse(word,word_begin,inc-1);
				word_begin = inc+1;
			}
			inc++;
		}
		reverse(word,0,word.length()-1);
		System.out.println(word);
	}
	
	private void reverse(StringBuilder word, int start, int end) {
		while(start<end) {
			char temp = word.charAt(start);
			word.setCharAt(start, word.charAt(end));
			word.setCharAt(end,temp);
			start++;
			end--;
		}
	}
	
	/*
	 * Efficient method for string reverse
	 */
	public void reverseString2(StringBuilder word) {
		if(word==null || word.length()<2)
			return;
		int length = word.length();
		int position = 0;
		int word_begin=0;
		while(position<length) {
			if(word_begin==0 && word.charAt(position)!=' ')
				word_begin = position;
			if(word_begin>0 && (position+1<length && word.charAt(position+1)==' ') || (position+1==length)) {
				reverse(word,word_begin,position);
				word_begin = 0;
			}
			position++;
		}
		reverse(word,0,word.length()-1);
		System.out.println(word.toString());
	}
	
	
	/*
	 * Find smallest window in a string which contains all the characters in the string 
	 */
	public void checkWindow(String text1, String text2) {
		if(text1==null || text1.length()==0 || text1.length()<text2.length())
			return;
		Map<Character,Integer> map = fillWord(text2);
		
	}
	
	public void findPattern(String text, String pat) {
		if(text.length()==0 || pat.length()==0 || text.length()<pat.length())
			 return;
		int N = text.length();
		int M = pat.length();
		for(int i=0;i<=(N-M);i++) {
			int j=0;
			for(j=0;j<M;j++) {
				if(text.charAt(i+j)!=pat.charAt(j)) {
					break;
				}
			}
			if(j==M) 
				System.out.println("The pattern is found at "+i+"th place in the string");
		}
	}
	
	/*
	 * KMP pattern matching algorithm
	 */
	public void kmp(String txt, String pat) {
		if(txt.length()==0 || pat.length()==0 || txt.length()<pat.length())
			return;
		int[] lps = computeArray(pat);
		System.out.println(Arrays.toString(lps));
		int i=0;int j=0;
		while(i<txt.length()) {
			if(txt.charAt(i)==pat.charAt(j)) {
				i++;
				j++;
			}
			if(j==pat.length()) {
				System.out.println("Pattern found at "+(i-j)+" and "+(i-1));
				j=lps[j-1];
			}
			else if(i<txt.length() && pat.charAt(j)!=txt.charAt(i)) {
				if(j!=0) 
					j = lps[j-1];
				else
					i = i+1;
			}
		}
	}
	
	private int[] computeArray(String pat) {
		int[] lps = new int[pat.length()];
		lps[0] = 0;
		int len = 0;
		int i=1;
		while(i<pat.length()) {
			if(pat.charAt(i)==pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if(len!=0) {
					len = lps[len-1];
				}
				else { 
					lps[i]=0;
					i++;
				}
			}
		}
		return lps;
	}
	
	public void longestNonRepeatSubString(String txt){
		if(txt.length()==0) return;
		int[] visited = new int[256];
		for(int i=0;i<visited.length;i++) 
			visited[i] = -1;
		int cur_len = 1;
		int max_len = 1;
		int start = 0;
		int prev_index = -1;
		visited[0] = 0;
		for(int i=1;i<txt.length();i++) {
			prev_index = visited[txt.charAt(i)];
			if(prev_index==-1 || i-cur_len>prev_index)
				cur_len++;
			else {
				if(cur_len>max_len){
					start = prev_index;
					max_len = cur_len;
				}
				cur_len = i-prev_index;
			}
			visited[txt.charAt(i)]=i;
		}
		if(cur_len>max_len)
			max_len = cur_len;
		System.out.println("Max length non repeating substring is"+max_len);
		System.out.println("The string is "+txt.substring(start,start+max_len));
	}

	/*
	 * Print Permutations in sorted order
	 */
	public void printPerSorted(String txt, int start,String result) {
		if(result.length()==txt.length()) {
			System.out.println(result+" ");
			return;
		}
		for(int i=start;i<txt.length();i++) {
			printPerSorted(txt,start,result+txt.charAt(i));
		}
	}
	
	private void printInterLeavings(String txt, String txt2) {
		printIntLeavUtils(txt,txt2,0,0,"");
	}
	
	private void printIntLeavUtils(String txt, String txt2, int m, int n, String res) {
		if(m== txt.length() && n==txt2.length()) {
			System.out.println(res);
			return;
		}
		if(m!=txt.length()) {
			printIntLeavUtils(txt,txt2,m+1,n,res+txt.charAt(m));
		}
		if(n!=txt2.length()) {
			res = res+txt2.charAt(n++);
			printIntLeavUtils(txt,txt2,m,n,res);
		}
	}
	
	/*
	 * Check if a string is a interleaving of two other strings
	 */
	public boolean checkInterStrings(String txt, String txt2,String result) {
		if(result.length()!=txt.length()+txt2.length())
			return false;
		int i=0;
		int j=0;
		int k = 0;
		while(k<result.length()) {
			if(i<txt.length() && result.charAt(k)==txt.charAt(i)) 
				i++;
			else if(j<txt2.length() && result.charAt(k)==txt2.charAt(j))
				j++;
			else 
				return false;
			k++;
		}
		return true;
	}
	
	/*
	 * Palindrome partitioning 
	 */
	public int palindromePart(String txt) {
		if(txt.length()==0 || isPalindrome(txt)) 
			return 0;
		int n = txt.length();
		int[][] count = new int[n][n];
		boolean[][] pal = new boolean[n][n];
		for(int i=0;i<n;i++) {
			count[i][i] = 0;
			pal[i][i] = true;
		}
		int L=2;
		for(L=2;L<=n;L++) {
			for(int i=0;i<=n-L;i++){
				int j= i+L-1;
				if(L==2) 
					pal[i][j] = txt.charAt(i)==txt.charAt(j);
				else
					pal[i][j] = txt.charAt(i)==txt.charAt(j) && pal[i+1][j-1];
				if(pal[i][j]==true)
					count[i][j]=0;
				else {
					count[i][j] = Integer.MAX_VALUE;
					for(int k=i;k<j;k++) {
						count[i][j]  = Math.min(count[i][j], count[i][k]+count[k+1][j]+1);
					}
				}
			}
		}
		return count[0][n-1];
	}
	
	private boolean isPalindrome(String txt) {
		int left = 0;
		int right = txt.length()-1;
		while(left<right) {
			if(txt.charAt(left)!=txt.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

	public int palindromePart2(String txt) {
		if(txt.length()==0 || isPalindrome(txt)) 
			return 0;
		int n = txt.length();
		int[] count = new int[n];
		boolean[][] pal = new boolean[n][n];
		for(int i=0;i<n;i++) {
			count[i] = Integer.MAX_VALUE;
			pal[i][i] = true;
		}
		int L=2;
		for(L=2;L<=n;L++) {
			for(int i=0;i<=n-L;i++){
				int j= i+L-1;
				if(L==2) 
					pal[i][j] = txt.charAt(i)==txt.charAt(j);
				else
					pal[i][j] = txt.charAt(i)==txt.charAt(j) && pal[i+1][j-1];
				}
		}
		for(int i=0;i<n;i++) {
			if(pal[0][i]==true)
				count[i]=0;
			else {
				for(int j=0;j<i;j++) {
					if(pal[j+1][i]==true && 1+count[j]<count[i])
						count[i] = 1+count[j];
				}
			}
		}
		return count[n-1];
	}
	
	/*
	 * Lexographic Rank of a string 
	 */
	public void lexoRank(String txt) {
		int len = txt.length();
		int mul = fact(len);
		int rank= 0;
		for(int i=0;i<len;i++) {
			mul = mul/(len-i);
			int rightSmall = findSmallerRight(txt,i,len);
			rank = rank + (rightSmall*mul);
		}
		System.out.println(rank+1);
	}
	
	private int findSmallerRight(String txt, int start, int end) {
		int count = 0; 
		for(int i=start+1;i<end;i++) {
			if(txt.charAt(i)<txt.charAt(start))
				count++;
		}
		return count;
	}
	
	private int fact(int len) {
		if(len==0) return 1;
		return len*fact(len-1);
	}
	
	public void lexoRank2(String txt) {
		int len = txt.length();
		int mul = fact(len);
		int[] count = new int[256];
		fillCounts(txt,count);
		int rank = 0;
		for(int i=0;i<len;i++) {
			mul /= len-i;
			rank = rank + count[txt.charAt(i)-1]*mul;
			updateCount(txt.charAt(i),count);
		}
		System.out.println(rank+1);
	}
	private void updateCount(int start, int[] count) {
		for(int i=start;i<256;i++) 
			count[i]--;
	}
	
	private void fillCounts(String txt, int[] count) {
		for(int i=0;i<txt.length();i++) 
			count[txt.charAt(i)]++;
		for(int i=1;i<256;i++) {
			count[i] += count[i-1];
		}
	}
	
	public void sortDesc(String text) {
		Character[] arr = new Character[text.length()];
		for(int i=0;i<arr.length;i++) 
			arr[i] = text.charAt(i);
		Arrays.sort(arr, new Comparator<Character>() {
			@Override
			public int compare(Character paramT1, Character paramT2) {
				// TODO Auto-generated method stub
				if(paramT1>paramT2) return -1;
				else if(paramT1<paramT2) return 1;
				else return 0;
			
			}
			
		});
		
		System.out.println(Arrays.toString(arr));
	}
	
	
	/*
	 * Longest Palindrome Substring
	 */
	public void longestPal(String txt) {
		if(txt.length()==0) return;
		int n = txt.length();
		boolean[][] pal = new boolean[n][n];
		for(int i=0;i<n;i++) {
			pal[i][i] = true;
		}
		int maxLength = 1;
		int startIndex = 0;
		for(int i=0;i<n-1;i++) {
			int j = i+1;
			if(txt.charAt(i)==txt.charAt(j)) {
				pal[i][j]=true;
				maxLength = 2;
				startIndex = i;
			}
		}
		for(int k=3;k<=n;k++) {
			for(int i=0;i<=n-k;i++) {
				int j = i+k-1;
				
				if(pal[i+1][j-1]==true && txt.charAt(i)==txt.charAt(j)) {
					pal[i][j] = true;
					if(k>maxLength) {
						maxLength = k;
						startIndex = i;
					}
						
				}
			}
		}
		System.out.println("The longest palindromic substring is "+txt.substring(startIndex, startIndex+maxLength)+" and length is "+maxLength);
	}
	
	/*
	 * String Transformation
	 */
	public void stringTrans(StringBuilder txt) {
		if(txt.length()==0) return;
		int shift = 0;
		int lengthRemaining = txt.length();
		int lenFirst = 0;
		while(lengthRemaining>0) {
			int k=0;
			while(Math.pow(3, k)+1<=lengthRemaining) 
				k++;
			lenFirst = (int)Math.pow(3,k-1)+1;
			lengthRemaining -= lenFirst;
			cycleIterate(txt,shift,lenFirst);
			reverse(txt,shift/2,shift-1);
			reverse(txt,shift,shift+(lenFirst/2)-1);
			reverse(txt,shift/2,shift+(lenFirst/2)-1);
			shift +=lenFirst;
		}
		System.out.println(txt.toString());
	}
	
	private void cycleIterate(StringBuilder txt, int start, int len) {
		for(int i=1;i<len;i=i*3) {
			int j=i;
			int item = j+start;
			do {
				if(j%2!=0) 
					j= len/2 + j/2;
				else 
					j = j/2;
				swap(txt,item,j+start);
			}while(j!=i);
		}
	}
	
	
	/*
	 * Longest Palindromic substring
	 */
	public void longestPal2(String txt) {
		int maxLength = 1;
		int start = 0;
		for(int i=1;i<txt.length();i++) {
			int low = i-1;
			int high = i;
			while(low>=0 && high <txt.length() && txt.charAt(low)==txt.charAt(high)) {
				if(high-low+1>maxLength) {
					maxLength = high-low+1;
					start = low;
				}
				low--;
				high++;
			}
			low = i-1;
			high = i+1;
			while(low>=0 && high < txt.length() && txt.charAt(low)==txt.charAt(high)) {
				if(high-low+1>maxLength) {
					maxLength = high-low+1;
					start = low;
				}
				low--;
				high++;
			}
		}
		
		System.out.println("THe max palindrome substring is "+txt.substring(start, start+maxLength)+" and length is "+maxLength);
	}
	
	/*
	 * Count number of words in a string
	 */
	public void countString(String txt) {
		boolean state = false;
		int wc = 0;
		int i=0;
		while(i<txt.length()) {
			if(txt.charAt(i)==' ' || txt.charAt(i)=='\t' || txt.charAt(i)=='\n') 
				state = false;
			else if(state == false) {
				state = true;
				wc++;
			}
			i++;
		}
		System.out.println(wc);
	}
	
	public void longestSubString(String txt1, String txt2) {
		int[][] dp = new int[txt1.length()+1][txt2.length()+1];
		int maxLength = 0;
		int startIndexI=-1;
		int startIndexJ=-1;
		for(int i=0;i<=txt1.length();i++) {
			for(int j=0;j<=txt2.length();j++) {
				if(i==0 || j==0) 
					dp[i][j] = 0;
				else if(txt1.charAt(i-1)==txt2.charAt(j-1)) { 
					dp[i][j] = 1+dp[i-1][j-1];
					if(maxLength<dp[i][j]) {
						maxLength = dp[i][j];
						startIndexI = i;
						startIndexJ = j;
					}
				}
				else 
					dp[i][j] = 0;
			}
		}
		System.out.println(maxLength+" and the substring is "+txt1.substring(startIndexI-maxLength,startIndexI));
	}
	
	
	public void removeBAC(String input) {
		boolean state = false;
		StringBuilder output = new StringBuilder("");
		for(int i=0;i<input.length();i++) {
			if(state==false && input.charAt(i)!='b' && input.charAt(i)!='a') {
				output.append(input.charAt(i));
			}
			if(state==true && input.charAt(i)!='c') {
				output.append('a');
				if(input.charAt(i)!='a' && input.charAt(i)!='b') {
					output.append(input.charAt(i));
				}
			}
			int j = output.length();
			if(j>1 && output.charAt(j-2)=='a' && output.charAt(j-1)=='c')
				output = new StringBuilder(output.substring(0, j-2));
			state = input.charAt(i)=='a' ? true : false;
		}
		if(state==true) 
			output.append('a');
		System.out.println(output.toString());
	}
	
	/*
	 * Interleaving Strings
	 */
	public boolean interLeavings(String a, String b, String c) {
		int M = a.length();
		int N = b.length();
		if((M+N)!=c.length())
			return false;
		boolean[][] dp = new boolean[M+1][N+1];
		for(int i=0;i<=a.length();i++) {
			for(int j=0;j<=b.length();j++) {
				if(i==0 && j==0)
					dp[i][j] = true;
				else if(i==0 && b.charAt(j-1)==c.charAt(j-1)) {
					dp[i][j] = dp[i][j-1];
				}
				else if(j==0 && a.charAt(i-1)==c.charAt(i-1) ) {
					dp[i][j] = dp[i-1][j];
				}
				else if(a.charAt(i-1)==c.charAt(i+j-1) && b.charAt(j-1)!=c.charAt(i+j-1)) {
					dp[i][j] = dp[i-1][j];
				}
				else if(b.charAt(j-1)==c.charAt(i+j-1) && a.charAt(i-1)==c.charAt(i+j-1)) {
					dp[i][j] = dp[i][j-1];
				}
				else if(a.charAt(i-1)==c.charAt(i+j-1) && b.charAt(j-1)==c.charAt(i+j-1)) {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		return dp[M][N];
	}
	
	/*
	 * First Non repeating character in a stream in characters
	 */
	public void nonRepeatStream() {
		
		boolean isRepeated[] = new boolean[256];
		DLLCharLL ll = new DLLCharLL();
		DLLChar[] pointer = new DLLChar[256];
		
		char[] stream = {'g','e','e','k','s','f','o','r','g','e','e','k','s','a','n','d','g','e','e','k','s','q','u','i','z','k','f','o','r'};
		for(int i=0;i<stream.length;i++) {
			if(isRepeated[stream[i]-'a']==true)
				continue;
			if(pointer[stream[i]-'a']!=null) {
				ll.delete(pointer[stream[i]-'a']);
				pointer[stream[i]-'a']= null;
				isRepeated[stream[i]-'a']=true;
			}
			else {
				DLLChar newNode = new DLLChar(stream[i]);
				pointer[stream[i]-'a'] = newNode;
				ll.add(newNode);
			}
			if(!ll.isEmpty()) {
				System.out.println(ll.peek().data);
			}
		}
	}
	
	/*
	 * Recursively remove all adjacent duplicates 
	 */
	public StringBuilder removeAdjDups(StringBuilder sb, Prev_Char ch) {
		if(sb.length()<2) return sb;
		if(sb.charAt(0)==sb.charAt(1)) {
			ch.prev = sb.charAt(0);
			while(sb.length()>1 && sb.charAt(0)==sb.charAt(1)) {
				sb.deleteCharAt(0);
			}
			sb.deleteCharAt(0);
			return removeAdjDups(sb,ch);
		}
		StringBuilder rem = removeAdjDups(new StringBuilder(sb.substring(1, sb.length())),ch);
		if(rem.length()>0 && rem.charAt(0)==sb.charAt(0)) {
			ch.prev = rem.charAt(0);
			rem.deleteCharAt(0);
			return rem;
		}
		if(rem.length()==0 && ch.prev == sb.charAt(0)) {
			return rem;
		}
		rem.insert(0, sb.charAt(0));
		return rem;
	}
	
	/*
	 * Longest Common Subsequence
	 */
	public void longestSubSeq(String a, String b) {
		int M = a.length()+1;
		int N = b.length()+1;
		int[][] dp = new int[M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(i==0 || j==0) 
					dp[i][j]=0;
				else if(a.charAt(i-1)==b.charAt(j-1)) 
					dp[i][j] = 1+ dp[i-1][j-1];
				else 
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.println(dp[M-1][N-1]);
		char[] lcs = new char[dp[M-1][N-1]];
		int i=M-1,j=N-1;
		int index = dp[M-1][N-1]-1;
		while(i>0 && j>0) {
			if(a.charAt(i-1)==b.charAt(j-1)) {
				lcs[index] = a.charAt(i-1);
				i--;j--;index--;
			}
			else if(dp[i-1][j]>dp[i][j-1]){
				i--;
			}
			else 
				j--;
		}
		System.out.println(Arrays.toString(lcs));
	}
	
	
	public static void main(String args[]) {
		StringAllInOne strings  = new StringAllInOne();
		StringBuilder text2 = new StringBuilder("i like this program very much");
	//	strings.maxRepeatChar(text);
		StringBuilder text = new StringBuilder("a1b2c3d4e5f6g7");
	//	strings.printPermutations(text, 0, text.length());
		
	//	strings.nEqual(text, 4);
	//	strings.firstNonRepeat2("GeeksforGeeks");
		String[] arr = {"geeksforgeeks", "unsorted", "sunday", "just", "sss" };
	//	strings.printWordsInList(arr, "sun");
	//	strings.reverseString2(text2);
		String txt = "bbbbd";
		String pat = "ABABCABAB";
		String txt2 = "AEDFHR";
		String txt1 = "ABCDGH";
	//	strings.findPattern(txt, pat);
	//	strings.kmp(txt, pat);
	//	strings.longestNonRepeatSubString(txt);
	//	strings.printPerSorted(txt, 0, "");
	//	strings.printInterLeavings(txt, txt2);
	//	System.out.println(strings.checkInterStrings(txt, txt2, result));
	//	System.out.println(strings.palindromePart(txt2));
	//	System.out.println(strings.palindromePart2(txt2));
	//	strings.lexoRank(txt2);
	//	strings.lexoRank2(txt2);
	//	strings.sortDesc("BCDA");
	//	strings.longestPal(txt2);
	//	strings.stringTrans(text);
	//	strings.longestPal2(txt2);
	//	strings.countString("One two          three\n  four\nfive  ");
	//	strings.bigNum("213333333333333333333333333333333333");
	//	strings.hashSet();
	//	strings.longestSubString(txt1, txt2);
	//	strings.removeBAC(txt1);
	//	strings.nonRepeatStream();
	//	StringBuilder sb = new StringBuilder("acbbcddc");
	//	System.out.println(strings.removeAdjDups(sb, new Prev_Char()).toString());
		strings.longestSubSeq(txt1, txt2);
	}
	
	class Node_Set {
		public String name1="";
		public String name2="";
		public Node_Set(String n, String n2) {
			name1 = n;
			name2 = n2;
		}
	}
	public void bigNum(String num) {
		boolean great = true;
		try {
			Long.parseLong(num);
		}
		catch(Exception e) {
			System.out.println(num+" can't be fitted anywhere.");
			great = false;
		}
		if(great==true) {
			Long number = Long.parseLong(num);
			System.out.println(number+" can be fitted in:");
			if(number<=Byte.MAX_VALUE && number>=Byte.MIN_VALUE) 
				System.out.println("* byte");
			if(number<=Short.MAX_VALUE && number>=Short.MIN_VALUE)
				System.out.println("* short");
			if(number<=Integer.MAX_VALUE && number>=Integer.MIN_VALUE)
				System.out.println("* int");
			if(number<=Long.MAX_VALUE && number>=Long.MIN_VALUE) 
				System.out.println("* long");
		}
	}
}

class DLLChar {
	public char data;
	public DLLChar next;
	public DLLChar prev;
	
	public DLLChar(char data) {
		this.data = data;
		next = null;
		prev = null;
	}
}

class DLLCharLL {
	private DLLChar head;
	private DLLChar tail;
	
	public DLLCharLL() {
		head = null;
		tail = null;
	}
	
	public void add(DLLChar newNode) {
		if(head==null) {
			head = newNode;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
	}
	
	public boolean delete(DLLChar node) {
		if(isEmpty()) return false;
		if(head==node) {
			head = head.next;
		}
		if(tail==node) {
			tail = tail.prev;
		}
		if(node.next!=null) {
			node.next.prev = node.prev;
		}
		if(node.prev!=null) {
			node.prev.next= node.next;
		}
		return true;
	}
	
	public DLLChar peek()  {
		return head;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
}

class Prev_Char {
	public char prev = '\0';
}
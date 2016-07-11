import java.util.HashMap;


public class PrintListItems {

	private void printList(String word, String[] list) {
		HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		for(int i=0;i<word.length();i++) {
			if(h.containsKey(word.charAt(i))) 
				h.put(word.charAt(i), h.get(word.charAt(i))+1);
			else
				h.put(word.charAt(i), 1);
		}
		
		for(int i=0;i<list.length;i++) {
			int n = list[i].length();
			int count=0;
			for(int j=0;j<n;j++) {
				if(h.containsKey(list[i].charAt(j)) && h.get(list[i].charAt(j))>0)  {
					count++;
					h.put(list[i].charAt(j), h.get(list[i].charAt(j))-1);
				}
			}
			if(count==3) {
				System.out.println(list[i]);
			}
			for(int k=0;k<word.length();k++) {
				if(h.containsKey(word.charAt(k))) 
					h.put(word.charAt(k), h.get(word.charAt(k))+1);
				else
					h.put(word.charAt(k), 1);
			}
			
		}
	}
	
	public static void main(String args[]) {
		PrintListItems p = new PrintListItems();
		String[] list = {"sunday","geeksforgeeks","unsorted","just","sss"};
		p.printList("sun", list);
	}
}

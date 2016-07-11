import java.util.HashMap;


public class WordInList {

	public void checks(String[] arr, String check)
	{
		HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		
		for(int i=0;i<check.length();i++)
		{
			if(h.containsKey(check.charAt(i))==false )
				h.put(check.charAt(i), 1);
			else
				h.put(check.charAt(i), h.get(check.charAt(i))+1);
		}
		System.out.println(h.entrySet());
		for(int i=0;i<arr.length;i++)
		{
			int count =0;
		//System.out.println(arr[i].charAt(0));
			for(int j=0;j<arr[i].length();j++)
			{
			//	System.out.println(arr[i].charAt(12));
				if(h.containsKey(arr[i].charAt(j))  && h.get(arr[i].charAt(j))!=0)
				{
					count++;
					h.put(arr[i].charAt(j), h.get(arr[i].charAt(j))-1);
				}
			}
		//	System.out.println(count);
			if(count == check.length())
				System.out.println(arr[i]+" :This string is present ");
			for(int ik=0;ik<check.length();ik++)
			{
				if(h.containsKey(check.charAt(ik))==false)
					h.put(check.charAt(ik), 1);
				else
				{
					int val = h.get(check.charAt(ik));
					h.put(check.charAt(ik), val+1);
				}
			}	
			
			}
			
			
	}
	
	public static void main(String args[])
	{
		String check = "suun";
		String[] arr ={"geeksforgeeks","utensils","sunuday","just","sss"};
		
		WordInList w = new WordInList();
		w.checks(arr, check);
	}
	
}

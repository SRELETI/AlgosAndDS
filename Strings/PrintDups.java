import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class PrintDups {

	public void print(String input)
	{
		HashMap<Character,Integer> h = new HashMap<Character,Integer>();
		
		for(int i=0;i<input.length();i++)
		{
			if(h.containsKey(input.charAt(i))==false)
				h.put(input.charAt(i), 1);
			else
			{
				h.put(input.charAt(i), h.get(input.charAt(i))+1);
			}
		}
		for(Map.Entry<Character, Integer> i:h.entrySet())
		{
			if(i.getValue()>1)
			{
				System.out.println(i.getKey()+" "+i.getValue());
			}
		}
	}
	
	public static void main(String args[])
	{
		String str = "geeksforgeeks";
		PrintDups p = new PrintDups();
		
		p.print(str);
	}
}

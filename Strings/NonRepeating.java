import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class NonRepeating {

	public void print(String s)
	{
		HashMap<Character,Integer> h = new LinkedHashMap<Character,Integer>();
		
		for(int i=0;i<s.length();i++)
		{
			if(h.containsKey(s.charAt(i))==false)
				h.put(s.charAt(i), 1);
			else
			{
				h.put(s.charAt(i), h.get(s.charAt(i))+1);
			}
		}	
	//	int element=0;
		for(Map.Entry<Character,Integer> m : h.entrySet())
		{
			if(m.getValue()==1)
			{
				System.out.print(m.getKey()+" Count is "+m.getValue());
				return;
			}
		}
			
	}
	
	public static void main(String args[])
	{
		NonRepeating n = new NonRepeating();
		String s= "geeksQuiz";
		n.print(s);
	}
	
	
}

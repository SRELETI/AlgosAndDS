
public class AnagramApp {
	public static void main(String args[])
	{
		String inp="sudeep";
		Anagram aa=new Anagram(inp);
		int size=inp.length();
		aa.doAnagram(size);
	}
}

import java.util.Arrays;


public class PermutationsRep {

	public static void main(String args[])
	{
		String s = "BCA";
		char[] ss = s.toCharArray();
		Arrays.sort(ss);
		s = new String(ss);
		int last = s.length()-1;
		int start = 0;
		PermutationsRep  p = new PermutationsRep();
	//	p.generatePer(s,ss,last,start);
		p.generate(s, "");
	}
	
	public void generatePer(String s, char[] ss, int last , int start)
	{
		int len = s.length();
		for(int i=0;i<len;i++)
		{
			ss[start]=s.charAt(i);
			if(last == start)
			{
				System.out.println(Arrays.toString(ss));
			}
			else
				generatePer(s,ss,last,start+1);
		}
	}
	
	public void generate(String s, String pre)
	{
		if(pre.length()==s.length())
			System.out.println(pre.toString());
		else
		{
			for(int i=0;i<s.length();i++)
			{
				generate(s,pre+s.charAt(i));
			}
		}
	}
	
}

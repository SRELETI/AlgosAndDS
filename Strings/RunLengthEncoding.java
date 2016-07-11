
public class RunLengthEncoding {

	public void runLength(String s)
	{
		int count=1;
		
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		
		for(int i=1;i<s.length();i++)
		{
			if(s.charAt(i)==s.charAt(i-1))
				count++;
			else
			{
				sb.append(count);
				count=1;
				sb.append(s.charAt(i));
			}
		}
		if(count!=1)
			sb.append(count);
		
		System.out.println(sb.toString());
	}
	
	public static void main(String args[])
	{
		RunLengthEncoding r = new RunLengthEncoding();
		
		String s = "wwwwaaadexxxxxx";
		
		r.runLength(s);
	}
}

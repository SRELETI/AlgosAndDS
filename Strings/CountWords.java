
public class CountWords {

	public void count(String text)
	{
		int flag = 1;
		int i=0;
		int count=0;
		while(text!=null && text.length()!=0)
		{
			if(text.charAt(i)=='\n' || text.charAt(i)==' ' || text.charAt(i)=='\t' )
				flag = 1;
			else if(flag==1)
			{
				flag = 0;
				count =count+1;
			}
			text= text.substring(1);
		}
		System.out.println(count);
	}
	
	public static void main(String args[])
	{
		String s ="one two   three\n   four\t";
		CountWords c = new CountWords();
		c.count(s);
	}
}

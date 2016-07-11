
public class LongestPalinSub {

	public void longestPal(String text)
	{
		int len = text.length();
		boolean[][] arr = new boolean[len][len];
		
		int start = 0;
		int maxLength =1;
		
		for(int i=0;i<len;i++)
			arr[i][i]=true;
		for(int i=0;i<len-1;i++)
		{
			if(text.charAt(i)==text.charAt(i+1))
			{
				arr[i][i+1]=true;
				start = i;
				maxLength=2;
			}
		}
		
		for(int k=3;k<=len;k++)
		{
			for(int i=0;i<len-k+1;i++)
			{
				int j = i+k-1;
				if(arr[i+1][j-1]==true && text.charAt(i)==text.charAt(j))
				{
					arr[i][j]=true;
					if(k>maxLength)
					{
						maxLength = k;
						start = i;
					}
				}
			}
		}
		
		System.out.println("The longest substring is "+ text.substring(start, start+maxLength));
	}
	
	public static void main(String args[])
	{
		LongestPalinSub l = new LongestPalinSub();
		String s = "forgeeksskeegfor";
		l.longestPal(s);
		
		
	}
}

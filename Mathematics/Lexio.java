import java.util.Arrays;


public class Lexio {

	public void rank(String s)
	{
		int len = s.length();
		int fact = fact(len);
		int count=0;
		int rank =1;
		for(int i=0;i<s.length();i++)
		{
			fact = fact/(len-i);
			count = countSmaller(s,i);
			rank= rank+(fact*count);
		}
		System.out.println(rank);
	}
	
	private int countSmaller(String s, int i)
	{
		int count=0;
		for(int k=i;k<s.length();k++)
		{
			if(s.charAt(i)>s.charAt(k))
				count++;
		}
	//	System.out.println(count);
		return count;
	}
	private int fact(int len)
	{
		if(len==0)
			return 1;
		return len * fact(len-1);
	}
	public static void main(String args[])
	{
		Lexio l = new Lexio();
	    l.rank("STRING");
	    l.rank2("STRING");
	}
	
	private void populate(String s,int[] countArr)
	{
		int i=0;
		while(i<s.length())
		{
			countArr[(int)s.charAt(i)]++;
			i++;
		}
	//	System.out.println(Arrays.toString(countArr));
		for(int j=1;j<countArr.length;j++)
			countArr[j]= countArr[j]+countArr[j-1];
	}
	public void rank2(String s)
	{
		int len = s.length();
		int fact  = fact(len);
		int count=0;
		int rank=1;
		int[] countArr = new int[256];
		populate(s,countArr);
	//	System.out.println(Arrays.toString(countArr));
		for(int i=0;i<s.length();i++)
		{
			fact = fact/(len-i);
			rank = rank+(countArr[(int)s.charAt(i)-1]*fact);
			updatecount(countArr,(int)s.charAt(i));
		}
		System.out.println(rank);
	}
	
	private void updatecount(int[]countArr, int i)
	{
		for(int k=i;k<countArr.length;k++)
			countArr[k]--;
	//	System.out.println(Arrays.toString(countArr));
	}
}



public class Base14 {

	public void calc(String s1, String s2)
	{
		int num1_len = s1.length();
		int num2_len = s2.length();
		
		int carry=0;
		int num1,num2,res_num;
		if(num1_len != num2_len)
		{
			if(num1_len<num2_len)
			{
				String temp="";
				for(int i=0;i<num2_len-num1_len;i++)
					temp = temp+"0";
				s1 = temp+s1;
			}
			else
			{
				String temp="";
				for(int i=0;i<num1_len-num2_len;i++)
					temp = temp+"0";
				s2 = temp+s2;
			}
		}
		System.out.println(s1+" "+s2);
		StringBuilder res = new StringBuilder();
		res.setLength(s1.length()+1);
		for(int i=num1_len-1;i>=0;i--)
		{
			num1 = getNumerical(s1,i);
			num2 = getNumerical(s2,i);
			if(num1==-1 || num2==-1)
			{
				System.out.println("Invalid");
				return;
			}
			res_num = carry+num1+num2;
			if(res_num>=14)
			{
				carry=1;
				res_num = res_num -14;
			}
			else
				carry = 0;
			char ch =getCharValue(res_num);
			res.setCharAt(i+1, ch);
		}
		if(carry==0)
			res.setCharAt(0, '0');
		else
			res.setCharAt(0, '1');
		System.out.println(res.toString());
	}
	
	private char getCharValue(int val)
	{
		if(val>=0 && val<=9)
			return (char) (val+'0');
		if(val>=10 && val<=14)
			return (char) (val+'A'-10);
		else
			return (Character) null;
	}
	private int getNumerical(String s, int pos)
	{
		if(s.charAt(pos)>='0' && s.charAt(pos)<='9')
			return s.charAt(pos)-'0';
		if(s.charAt(pos)>='A' && s.charAt(pos)<='D')
			return s.charAt(pos)-'A'+10;
		else 
			return -1;
	}
	
	public static void main(String args[])
	{
		String s1= "12A";
		String s2="D3";
		Base14 b = new Base14();
		b.calc(s1, s2);
	}
}
